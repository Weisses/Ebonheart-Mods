package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraft.init.Biomes;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal.Type;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipYellow;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBlack;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBlue;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBrown;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCyan;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipGray;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipGreen;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLime;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipNormal;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipOrange;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipPink;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipPurple;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipRed;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipWhite;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipYellow;
import com.viesis.viescraft.common.entity.old.EntityAirshipBase;
import com.viesis.viescraft.common.entity.old.EntityItemAirship;


public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		//register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
		//register(EntityAirshipVC.class, "AirshipEbonheart", 64, 1, true);
		
		register(EntityItemAirship.class, "item.airship", 64, 20, true);
		//register(EntityAirshipVCtest.class, "AirshipEbonheartNEW", 64, 1, true);
		
		//register(EntityItemAirshipFurnace.class, "vc.ItemAirshipFurnace", 64, 20, true);
		
		//===========================================
		
		
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
		
		
		
		//===========================================
		
		
		
		register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.NORMAL.getName(), 64, 1, true);
		register(EntityAirshipBlack.class, "airship." + EntityAirshipNormal.Type.BLACK.getName(), 64, 1, true);
		register(EntityAirshipBlue.class, "airship." + EntityAirshipNormal.Type.BLUE.getName(), 64, 1, true);
		register(EntityAirshipBrown.class, "airship." + EntityAirshipNormal.Type.BROWN.getName(), 64, 1, true);
		register(EntityAirshipCyan.class, "airship." + EntityAirshipNormal.Type.CYAN.getName(), 64, 1, true);
		register(EntityAirshipGray.class, "airship." + EntityAirshipNormal.Type.GRAY.getName(), 64, 1, true);
		register(EntityAirshipGreen.class, "airship." + EntityAirshipNormal.Type.GREEN.getName(), 64, 1, true);
		register(EntityAirshipLightBlue.class, "airship." + EntityAirshipNormal.Type.LIGHTBLUE.getName(), 64, 1, true);
		register(EntityAirshipLightGray.class, "airship." + EntityAirshipNormal.Type.LIGHTGRAY.getName(), 64, 1, true);
		register(EntityAirshipLime.class, "airship." + EntityAirshipNormal.Type.LIME.getName(), 64, 1, true);
		register(EntityAirshipMagenta.class, "airship." + EntityAirshipNormal.Type.MAGENTA.getName(), 64, 1, true);
		register(EntityAirshipOrange.class, "airship." + EntityAirshipNormal.Type.ORANGE.getName(), 64, 1, true);
		register(EntityAirshipPink.class, "airship." + EntityAirshipNormal.Type.PINK.getName(), 64, 1, true);
		register(EntityAirshipPurple.class, "airship." + EntityAirshipNormal.Type.PURPLE.getName(), 64, 1, true);
		register(EntityAirshipRed.class, "airship." + EntityAirshipNormal.Type.RED.getName(), 64, 1, true);
		register(EntityAirshipWhite.class, "airship." + EntityAirshipNormal.Type.WHITE.getName(), 64, 1, true);
		register(EntityAirshipYellow.class, "airship." + EntityAirshipNormal.Type.YELLOW.getName(), 64, 1, true);
		
		
		
		////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.BLACK.getName(), 64, 1, true);
		////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.RED.getName(), 64, 1, true);
		
		
		
		register(EntityAirshipBase.class, "AirshipEbonheart", 64, 1, true);
		//register(EntityAirshipBase2.class, "AirshipV2", 64, 1, true);
		
		//register(EntityAirshipFurnace.class, "AirshipVCFurnace", 64, 1, true);
		
		
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
