package com.viesis.gemstones.client.tileentity;

import org.lwjgl.opengl.GL11;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.client.model.ModelGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

public class RenderGemstoneWorkbench extends TileEntitySpecialRenderer<TileEntityGemstoneWorkbench> {
	
	ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private ModelGemstoneWorkbench model;
	
	public RenderGemstoneWorkbench() 
	{
		this.model = new ModelGemstoneWorkbench();
	}
	
	@Override
	public void renderTileEntityAt(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage) 
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
