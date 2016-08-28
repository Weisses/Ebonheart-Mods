package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Black;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Green;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Red;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1White;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Admin;
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
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Admin;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Black;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Blue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Brown;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Cyan;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Gray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Green;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1LightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1LightGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Lime;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Magenta;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Orange;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Pink;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Purple;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Red;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1White;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Admin;
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
		register(EntityItemAirshipV1Normal.class, "item.airship.normal", 64, 20, true);
		register(EntityItemAirshipV1Black.class, "item.airship.black", 64, 20, true);
		register(EntityItemAirshipV1Blue.class, "item.airship.blue", 64, 20, true);
		register(EntityItemAirshipV1Brown.class, "item.airship.brown", 64, 20, true);
		register(EntityItemAirshipV1Cyan.class, "item.airship.cyan", 64, 20, true);
		register(EntityItemAirshipV1Gray.class, "item.airship.gray", 64, 20, true);
		register(EntityItemAirshipV1Green.class, "item.airship.green", 64, 20, true);
		register(EntityItemAirshipV1LightBlue.class, "item.airship.lightblue", 64, 20, true);
		register(EntityItemAirshipV1LightGray.class, "item.airship.lightgray", 64, 20, true);
		register(EntityItemAirshipV1Lime.class, "item.airship.lime", 64, 20, true);
		register(EntityItemAirshipV1Magenta.class, "item.airship.magenta", 64, 20, true);
		register(EntityItemAirshipV1Orange.class, "item.airship.orange", 64, 20, true);
		register(EntityItemAirshipV1Pink.class, "item.airship.pink", 64, 20, true);
		register(EntityItemAirshipV1Purple.class, "item.airship.purple", 64, 20, true);
		register(EntityItemAirshipV1Red.class, "item.airship.red", 64, 20, true);
		register(EntityItemAirshipV1White.class, "item.airship.white", 64, 20, true);
		register(EntityItemAirshipV1Yellow.class, "item.airship.yellow", 64, 20, true);
		register(EntityItemAirshipV1Admin.class, "item.airship.admin", 64, 20, true);
		
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
		register(EntityItemAirshipV2Admin.class, "item.airship.v2.admin", 64, 20, true);
		
		//===========================================
		
		register(EntityAirshipV1Normal.class, "airship.normal", 64, 1, true);
		register(EntityAirshipV1Black.class, "airship.black", 64, 1, true);
		register(EntityAirshipV1Blue.class, "airship.blue", 64, 1, true);
		register(EntityAirshipV1Brown.class, "airship.brown", 64, 1, true);
		register(EntityAirshipV1Cyan.class, "airship.cyan", 64, 1, true);
		register(EntityAirshipV1Gray.class, "airship.gray", 64, 1, true);
		register(EntityAirshipV1Green.class, "airship.green", 64, 1, true);
		register(EntityAirshipV1LightBlue.class, "airship.lightblue", 64, 1, true);
		register(EntityAirshipV1LightGray.class, "airship.lightgray", 64, 1, true);
		register(EntityAirshipV1Lime.class, "airship.lime", 64, 1, true);
		register(EntityAirshipV1Magenta.class, "airship.magenta", 64, 1, true);
		register(EntityAirshipV1Orange.class, "airship.orange", 64, 1, true);
		register(EntityAirshipV1Pink.class, "airship.pink", 64, 1, true);
		register(EntityAirshipV1Purple.class, "airship.purple", 64, 1, true);
		register(EntityAirshipV1Red.class, "airship.red", 64, 1, true);
		register(EntityAirshipV1White.class, "airship.white", 64, 1, true);
		register(EntityAirshipV1Yellow.class, "airship.yellow", 64, 1, true);
		register(EntityAirshipV1Admin.class, "airship.v1.admin", 64, 1, true);
		
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
		register(EntityAirshipV2Admin.class, "airship.v2.admin", 64, 1, true);
		
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
