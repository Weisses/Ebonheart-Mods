package com.viesis.viescraft.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV3Off extends ModelBase {
	
	private float bladespin;
	private long lastframe;
	
	//fields
    ModelRenderer Base_1a;
    ModelRenderer Base_Seat_1a;
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
    ModelRenderer Base_Front_2d;
    ModelRenderer Base_Side_L1;
    ModelRenderer Base_Side_L2;
    ModelRenderer Base_Side_L3;
    ModelRenderer Base_Side_L4;
    ModelRenderer Base_Side_R1;
    ModelRenderer Base_Side_R2;
    ModelRenderer Base_Side_R3;
    ModelRenderer Base_Side_R4;
    ModelRenderer Base_Back_1a;
    ModelRenderer Base_Back_1c;
    ModelRenderer Base_Corner_F1;
    ModelRenderer Base_Corner_F2;
    ModelRenderer Base_Corner_B1;
    ModelRenderer Base_Corner_B2;
    ModelRenderer Engine_M1a;
    ModelRenderer Engine_M1b;
    ModelRenderer Engine_M1c;
    ModelRenderer Engine_M1d;
    ModelRenderer Engine_R1;
    ModelRenderer Engine_L1;
    ModelRenderer Propeller_R1a;
    ModelRenderer Propeller_R1b;
    ModelRenderer Propeller_R1c;
    ModelRenderer Propeller_L1a;
    ModelRenderer Propeller_L1b;
    ModelRenderer Propeller_L1c;
    ModelRenderer Engine_FL2a;
    ModelRenderer Engine_FR2a;
    ModelRenderer BalloonL1a;
    ModelRenderer BalloonL1b;
    ModelRenderer BalloonR1a;
    ModelRenderer BalloonR1b;
    ModelRenderer BalloonR2a;
    ModelRenderer BalloonL2a;
    ModelRenderer BalloonR2b;
    ModelRenderer BalloonL2b;
    ModelRenderer Pole1;
    ModelRenderer Pole2;
    ModelRenderer Engine_R1c;
    ModelRenderer Engine_L1c;
    
    public ModelAirshipV3Off()
    {
    	textureWidth = 256;
    	textureHeight = 128;
    	
	    Base_1a = new ModelRenderer(this, 0, 0);
		Base_1a.addBox(0F, 0F, 0F, 14, 2, 24);
		Base_1a.setRotationPoint(-7F, 5F, -12F);
		Base_1a.setTextureSize(256, 128);
		Base_1a.mirror = true;
		setRotation(Base_1a, 0F, 0F, 0F);
		Base_Seat_1a = new ModelRenderer(this, 0, 32);
		Base_Seat_1a.addBox(0F, 0F, 0F, 10, 2, 8);
		Base_Seat_1a.setRotationPoint(-5F, 4F, 3F);
		Base_Seat_1a.setTextureSize(256, 128);
		Base_Seat_1a.mirror = true;
		setRotation(Base_Seat_1a, 0F, 0F, 0F);
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
		Anchor_1a.setRotationPoint(7F, 0F, 6F);
		Anchor_1a.setTextureSize(256, 128);
		Anchor_1a.mirror = true;
		setRotation(Anchor_1a, 0F, 0F, 0F);
		Anchor_1b = new ModelRenderer(this, 0, 4);
		Anchor_1b.addBox(0F, 0F, 0F, 3, 2, 2);
		Anchor_1b.setRotationPoint(-10F, 0F, 6F);
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
		Base_Front_2d = new ModelRenderer(this, 3, 1);
		Base_Front_2d.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Front_2d.setRotationPoint(-7F, 0F, -15F);
		Base_Front_2d.setTextureSize(256, 128);
		Base_Front_2d.mirror = true;
		setRotation(Base_Front_2d, 0F, 0F, 0F);
		Base_Side_L1 = new ModelRenderer(this, 3, 1);
		Base_Side_L1.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_L1.setRotationPoint(-9F, 0F, -10F);
		Base_Side_L1.setTextureSize(256, 128);
		Base_Side_L1.mirror = true;
		setRotation(Base_Side_L1, 0F, 0F, 0F);
		Base_Side_L2 = new ModelRenderer(this, 3, 1);
		Base_Side_L2.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_L2.setRotationPoint(-9F, 0F, -6F);
		Base_Side_L2.setTextureSize(256, 128);
		Base_Side_L2.mirror = true;
		setRotation(Base_Side_L2, 0F, 0F, 0F);
		Base_Side_L3 = new ModelRenderer(this, 3, 1);
		Base_Side_L3.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_L3.setRotationPoint(-9F, 0F, -2F);
		Base_Side_L3.setTextureSize(256, 128);
		Base_Side_L3.mirror = true;
		setRotation(Base_Side_L3, 0F, 0F, 0F);
		Base_Side_L4 = new ModelRenderer(this, 3, 1);
		Base_Side_L4.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_L4.setRotationPoint(-9F, 0F, 2F);
		Base_Side_L4.setTextureSize(256, 128);
		Base_Side_L4.mirror = true;
		setRotation(Base_Side_L4, 0F, 0F, 0F);
		Base_Side_R1 = new ModelRenderer(this, 3, 1);
		Base_Side_R1.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_R1.setRotationPoint(8F, 0F, -10F);
		Base_Side_R1.setTextureSize(256, 128);
		Base_Side_R1.mirror = true;
		setRotation(Base_Side_R1, 0F, 0F, 0F);
		Base_Side_R2 = new ModelRenderer(this, 3, 1);
		Base_Side_R2.addBox(0F, 0F, 0F, 1, 1, 1);
		Base_Side_R2.setRotationPoint(8F, 0F, -6F);
		Base_Side_R2.setTextureSize(256, 128);
	 	Base_Side_R2.mirror = true;
	 	setRotation(Base_Side_R2, 0F, 0F, 0F);
	 	Base_Side_R3 = new ModelRenderer(this, 3, 1);
	 	Base_Side_R3.addBox(0F, 0F, 0F, 1, 1, 1);
	 	Base_Side_R3.setRotationPoint(8F, 0F, -2F);
	 	Base_Side_R3.setTextureSize(256, 128);
	 	Base_Side_R3.mirror = true;
	 	setRotation(Base_Side_R3, 0F, 0F, 0F);
	 	Base_Side_R4 = new ModelRenderer(this, 3, 1);
	 	Base_Side_R4.addBox(0F, 0F, 0F, 1, 1, 1);
	 	Base_Side_R4.setRotationPoint(8F, 0F, 2F);
	 	Base_Side_R4.setTextureSize(256, 128);
	 	Base_Side_R4.mirror = true;
	 	setRotation(Base_Side_R4, 0F, 0F, 0F);
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
		Engine_R1.setRotationPoint(-13F, -14F, 9F);
		Engine_R1.setTextureSize(256, 128);
		Engine_R1.mirror = true;
		setRotation(Engine_R1, 0F, 0F, 0F);
		Engine_L1 = new ModelRenderer(this, 34, 64);
		Engine_L1.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_L1.setRotationPoint(9F, -13F, 9F);
		Engine_L1.setTextureSize(256, 128);
		Engine_L1.mirror = true;
		setRotation(Engine_L1, 0F, 0F, 0F);
		Propeller_R1a = new ModelRenderer(this, 6, 76);
		Propeller_R1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_R1a.setRotationPoint(-17F, 1F, 15F);
		Propeller_R1a.setTextureSize(256, 128);
		Propeller_R1a.mirror = true;
		setRotation(Propeller_R1a, 0F, 0F, 0F);
		Propeller_R1b = new ModelRenderer(this, 0, 76);
		Propeller_R1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_R1b.setRotationPoint(-17F, 1F, 15F);
		Propeller_R1b.setTextureSize(256, 128);
		Propeller_R1b.mirror = true;
		setRotation(Propeller_R1b, 0F, 0F, 0F);
		Propeller_R1c = new ModelRenderer(this, 0, 86);
		Propeller_R1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_R1c.setRotationPoint(-17F, 1F, 15F);
		Propeller_R1c.setTextureSize(256, 128);
		Propeller_R1c.mirror = true;
		setRotation(Propeller_R1c, 0F, 0F, 0F);
		Propeller_L1a = new ModelRenderer(this, 6, 76);
		Propeller_L1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_L1a.setRotationPoint(17F, 1F, 15F);
		Propeller_L1a.setTextureSize(256, 128);
		Propeller_L1a.mirror = true;
		setRotation(Propeller_L1a, 0F, 0F, 0F);
		Propeller_L1b = new ModelRenderer(this, 0, 76);
		Propeller_L1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_L1b.setRotationPoint(17F, 1F, 15F);
		Propeller_L1b.setTextureSize(256, 128);
		Propeller_L1b.mirror = true;
		setRotation(Propeller_L1b, 0F, 0F, 0F);
		Propeller_L1c = new ModelRenderer(this, 0, 86);
		Propeller_L1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_L1c.setRotationPoint(17F, 1F, 15F);
		Propeller_L1c.setTextureSize(256, 128);
		Propeller_L1c.mirror = true;
		setRotation(Propeller_L1c, 0F, 0F, 0F);
		Engine_FL2a = new ModelRenderer(this, 102, 76);
		Engine_FL2a.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_FL2a.setRotationPoint(15F, -7F, 4F);
		Engine_FL2a.setTextureSize(256, 128);
		Engine_FL2a.mirror = true;
		setRotation(Engine_FL2a, 0F, 0F, 0F);
		Engine_FR2a = new ModelRenderer(this, 102, 64);
		Engine_FR2a.addBox(0F, 0F, 0F, 4, 6, 6);
		Engine_FR2a.setRotationPoint(-19F, -7F, 4F);
		Engine_FR2a.setTextureSize(256, 128);
		Engine_FR2a.mirror = true;
		setRotation(Engine_FR2a, 0F, 0F, 0F);
		BalloonL1a = new ModelRenderer(this, 186, 58);
		BalloonL1a.addBox(0F, 0F, 0F, 6, 6, 29);
		BalloonL1a.setRotationPoint(14F, -13F, -11F);
		BalloonL1a.setTextureSize(256, 128);
		BalloonL1a.mirror = true;
		setRotation(BalloonL1a, 0F, 0F, 0F);
		BalloonL1b = new ModelRenderer(this, 186, 93);
		BalloonL1b.addBox(0F, 0F, 0F, 8, 8, 27);
		BalloonL1b.setRotationPoint(13F, -14F, -10F);
		BalloonL1b.setTextureSize(256, 128);
		BalloonL1b.mirror = true;
		setRotation(BalloonL1b, 0F, 0F, 0F);
		BalloonR1a = new ModelRenderer(this, 186, 58);
		BalloonR1a.addBox(0F, 0F, 0F, 6, 6, 29);
		BalloonR1a.setRotationPoint(-20F, -13F, -11F);
		BalloonR1a.setTextureSize(256, 128);
		BalloonR1a.mirror = true;
		setRotation(BalloonR1a, 0F, 0F, 0F);
		BalloonR1b = new ModelRenderer(this, 186, 93);
		BalloonR1b.addBox(0F, 0F, 0F, 8, 8, 27);
		BalloonR1b.setRotationPoint(-21F, -14F, -10F);
		BalloonR1b.setTextureSize(256, 128);
		BalloonR1b.mirror = true;
		setRotation(BalloonR1b, 0F, 0F, 0F);
		BalloonR2a = new ModelRenderer(this, 212, 16);
		BalloonR2a.addBox(0F, 0F, 0F, 6, 6, 16);
		BalloonR2a.setRotationPoint(-20F, -2F, -2F);
		BalloonR2a.setTextureSize(256, 128);
		BalloonR2a.mirror = true;
		setRotation(BalloonR2a, 0F, 0F, 0F);
		BalloonL2a = new ModelRenderer(this, 212, 16);
		BalloonL2a.addBox(0F, 0F, 0F, 6, 6, 16);
		BalloonL2a.setRotationPoint(14F, -2F, -2F);
		BalloonL2a.setTextureSize(256, 128);
		BalloonL2a.mirror = true;
		setRotation(BalloonL2a, 0F, 0F, 0F);
		BalloonR2b = new ModelRenderer(this, 216, 38);
		BalloonR2b.addBox(0F, 0F, 0F, 4, 4, 16);
		BalloonR2b.setRotationPoint(15F, -1F, -3F);
		BalloonR2b.setTextureSize(256, 128);
		BalloonR2b.mirror = true;
		setRotation(BalloonR2b, 0F, 0F, 0F);
		BalloonL2b = new ModelRenderer(this, 216, 38);
		BalloonL2b.addBox(0F, 0F, 0F, 4, 4, 16);
		BalloonL2b.setRotationPoint(-19F, -1F, -3F);
		BalloonL2b.setTextureSize(256, 128);
		BalloonL2b.mirror = true;
		setRotation(BalloonL2b, 0F, 0F, 0F);
		Pole1 = new ModelRenderer(this, 2, 0);
		Pole1.addBox(-0.5F, -9F, -1F, 1, 10, 2);
		Pole1.setRotationPoint(-8.5F, 0F, 8F);
		Pole1.setTextureSize(256, 128);
		Pole1.mirror = true;
		setRotation(Pole1, -0.4537856F, 0F, -0.3490659F);
		Pole2 = new ModelRenderer(this, 2, 0);
		Pole2.addBox(-0.5F, -9F, -1F, 1, 10, 2);
		Pole2.setRotationPoint(8.5F, 0F, 8F);
		Pole2.setTextureSize(256, 128);
		Pole2.mirror = true;
		setRotation(Pole2, -0.4537856F, 0F, 0.3490659F);
		Engine_R1c = new ModelRenderer(this, 54, 84);
	    Engine_R1c.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
	    Engine_R1c.setRotationPoint(-10F, -9F, 15F);
	    Engine_R1c.setTextureSize(256, 128);
	    Engine_R1c.mirror = true;
	    setRotation(Engine_R1c, 0F, 0F, -0.4363323F);
	    Engine_L1c = new ModelRenderer(this, 54, 84);
	    Engine_L1c.addBox(-0.5F, 0F, -0.5F, 1, 13, 1);
	    Engine_L1c.setRotationPoint(10F, -9F, 15F);
	    Engine_L1c.setTextureSize(256, 128);
	    Engine_L1c.mirror = true;
	    setRotation(Engine_L1c, 0F, 0F, 0.4363323F);
    }
    
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
    	super.render(entity, f, f1, f2, f3, f4, f5);
    	setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    	Base_1a.render(f5);
    	Base_Seat_1a.render(f5);
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
	    Base_Front_2d.render(f5);
	    Base_Side_L1.render(f5);
	    Base_Side_L2.render(f5);
	    Base_Side_L3.render(f5);
	    Base_Side_L4.render(f5);
	    Base_Side_R1.render(f5);
	    Base_Side_R2.render(f5);
	    Base_Side_R3.render(f5);
	    Base_Side_R4.render(f5);
	    Base_Back_1a.render(f5);
	    Base_Back_1c.render(f5);
	    Base_Corner_F1.render(f5);
	    Base_Corner_F2.render(f5);
	    Base_Corner_B1.render(f5);
	    Base_Corner_B2.render(f5);
	    Engine_M1a.render(f5);
	    Engine_M1b.render(f5);
	    Engine_M1c.render(f5);
	    Engine_M1d.render(f5);
	    Engine_R1.render(f5);
	    Engine_L1.render(f5);
	    Propeller_R1a.render(f5);
	    Propeller_R1b.render(f5);
	    Propeller_R1c.render(f5);
	    Propeller_L1a.render(f5);
	    Propeller_L1b.render(f5);
	    Propeller_L1c.render(f5);
	    Engine_FL2a.render(f5);
	    Engine_FR2a.render(f5);
	    BalloonL1a.render(f5);
	    BalloonL1b.render(f5);
	    BalloonR1a.render(f5);
	    BalloonR1b.render(f5);
	    BalloonR2a.render(f5);
	    BalloonL2a.render(f5);
	    BalloonR2b.render(f5);
	    BalloonL2b.render(f5);
	    Pole1.render(f5);
	    Pole2.render(f5);
	    Engine_R1c.render(f5);
	    Engine_L1c.render(f5);
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
