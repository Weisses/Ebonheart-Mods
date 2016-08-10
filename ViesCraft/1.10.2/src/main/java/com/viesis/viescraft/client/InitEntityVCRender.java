package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipBlack;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipBrown;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipCyan;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipGreen;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipLightBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipLightGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipLime;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipMagenta;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipNormal;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipOrange;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipPink;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipPurple;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipRed;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipWhite;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipYellow;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipBlack;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipBlue;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipBrown;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipCyan;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipGray;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipGreen;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipLightBlue;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipLightGray;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipLime;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipMagenta;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipNormal;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipOrange;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipPink;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipPurple;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipRed;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipWhite;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipYellow;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipYellow;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBlack;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBrown;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipCyan;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipGreen;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipLime;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipNormal;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipOrange;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipPink;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipPurple;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipRed;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipWhite;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipYellow;

public final class InitEntityVCRender extends ItemsVC {
	
	public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	
	public static void registerRenders()
	{
		registerRender(EntityItemAirshipNormal.class,  new RenderItemAirshipNormal(EARender));
		registerRender(EntityItemAirshipBlack.class,  new RenderItemAirshipBlack(EARender));
		registerRender(EntityItemAirshipBlue.class,  new RenderItemAirshipBlue(EARender));
		registerRender(EntityItemAirshipBrown.class,  new RenderItemAirshipBrown(EARender));
		registerRender(EntityItemAirshipCyan.class,  new RenderItemAirshipCyan(EARender));
		registerRender(EntityItemAirshipGray.class,  new RenderItemAirshipGray(EARender));
		registerRender(EntityItemAirshipGreen.class,  new RenderItemAirshipGreen(EARender));
		registerRender(EntityItemAirshipLightBlue.class,  new RenderItemAirshipLightBlue(EARender));
		registerRender(EntityItemAirshipLightGray.class,  new RenderItemAirshipLightGray(EARender));
		registerRender(EntityItemAirshipLime.class,  new RenderItemAirshipLime(EARender));
		registerRender(EntityItemAirshipMagenta.class,  new RenderItemAirshipMagenta(EARender));
		registerRender(EntityItemAirshipOrange.class,  new RenderItemAirshipOrange(EARender));
		registerRender(EntityItemAirshipPink.class,  new RenderItemAirshipPink(EARender));
		registerRender(EntityItemAirshipPurple.class,  new RenderItemAirshipPurple(EARender));
		registerRender(EntityItemAirshipRed.class,  new RenderItemAirshipRed(EARender));
		registerRender(EntityItemAirshipWhite.class,  new RenderItemAirshipWhite(EARender));
		registerRender(EntityItemAirshipYellow.class,  new RenderItemAirshipYellow(EARender));
		
		//===========================================================================
		
		registerRender(EntityAirshipNormal.class,  new RenderAirshipNormal(EARender));
		registerRender(EntityAirshipBlack.class,  new RenderAirshipBlack(EARender));
		registerRender(EntityAirshipBlue.class,  new RenderAirshipBlue(EARender));
		registerRender(EntityAirshipBrown.class,  new RenderAirshipBrown(EARender));
		registerRender(EntityAirshipCyan.class,  new RenderAirshipCyan(EARender));
		registerRender(EntityAirshipGray.class,  new RenderAirshipGray(EARender));
		registerRender(EntityAirshipGreen.class,  new RenderAirshipGreen(EARender));
		registerRender(EntityAirshipLightBlue.class,  new RenderAirshipLightBlue(EARender));
		registerRender(EntityAirshipLightGray.class,  new RenderAirshipLightGray(EARender));
		registerRender(EntityAirshipLime.class,  new RenderAirshipLime(EARender));
		registerRender(EntityAirshipMagenta.class,  new RenderAirshipMagenta(EARender));
		registerRender(EntityAirshipOrange.class,  new RenderAirshipOrange(EARender));
		registerRender(EntityAirshipPink.class,  new RenderAirshipPink(EARender));
		registerRender(EntityAirshipPurple.class,  new RenderAirshipPurple(EARender));
		registerRender(EntityAirshipRed.class,  new RenderAirshipRed(EARender));
		registerRender(EntityAirshipWhite.class,  new RenderAirshipWhite(EARender));
		registerRender(EntityAirshipYellow.class,  new RenderAirshipYellow(EARender));
	}
	
	public static void registerRender(Class<? extends Entity> classIn, Render<? extends Entity> renderItem)
	{
		RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
}
