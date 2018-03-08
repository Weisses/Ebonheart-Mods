package com.viesis.viescraft;

import java.io.File;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.creative.VCTabBlocks;
import com.viesis.viescraft.api.creative.VCTabItems;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.proxy.CommonProxy;

@Mod(modid = References.MOD_ID, name = References.MOD_NAME, version = References.MOD_VERSION, guiFactory = References.CONFIG_GUI)
public class ViesCraft {
    
    @SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final VCTabItems tabViesCraftItems = new VCTabItems("tabViesCraftItems");
	public static final VCTabBlocks tabViesCraftBlocks = new VCTabBlocks("tabViesCraftBlocks");
	
	private static File configDir;
	
	@Mod.Instance(References.MOD_ID)
	public static ViesCraft instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + References.MOD_ID);
		configDir.mkdirs();
		ViesCraftConfig.init(new File(configDir.getPath(), References.MOD_ID + ".cfg"));
		
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
		LogHelper.info("   Enforcing Brannigan's Law...   ");
		LogHelper.info("<<==============================>>");
	}
}
