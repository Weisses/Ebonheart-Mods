package com.viesis.gemstones.common.items.armor;

import java.util.List;
import java.util.Random;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.items.ItemHelper;
import com.viesis.gemstones.common.items.MaterialHelper;
import com.viesis.gemstones.common.utils.modifiers.VGAttributeModifier;
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

//Necrocite
public class ItemVengeanceArmor extends ItemArmor {
	
	double playerPosX;
	double playerPosY;
	double playerPosZ;
	
	Random random = new Random();
	
	public ItemVengeanceArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.VENGEANCE, renderIndexIn, equipmentSlotIn);
		
		ItemHelper.setItemName(this, unlocalizedName);
		//this.setCreativeTab(ViesisGemstones.tabEbonArtsItems);
		
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
		return new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 0) == repair ? true : super.getIsRepairable(toRepair, repair);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "Unholy power courses through");
		toolTip.add(TextFormatting.DARK_PURPLE + "this cursed armor.");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + "Set Bonus:");
		toolTip.add(TextFormatting.GREEN + "Max Health increased by +4.");
		toolTip.add(TextFormatting.GREEN + "All Attacks increased by +1.");
		toolTip.add(TextFormatting.GREEN + "Speed increased by 110%");
		
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	/**
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsVG.vengeance_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsVG.vengeance_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsVG.vengeance_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsVG.vengeance_boots) 
		{
			
			if(!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.VENGEANCE_SPEED_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(VGAttributeModifier.VENGEANCE_SPEED_BONUS);
			}
			
			if(!player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(VGAttributeModifier.VENGEANCE_HP_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).applyModifier(VGAttributeModifier.VENGEANCE_HP_BONUS);
			}
			
			if(!player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(VGAttributeModifier.VENGEANCE_ATTACK_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).applyModifier(VGAttributeModifier.VENGEANCE_ATTACK_BONUS);
			}
			
			if(!ViesisGemstonesConfig.armorParticle)
			{
				if(world.isRemote)
				{
					
					if(player.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND) != null)
					{
						
						int d = random.nextInt(100) + 1;
						
						if (d <= 2)
						{
							ViesisGemstones.proxy.generateUnholyParticles(player);
						}
						
					}
					
					//Blocking with shield
					if (player.isHandActive())
					{
						
						int d = random.nextInt(100) + 1;
						
						if (d <= 25)
						{
							
							playerPosX = player.getPositionVector().xCoord;
							playerPosY = player.getPositionVector().yCoord;
							playerPosZ = player.getPositionVector().zCoord;
							
							world.spawnParticle(EnumParticleTypes.SPELL_WITCH, playerPosX, playerPosY, playerPosZ, (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), new int[0]);
							
						}
					
					}
				
				}
				
			}
			
		}
		
	}*/
	
}
