package com.viesis.viescraft.client.entity.model.v4;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV4FrameOff extends ModelBase {
	
	//fields
	ModelRenderer BaseWoodChest;
	ModelRenderer BalloonFinR1a;
	ModelRenderer BalloonFinR1b;
	ModelRenderer BalloonFinR1c;
	ModelRenderer BalloonFinR1d;
	ModelRenderer BalloonFinR2a;
	ModelRenderer BalloonFinR2b;
	ModelRenderer BalloonFinR2c;
	ModelRenderer BalloonFinR2d;
	ModelRenderer BalloonFinL1a;
	ModelRenderer BalloonFinL1b;
	ModelRenderer BalloonFinL1c;
	ModelRenderer BalloonFinL1d;
	ModelRenderer BalloonFinL2a;
	ModelRenderer BalloonFinL2b;
	ModelRenderer BalloonFinL2c;
	ModelRenderer BalloonFinL2d;
	ModelRenderer Base_1a;
	ModelRenderer Base_Seat_1b;
	ModelRenderer Base_Side_1a;
	ModelRenderer Base_Side_1b;
	ModelRenderer Base_Side_2a;
	ModelRenderer Base_Side_2b;
	ModelRenderer Anchor_1a;
	ModelRenderer Anchor_1b;
	ModelRenderer Anchor_1c;
	ModelRenderer Anchor_1d;
	ModelRenderer Anchor_2a;
	ModelRenderer Anchor_2b;
	ModelRenderer Anchor_2c;
	ModelRenderer Anchor_2d;
	ModelRenderer Rope_1b;
	ModelRenderer Rope_1c;
	ModelRenderer Base_Front_1a1;
	ModelRenderer Base_Front_1aR;
	ModelRenderer Base_Front_1aL;
	ModelRenderer Base_Front_1aM;
	ModelRenderer Base_Front_1c;
	ModelRenderer Base_Front_2a;
	ModelRenderer Base_Front_2b;
	ModelRenderer Base_Front_2c;
	ModelRenderer Base_Front_2d;
	ModelRenderer Base_Back_1a;
	ModelRenderer Base_Back_1c;
	ModelRenderer Base_Back_2a;
	ModelRenderer Base_Back_2b;
	ModelRenderer Base_Corner_F1;
	ModelRenderer Base_Corner_F2;
	ModelRenderer Base_Corner_B1;
	ModelRenderer Base_Corner_B2;
	ModelRenderer Engine_M1a;
	ModelRenderer Engine_M1b;
	ModelRenderer Engine_M1c;
	ModelRenderer Engine_M1d;
	ModelRenderer Engine_R1;
	ModelRenderer Engine_R2a;
	ModelRenderer Engine_L1;
	ModelRenderer Engine_L2a;
	ModelRenderer Propeller_R1a;
	ModelRenderer Propeller_R1b;
	ModelRenderer Propeller_R1c;
	ModelRenderer Propeller_L1a;
	ModelRenderer Propeller_L1b;
	ModelRenderer Propeller_L1c;
	ModelRenderer BaseFinR1a;
	ModelRenderer BaseFinR1b;
	ModelRenderer BaseFinR1c;
	ModelRenderer BaseFinR1d;
	ModelRenderer BaseFinL1a;
	ModelRenderer BaseFinL1b;
	ModelRenderer BaseFinL1c;
	ModelRenderer BaseFinL1d;
	ModelRenderer EnginePipe_L1a;
	ModelRenderer EnginePipe_L1b;
	ModelRenderer EnginePipe_L1d;
	ModelRenderer EnginePipe_R1a;
	ModelRenderer EnginePipe_R1b;
	ModelRenderer EnginePipe_R1d;
	ModelRenderer BalloonFrameTL1a1;
	ModelRenderer BalloonFrameTL1a2;
	ModelRenderer BalloonFrameTR1b1;
	ModelRenderer BalloonFrameTR1b2;
	ModelRenderer BalloonFrameBL1a1;
	ModelRenderer BalloonFrameBL1a2;
	ModelRenderer BalloonFrameBR1b1;
	ModelRenderer BalloonFrameBR1b2;
	ModelRenderer BalloonFrameTL2a1;
	ModelRenderer BalloonFrameTR2b1;
	ModelRenderer BalloonFrameBL2a1;
	ModelRenderer BalloonFrameBR2b1;
	ModelRenderer BalloonFrameTL3a1;
	ModelRenderer BalloonFrameTR3b1;
	ModelRenderer BalloonFrameBL3a1;
	ModelRenderer BalloonFrameBR3b1;
	ModelRenderer BalloonFrameFa;
	ModelRenderer BalloonFrameFb;
	ModelRenderer BalloonFrameFc;
	ModelRenderer BalloonFrameFd;
	ModelRenderer BalloonFrameBa;
	ModelRenderer BalloonFrameBb;
	ModelRenderer BalloonFrameBc;
	ModelRenderer BalloonFrameBd;
	ModelRenderer BalloonFrameFM;
	ModelRenderer BalloonFrameBM;
    ModelRenderer ControlPanel;
    ModelRenderer ControlBrace;
    ModelRenderer SkidR1;
    ModelRenderer SkidR2;
    ModelRenderer SkidR3;
    ModelRenderer SkidL1;
    ModelRenderer SkidL2;
    ModelRenderer SkidL3;
	
	public ModelAirshipV4FrameOff()
	{
		textureWidth = 256;
		textureHeight = 128;
		
		BaseWoodChest = new ModelRenderer(this, 150, 43);
	    BaseWoodChest.addBox(0F, 0F, 0F, 10, 2, 8);
	    BaseWoodChest.setRotationPoint(-5F, 4F, 3F);
	    BaseWoodChest.setTextureSize(256, 128);
	    BaseWoodChest.mirror = true;
	    setRotation(BaseWoodChest, 0F, 0F, 0F);
	    BalloonFinR1a = new ModelRenderer(this, 0, 56);
		BalloonFinR1a.addBox(0F, -0.5F, -0.5F, 21, 1, 1);
		BalloonFinR1a.setRotationPoint(15F, -33F, 0F);
		BalloonFinR1a.setTextureSize(256, 128);
		BalloonFinR1a.mirror = true;
		setRotation(BalloonFinR1a, 0.7853982F, -0.7853982F, -0.7853982F);
		BalloonFinR1b = new ModelRenderer(this, 0, 53);
		BalloonFinR1b.addBox(0F, -0.5F, -0.5F, 20, 1, 1);
		BalloonFinR1b.setRotationPoint(15F, -33F, 0F);
		BalloonFinR1b.setTextureSize(256, 128);
		BalloonFinR1b.mirror = true;
		setRotation(BalloonFinR1b, 0F, 0F, -0.7853982F);
		BalloonFinR1c = new ModelRenderer(this, 0, 56);
		BalloonFinR1c.addBox(0F, -0.5F, -0.5F, 18, 1, 1);
		BalloonFinR1c.setRotationPoint(15F, -33F, 0F);
		BalloonFinR1c.setTextureSize(256, 128);
		BalloonFinR1c.mirror = true;
		setRotation(BalloonFinR1c, 0.7853982F, 0.7853982F, -0.7853982F);
		BalloonFinR1d = new ModelRenderer(this, 52, 26);
		BalloonFinR1d.addBox(-2F, -2F, -3F, 2, 3, 6);
		BalloonFinR1d.setRotationPoint(16F, -33F, 0F);
		BalloonFinR1d.setTextureSize(256, 128);
		BalloonFinR1d.mirror = true;
		setRotation(BalloonFinR1d, 0F, 0F, 0F);
		BalloonFinR2a = new ModelRenderer(this, 0, 30);
		BalloonFinR2a.addBox(0F, -0.5F, -0.5F, 9, 1, 1);
		BalloonFinR2a.setRotationPoint(8F, -44F, 8F);
		BalloonFinR2a.setTextureSize(256, 128);
		BalloonFinR2a.mirror = true;
		setRotation(BalloonFinR2a, 0.7853982F, -0.6108652F, -0.6108652F);
		BalloonFinR2b = new ModelRenderer(this, 0, 27);
		BalloonFinR2b.addBox(0F, -0.5F, -0.5F, 8, 1, 1);
		BalloonFinR2b.setRotationPoint(8F, -44F, 7F);
		BalloonFinR2b.setTextureSize(256, 128);
		BalloonFinR2b.mirror = true;
		setRotation(BalloonFinR2b, 0F, 0F, -0.6108652F);
		BalloonFinR2c = new ModelRenderer(this, 0, 30);
		BalloonFinR2c.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		BalloonFinR2c.setRotationPoint(8F, -44F, 6F);
		BalloonFinR2c.setTextureSize(256, 128);
		BalloonFinR2c.mirror = true;
		setRotation(BalloonFinR2c, 0.7853982F, 0.6108652F, -0.6108652F);
		BalloonFinR2d = new ModelRenderer(this, 52, 14);
		BalloonFinR2d.addBox(-2F, -2F, -2F, 2, 2, 4);
		BalloonFinR2d.setRotationPoint(8.5F, -43F, 7F);
		BalloonFinR2d.setTextureSize(256, 128);
		BalloonFinR2d.mirror = true;
		setRotation(BalloonFinR2d, 0F, 0F, 0F);
		BalloonFinL1a = new ModelRenderer(this, 0, 56);
		BalloonFinL1a.addBox(-21F, -0.5F, -0.5F, 21, 1, 1);
		BalloonFinL1a.setRotationPoint(-15F, -33F, 0F);
		BalloonFinL1a.setTextureSize(256, 128);
		BalloonFinL1a.mirror = true;
		setRotation(BalloonFinL1a, 0.7853982F, 0.7853982F, 0.7853982F);
		BalloonFinL1b = new ModelRenderer(this, 0, 53);
		BalloonFinL1b.addBox(-20F, -0.5F, -0.5F, 20, 1, 1);
		BalloonFinL1b.setRotationPoint(-15F, -33F, 0F);
		BalloonFinL1b.setTextureSize(256, 128);
		BalloonFinL1b.mirror = true;
		setRotation(BalloonFinL1b, 0F, 0F, 0.7853982F);
		BalloonFinL1c = new ModelRenderer(this, 0, 56);
		BalloonFinL1c.addBox(-18F, -0.5F, -0.5F, 18, 1, 1);
		BalloonFinL1c.setRotationPoint(-15F, -33F, 0F);
		BalloonFinL1c.setTextureSize(256, 128);
		BalloonFinL1c.mirror = true;
		setRotation(BalloonFinL1c, 0.7853982F, -0.7853982F, 0.7853982F);
		BalloonFinL1d = new ModelRenderer(this, 52, 26);
		BalloonFinL1d.addBox(-2F, -2F, -3F, 2, 3, 6);
		BalloonFinL1d.setRotationPoint(-14F, -33F, 0F);
		BalloonFinL1d.setTextureSize(256, 128);
		BalloonFinL1d.mirror = true;
		setRotation(BalloonFinL1d, 0F, 0F, 0F);
		BalloonFinL2a = new ModelRenderer(this, 0, 30);
		BalloonFinL2a.addBox(-7F, -0.5F, -0.5F, 7, 1, 1);
		BalloonFinL2a.setRotationPoint(-8F, -44F, 6F);
		BalloonFinL2a.setTextureSize(256, 128);
		BalloonFinL2a.mirror = true;
		setRotation(BalloonFinL2a, 0.7853982F, -0.6108652F, 0.6108652F);
		BalloonFinL2b = new ModelRenderer(this, 0, 27);
		BalloonFinL2b.addBox(-8F, -0.5F, -0.5F, 8, 1, 1);
		BalloonFinL2b.setRotationPoint(-8F, -44F, 7F);
		BalloonFinL2b.setTextureSize(256, 128);
		BalloonFinL2b.mirror = true;
		setRotation(BalloonFinL2b, 0F, 0F, 0.6108652F);
		BalloonFinL2c = new ModelRenderer(this, 0, 30);
		BalloonFinL2c.addBox(-9F, -0.5F, -0.5F, 9, 1, 1);
		BalloonFinL2c.setRotationPoint(-8F, -44F, 8F);
		BalloonFinL2c.setTextureSize(256, 128);
		BalloonFinL2c.mirror = true;
		setRotation(BalloonFinL2c, 0.7853982F, 0.6108652F, 0.6108652F);
		BalloonFinL2d = new ModelRenderer(this, 52, 14);
		BalloonFinL2d.addBox(-2F, -2F, -2F, 2, 2, 4);
		BalloonFinL2d.setRotationPoint(-6.5F, -43F, 7F);
		BalloonFinL2d.setTextureSize(256, 128);
		BalloonFinL2d.mirror = true;
		setRotation(BalloonFinL2d, 0F, 0F, 0F);
		Base_1a = new ModelRenderer(this, 0, 0);
		Base_1a.addBox(0F, 0F, 0F, 14, 2, 24);
		Base_1a.setRotationPoint(-7F, 5F, -12F);
		Base_1a.setTextureSize(256, 128);
		Base_1a.mirror = true;
		setRotation(Base_1a, 0F, 0F, 0F);
		Base_Seat_1b = new ModelRenderer(this, 0, 42);
		Base_Seat_1b.addBox(0F, 0F, 0F, 10, 2, 8);
		Base_Seat_1b.setRotationPoint(-5F, 4F, -6F);
		Base_Seat_1b.setTextureSize(256, 128);
		Base_Seat_1b.mirror = true;
		setRotation(Base_Seat_1b, 0F, 0F, 0F);
		Base_Side_1a = new ModelRenderer(this, 0, 64);
		Base_Side_1a.addBox(0F, 0F, 0F, 1, 4, 26);
		Base_Side_1a.setRotationPoint(8F, 1F, -13F);
		Base_Side_1a.setTextureSize(256, 128);
		Base_Side_1a.mirror = true;
		setRotation(Base_Side_1a, 0F, 0F, 0F);
		Base_Side_1b = new ModelRenderer(this, 92, 0);
		Base_Side_1b.addBox(0F, 0F, 0F, 1, 2, 24);
		Base_Side_1b.setRotationPoint(7F, 4F, -12F);
		Base_Side_1b.setTextureSize(256, 128);
		Base_Side_1b.mirror = true;
		setRotation(Base_Side_1b, 0F, 0F, 0F);
		Base_Side_2a = new ModelRenderer(this, 0, 64);
		Base_Side_2a.addBox(0F, 0F, 0F, 1, 4, 26);
		Base_Side_2a.setRotationPoint(-9F, 1F, -13F);
		Base_Side_2a.setTextureSize(256, 128);
		Base_Side_2a.mirror = true;
		setRotation(Base_Side_2a, 0F, 0F, 0F);
		Base_Side_2b = new ModelRenderer(this, 92, 0);
		Base_Side_2b.addBox(0F, 0F, 0F, 1, 2, 24);
		Base_Side_2b.setRotationPoint(-8F, 4F, -12F);
		Base_Side_2b.setTextureSize(256, 128);
		Base_Side_2b.mirror = true;
		setRotation(Base_Side_2b, 0F, 0F, 0F);
		Anchor_1a = new ModelRenderer(this, 0, 0);
		Anchor_1a.addBox(0F, 0F, 0F, 3, 2, 2);
		Anchor_1a.setRotationPoint(7F, 0F, -10F);
		Anchor_1a.setTextureSize(256, 128);
		Anchor_1a.mirror = true;
		setRotation(Anchor_1a, 0F, 0F, 0F);
		Anchor_1b = new ModelRenderer(this, 0, 4);
		Anchor_1b.addBox(0F, 0F, 0F, 3, 2, 2);
		Anchor_1b.setRotationPoint(-10F, 0F, -10F);
		Anchor_1b.setTextureSize(256, 128);
		Anchor_1b.mirror = true;
		setRotation(Anchor_1b, 0F, 0F, 0F);
		Anchor_1c = new ModelRenderer(this, 0, 8);
		Anchor_1c.addBox(0F, 0F, 0F, 4, 2, 2);
		Anchor_1c.setRotationPoint(-11F, 0F, 8F);
		Anchor_1c.setTextureSize(256, 128);
		Anchor_1c.mirror = true;
		setRotation(Anchor_1c, 0F, 0F, 0F);
		Anchor_1d = new ModelRenderer(this, 0, 12);
		Anchor_1d.addBox(0F, 0F, 0F, 4, 2, 2);
		Anchor_1d.setRotationPoint(7F, 0F, 8F);
		Anchor_1d.setTextureSize(256, 128);
		Anchor_1d.mirror = true;
		setRotation(Anchor_1d, 0F, 0F, 0F);
		Anchor_2a = new ModelRenderer(this, 64, 0);
		Anchor_2a.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2a.setRotationPoint(-14F, -22F, -14F);
		Anchor_2a.setTextureSize(256, 128);
		Anchor_2a.mirror = true;
		setRotation(Anchor_2a, 0F, 0F, 0F);
		Anchor_2b = new ModelRenderer(this, 64, 6);
		Anchor_2b.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2b.setRotationPoint(-14F, -22F, 11F);
		Anchor_2b.setTextureSize(256, 128);
		Anchor_2b.mirror = true;
		setRotation(Anchor_2b, 0F, 0F, 0F);
		Anchor_2c = new ModelRenderer(this, 64, 12);
		Anchor_2c.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2c.setRotationPoint(11F, -22F, -14F);
		Anchor_2c.setTextureSize(256, 128);
		Anchor_2c.mirror = true;
		setRotation(Anchor_2c, 0F, 0F, 0F);
		Anchor_2d = new ModelRenderer(this, 64, 18);
		Anchor_2d.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2d.setRotationPoint(11F, -22F, 11F);
		Anchor_2d.setTextureSize(256, 128);
		Anchor_2d.mirror = true;
		setRotation(Anchor_2d, 0F, 0F, 0F);
		Rope_1b = new ModelRenderer(this, 88, 0);
		Rope_1b.addBox(0F, 0F, 0F, 1, 23, 1);
		Rope_1b.setRotationPoint(12F, -21F, 12F);
		Rope_1b.setTextureSize(256, 128);
		Rope_1b.mirror = true;
		setRotation(Rope_1b, -0.1570796F, 0F, 0.1745329F);
		Rope_1c = new ModelRenderer(this, 84, 0);
		Rope_1c.addBox(0F, 0F, 0F, 1, 23, 1);
		Rope_1c.setRotationPoint(-13F, -21F, 12F);
		Rope_1c.setTextureSize(256, 128);
		Rope_1c.mirror = true;
		setRotation(Rope_1c, -0.1570796F, 0F, -0.1745329F);
		Base_Front_1a1 = new ModelRenderer(this, 2, 94);
		Base_Front_1a1.addBox(0F, 0F, 0F, 14, 4, 1);
		Base_Front_1a1.setRotationPoint(-7F, 1F, -15F);
		Base_Front_1a1.setTextureSize(256, 128);
		Base_Front_1a1.mirror = true;
		setRotation(Base_Front_1a1, 0F, 0F, 0F);
		Base_Front_1aR = new ModelRenderer(this, 15, 99);
		Base_Front_1aR.addBox(0F, 0F, 0F, 1, 4, 1);
		Base_Front_1aR.setRotationPoint(-8F, 1F, -14F);
		Base_Front_1aR.setTextureSize(256, 128);
		Base_Front_1aR.mirror = true;
		setRotation(Base_Front_1aR, 0F, 0F, 0F);
		Base_Front_1aL = new ModelRenderer(this, 15, 94);
		Base_Front_1aL.addBox(0F, 0F, 0F, 1, 4, 1);
		Base_Front_1aL.setRotationPoint(7F, 1F, -14F);
		Base_Front_1aL.setTextureSize(256, 128);
		Base_Front_1aL.mirror = true;
		setRotation(Base_Front_1aL, 0F, 0F, 0F);
		Base_Front_1aM = new ModelRenderer(this, 2, 94);
		Base_Front_1aM.addBox(0F, 0F, 0F, 14, 2, 1);
		Base_Front_1aM.setRotationPoint(-7F, 4F, -14F);
		Base_Front_1aM.setTextureSize(256, 128);
		Base_Front_1aM.mirror = true;
		setRotation(Base_Front_1aM, 0F, 0F, 0F);
		Base_Front_1c = new ModelRenderer(this, 0, 104);
		Base_Front_1c.addBox(0F, 0F, 0F, 16, 2, 1);
		Base_Front_1c.setRotationPoint(-8F, 4F, -13F);
		Base_Front_1c.setTextureSize(256, 128);
		Base_Front_1c.mirror = true;
		setRotation(Base_Front_1c, 0F, 0F, 0F);
		Base_Front_2a = new ModelRenderer(this, 3, 1);
		Base_Front_2a.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Front_2a.setRotationPoint(6F, 0F, -15F);
		Base_Front_2a.setTextureSize(256, 128);
		Base_Front_2a.mirror = true;
		setRotation(Base_Front_2a, 0F, 0F, 0F);
		Base_Front_2b = new ModelRenderer(this, 3, 1);
		Base_Front_2b.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Front_2b.setRotationPoint(3F, 0F, -15F);
		Base_Front_2b.setTextureSize(256, 128);
		Base_Front_2b.mirror = true;
		setRotation(Base_Front_2b, 0F, 0F, 0F);
		Base_Front_2c = new ModelRenderer(this, 3, 1);
		Base_Front_2c.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Front_2c.setRotationPoint(-4F, 0F, -15F);
		Base_Front_2c.setTextureSize(256, 128);
		Base_Front_2c.mirror = true;
		setRotation(Base_Front_2c, 0F, 0F, 0F);
		Base_Front_2d = new ModelRenderer(this, 3, 1);
		Base_Front_2d.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Front_2d.setRotationPoint(-7F, 0F, -15F);
		Base_Front_2d.setTextureSize(256, 128);
		Base_Front_2d.mirror = true;
		setRotation(Base_Front_2d, 0F, 0F, 0F);
		Base_Back_1a = new ModelRenderer(this, 0, 99);
		Base_Back_1a.addBox(0F, 0F, 0F, 16, 4, 1);
		Base_Back_1a.setRotationPoint(-8F, 1F, 13F);
		Base_Back_1a.setTextureSize(256, 128);
		Base_Back_1a.mirror = true;
		setRotation(Base_Back_1a, 0F, 0F, 0F);
		Base_Back_1c = new ModelRenderer(this, 0, 107);
		Base_Back_1c.addBox(0F, 0F, 0F, 16, 2, 1);
		Base_Back_1c.setRotationPoint(-8F, 4F, 12F);
		Base_Back_1c.setTextureSize(256, 128);
		Base_Back_1c.mirror = true;
		setRotation(Base_Back_1c, 0F, 0F, 0F);
		Base_Back_2a = new ModelRenderer(this, 3, 1);
		Base_Back_2a.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Back_2a.setRotationPoint(-6F, 0F, 13F);
		Base_Back_2a.setTextureSize(256, 128);
		Base_Back_2a.mirror = true;
		setRotation(Base_Back_2a, 0F, 0F, 0F);
		Base_Back_2b = new ModelRenderer(this, 3, 1);
		Base_Back_2b.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Back_2b.setRotationPoint(5F, 0F, 13F);
		Base_Back_2b.setTextureSize(256, 128);
		Base_Back_2b.mirror = true;
		setRotation(Base_Back_2b, 0F, 0F, 0F);
		Base_Corner_F1 = new ModelRenderer(this, 0, 64);
		Base_Corner_F1.addBox(0F, 0F, 0F, 1, 5, 1);
		Base_Corner_F1.setRotationPoint(8F, 0F, -14F);
		Base_Corner_F1.setTextureSize(256, 128);
		Base_Corner_F1.mirror = true;
		setRotation(Base_Corner_F1, 0F, 0F, 0F);
		Base_Corner_F2 = new ModelRenderer(this, 4, 64);
		Base_Corner_F2.addBox(0F, 0F, 0F, 1, 5, 1);
		Base_Corner_F2.setRotationPoint(-9F, 0F, -14F);
		Base_Corner_F2.setTextureSize(256, 128);
		Base_Corner_F2.mirror = true;
		setRotation(Base_Corner_F2, 0F, 0F, 0F);
		Base_Corner_B1 = new ModelRenderer(this, 8, 64);
		Base_Corner_B1.addBox(0F, 0F, 0F, 1, 5, 1);
		Base_Corner_B1.setRotationPoint(8F, 0F, 13F);
		Base_Corner_B1.setTextureSize(256, 128);
		Base_Corner_B1.mirror = true;
		setRotation(Base_Corner_B1, 0F, 0F, 0F);
		Base_Corner_B2 = new ModelRenderer(this, 12, 64);
		Base_Corner_B2.addBox(0F, 0F, 0F, 1, 5, 1);
		Base_Corner_B2.setRotationPoint(-9F, 0F, 13F);
		Base_Corner_B2.setTextureSize(256, 128);
		Base_Corner_B2.mirror = true;
		setRotation(Base_Corner_B2, 0F, 0F, 0F);
		Engine_M1a = new ModelRenderer(this, 54, 64);
		Engine_M1a.addBox(0F, 0F, 0F, 6, 6, 6);
		Engine_M1a.setRotationPoint(-3F, 0F, 11F);
		Engine_M1a.setTextureSize(256, 128);
		Engine_M1a.mirror = true;
		setRotation(Engine_M1a, 0F, 0F, 0F);
		Engine_M1b = new ModelRenderer(this, 0, 60);
		Engine_M1b.addBox(0F, 0F, 0F, 12, 2, 2);
		Engine_M1b.setRotationPoint(-6F, 2F, 14F);
		Engine_M1b.setTextureSize(256, 128);
		Engine_M1b.mirror = true;
		setRotation(Engine_M1b, 0F, 0F, 0F);
		Engine_M1c = new ModelRenderer(this, 35, 88);
		Engine_M1c.addBox(0F, 0F, 0F, 8, 1, 1);
		Engine_M1c.setRotationPoint(-4F, 6F, 12F);
		Engine_M1c.setTextureSize(256, 128);
		Engine_M1c.mirror = true;
		setRotation(Engine_M1c, 0F, 0F, 0F);
		Engine_M1d = new ModelRenderer(this, 1, 16);
		Engine_M1d.addBox(0F, 0F, 0F, 2, 4, 2);
		Engine_M1d.setRotationPoint(-1F, -4F, 12F);
		Engine_M1d.setTextureSize(256, 128);
		Engine_M1d.mirror = true;
		setRotation(Engine_M1d, 0F, 0F, 0F);
		Engine_R1 = new ModelRenderer(this, 34, 76);
		Engine_R1.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_R1.setRotationPoint(-19F, -32F, -2F);
		Engine_R1.setTextureSize(256, 128);
		Engine_R1.mirror = true;
		setRotation(Engine_R1, 0F, 0F, 0F);
		Engine_R2a = new ModelRenderer(this, 78, 64);
		Engine_R2a.addBox(0F, -2F, 0F, 4, 6, 8);
		Engine_R2a.setRotationPoint(-22F, -28F, 0F);
		Engine_R2a.setTextureSize(256, 128);
		Engine_R2a.mirror = true;
		setRotation(Engine_R2a, 0F, 0F, 0F);
		Engine_L1 = new ModelRenderer(this, 34, 64);
		Engine_L1.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_L1.setRotationPoint(15F, -32F, -2F);
		Engine_L1.setTextureSize(256, 128);
		Engine_L1.mirror = true;
		setRotation(Engine_L1, 0F, 0F, 0F);
		Engine_L2a = new ModelRenderer(this, 78, 78);
		Engine_L2a.addBox(0F, 0F, 0F, 4, 6, 8);
		Engine_L2a.setRotationPoint(18F, -30F, 0F);
		Engine_L2a.setTextureSize(256, 128);
		Engine_L2a.mirror = true;
		setRotation(Engine_L2a, 0F, 0F, 0F);
		Propeller_R1a = new ModelRenderer(this, 6, 76);
		Propeller_R1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_R1a.setRotationPoint(-20F, -27F, 9F);
		Propeller_R1a.setTextureSize(256, 128);
		Propeller_R1a.mirror = true;
		setRotation(Propeller_R1a, 0F, 0F, 0F);
		Propeller_R1b = new ModelRenderer(this, 0, 76);
		Propeller_R1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_R1b.setRotationPoint(-20F, -27F, 9F);
		Propeller_R1b.setTextureSize(256, 128);
		Propeller_R1b.mirror = true;
		setRotation(Propeller_R1b, 0F, 0F, 0F);
		Propeller_R1c = new ModelRenderer(this, 0, 86);
		Propeller_R1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_R1c.setRotationPoint(-20F, -27F, 9F);
		Propeller_R1c.setTextureSize(256, 128);
		Propeller_R1c.mirror = true;
		setRotation(Propeller_R1c, 0F, 0F, 0F);
		Propeller_L1a = new ModelRenderer(this, 6, 76);
		Propeller_L1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_L1a.setRotationPoint(20F, -27F, 9F);
		Propeller_L1a.setTextureSize(256, 128);
		Propeller_L1a.mirror = true;
		setRotation(Propeller_L1a, 0F, 0F, 0F);
		Propeller_L1b = new ModelRenderer(this, 0, 76);
		Propeller_L1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_L1b.setRotationPoint(20F, -27F, 9F);
		Propeller_L1b.setTextureSize(256, 128);
		Propeller_L1b.mirror = true;
		setRotation(Propeller_L1b, 0F, 0F, 0F);
		Propeller_L1c = new ModelRenderer(this, 0, 86);
		Propeller_L1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_L1c.setRotationPoint(20F, -27F, 9F);
		Propeller_L1c.setTextureSize(256, 128);
		Propeller_L1c.mirror = true;
		setRotation(Propeller_L1c, 0F, 0F, 0F);
		BaseFinR1a = new ModelRenderer(this, 0, 30);
		BaseFinR1a.addBox(0F, -0.5F, -0.5F, 9, 1, 1);
		BaseFinR1a.setRotationPoint(9F, 0F, 1F);
		BaseFinR1a.setTextureSize(256, 128);
		BaseFinR1a.mirror = true;
		setRotation(BaseFinR1a, 0.7853982F, -0.6108652F, 0.6108652F);
		BaseFinR1b = new ModelRenderer(this, 0, 27);
		BaseFinR1b.addBox(0F, -0.5F, -0.5F, 8, 1, 1);
		BaseFinR1b.setRotationPoint(9F, 0F, 0F);
		BaseFinR1b.setTextureSize(256, 128);
		BaseFinR1b.mirror = true;
		setRotation(BaseFinR1b, 0F, 0F, 0.6108652F);
		BaseFinR1c = new ModelRenderer(this, 0, 30);
		BaseFinR1c.addBox(0F, -0.5F, -0.5F, 7, 1, 1);
		BaseFinR1c.setRotationPoint(9F, 0F, -1F);
		BaseFinR1c.setTextureSize(256, 128);
		BaseFinR1c.mirror = true;
		setRotation(BaseFinR1c, 0.7853982F, 0.6108652F, 0.6108652F);
		BaseFinR1d = new ModelRenderer(this, 52, 0);
		BaseFinR1d.addBox(-1F, -1F, -2F, 2, 3, 4);
		BaseFinR1d.setRotationPoint(8.5F, -0.5F, 0F);
		BaseFinR1d.setTextureSize(256, 128);
		BaseFinR1d.mirror = true;
		setRotation(BaseFinR1d, 0F, 0F, 0F);
		BaseFinL1a = new ModelRenderer(this, 0, 30);
		BaseFinL1a.addBox(-7F, -0.5F, -0.5F, 7, 1, 1);
		BaseFinL1a.setRotationPoint(-9F, 0F, -1F);
		BaseFinL1a.setTextureSize(256, 128);
		BaseFinL1a.mirror = true;
		setRotation(BaseFinL1a, 0.7853982F, -0.6108652F, -0.6108652F);
		BaseFinL1b = new ModelRenderer(this, 0, 27);
		BaseFinL1b.addBox(-8F, -0.5F, -0.5F, 8, 1, 1);
		BaseFinL1b.setRotationPoint(-9F, 0F, 0F);
		BaseFinL1b.setTextureSize(256, 128);
		BaseFinL1b.mirror = true;
		setRotation(BaseFinL1b, 0F, 0F, -0.6108652F);
		BaseFinL1c = new ModelRenderer(this, 0, 30);
		BaseFinL1c.addBox(-9F, -0.5F, -0.5F, 9, 1, 1);
		BaseFinL1c.setRotationPoint(-9F, 0F, 1F);
		BaseFinL1c.setTextureSize(256, 128);
		BaseFinL1c.mirror = true;
		setRotation(BaseFinL1c, 0.7853982F, 0.6108652F, -0.6108652F);
		BaseFinL1d = new ModelRenderer(this, 52, 0);
		BaseFinL1d.addBox(-1F, -1F, -2F, 2, 3, 4);
		BaseFinL1d.setRotationPoint(-8.5F, -0.5F, 0F);
		BaseFinL1d.setTextureSize(256, 128);
		BaseFinL1d.mirror = true;
		setRotation(BaseFinL1d, 0F, 0F, 0F);
		EnginePipe_L1a = new ModelRenderer(this, 54, 80);
		EnginePipe_L1a.addBox(0F, 0F, 0F, 1, 1, 6);
		EnginePipe_L1a.setRotationPoint(-10F, 2F, 9F);
		EnginePipe_L1a.setTextureSize(256, 128);
		EnginePipe_L1a.mirror = true;
		setRotation(EnginePipe_L1a, 0F, 0F, 0F);
		EnginePipe_L1b = new ModelRenderer(this, 54, 78);
		EnginePipe_L1b.addBox(0F, 0F, 0F, 5, 1, 1);
		EnginePipe_L1b.setRotationPoint(-10F, 1F, 14F);
		EnginePipe_L1b.setTextureSize(256, 128);
		EnginePipe_L1b.mirror = true;
		setRotation(EnginePipe_L1b, 0F, 0F, 0F);
		EnginePipe_L1d = new ModelRenderer(this, 68, 77);
		EnginePipe_L1d.addBox(-0.5F, 0F, -0.5F, 1, 12, 1);
		EnginePipe_L1d.setRotationPoint(-16F, -28.5F, 3F);
		EnginePipe_L1d.setTextureSize(256, 128);
		EnginePipe_L1d.mirror = true;
		setRotation(EnginePipe_L1d, 0.8726646F, 0.2617994F, 0F);
		EnginePipe_R1a = new ModelRenderer(this, 54, 80);
		EnginePipe_R1a.addBox(0F, 0F, 0F, 1, 1, 6);
		EnginePipe_R1a.setRotationPoint(9F, 2F, 9F);
		EnginePipe_R1a.setTextureSize(256, 128);
		EnginePipe_R1a.mirror = true;
		setRotation(EnginePipe_R1a, 0F, 0F, 0F);
		EnginePipe_R1b = new ModelRenderer(this, 54, 78);
		EnginePipe_R1b.addBox(0F, 0F, 0F, 5, 1, 1);
		EnginePipe_R1b.setRotationPoint(5F, 1F, 14F);
		EnginePipe_R1b.setTextureSize(256, 128);
		EnginePipe_R1b.mirror = true;
		setRotation(EnginePipe_R1b, 0F, 0F, 0F);
		EnginePipe_R1d = new ModelRenderer(this, 68, 77);
		EnginePipe_R1d.addBox(-0.5F, 0F, -0.5F, 1, 12, 1);
		EnginePipe_R1d.setRotationPoint(16F, -28.5F, 3F);
		EnginePipe_R1d.setTextureSize(256, 128);
		EnginePipe_R1d.mirror = true;
		setRotation(EnginePipe_R1d, 0.8726646F, -0.2617994F, 0F);
		BalloonFrameTL1a1 = new ModelRenderer(this, 192, 96);
		BalloonFrameTL1a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameTL1a1.setRotationPoint(15F, -44F, -15F);
		BalloonFrameTL1a1.setTextureSize(256, 128);
		BalloonFrameTL1a1.mirror = true;
		setRotation(BalloonFrameTL1a1, 0F, 0F, 0F);
		BalloonFrameTL1a2 = new ModelRenderer(this, 190, 95);
		BalloonFrameTL1a2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameTL1a2.setRotationPoint(14F, -43F, -15F);
		BalloonFrameTL1a2.setTextureSize(256, 128);
		BalloonFrameTL1a2.mirror = true;
		setRotation(BalloonFrameTL1a2, 0F, 0F, 0F);
		BalloonFrameTR1b1 = new ModelRenderer(this, 188, 94);
		BalloonFrameTR1b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameTR1b1.setRotationPoint(-15F, -44F, -15F);
		BalloonFrameTR1b1.setTextureSize(256, 128);
		BalloonFrameTR1b1.mirror = true;
		setRotation(BalloonFrameTR1b1, 0F, 0F, 0F);
		BalloonFrameTR1b2 = new ModelRenderer(this, 186, 93);
		BalloonFrameTR1b2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameTR1b2.setRotationPoint(-14F, -43F, -15F);
		BalloonFrameTR1b2.setTextureSize(256, 128);
		BalloonFrameTR1b2.mirror = true;
		setRotation(BalloonFrameTR1b2, 0F, 0F, 0F);
		BalloonFrameBL1a1 = new ModelRenderer(this, 184, 92);
		BalloonFrameBL1a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameBL1a1.setRotationPoint(15F, -20F, -15F);
		BalloonFrameBL1a1.setTextureSize(256, 128);
		BalloonFrameBL1a1.mirror = true;
		setRotation(BalloonFrameBL1a1, 0F, 0F, 0F);
		BalloonFrameBL1a2 = new ModelRenderer(this, 182, 91);
		BalloonFrameBL1a2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameBL1a2.setRotationPoint(14F, -21F, -15F);
		BalloonFrameBL1a2.setTextureSize(256, 128);
		BalloonFrameBL1a2.mirror = true;
		setRotation(BalloonFrameBL1a2, 0F, 0F, 0F);
		BalloonFrameBR1b1 = new ModelRenderer(this, 180, 90);
		BalloonFrameBR1b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameBR1b1.setRotationPoint(-15F, -20F, -15F);
		BalloonFrameBR1b1.setTextureSize(256, 128);
		BalloonFrameBR1b1.mirror = true;
		setRotation(BalloonFrameBR1b1, 0F, 0F, 0F);
		BalloonFrameBR1b2 = new ModelRenderer(this, 178, 89);
		BalloonFrameBR1b2.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 31);
		BalloonFrameBR1b2.setRotationPoint(-14F, -21F, -15F);
		BalloonFrameBR1b2.setTextureSize(256, 128);
		BalloonFrameBR1b2.mirror = true;
		setRotation(BalloonFrameBR1b2, 0F, 0F, 0F);
		BalloonFrameTL2a1 = new ModelRenderer(this, 170, 82);
		BalloonFrameTL2a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 37);
		BalloonFrameTL2a1.setRotationPoint(13F, -43F, -18F);
		BalloonFrameTL2a1.setTextureSize(256, 128);
		BalloonFrameTL2a1.mirror = true;
		setRotation(BalloonFrameTL2a1, 0F, 0F, 0F);
		BalloonFrameTR2b1 = new ModelRenderer(this, 168, 81);
		BalloonFrameTR2b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 37);
		BalloonFrameTR2b1.setRotationPoint(-13F, -43F, -18.04F);
		BalloonFrameTR2b1.setTextureSize(256, 128);
		BalloonFrameTR2b1.mirror = true;
		setRotation(BalloonFrameTR2b1, 0F, 0F, 0F);
		BalloonFrameBL2a1 = new ModelRenderer(this, 166, 80);
		BalloonFrameBL2a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 37);
		BalloonFrameBL2a1.setRotationPoint(13F, -21F, -18F);
		BalloonFrameBL2a1.setTextureSize(256, 128);
		BalloonFrameBL2a1.mirror = true;
		setRotation(BalloonFrameBL2a1, 0F, 0F, 0F);
		BalloonFrameBR2b1 = new ModelRenderer(this, 164, 79);
		BalloonFrameBR2b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 37);
		BalloonFrameBR2b1.setRotationPoint(-13F, -21F, -18F);
		BalloonFrameBR2b1.setTextureSize(256, 128);
		BalloonFrameBR2b1.mirror = true;
		setRotation(BalloonFrameBR2b1, 0F, 0F, 0F);
		BalloonFrameTL3a1 = new ModelRenderer(this, 158, 74);
		BalloonFrameTL3a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 41);
		BalloonFrameTL3a1.setRotationPoint(12F, -42F, -20F);
		BalloonFrameTL3a1.setTextureSize(256, 128);
		BalloonFrameTL3a1.mirror = true;
		setRotation(BalloonFrameTL3a1, 0F, 0F, 0F);
		BalloonFrameTR3b1 = new ModelRenderer(this, 156, 73);
		BalloonFrameTR3b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 41);
		BalloonFrameTR3b1.setRotationPoint(-12F, -42F, -20F);
		BalloonFrameTR3b1.setTextureSize(256, 128);
		BalloonFrameTR3b1.mirror = true;
		setRotation(BalloonFrameTR3b1, 0F, 0F, 0F);
		BalloonFrameBL3a1 = new ModelRenderer(this, 163, 72);
		BalloonFrameBL3a1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 41);
		BalloonFrameBL3a1.setRotationPoint(12F, -22F, -20F);
		BalloonFrameBL3a1.setTextureSize(256, 128);
		BalloonFrameBL3a1.mirror = true;
		setRotation(BalloonFrameBL3a1, 0F, 0F, 0F);
		BalloonFrameBR3b1 = new ModelRenderer(this, 161, 71);
		BalloonFrameBR3b1.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 41);
		BalloonFrameBR3b1.setRotationPoint(-12F, -22F, -20F);
		BalloonFrameBR3b1.setTextureSize(256, 128);
		BalloonFrameBR3b1.mirror = true;
		setRotation(BalloonFrameBR3b1, 0F, 0F, 0F);
		BalloonFrameFa = new ModelRenderer(this, 170, 94);
		BalloonFrameFa.addBox(-0.5F, -0.5F, -0.7F, 1, 16, 1);
		BalloonFrameFa.setRotationPoint(0F, -32F, -20F);
		BalloonFrameFa.setTextureSize(256, 128);
		BalloonFrameFa.mirror = true;
		setRotation(BalloonFrameFa, 0F, 0F, 0.8726646F);
		BalloonFrameFb = new ModelRenderer(this, 174, 94);
		BalloonFrameFb.addBox(-0.5F, -15.5F, -0.7F, 1, 16, 1);
		BalloonFrameFb.setRotationPoint(0F, -32F, -20F);
		BalloonFrameFb.setTextureSize(256, 128);
		BalloonFrameFb.mirror = true;
		setRotation(BalloonFrameFb, 0F, 0F, 0.8726646F);
		BalloonFrameFc = new ModelRenderer(this, 178, 94);
		BalloonFrameFc.addBox(-0.5F, -0.5F, -0.7F, 1, 16, 1);
		BalloonFrameFc.setRotationPoint(0F, -32F, -20F);
		BalloonFrameFc.setTextureSize(256, 128);
		BalloonFrameFc.mirror = true;
		setRotation(BalloonFrameFc, 0F, 0F, 2.268928F);
		BalloonFrameFd = new ModelRenderer(this, 182, 94);
		BalloonFrameFd.addBox(-0.5F, -15.5F, -0.7F, 1, 16, 1);
		BalloonFrameFd.setRotationPoint(0F, -32F, -20F);
		BalloonFrameFd.setTextureSize(256, 128);
		BalloonFrameFd.mirror = true;
		setRotation(BalloonFrameFd, 0F, 0F, 2.268928F);
		BalloonFrameBa = new ModelRenderer(this, 170, 77);
		BalloonFrameBa.addBox(-0.5F, -0.5F, -1.3F, 1, 16, 1);
		BalloonFrameBa.setRotationPoint(0F, -32F, 21F);
		BalloonFrameBa.setTextureSize(256, 128);
		BalloonFrameBa.mirror = true;
		setRotation(BalloonFrameBa, 0F, 0F, 0.8726646F);
		BalloonFrameBb = new ModelRenderer(this, 174, 77);
		BalloonFrameBb.addBox(-0.5F, -15.5F, -1.3F, 1, 16, 1);
		BalloonFrameBb.setRotationPoint(0F, -32F, 21F);
		BalloonFrameBb.setTextureSize(256, 128);
		BalloonFrameBb.mirror = true;
		setRotation(BalloonFrameBb, 0F, 0F, 0.8726646F);
		BalloonFrameBc = new ModelRenderer(this, 178, 77);
		BalloonFrameBc.addBox(-0.5F, -0.5F, -1.3F, 1, 16, 1);
		BalloonFrameBc.setRotationPoint(0F, -32F, 21F);
		BalloonFrameBc.setTextureSize(256, 128);
		BalloonFrameBc.mirror = true;
		setRotation(BalloonFrameBc, 0F, 0F, 2.268928F);
		BalloonFrameBd = new ModelRenderer(this, 182, 77);
		BalloonFrameBd.addBox(-0.5F, -15.5F, -1.3F, 1, 16, 1);
		BalloonFrameBd.setRotationPoint(0F, -32F, 21F);
		BalloonFrameBd.setTextureSize(256, 128);
		BalloonFrameBd.mirror = true;
		setRotation(BalloonFrameBd, 0F, 0F, 2.268928F);
		BalloonFrameFM = new ModelRenderer(this, 240, 0);
		BalloonFrameFM.addBox(-3F, -3F, -1F, 6, 6, 2);
		BalloonFrameFM.setRotationPoint(0F, -32F, -20F);
		BalloonFrameFM.setTextureSize(256, 128);
		BalloonFrameFM.mirror = true;
		setRotation(BalloonFrameFM, 0F, 0F, 0F);
		BalloonFrameBM = new ModelRenderer(this, 240, 8);
		BalloonFrameBM.addBox(-3F, -3F, -1F, 6, 6, 2);
		BalloonFrameBM.setRotationPoint(0F, -32F, 20F);
		BalloonFrameBM.setTextureSize(256, 128);
		BalloonFrameBM.mirror = true;
		setRotation(BalloonFrameBM, 0F, 0F, 0F);
		ControlPanel = new ModelRenderer(this, 0, 122);
		ControlPanel.addBox(0F, 0F, 0F, 7, 5, 1);
		ControlPanel.setRotationPoint(-3.5F, -1F, -16F);
		ControlPanel.setTextureSize(256, 128);
		ControlPanel.mirror = true;
		setRotation(ControlPanel, 0.7853982F, 0F, 0F);
		ControlBrace = new ModelRenderer(this, 0, 117);
		ControlBrace.addBox(0F, 0F, 0F, 5, 4, 1);
		ControlBrace.setRotationPoint(-2.5F, -0.5F, -15.5F);
		ControlBrace.setTextureSize(256, 128);
		ControlBrace.mirror = true;
		setRotation(ControlBrace, 0F, 0F, 0F);
		SkidR1 = new ModelRenderer(this, 248, 26);
		SkidR1.addBox(-1F, 0F, -1F, 2, 3, 2);
		SkidR1.setRotationPoint(-6F, 6F, -6F);
		SkidR1.setTextureSize(256, 128);
		SkidR1.mirror = true;
		setRotation(SkidR1, 0F, 0.7853982F, 0F);
		SkidR2 = new ModelRenderer(this, 248, 26);
		SkidR2.addBox(-1F, 0F, -1F, 2, 3, 2);
		SkidR2.setRotationPoint(-6F, 6F, 6F);
		SkidR2.setTextureSize(256, 128);
		SkidR2.mirror = true;
		setRotation(SkidR2, 0F, 0.7853982F, 0F);
		SkidR3 = new ModelRenderer(this, 202, 26);
		SkidR3.addBox(-1.5F, 0F, 0F, 3, 1, 24);
		SkidR3.setRotationPoint(-6F, 9F, -12F);
		SkidR3.setTextureSize(256, 128);
		SkidR3.mirror = true;
		setRotation(SkidR3, 0F, 0F, 0F);
		SkidL1 = new ModelRenderer(this, 248, 26);
		SkidL1.addBox(-1F, 0F, -1F, 2, 3, 2);
		SkidL1.setRotationPoint(6F, 6F, -6F);
		SkidL1.setTextureSize(256, 128);
		SkidL1.mirror = true;
		setRotation(SkidL1, 0F, 0.7853982F, 0F);
		SkidL2 = new ModelRenderer(this, 248, 26);
		SkidL2.addBox(-1F, 0F, -1F, 2, 3, 2);
		SkidL2.setRotationPoint(6F, 6F, 6F);
		SkidL2.setTextureSize(256, 128);
		SkidL2.mirror = true;
		setRotation(SkidL2, 0F, 0.7853982F, 0F);
		SkidL3 = new ModelRenderer(this, 202, 26);
		SkidL3.addBox(-1.5F, 0F, 0F, 3, 1, 24);
		SkidL3.setRotationPoint(6F, 9F, -12F);
		SkidL3.setTextureSize(256, 128);
		SkidL3.mirror = true;
		setRotation(SkidL3, 0F, 0F, 0F);
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
	    BaseWoodChest.render(f5);
		BalloonFinR1a.render(f5);
		BalloonFinR1b.render(f5);
		BalloonFinR1c.render(f5);
		BalloonFinR1d.render(f5);
		BalloonFinR2a.render(f5);
		BalloonFinR2b.render(f5);
		BalloonFinR2c.render(f5);
		BalloonFinR2d.render(f5);
		BalloonFinL1a.render(f5);
		BalloonFinL1b.render(f5);
		BalloonFinL1c.render(f5);
		BalloonFinL1d.render(f5);
		BalloonFinL2a.render(f5);
		BalloonFinL2b.render(f5);
		BalloonFinL2c.render(f5);
		BalloonFinL2d.render(f5);
		Base_1a.render(f5);
		Base_Seat_1b.render(f5);
		Base_Side_1a.render(f5);
		Base_Side_1b.render(f5);
		Base_Side_2a.render(f5);
		Base_Side_2b.render(f5);
		Anchor_1a.render(f5);
		Anchor_1b.render(f5);
		Anchor_1c.render(f5);
		Anchor_1d.render(f5);
		Anchor_2a.render(f5);
		Anchor_2b.render(f5);
		Anchor_2c.render(f5);
		Anchor_2d.render(f5);
		Rope_1b.render(f5);
		Rope_1c.render(f5);
		Base_Front_1a1.render(f5);
		Base_Front_1aR.render(f5);
		Base_Front_1aL.render(f5);
		Base_Front_1aM.render(f5);
		Base_Front_1c.render(f5);
		Base_Front_2a.render(f5);
		Base_Front_2b.render(f5);
		Base_Front_2c.render(f5);
		Base_Front_2d.render(f5);
		Base_Back_1a.render(f5);
		Base_Back_1c.render(f5);
		Base_Back_2a.render(f5);
		Base_Back_2b.render(f5);
		Base_Corner_F1.render(f5);
		Base_Corner_F2.render(f5);
		Base_Corner_B1.render(f5);
		Base_Corner_B2.render(f5);
		Engine_M1a.render(f5);
		Engine_M1b.render(f5);
		Engine_M1c.render(f5);
		Engine_M1d.render(f5);
		Engine_R1.render(f5);
		Engine_R2a.render(f5);
		Engine_L1.render(f5);
		Engine_L2a.render(f5);
		Propeller_R1a.render(f5);
		Propeller_R1b.render(f5);
		Propeller_R1c.render(f5);
		Propeller_L1a.render(f5);
		Propeller_L1b.render(f5);
		Propeller_L1c.render(f5);
		BaseFinR1a.render(f5);
		BaseFinR1b.render(f5);
		BaseFinR1c.render(f5);
		BaseFinR1d.render(f5);
		BaseFinL1a.render(f5);
		BaseFinL1b.render(f5);
		BaseFinL1c.render(f5);
		BaseFinL1d.render(f5);
		EnginePipe_L1a.render(f5);
		EnginePipe_L1b.render(f5);
		EnginePipe_L1d.render(f5);
		EnginePipe_R1a.render(f5);
		EnginePipe_R1b.render(f5);
		EnginePipe_R1d.render(f5);
		BalloonFrameTL1a1.render(f5);
		BalloonFrameTL1a2.render(f5);
		BalloonFrameTR1b1.render(f5);
		BalloonFrameTR1b2.render(f5);
		BalloonFrameBL1a1.render(f5);
		BalloonFrameBL1a2.render(f5);
		BalloonFrameBR1b1.render(f5);
		BalloonFrameBR1b2.render(f5);
		BalloonFrameTL2a1.render(f5);
		BalloonFrameTR2b1.render(f5);
		BalloonFrameBL2a1.render(f5);
		BalloonFrameBR2b1.render(f5);
		BalloonFrameTL3a1.render(f5);
		BalloonFrameTR3b1.render(f5);
		BalloonFrameBL3a1.render(f5);
		BalloonFrameBR3b1.render(f5);
		BalloonFrameFa.render(f5);
		BalloonFrameFb.render(f5);
		BalloonFrameFc.render(f5);
		BalloonFrameFd.render(f5);
		BalloonFrameBa.render(f5);
		BalloonFrameBb.render(f5);
		BalloonFrameBc.render(f5);
		BalloonFrameBd.render(f5);
		BalloonFrameFM.render(f5);
		BalloonFrameBM.render(f5);
	    ControlPanel.render(f5);
	    ControlBrace.render(f5);
	    SkidR1.render(f5);
	    SkidR2.render(f5);
	    SkidR3.render(f5);
	    SkidL1.render(f5);
	    SkidL2.render(f5);
	    SkidL3.render(f5);
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
