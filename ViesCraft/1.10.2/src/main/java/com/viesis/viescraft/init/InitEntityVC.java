package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipYellow;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Black;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Green;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Red;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2White;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBlack;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBrown;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipCyan;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipGreen;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLime;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipNormal;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipOrange;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipPink;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipPurple;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipRed;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipWhite;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipYellow;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Black;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Blue;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Brown;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Cyan;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Gray;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Green;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2LightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2LightGray;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Lime;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Magenta;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Normal;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Orange;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Pink;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Purple;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Red;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2White;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Yellow;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		register(EntityItemAirshipNormal.class, "item.airship.normal", 64, 20, true);
		register(EntityItemAirshipBlack.class, "item.airship.black", 64, 20, true);
		register(EntityItemAirshipBlue.class, "item.airship.blue", 64, 20, true);
		register(EntityItemAirshipBrown.class, "item.airship.brown", 64, 20, true);
		register(EntityItemAirshipCyan.class, "item.airship.cyan", 64, 20, true);
		register(EntityItemAirshipGray.class, "item.airship.gray", 64, 20, true);
		register(EntityItemAirshipGreen.class, "item.airship.green", 64, 20, true);
		register(EntityItemAirshipLightBlue.class, "item.airship.lightblue", 64, 20, true);
		register(EntityItemAirshipLightGray.class, "item.airship.lightgray", 64, 20, true);
		register(EntityItemAirshipLime.class, "item.airship.lime", 64, 20, true);
		register(EntityItemAirshipMagenta.class, "item.airship.magenta", 64, 20, true);
		register(EntityItemAirshipOrange.class, "item.airship.orange", 64, 20, true);
		register(EntityItemAirshipPink.class, "item.airship.pink", 64, 20, true);
		register(EntityItemAirshipPurple.class, "item.airship.purple", 64, 20, true);
		register(EntityItemAirshipRed.class, "item.airship.red", 64, 20, true);
		register(EntityItemAirshipWhite.class, "item.airship.white", 64, 20, true);
		register(EntityItemAirshipYellow.class, "item.airship.yellow", 64, 20, true);
		/**
		register(EntityItemAirshipV2Normal.class, "item.airship.v2.normal", 64, 20, true);
		register(EntityItemAirshipV2Black.class, "item.airship.v2.black", 64, 20, true);
		register(EntityItemAirshipV2Blue.class, "item.airship.v2.blue", 64, 20, true);
		register(EntityItemAirshipV2Brown.class, "item.airship.v2.brown", 64, 20, true);
		register(EntityItemAirshipV2Cyan.class, "item.airship.v2.cyan", 64, 20, true);
		register(EntityItemAirshipV2Gray.class, "item.airship.v2.gray", 64, 20, true);
		register(EntityItemAirshipV2Green.class, "item.airship.v2.green", 64, 20, true);
		register(EntityItemAirshipV2LightBlue.class, "item.airship.v2.lightblue", 64, 20, true);
		register(EntityItemAirshipV2LightGray.class, "item.airship.v2.lightgray", 64, 20, true);
		register(EntityItemAirshipV2Lime.class, "item.airship.v2.lime", 64, 20, true);
		register(EntityItemAirshipV2Magenta.class, "item.airship.v2.magenta", 64, 20, true);
		register(EntityItemAirshipV2Orange.class, "item.airship.v2.orange", 64, 20, true);
		register(EntityItemAirshipV2Pink.class, "item.airship.v2.pink", 64, 20, true);
		register(EntityItemAirshipV2Purple.class, "item.airship.v2.purple", 64, 20, true);
		register(EntityItemAirshipV2Red.class, "item.airship.v2.red", 64, 20, true);
		register(EntityItemAirshipV2White.class, "item.airship.v2.white", 64, 20, true);
		register(EntityItemAirshipV2Yellow.class, "item.airship.v2.yellow", 64, 20, true);
		*/
		//===========================================
		
		register(EntityAirshipNormal.class, "airship.normal", 64, 1, true);
		register(EntityAirshipBlack.class, "airship.black", 64, 1, true);
		register(EntityAirshipBlue.class, "airship.blue", 64, 1, true);
		register(EntityAirshipBrown.class, "airship.brown", 64, 1, true);
		register(EntityAirshipCyan.class, "airship.cyan", 64, 1, true);
		register(EntityAirshipGray.class, "airship.gray", 64, 1, true);
		register(EntityAirshipGreen.class, "airship.green", 64, 1, true);
		register(EntityAirshipLightBlue.class, "airship.lightblue", 64, 1, true);
		register(EntityAirshipLightGray.class, "airship.lightgray", 64, 1, true);
		register(EntityAirshipLime.class, "airship.lime", 64, 1, true);
		register(EntityAirshipMagenta.class, "airship.magenta", 64, 1, true);
		register(EntityAirshipOrange.class, "airship.orange", 64, 1, true);
		register(EntityAirshipPink.class, "airship.pink", 64, 1, true);
		register(EntityAirshipPurple.class, "airship.purple", 64, 1, true);
		register(EntityAirshipRed.class, "airship.red", 64, 1, true);
		register(EntityAirshipWhite.class, "airship.white", 64, 1, true);
		register(EntityAirshipYellow.class, "airship.yellow", 64, 1, true);
		/**
		register(EntityAirshipV2Normal.class, "airship.v2.normal", 64, 1, true);
		register(EntityAirshipV2Black.class, "airship.v2.black", 64, 1, true);
		register(EntityAirshipV2Blue.class, "airship.v2.blue", 64, 1, true);
		register(EntityAirshipV2Brown.class, "airship.v2.brown", 64, 1, true);
		register(EntityAirshipV2Cyan.class, "airship.v2.cyan", 64, 1, true);
		register(EntityAirshipV2Gray.class, "airship.v2.gray", 64, 1, true);
		register(EntityAirshipV2Green.class, "airship.v2.green", 64, 1, true);
		register(EntityAirshipV2LightBlue.class, "airship.v2.lightblue", 64, 1, true);
		register(EntityAirshipV2LightGray.class, "airship.v2.lightgray", 64, 1, true);
		register(EntityAirshipV2Lime.class, "airship.v2.lime", 64, 1, true);
		register(EntityAirshipV2Magenta.class, "airship.v2.magenta", 64, 1, true);
		register(EntityAirshipV2Orange.class, "airship.v2.orange", 64, 1, true);
		register(EntityAirshipV2Pink.class, "airship.v2.pink", 64, 1, true);
		register(EntityAirshipV2Purple.class, "airship.v2.purple", 64, 1, true);
		register(EntityAirshipV2Red.class, "airship.v2.red", 64, 1, true);
		register(EntityAirshipV2White.class, "airship.v2.white", 64, 1, true);
		register(EntityAirshipV2Yellow.class, "airship.v2.yellow", 64, 1, true);
		*/
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
	
	public static void register1(Class<? extends Entity> class1, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(class1, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}
