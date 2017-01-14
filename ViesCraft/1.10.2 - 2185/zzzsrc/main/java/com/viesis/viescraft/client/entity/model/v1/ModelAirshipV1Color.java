package com.viesis.viescraft.client.entity.model.v1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV1Color extends ModelBase {
	
	//fields
	ModelRenderer Balloon1;
	ModelRenderer Balloon2;
	ModelRenderer Balloon3;
	ModelRenderer RopeFL;
	ModelRenderer RopeFR;
	ModelRenderer RopeBL;
	ModelRenderer RopeBR;
	ModelRenderer BaseWoodFloor;
	ModelRenderer BaseWoodChest;
	
	public ModelAirshipV1Color()
	{
		textureWidth = 256;
		textureHeight = 128;
		
		Balloon1 = new ModelRenderer(this, 0, 0);
		Balloon1.addBox(0F, 0F, 0F, 32, 32, 32);
		Balloon1.setRotationPoint(-16F, -52F, -16F);
		Balloon1.setTextureSize(256, 128);
		Balloon1.mirror = true;
		setRotation(Balloon1, 0F, 0F, 0F);
		Balloon2 = new ModelRenderer(this, 0, 0);
		Balloon2.addBox(0F, 0F, 0F, 30, 30, 38);
		Balloon2.setRotationPoint(-15F, -51F, -19F);
		Balloon2.setTextureSize(256, 128);
		Balloon2.mirror = true;
		setRotation(Balloon2, 0F, 0F, 0F);
		Balloon3 = new ModelRenderer(this, 0, 0);
		Balloon3.addBox(0F, 0F, 0F, 26, 26, 44);
		Balloon3.setRotationPoint(-13F, -49F, -22F);
		Balloon3.setTextureSize(256, 128);
		Balloon3.mirror = true;
		setRotation(Balloon3, 0F, 0F, 0F);
		RopeFL = new ModelRenderer(this, 0, 0);
		RopeFL.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeFL.setRotationPoint(12F, -21F, -13F);
		RopeFL.setTextureSize(256, 128);
		RopeFL.mirror = true;
		setRotation(RopeFL, 0.1570796F, 0F, 0.1745329F);
		RopeFR = new ModelRenderer(this, 12, 0);
		RopeFR.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeFR.setRotationPoint(-13F, -21F, -13F);
		RopeFR.setTextureSize(256, 128);
		RopeFR.mirror = true;
		setRotation(RopeFR, 0.1570796F, 0F, -0.1745329F);
		RopeBL = new ModelRenderer(this, 4, 0);
		RopeBL.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeBL.setRotationPoint(12F, -21F, 12F);
		RopeBL.setTextureSize(256, 128);
		RopeBL.mirror = true;
		setRotation(RopeBL, -0.1570796F, 0F, 0.1745329F);
		RopeBR = new ModelRenderer(this, 8, 0);
		RopeBR.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeBR.setRotationPoint(-13F, -21F, 12F);
		RopeBR.setTextureSize(256, 128);
		RopeBR.mirror = true;
		setRotation(RopeBR, -0.1570796F, 0F, -0.1745329F);
		BaseWoodFloor = new ModelRenderer(this, 180, 0);
		BaseWoodFloor.addBox(0F, 0F, 0F, 14, 0, 24);
		BaseWoodFloor.setRotationPoint(-7F, 5F, -12F);
		BaseWoodFloor.setTextureSize(256, 128);
		BaseWoodFloor.mirror = true;
		setRotation(BaseWoodFloor, 0F, 0F, 0F);
		BaseWoodChest = new ModelRenderer(this, 196, 24);
		BaseWoodChest.addBox(0F, 0F, 0F, 10, 2, 8);
		BaseWoodChest.setRotationPoint(-5F, 4F, 3F);
		BaseWoodChest.setTextureSize(256, 128);
		BaseWoodChest.mirror = true;
		setRotation(BaseWoodChest, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Balloon1.render(f5);
		Balloon2.render(f5);
		Balloon3.render(f5);
		RopeFL.render(f5);
		RopeFR.render(f5);
		RopeBL.render(f5);
		RopeBR.render(f5);
		BaseWoodFloor.render(f5);
		BaseWoodChest.render(f5);
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
