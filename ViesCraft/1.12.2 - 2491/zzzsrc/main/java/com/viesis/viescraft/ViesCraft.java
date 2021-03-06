package com.viesis.viescraft;

import java.io.File;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.creative.VCTabAirshipsV1;
import com.viesis.viescraft.api.creative.VCTabAirshipsV2;
import com.viesis.viescraft.api.creative.VCTabAirshipsV3;
import com.viesis.viescraft.api.creative.VCTabAirshipsV4;
import com.viesis.viescraft.api.creative.VCTabAirshipsV5;
import com.viesis.viescraft.api.creative.VCTabAirshipsV6;
import com.viesis.viescraft.api.creative.VCTabBlocks;
import com.viesis.viescraft.api.creative.VCTabItems;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, guiFactory = Reference.CONFIG_GUI)
public class ViesCraft {
	
	@Mod.Instance(Reference.MOD_ID)
	public static ViesCraft instance;
	
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final VCTabBlocks tabViesCraftBlocks = new VCTabBlocks("tabViesCraftBlocks");
	public static final VCTabItems tabViesCraftItems = new VCTabItems("tabViesCraftItems");
	public static final VCTabAirshipsV1 tabViesCraftAirshipsV1 = new VCTabAirshipsV1("tabViesCraftAirshipsV1");
	public static final VCTabAirshipsV2 tabViesCraftAirshipsV2 = new VCTabAirshipsV2("tabViesCraftAirshipsV2");
	public static final VCTabAirshipsV3 tabViesCraftAirshipsV3 = new VCTabAirshipsV3("tabViesCraftAirshipsV3");
	public static final VCTabAirshipsV4 tabViesCraftAirshipsV4 = new VCTabAirshipsV4("tabViesCraftAirshipsV4");
	public static final VCTabAirshipsV5 tabViesCraftAirshipsV5 = new VCTabAirshipsV5("tabViesCraftAirshipsV5");
	public static final VCTabAirshipsV6 tabViesCraftAirshipsV6 = new VCTabAirshipsV6("tabViesCraftAirshipsV6");
	
	private static File configDir;
	
	public static boolean isViesisGemstonesModLoaded;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		configDir = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		configDir.mkdirs();
		ViesCraftConfig.init(new File(configDir.getPath(), Reference.MOD_ID + ".cfg"));
		
		isViesisGemstonesModLoaded = Loader.isModLoaded("vg");
		
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
