package com.viesis.viescraft.client.entity.model.v3;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV3Balloon extends ModelBase {
	
	//fields
	ModelRenderer BaseWoodFloor;
	ModelRenderer BaseWoodChest;
	ModelRenderer BalloonTR1;
	ModelRenderer BalloonTL1;
	ModelRenderer BalloonBL1;
	ModelRenderer BalloonBL2;
	ModelRenderer BalloonBR1;
	ModelRenderer BalloonBR2;
	
	public ModelAirshipV3Balloon()
	{
		textureWidth = 512;
		textureHeight = 256;
		
		BaseWoodFloor = new ModelRenderer(this, 436, 0);
	    BaseWoodFloor.addBox(0F, 0F, 0F, 14, 0, 24);
	    BaseWoodFloor.setRotationPoint(-7F, 5F, -12F);
	    BaseWoodFloor.setTextureSize(512, 256);
	    BaseWoodFloor.mirror = true;
	    setRotation(BaseWoodFloor, 0F, 0F, 0F);
	    BaseWoodChest = new ModelRenderer(this, 452, 24);
	    BaseWoodChest.addBox(0F, 0F, 0F, 10, 2, 8);
	    BaseWoodChest.setRotationPoint(-5F, 4F, 3F);
	    BaseWoodChest.setTextureSize(512, 256);
	    BaseWoodChest.mirror = true;
	    setRotation(BaseWoodChest, 0F, 0F, 0F);
	    BalloonTR1 = new ModelRenderer(this, 115, 192);
	    BalloonTR1.addBox(0F, 0F, 0F, 8, 8, 27);
	    BalloonTR1.setRotationPoint(-21F, -14F, -10F);
	    BalloonTR1.setTextureSize(512, 256);
	    BalloonTR1.mirror = true;
	    setRotation(BalloonTR1, 0F, 0F, 0F);
	    BalloonTL1 = new ModelRenderer(this, 115, 192);
	    BalloonTL1.addBox(0F, 0F, 0F, 8, 8, 27);
	    BalloonTL1.setRotationPoint(13F, -14F, -10F);
	    BalloonTL1.setTextureSize(512, 256);
	    BalloonTL1.mirror = true;
	    setRotation(BalloonTL1, 0F, 0F, 0F);
	    BalloonBL1 = new ModelRenderer(this, 0, 132);
	    BalloonBL1.addBox(0F, 0F, 0F, 6, 6, 16);
	    BalloonBL1.setRotationPoint(14F, -2F, -2F);
	    BalloonBL1.setTextureSize(512, 256);
	    BalloonBL1.mirror = true;
	    setRotation(BalloonBL1, 0F, 0F, 0F);
	    BalloonBL2 = new ModelRenderer(this, 0, 154);
	    BalloonBL2.addBox(0F, 0F, 0F, 4, 4, 16);
	    BalloonBL2.setRotationPoint(15F, -1F, -3F);
	    BalloonBL2.setTextureSize(512, 256);
	    BalloonBL2.mirror = true;
	    setRotation(BalloonBL2, 0F, 0F, 0F);
	    BalloonBR1 = new ModelRenderer(this, 0, 132);
	    BalloonBR1.addBox(0F, 0F, 0F, 6, 6, 16);
	    BalloonBR1.setRotationPoint(-20F, -2F, -2F);
	    BalloonBR1.setTextureSize(512, 256);
	    BalloonBR1.mirror = true;
	    setRotation(BalloonBR1, 0F, 0F, 0F);
	    BalloonBR2 = new ModelRenderer(this, 0, 154);
	    BalloonBR2.addBox(0F, 0F, 0F, 4, 4, 16);
	    BalloonBR2.setRotationPoint(-19F, -1F, -3F);
	    BalloonBR2.setTextureSize(512, 256);
	    BalloonBR2.mirror = true;
	    setRotation(BalloonBR2, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		BaseWoodFloor.render(f5);
		BaseWoodChest.render(f5);
		BalloonTR1.render(f5);
		BalloonTL1.render(f5);
		BalloonBL1.render(f5);
		BalloonBL2.render(f5);
		BalloonBR1.render(f5);
		BalloonBR2.render(f5);
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
