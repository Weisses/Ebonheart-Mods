package com.viesis.viescraft.api;

import com.viesis.viescraft.common.items.ItemDismounterNormal;
import com.viesis.viescraft.common.items.ItemDismounterPlayer;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.achievements.ItemEntityAirship;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV4;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV5;
import com.viesis.viescraft.common.items.airshipitems.creative.ItemCreativeAirshipV6;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV1;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV2;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV3;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV4;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV5;
import com.viesis.viescraft.common.items.airshipitems.normal.ItemAirshipV6;
import com.viesis.viescraft.common.items.parts.ItemModuleCreative;
import com.viesis.viescraft.common.items.parts.ItemModuleType;
import com.viesis.viescraft.common.items.parts.ItemViesoline;
import com.viesis.viescraft.common.items.parts.main.ItemBalloon;
import com.viesis.viescraft.common.items.parts.main.ItemEngine;
import com.viesis.viescraft.common.items.parts.main.ItemFrame;
import com.viesis.viescraft.common.items.parts.main.ItemIgnition;
import com.viesis.viescraft.common.items.parts.main.ItemLogicChip;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeBalloon;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeCore;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeEngine;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeFrame;

public class ItemsVC {
	
	public static final ItemGuidebookMain GUIDEBOOK_MAIN = new ItemGuidebookMain();
	public static final ItemDismounterNormal ITEM_DISMOUNTER_NORMAL = new ItemDismounterNormal();
	public static final ItemDismounterPlayer ITEM_DISMOUNTER_PLAYER = new ItemDismounterPlayer();
	public static final ItemViesoline VIESOLINE_PELLETS = new ItemViesoline();
	public static final ItemLogicChip LOGIC_CHIP = new ItemLogicChip();
	public static final ItemFrame AIRSHIP_FRAME = new ItemFrame();
	public static final ItemIgnition AIRSHIP_IGNITION = new ItemIgnition();
	public static final ItemEngine AIRSHIP_ENGINE = new ItemEngine();
	public static final ItemBalloon AIRSHIP_BALLOON = new ItemBalloon();
	public static final ItemUpgradeFrame UPGRADE_FRAME = new ItemUpgradeFrame();
	public static final ItemUpgradeCore UPGRADE_CORE = new ItemUpgradeCore();
	public static final ItemUpgradeEngine UPGRADE_ENGINE = new ItemUpgradeEngine();
	public static final ItemUpgradeBalloon UPGRADE_BALLOON = new ItemUpgradeBalloon();
	public static final ItemModuleType MODULE_TYPE = new ItemModuleType();
	public static final ItemModuleCreative MODULE_CREATIVE = new ItemModuleCreative();
	
	//================================
	
	public static final ItemAirshipV1 ITEM_V1_AIRSHIP = new ItemAirshipV1("airships/item_airship_v1");
	public static final ItemCreativeAirshipV1 ITEM_CREATIVE_V1_AIRSHIP = new ItemCreativeAirshipV1("airships/item_creative_airship_v1");
	public static final ItemAirshipV2 ITEM_V2_AIRSHIP = new ItemAirshipV2("airships/item_airship_v2");
	public static final ItemCreativeAirshipV2 ITEM_CREATIVE_V2_AIRSHIP = new ItemCreativeAirshipV2("airships/item_creative_airship_v2");
	public static final ItemAirshipV3 ITEM_V3_AIRSHIP = new ItemAirshipV3("airships/item_airship_v3");
	public static final ItemCreativeAirshipV3 ITEM_CREATIVE_V3_AIRSHIP = new ItemCreativeAirshipV3("airships/item_creative_airship_v3");
	public static final ItemAirshipV4 ITEM_V4_AIRSHIP = new ItemAirshipV4("airships/item_airship_v4");
	public static final ItemCreativeAirshipV4 ITEM_CREATIVE_V4_AIRSHIP = new ItemCreativeAirshipV4("airships/item_creative_airship_v4");
	public static final ItemAirshipV5 ITEM_V5_AIRSHIP = new ItemAirshipV5("airships/item_airship_v5");
	public static final ItemCreativeAirshipV5 ITEM_CREATIVE_V5_AIRSHIP = new ItemCreativeAirshipV5("airships/item_creative_airship_v5");
	public static final ItemAirshipV6 ITEM_V6_AIRSHIP = new ItemAirshipV6("airships/item_airship_v6");
	public static final ItemCreativeAirshipV6 ITEM_CREATIVE_V6_AIRSHIP = new ItemCreativeAirshipV6("airships/item_creative_airship_v6");
	
	//================================
	
	public static final ItemAchievement ACHIEVEMENT_AIRSHIP = new ItemAchievement();
	public static final ItemEntityAirship ITEM_ENTITY_AIRSHIP = new ItemEntityAirship();
	
	//================================
}
