package com.ebonheart.EbonArtsMod.common.entity.modifiers;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;

public class EAAttributeModifier {

	public static EntityPlayer player;
	
	public static AttributeModifier BURNISHED_SPEED_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000101"), "Burnished Speed Boost", 0.20, 2);
	//public static AttributeModifier BURNISHED_LOOT_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000102"), "Burnished Loot Boost", 5.00, 0);
	
	
	public static AttributeModifier SCALEMAIL_SPEED_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000201"), "Scalemail Speed Boost", 0.00, 2);
	
	
	public static AttributeModifier VENGEANCE_SPEED_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000301"), "Vengeance Speed Boost", 0.10, 2);
	public static AttributeModifier VENGEANCE_HP_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000302"), "Vengeance HP Boost", 0.20, 2);
	public static AttributeModifier VENGEANCE_ATTACK_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000303"), "Vengeance Attack Boost", 1.00, 2);
	
	public static AttributeModifier CELESTIAL_SPEED_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000401"), "Celestial Speed Boost", 0.00, 2);
	public static AttributeModifier CELESTIAL_FLY_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000402"), "Celestial Fly Speed Boost", 0.00, 2);
	
	public static AttributeModifier HELLIONFRUIT_BONUS = new AttributeModifier(UUID.fromString("d607b1a8-a17e-4ffd-b346-0d5f00000402"), "Hellion Fruit Boost", 0.00, 2);
	
	/**
	 * 
		0 = x + y
		1 = x * y
		2 = x * (1 + y)
	 **/
}
