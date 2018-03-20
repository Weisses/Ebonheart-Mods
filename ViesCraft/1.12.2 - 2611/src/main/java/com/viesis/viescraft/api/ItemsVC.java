package com.viesis.viescraft.api;

import com.viesis.viescraft.common.items.ItemBomb;
import com.viesis.viescraft.common.items.ItemDismounterNormal;
import com.viesis.viescraft.common.items.ItemDismounterPlayer;
import com.viesis.viescraft.common.items.ItemEntityAirship;
import com.viesis.viescraft.common.items.ItemGuidebookMain;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;
import com.viesis.viescraft.common.items.airships.ItemAirship;
import com.viesis.viescraft.common.items.airships.ItemCreativeAirship;
import com.viesis.viescraft.common.items.parts.ItemModuleCreative;
import com.viesis.viescraft.common.items.parts.ItemModuleType;
import com.viesis.viescraft.common.items.parts.ItemViesoline;
import com.viesis.viescraft.common.items.parts.main.ItemBalloon;
import com.viesis.viescraft.common.items.parts.main.ItemEngine;
import com.viesis.viescraft.common.items.parts.main.ItemFrame;
import com.viesis.viescraft.common.items.parts.main.ItemIgnition;
import com.viesis.viescraft.common.items.parts.main.ItemLogicChip;
import com.viesis.viescraft.common.items.symbols.ItemDisplaySymbol;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeBalloon;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeCore;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeEngine;
import com.viesis.viescraft.common.items.upgrades.ItemUpgradeFrame;

public class ItemsVC {
	
	public static final ItemGuidebookMain GUIDEBOOK_MAIN = new ItemGuidebookMain();
	public static final ItemDismounterNormal DISMOUNTER_NORMAL = new ItemDismounterNormal();
	public static final ItemDismounterPlayer DISMOUNTER_PLAYER = new ItemDismounterPlayer();
	public static final ItemViesoline VIESOLINE_PELLETS = new ItemViesoline();
	public static final ItemLogicChip LOGIC_CHIP = new ItemLogicChip();
	public static final ItemFrame AIRSHIP_FRAME = new ItemFrame();
	public static final ItemIgnition AIRSHIP_IGNITION = new ItemIgnition();
	public static final ItemEngine AIRSHIP_ENGINE = new ItemEngine();
	public static final ItemBalloon AIRSHIP_BALLOON = new ItemBalloon();
	
	public static final ItemUpgradeCore UPGRADE_CORE = new ItemUpgradeCore();
	public static final ItemUpgradeFrame UPGRADE_FRAME = new ItemUpgradeFrame();
	public static final ItemUpgradeEngine UPGRADE_ENGINE = new ItemUpgradeEngine();
	public static final ItemUpgradeBalloon UPGRADE_BALLOON = new ItemUpgradeBalloon();
	
	public static final ItemBomb BOMB = new ItemBomb();
	
	public static final ItemModuleType MODULE_TYPE = new ItemModuleType();
	public static final ItemModuleCreative MODULE_CREATIVE = new ItemModuleCreative();
	
	//================================
	
	public static final ItemAirship ITEM_AIRSHIP = new ItemAirship("airships/item_airship");
	public static final ItemCreativeAirship ITEM_AIRSHIP_CREATIVE = new ItemCreativeAirship("airships/item_airship_creative");
	
	//================================
	//Hidden Items
	public static final ItemEntityAirship ITEM_ENTITY_AIRSHIP = new ItemEntityAirship();
	
	public static final ItemAchievement ACHIEVEMENT_AIRSHIP = new ItemAchievement();
	
	public static final ItemDisplaySymbol ITEM_DISPLAY_SYMBOL = new ItemDisplaySymbol();
	
	//================================
}
