package com.viesis.viescraft.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipPanel extends ModelBase {
	
	//fields
	ModelRenderer ControlScreen;
	
	public ModelAirshipPanel()
	{
		textureWidth = 6;
		textureHeight = 4;
		
		ControlScreen = new ModelRenderer(this, 0, 0);
	    ControlScreen.addBox(0F, 0F, 0F, 6, 4, 0);
	    ControlScreen.setRotationPoint(-3F, -1F, -15F);
	    ControlScreen.setTextureSize(18, 12);
	    ControlScreen.mirror = true;
	    setRotation(ControlScreen, 0.7853982F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		ControlScreen.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}
}
