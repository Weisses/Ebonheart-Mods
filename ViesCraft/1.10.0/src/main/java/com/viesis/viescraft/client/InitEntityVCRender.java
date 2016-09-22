package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipAdmin;
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
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2Admin;
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
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Admin;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Black;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Blue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Brown;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Cyan;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Gray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Green;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3LightBlue;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3LightGray;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Lime;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Magenta;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Normal;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Orange;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Pink;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Purple;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Red;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3White;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3Yellow;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipAdmin;
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
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2Admin;
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
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Admin;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Black;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Blue;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Brown;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Cyan;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Gray;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Green;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3LightBlue;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3LightGray;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Lime;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Magenta;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Normal;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Orange;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Pink;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Purple;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Red;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3White;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3Yellow;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1Admin;
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
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2Admin;
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
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Admin;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Black;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Blue;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Brown;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Cyan;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Gray;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Green;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3LightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3LightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Lime;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Magenta;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Normal;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Orange;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Pink;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Purple;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Red;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3White;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3Yellow;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1Admin;
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
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Admin;
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
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Admin;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Black;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Blue;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Brown;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Cyan;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Gray;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Green;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3LightBlue;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3LightGray;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Lime;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Magenta;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Normal;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Orange;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Pink;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Purple;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Red;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3White;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3Yellow;

public final class InitEntityVCRender extends ItemsVC {
	
	public static RenderManager VCRender = Minecraft.getMinecraft().getRenderManager(); 
	
