package com.viesis.viescraft;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.creative.VCTabAirships;
import com.viesis.viescraft.api.creative.VCTabItems;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.proxy.CommonProxy;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.CONFIG_GUI)
public class ViesCraft {
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	//public static final VCTabBlocks tabViesCraftBlocks = new VCTabBlocks("tabViesCraftBlocks");
	public static final VCTabItems tabViesCraftItems = new VCTabItems("tabViesCraftItems");
	public static final VCTabAirships tabViesCraftAirships = new VCTabAirships("tabViesCraftAirships");
	
	private static File configDir;
	
	@Mod.Instance(Reference.MOD_ID)
	public static ViesCraft instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		configDir.mkdirs();
		ViesCraftConfig.init(new File(configDir.getPath(), Reference.MOD_ID + ".cfg"));
		
		this.proxy.preInit(event);
		LogHelper.info("Pre Initialization Complete.");
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
