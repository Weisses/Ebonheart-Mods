package com.viesis.viescraft.client.entity.model.v4;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV4Color extends ModelBase {
	
	//fields
	ModelRenderer BaseWoodChest;
	ModelRenderer BaseWoodFloor;
	ModelRenderer BalloonRTFin1;
	ModelRenderer BalloonRTFin2;
	ModelRenderer BaseRBFin1;
	ModelRenderer RopeR;
	ModelRenderer BalloonLTFin1;
	ModelRenderer BalloonLTFin2;
	ModelRenderer BaseLBFin1;
	ModelRenderer RopeL;
	ModelRenderer Balloon1;
	ModelRenderer Balloon2;
	ModelRenderer Balloon3;
	
	public ModelAirshipV4Color()
	{
		textureWidth = 256;
		textureHeight = 128;
		
		BaseWoodChest = new ModelRenderer(this, 196, 24);
		BaseWoodChest.addBox(0F, 0F, 0F, 10, 2, 8);
		BaseWoodChest.setRotationPoint(-5F, 4F, 3F);
		BaseWoodChest.setTextureSize(256, 128);
		BaseWoodChest.mirror = true;
		setRotation(BaseWoodChest, 0F, 0F, 0F);
		BaseWoodFloor = new ModelRenderer(this, 180, 0);
		BaseWoodFloor.addBox(0F, 0F, 0F, 14, 0, 24);
		BaseWoodFloor.setRotationPoint(-7F, 5F, -12F);
		BaseWoodFloor.setTextureSize(256, 128);
		BaseWoodFloor.mirror = true;
		setRotation(BaseWoodFloor, 0F, 0F, 0F);
		BalloonRTFin1 = new ModelRenderer(this, 190, 102);
		BalloonRTFin1.addBox(0F, 0F, -13F, 20, 0, 26);
		BalloonRTFin1.setRotationPoint(15F, -33F, 1F);
		BalloonRTFin1.setTextureSize(256, 128);
		BalloonRTFin1.mirror = true;
		setRotation(BalloonRTFin1, 0F, 0F, -0.7853982F);
		BalloonRTFin2 = new ModelRenderer(this, 229, 63);
		BalloonRTFin2.addBox(0F, 0F, -5F, 8, 0, 11);
		BalloonRTFin2.setRotationPoint(8F, -44F, 7F);
		BalloonRTFin2.setTextureSize(256, 128);
		BalloonRTFin2.mirror = true;
		setRotation(BalloonRTFin2, 0F, 0F, -0.6108652F);
		BaseRBFin1 = new ModelRenderer(this, 229, 63);
		BaseRBFin1.addBox(0F, 0F, -5F, 8, 0, 11);
		BaseRBFin1.setRotationPoint(9F, 0F, 0F);
		BaseRBFin1.setTextureSize(256, 128);
		BaseRBFin1.mirror = true;
		setRotation(BaseRBFin1, 0F, 0F, 0.6108652F);
		RopeR = new ModelRenderer(this, 76, 0);
		RopeR.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeR.setRotationPoint(12F, -21F, -13F);
		RopeR.setTextureSize(256, 128);
		RopeR.mirror = true;
		setRotation(RopeR, 0.1570796F, 0F, 0.1745329F);
		BalloonLTFin1 = new ModelRenderer(this, 190, 76);
		BalloonLTFin1.addBox(-20F, 0F, -13F, 20, 0, 26);
		BalloonLTFin1.setRotationPoint(-15F, -33F, 1F);
		BalloonLTFin1.setTextureSize(256, 128);
		BalloonLTFin1.mirror = true;
		setRotation(BalloonLTFin1, 0F, 0F, 0.7853982F);
		BalloonLTFin2 = new ModelRenderer(this, 229, 52);
		BalloonLTFin2.addBox(-8F, 0F, -5F, 8, 0, 11);
		BalloonLTFin2.setRotationPoint(-8F, -44F, 7F);
		BalloonLTFin2.setTextureSize(256, 128);
		BalloonLTFin2.mirror = true;
		setRotation(BalloonLTFin2, 0F, 0F, 0.6108652F);
		BaseLBFin1 = new ModelRenderer(this, 229, 52);
		BaseLBFin1.addBox(-8F, 0F, -5F, 8, 0, 11);
		BaseLBFin1.setRotationPoint(-9F, 0F, 0F);
		BaseLBFin1.setTextureSize(256, 128);
		BaseLBFin1.mirror = true;
		setRotation(BaseLBFin1, 0F, 0F, -0.6108652F);
		RopeL = new ModelRenderer(this, 80, 0);
		RopeL.addBox(0F, 0F, 0F, 1, 23, 1);
		RopeL.setRotationPoint(-13F, -21F, -13F);
		RopeL.setTextureSize(256, 128);
		RopeL.mirror = true;
		setRotation(RopeL, 0.1570796F, 0F, -0.1745329F);
		Balloon1 = new ModelRenderer(this, 0, 0);
		Balloon1.addBox(0F, 0F, 0F, 30, 24, 30);
		Balloon1.setRotationPoint(-15F, -44F, -15F);
		Balloon1.setTextureSize(256, 128);
		Balloon1.mirror = true;
		setRotation(Balloon1, 0F, 0F, 0F);
		Balloon2 = new ModelRenderer(this, 0, 54);
		Balloon2.addBox(0F, 0F, 0F, 26, 22, 36);
		Balloon2.setRotationPoint(-13F, -43F, -18F);
		Balloon2.setTextureSize(256, 128);
		Balloon2.mirror = true;
		setRotation(Balloon2, 0F, 0F, 0F);
		Balloon3 = new ModelRenderer(this, 34, 16);
		Balloon3.addBox(0F, 0F, 0F, 24, 20, 40);
		Balloon3.setRotationPoint(-12F, -42F, -20F);
		Balloon3.setTextureSize(256, 128);
		Balloon3.mirror = true;
		setRotation(Balloon3, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		BaseWoodChest.render(f5);
		BaseWoodFloor.render(f5);
		BalloonRTFin1.render(f5);
		BalloonRTFin2.render(f5);
		BaseRBFin1.render(f5);
		RopeR.render(f5);
		BalloonLTFin1.render(f5);
		BalloonLTFin2.render(f5);
		BaseLBFin1.render(f5);
		RopeL.render(f5);
		Balloon1.render(f5);
		Balloon2.render(f5);
		Balloon3.render(f5);
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
