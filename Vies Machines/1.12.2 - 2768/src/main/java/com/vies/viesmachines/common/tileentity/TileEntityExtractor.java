package com.vies.viesmachines.common.tileentity;

import javax.annotation.Nullable;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemGeneric;
import com.vies.viesmachines.common.items.kits.ItemKitDurability;
import com.vies.viesmachines.common.items.kits.ItemKitEnergy;
import com.vies.viesmachines.common.items.kits.ItemKitHealth;
import com.vies.viesmachines.common.items.machines.ItemMachineBase;
import com.vies.viesmachines.common.items.misc.ItemMachinePellets;
import com.vies.viesmachines.common.items.parts.ItemComponentFlying;
import com.vies.viesmachines.common.items.parts.ItemComponentGround;
import com.vies.viesmachines.common.items.parts.ItemComponentWater;
import com.vies.viesmachines.common.items.tools.ItemToolDismounting;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeComponent;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeEngine;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeFrame;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityExtractor extends TileEntity implements ITickable {
    
    public ItemStackHandler inventory;
    private int size = 64;
    
    public int processTime;
    private int processTimeTotal;
    public int itemToFindMeta;
    public int procChance;
    public int procAmount;
    public boolean isOn;
    
    private String customNameVM;
    private final String defaultNameVM = "appliance_extractor";
    
    public TileEntityExtractor() 
    {
    	this.inventory = new ItemStackHandler(size);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.inventory;
        return super.getCapability(capability, facing);
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	
    	compound.setTag("Slots", this.inventory.serializeNBT());
    	compound.setInteger("ProcessTime", this.processTime);
    	compound.setInteger("ItemToFindMeta", this.itemToFindMeta);
    	compound.setInteger("ProcChance", this.procChance);
    	compound.setBoolean("IsOn", this.isOn);
    	
    	if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customNameVM);
        }
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.inventory.deserializeNBT(compound.getCompoundTag("Slots"));

    	this.processTime = compound.getInteger("ProcessTime");
    	this.itemToFindMeta = compound.getInteger("ItemToFindMeta");
    	this.procChance = compound.getInteger("ProcChance");
    	this.isOn = compound.getBoolean("IsOn");
    	
        if (compound.hasKey("CustomName", 8))
        {
            this.customNameVM = compound.getString("CustomName");
        }
    }
    
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		super.onDataPacket(net, pkt);
		
		this.processTime = pkt.getNbtCompound().getInteger("ProcessTime");
		this.handleUpdateTag(pkt.getNbtCompound());
	}
	
	/** Get the name of this object. For players this returns their username. */
	public String getName()
    {
        return this.hasCustomName() ? this.customNameVM : this.defaultNameVM;
    }
	
	/** Returns true if this thing is named. */
    public boolean hasCustomName()
    {
        return this.customNameVM != null && !this.customNameVM.isEmpty();
    }

	@Override
	public void update() 
	{
		this.cuttingLogic();
	}
	
	/** Wrapper for all gem cutting logic. */
    private void cuttingLogic()
    {
    	boolean hasBeenCutting = cuttingSomething();
        boolean changedCuttingState = false;
        
        if(!this.world.isRemote)
        {
        	if(this.isOn)
            {
        		//If something in input slot
            	if(!this.inventory.getStackInSlot(0).isEmpty())
            	{
	        		this.processTimeTotal = getMaxCutTime(this.inventory.getStackInSlot(0));
	                this.procChance = getGemProc(this.inventory.getStackInSlot(0));
	                this.procAmount = this.getMultiProcChance(this.inventory.getStackInSlot(0));
	                
	        		//Start cutting
	                if(!cuttingSomething() && canCut())
	                {
	                     if(cuttingSomething())
	                     {
	                         changedCuttingState = true;
	                     }
	                }
	                
	                //Continue cutting
	                if(cuttingSomething() && canCut())
	                {
	                    ++this.processTime;
	                    
	                    this.syncCutTime();
	            		
	                    //Check if completed cutting a gem
	                    if(this.processTime == this.processTimeTotal)
	                    {
	                    	double procSuccessful = References.random.nextInt(100);
	                    	this.processTime = 0;
	                    	this.processTimeTotal = getMaxCutTime(this.inventory.getStackInSlot(0));
	                    	this.procAmount = this.getMultiProcChance(this.inventory.getStackInSlot(0));
	                    	
	                        if(this.procChance >= procSuccessful)
	                        {
	                        	cutShard();
	                        }
	                        else
	                        {
	                        	this.inventory.getStackInSlot(0).shrink(1);
	                        }
	                    	
	                        changedCuttingState = true;
	                    }
	                }
	                else
	                {
	                    this.processTime = 0;
	                }
            	}
        		else
        		{
        			this.processTime = 0;
        			this.procChance = 0;
        		}
        	}
        	else
        	{
        		this.processTime = 0;
        		
        		if(!this.inventory.getStackInSlot(0).isEmpty())
            	{
        			this.procChance = getGemProc(this.inventory.getStackInSlot(0));
            	}
        		else
        		{
        			this.procChance = 0;
        		}
        	}
        	
            if(!canCut()
            && this.processTime > 0)
            {
            	this.processTime = 0;
            }
            
            //Started or stopped cutting, update block to change to active or inactive model
            if(hasBeenCutting != cuttingSomething())
            {
                changedCuttingState = true;
            }
    	}
        
        if(changedCuttingState)
        {
            this.markDirty();
        }
    }
    
    /** Returns true if the appliance can cut a Shard, i.e. has a source item, destination stack isn't full, etc. */
    private boolean canCut()
    {
        if(((ItemStack)this.inventory.getStackInSlot(0)).isEmpty())
        {
            return false;
        }
        else
        {
        	ItemStack itemstack1 = (ItemStack)this.inventory.getStackInSlot(1);
        	
        	if(itemstack1.isEmpty()) return true;
        	//if(!itemstack1.isItemEqual(GemCuttingRecipes.CUT_GEM_OUTPUT[this.itemToFindMeta])) return false;
        	
            int result = itemstack1.getCount() + ExtractorRecipes.CUT_GEM_OUTPUT[this.itemToFindMeta].getCount();
            return result <= 64 && result <= itemstack1.getMaxStackSize();
        }
    }
    
    /** Logic to convert ItemStack input to a Shard. */
    public void cutShard()
    {
        if(this.canCut())
        {
        	ItemStack itemstackIn = (ItemStack)this.inventory.getStackInSlot(0);
            ItemStack itemstackOut = ExtractorRecipes.CUT_GEM_OUTPUT[this.itemToFindMeta];
            //GemCuttingRecipes.getRandomGem(GemCuttingRecipes.CUT_GEM_OUTPUT); //Returns a Random Gem from array.
            ItemStack itemstack1 = (ItemStack)this.inventory.getStackInSlot(1);
            
            
    		
    		ItemStack[] stack = new ItemStack[]
    		{
    			new ItemStack(ItemsVM.XEGONITE, 1 + this.procAmount)//,
    			//new ItemStack(ItemsVM.KIT_HEALTH_8, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_HEALTH_MAX, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_ENERGY_25, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_ENERGY_100, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_ENERGY_MAX, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_DURABILITY_50, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_DURABILITY_200, 1 + this.procAmount),
    			//new ItemStack(ItemsVM.KIT_DURABILITY_MAX, 1 + this.procAmount)
    		};
    		
    		
    		
            if(itemstack1.isEmpty())
            {
            	this.inventory.insertItem(1, stack[this.itemToFindMeta], false);
            }
            else if(itemstack1.isItemEqual(
            		//GemCuttingRecipes.CUT_GEM_OUTPUT[this.itemToFindMeta]
            		//new ItemStack(
                			//InitItemsVG.GEMSTONE_ITEM_BASIC_V1
                	//		ItemsVM.XEGONITE, 1)
            		stack[this.itemToFindMeta]
            		))
            {
            	if(itemstack1.getCount() + this.procAmount > 64)
            	{
            		int reducedAmount = 
            		References.random.nextInt((itemstack1.getCount() + this.procAmount) - 64);
            		
            		if(reducedAmount == 0)
            		{
            			reducedAmount = 1;
            		}
            		
            		itemstack1.grow(reducedAmount);
            	}
            	else
            	{
            		itemstack1.grow(1 + this.procAmount);
            	}
            }
            
    		if(itemstack1.getCount() == 65)
    		{
    			itemstack1.shrink(1);
    		}
    		
    		if(itemstack1.getCount() == 66)
    		{
    			itemstack1.shrink(2);
    		}
    		
            itemstackIn.shrink(1);
        }
    }
    
    /**
     * Gets the Max time needed to process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0) For now, just returns 200.
     * @return
     */
    public int getMaxCutTime(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	return 200;
        }
    }
    
    /**
     * Gets the Shard Proc % needed to successfully process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0).
     * @return
     */
    public int getGemProc(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	Item item = stack.getItem();
        	
            //if(item == InitItemsVG.GEMSTONE_ITEM_UNIDENTIFIED) return 500;
            
            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                
                if(block == Blocks.REDSTONE_ORE) return 25;
                if(block == Blocks.REDSTONE_BLOCK) return 80;
                if(block == Blocks.COAL_ORE) return 30;
                if(block == Blocks.COAL_BLOCK) return 90;
                if(block == Blocks.IRON_ORE) return 75;
                if(block == Blocks.IRON_BLOCK) return 225;
                if(block == Blocks.QUARTZ_ORE) return 90;
                if(block == Blocks.QUARTZ_BLOCK) return 270;
                if(block == Blocks.GOLD_ORE) return 105;
                if(block == Blocks.GOLD_BLOCK) return 315;
                if(block == Blocks.LAPIS_ORE) return 115;
                if(block == Blocks.LAPIS_BLOCK) return 350;
                if(block == Blocks.DIAMOND_ORE) return 150;
                if(block == Blocks.DIAMOND_BLOCK) return 450;
                if(block == Blocks.EMERALD_ORE) return 165;
                if(block == Blocks.EMERALD_BLOCK) return 495;
                
                if(block == Blocks.MYCELIUM) return 10;
                if(block == Blocks.COBBLESTONE) return 15;
                if(block == Blocks.LOG) return 16;
                if(block == Blocks.LOG2) return 16;
                if(block == Blocks.NETHERRACK) return 13;
                if(block == Blocks.NETHER_BRICK) return 50;
                if(block == Blocks.RED_NETHER_BRICK) return 60;
                if(block == Blocks.OBSIDIAN) return 45;
                if(block == Blocks.GLOWSTONE) return 95;
                if(block == Blocks.SEA_LANTERN) return 95;
                if(block == Blocks.PRISMARINE) return 100;
                if(block == Blocks.END_STONE) return 110;
                if(block == Blocks.END_BRICKS) return 110;
                if(block == Blocks.END_ROD) return 130;
                if(block == Blocks.PURPUR_BLOCK) return 150;
                if(block == Blocks.PURPUR_PILLAR) return 150;
                if(block == Blocks.PURPUR_STAIRS) return 150;
                if(block == Blocks.PURPUR_SLAB) return 75;
                if(block == Blocks.ENCHANTING_TABLE) return 280;
                if(block == Blocks.ENDER_CHEST) return 415;
                if(block == Blocks.BEACON) return 500;
                
                if(block.getDefaultState().getMaterial() == Material.GRASS
                || block.getDefaultState().getMaterial() == Material.PLANTS
                || block.getDefaultState().getMaterial() == Material.LEAVES
                || block.getDefaultState().getMaterial() == Material.VINE
                || block.getDefaultState().getMaterial() == Material.CACTUS
                || block.getDefaultState().getMaterial() == Material.GOURD
                || block.getDefaultState().getMaterial() == Material.CAKE
                )
                {
                    return 5;
                }
                if(block.getDefaultState().getMaterial() == Material.SNOW
                || block.getDefaultState().getMaterial() == Material.CRAFTED_SNOW
                || block.getDefaultState().getMaterial() == Material.ICE
                || block.getDefaultState().getMaterial() == Material.PACKED_ICE)
                {
                    return 8;
                }
                if(block.getDefaultState().getMaterial() == Material.GROUND
                || block.getDefaultState().getMaterial() == Material.SAND
                || block.getDefaultState().getMaterial() == Material.WEB)
                {
                    return 10;
                }
                if(block.getDefaultState().getMaterial() == Material.WOOD)
                {
                    return 13;
                }
                if(block.getDefaultState().getMaterial() == Material.CLOTH
                || block.getDefaultState().getMaterial() == Material.CARPET
                || block.getDefaultState().getMaterial() == Material.SPONGE)
                {
                    return 15;
                }
                if(block.getDefaultState().getMaterial() == Material.CLAY
                || block.getDefaultState().getMaterial() == Material.CORAL)
                {
                    return 18;
                }
                if(block.getDefaultState().getMaterial() == Material.GLASS)
                {
                    return 20;
                }
                if(block.getDefaultState().getMaterial() == Material.ROCK
                || block.getDefaultState().getMaterial() == Material.PISTON)
                {
                    return 25;
                }
                if(block.getDefaultState().getMaterial() == Material.IRON
                || block.getDefaultState().getMaterial() == Material.ANVIL
                || block.getDefaultState().getMaterial() == Material.CIRCUITS
                || block.getDefaultState().getMaterial() == Material.REDSTONE_LIGHT)
                {
                    return 40;
                }
                if(block.getDefaultState().getMaterial() == Material.TNT)
                {
                    return 50;
                }
                if(block.getDefaultState().getMaterial() == Material.DRAGON_EGG)
                {
                    return 100;
                }
                
                return 25;
            }
            
            if(item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 15;
            if(item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 15;
            if(item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 15;
            if(item instanceof ItemTool && "STONE".equals(((ItemTool)item).getToolMaterialName())) return 28;
            if(item instanceof ItemSword && "STONE".equals(((ItemSword)item).getToolMaterialName())) return 28;
            if(item instanceof ItemHoe && "STONE".equals(((ItemHoe)item).getMaterialName())) return 28;
            if(item instanceof ItemTool && "IRON".equals(((ItemTool)item).getToolMaterialName())) return 38;
            if(item instanceof ItemSword && "IRON".equals(((ItemSword)item).getToolMaterialName())) return 38;
            if(item instanceof ItemHoe && "IRON".equals(((ItemHoe)item).getMaterialName())) return 38;
            if(item instanceof ItemTool && "GOLD".equals(((ItemTool)item).getToolMaterialName())) return 58;
            if(item instanceof ItemSword && "GOLD".equals(((ItemSword)item).getToolMaterialName())) return 58;
            if(item instanceof ItemHoe && "GOLD".equals(((ItemHoe)item).getMaterialName())) return 58;
            if(item instanceof ItemTool && "DIAMOND".equals(((ItemTool)item).getToolMaterialName())) return 85;
            if(item instanceof ItemSword && "DIAMOND".equals(((ItemSword)item).getToolMaterialName())) return 85;
            if(item instanceof ItemHoe && "DIAMOND".equals(((ItemHoe)item).getMaterialName())) return 85;
            if(item instanceof ItemArmor && "leather".equals(((ItemArmor)item).getArmorMaterial().getName())) return 14;
            if(item instanceof ItemArmor && "iron".equals(((ItemArmor)item).getArmorMaterial().getName())) return 40;
            if(item instanceof ItemArmor && "gold".equals(((ItemArmor)item).getArmorMaterial().getName())) return 60;
            if(item instanceof ItemArmor && "chainmail".equals(((ItemArmor)item).getArmorMaterial().getName())) return 75;
            if(item instanceof ItemArmor && "diamond".equals(((ItemArmor)item).getArmorMaterial().getName())) return 90;
            
            if(item == Items.IRON_HORSE_ARMOR) return 40;
            if(item == Items.GOLDEN_HORSE_ARMOR) return 60;
            if(item == Items.DIAMOND_HORSE_ARMOR) return 90;
            
            if(item instanceof ItemRecord) return 90;
            
            if(item == Items.REDSTONE) return 8;
        	if(item == Items.DYE) return 10;
        	if(item == Items.COAL) return 10;
        	if(item == Items.IRON_INGOT) return 25;
        	if(item == Items.QUARTZ) return 30;
        	if(item == Items.GOLD_INGOT) return 35;
        	if(item == Items.DIAMOND) return 50;
        	if(item == Items.EMERALD) return 55;

        	if(item == Items.PRISMARINE_SHARD) return 75;
        	if(item == Items.PRISMARINE_CRYSTALS) return 90;
        	
        	if(item instanceof ItemSeeds) return 3;
        	
        	if(item == Items.GOLD_NUGGET) return 4;
        	if(item == Items.GUNPOWDER) return 10;
            if(item == Items.BLAZE_ROD) return 15;
            if(item == Items.BREWING_STAND) return 18;
            if(item == Items.GLOWSTONE_DUST) return 25;
            if(item == Items.COMPASS) return 40;
            if(item == Items.CLOCK) return 55;
            if(item == Items.ENDER_PEARL) return 30;
            if(item == Items.FIRE_CHARGE) return 40;
            if(item == Items.SHEARS) return 40;
            if(item == Items.FIREWORK_CHARGE) return 45;
            if(item == Items.CAULDRON) return 50;
            if(item == Items.ENDER_EYE) return 55;
            if(item == Items.ENCHANTED_BOOK) return 70;
            if(item == Items.GOLDEN_APPLE) return 75;
            if(item == Items.BUCKET) return 75;
            if(item == Items.GHAST_TEAR) return 80;
            if(item == Items.CHORUS_FRUIT) return 80;
            if(item == Items.CHORUS_FRUIT_POPPED) return 85;
            if(item == Items.LAVA_BUCKET) return 85;
            if(item == Items.EXPERIENCE_BOTTLE) return 100;
            if(item == Items.TOTEM_OF_UNDYING) return 300;
            if(item == Items.NETHER_STAR) return 350;
            if(item == Items.SHULKER_SHELL) return 350;
            if(item == Items.ELYTRA) return 400;
            
            if(item instanceof ItemGeneric && "GenericProc".equals(((ItemGeneric)item).getGemProcName())) return 18;
            
            if(item instanceof ItemKitHealth && "KitHealthProc_UNCOMMON".equals(((ItemKitHealth)item).getGemProcName())) return 33;
            if(item instanceof ItemKitHealth && "KitHealthProc_RARE".equals(((ItemKitHealth)item).getGemProcName())) return 66;
            if(item instanceof ItemKitHealth && "KitHealthProc_EPIC".equals(((ItemKitHealth)item).getGemProcName())) return 100;
            
            if(item instanceof ItemKitEnergy && "KitEnergyProc_UNCOMMON".equals(((ItemKitEnergy)item).getGemProcName())) return 33;
            if(item instanceof ItemKitEnergy && "KitEnergyProc_RARE".equals(((ItemKitEnergy)item).getGemProcName())) return 66;
            if(item instanceof ItemKitEnergy && "KitEnergyProc_EPIC".equals(((ItemKitEnergy)item).getGemProcName())) return 100;
            
            if(item instanceof ItemKitDurability && "KitDurabilityProc_UNCOMMON".equals(((ItemKitDurability)item).getGemProcName())) return 33;
            if(item instanceof ItemKitDurability && "KitDurabilityProc_RARE".equals(((ItemKitDurability)item).getGemProcName())) return 66;
            if(item instanceof ItemKitDurability && "KitDurabilityProc_EPIC".equals(((ItemKitDurability)item).getGemProcName())) return 100;
            
            if(item instanceof ItemMachinePellets && "AmmoProc".equals(((ItemMachinePellets)item).getGemProcName())) return 40;
            
            if(item instanceof ItemComponentGround && "ComponentGroundProc".equals(((ItemComponentGround)item).getGemProcName())) return 50;
            if(item instanceof ItemComponentWater && "ComponentWaterProc".equals(((ItemComponentWater)item).getGemProcName())) return 50;
            if(item instanceof ItemComponentFlying && "ComponentFlyingProc".equals(((ItemComponentFlying)item).getGemProcName())) return 50;
            
            if(item instanceof ItemToolDismounting && "ToolsProc".equals(((ItemToolDismounting)item).getGemProcName())) return 15;
            
            if(item instanceof ItemMachineBase && "ItemMachineProc".equals(((ItemMachineBase)item).getGemProcName())) return 500;
            
            if(item instanceof ItemUpgradeFrame && "UpgradeFrameProc".equals(((ItemUpgradeFrame)item).getGemProcName())) return 75;
            if(item instanceof ItemUpgradeEngine && "UpgradeEngineProc".equals(((ItemUpgradeEngine)item).getGemProcName())) return 75;
            if(item instanceof ItemUpgradeComponent && "UpgradeComponentProc".equals(((ItemUpgradeComponent)item).getGemProcName())) return 75;
            
            return 5;
        }
    }
    
    /**
     * Gets the Multi Proc to process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0) 
     * @return
     */
    public int getMultiProcChance(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	if(this.getGemProc(stack) >= 500)
        	{
        		return 4+References.random.nextInt(2);
        	}
        	else if(this.getGemProc(stack) >= 401)
        	{
        		return 3+References.random.nextInt(2);
        	}
        	else if(this.getGemProc(stack) >= 301)
        	{
        		return 2+References.random.nextInt(2);
        	}
        	else if(this.getGemProc(stack) >= 201)
        	{
        		return 1+References.random.nextInt(2);
        	}
        	else if(this.getGemProc(stack) >= 101)
        	{
        		return 0+References.random.nextInt(2);
        	}
        	
        	return 0;
        }
    }
    
    /** Is appliance on? */
    @SideOnly(Side.CLIENT)
    public boolean isApplianceOn()
    {
    	boolean isCutting = false;
    	
    	if(this.processTime > 0)
    	{
    		isCutting = true;
    	}
    	
    	return isCutting;
    }
    
    /** Currently cutting something! */
    public boolean cuttingSomething()
    {
        return true;
    }
    
    public void syncCutTime()
    {
    	if(this.processTime == 1
    	|| this.processTime == 20
		|| this.processTime == 40
		|| this.processTime == 60
		|| this.processTime == 80
		|| this.processTime == 100
		|| this.processTime == 120
		|| this.processTime == 140
		|| this.processTime == 160
		|| this.processTime == 180
		|| this.processTime == 200)
        {
        	this.markUpdate();
        }
    }
    
    protected void markUpdate()
    {
        world.notifyBlockUpdate(this.getPos(), this.getBlockType().getDefaultState(), this.getBlockType().getDefaultState(), 0);
    }
    
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.processTime;
            case 1:
                return this.processTimeTotal;
            case 2:
                return this.procChance;
            default:
                return 0;
        }
    }
    
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.processTime = value;
                break;
            case 1:
                this.processTimeTotal = value;
                break;
            case 2:
                this.procChance = value;
                break;
        }
    }
    
    public int getFieldCount()
    {
        return 3;
    }
}
