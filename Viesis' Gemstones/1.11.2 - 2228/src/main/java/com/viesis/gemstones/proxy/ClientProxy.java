package com.viesis.gemstones.proxy;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.client.InitBlocksVGRender;
import com.viesis.gemstones.client.InitEntityVGRender;
import com.viesis.gemstones.client.InitItemsVGRender;
import com.viesis.gemstones.client.InitSoundEventsVG;
import com.viesis.gemstones.client.InitTileEntityVGRender;
import com.viesis.gemstones.client.ModColourManager;
import com.viesis.gemstones.client.tileentity.RenderGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		InitSoundEventsVG.registerSounds();
		InitItemsVGRender.registerItemRender();
		InitBlocksVGRender.registerBlockRender();
		InitEntityVGRender.registerEntityRender();
		InitTileEntityVGRender.registerTileEntityRender();
		
		OBJLoader.INSTANCE.addDomain(References.MOD_ID);
		
		
		
		//Item item2 = Item.getItemFromBlock(TileEntityGemstoneWorkbench.instance);
        //ModelLoader.setCustomModelResourceLocation(item2, 0, new ModelResourceLocation(References.MOD_ID + ":" + TileEntityGemstoneWorkbench.name, "inventory"));

		//Keybinds.init();
		//NetworkHandler.preInitClient();
		//InitItemsEARender.registerItemRenderTEMP();
		//InitBlocksEARender.registerBlockRenderTEMP();
		//InitEntityEARender.registerEntityRenderTEMP();
		//InitTileEntityEARender.registerTileEntityRenderTEMP();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		//ModColourManager.registerColourHandlers();
		
		//MinecraftForge.EVENT_BUS.register(new GuiAirshipHUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
}
