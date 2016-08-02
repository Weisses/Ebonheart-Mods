package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal;
import com.viesis.viescraft.common.items.resources.ItemAirshipBlack;
import com.viesis.viescraft.common.items.resources.ItemAirshipBlue;
import com.viesis.viescraft.common.items.resources.ItemAirshipBrown;
import com.viesis.viescraft.common.items.resources.ItemAirshipCyan;
import com.viesis.viescraft.common.items.resources.ItemAirshipGray;
import com.viesis.viescraft.common.items.resources.ItemAirshipGreen;
import com.viesis.viescraft.common.items.resources.ItemAirshipLightBlue;
import com.viesis.viescraft.common.items.resources.ItemAirshipLightGray;
import com.viesis.viescraft.common.items.resources.ItemAirshipLime;
import com.viesis.viescraft.common.items.resources.ItemAirshipMagenta;
import com.viesis.viescraft.common.items.resources.ItemAirshipNormal;
import com.viesis.viescraft.common.items.resources.ItemAirshipOrange;
import com.viesis.viescraft.common.items.resources.ItemAirshipPink;
import com.viesis.viescraft.common.items.resources.ItemAirshipPurple;
import com.viesis.viescraft.common.items.resources.ItemAirshipRed;
import com.viesis.viescraft.common.items.resources.ItemAirshipWhite;
import com.viesis.viescraft.common.items.resources.ItemAirshipYellow;
import com.viesis.viescraft.common.items.resources.ItemBalloon;
import com.viesis.viescraft.common.items.resources.ItemEngine;
import com.viesis.viescraft.common.items.resources.ItemIgnition;
import com.viesis.viescraft.common.items.resources.ItemPaint;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementAirborn;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementCreate;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementCreateColor;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementEngine;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementIgnition;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementLava;
import com.viesis.viescraft.common.items.resources.achievements.ItemAchievementWater;
import com.viesis.viescraft.common.items.resources.old.ItemAirship;
import com.viesis.viescraft.common.items.resources.old.ItemAirshipV2;
import com.viesis.viescraft.common.items.resources.old.ItemAirshiptest;
import com.viesis.viescraft.common.items.resources.old.ItemViesdenburg;

public class InitItemsVC extends ItemsVC {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static void preInit()
	{
		airship_balloon = registerItem(new ItemBalloon());
		airship_engine = registerItem(new ItemEngine());
		airship_ignition = registerItem(new ItemIgnition());
		
		
		item_airship_normal = registerItem(new ItemAirshipNormal());
		item_airship_black = registerItem(new ItemAirshipBlack());
		item_airship_blue = registerItem(new ItemAirshipBlue());
		item_airship_brown = registerItem(new ItemAirshipBrown());
		item_airship_cyan = registerItem(new ItemAirshipCyan());
		item_airship_gray = registerItem(new ItemAirshipGray());
		item_airship_green = registerItem(new ItemAirshipGreen());
		item_airship_lightblue = registerItem(new ItemAirshipLightBlue());
		item_airship_lightgray = registerItem(new ItemAirshipLightGray());
		item_airship_lime = registerItem(new ItemAirshipLime());
		item_airship_magenta = registerItem(new ItemAirshipMagenta());
		item_airship_orange = registerItem(new ItemAirshipOrange());
		item_airship_pink = registerItem(new ItemAirshipPink());
		item_airship_purple = registerItem(new ItemAirshipPurple());
		item_airship_red = registerItem(new ItemAirshipRed());
		item_airship_white = registerItem(new ItemAirshipWhite());
		item_airship_yellow = registerItem(new ItemAirshipYellow());
		
		item_paint_black = registerItem(new ItemPaint(EntityAirshipNormal.Type.BLACK));
		item_paint_blue = registerItem(new ItemPaint(EntityAirshipNormal.Type.BLUE));
		item_paint_brown = registerItem(new ItemPaint(EntityAirshipNormal.Type.BROWN));
		item_paint_cyan = registerItem(new ItemPaint(EntityAirshipNormal.Type.CYAN));
		item_paint_gray = registerItem(new ItemPaint(EntityAirshipNormal.Type.GRAY));
		item_paint_green = registerItem(new ItemPaint(EntityAirshipNormal.Type.GREEN));
		item_paint_lightblue = registerItem(new ItemPaint(EntityAirshipNormal.Type.LIGHTBLUE));
		item_paint_lightgray = registerItem(new ItemPaint(EntityAirshipNormal.Type.LIGHTGRAY));
		item_paint_lime = registerItem(new ItemPaint(EntityAirshipNormal.Type.LIME));
		item_paint_magenta = registerItem(new ItemPaint(EntityAirshipNormal.Type.MAGENTA));
		item_paint_orange = registerItem(new ItemPaint(EntityAirshipNormal.Type.ORANGE));
		item_paint_pink = registerItem(new ItemPaint(EntityAirshipNormal.Type.PINK));
		item_paint_purple = registerItem(new ItemPaint(EntityAirshipNormal.Type.PURPLE));
		item_paint_red = registerItem(new ItemPaint(EntityAirshipNormal.Type.RED));
		item_paint_white = registerItem(new ItemPaint(EntityAirshipNormal.Type.WHITE));
		item_paint_yellow = registerItem(new ItemPaint(EntityAirshipNormal.Type.YELLOW));
		
		
		//item_airship_black = registerItem(new ItemAirshiptest(EntityAirshipNormal.Type.BLACK));
		//item_airship_blue = registerItem(new ItemAirshiptest(EntityAirshipNormal.Type.BLUE));
		//item_airship_red = registerItem(new ItemAirshiptest(EntityAirshipNormal.Type.RED));
		
		
		
		item_airship_base = registerItem(new ItemAirship());
		//item_airship_v2 = registerItem(new ItemAirshipV2());
		//item_airship_furnace = registerItem(new ItemAirshipFurnace());
		
		
		item_viesdenburg = registerItem(new ItemViesdenburg());
		
		achievement_airship_create_engine = registerItem(new ItemAchievementEngine());
		achievement_airship_create_ignition = registerItem(new ItemAchievementIgnition());
		achievement_airship_create = registerItem(new ItemAchievementCreate());
		achievement_airship_create_color = registerItem(new ItemAchievementCreateColor());
		
		achievement_airship_airborn = registerItem(new ItemAchievementAirborn());
		achievement_airship_water = registerItem(new ItemAchievementWater());
		achievement_airship_lava = registerItem(new ItemAchievementLava());
		
		//test = registerItem(new ItemAirship());
		
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
