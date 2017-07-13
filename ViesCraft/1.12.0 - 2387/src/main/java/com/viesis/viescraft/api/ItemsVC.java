package com.viesis.viescraft.api;

import com.viesis.viescraft.common.items.ItemAirshipDismounter;
import com.viesis.viescraft.common.items.ItemGuidebookControl;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.ItemGuidebookPaint;
import com.viesis.viescraft.common.items.ItemGuidebookSocket;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.achievements.ItemEntityAirship;
import com.viesis.viescraft.common.items.airshipitems.v1.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.v2.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.v3.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.v4.ItemAirshipV4;
import com.viesis.viescraft.common.items.parts.ItemBalloon;
import com.viesis.viescraft.common.items.parts.ItemBalloonPattern;
import com.viesis.viescraft.common.items.parts.ItemColorizerBalloon;
import com.viesis.viescraft.common.items.parts.ItemEngine;
import com.viesis.viescraft.common.items.parts.ItemFrame;
import com.viesis.viescraft.common.items.parts.ItemIgnition;
import com.viesis.viescraft.common.items.parts.ItemModule;
import com.viesis.viescraft.common.items.parts.ItemViesoline;

public class ItemsVC {
	
	public static final ItemGuidebookMain GUIDEBOOK_MAIN = new ItemGuidebookMain();
	public static final ItemGuidebookControl GUIDEBOOK_CONTROL = new ItemGuidebookControl();
	public static final ItemGuidebookPaint GUIDEBOOK_PAINT = new ItemGuidebookPaint();
	public static final ItemGuidebookSocket GUIDEBOOK_SOCKET = new ItemGuidebookSocket();
	
	public static final ItemViesoline VIESOLINE_PELLETS = new ItemViesoline();
	
	public static final ItemBalloon AIRSHIP_BALLOON = new ItemBalloon();
	public static final ItemEngine AIRSHIP_ENGINE = new ItemEngine();
	public static final ItemIgnition AIRSHIP_IGNITION = new ItemIgnition();
	
	public static final ItemAirshipDismounter ITEM_DISMOUNTER = new ItemAirshipDismounter();
	
	public static final ItemFrame AIRSHIP_FRAME = new ItemFrame();
	public static final ItemBalloonPattern AIRSHIP_BALLOON_PATTERN = new ItemBalloonPattern();
	public static final ItemModule AIRSHIP_MODULE = new ItemModule();
	
	public static final ItemColorizerBalloon ITEM_BALLOON_COLORIZER = new ItemColorizerBalloon();
	
	//==============================================
	
	public static final ItemAirshipV1 ITEM_AIRSHIP_V1 = new ItemAirshipV1("v1/item_airship_v1");
	public static final ItemAirshipV2 ITEM_AIRSHIP_V2 = new ItemAirshipV2("v2/item_airship_v2");
	public static final ItemAirshipV3 ITEM_AIRSHIP_V3 = new ItemAirshipV3("v3/item_airship_v3");
	public static final ItemAirshipV4 ITEM_AIRSHIP_V4 = new ItemAirshipV4("v4/item_airship_v4");
	
	public static final ItemAchievement ACHIEVEMENT_AIRSHIP = new ItemAchievement();
	public static final ItemEntityAirship ITEM_ENTITY_AIRSHIP = new ItemEntityAirship();
	
	//public static Item item_frame_colorizer;
	//public static Item airship_battery;
	
}
