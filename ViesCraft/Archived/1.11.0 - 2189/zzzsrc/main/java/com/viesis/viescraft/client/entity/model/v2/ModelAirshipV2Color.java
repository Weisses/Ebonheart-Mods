package com.viesis.viescraft.client.entity.model.v2;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV2Color extends ModelBase {
	
	//fields
	ModelRenderer BaseColorFloor;
	ModelRenderer BaseColorChest;
	ModelRenderer BalloonR1a;
	ModelRenderer BalloonR1b;
	ModelRenderer BalloonL1a;
	ModelRenderer BalloonL1b;
	
	public ModelAirshipV2Color()
	{
		textureWidth = 256;
		textureHeight = 128;
		
		BaseColorFloor = new ModelRenderer(this, 180, 0);
		BaseColorFloor.addBox(0F, 0F, 0F, 14, 0, 24);
		BaseColorFloor.setRotationPoint(-7F, 5F, -12F);
		BaseColorFloor.setTextureSize(256, 128);
		BaseColorFloor.mirror = true;
		setRotation(BaseColorFloor, 0F, 0F, 0F);
		BaseColorChest = new ModelRenderer(this, 196, 24);
		BaseColorChest.addBox(0F, 0F, 0F, 10, 2, 8);
		BaseColorChest.setRotationPoint(-5F, 4F, 3F);
		BaseColorChest.setTextureSize(256, 128);
		BaseColorChest.mirror = true;
		setRotation(BaseColorChest, 0F, 0F, 0F);
		BalloonR1a = new ModelRenderer(this, 0, 0);
		BalloonR1a.addBox(0F, 0F, 0F, 8, 8, 27);
		BalloonR1a.setRotationPoint(-21F, -6F, -13F);
		BalloonR1a.setTextureSize(256, 128);
		BalloonR1a.mirror = true;
		setRotation(BalloonR1a, 0F, 0F, 0F);
		BalloonR1b = new ModelRenderer(this, 70, 0);
		BalloonR1b.addBox(0F, 0F, 0F, 10, 10, 25);
		BalloonR1b.setRotationPoint(-22F, -7F, -12F);
		BalloonR1b.setTextureSize(256, 128);
		BalloonR1b.mirror = true;
		setRotation(BalloonR1b, 0F, 0F, 0F);
		BalloonL1a = new ModelRenderer(this, 0, 35);
		BalloonL1a.addBox(0F, 0F, 0F, 8, 8, 27);
		BalloonL1a.setRotationPoint(13F, -6F, -13F);
		BalloonL1a.setTextureSize(256, 128);
		BalloonL1a.mirror = true;
		setRotation(BalloonL1a, 0F, 0F, 0F);
		BalloonL1b = new ModelRenderer(this, 70, 35);
		BalloonL1b.addBox(0F, 0F, 0F, 10, 10, 25);
		BalloonL1b.setRotationPoint(12F, -7F, -12F);
		BalloonL1b.setTextureSize(256, 128);
		BalloonL1b.mirror = true;
		setRotation(BalloonL1b, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		BaseColorFloor.render(f5);
		BaseColorChest.render(f5);
		BalloonR1a.render(f5);
		BalloonR1b.render(f5);
		BalloonL1a.render(f5);
		BalloonL1b.render(f5);
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
