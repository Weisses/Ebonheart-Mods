package com.ebonheart.EbonArtsMod.common.items.tools;

import java.util.List;
import java.util.Random;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.common.items.WeaponHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlazefury extends ItemSword {

	public ItemBlazefury(ToolMaterial material) 
	{
		super(material);
		ItemHelper.setItemName(this, "tool/blazefury");
	}
	
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		Random rand = new Random();
		int d = rand.nextInt(100) + 1;
		
		if (d < 30)
		{
			Potion potion = Potion.getPotionById(12);
					//.fireResistance;
			EntityPlayer playerIn = attacker.getEntityWorld().getPlayerEntityByUUID(attacker.getUniqueID());
			target.setFire(4);
			WeaponHelper.addPotionEffectToTarget(playerIn, potion, 5, 0);
			stack.damageItem(1, playerIn);
		}
        return true;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) {
		toolTip.add(TextFormatting.DARK_PURPLE + "\"Let the flames consume all");
		toolTip.add(TextFormatting.DARK_PURPLE + "that stand before you.\"");
		toolTip.add(" ");
		toolTip.add(TextFormatting.GOLD + "30% chance on hit:");
		toolTip.add(TextFormatting.RED + "Target - Set on fire for 4 seconds.");
		toolTip.add(TextFormatting.GREEN + "Self - Fire Resistance for 5 seconds.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	
}
