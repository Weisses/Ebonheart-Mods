package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.items.achievements.ItemAchievementAirborn;
import com.viesis.viescraft.common.items.achievements.ItemAchievementCreate;
import com.viesis.viescraft.common.items.achievements.ItemAchievementCreateColor;
import com.viesis.viescraft.common.items.achievements.ItemAchievementEngine;
import com.viesis.viescraft.common.items.achievements.ItemAchievementIgnition;
import com.viesis.viescraft.common.items.achievements.ItemAchievementLava;
import com.viesis.viescraft.common.items.achievements.ItemAchievementWater;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipBlack;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipBlue;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipBrown;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipCyan;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipGray;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipGreen;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipLightBlue;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipLightGray;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipLime;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipMagenta;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipNormal;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipOrange;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipPink;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipPurple;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipRed;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipWhite;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipYellow;
import com.viesis.viescraft.common.items.resources.ItemBalloon;
import com.viesis.viescraft.common.items.resources.ItemEngine;
import com.viesis.viescraft.common.items.resources.ItemIgnition;
import com.viesis.viescraft.common.items.resources.ItemPaint;

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
		
		item_paint_black = registerItem(new ItemPaint(EntityAirshipCore.Type.BLACK));
		item_paint_blue = registerItem(new ItemPaint(EntityAirshipCore.Type.BLUE));
		item_paint_brown = registerItem(new ItemPaint(EntityAirshipCore.Type.BROWN));
		item_paint_cyan = registerItem(new ItemPaint(EntityAirshipCore.Type.CYAN));
		item_paint_gray = registerItem(new ItemPaint(EntityAirshipCore.Type.GRAY));
		item_paint_green = registerItem(new ItemPaint(EntityAirshipCore.Type.GREEN));
		item_paint_lightblue = registerItem(new ItemPaint(EntityAirshipCore.Type.LIGHTBLUE));
		item_paint_lightgray = registerItem(new ItemPaint(EntityAirshipCore.Type.LIGHTGRAY));
		item_paint_lime = registerItem(new ItemPaint(EntityAirshipCore.Type.LIME));
		item_paint_magenta = registerItem(new ItemPaint(EntityAirshipCore.Type.MAGENTA));
		item_paint_orange = registerItem(new ItemPaint(EntityAirshipCore.Type.ORANGE));
		item_paint_pink = registerItem(new ItemPaint(EntityAirshipCore.Type.PINK));
		item_paint_purple = registerItem(new ItemPaint(EntityAirshipCore.Type.PURPLE));
		item_paint_red = registerItem(new ItemPaint(EntityAirshipCore.Type.RED));
		item_paint_white = registerItem(new ItemPaint(EntityAirshipCore.Type.WHITE));
		item_paint_yellow = registerItem(new ItemPaint(EntityAirshipCore.Type.YELLOW));
		
		achievement_airship_create_engine = registerItem(new ItemAchievementEngine());
		achievement_airship_create_ignition = registerItem(new ItemAchievementIgnition());
		achievement_airship_create = registerItem(new ItemAchievementCreate());
		achievement_airship_create_color = registerItem(new ItemAchievementCreateColor());
		
		achievement_airship_airborn = registerItem(new ItemAchievementAirborn());
		achievement_airship_water = registerItem(new ItemAchievementWater());
		achievement_airship_lava = registerItem(new ItemAchievementLava());
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);
		
		return item;
	}
}
