package com.viesis.viescraft.common.utils.events;

import java.util.List;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.client.MessageConfig;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

public class EventHandlerConfig {
	
	public static final ResourceLocation[] GENERAL_ITEMS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "guidebooks/guidebook_main"),
		new ResourceLocation(Reference.MOD_ID_COLON + "guidebooks/guidebook_control"),
		new ResourceLocation(Reference.MOD_ID_COLON + "guidebooks/guidebook_paint"),
		new ResourceLocation(Reference.MOD_ID_COLON + "guidebooks/guidebook_socket"),
		new ResourceLocation(Reference.MOD_ID_COLON + "airship_workbench"),
		new ResourceLocation(Reference.MOD_ID_COLON + "item_airship_dismounter"),
		new ResourceLocation(Reference.MOD_ID_COLON + "airship_balloon"),
		new ResourceLocation(Reference.MOD_ID_COLON + "airship_engine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "airship_ignition"),
		new ResourceLocation(Reference.MOD_ID_COLON + "viesoline_pellets"),
		new ResourceLocation(Reference.MOD_ID_COLON + "item_balloon_colorizer"),
		new ResourceLocation(Reference.MOD_ID_COLON + "airship_module_chip")
	};
	
	public static final ResourceLocation[] FRAMES = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_oak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_spruce"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_birch"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_jungle"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_acacia"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_darkoak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_sandstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_brick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_bone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_iron"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_redstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_gold"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_lapislazuli"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_slime"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_mycelium"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_netherbrick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_soulsand"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_quartz"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_ice"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_glowstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_obsidian"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_diamond"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_emerald"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_prismarine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_purpur"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_netherstar"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_mythic"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_water"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_lava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "frames/airship_frame_ender")
	};
	
	public static final ResourceLocation[] V1_AIRSHIPS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_oak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_spruce"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_birch"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_jungle"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_acacia"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_darkoak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_sandstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier1/item_airship_v1_brick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_bone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_iron"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_redstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_gold"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_lapislazuli"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_slime"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier2/item_airship_v1_mycelium"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_netherbrick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_soulsand"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_quartz"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_ice"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_glowstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier3/item_airship_v1_obsidian"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier4/item_airship_v1_diamond"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier4/item_airship_v1_emerald"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier4/item_airship_v1_prismarine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier4/item_airship_v1_purpur"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/tier4/item_airship_v1_netherstar"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/item_airship_v1_mythic"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/item_airship_v1_water"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/item_airship_v1_lava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v1/item_airship_v1_ender")
	};
	
	public static final ResourceLocation[] V2_AIRSHIPS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_oak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_spruce"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_birch"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_jungle"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_acacia"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_darkoak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_sandstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier1/item_airship_v2_brick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_bone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_iron"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_redstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_gold"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_lapislazuli"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_slime"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier2/item_airship_v2_mycelium"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_netherbrick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_soulsand"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_quartz"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_ice"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_glowstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier3/item_airship_v2_obsidian"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier4/item_airship_v2_diamond"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier4/item_airship_v2_emerald"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier4/item_airship_v2_prismarine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier4/item_airship_v2_purpur"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/tier4/item_airship_v2_netherstar"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/item_airship_v2_mythic"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/item_airship_v2_water"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/item_airship_v2_lava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v2/item_airship_v2_ender")
	};
	
	public static final ResourceLocation[] V3_AIRSHIPS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_oak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_spruce"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_birch"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_jungle"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_acacia"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_darkoak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_sandstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier1/item_airship_v3_brick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_bone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_iron"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_redstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_gold"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_lapislazuli"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_slime"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier2/item_airship_v3_mycelium"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_netherbrick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_soulsand"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_quartz"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_ice"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_glowstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier3/item_airship_v3_obsidian"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier4/item_airship_v3_diamond"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier4/item_airship_v3_emerald"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier4/item_airship_v3_prismarine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier4/item_airship_v3_purpur"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/tier4/item_airship_v3_netherstar"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/item_airship_v3_mythic"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/item_airship_v3_water"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/item_airship_v3_lava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v3/item_airship_v3_ender")
	};
	
	public static final ResourceLocation[] V4_AIRSHIPS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_oak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_spruce"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_birch"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_jungle"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_acacia"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_darkoak"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_sandstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier1/item_airship_v4_brick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_bone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_iron"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_redstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_gold"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_lapislazuli"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_slime"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier2/item_airship_v4_mycelium"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_netherbrick"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_soulsand"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_quartz"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_ice"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_glowstone"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier3/item_airship_v4_obsidian"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier4/item_airship_v4_diamond"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier4/item_airship_v4_emerald"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier4/item_airship_v4_prismarine"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier4/item_airship_v4_purpur"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/tier4/item_airship_v4_netherstar"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/item_airship_v4_mythic"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/item_airship_v4_water"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/item_airship_v4_lava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "v4/item_airship_v4_ender")
	};
	
	public static final ResourceLocation[] MODULES = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_minorspeed"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_majorspeed"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_smallinventory"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_largeinventory"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_infinitefuel"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_waterlanding"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_maxaltitude"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_minorefficiency"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_majorefficiency"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_jukebox"),
		new ResourceLocation(Reference.MOD_ID_COLON + "modules/airship_module_cruisecontrol")
	};
	
	public static final ResourceLocation[] BALLOON_PATTERNS = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalplain"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedplain"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomplain"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalchecker"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedchecker"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomchecker"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalpolkadot"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedpolkadot"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantompolkadot"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalzigzag"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedzigzag"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomzigzag"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalcreeper"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedcreeper"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomcreeper"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalwater"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedwater"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomwater"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normallava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedlava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomlava"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normalender"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedender"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomender"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_normaltools"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_colorizedtools"),
		new ResourceLocation(Reference.MOD_ID_COLON + "balloonpatterns/airship_balloon_pattern_phantomtools")
	};
	
	
	
	public EventHandlerConfig()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event)
	{
		if(!event.player.world.isRemote)
		{
			NetworkHandler.sendToClient(new MessageConfig(), (EntityPlayerMP)event.player);
			
			if(ViesCraftConfig.recipeBookAddAll)
			{
				event.player.unlockRecipes(GENERAL_ITEMS);
				event.player.unlockRecipes(FRAMES);
				event.player.unlockRecipes(V1_AIRSHIPS);
				event.player.unlockRecipes(V2_AIRSHIPS);
				event.player.unlockRecipes(V3_AIRSHIPS);
				event.player.unlockRecipes(V4_AIRSHIPS);
				event.player.unlockRecipes(MODULES);
				event.player.unlockRecipes(BALLOON_PATTERNS);
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerLogoutEvent(PlayerLoggedOutEvent event)
	{
		
	}
}
