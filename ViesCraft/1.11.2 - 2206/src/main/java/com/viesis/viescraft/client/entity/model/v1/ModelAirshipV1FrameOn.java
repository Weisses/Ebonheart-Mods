package com.viesis.viescraft.client.entity.model.v1;

import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;

public class ModelAirshipV1FrameOn extends ModelBase {
	
	public Random random = new Random();
	
	private float bladespin;
	private long lastframe;
	
	//fields
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
	ModelRenderer Engine_R1a;
	ModelRenderer Engine_R1b;
	ModelRenderer Engine_R2a;
	ModelRenderer Engine_L1;
	ModelRenderer Engine_L1a;
	ModelRenderer Engine_L1b;
	ModelRenderer Engine_L2a;
	ModelRenderer Propeller_R1a;
	ModelRenderer Propeller_R1b;
	ModelRenderer Propeller_R1c;
	ModelRenderer Propeller_L1a;
	ModelRenderer Propeller_L1b;
	ModelRenderer Propeller_L1c;
	ModelRenderer BalloonFrameRT1;
	ModelRenderer BalloonFrameRM1;
	ModelRenderer BalloonFrameRB1;
	ModelRenderer BalloonFrameLT1;
	ModelRenderer BalloonFrameLM1;
	ModelRenderer BalloonFrameLB1;
	ModelRenderer BalloonFrameMT1;
	ModelRenderer BalloonFrameRT2a;
	ModelRenderer BalloonFrameRT2b;
	ModelRenderer BalloonFrameMT2;
	ModelRenderer BalloonFrameLT2a;
	ModelRenderer BalloonFrameLT2b;
	ModelRenderer BalloonFrameRM2;
	ModelRenderer BalloonFrameLM2;
	ModelRenderer BalloonFrameRB2a;
	ModelRenderer BalloonFrameRB2b;
	ModelRenderer BalloonFrameLB2a;
	ModelRenderer BalloonFrameLB2b;
	ModelRenderer BalloonFrameRT3;
	ModelRenderer BalloonFrameMT3;
	ModelRenderer BalloonFrameLT3;
	ModelRenderer BalloonFrameRM3;
	ModelRenderer BalloonFrameLM3;
	ModelRenderer BalloonFrameRB3;
	ModelRenderer BalloonFrameLB3;
	ModelRenderer BalloonFrameF3a;
	ModelRenderer BalloonFrameF3b;
	ModelRenderer BalloonFrameF3c;
	ModelRenderer BalloonFrameF3d;
	ModelRenderer BalloonFrameF3e;
	ModelRenderer BalloonFrameB3a;
	ModelRenderer BalloonFrameB3b;
	ModelRenderer BalloonFrameB3c;
	ModelRenderer BalloonFrameB3d;
	ModelRenderer BalloonFrameB3e;
    ModelRenderer ControlPanel;
    ModelRenderer ControlBrace;
    ModelRenderer SkidR1;
    ModelRenderer SkidR2;
    ModelRenderer SkidR3;
    ModelRenderer SkidL1;
    ModelRenderer SkidL2;
    ModelRenderer SkidL3;
	
