package com.viesis.viescraft.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipBlack;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipBrown;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipCyan;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipGreen;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipLightBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipLightGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipLime;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipMagenta;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipNormal;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipOrange;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipPink;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipPurple;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipRed;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipWhite;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipYellow;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Black;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Blue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Brown;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Cyan;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Gray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Green;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2LightBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2LightGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Lime;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Magenta;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Normal;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Orange;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Pink;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Purple;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Red;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2White;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Yellow;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipBlack;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipBlue;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipBrown;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipCyan;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipGray;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipGreen;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipLightBlue;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipLightGray;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipLime;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipMagenta;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipNormal;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipOrange;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipPink;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipPurple;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipRed;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipWhite;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipYellow;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Black;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Blue;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Brown;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Cyan;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Gray;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Green;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2LightBlue;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2LightGray;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Lime;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Magenta;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Normal;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Orange;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Pink;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Purple;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Red;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2White;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Yellow;
import com.viesis.viescraft.client.tileentity.render.RenderAirshipWorkbench;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Black;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Green;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Red;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1White;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Black;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Green;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Red;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2White;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Black;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Blue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Brown;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Cyan;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Gray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Green;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1LightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1LightGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Lime;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Magenta;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Orange;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Pink;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Purple;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Red;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1White;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Black;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Blue;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Brown;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Cyan;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Gray;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Green;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2LightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2LightGray;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Lime;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Magenta;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Normal;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Orange;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Pink;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Purple;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Red;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2White;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Yellow;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public final class InitTileEntityVCRender //extends ItemsVC 
{
	
	//public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	
	public static void registerRenders()
	{
		registerRender(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		//registerRender(EntityItemAirshipNormal.class,  new RenderItemAirshipNormal(EARender));
		////ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		//	
		//registerRender(BlocksVC.airship_workbench);
	}
	//public static void registerRender(Block block)
	//{
	//	Item item = Item.getItemFromBlock(block);
	//	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	//}
	public static <T extends TileEntity> void registerRender(Class<T> classIn, TileEntitySpecialRenderer<? super T> renderItem)
	{
		//ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		ClientRegistry.bindTileEntitySpecialRenderer(classIn, renderItem);
		//RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
	
	//public static void registerRenders()
	//{
	//	registerRender(BlocksVC.airship_workbench);
	//}
	
	
}
