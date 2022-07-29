package com.viesis.viescraft.client.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.tileentity.model.ModelBatteryCharger;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityBatteryCharger;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderBatteryCharger extends TileEntitySpecialRenderer<TileEntityBatteryCharger> {
	
	ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private ModelBatteryCharger model;
	
	public RenderBatteryCharger() 
	{
		this.model = new ModelBatteryCharger();
	}
	
	@Override
	public void render(TileEntityBatteryCharger te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		
		this.model.renderModel(0.0625f);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
