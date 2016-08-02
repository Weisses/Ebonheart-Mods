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
import com.viesis.viescraft.client.entity.render.old.RenderAirshipBase;
import com.viesis.viescraft.client.entity.render.old.RenderAirshipBase2;
import com.viesis.viescraft.client.projectile.RenderItemAirshipBlack;
import com.viesis.viescraft.client.projectile.RenderItemAirshipBlue;
import com.viesis.viescraft.client.projectile.RenderItemAirshipBrown;
import com.viesis.viescraft.client.projectile.RenderItemAirshipCyan;
import com.viesis.viescraft.client.projectile.RenderItemAirshipGray;
import com.viesis.viescraft.client.projectile.RenderItemAirshipGreen;
import com.viesis.viescraft.client.projectile.RenderItemAirshipLightBlue;
import com.viesis.viescraft.client.projectile.RenderItemAirshipLightGray;
import com.viesis.viescraft.client.projectile.RenderItemAirshipLime;
import com.viesis.viescraft.client.projectile.RenderItemAirshipMagenta;
import com.viesis.viescraft.client.projectile.RenderItemAirshipNormal;
import com.viesis.viescraft.client.projectile.RenderItemAirshipOrange;
import com.viesis.viescraft.client.projectile.RenderItemAirshipPink;
import com.viesis.viescraft.client.projectile.RenderItemAirshipPurple;
import com.viesis.viescraft.client.projectile.RenderItemAirshipRed;
import com.viesis.viescraft.client.projectile.RenderItemAirshipWhite;
import com.viesis.viescraft.client.projectile.RenderItemAirshipYellow;
import com.viesis.viescraft.client.projectile.old.RenderItemAirship;
import com.viesis.viescraft.client.projectile.old.RenderItemAirshipV2;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipYellow;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBlack;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBlue;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBrown;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCyan;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipGray;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipGreen;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipLime;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipNormal;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipOrange;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipPink;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipPurple;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipRed;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipWhite;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipYellow;
import com.viesis.viescraft.common.entity.old.EntityAirshipBase;
import com.viesis.viescraft.common.entity.old.EntityAirshipBase2;
import com.viesis.viescraft.common.entity.old.EntityItemAirship;
import com.viesis.viescraft.common.entity.old.EntityItemAirshipV2;



public final class InitEntityVCRender extends ItemsVC {
	
	public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	 //public static ModelHorse test1 = new ModelHorse();
	 
	 //public static ModelAirshipBase test = new ModelAirshipBase();
	
	public static void registerRenders()
	{
		registerRender(EntityItemAirship.class,  new RenderItemAirship(EARender));
		registerRender(EntityItemAirshipV2.class,  new RenderItemAirshipV2(EARender));
		
		registerRender(EntityAirshipBase.class,  new RenderAirshipBase(EARender));
		registerRender(EntityAirshipBase2.class,  new RenderAirshipBase2(EARender));
		
		
		//===========================================================================
		
		
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
