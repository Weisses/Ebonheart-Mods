package com.viesis.viescraft.common.entity.airshipcolors.v1;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiOpenBlack;

public class EntityAirshipBlack extends EntityAirshipCore implements IInventory {
	
	public ItemStack[] inventory;
	private String customName;
	
	public EntityAirshipBlack(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
        this.inventory = new ItemStack[this.getSizeInventory()];
    }
	
    public EntityAirshipBlack(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.inventory = new ItemStack[this.getSizeInventory()];
    }
    
	/**
     * Main entity item drop.
     */
    @Override
	public Item getItemBoat()
    {
		return InitItemsVC.item_airship_black;
    }
	
	@Override
	public void setAirshipDead()
    {
		InventoryHelper.dropInventoryItems(this.worldObj, this.getPosition(), this);
    }
	
	//==================================//
    //               Gui                //
	//==================================//
	
    //@Override
    //public void openGUI(World world, EntityPlayer player)
    //{
    	//player.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
    //}
	
	
	
    @Override
    protected void controlAirshipExtra()
    {
    	if (this.isBeingRidden())
        {
    		//LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
            if (this.openInputDown)
            		//Minecraft.getMinecraft().gameSettings.isKeyDown(Keybinds.vcInventory))
            {
            	
            	
            	//LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
            	//if( Minecraft.getMinecraft().setIngameNotInFocus()
            	///		Minecraft.getMinecraft().currentScreen == ((GuiEntityAirshipBlack)null)
            	//		Minecraft.getMinecraft().thePlayer.get
            	//	)
            	//{
            		
            	//}
            		//Minecraft.getMinecraft().currentScreen == GuiHandler.GUI_AIRSHIP_BLACK
            	
            	//PacketDispatcher.sendToServer(new OpenGuiMessage(GuiHandler.GUI_AIRSHIP_BLACK));
            	NetworkHandler.sendToServer(new MessageGuiOpenBlack());
            	//LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
            	//this.openGUI(this.worldObj, playerVC);
            	//Minecraft.getMinecraft().thePlayer.displayGui(null);
            			//Minecraft.getMinecraft().thePlayer
            	Minecraft.getMinecraft().setIngameFocus();		
            			
            			//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            	//ViesCraft.network.sendTo(new SomeMessage(), somePlayer);
            			
            	///}	
            	///else if (Minecraft.getMinecraft().currentScreen != ((GuiEntityAirshipBlack)null)
            	///		)
            	///{
            	///	NetworkHandler.sendToServer(new MessageGuiCloseBlack());
            	
            	///}
            }
        }
    }
    
    
	//==================================//
    //            Inventory             //
	//==================================//
    
    //public String getCustomName() 
    //{
	//	return this.customName;
	//}
    
	//public void setCustomName(String customName) 
	//{
	//	this.customName = customName;
	//}
    
	//@Override
	//public String getName() 
	//{
		//return this.hasCustomName() ? this.customName : "container.vc.airship.black";
	//}
	
	//@Override
	//public boolean hasCustomName() 
	//{
	//	return this.customName != null && !this.customName.equals("");
	//}
	
	//@Override
	//public ITextComponent getDisplayName() 
	//{
	//	return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	//}

	@Override
	public int getSizeInventory() 
	{
		return 9;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index <0 || index >= this.getSizeInventory())
		{
			return null;
		}
		
		return this.inventory[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		if (this.getStackInSlot(index) != null) 
		{
			ItemStack itemstack;

			if (this.getStackInSlot(index).stackSize <= count) 
			{
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			} 
			else 
			{
				itemstack = this.getStackInSlot(index).splitStack(count);

				if (this.getStackInSlot(index).stackSize <= 0) 
				{
					this.setInventorySlotContents(index, null);
				} 
				else 
				{
					//Just to show that changes happened
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}

				this.markDirty();
				return itemstack;
			}
		} 
		else 
		{
			return null;
		}
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, null);
		return stack;
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		if (index < 0 || index >= this.getSizeInventory())
		{
			return;
		}

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}

		if (stack != null && stack.stackSize == 0)
		{
			stack = null;
		}

		this.inventory[index] = stack;
		this.markDirty();
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public void markDirty() {}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return (EntityAirshipBlack)player.getRidingEntity() == this;
		//this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@Override
	public void openInventory(EntityPlayer player) 
	{
		//player.addStat( -=Achievement=-);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public int getField(int id) 
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value){}
	
	@Override
	public int getFieldCount() 
	{
		return 0;
	}
	
	@Override
	public void clear() 
	{
		for (int i = 0; i < this.getSizeInventory(); i++)
		{
			this.setInventorySlotContents(i, null);
		}
	}
	
	
	
	//==================================//
    //            Read/Write            //
	//==================================//
    
	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
    	super.writeEntityToNBT(compound);
    	
    	//compound.setShort("Fuel", (short)this.fuel);
        compound.setString("Type", this.getBoatType().getName());
        
        NBTTagList list = new NBTTagList();
		for (int i = 0; i < this.getSizeInventory(); ++i) 
		{
			if (this.getStackInSlot(i) != null) 
			{
				NBTTagCompound stackTag = new NBTTagCompound();
				stackTag.setByte("Slot", (byte) i);
				this.getStackInSlot(i).writeToNBT(stackTag);
				list.appendTag(stackTag);
			}
		}
		compound.setTag("Items", list);
        
		if (this.hasCustomName()) 
		{
			//compound.setString("CustomName", this.getCustomName());
		}
    }
    
    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
    	super.readEntityFromNBT(compound);
    	
    	//this.fuel = compound.getShort("Fuel");
        if (compound.hasKey("Type", 8))
        {
            this.setBoatType(EntityAirshipCore.Type.getTypeFromString(compound.getString("Type")));
        }
        
        NBTTagList list = compound.getTagList("Items", 10);
		for (int i = 0; i < list.tagCount(); ++i) 
		{
			NBTTagCompound stackTag = list.getCompoundTagAt(i);
			int slot = stackTag.getByte("Slot") & 255;
			this.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(stackTag));
		}

		if (compound.hasKey("CustomName", 8)) 
		{
			//this.setCustomName(compound.getString("CustomName"));
		}
    }
}
