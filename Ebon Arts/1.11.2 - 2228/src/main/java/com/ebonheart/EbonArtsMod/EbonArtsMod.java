package com.ebonheart.EbonArtsMod;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.ebonheart.EbonArtsMod.api.References;
import com.ebonheart.EbonArtsMod.api.creativeTab.EbonArtsTabBlocks;
import com.ebonheart.EbonArtsMod.api.creativeTab.EbonArtsTabCryptic;
import com.ebonheart.EbonArtsMod.api.creativeTab.EbonArtsTabDyeables;
import com.ebonheart.EbonArtsMod.api.creativeTab.EbonArtsTabItems;
import com.ebonheart.EbonArtsMod.api.util.LogHelper;
import com.ebonheart.EbonArtsMod.configs.EbonArtsConfiguration;
import com.ebonheart.EbonArtsMod.proxy.CommonProxy;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION, guiFactory = References.CONFIG_GUI)
public class EbonArtsMod {

	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static Configuration config = null;
	
	public static final EbonArtsTabItems tabEbonArtsItems = new EbonArtsTabItems("tabEbonArtsItems");
	public static final EbonArtsTabBlocks tabEbonArtsBlocks = new EbonArtsTabBlocks("tabEbonArtsBlocks");
	public static final EbonArtsTabDyeables tabEbonArtsDyeables = new EbonArtsTabDyeables("tabEbonArtsDyeables");
	public static final EbonArtsTabCryptic tabEbonArtsCryptic = new EbonArtsTabCryptic("tabEbonArtsCryptic");
	
	@Mod.Instance(References.MOD_ID)
	public static EbonArtsMod instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			config.load();
			LogHelper.info("Configuration loaded.");
		}
		catch (Exception e)
		{
			LogHelper.error("Ebon Arts has a problem loading it's configuration.");
			throw new RuntimeException(e);
		}
		finally
		{
			if (config.hasChanged()) 
			{
				config.save();
				LogHelper.info("Configuration changed, saved.");
			}
		}
		MinecraftForge.EVENT_BUS.register(instance);
		EbonArtsConfiguration.syncConfig();
		
		this.proxy.preInit(event);
		LogHelper.info("Pre Initialization Complete.");
	}
	
	//If config changed, it syncs it.
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equals(References.MOD_ID))
		{
			EbonArtsConfiguration.syncConfig();
			LogHelper.info("Configuration synced.");
		}
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.proxy.init(event);
		LogHelper.info("Initialization Complete.");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
		LogHelper.info("Post Initialization Complete.");
	}
}
