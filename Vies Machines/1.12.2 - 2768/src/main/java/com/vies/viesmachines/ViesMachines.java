package com.vies.viesmachines;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.creative.BlocksTab;
import com.vies.viesmachines.api.creative.ItemsTab;
import com.vies.viesmachines.api.util.Loghelper;
import com.vies.viesmachines.configs.VMConfiguration;
import com.vies.viesmachines.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MOD_ID, 
	 name = References.MOD_NAME, 
	 version = References.VERSION, 
	 guiFactory = References.CONFIG_GUI,
	 acceptedMinecraftVersions = References.ACCEPTED_MINECRAFT_VERSIONS
	 )

public class ViesMachines {
    
	@SidedProxy(clientSide = References.CLIENT_PROXY_CLASS, serverSide = References.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
    
	public static final ItemsTab tabItems = new ItemsTab("tabItems");
	public static final BlocksTab tabBlocks = new BlocksTab("tabBlocks");
	
	@Mod.Instance(References.MOD_ID)
	public static ViesMachines instance;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(instance);
		
		VMConfiguration.load(event);
		
		this.proxy.preInit(event);
		
		Loghelper.info("<<==============================>>");
		Loghelper.info("        Pre-Init Complete.        ");
		Loghelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		this.proxy.init(event);
		
		Loghelper.info("<<==============================>>");
		Loghelper.info("          Init Complete.          ");
		Loghelper.info("<<==============================>>");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		this.proxy.postInit(event);
		
		Loghelper.info("<<==============================>>");
		Loghelper.info("   Enforcing Brannigan's Law...   ");
		Loghelper.info("<<==============================>>");
	}
}
