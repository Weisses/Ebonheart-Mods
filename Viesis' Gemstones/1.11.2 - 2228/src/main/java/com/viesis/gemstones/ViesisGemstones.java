package com.viesis.gemstones;

import java.io.File;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.creativeTab.VGTabBlocks;
import com.viesis.gemstones.api.creativeTab.VGTabCryptic;
import com.viesis.gemstones.api.creativeTab.VGTabDyeables;
import com.viesis.gemstones.api.creativeTab.VGTabItems;
import com.viesis.gemstones.api.util.LogHelper;
import com.viesis.gemstones.configs.ViesisGemstonesConfig;
import com.viesis.gemstones.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION, guiFactory = References.CONFIG_GUI)
public class ViesisGemstones {
	
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final VGTabItems tabVGItems = new VGTabItems("tabVGItems");
	public static final VGTabBlocks tabVGBlocks = new VGTabBlocks("tabVGBlocks");
	public static final VGTabDyeables tabVGDyeables = new VGTabDyeables("tabVGDyeables");
	public static final VGTabCryptic tabVGCryptic = new VGTabCryptic("tabVGCryptic");
	
	private static File configDir;
	
	@Mod.Instance(References.MOD_ID)
	public static ViesisGemstones instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + References.MOD_ID);
		configDir.mkdirs();
		ViesisGemstonesConfig.init(new File(configDir.getPath(), References.MOD_ID + ".cfg"));
		
		this.proxy.preInit(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("        Pre Init Complete.        ");
		LogHelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.proxy.init(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("          Init Complete.          ");
		LogHelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
		LogHelper.info("<<==============================>>");
		LogHelper.info("        Post Init Complete.       ");
		LogHelper.info("<<==============================>>");
	}
}