	public ModelAirshipV1FrameOn()
	{
		textureWidth = 256;
		textureHeight = 128;
		
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
		Anchor_1c.addBox(0F, 0F, 0F, 3, 2, 2);
		Anchor_1c.setRotationPoint(-10F, 0F, 8F);
		Anchor_1c.setTextureSize(256, 128);
		Anchor_1c.mirror = true;
		setRotation(Anchor_1c, 0F, 0F, 0F);
		Anchor_1d = new ModelRenderer(this, 0, 12);
		Anchor_1d.addBox(0F, 0F, 0F, 3, 2, 2);
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
		Anchor_2b = new ModelRenderer(this, 64, 5);
		Anchor_2b.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2b.setRotationPoint(-14F, -22F, 11F);
		Anchor_2b.setTextureSize(256, 128);
		Anchor_2b.mirror = true;
		setRotation(Anchor_2b, 0F, 0F, 0F);
		Anchor_2c = new ModelRenderer(this, 64, 10);
		Anchor_2c.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2c.setRotationPoint(11F, -22F, -14F);
		Anchor_2c.setTextureSize(256, 128);
		Anchor_2c.mirror = true;
		setRotation(Anchor_2c, 0F, 0F, 0F);
		Anchor_2d = new ModelRenderer(this, 64, 15);
		Anchor_2d.addBox(0F, 0F, 0F, 3, 3, 3);
		Anchor_2d.setRotationPoint(11F, -22F, 11F);
		Anchor_2d.setTextureSize(256, 128);
		Anchor_2d.mirror = true;
		setRotation(Anchor_2d, 0F, 0F, 0F);
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
		Engine_R1.setRotationPoint(-13F, 0F, 0F);
		Engine_R1.setTextureSize(256, 128);
		Engine_R1.mirror = true;
		setRotation(Engine_R1, 0F, 0F, 0F);
		Engine_R1a = new ModelRenderer(this, 54, 76);
		Engine_R1a.addBox(0F, 0F, 0F, 1, 1, 10);
		Engine_R1a.setRotationPoint(-10F, 4F, 5F);
		Engine_R1a.setTextureSize(256, 128);
		Engine_R1a.mirror = true;
		setRotation(Engine_R1a, 0F, 0F, 0F);
		Engine_R1b = new ModelRenderer(this, 54, 84);
		Engine_R1b.addBox(0F, 0F, 0F, 4, 1, 1);
		Engine_R1b.setRotationPoint(-9F, 4F, 14F);
		Engine_R1b.setTextureSize(256, 128);
		Engine_R1b.mirror = true;
		setRotation(Engine_R1b, 0F, 0F, 0F);
		Engine_R2a = new ModelRenderer(this, 78, 64);
		Engine_R2a.addBox(0F, -2F, 0F, 4, 6, 8);
		Engine_R2a.setRotationPoint(-16F, 0F, 2F);
		Engine_R2a.setTextureSize(256, 128);
		Engine_R2a.mirror = true;
		setRotation(Engine_R2a, 0F, 0F, 0F);
		Engine_L1 = new ModelRenderer(this, 34, 64);
		Engine_L1.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_L1.setRotationPoint(9F, 0F, 0F);
		Engine_L1.setTextureSize(256, 128);
		Engine_L1.mirror = true;
		setRotation(Engine_L1, 0F, 0F, 0F);
		Engine_L1a = new ModelRenderer(this, 54, 87);
		Engine_L1a.addBox(0F, 0F, 0F, 1, 1, 10);
		Engine_L1a.setRotationPoint(9F, 4F, 5F);
		Engine_L1a.setTextureSize(256, 128);
		Engine_L1a.mirror = true;
		setRotation(Engine_L1a, 0F, 0F, 0F);
		Engine_L1b = new ModelRenderer(this, 54, 95);
		Engine_L1b.addBox(0F, 0F, 0F, 4, 1, 1);
		Engine_L1b.setRotationPoint(5F, 4F, 14F);
		Engine_L1b.setTextureSize(256, 128);
		Engine_L1b.mirror = true;
		setRotation(Engine_L1b, 0F, 0F, 0F);
		Engine_L2a = new ModelRenderer(this, 78, 78);
		Engine_L2a.addBox(0F, 0F, 0F, 4, 6, 8);
		Engine_L2a.setRotationPoint(12F, -2F, 2F);
		Engine_L2a.setTextureSize(256, 128);
		Engine_L2a.mirror = true;
		setRotation(Engine_L2a, 0F, 0F, 0F);
		Propeller_R1a = new ModelRenderer(this, 6, 76);
		Propeller_R1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_R1a.setRotationPoint(-14F, 1F, 11F);
		Propeller_R1a.setTextureSize(256, 128);
		Propeller_R1a.mirror = true;
		setRotation(Propeller_R1a, 0F, 0F, 0F);
		Propeller_R1b = new ModelRenderer(this, 0, 76);
		Propeller_R1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_R1b.setRotationPoint(-14F, 1F, 11F);
		Propeller_R1b.setTextureSize(256, 128);
		Propeller_R1b.mirror = true;
		setRotation(Propeller_R1b, 0F, 0F, 0F);
		Propeller_R1c = new ModelRenderer(this, 0, 86);
		Propeller_R1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_R1c.setRotationPoint(-14F, 1F, 11F);
		Propeller_R1c.setTextureSize(256, 128);
		Propeller_R1c.mirror = true;
		setRotation(Propeller_R1c, 0F, 0F, 0F);
		Propeller_L1a = new ModelRenderer(this, 6, 76);
		Propeller_L1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_L1a.setRotationPoint(14F, 1F, 11F);
		Propeller_L1a.setTextureSize(256, 128);
		Propeller_L1a.mirror = true;
		setRotation(Propeller_L1a, 0F, 0F, 0F);
		Propeller_L1b = new ModelRenderer(this, 0, 76);
		Propeller_L1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_L1b.setRotationPoint(14F, 1F, 11F);
		Propeller_L1b.setTextureSize(256, 128);
		Propeller_L1b.mirror = true;
		setRotation(Propeller_L1b, 0F, 0F, 0F);
		Propeller_L1c = new ModelRenderer(this, 0, 86);
		Propeller_L1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_L1c.setRotationPoint(14F, 1F, 11F);
		Propeller_L1c.setTextureSize(256, 128);
		Propeller_L1c.mirror = true;
		setRotation(Propeller_L1c, 0F, 0F, 0F);
		BalloonFrameRT1 = new ModelRenderer(this, 188, 94);
		BalloonFrameRT1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameRT1.setRotationPoint(-16.5F, -52.5F, -16.5F);
		BalloonFrameRT1.setTextureSize(256, 128);
		BalloonFrameRT1.mirror = true;
		setRotation(BalloonFrameRT1, 0F, 0F, 0F);
		BalloonFrameRM1 = new ModelRenderer(this, 186, 93);
		BalloonFrameRM1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameRM1.setRotationPoint(-16.5F, -36.5F, -16.5F);
		BalloonFrameRM1.setTextureSize(256, 128);
		BalloonFrameRM1.mirror = true;
		setRotation(BalloonFrameRM1, 0F, 0F, 0F);
		BalloonFrameRB1 = new ModelRenderer(this, 184, 92);
		BalloonFrameRB1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameRB1.setRotationPoint(-16.5F, -20.5F, -16.5F);
		BalloonFrameRB1.setTextureSize(256, 128);
		BalloonFrameRB1.mirror = true;
		setRotation(BalloonFrameRB1, 0F, 0F, 0F);
		BalloonFrameLT1 = new ModelRenderer(this, 182, 91);
		BalloonFrameLT1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameLT1.setRotationPoint(15.5F, -52.5F, -16.5F);
		BalloonFrameLT1.setTextureSize(256, 128);
		BalloonFrameLT1.mirror = true;
		setRotation(BalloonFrameLT1, 0F, 0F, 0F);
		BalloonFrameLM1 = new ModelRenderer(this, 180, 90);
		BalloonFrameLM1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameLM1.setRotationPoint(15.5F, -36.5F, -16.5F);
		BalloonFrameLM1.setTextureSize(256, 128);
		BalloonFrameLM1.mirror = true;
		setRotation(BalloonFrameLM1, 0F, 0F, 0F);
		BalloonFrameLB1 = new ModelRenderer(this, 178, 89);
		BalloonFrameLB1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameLB1.setRotationPoint(15.5F, -20.5F, -16.5F);
		BalloonFrameLB1.setTextureSize(256, 128);
		BalloonFrameLB1.mirror = true;
		setRotation(BalloonFrameLB1, 0F, 0F, 0F);
		BalloonFrameMT1 = new ModelRenderer(this, 176, 88);
		BalloonFrameMT1.addBox(0F, 0F, 0F, 1, 1, 33);
		BalloonFrameMT1.setRotationPoint(-0.5F, -52.5F, -16.5F);
		BalloonFrameMT1.setTextureSize(256, 128);
		BalloonFrameMT1.mirror = true;
		setRotation(BalloonFrameMT1, 0F, 0F, 0F);
		BalloonFrameRT2a = new ModelRenderer(this, 176, 80);
		BalloonFrameRT2a.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameRT2a.setRotationPoint(-15.5F, -51.5F, -19.5F);
		BalloonFrameRT2a.setTextureSize(256, 128);
		BalloonFrameRT2a.mirror = true;
		setRotation(BalloonFrameRT2a, 0F, 0F, 0F);
		BalloonFrameRT2b = new ModelRenderer(this, 174, 79);
		BalloonFrameRT2b.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameRT2b.setRotationPoint(-14.5F, -50.5F, -19.5F);
		BalloonFrameRT2b.setTextureSize(256, 128);
		BalloonFrameRT2b.mirror = true;
		setRotation(BalloonFrameRT2b, 0F, 0F, 0F);
		BalloonFrameMT2 = new ModelRenderer(this, 172, 77);
		BalloonFrameMT2.addBox(0F, 0F, 0F, 1, 2, 39);
		BalloonFrameMT2.setRotationPoint(-0.5F, -51.5F, -19.5F);
		BalloonFrameMT2.setTextureSize(256, 128);
		BalloonFrameMT2.mirror = true;
		setRotation(BalloonFrameMT2, 0F, 0F, 0F);
		BalloonFrameLT2a = new ModelRenderer(this, 176, 76);
		BalloonFrameLT2a.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameLT2a.setRotationPoint(14.5F, -51.5F, -19.5F);
		BalloonFrameLT2a.setTextureSize(256, 128);
		BalloonFrameLT2a.mirror = true;
		setRotation(BalloonFrameLT2a, 0F, 0F, 0F);
		BalloonFrameLT2b = new ModelRenderer(this, 175, 75);
		BalloonFrameLT2b.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameLT2b.setRotationPoint(13.5F, -50.5F, -19.5F);
		BalloonFrameLT2b.setTextureSize(256, 128);
		BalloonFrameLT2b.mirror = true;
		setRotation(BalloonFrameLT2b, 0F, 0F, 0F);
		BalloonFrameRM2 = new ModelRenderer(this, 170, 74);
		BalloonFrameRM2.addBox(0F, 0F, -1F, 2, 1, 39);
		BalloonFrameRM2.setRotationPoint(-15.5F, -36.5F, -18.5F);
		BalloonFrameRM2.setTextureSize(256, 128);
		BalloonFrameRM2.mirror = true;
		setRotation(BalloonFrameRM2, 0F, 0F, 0F);
		BalloonFrameLM2 = new ModelRenderer(this, 166, 73);
		BalloonFrameLM2.addBox(0F, 0F, 0F, 2, 1, 39);
		BalloonFrameLM2.setRotationPoint(13.5F, -36.5F, -19.5F);
		BalloonFrameLM2.setTextureSize(256, 128);
		BalloonFrameLM2.mirror = true;
		setRotation(BalloonFrameLM2, 0F, 0F, 0F);
		BalloonFrameRB2a = new ModelRenderer(this, 165, 72);
		BalloonFrameRB2a.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameRB2a.setRotationPoint(-15.5F, -21.5F, -19.5F);
		BalloonFrameRB2a.setTextureSize(256, 128);
		BalloonFrameRB2a.mirror = true;
		setRotation(BalloonFrameRB2a, 0F, 0F, 0F);
		BalloonFrameRB2b = new ModelRenderer(this, 163, 71);
		BalloonFrameRB2b.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameRB2b.setRotationPoint(-14.5F, -22.5F, -19.5F);
		BalloonFrameRB2b.setTextureSize(256, 128);
		BalloonFrameRB2b.mirror = true;
		setRotation(BalloonFrameRB2b, 0F, 0F, 0F);
		BalloonFrameLB2a = new ModelRenderer(this, 158, 68);
		BalloonFrameLB2a.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameLB2a.setRotationPoint(14.5F, -21.5F, -19.5F);
		BalloonFrameLB2a.setTextureSize(256, 128);
		BalloonFrameLB2a.mirror = true;
		setRotation(BalloonFrameLB2a, 0F, 0F, 0F);
		BalloonFrameLB2b = new ModelRenderer(this, 156, 67);
		BalloonFrameLB2b.addBox(0F, 0F, 0F, 1, 1, 39);
		BalloonFrameLB2b.setRotationPoint(13.5F, -22.5F, -19.5F);
		BalloonFrameLB2b.setTextureSize(256, 128);
		BalloonFrameLB2b.mirror = true;
		setRotation(BalloonFrameLB2b, 0F, 0F, 0F);
		BalloonFrameRT3 = new ModelRenderer(this, 164, 60);
		BalloonFrameRT3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameRT3.setRotationPoint(-13.5F, -49.5F, -22.5F);
		BalloonFrameRT3.setTextureSize(256, 128);
		BalloonFrameRT3.mirror = true;
		setRotation(BalloonFrameRT3, 0F, 0F, 0F);
		BalloonFrameMT3 = new ModelRenderer(this, 162, 59);
		BalloonFrameMT3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameMT3.setRotationPoint(-0.5F, -49.5F, -22.5F);
		BalloonFrameMT3.setTextureSize(256, 128);
		BalloonFrameMT3.mirror = true;
		setRotation(BalloonFrameMT3, 0F, 0F, 0F);
		BalloonFrameLT3 = new ModelRenderer(this, 160, 58);
		BalloonFrameLT3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameLT3.setRotationPoint(12.5F, -49.5F, -22.5F);
		BalloonFrameLT3.setTextureSize(256, 128);
		BalloonFrameLT3.mirror = true;
		setRotation(BalloonFrameLT3, 0F, 0F, 0F);
		BalloonFrameRM3 = new ModelRenderer(this, 158, 57);
		BalloonFrameRM3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameRM3.setRotationPoint(-13.5F, -36.5F, -22.5F);
		BalloonFrameRM3.setTextureSize(256, 128);
		BalloonFrameRM3.mirror = true;
		setRotation(BalloonFrameRM3, 0F, 0F, 0F);
		BalloonFrameLM3 = new ModelRenderer(this, 156, 56);
		BalloonFrameLM3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameLM3.setRotationPoint(12.5F, -36.5F, -22.5F);
		BalloonFrameLM3.setTextureSize(256, 128);
		BalloonFrameLM3.mirror = true;
		setRotation(BalloonFrameLM3, 0F, 0F, 0F);
		BalloonFrameRB3 = new ModelRenderer(this, 154, 55);
		BalloonFrameRB3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameRB3.setRotationPoint(-13.5F, -23.5F, -22.5F);
		BalloonFrameRB3.setTextureSize(256, 128);
		BalloonFrameRB3.mirror = true;
		setRotation(BalloonFrameRB3, 0F, 0F, 0F);
		BalloonFrameLB3 = new ModelRenderer(this, 152, 54);
		BalloonFrameLB3.addBox(0F, 0F, 0F, 1, 1, 45);
		BalloonFrameLB3.setRotationPoint(12.5F, -23.5F, -22.5F);
		BalloonFrameLB3.setTextureSize(256, 128);
		BalloonFrameLB3.mirror = true;
		setRotation(BalloonFrameLB3, 0F, 0F, 0F);
		BalloonFrameF3a = new ModelRenderer(this, 150, 72);
		BalloonFrameF3a.addBox(-0.5F, -12.5F, -0.5F, 1, 13, 1);
		BalloonFrameF3a.setRotationPoint(0F, -36F, -22F);
		BalloonFrameF3a.setTextureSize(256, 128);
		BalloonFrameF3a.mirror = true;
		setRotation(BalloonFrameF3a, 0F, 0F, 0F);
		BalloonFrameF3b = new ModelRenderer(this, 196, 96);
		BalloonFrameF3b.addBox(-12.5F, -0.5F, -0.5F, 25, 1, 1);
		BalloonFrameF3b.setRotationPoint(0F, -36F, -22F);
		BalloonFrameF3b.setTextureSize(256, 128);
		BalloonFrameF3b.mirror = true;
		setRotation(BalloonFrameF3b, 0F, 0F, 0F);
		BalloonFrameF3c = new ModelRenderer(this, 154, 60);
		BalloonFrameF3c.addBox(-0.5F, -18.5F, -0.7F, 1, 37, 1);
		BalloonFrameF3c.setRotationPoint(0F, -36F, -22F);
		BalloonFrameF3c.setTextureSize(256, 128);
		BalloonFrameF3c.mirror = true;
		setRotation(BalloonFrameF3c, 0F, 0F, 0.7853982F);
		BalloonFrameF3d = new ModelRenderer(this, 158, 60);
		BalloonFrameF3d.addBox(-0.5F, -18.5F, -0.7F, 1, 37, 1);
		BalloonFrameF3d.setRotationPoint(0F, -36F, -22F);
		BalloonFrameF3d.setTextureSize(256, 128);
		BalloonFrameF3d.mirror = true;
		setRotation(BalloonFrameF3d, 0F, 0F, 2.356194F);
		BalloonFrameF3e = new ModelRenderer(this, 240, 0);
		BalloonFrameF3e.addBox(-3F, -3F, -1F, 6, 6, 2);
		BalloonFrameF3e.setRotationPoint(0F, -36F, -22F);
		BalloonFrameF3e.setTextureSize(256, 128);
		BalloonFrameF3e.mirror = true;
		setRotation(BalloonFrameF3e, 0F, 0F, 0F);
		BalloonFrameB3a = new ModelRenderer(this, 162, 72);
		BalloonFrameB3a.addBox(-0.5F, -12.5F, -0.5F, 1, 13, 1);
		BalloonFrameB3a.setRotationPoint(0F, -36F, 22F);
		BalloonFrameB3a.setTextureSize(256, 128);
		BalloonFrameB3a.mirror = true;
		setRotation(BalloonFrameB3a, 0F, 0F, 0F);
		BalloonFrameB3b = new ModelRenderer(this, 196, 94);
		BalloonFrameB3b.addBox(-12.5F, -0.5F, -0.5F, 25, 1, 1);
		BalloonFrameB3b.setRotationPoint(0F, -36F, 22F);
		BalloonFrameB3b.setTextureSize(256, 128);
		BalloonFrameB3b.mirror = true;
		setRotation(BalloonFrameB3b, 0F, 0F, 0F);
		BalloonFrameB3c = new ModelRenderer(this, 166, 60);
		BalloonFrameB3c.addBox(-0.5F, -18.5F, -0.3F, 1, 37, 1);
		BalloonFrameB3c.setRotationPoint(0F, -36F, 22F);
		BalloonFrameB3c.setTextureSize(256, 128);
		BalloonFrameB3c.mirror = true;
		setRotation(BalloonFrameB3c, 0F, 0F, 0.7853982F);
		BalloonFrameB3d = new ModelRenderer(this, 170, 60);
		BalloonFrameB3d.addBox(-0.5F, -18.5F, -0.3F, 1, 37, 1);
		BalloonFrameB3d.setRotationPoint(0F, -36F, 22F);
		BalloonFrameB3d.setTextureSize(256, 128);
		BalloonFrameB3d.mirror = true;
		setRotation(BalloonFrameB3d, 0F, 0F, 2.356194F);
		BalloonFrameB3e = new ModelRenderer(this, 240, 8);
		BalloonFrameB3e.addBox(-3F, -3F, -1F, 6, 6, 2);
		BalloonFrameB3e.setRotationPoint(0F, -36F, 22F);
		BalloonFrameB3e.setTextureSize(256, 128);
		BalloonFrameB3e.mirror = true;
		setRotation(BalloonFrameB3e, 0F, 0F, 0F);
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
		Engine_R1a.render(f5);
		Engine_R1b.render(f5);
		Engine_R2a.render(f5);
		Engine_L1.render(f5);
		Engine_L1a.render(f5);
		Engine_L1b.render(f5);
		Engine_L2a.render(f5);
		Propeller_R1a.render(f5);
		Propeller_R1b.render(f5);
		Propeller_R1c.render(f5);
		Propeller_L1a.render(f5);
		Propeller_L1b.render(f5);
		Propeller_L1c.render(f5);
		BalloonFrameRT1.render(f5);
		BalloonFrameRM1.render(f5);
		BalloonFrameRB1.render(f5);
		BalloonFrameLT1.render(f5);
		BalloonFrameLM1.render(f5);
		BalloonFrameLB1.render(f5);
		BalloonFrameMT1.render(f5);
		BalloonFrameRT2a.render(f5);
		BalloonFrameRT2b.render(f5);
		BalloonFrameMT2.render(f5);
		BalloonFrameLT2a.render(f5);
		BalloonFrameLT2b.render(f5);
		BalloonFrameRM2.render(f5);
		BalloonFrameLM2.render(f5);
		BalloonFrameRB2a.render(f5);
		BalloonFrameRB2b.render(f5);
		BalloonFrameLB2a.render(f5);
		BalloonFrameLB2b.render(f5);
		BalloonFrameRT3.render(f5);
		BalloonFrameMT3.render(f5);
		BalloonFrameLT3.render(f5);
		BalloonFrameRM3.render(f5);
		BalloonFrameLM3.render(f5);
		BalloonFrameRB3.render(f5);
		BalloonFrameLB3.render(f5);
		BalloonFrameF3a.render(f5);
		BalloonFrameF3b.render(f5);
		BalloonFrameF3c.render(f5);
		BalloonFrameF3d.render(f5);
		BalloonFrameF3e.render(f5);
		BalloonFrameB3a.render(f5);
		BalloonFrameB3b.render(f5);
		BalloonFrameB3c.render(f5);
		BalloonFrameB3d.render(f5);
		BalloonFrameB3e.render(f5);
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
		
		long now = System.nanoTime();
		int elapsed = (int) ((now - lastframe) / (1000000));
		// 1000000 nanoseconds = .001 seconds
		bladespin = (float) elapsed / 300.0f;
		// 0.001 seconds / 300 = 3.3333 repeating.
		lastframe = now;
		
		this.Propeller_R1a.rotateAngleZ += (bladespin * 3);
		this.Propeller_R1b.rotateAngleZ += (bladespin * 3);
		this.Propeller_R1c.rotateAngleZ += (bladespin * 3);
		
		this.Propeller_L1a.rotateAngleZ += (bladespin * 3);
		this.Propeller_L1b.rotateAngleZ += (bladespin * 3);
		this.Propeller_L1c.rotateAngleZ += (bladespin * 3);
		
		int randomTick = random.nextInt(100) + 1;
		
		if(randomTick < 20)
		{
			entity.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
				entity.posX - (double)(MathHelper.sin(-entity.rotationYaw * 0.017453292F) * 00.82F), 
				entity.posY + 0.95D + (entity.world.rand.nextFloat() * 0.025D), 
				entity.posZ - (double)(MathHelper.cos(entity.rotationYaw * 0.017453292F) * 00.82F), 
				0.0D, 0.0D, 0.0D, new int[0]);
		}
	}
}