	public static void registerRenders()
	{
		registerRender(EntityItemAirshipV1Normal.class,  new RenderItemAirshipNormal(VCRender));
		registerRender(EntityItemAirshipV1Black.class,  new RenderItemAirshipBlack(VCRender));
		registerRender(EntityItemAirshipV1Blue.class,  new RenderItemAirshipBlue(VCRender));
		registerRender(EntityItemAirshipV1Brown.class,  new RenderItemAirshipBrown(VCRender));
		registerRender(EntityItemAirshipV1Cyan.class,  new RenderItemAirshipCyan(VCRender));
		registerRender(EntityItemAirshipV1Gray.class,  new RenderItemAirshipGray(VCRender));
		registerRender(EntityItemAirshipV1Green.class,  new RenderItemAirshipGreen(VCRender));
		registerRender(EntityItemAirshipV1LightBlue.class,  new RenderItemAirshipLightBlue(VCRender));
		registerRender(EntityItemAirshipV1LightGray.class,  new RenderItemAirshipLightGray(VCRender));
		registerRender(EntityItemAirshipV1Lime.class,  new RenderItemAirshipLime(VCRender));
		registerRender(EntityItemAirshipV1Magenta.class,  new RenderItemAirshipMagenta(VCRender));
		registerRender(EntityItemAirshipV1Orange.class,  new RenderItemAirshipOrange(VCRender));
		registerRender(EntityItemAirshipV1Pink.class,  new RenderItemAirshipPink(VCRender));
		registerRender(EntityItemAirshipV1Purple.class,  new RenderItemAirshipPurple(VCRender));
		registerRender(EntityItemAirshipV1Red.class,  new RenderItemAirshipRed(VCRender));
		registerRender(EntityItemAirshipV1White.class,  new RenderItemAirshipWhite(VCRender));
		registerRender(EntityItemAirshipV1Yellow.class,  new RenderItemAirshipYellow(VCRender));
		registerRender(EntityItemAirshipV1Admin.class,  new RenderItemAirshipAdmin(VCRender));
		
		registerRender(EntityItemAirshipV2Normal.class,  new RenderItemAirshipV2Normal(VCRender));
		registerRender(EntityItemAirshipV2Black.class,  new RenderItemAirshipV2Black(VCRender));
		registerRender(EntityItemAirshipV2Blue.class,  new RenderItemAirshipV2Blue(VCRender));
		registerRender(EntityItemAirshipV2Brown.class,  new RenderItemAirshipV2Brown(VCRender));
		registerRender(EntityItemAirshipV2Cyan.class,  new RenderItemAirshipV2Cyan(VCRender));
		registerRender(EntityItemAirshipV2Gray.class,  new RenderItemAirshipV2Gray(VCRender));
		registerRender(EntityItemAirshipV2Green.class,  new RenderItemAirshipV2Green(VCRender));
		registerRender(EntityItemAirshipV2LightBlue.class,  new RenderItemAirshipV2LightBlue(VCRender));
		registerRender(EntityItemAirshipV2LightGray.class,  new RenderItemAirshipV2LightGray(VCRender));
		registerRender(EntityItemAirshipV2Lime.class,  new RenderItemAirshipV2Lime(VCRender));
		registerRender(EntityItemAirshipV2Magenta.class,  new RenderItemAirshipV2Magenta(VCRender));
		registerRender(EntityItemAirshipV2Orange.class,  new RenderItemAirshipV2Orange(VCRender));
		registerRender(EntityItemAirshipV2Pink.class,  new RenderItemAirshipV2Pink(VCRender));
		registerRender(EntityItemAirshipV2Purple.class,  new RenderItemAirshipV2Purple(VCRender));
		registerRender(EntityItemAirshipV2Red.class,  new RenderItemAirshipV2Red(VCRender));
		registerRender(EntityItemAirshipV2White.class,  new RenderItemAirshipV2White(VCRender));
		registerRender(EntityItemAirshipV2Yellow.class,  new RenderItemAirshipV2Yellow(VCRender));
		registerRender(EntityItemAirshipV2Admin.class,  new RenderItemAirshipV2Admin(VCRender));
		
		registerRender(EntityItemAirshipV3Normal.class,  new RenderItemAirshipV3Normal(VCRender));
		registerRender(EntityItemAirshipV3Black.class,  new RenderItemAirshipV3Black(VCRender));
		registerRender(EntityItemAirshipV3Blue.class,  new RenderItemAirshipV3Blue(VCRender));
		registerRender(EntityItemAirshipV3Brown.class,  new RenderItemAirshipV3Brown(VCRender));
		registerRender(EntityItemAirshipV3Cyan.class,  new RenderItemAirshipV3Cyan(VCRender));
		registerRender(EntityItemAirshipV3Gray.class,  new RenderItemAirshipV3Gray(VCRender));
		registerRender(EntityItemAirshipV3Green.class,  new RenderItemAirshipV3Green(VCRender));
		registerRender(EntityItemAirshipV3LightBlue.class,  new RenderItemAirshipV3LightBlue(VCRender));
		registerRender(EntityItemAirshipV3LightGray.class,  new RenderItemAirshipV3LightGray(VCRender));
		registerRender(EntityItemAirshipV3Lime.class,  new RenderItemAirshipV3Lime(VCRender));
		registerRender(EntityItemAirshipV3Magenta.class,  new RenderItemAirshipV3Magenta(VCRender));
		registerRender(EntityItemAirshipV3Orange.class,  new RenderItemAirshipV3Orange(VCRender));
		registerRender(EntityItemAirshipV3Pink.class,  new RenderItemAirshipV3Pink(VCRender));
		registerRender(EntityItemAirshipV3Purple.class,  new RenderItemAirshipV3Purple(VCRender));
		registerRender(EntityItemAirshipV3Red.class,  new RenderItemAirshipV3Red(VCRender));
		registerRender(EntityItemAirshipV3White.class,  new RenderItemAirshipV3White(VCRender));
		registerRender(EntityItemAirshipV3Yellow.class,  new RenderItemAirshipV3Yellow(VCRender));
		registerRender(EntityItemAirshipV3Admin.class,  new RenderItemAirshipV3Admin(VCRender));
		
		//===========================================================================
		
		registerRender(EntityAirshipV1Normal.class,  new RenderAirshipNormal(VCRender));
		registerRender(EntityAirshipV1Black.class,  new RenderAirshipBlack(VCRender));
		registerRender(EntityAirshipV1Blue.class,  new RenderAirshipBlue(VCRender));
		registerRender(EntityAirshipV1Brown.class,  new RenderAirshipBrown(VCRender));
		registerRender(EntityAirshipV1Cyan.class,  new RenderAirshipCyan(VCRender));
		registerRender(EntityAirshipV1Gray.class,  new RenderAirshipGray(VCRender));
		registerRender(EntityAirshipV1Green.class,  new RenderAirshipGreen(VCRender));
		registerRender(EntityAirshipV1LightBlue.class,  new RenderAirshipLightBlue(VCRender));
		registerRender(EntityAirshipV1LightGray.class,  new RenderAirshipLightGray(VCRender));
		registerRender(EntityAirshipV1Lime.class,  new RenderAirshipLime(VCRender));
		registerRender(EntityAirshipV1Magenta.class,  new RenderAirshipMagenta(VCRender));
		registerRender(EntityAirshipV1Orange.class,  new RenderAirshipOrange(VCRender));
		registerRender(EntityAirshipV1Pink.class,  new RenderAirshipPink(VCRender));
		registerRender(EntityAirshipV1Purple.class,  new RenderAirshipPurple(VCRender));
		registerRender(EntityAirshipV1Red.class,  new RenderAirshipRed(VCRender));
		registerRender(EntityAirshipV1White.class,  new RenderAirshipWhite(VCRender));
		registerRender(EntityAirshipV1Yellow.class,  new RenderAirshipYellow(VCRender));
		registerRender(EntityAirshipV1Admin.class,  new RenderAirshipAdmin(VCRender));
		
		registerRender(EntityAirshipV2Normal.class,  new RenderAirshipV2Normal(VCRender));
		registerRender(EntityAirshipV2Black.class,  new RenderAirshipV2Black(VCRender));
		registerRender(EntityAirshipV2Blue.class,  new RenderAirshipV2Blue(VCRender));
		registerRender(EntityAirshipV2Brown.class,  new RenderAirshipV2Brown(VCRender));
		registerRender(EntityAirshipV2Cyan.class,  new RenderAirshipV2Cyan(VCRender));
		registerRender(EntityAirshipV2Gray.class,  new RenderAirshipV2Gray(VCRender));
		registerRender(EntityAirshipV2Green.class,  new RenderAirshipV2Green(VCRender));
		registerRender(EntityAirshipV2LightBlue.class,  new RenderAirshipV2LightBlue(VCRender));
		registerRender(EntityAirshipV2LightGray.class,  new RenderAirshipV2LightGray(VCRender));
		registerRender(EntityAirshipV2Lime.class,  new RenderAirshipV2Lime(VCRender));
		registerRender(EntityAirshipV2Magenta.class,  new RenderAirshipV2Magenta(VCRender));
		registerRender(EntityAirshipV2Orange.class,  new RenderAirshipV2Orange(VCRender));
		registerRender(EntityAirshipV2Pink.class,  new RenderAirshipV2Pink(VCRender));
		registerRender(EntityAirshipV2Purple.class,  new RenderAirshipV2Purple(VCRender));
		registerRender(EntityAirshipV2Red.class,  new RenderAirshipV2Red(VCRender));
		registerRender(EntityAirshipV2White.class,  new RenderAirshipV2White(VCRender));
		registerRender(EntityAirshipV2Yellow.class,  new RenderAirshipV2Yellow(VCRender));
		registerRender(EntityAirshipV2Admin.class,  new RenderAirshipV2Admin(VCRender));
		
		registerRender(EntityAirshipV3Normal.class,  new RenderAirshipV3Normal(VCRender));
		registerRender(EntityAirshipV3Black.class,  new RenderAirshipV3Black(VCRender));
		registerRender(EntityAirshipV3Blue.class,  new RenderAirshipV3Blue(VCRender));
		registerRender(EntityAirshipV3Brown.class,  new RenderAirshipV3Brown(VCRender));
		registerRender(EntityAirshipV3Cyan.class,  new RenderAirshipV3Cyan(VCRender));
		registerRender(EntityAirshipV3Gray.class,  new RenderAirshipV3Gray(VCRender));
		registerRender(EntityAirshipV3Green.class,  new RenderAirshipV3Green(VCRender));
		registerRender(EntityAirshipV3LightBlue.class,  new RenderAirshipV3LightBlue(VCRender));
		registerRender(EntityAirshipV3LightGray.class,  new RenderAirshipV3LightGray(VCRender));
		registerRender(EntityAirshipV3Lime.class,  new RenderAirshipV3Lime(VCRender));
		registerRender(EntityAirshipV3Magenta.class,  new RenderAirshipV3Magenta(VCRender));
		registerRender(EntityAirshipV3Orange.class,  new RenderAirshipV3Orange(VCRender));
		registerRender(EntityAirshipV3Pink.class,  new RenderAirshipV3Pink(VCRender));
		registerRender(EntityAirshipV3Purple.class,  new RenderAirshipV3Purple(VCRender));
		registerRender(EntityAirshipV3Red.class,  new RenderAirshipV3Red(VCRender));
		registerRender(EntityAirshipV3White.class,  new RenderAirshipV3White(VCRender));
		registerRender(EntityAirshipV3Yellow.class,  new RenderAirshipV3Yellow(VCRender));
		registerRender(EntityAirshipV3Admin.class,  new RenderAirshipV3Admin(VCRender));
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn, Render<? extends Entity> renderItem)
	{
		RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
}
