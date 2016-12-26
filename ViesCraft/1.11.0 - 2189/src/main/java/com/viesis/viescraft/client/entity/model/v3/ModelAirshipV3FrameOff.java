package com.viesis.viescraft.client.entity.model.v3;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV3FrameOff extends ModelBase {
	
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
	ModelRenderer Engine_R2b;
	ModelRenderer Engine_L1;
	ModelRenderer Engine_L1a;
	ModelRenderer Engine_L1b;
	ModelRenderer Engine_L2b;
	ModelRenderer Propeller_R1a;
	ModelRenderer Propeller_R1b;
	ModelRenderer Propeller_R1c;
	ModelRenderer Propeller_L1a;
	ModelRenderer Propeller_L1b;
	ModelRenderer Propeller_L1c;
	ModelRenderer Propeller_FL1a;
	ModelRenderer Propeller_FL1b;
	ModelRenderer Propeller_FL1c;
	ModelRenderer Engine_FL2a;
	ModelRenderer Propeller_FR1b;
	ModelRenderer Propeller_FR1c;
	ModelRenderer Propeller_FR1a;
	ModelRenderer Engine_FR2a;
	ModelRenderer Pipe_L1a;
	ModelRenderer Pipe_L1b;
	ModelRenderer Pipe_R1a;
	ModelRenderer Pipe_R1b;
	ModelRenderer BalloonFrameRMa;
	ModelRenderer BalloonFrameRT1a;
	ModelRenderer BalloonFrameRT1b;
	ModelRenderer BalloonFrameRB1a;
	ModelRenderer BalloonFrameRB1b;
	ModelRenderer BalloonFrameRT2a1;
	ModelRenderer BalloonFrameRT2a2;
	ModelRenderer BalloonFrameRT2b1;
	ModelRenderer BalloonFrameRT2b2;
	ModelRenderer BalloonFrameRB2a1;
	ModelRenderer BalloonFrameRB2a2;
	ModelRenderer BalloonFrameRB2b1;
	ModelRenderer BalloonFrameRB2b2;
	ModelRenderer AnchorRa;
	ModelRenderer JointR1a;
	ModelRenderer JointR1b;
	ModelRenderer BalloonFrameLMa;
	ModelRenderer BalloonFrameLT1a;
	ModelRenderer BalloonFrameLT1b;
	ModelRenderer BalloonFrameLB1a;
	ModelRenderer BalloonFrameLB1b;
	ModelRenderer BalloonFrameLT2a1;
	ModelRenderer BalloonFrameLT2a2;
	ModelRenderer BalloonFrameLT2b1;
	ModelRenderer BalloonFrameLT2b2;
	ModelRenderer BalloonFrameLB2a1;
	ModelRenderer BalloonFrameLB2a2;
	ModelRenderer BalloonFrameLB2b1;
	ModelRenderer BalloonFrameLB2b2;
	ModelRenderer AnchorLa;
	ModelRenderer JointL1a;
	ModelRenderer JointL1b;
	
	public ModelAirshipV3FrameOff()
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
		Base_Front_2a.setRotationPoint(6.013333F, 0F, -15F);
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
		Engine_R1.addBox(0F, 1F, 0F, 4, 6, 6);
		Engine_R1.setRotationPoint(-13F, -2F, 6F);
		Engine_R1.setTextureSize(256, 128);
		Engine_R1.mirror = true;
		setRotation(Engine_R1, 0F, 0F, 0F);
		Engine_R1a = new ModelRenderer(this, 54, 76);
		Engine_R1a.addBox(0F, 0F, 0F, 1, 1, 8);
		Engine_R1a.setRotationPoint(-10F, 5F, 7F);
		Engine_R1a.setTextureSize(256, 128);
		Engine_R1a.mirror = true;
		setRotation(Engine_R1a, 0F, 0F, 0F);
		Engine_R1b = new ModelRenderer(this, 54, 84);
		Engine_R1b.addBox(0F, 0F, 0F, 5, 1, 1);
		Engine_R1b.setRotationPoint(-10F, 4F, 14F);
		Engine_R1b.setTextureSize(256, 128);
		Engine_R1b.mirror = true;
		setRotation(Engine_R1b, 0F, 0F, 0F);
		Engine_R2b = new ModelRenderer(this, 0, 16);
		Engine_R2b.addBox(0F, 0F, 0F, 2, 4, 2);
		Engine_R2b.setRotationPoint(10.5F, -5F, 9F);
		Engine_R2b.setTextureSize(256, 128);
		Engine_R2b.mirror = true;
		setRotation(Engine_R2b, 0F, 0F, 0F);
		Engine_L1 = new ModelRenderer(this, 34, 64);
		Engine_L1.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_L1.setRotationPoint(9F, -1F, 6F);
		Engine_L1.setTextureSize(256, 128);
		Engine_L1.mirror = true;
		setRotation(Engine_L1, 0F, 0F, 0F);
		Engine_L1a = new ModelRenderer(this, 54, 87);
		Engine_L1a.addBox(0F, 0F, 0F, 1, 1, 8);
		Engine_L1a.setRotationPoint(9F, 5F, 7F);
		Engine_L1a.setTextureSize(256, 128);
		Engine_L1a.mirror = true;
		setRotation(Engine_L1a, 0F, 0F, 0F);
		Engine_L1b = new ModelRenderer(this, 54, 95);
		Engine_L1b.addBox(0F, 0F, 0F, 5, 1, 1);
		Engine_L1b.setRotationPoint(5F, 4F, 14F);
		Engine_L1b.setTextureSize(256, 128);
		Engine_L1b.mirror = true;
		setRotation(Engine_L1b, 0F, 0F, 0F);
		Engine_L2b = new ModelRenderer(this, 1, 16);
		Engine_L2b.addBox(0F, 0F, 0F, 2, 4, 2);
		Engine_L2b.setRotationPoint(-12.5F, -5F, 9F);
		Engine_L2b.setTextureSize(256, 128);
		Engine_L2b.mirror = true;
		setRotation(Engine_L2b, 0F, 0F, 0F);
		Propeller_R1a = new ModelRenderer(this, 6, 76);
		Propeller_R1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_R1a.setRotationPoint(-17F, -2F, 15F);
		Propeller_R1a.setTextureSize(256, 128);
		Propeller_R1a.mirror = true;
		setRotation(Propeller_R1a, 0F, 0F, 0F);
		Propeller_R1b = new ModelRenderer(this, 0, 76);
		Propeller_R1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_R1b.setRotationPoint(-17F, -2F, 15F);
		Propeller_R1b.setTextureSize(256, 128);
		Propeller_R1b.mirror = true;
		setRotation(Propeller_R1b, 0F, 0F, 0F);
		Propeller_R1c = new ModelRenderer(this, 0, 86);
		Propeller_R1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_R1c.setRotationPoint(-17F, -2F, 15F);
		Propeller_R1c.setTextureSize(256, 128);
		Propeller_R1c.mirror = true;
		setRotation(Propeller_R1c, 0F, 0F, 0F);
		Propeller_L1a = new ModelRenderer(this, 6, 76);
		Propeller_L1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_L1a.setRotationPoint(17F, -2F, 15F);
		Propeller_L1a.setTextureSize(256, 128);
		Propeller_L1a.mirror = true;
		setRotation(Propeller_L1a, 0F, 0F, 0F);
		Propeller_L1b = new ModelRenderer(this, 0, 76);
		Propeller_L1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_L1b.setRotationPoint(17F, -2F, 15F);
		Propeller_L1b.setTextureSize(256, 128);
		Propeller_L1b.mirror = true;
		setRotation(Propeller_L1b, 0F, 0F, 0F);
		Propeller_L1c = new ModelRenderer(this, 0, 86);
		Propeller_L1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_L1c.setRotationPoint(17F, -2F, 15F);
		Propeller_L1c.setTextureSize(256, 128);
		Propeller_L1c.mirror = true;
		setRotation(Propeller_L1c, 0F, 0F, 0F);
		Propeller_FL1a = new ModelRenderer(this, 54, 101);
		Propeller_FL1a.addBox(-1F, -2F, -1F, 2, 4, 2);
		Propeller_FL1a.setRotationPoint(17F, 5F, 0F);
		Propeller_FL1a.setTextureSize(256, 128);
		Propeller_FL1a.mirror = true;
		setRotation(Propeller_FL1a, 0F, 0F, 0F);
		Propeller_FL1b = new ModelRenderer(this, 34, 94);
		Propeller_FL1b.addBox(-1F, 0F, -4F, 2, 1, 8);
		Propeller_FL1b.setRotationPoint(17F, 5F, 0F);
		Propeller_FL1b.setTextureSize(256, 128);
		Propeller_FL1b.mirror = true;
		setRotation(Propeller_FL1b, 0F, 0F, 0F);
		Propeller_FL1c = new ModelRenderer(this, 34, 104);
		Propeller_FL1c.addBox(-4F, 0F, -1F, 8, 1, 2);
		Propeller_FL1c.setRotationPoint(17F, 5F, 0F);
		Propeller_FL1c.setTextureSize(256, 128);
		Propeller_FL1c.mirror = true;
		setRotation(Propeller_FL1c, 0F, 0F, 0F);
		Engine_FL2a = new ModelRenderer(this, 102, 76);
		Engine_FL2a.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_FL2a.setRotationPoint(15F, -2F, -3F);
		Engine_FL2a.setTextureSize(256, 128);
		Engine_FL2a.mirror = true;
		setRotation(Engine_FL2a, 0F, 0F, 0F);
		Propeller_FR1b = new ModelRenderer(this, 34, 94);
		Propeller_FR1b.addBox(-1F, 0F, -4F, 2, 1, 8);
		Propeller_FR1b.setRotationPoint(-17F, 5F, 0F);
		Propeller_FR1b.setTextureSize(256, 128);
		Propeller_FR1b.mirror = true;
		setRotation(Propeller_FR1b, 0F, 0F, 0F);
		Propeller_FR1c = new ModelRenderer(this, 34, 104);
		Propeller_FR1c.addBox(-4F, 0F, -1F, 8, 1, 2);
		Propeller_FR1c.setRotationPoint(-17F, 5F, 0F);
		Propeller_FR1c.setTextureSize(256, 128);
		Propeller_FR1c.mirror = true;
		setRotation(Propeller_FR1c, 0F, 0F, 0F);
		Propeller_FR1a = new ModelRenderer(this, 54, 101);
		Propeller_FR1a.addBox(-1F, -2F, -1F, 2, 4, 2);
		Propeller_FR1a.setRotationPoint(-17F, 5F, 0F);
		Propeller_FR1a.setTextureSize(256, 128);
		Propeller_FR1a.mirror = true;
		setRotation(Propeller_FR1a, 0F, 0F, 0F);
		Engine_FR2a = new ModelRenderer(this, 102, 64);
		Engine_FR2a.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_FR2a.setRotationPoint(-19F, -2F, -3F);
		Engine_FR2a.setTextureSize(256, 128);
		Engine_FR2a.mirror = true;
		setRotation(Engine_FR2a, 0F, 0F, 0F);
		Pipe_L1a = new ModelRenderer(this, 78, 99);
		Pipe_L1a.addBox(0F, 0F, 0F, 5, 1, 1);
		Pipe_L1a.setRotationPoint(13F, 3F, 9F);
		Pipe_L1a.setTextureSize(256, 128);
		Pipe_L1a.mirror = true;
		setRotation(Pipe_L1a, 0F, 0F, 0F);
		Pipe_L1b = new ModelRenderer(this, 78, 92);
		Pipe_L1b.addBox(0F, 0F, 0F, 1, 1, 6);
		Pipe_L1b.setRotationPoint(17F, 3F, 3F);
		Pipe_L1b.setTextureSize(256, 128);
		Pipe_L1b.mirror = true;
		setRotation(Pipe_L1b, 0F, 0F, 0F);
		Pipe_R1a = new ModelRenderer(this, 78, 99);
		Pipe_R1a.addBox(0F, 0F, 0F, 5, 1, 1);
		Pipe_R1a.setRotationPoint(-18F, 3F, 9F);
		Pipe_R1a.setTextureSize(256, 128);
		Pipe_R1a.mirror = true;
		setRotation(Pipe_R1a, 0F, 0F, 0F);
		Pipe_R1b = new ModelRenderer(this, 78, 92);
		Pipe_R1b.addBox(0F, 0F, 0F, 1, 1, 6);
		Pipe_R1b.setRotationPoint(-18F, 3F, 3F);
		Pipe_R1b.setTextureSize(256, 128);
		Pipe_R1b.mirror = true;
		setRotation(Pipe_R1b, 0F, 0F, 0F);
		BalloonFrameRMa = new ModelRenderer(this, 240, 0);
		BalloonFrameRMa.addBox(0F, 0F, 0F, 6, 6, 2);
		BalloonFrameRMa.setRotationPoint(-20F, -5F, -14F);
		BalloonFrameRMa.setTextureSize(256, 128);
		BalloonFrameRMa.mirror = true;
		setRotation(BalloonFrameRMa, 0F, 0F, 0F);
		BalloonFrameRT1a = new ModelRenderer(this, 0, 0);
		BalloonFrameRT1a.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameRT1a.setRotationPoint(-12.5F, -7.5F, -12.5F);
		BalloonFrameRT1a.setTextureSize(256, 128);
		BalloonFrameRT1a.mirror = true;
		setRotation(BalloonFrameRT1a, 0F, 0F, 0F);
		BalloonFrameRT1b = new ModelRenderer(this, 0, 0);
		BalloonFrameRT1b.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameRT1b.setRotationPoint(-22.5F, -7.5F, -12.5F);
		BalloonFrameRT1b.setTextureSize(256, 128);
		BalloonFrameRT1b.mirror = true;
		setRotation(BalloonFrameRT1b, 0F, 0F, 0F);
		BalloonFrameRB1a = new ModelRenderer(this, 0, 0);
		BalloonFrameRB1a.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameRB1a.setRotationPoint(-12.5F, 2.5F, -12.5F);
		BalloonFrameRB1a.setTextureSize(256, 128);
		BalloonFrameRB1a.mirror = true;
		setRotation(BalloonFrameRB1a, 0F, 0F, 0F);
		BalloonFrameRB1b = new ModelRenderer(this, 0, 0);
		BalloonFrameRB1b.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameRB1b.setRotationPoint(-22.5F, 2.5F, -12.5F);
		BalloonFrameRB1b.setTextureSize(256, 128);
		BalloonFrameRB1b.mirror = true;
		setRotation(BalloonFrameRB1b, 0F, 0F, 0F);
		BalloonFrameRT2a1 = new ModelRenderer(this, 0, 0);
		BalloonFrameRT2a1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameRT2a1.setRotationPoint(-13.5F, -6.5F, -13.5F);
		BalloonFrameRT2a1.setTextureSize(256, 128);
		BalloonFrameRT2a1.mirror = true;
		setRotation(BalloonFrameRT2a1, 0F, 0F, 0F);
		BalloonFrameRT2a2 = new ModelRenderer(this, 0, 0);
		BalloonFrameRT2a2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameRT2a2.setRotationPoint(-14.5F, -5.5F, -14.5F);
		BalloonFrameRT2a2.setTextureSize(256, 128);
		BalloonFrameRT2a2.mirror = true;
		setRotation(BalloonFrameRT2a2, 0F, 0F, 0F);
		BalloonFrameRT2b1 = new ModelRenderer(this, 0, 0);
		BalloonFrameRT2b1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameRT2b1.setRotationPoint(-21.5F, -6.5F, -13.5F);
		BalloonFrameRT2b1.setTextureSize(256, 128);
		BalloonFrameRT2b1.mirror = true;
		setRotation(BalloonFrameRT2b1, 0F, 0F, 0F);
		BalloonFrameRT2b2 = new ModelRenderer(this, 0, 0);
		BalloonFrameRT2b2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameRT2b2.setRotationPoint(-20.5F, -5.5F, -14.5F);
		BalloonFrameRT2b2.setTextureSize(256, 128);
		BalloonFrameRT2b2.mirror = true;
		setRotation(BalloonFrameRT2b2, 0F, 0F, 0F);
		BalloonFrameRB2a1 = new ModelRenderer(this, 0, 0);
		BalloonFrameRB2a1.addBox(0F, 0F, -1F, 1, 1, 28);
		BalloonFrameRB2a1.setRotationPoint(-13.5F, 1.5F, -12.5F);
		BalloonFrameRB2a1.setTextureSize(256, 128);
		BalloonFrameRB2a1.mirror = true;
		setRotation(BalloonFrameRB2a1, 0F, 0F, 0F);
		BalloonFrameRB2a2 = new ModelRenderer(this, 0, 0);
		BalloonFrameRB2a2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameRB2a2.setRotationPoint(-14.5F, 0.5F, -14.5F);
		BalloonFrameRB2a2.setTextureSize(256, 128);
		BalloonFrameRB2a2.mirror = true;
		setRotation(BalloonFrameRB2a2, 0F, 0F, 0F);
		BalloonFrameRB2b1 = new ModelRenderer(this, 0, 0);
		BalloonFrameRB2b1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameRB2b1.setRotationPoint(-21.5F, 1.5F, -13.5F);
		BalloonFrameRB2b1.setTextureSize(256, 128);
		BalloonFrameRB2b1.mirror = true;
		setRotation(BalloonFrameRB2b1, 0F, 0F, 0F);
		BalloonFrameRB2b2 = new ModelRenderer(this, 0, 0);
		BalloonFrameRB2b2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameRB2b2.setRotationPoint(-20.5F, 0.5F, -14.5F);
		BalloonFrameRB2b2.setTextureSize(256, 128);
		BalloonFrameRB2b2.mirror = true;
		setRotation(BalloonFrameRB2b2, 0F, 0F, 0F);
		AnchorRa = new ModelRenderer(this, 0, 0);
		AnchorRa.addBox(0F, 0F, 0F, 2, 2, 6);
		AnchorRa.setRotationPoint(-9.5F, 0.5F, -3F);
		AnchorRa.setTextureSize(256, 128);
		AnchorRa.mirror = true;
		setRotation(AnchorRa, 0F, 0F, 0F);
		JointR1a = new ModelRenderer(this, 10, 0);
		JointR1a.addBox(-4F, -0.5F, -0.5F, 4, 1, 1);
		JointR1a.setRotationPoint(-8.5F, 1.5F, -2F);
		JointR1a.setTextureSize(256, 128);
		JointR1a.mirror = true;
		setRotation(JointR1a, 0.7853982F, -0.2792527F, -0.2617994F);
		JointR1b = new ModelRenderer(this, 10, 0);
		JointR1b.addBox(-4F, -0.5F, -0.5F, 4, 1, 1);
		JointR1b.setRotationPoint(-8.5F, 1.5F, 2F);
		JointR1b.setTextureSize(256, 128);
		JointR1b.mirror = true;
		setRotation(JointR1b, 0.7853982F, 0.2792527F, -0.2617994F);
		BalloonFrameLMa = new ModelRenderer(this, 240, 8);
		BalloonFrameLMa.addBox(0F, 0F, 0F, 6, 6, 2);
		BalloonFrameLMa.setRotationPoint(14F, -5F, -14F);
		BalloonFrameLMa.setTextureSize(256, 128);
		BalloonFrameLMa.mirror = true;
		setRotation(BalloonFrameLMa, 0F, 0F, 0F);
		BalloonFrameLT1a = new ModelRenderer(this, 0, 0);
		BalloonFrameLT1a.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameLT1a.setRotationPoint(21.5F, -7.5F, -12.5F);
		BalloonFrameLT1a.setTextureSize(256, 128);
		BalloonFrameLT1a.mirror = true;
		setRotation(BalloonFrameLT1a, 0F, 0F, 0F);
		BalloonFrameLT1b = new ModelRenderer(this, 0, 0);
		BalloonFrameLT1b.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameLT1b.setRotationPoint(11.5F, -7.5F, -12.5F);
		BalloonFrameLT1b.setTextureSize(256, 128);
		BalloonFrameLT1b.mirror = true;
		setRotation(BalloonFrameLT1b, 0F, 0F, 0F);
		BalloonFrameLB1a = new ModelRenderer(this, 0, 0);
		BalloonFrameLB1a.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameLB1a.setRotationPoint(21.5F, 2.5F, -12.5F);
		BalloonFrameLB1a.setTextureSize(256, 128);
		BalloonFrameLB1a.mirror = true;
		setRotation(BalloonFrameLB1a, 0F, 0F, 0F);
		BalloonFrameLB1b = new ModelRenderer(this, 0, 0);
		BalloonFrameLB1b.addBox(0F, 0F, 0F, 1, 1, 26);
		BalloonFrameLB1b.setRotationPoint(11.5F, 2.5F, -12.5F);
		BalloonFrameLB1b.setTextureSize(256, 128);
		BalloonFrameLB1b.mirror = true;
		setRotation(BalloonFrameLB1b, 0F, 0F, 0F);
		BalloonFrameLT2a1 = new ModelRenderer(this, 0, 0);
		BalloonFrameLT2a1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameLT2a1.setRotationPoint(20.5F, -6.5F, -13.5F);
		BalloonFrameLT2a1.setTextureSize(256, 128);
		BalloonFrameLT2a1.mirror = true;
		setRotation(BalloonFrameLT2a1, 0F, 0F, 0F);
		BalloonFrameLT2a2 = new ModelRenderer(this, 0, 0);
		BalloonFrameLT2a2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameLT2a2.setRotationPoint(19.5F, -5.5F, -14.5F);
		BalloonFrameLT2a2.setTextureSize(256, 128);
		BalloonFrameLT2a2.mirror = true;
		setRotation(BalloonFrameLT2a2, 0F, 0F, 0F);
		BalloonFrameLT2b1 = new ModelRenderer(this, 0, 0);
		BalloonFrameLT2b1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameLT2b1.setRotationPoint(12.5F, -6.5F, -13.5F);
		BalloonFrameLT2b1.setTextureSize(256, 128);
		BalloonFrameLT2b1.mirror = true;
		setRotation(BalloonFrameLT2b1, 0F, 0F, 0F);
		BalloonFrameLT2b2 = new ModelRenderer(this, 0, 0);
		BalloonFrameLT2b2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameLT2b2.setRotationPoint(13.5F, -5.5F, -14.5F);
		BalloonFrameLT2b2.setTextureSize(256, 128);
		BalloonFrameLT2b2.mirror = true;
		setRotation(BalloonFrameLT2b2, 0F, 0F, 0F);
		BalloonFrameLB2a1 = new ModelRenderer(this, 0, 0);
		BalloonFrameLB2a1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameLB2a1.setRotationPoint(20.5F, 1.5F, -13.5F);
		BalloonFrameLB2a1.setTextureSize(256, 128);
		BalloonFrameLB2a1.mirror = true;
		setRotation(BalloonFrameLB2a1, 0F, 0F, 0F);
		BalloonFrameLB2a2 = new ModelRenderer(this, 0, 0);
		BalloonFrameLB2a2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameLB2a2.setRotationPoint(19.5F, 0.5F, -14.5F);
		BalloonFrameLB2a2.setTextureSize(256, 128);
		BalloonFrameLB2a2.mirror = true;
		setRotation(BalloonFrameLB2a2, 0F, 0F, 0F);
		BalloonFrameLB2b1 = new ModelRenderer(this, 0, 0);
		BalloonFrameLB2b1.addBox(0F, 0F, 0F, 1, 1, 28);
		BalloonFrameLB2b1.setRotationPoint(12.5F, 1.5F, -13.5F);
		BalloonFrameLB2b1.setTextureSize(256, 128);
		BalloonFrameLB2b1.mirror = true;
		setRotation(BalloonFrameLB2b1, 0F, 0F, 0F);
		BalloonFrameLB2b2 = new ModelRenderer(this, 0, 0);
		BalloonFrameLB2b2.addBox(0F, 0F, 0F, 1, 1, 29);
		BalloonFrameLB2b2.setRotationPoint(13.5F, 0.5F, -14.5F);
		BalloonFrameLB2b2.setTextureSize(256, 128);
		BalloonFrameLB2b2.mirror = true;
		setRotation(BalloonFrameLB2b2, 0F, 0F, 0F);
		AnchorLa = new ModelRenderer(this, 0, 0);
		AnchorLa.addBox(0F, 0F, 0F, 2, 2, 6);
		AnchorLa.setRotationPoint(7.5F, 0.5F, -3F);
		AnchorLa.setTextureSize(256, 128);
		AnchorLa.mirror = true;
		setRotation(AnchorLa, 0F, 0F, 0F);
		JointL1a = new ModelRenderer(this, 10, 0);
		JointL1a.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		JointL1a.setRotationPoint(8.5F, 1.5F, 2F);
		JointL1a.setTextureSize(256, 128);
		JointL1a.mirror = true;
		setRotation(JointL1a, 0.7853982F, -0.2792527F, 0.2617994F);
		JointL1b = new ModelRenderer(this, 10, 0);
		JointL1b.addBox(0F, -0.5F, -0.5F, 4, 1, 1);
		JointL1b.setRotationPoint(8.5F, 1.5F, -2F);
		JointL1b.setTextureSize(256, 128);
		JointL1b.mirror = true;
		setRotation(JointL1b, 0.7853982F, 0.2792527F, 0.2617994F);
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
		Engine_R2b.render(f5);
		Engine_L1.render(f5);
		Engine_L1a.render(f5);
		Engine_L1b.render(f5);
		Engine_L2b.render(f5);
		Propeller_R1a.render(f5);
		Propeller_R1b.render(f5);
		Propeller_R1c.render(f5);
		Propeller_L1a.render(f5);
		Propeller_L1b.render(f5);
		Propeller_L1c.render(f5);
		Propeller_FL1a.render(f5);
		Propeller_FL1b.render(f5);
		Propeller_FL1c.render(f5);
		Engine_FL2a.render(f5);
		Propeller_FR1b.render(f5);
		Propeller_FR1c.render(f5);
		Propeller_FR1a.render(f5);
		Engine_FR2a.render(f5);
		Pipe_L1a.render(f5);
		Pipe_L1b.render(f5);
		Pipe_R1a.render(f5);
		Pipe_R1b.render(f5);
		BalloonFrameRMa.render(f5);
		BalloonFrameRT1a.render(f5);
		BalloonFrameRT1b.render(f5);
		BalloonFrameRB1a.render(f5);
		BalloonFrameRB1b.render(f5);
		BalloonFrameRT2a1.render(f5);
		BalloonFrameRT2a2.render(f5);
		BalloonFrameRT2b1.render(f5);
		BalloonFrameRT2b2.render(f5);
		BalloonFrameRB2a1.render(f5);
		BalloonFrameRB2a2.render(f5);
		BalloonFrameRB2b1.render(f5);
		BalloonFrameRB2b2.render(f5);
		AnchorRa.render(f5);
		JointR1a.render(f5);
		JointR1b.render(f5);
		BalloonFrameLMa.render(f5);
		BalloonFrameLT1a.render(f5);
		BalloonFrameLT1b.render(f5);
		BalloonFrameLB1a.render(f5);
		BalloonFrameLB1b.render(f5);
		BalloonFrameLT2a1.render(f5);
		BalloonFrameLT2a2.render(f5);
		BalloonFrameLT2b1.render(f5);
		BalloonFrameLT2b2.render(f5);
		BalloonFrameLB2a1.render(f5);
		BalloonFrameLB2a2.render(f5);
		BalloonFrameLB2b1.render(f5);
		BalloonFrameLB2b2.render(f5);
		AnchorLa.render(f5);
		JointL1a.render(f5);
		JointL1b.render(f5);
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
