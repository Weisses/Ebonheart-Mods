package com.viesis.gemstones.common.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class WeaponHelper {
	
	public static void addPotionEffectToPlayer(EntityPlayer player, Potion potion , int seconds, int strength)
	{
		int a = 20 * seconds;
		player.addPotionEffect(new PotionEffect(potion, a, strength));
	}
	
	public static void addPotionEffectToTarget(EntityLivingBase target, Potion potion , int seconds, int strength)
	{
		int a = 20 * seconds;
		target.addPotionEffect(new PotionEffect(potion, a, strength));
	}
}
