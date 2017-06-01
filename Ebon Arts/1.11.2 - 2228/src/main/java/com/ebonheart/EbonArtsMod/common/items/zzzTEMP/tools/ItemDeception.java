package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.tools;

import java.util.List;
import java.util.Random;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.common.items.WeaponHelper;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDeception extends ItemSword {
	
	public ItemDeception(ToolMaterial material) 
	{
		super(material);
		ItemHelper.setItemName(this, "tool/deception");
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		Random rand = new Random();
		int d = rand.nextInt(100) + 1;
		
		if (d < 40)
		{
			Potion potion1 = Potion.getPotionById(15);
					//.blindness;
			Potion potion2 = Potion.getPotionById(14);
					//.invisibility;
			EntityPlayer playerIn = attacker.getEntityWorld().getPlayerEntityByUUID(attacker.getUniqueID());
			WeaponHelper.addPotionEffectToTarget(target, potion1, 3, 0);
			WeaponHelper.addPotionEffectToTarget(playerIn, potion2, 5, 0);
			stack.damageItem(1, playerIn);
		}
        return true;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "\"All minds can bend as");
		toolTip.add(TextFormatting.DARK_PURPLE + "reality shifts.\"");
		toolTip.add(" ");
		toolTip.add(TextFormatting.GOLD + "40% chance on hit:");
		toolTip.add(TextFormatting.RED + "Target - Blinds for 3 seconds.");
		toolTip.add(TextFormatting.GREEN + "Self - Invisibility for 5 seconds.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	
}
