package com.viesis.gemstones.common.items.zzzTEMP.armor;

import java.util.List;
import java.util.Random;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.zzzArk.modifier.VGAttributeModifier;
import com.viesis.gemstones.common.items.ItemHelper;
import com.viesis.gemstones.common.items.MaterialHelper;
import com.viesis.gemstones.configs.ViesisGemstonesConfig;
import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Arcanite
public class ItemBurnishedArmor extends ItemArmor {
	
	int playerPosX;
	int playerPosY;
	int playerPosZ;
	
	Random random = new Random();
	
	public ItemBurnishedArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.BURNISHED, renderIndexIn, equipmentSlotIn);
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesisGemstones.tabVGItems);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return InitItemsVG.arcanite == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GOLD + "Polished armor stacked in layers");
		toolTip.add(TextFormatting.GOLD + "for stealthy speed.");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + "Set Bonus:");
		toolTip.add(TextFormatting.GREEN + "Ability - Sprint Stealth.");
		toolTip.add(TextFormatting.GREEN + "Speed increased by 120%");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsVG.burnished_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsVG.burnished_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsVG.burnished_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsVG.burnished_boots) 
		{
			
			if(!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.BURNISHED_SPEED_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(VGAttributeModifier.BURNISHED_SPEED_BONUS);
			}
			
			if(player.isSprinting())
			{
				
				if(!player.isInvisible())
				{
					player.setInvisible(true);
				}
				
				if(!ViesisGemstonesConfig.armorParticle)
				{
					
					if(world.isRemote)
					{
						
						playerPosX = player.getPosition().getX();
						playerPosY = player.getPosition().getY();
						playerPosZ = player.getPosition().getZ();
						
						int d = random.nextInt(100) + 1;
						
						if (d <= 10)
						{
							ViesisGemstones.proxy.generateSprintParticles(player);
						}
						
						if (d <= 50)
						{
							world.spawnParticle(EnumParticleTypes.CLOUD, playerPosX, playerPosY, playerPosZ, (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), new int[0]);
						}
						
					}
					
				}
				
			}
			else
			{
				player.setInvisible(false);
			}
			
		}
		
	}
	
	
	
}
