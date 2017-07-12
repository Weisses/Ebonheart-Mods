package com.viesis.viescraft.client.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.tileentity.model.ModelAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderAirshipWorkbench extends TileEntitySpecialRenderer<TileEntityAirshipWorkbench> {
	
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private ModelAirshipWorkbench model;
	
	public RenderAirshipWorkbench() 
	{
		this.model = new ModelAirshipWorkbench();
	}
	
	@Override
	public void render(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	//public void renderTileEntityAt(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage) 
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
