package com.viesis.viescraft;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.creative.VCTabBlocks;
import com.viesis.viescraft.api.creative.VCTabItems;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.api.util.MovementControl;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.CONFIG_GUI)
public class ViesCraft
{
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static Configuration config = null;
	
	//public static final VCTabBlocks tabViesCraftBlocks = new VCTabBlocks("tabViesCraftBlocks");
	public static final VCTabItems tabViesCraftItems = new VCTabItems("tabViesCraftItems");
	
	@Mod.Instance(Reference.MOD_ID)
	public static ViesCraft instance;
	
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		config = new Configuration(event.getSuggestedConfigurationFile());
		try
		{
			config.load();
			//MovementControl.initMovement();
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
		ViesCraftConfig.syncConfig();
		
		this.proxy.preInit(event);
		LogHelper.info("Pre Initialization Complete.");
	}
	
	//If config changed, it syncs it.
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if(event.getModID().equals(Reference.MOD_ID))
		{
			ViesCraftConfig.syncConfig();
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
