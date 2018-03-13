package com.viesis.viescraft.client.entity.model.v1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipV1Frame extends ModelBase
{
    ModelRenderer BaseWoodChest;
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
    ModelRenderer Engine_PipePivot_R;
    ModelRenderer Engine_PipePivot_L;
    ModelRenderer Engine_L1b;
    ModelRenderer Engine_L2a;
    ModelRenderer BalloonFrameRT1;
    ModelRenderer BalloonFrameRM1a;
    ModelRenderer BalloonFrameRM1b;
    ModelRenderer BalloonFrameRB1;
    ModelRenderer BalloonFrameLT1;
    ModelRenderer BalloonFrameLM1a;
    ModelRenderer BalloonFrameLM1b;
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
    ModelRenderer ItemFrameFront1;
    ModelRenderer ItemFrameFront2;
    ModelRenderer ItemFrameControlBraceOverlay;
    ModelRenderer ItemFrameLeftInside;
    ModelRenderer ItemFrameLeftBorderT;
    ModelRenderer ItemFrameLeftBorderB;
    ModelRenderer ItemFrameLeftBorderR;
    ModelRenderer ItemFrameLeftBorderL;
    ModelRenderer ItemFrameRightInside;
    ModelRenderer ItemFrameRightBorderT;
    ModelRenderer ItemFrameRightBorderB;
    ModelRenderer ItemFrameRightBorderR;
    ModelRenderer ItemFrameRightBorderL;
    ModelRenderer BombBay;

    public ModelAirshipV1Frame()
    {
        this( 0.0f );
    }

    public ModelAirshipV1Frame( float par1 )
    {
        BaseWoodChest = new ModelRenderer( this, 150, 43 );
        BaseWoodChest.setTextureSize( 256, 128 );
        BaseWoodChest.addBox( 0F, 0F, 0F, 10, 2, 8);
        BaseWoodChest.setRotationPoint( -5F, 4F, 3F );
        Base_1a = new ModelRenderer( this, 0, 0 );
        Base_1a.setTextureSize( 256, 128 );
        Base_1a.addBox( 0F, 0F, 0F, 14, 2, 24);
        Base_1a.setRotationPoint( -7F, 5F, -12F );
        Base_Seat_1b = new ModelRenderer( this, 0, 42 );
        Base_Seat_1b.setTextureSize( 256, 128 );
        Base_Seat_1b.addBox( 0F, 0F, 0F, 10, 2, 8);
        Base_Seat_1b.setRotationPoint( -5F, 4F, -6F );
        Base_Side_1a = new ModelRenderer( this, 0, 64 );
        Base_Side_1a.setTextureSize( 256, 128 );
        Base_Side_1a.addBox( 0F, 0F, 0F, 1, 4, 26);
        Base_Side_1a.setRotationPoint( 8F, 1F, -13F );
        Base_Side_1b = new ModelRenderer( this, 92, 0 );
        Base_Side_1b.setTextureSize( 256, 128 );
        Base_Side_1b.addBox( 0F, 0F, 0F, 1, 2, 24);
        Base_Side_1b.setRotationPoint( 7F, 4F, -12F );
        Base_Side_2a = new ModelRenderer( this, 0, 64 );
        Base_Side_2a.setTextureSize( 256, 128 );
        Base_Side_2a.addBox( 0F, 0F, 0F, 1, 4, 26);
        Base_Side_2a.setRotationPoint( -9F, 1F, -13F );
        Base_Side_2b = new ModelRenderer( this, 92, 0 );
        Base_Side_2b.setTextureSize( 256, 128 );
        Base_Side_2b.addBox( 0F, 0F, 0F, 1, 2, 24);
        Base_Side_2b.setRotationPoint( -8F, 4F, -12F );
        Anchor_1a = new ModelRenderer( this, 0, 0 );
        Anchor_1a.setTextureSize( 256, 128 );
        Anchor_1a.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_1a.setRotationPoint( 7F, 0F, -10F );
        Anchor_1b = new ModelRenderer( this, 0, 0 );
        Anchor_1b.setTextureSize( 256, 128 );
        Anchor_1b.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_1b.setRotationPoint( -10F, 0F, -10F );
        Anchor_1c = new ModelRenderer( this, 0, 0 );
        Anchor_1c.setTextureSize( 256, 128 );
        Anchor_1c.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_1c.setRotationPoint( -10F, 0F, 8F );
        Anchor_1d = new ModelRenderer( this, 0, 0 );
        Anchor_1d.setTextureSize( 256, 128 );
        Anchor_1d.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_1d.setRotationPoint( 7F, 0F, 8F );
        Anchor_2a = new ModelRenderer( this, 64, 0 );
        Anchor_2a.setTextureSize( 256, 128 );
        Anchor_2a.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2a.setRotationPoint( -14F, -22F, -14F );
        Anchor_2b = new ModelRenderer( this, 64, 0 );
        Anchor_2b.setTextureSize( 256, 128 );
        Anchor_2b.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2b.setRotationPoint( -14F, -22F, 11F );
        Anchor_2c = new ModelRenderer( this, 64, 0 );
        Anchor_2c.setTextureSize( 256, 128 );
        Anchor_2c.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2c.setRotationPoint( 11F, -22F, -14F );
        Anchor_2d = new ModelRenderer( this, 64, 0 );
        Anchor_2d.setTextureSize( 256, 128 );
        Anchor_2d.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2d.setRotationPoint( 11F, -22F, 11F );
        Base_Front_1a1 = new ModelRenderer( this, 2, 94 );
        Base_Front_1a1.setTextureSize( 256, 128 );
        Base_Front_1a1.addBox( 0F, 0F, 0F, 14, 4, 1);
        Base_Front_1a1.setRotationPoint( -7F, 1F, -15F );
        Base_Front_1aR = new ModelRenderer( this, 38, 99 );
        Base_Front_1aR.setTextureSize( 256, 128 );
        Base_Front_1aR.addBox( 0F, 0F, 0F, 1, 4, 1);
        Base_Front_1aR.setRotationPoint( -8F, 1F, -14F );
        Base_Front_1aL = new ModelRenderer( this, 34, 99 );
        Base_Front_1aL.setTextureSize( 256, 128 );
        Base_Front_1aL.addBox( 0F, 0F, 0F, 1, 4, 1);
        Base_Front_1aL.setRotationPoint( 7F, 1F, -14F );
        Base_Front_1aM = new ModelRenderer( this, 0, 110 );
        Base_Front_1aM.setTextureSize( 256, 128 );
        Base_Front_1aM.addBox( 0F, 0F, 0F, 14, 2, 1);
        Base_Front_1aM.setRotationPoint( -7F, 4F, -14F );
        Base_Front_1c = new ModelRenderer( this, 0, 104 );
        Base_Front_1c.setTextureSize( 256, 128 );
        Base_Front_1c.addBox( 0F, 0F, 0F, 16, 2, 1);
        Base_Front_1c.setRotationPoint( -8F, 4F, -13F );
        Base_Front_2a = new ModelRenderer( this, 10, 2 );
        Base_Front_2a.setTextureSize( 256, 128 );
        Base_Front_2a.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Front_2a.setRotationPoint( 6F, 0F, -15F );
        Base_Front_2b = new ModelRenderer( this, 10, 0 );
        Base_Front_2b.setTextureSize( 256, 128 );
        Base_Front_2b.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Front_2b.setRotationPoint( 3F, 0F, -15F );
        Base_Front_2c = new ModelRenderer( this, 10, 4 );
        Base_Front_2c.setTextureSize( 256, 128 );
        Base_Front_2c.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Front_2c.setRotationPoint( -4F, 0F, -15F );
        Base_Front_2d = new ModelRenderer( this, 10, 6 );
        Base_Front_2d.setTextureSize( 256, 128 );
        Base_Front_2d.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Front_2d.setRotationPoint( -7F, 0F, -15F );
        Base_Back_1a = new ModelRenderer( this, 0, 99 );
        Base_Back_1a.setTextureSize( 256, 128 );
        Base_Back_1a.addBox( 0F, 0F, 0F, 16, 4, 1);
        Base_Back_1a.setRotationPoint( -8F, 1F, 13F );
        Base_Back_1c = new ModelRenderer( this, 0, 107 );
        Base_Back_1c.setTextureSize( 256, 128 );
        Base_Back_1c.addBox( 0F, 0F, 0F, 16, 2, 1);
        Base_Back_1c.setRotationPoint( -8F, 4F, 12F );
        Base_Back_2a = new ModelRenderer( this, 10, 8 );
        Base_Back_2a.setTextureSize( 256, 128 );
        Base_Back_2a.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Back_2a.setRotationPoint( -6F, 0F, 13F );
        Base_Back_2b = new ModelRenderer( this, 10, 10 );
        Base_Back_2b.setTextureSize( 256, 128 );
        Base_Back_2b.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Back_2b.setRotationPoint( 5F, 0F, 13F );
        Base_Corner_F1 = new ModelRenderer( this, 0, 64 );
        Base_Corner_F1.setTextureSize( 256, 128 );
        Base_Corner_F1.addBox( 0F, 0F, 0F, 1, 5, 1);
        Base_Corner_F1.setRotationPoint( 8F, 0F, -14F );
        Base_Corner_F2 = new ModelRenderer( this, 4, 64 );
        Base_Corner_F2.setTextureSize( 256, 128 );
        Base_Corner_F2.addBox( 0F, 0F, 0F, 1, 5, 1);
        Base_Corner_F2.setRotationPoint( -9F, 0F, -14F );
        Base_Corner_B1 = new ModelRenderer( this, 8, 64 );
        Base_Corner_B1.setTextureSize( 256, 128 );
        Base_Corner_B1.addBox( 0F, 0F, 0F, 1, 5, 1);
        Base_Corner_B1.setRotationPoint( 8F, 0F, 13F );
        Base_Corner_B2 = new ModelRenderer( this, 12, 64 );
        Base_Corner_B2.setTextureSize( 256, 128 );
        Base_Corner_B2.addBox( 0F, 0F, 0F, 1, 5, 1);
        Base_Corner_B2.setRotationPoint( -9F, 0F, 13F );
        Engine_M1a = new ModelRenderer( this, 54, 64 );
        Engine_M1a.setTextureSize( 256, 128 );
        Engine_M1a.addBox( 0F, 0F, 0F, 6, 6, 6);
        Engine_M1a.setRotationPoint( -3F, 0F, 11F );
        Engine_M1b = new ModelRenderer( this, 0, 60 );
        Engine_M1b.setTextureSize( 256, 128 );
        Engine_M1b.addBox( 0F, 0F, 0F, 12, 2, 2);
        Engine_M1b.setRotationPoint( -6F, 2F, 14F );
        Engine_M1c = new ModelRenderer( this, 35, 88 );
        Engine_M1c.setTextureSize( 256, 128 );
        Engine_M1c.addBox( 0F, 0F, 0F, 8, 1, 1);
        Engine_M1c.setRotationPoint( -4F, 6F, 12F );
        Engine_M1d = new ModelRenderer( this, 1, 16 );
        Engine_M1d.setTextureSize( 256, 128 );
        Engine_M1d.addBox( 0F, 0F, 0F, 2, 4, 2);
        Engine_M1d.setRotationPoint( -1F, -4F, 12F );
        Engine_R1 = new ModelRenderer( this, 34, 76 );
        Engine_R1.setTextureSize( 256, 128 );
        Engine_R1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -13F, 0F, 0F );
        Engine_R1a = new ModelRenderer( this, 55, 88 );
        Engine_R1a.setTextureSize( 256, 128 );
        Engine_R1a.addBox( -1F, -1F, -9F, 1, 1, 9);
        Engine_R1a.setRotationPoint( -9F, 4F, 14F );
        Engine_R1b = new ModelRenderer( this, 54, 95 );
        Engine_R1b.setTextureSize( 256, 128 );
        Engine_R1b.addBox( 0F, 0F, 0F, 4, 1, 1);
        Engine_R1b.setRotationPoint( -9F, 4F, 14F );
        Engine_R2a = new ModelRenderer( this, 78, 64 );
        Engine_R2a.setTextureSize( 256, 128 );
        Engine_R2a.addBox( 0F, -2F, 0F, 4, 6, 8);
        Engine_R2a.setRotationPoint( -16F, 0F, 2F );
        Engine_L1 = new ModelRenderer( this, 34, 64 );
        Engine_L1.setTextureSize( 256, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 9F, 0F, 0F );
        Engine_L1a = new ModelRenderer( this, 55, 88 );
        Engine_L1a.setTextureSize( 256, 128 );
        Engine_L1a.addBox( 0F, 0F, 0F, 1, 1, 9);
        Engine_L1a.setRotationPoint( 9F, 4F, 5F );
        Engine_PipePivot_R = new ModelRenderer( this, 68, 95 );
        Engine_PipePivot_R.setTextureSize( 256, 128 );
        Engine_PipePivot_R.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Engine_PipePivot_R.setRotationPoint( -9.5F, 4F, 14.5F );
        Engine_PipePivot_L = new ModelRenderer( this, 68, 95 );
        Engine_PipePivot_L.setTextureSize( 256, 128 );
        Engine_PipePivot_L.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Engine_PipePivot_L.setRotationPoint( 9.5F, 4F, 14.5F );
        Engine_L1b = new ModelRenderer( this, 54, 95 );
        Engine_L1b.setTextureSize( 256, 128 );
        Engine_L1b.addBox( 0F, 0F, 0F, 4, 1, 1);
        Engine_L1b.setRotationPoint( 5F, 4F, 14F );
        Engine_L2a = new ModelRenderer( this, 78, 78 );
        Engine_L2a.setTextureSize( 256, 128 );
        Engine_L2a.addBox( 0F, 0F, 0F, 4, 6, 8);
        Engine_L2a.setRotationPoint( 12F, -2F, 2F );
        BalloonFrameRT1 = new ModelRenderer( this, 188, 94 );
        BalloonFrameRT1.setTextureSize( 256, 128 );
        BalloonFrameRT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameRT1.setRotationPoint( -16.5F, -52.5F, -16.5F );
        BalloonFrameRM1a = new ModelRenderer( this, 209, 116 );
        BalloonFrameRM1a.setTextureSize( 256, 128 );
        BalloonFrameRM1a.addBox( 0F, 0F, 11.5F, 1, 1, 10);
        BalloonFrameRM1a.setRotationPoint( -16.5F, -36.5F, -5F );
        BalloonFrameRM1b = new ModelRenderer( this, 209, 116 );
        BalloonFrameRM1b.setTextureSize( 256, 128 );
        BalloonFrameRM1b.addBox( 0F, 0F, 11.5F, 1, 1, 10);
        BalloonFrameRM1b.setRotationPoint( -16.5F, -36.5F, -28F );
        BalloonFrameRB1 = new ModelRenderer( this, 184, 92 );
        BalloonFrameRB1.setTextureSize( 256, 128 );
        BalloonFrameRB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameRB1.setRotationPoint( -16.5F, -20.5F, -16.5F );
        BalloonFrameLT1 = new ModelRenderer( this, 182, 91 );
        BalloonFrameLT1.setTextureSize( 256, 128 );
        BalloonFrameLT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameLT1.setRotationPoint( 15.5F, -52.5F, -16.5F );
        BalloonFrameLM1a = new ModelRenderer( this, 203, 113 );
        BalloonFrameLM1a.setTextureSize( 256, 128 );
        BalloonFrameLM1a.addBox( 0F, 0F, 11.5F, 1, 1, 10);
        BalloonFrameLM1a.setRotationPoint( 15.5F, -36.5F, -5F );
        BalloonFrameLM1b = new ModelRenderer( this, 203, 113 );
        BalloonFrameLM1b.setTextureSize( 256, 128 );
        BalloonFrameLM1b.addBox( 0F, 0F, 11.5F, 1, 1, 10);
        BalloonFrameLM1b.setRotationPoint( 15.5F, -36.5F, -28F );
        BalloonFrameLB1 = new ModelRenderer( this, 178, 89 );
        BalloonFrameLB1.setTextureSize( 256, 128 );
        BalloonFrameLB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameLB1.setRotationPoint( 15.5F, -20.5F, -16.5F );
        BalloonFrameMT1 = new ModelRenderer( this, 176, 88 );
        BalloonFrameMT1.setTextureSize( 256, 128 );
        BalloonFrameMT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameMT1.setRotationPoint( -0.5F, -52.5F, -16.5F );
        BalloonFrameRT2a = new ModelRenderer( this, 176, 80 );
        BalloonFrameRT2a.setTextureSize( 256, 128 );
        BalloonFrameRT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRT2a.setRotationPoint( -15.5F, -51.5F, -19.5F );
        BalloonFrameRT2b = new ModelRenderer( this, 174, 79 );
        BalloonFrameRT2b.setTextureSize( 256, 128 );
        BalloonFrameRT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRT2b.setRotationPoint( -14.5F, -50.5F, -19.5F );
        BalloonFrameMT2 = new ModelRenderer( this, 172, 77 );
        BalloonFrameMT2.setTextureSize( 256, 128 );
        BalloonFrameMT2.addBox( 0F, 0F, 0F, 1, 2, 39);
        BalloonFrameMT2.setRotationPoint( -0.5F, -51.5F, -19.5F );
        BalloonFrameLT2a = new ModelRenderer( this, 176, 76 );
        BalloonFrameLT2a.setTextureSize( 256, 128 );
        BalloonFrameLT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLT2a.setRotationPoint( 14.5F, -51.5F, -19.5F );
        BalloonFrameLT2b = new ModelRenderer( this, 175, 75 );
        BalloonFrameLT2b.setTextureSize( 256, 128 );
        BalloonFrameLT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLT2b.setRotationPoint( 13.5F, -50.5F, -19.5F );
        BalloonFrameRM2 = new ModelRenderer( this, 170, 74 );
        BalloonFrameRM2.setTextureSize( 256, 128 );
        BalloonFrameRM2.addBox( 0F, 0F, -1F, 2, 1, 39);
        BalloonFrameRM2.setRotationPoint( -15.5F, -36.5F, -18.5F );
        BalloonFrameLM2 = new ModelRenderer( this, 166, 73 );
        BalloonFrameLM2.setTextureSize( 256, 128 );
        BalloonFrameLM2.addBox( 0F, 0F, 0F, 2, 1, 39);
        BalloonFrameLM2.setRotationPoint( 13.5F, -36.5F, -19.5F );
        BalloonFrameRB2a = new ModelRenderer( this, 165, 72 );
        BalloonFrameRB2a.setTextureSize( 256, 128 );
        BalloonFrameRB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRB2a.setRotationPoint( -15.5F, -21.5F, -19.5F );
        BalloonFrameRB2b = new ModelRenderer( this, 163, 71 );
        BalloonFrameRB2b.setTextureSize( 256, 128 );
        BalloonFrameRB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRB2b.setRotationPoint( -14.5F, -22.5F, -19.5F );
        BalloonFrameLB2a = new ModelRenderer( this, 158, 68 );
        BalloonFrameLB2a.setTextureSize( 256, 128 );
        BalloonFrameLB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLB2a.setRotationPoint( 14.5F, -21.5F, -19.5F );
        BalloonFrameLB2b = new ModelRenderer( this, 156, 67 );
        BalloonFrameLB2b.setTextureSize( 256, 128 );
        BalloonFrameLB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLB2b.setRotationPoint( 13.5F, -22.5F, -19.5F );
        BalloonFrameRT3 = new ModelRenderer( this, 164, 60 );
        BalloonFrameRT3.setTextureSize( 256, 128 );
        BalloonFrameRT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRT3.setRotationPoint( -13.5F, -49.5F, -22.5F );
        BalloonFrameMT3 = new ModelRenderer( this, 162, 59 );
        BalloonFrameMT3.setTextureSize( 256, 128 );
        BalloonFrameMT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameMT3.setRotationPoint( -0.5F, -49.5F, -22.5F );
        BalloonFrameLT3 = new ModelRenderer( this, 160, 58 );
        BalloonFrameLT3.setTextureSize( 256, 128 );
        BalloonFrameLT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLT3.setRotationPoint( 12.5F, -49.5F, -22.5F );
        BalloonFrameRM3 = new ModelRenderer( this, 158, 57 );
        BalloonFrameRM3.setTextureSize( 256, 128 );
        BalloonFrameRM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRM3.setRotationPoint( -13.5F, -36.5F, -22.5F );
        BalloonFrameLM3 = new ModelRenderer( this, 156, 56 );
        BalloonFrameLM3.setTextureSize( 256, 128 );
        BalloonFrameLM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLM3.setRotationPoint( 12.5F, -36.5F, -22.5F );
        BalloonFrameRB3 = new ModelRenderer( this, 154, 55 );
        BalloonFrameRB3.setTextureSize( 256, 128 );
        BalloonFrameRB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRB3.setRotationPoint( -13.5F, -23.5F, -22.5F );
        BalloonFrameLB3 = new ModelRenderer( this, 152, 54 );
        BalloonFrameLB3.setTextureSize( 256, 128 );
        BalloonFrameLB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLB3.setRotationPoint( 12.5F, -23.5F, -22.5F );
        BalloonFrameF3a = new ModelRenderer( this, 150, 72 );
        BalloonFrameF3a.setTextureSize( 256, 128 );
        BalloonFrameF3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        BalloonFrameF3a.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3b = new ModelRenderer( this, 196, 96 );
        BalloonFrameF3b.setTextureSize( 256, 128 );
        BalloonFrameF3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        BalloonFrameF3b.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3c = new ModelRenderer( this, 154, 60 );
        BalloonFrameF3c.setTextureSize( 256, 128 );
        BalloonFrameF3c.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        BalloonFrameF3c.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3d = new ModelRenderer( this, 158, 60 );
        BalloonFrameF3d.setTextureSize( 256, 128 );
        BalloonFrameF3d.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        BalloonFrameF3d.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3e = new ModelRenderer( this, 240, 0 );
        BalloonFrameF3e.setTextureSize( 256, 128 );
        BalloonFrameF3e.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameF3e.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameB3a = new ModelRenderer( this, 162, 72 );
        BalloonFrameB3a.setTextureSize( 256, 128 );
        BalloonFrameB3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        BalloonFrameB3a.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3b = new ModelRenderer( this, 196, 94 );
        BalloonFrameB3b.setTextureSize( 256, 128 );
        BalloonFrameB3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        BalloonFrameB3b.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3c = new ModelRenderer( this, 166, 60 );
        BalloonFrameB3c.setTextureSize( 256, 128 );
        BalloonFrameB3c.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        BalloonFrameB3c.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3d = new ModelRenderer( this, 170, 60 );
        BalloonFrameB3d.setTextureSize( 256, 128 );
        BalloonFrameB3d.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        BalloonFrameB3d.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3e = new ModelRenderer( this, 240, 8 );
        BalloonFrameB3e.setTextureSize( 256, 128 );
        BalloonFrameB3e.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameB3e.setRotationPoint( 0F, -36F, 22F );
        ControlPanel = new ModelRenderer( this, 0, 122 );
        ControlPanel.setTextureSize( 256, 128 );
        ControlPanel.addBox( 0F, 0F, 0F, 7, 5, 1);
        ControlPanel.setRotationPoint( -3.5F, -1F, -16F );
        ControlBrace = new ModelRenderer( this, 0, 117 );
        ControlBrace.setTextureSize( 256, 128 );
        ControlBrace.addBox( -0.5F, 0F, 0F, 6, 4, 1);
        ControlBrace.setRotationPoint( -2.5F, -0.5F, -15.5F );
        SkidR1 = new ModelRenderer( this, 248, 26 );
        SkidR1.setTextureSize( 256, 128 );
        SkidR1.addBox( -1F, 0F, -1F, 2, 3, 2);
        SkidR1.setRotationPoint( -6F, 6F, -6F );
        SkidR2 = new ModelRenderer( this, 248, 26 );
        SkidR2.setTextureSize( 256, 128 );
        SkidR2.addBox( -1F, 0F, -1F, 2, 3, 2);
        SkidR2.setRotationPoint( -6F, 6F, 6F );
        SkidR3 = new ModelRenderer( this, 202, 26 );
        SkidR3.setTextureSize( 256, 128 );
        SkidR3.addBox( -1.5F, 0F, 0F, 3, 1, 24);
        SkidR3.setRotationPoint( -6F, 9F, -12F );
        SkidL1 = new ModelRenderer( this, 248, 26 );
        SkidL1.setTextureSize( 256, 128 );
        SkidL1.addBox( -1F, 0F, -1F, 2, 3, 2);
        SkidL1.setRotationPoint( 6F, 6F, -6F );
        SkidL2 = new ModelRenderer( this, 248, 26 );
        SkidL2.setTextureSize( 256, 128 );
        SkidL2.addBox( -1F, 0F, -1F, 2, 3, 2);
        SkidL2.setRotationPoint( 6F, 6F, 6F );
        SkidL3 = new ModelRenderer( this, 202, 26 );
        SkidL3.setTextureSize( 256, 128 );
        SkidL3.addBox( -1.5F, 0F, 0F, 3, 1, 24);
        SkidL3.setRotationPoint( 6F, 9F, -12F );
        ItemFrameFront1 = new ModelRenderer( this, 37, 117 );
        ItemFrameFront1.setTextureSize( 256, 128 );
        ItemFrameFront1.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 3);
        ItemFrameFront1.setRotationPoint( 0F, 4F, -16F );
        ItemFrameFront2 = new ModelRenderer( this, 32, 126 );
        ItemFrameFront2.setTextureSize( 256, 128 );
        ItemFrameFront2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        ItemFrameFront2.setRotationPoint( 0F, 4F, -18F );
        ItemFrameControlBraceOverlay = new ModelRenderer( this, 36, 122 );
        ItemFrameControlBraceOverlay.setTextureSize( 256, 128 );
        ItemFrameControlBraceOverlay.addBox( 0F, -0.5F, 0F, 5, 5, 1);
        ItemFrameControlBraceOverlay.setRotationPoint( -2.5F, -0.5F, -16F );
        ItemFrameLeftInside = new ModelRenderer( this, 49, 106 );
        ItemFrameLeftInside.setTextureSize( 256, 128 );
        ItemFrameLeftInside.addBox( 0F, -5.5F, -5.5F, 0, 11, 11);
        ItemFrameLeftInside.setRotationPoint( -16.5F, -36F, 0F );
        ItemFrameLeftBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameLeftBorderT.setTextureSize( 256, 128 );
        ItemFrameLeftBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderT.setRotationPoint( -16.5F, -42F, -0.5F );
        ItemFrameLeftBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameLeftBorderB.setTextureSize( 256, 128 );
        ItemFrameLeftBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderB.setRotationPoint( -16.5F, -30F, 0.5F );
        ItemFrameLeftBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameLeftBorderR.setTextureSize( 256, 128 );
        ItemFrameLeftBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderR.setRotationPoint( -16.5F, -35.5F, -6F );
        ItemFrameLeftBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameLeftBorderL.setTextureSize( 256, 128 );
        ItemFrameLeftBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderL.setRotationPoint( -16.5F, -36.5F, 6F );
        ItemFrameRightInside = new ModelRenderer( this, 49, 106 );
        ItemFrameRightInside.setTextureSize( 256, 128 );
        ItemFrameRightInside.addBox( 0F, -5.5F, -5.5F, 0, 11, 11);
        ItemFrameRightInside.setRotationPoint( 16.5F, -36F, 0F );
        ItemFrameRightBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameRightBorderT.setTextureSize( 256, 128 );
        ItemFrameRightBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderT.setRotationPoint( 16.5F, -42F, -0.5F );
        ItemFrameRightBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameRightBorderB.setTextureSize( 256, 128 );
        ItemFrameRightBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderB.setRotationPoint( 16.5F, -30F, 0.5F );
        ItemFrameRightBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameRightBorderR.setTextureSize( 256, 128 );
        ItemFrameRightBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderR.setRotationPoint( 16.5F, -35.5F, -6F );
        ItemFrameRightBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameRightBorderL.setTextureSize( 256, 128 );
        ItemFrameRightBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderL.setRotationPoint( 16.5F, -36.5F, 6F );
        BombBay = new ModelRenderer( this, 22, 26 );
        BombBay.setTextureSize( 256, 128 );
        BombBay.addBox( -4F, -0.5F, -4F, 8, 1, 8);
        BombBay.setRotationPoint( 0F, 7F, 0F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        BaseWoodChest.rotateAngleX = 0F;
        BaseWoodChest.rotateAngleY = 0F;
        BaseWoodChest.rotateAngleZ = 0F;
        BaseWoodChest.renderWithRotation(par7);

        Base_1a.rotateAngleX = 0F;
        Base_1a.rotateAngleY = 0F;
        Base_1a.rotateAngleZ = 0F;
        Base_1a.renderWithRotation(par7);

        Base_Seat_1b.rotateAngleX = 0F;
        Base_Seat_1b.rotateAngleY = 0F;
        Base_Seat_1b.rotateAngleZ = 0F;
        Base_Seat_1b.renderWithRotation(par7);

        Base_Side_1a.rotateAngleX = 0F;
        Base_Side_1a.rotateAngleY = 0F;
        Base_Side_1a.rotateAngleZ = 0F;
        Base_Side_1a.renderWithRotation(par7);

        Base_Side_1b.rotateAngleX = 0F;
        Base_Side_1b.rotateAngleY = 0F;
        Base_Side_1b.rotateAngleZ = 0F;
        Base_Side_1b.renderWithRotation(par7);

        Base_Side_2a.rotateAngleX = 0F;
        Base_Side_2a.rotateAngleY = 0F;
        Base_Side_2a.rotateAngleZ = 0F;
        Base_Side_2a.renderWithRotation(par7);

        Base_Side_2b.rotateAngleX = 0F;
        Base_Side_2b.rotateAngleY = 0F;
        Base_Side_2b.rotateAngleZ = 0F;
        Base_Side_2b.renderWithRotation(par7);

        Anchor_1a.rotateAngleX = 0F;
        Anchor_1a.rotateAngleY = 0F;
        Anchor_1a.rotateAngleZ = 0F;
        Anchor_1a.renderWithRotation(par7);

        Anchor_1b.rotateAngleX = 0F;
        Anchor_1b.rotateAngleY = 0F;
        Anchor_1b.rotateAngleZ = 0F;
        Anchor_1b.renderWithRotation(par7);

        Anchor_1c.rotateAngleX = 0F;
        Anchor_1c.rotateAngleY = 0F;
        Anchor_1c.rotateAngleZ = 0F;
        Anchor_1c.renderWithRotation(par7);

        Anchor_1d.rotateAngleX = 0F;
        Anchor_1d.rotateAngleY = 0F;
        Anchor_1d.rotateAngleZ = 0F;
        Anchor_1d.renderWithRotation(par7);

        Anchor_2a.rotateAngleX = 0F;
        Anchor_2a.rotateAngleY = 0F;
        Anchor_2a.rotateAngleZ = 0F;
        Anchor_2a.renderWithRotation(par7);

        Anchor_2b.rotateAngleX = 0F;
        Anchor_2b.rotateAngleY = 0F;
        Anchor_2b.rotateAngleZ = 0F;
        Anchor_2b.renderWithRotation(par7);

        Anchor_2c.rotateAngleX = 0F;
        Anchor_2c.rotateAngleY = 0F;
        Anchor_2c.rotateAngleZ = 0F;
        Anchor_2c.renderWithRotation(par7);

        Anchor_2d.rotateAngleX = 0F;
        Anchor_2d.rotateAngleY = 0F;
        Anchor_2d.rotateAngleZ = 0F;
        Anchor_2d.renderWithRotation(par7);

        Base_Front_1a1.rotateAngleX = 0F;
        Base_Front_1a1.rotateAngleY = 0F;
        Base_Front_1a1.rotateAngleZ = 0F;
        Base_Front_1a1.renderWithRotation(par7);

        Base_Front_1aR.rotateAngleX = 0F;
        Base_Front_1aR.rotateAngleY = 0F;
        Base_Front_1aR.rotateAngleZ = 0F;
        Base_Front_1aR.renderWithRotation(par7);

        Base_Front_1aL.rotateAngleX = 0F;
        Base_Front_1aL.rotateAngleY = 0F;
        Base_Front_1aL.rotateAngleZ = 0F;
        Base_Front_1aL.renderWithRotation(par7);

        Base_Front_1aM.rotateAngleX = 0F;
        Base_Front_1aM.rotateAngleY = 0F;
        Base_Front_1aM.rotateAngleZ = 0F;
        Base_Front_1aM.renderWithRotation(par7);

        Base_Front_1c.rotateAngleX = 0F;
        Base_Front_1c.rotateAngleY = 0F;
        Base_Front_1c.rotateAngleZ = 0F;
        Base_Front_1c.renderWithRotation(par7);

        Base_Front_2a.rotateAngleX = 0F;
        Base_Front_2a.rotateAngleY = 0F;
        Base_Front_2a.rotateAngleZ = 0F;
        Base_Front_2a.renderWithRotation(par7);

        Base_Front_2b.rotateAngleX = 0F;
        Base_Front_2b.rotateAngleY = 0F;
        Base_Front_2b.rotateAngleZ = 0F;
        Base_Front_2b.renderWithRotation(par7);

        Base_Front_2c.rotateAngleX = 0F;
        Base_Front_2c.rotateAngleY = 0F;
        Base_Front_2c.rotateAngleZ = 0F;
        Base_Front_2c.renderWithRotation(par7);

        Base_Front_2d.rotateAngleX = 0F;
        Base_Front_2d.rotateAngleY = 0F;
        Base_Front_2d.rotateAngleZ = 0F;
        Base_Front_2d.renderWithRotation(par7);

        Base_Back_1a.rotateAngleX = 0F;
        Base_Back_1a.rotateAngleY = 0F;
        Base_Back_1a.rotateAngleZ = 0F;
        Base_Back_1a.renderWithRotation(par7);

        Base_Back_1c.rotateAngleX = 0F;
        Base_Back_1c.rotateAngleY = 0F;
        Base_Back_1c.rotateAngleZ = 0F;
        Base_Back_1c.renderWithRotation(par7);

        Base_Back_2a.rotateAngleX = 0F;
        Base_Back_2a.rotateAngleY = 0F;
        Base_Back_2a.rotateAngleZ = 0F;
        Base_Back_2a.renderWithRotation(par7);

        Base_Back_2b.rotateAngleX = 0F;
        Base_Back_2b.rotateAngleY = 0F;
        Base_Back_2b.rotateAngleZ = 0F;
        Base_Back_2b.renderWithRotation(par7);

        Base_Corner_F1.rotateAngleX = 0F;
        Base_Corner_F1.rotateAngleY = 0F;
        Base_Corner_F1.rotateAngleZ = 0F;
        Base_Corner_F1.renderWithRotation(par7);

        Base_Corner_F2.rotateAngleX = 0F;
        Base_Corner_F2.rotateAngleY = 0F;
        Base_Corner_F2.rotateAngleZ = 0F;
        Base_Corner_F2.renderWithRotation(par7);

        Base_Corner_B1.rotateAngleX = 0F;
        Base_Corner_B1.rotateAngleY = 0F;
        Base_Corner_B1.rotateAngleZ = 0F;
        Base_Corner_B1.renderWithRotation(par7);

        Base_Corner_B2.rotateAngleX = 0F;
        Base_Corner_B2.rotateAngleY = 0F;
        Base_Corner_B2.rotateAngleZ = 0F;
        Base_Corner_B2.renderWithRotation(par7);

        Engine_M1a.rotateAngleX = 0F;
        Engine_M1a.rotateAngleY = 0F;
        Engine_M1a.rotateAngleZ = 0F;
        Engine_M1a.renderWithRotation(par7);

        Engine_M1b.rotateAngleX = 0F;
        Engine_M1b.rotateAngleY = 0F;
        Engine_M1b.rotateAngleZ = 0F;
        Engine_M1b.renderWithRotation(par7);

        Engine_M1c.rotateAngleX = 0F;
        Engine_M1c.rotateAngleY = 0F;
        Engine_M1c.rotateAngleZ = 0F;
        Engine_M1c.renderWithRotation(par7);

        Engine_M1d.rotateAngleX = 0F;
        Engine_M1d.rotateAngleY = 0F;
        Engine_M1d.rotateAngleZ = 0F;
        Engine_M1d.renderWithRotation(par7);

        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Engine_R1a.rotateAngleX = 0F;
        Engine_R1a.rotateAngleY = 0F;
        Engine_R1a.rotateAngleZ = -0.7853982F;
        Engine_R1a.renderWithRotation(par7);

        Engine_R1b.rotateAngleX = 0.7853982F;
        Engine_R1b.rotateAngleY = 0F;
        Engine_R1b.rotateAngleZ = 0F;
        Engine_R1b.renderWithRotation(par7);

        Engine_R2a.rotateAngleX = 0F;
        Engine_R2a.rotateAngleY = 0F;
        Engine_R2a.rotateAngleZ = 0F;
        Engine_R2a.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_L1a.rotateAngleX = 0F;
        Engine_L1a.rotateAngleY = 0F;
        Engine_L1a.rotateAngleZ = -0.7853982F;
        Engine_L1a.renderWithRotation(par7);

        Engine_PipePivot_R.rotateAngleX = 0F;
        Engine_PipePivot_R.rotateAngleY = 0F;
        Engine_PipePivot_R.rotateAngleZ = 0F;
        Engine_PipePivot_R.renderWithRotation(par7);

        Engine_PipePivot_L.rotateAngleX = 0F;
        Engine_PipePivot_L.rotateAngleY = 0F;
        Engine_PipePivot_L.rotateAngleZ = 0F;
        Engine_PipePivot_L.renderWithRotation(par7);

        Engine_L1b.rotateAngleX = 0.7853982F;
        Engine_L1b.rotateAngleY = 0F;
        Engine_L1b.rotateAngleZ = 0F;
        Engine_L1b.renderWithRotation(par7);

        Engine_L2a.rotateAngleX = 0F;
        Engine_L2a.rotateAngleY = 0F;
        Engine_L2a.rotateAngleZ = 0F;
        Engine_L2a.renderWithRotation(par7);

        BalloonFrameRT1.rotateAngleX = 0F;
        BalloonFrameRT1.rotateAngleY = 0F;
        BalloonFrameRT1.rotateAngleZ = 0F;
        BalloonFrameRT1.renderWithRotation(par7);

        BalloonFrameRM1a.rotateAngleX = 0F;
        BalloonFrameRM1a.rotateAngleY = 0F;
        BalloonFrameRM1a.rotateAngleZ = 0F;
        BalloonFrameRM1a.renderWithRotation(par7);

        BalloonFrameRM1b.rotateAngleX = 0F;
        BalloonFrameRM1b.rotateAngleY = 0F;
        BalloonFrameRM1b.rotateAngleZ = 0F;
        BalloonFrameRM1b.renderWithRotation(par7);

        BalloonFrameRB1.rotateAngleX = 0F;
        BalloonFrameRB1.rotateAngleY = 0F;
        BalloonFrameRB1.rotateAngleZ = 0F;
        BalloonFrameRB1.renderWithRotation(par7);

        BalloonFrameLT1.rotateAngleX = 0F;
        BalloonFrameLT1.rotateAngleY = 0F;
        BalloonFrameLT1.rotateAngleZ = 0F;
        BalloonFrameLT1.renderWithRotation(par7);

        BalloonFrameLM1a.rotateAngleX = 0F;
        BalloonFrameLM1a.rotateAngleY = 0F;
        BalloonFrameLM1a.rotateAngleZ = 0F;
        BalloonFrameLM1a.renderWithRotation(par7);

        BalloonFrameLM1b.rotateAngleX = 0F;
        BalloonFrameLM1b.rotateAngleY = 0F;
        BalloonFrameLM1b.rotateAngleZ = 0F;
        BalloonFrameLM1b.renderWithRotation(par7);

        BalloonFrameLB1.rotateAngleX = 0F;
        BalloonFrameLB1.rotateAngleY = 0F;
        BalloonFrameLB1.rotateAngleZ = 0F;
        BalloonFrameLB1.renderWithRotation(par7);

        BalloonFrameMT1.rotateAngleX = 0F;
        BalloonFrameMT1.rotateAngleY = 0F;
        BalloonFrameMT1.rotateAngleZ = 0F;
        BalloonFrameMT1.renderWithRotation(par7);

        BalloonFrameRT2a.rotateAngleX = 0F;
        BalloonFrameRT2a.rotateAngleY = 0F;
        BalloonFrameRT2a.rotateAngleZ = 0F;
        BalloonFrameRT2a.renderWithRotation(par7);

        BalloonFrameRT2b.rotateAngleX = 0F;
        BalloonFrameRT2b.rotateAngleY = 0F;
        BalloonFrameRT2b.rotateAngleZ = 0F;
        BalloonFrameRT2b.renderWithRotation(par7);

        BalloonFrameMT2.rotateAngleX = 0F;
        BalloonFrameMT2.rotateAngleY = 0F;
        BalloonFrameMT2.rotateAngleZ = 0F;
        BalloonFrameMT2.renderWithRotation(par7);

        BalloonFrameLT2a.rotateAngleX = 0F;
        BalloonFrameLT2a.rotateAngleY = 0F;
        BalloonFrameLT2a.rotateAngleZ = 0F;
        BalloonFrameLT2a.renderWithRotation(par7);

        BalloonFrameLT2b.rotateAngleX = 0F;
        BalloonFrameLT2b.rotateAngleY = 0F;
        BalloonFrameLT2b.rotateAngleZ = 0F;
        BalloonFrameLT2b.renderWithRotation(par7);

        BalloonFrameRM2.rotateAngleX = 0F;
        BalloonFrameRM2.rotateAngleY = 0F;
        BalloonFrameRM2.rotateAngleZ = 0F;
        BalloonFrameRM2.renderWithRotation(par7);

        BalloonFrameLM2.rotateAngleX = 0F;
        BalloonFrameLM2.rotateAngleY = 0F;
        BalloonFrameLM2.rotateAngleZ = 0F;
        BalloonFrameLM2.renderWithRotation(par7);

        BalloonFrameRB2a.rotateAngleX = 0F;
        BalloonFrameRB2a.rotateAngleY = 0F;
        BalloonFrameRB2a.rotateAngleZ = 0F;
        BalloonFrameRB2a.renderWithRotation(par7);

        BalloonFrameRB2b.rotateAngleX = 0F;
        BalloonFrameRB2b.rotateAngleY = 0F;
        BalloonFrameRB2b.rotateAngleZ = 0F;
        BalloonFrameRB2b.renderWithRotation(par7);

        BalloonFrameLB2a.rotateAngleX = 0F;
        BalloonFrameLB2a.rotateAngleY = 0F;
        BalloonFrameLB2a.rotateAngleZ = 0F;
        BalloonFrameLB2a.renderWithRotation(par7);

        BalloonFrameLB2b.rotateAngleX = 0F;
        BalloonFrameLB2b.rotateAngleY = 0F;
        BalloonFrameLB2b.rotateAngleZ = 0F;
        BalloonFrameLB2b.renderWithRotation(par7);

        BalloonFrameRT3.rotateAngleX = 0F;
        BalloonFrameRT3.rotateAngleY = 0F;
        BalloonFrameRT3.rotateAngleZ = 0F;
        BalloonFrameRT3.renderWithRotation(par7);

        BalloonFrameMT3.rotateAngleX = 0F;
        BalloonFrameMT3.rotateAngleY = 0F;
        BalloonFrameMT3.rotateAngleZ = 0F;
        BalloonFrameMT3.renderWithRotation(par7);

        BalloonFrameLT3.rotateAngleX = 0F;
        BalloonFrameLT3.rotateAngleY = 0F;
        BalloonFrameLT3.rotateAngleZ = 0F;
        BalloonFrameLT3.renderWithRotation(par7);

        BalloonFrameRM3.rotateAngleX = 0F;
        BalloonFrameRM3.rotateAngleY = 0F;
        BalloonFrameRM3.rotateAngleZ = 0F;
        BalloonFrameRM3.renderWithRotation(par7);

        BalloonFrameLM3.rotateAngleX = 0F;
        BalloonFrameLM3.rotateAngleY = 0F;
        BalloonFrameLM3.rotateAngleZ = 0F;
        BalloonFrameLM3.renderWithRotation(par7);

        BalloonFrameRB3.rotateAngleX = 0F;
        BalloonFrameRB3.rotateAngleY = 0F;
        BalloonFrameRB3.rotateAngleZ = 0F;
        BalloonFrameRB3.renderWithRotation(par7);

        BalloonFrameLB3.rotateAngleX = 0F;
        BalloonFrameLB3.rotateAngleY = 0F;
        BalloonFrameLB3.rotateAngleZ = 0F;
        BalloonFrameLB3.renderWithRotation(par7);

        BalloonFrameF3a.rotateAngleX = 0F;
        BalloonFrameF3a.rotateAngleY = 0F;
        BalloonFrameF3a.rotateAngleZ = 0F;
        BalloonFrameF3a.renderWithRotation(par7);

        BalloonFrameF3b.rotateAngleX = 0F;
        BalloonFrameF3b.rotateAngleY = 0F;
        BalloonFrameF3b.rotateAngleZ = 0F;
        BalloonFrameF3b.renderWithRotation(par7);

        BalloonFrameF3c.rotateAngleX = 0F;
        BalloonFrameF3c.rotateAngleY = 0F;
        BalloonFrameF3c.rotateAngleZ = -0.7853982F;
        BalloonFrameF3c.renderWithRotation(par7);

        BalloonFrameF3d.rotateAngleX = 0F;
        BalloonFrameF3d.rotateAngleY = 0F;
        BalloonFrameF3d.rotateAngleZ = 0.7853982F;
        BalloonFrameF3d.renderWithRotation(par7);

        BalloonFrameF3e.rotateAngleX = 0F;
        BalloonFrameF3e.rotateAngleY = 0F;
        BalloonFrameF3e.rotateAngleZ = 0F;
        BalloonFrameF3e.renderWithRotation(par7);

        BalloonFrameB3a.rotateAngleX = 0F;
        BalloonFrameB3a.rotateAngleY = 0F;
        BalloonFrameB3a.rotateAngleZ = 0F;
        BalloonFrameB3a.renderWithRotation(par7);

        BalloonFrameB3b.rotateAngleX = 0F;
        BalloonFrameB3b.rotateAngleY = 0F;
        BalloonFrameB3b.rotateAngleZ = 0F;
        BalloonFrameB3b.renderWithRotation(par7);

        BalloonFrameB3c.rotateAngleX = 0F;
        BalloonFrameB3c.rotateAngleY = 0F;
        BalloonFrameB3c.rotateAngleZ = -0.7853982F;
        BalloonFrameB3c.renderWithRotation(par7);

        BalloonFrameB3d.rotateAngleX = 0F;
        BalloonFrameB3d.rotateAngleY = 0F;
        BalloonFrameB3d.rotateAngleZ = 0.7853982F;
        BalloonFrameB3d.renderWithRotation(par7);

        BalloonFrameB3e.rotateAngleX = 0F;
        BalloonFrameB3e.rotateAngleY = 0F;
        BalloonFrameB3e.rotateAngleZ = 0F;
        BalloonFrameB3e.renderWithRotation(par7);

        ControlPanel.rotateAngleX = 0.7853982F;
        ControlPanel.rotateAngleY = 0F;
        ControlPanel.rotateAngleZ = 0F;
        ControlPanel.renderWithRotation(par7);

        ControlBrace.rotateAngleX = 0F;
        ControlBrace.rotateAngleY = 0F;
        ControlBrace.rotateAngleZ = 0F;
        ControlBrace.renderWithRotation(par7);

        SkidR1.rotateAngleX = 0F;
        SkidR1.rotateAngleY = -0.7853982F;
        SkidR1.rotateAngleZ = 0F;
        SkidR1.renderWithRotation(par7);

        SkidR2.rotateAngleX = 0F;
        SkidR2.rotateAngleY = -0.7853982F;
        SkidR2.rotateAngleZ = 0F;
        SkidR2.renderWithRotation(par7);

        SkidR3.rotateAngleX = 0F;
        SkidR3.rotateAngleY = 0F;
        SkidR3.rotateAngleZ = 0F;
        SkidR3.renderWithRotation(par7);

        SkidL1.rotateAngleX = 0F;
        SkidL1.rotateAngleY = -0.7853982F;
        SkidL1.rotateAngleZ = 0F;
        SkidL1.renderWithRotation(par7);

        SkidL2.rotateAngleX = 0F;
        SkidL2.rotateAngleY = -0.7853982F;
        SkidL2.rotateAngleZ = 0F;
        SkidL2.renderWithRotation(par7);

        SkidL3.rotateAngleX = 0F;
        SkidL3.rotateAngleY = 0F;
        SkidL3.rotateAngleZ = 0F;
        SkidL3.renderWithRotation(par7);

        ItemFrameFront1.rotateAngleX = 0F;
        ItemFrameFront1.rotateAngleY = 0F;
        ItemFrameFront1.rotateAngleZ = -0.7853982F;
        ItemFrameFront1.renderWithRotation(par7);

        ItemFrameFront2.rotateAngleX = 0F;
        ItemFrameFront2.rotateAngleY = 0F;
        ItemFrameFront2.rotateAngleZ = 0F;
        ItemFrameFront2.renderWithRotation(par7);

        ItemFrameControlBraceOverlay.rotateAngleX = 0F;
        ItemFrameControlBraceOverlay.rotateAngleY = 0F;
        ItemFrameControlBraceOverlay.rotateAngleZ = 0F;
        ItemFrameControlBraceOverlay.renderWithRotation(par7);

        ItemFrameLeftInside.rotateAngleX = 0F;
        ItemFrameLeftInside.rotateAngleY = 0F;
        ItemFrameLeftInside.rotateAngleZ = 0F;
        ItemFrameLeftInside.renderWithRotation(par7);

        ItemFrameLeftBorderT.rotateAngleX = 0F;
        ItemFrameLeftBorderT.rotateAngleY = 0F;
        ItemFrameLeftBorderT.rotateAngleZ = 0F;
        ItemFrameLeftBorderT.renderWithRotation(par7);

        ItemFrameLeftBorderB.rotateAngleX = 0F;
        ItemFrameLeftBorderB.rotateAngleY = 0F;
        ItemFrameLeftBorderB.rotateAngleZ = 0F;
        ItemFrameLeftBorderB.renderWithRotation(par7);

        ItemFrameLeftBorderR.rotateAngleX = 0F;
        ItemFrameLeftBorderR.rotateAngleY = 0F;
        ItemFrameLeftBorderR.rotateAngleZ = 0F;
        ItemFrameLeftBorderR.renderWithRotation(par7);

        ItemFrameLeftBorderL.rotateAngleX = 0F;
        ItemFrameLeftBorderL.rotateAngleY = 0F;
        ItemFrameLeftBorderL.rotateAngleZ = 0F;
        ItemFrameLeftBorderL.renderWithRotation(par7);

        ItemFrameRightInside.rotateAngleX = 0F;
        ItemFrameRightInside.rotateAngleY = 0F;
        ItemFrameRightInside.rotateAngleZ = 0F;
        ItemFrameRightInside.renderWithRotation(par7);

        ItemFrameRightBorderT.rotateAngleX = 0F;
        ItemFrameRightBorderT.rotateAngleY = 0F;
        ItemFrameRightBorderT.rotateAngleZ = 0F;
        ItemFrameRightBorderT.renderWithRotation(par7);

        ItemFrameRightBorderB.rotateAngleX = 0F;
        ItemFrameRightBorderB.rotateAngleY = 0F;
        ItemFrameRightBorderB.rotateAngleZ = 0F;
        ItemFrameRightBorderB.renderWithRotation(par7);

        ItemFrameRightBorderR.rotateAngleX = 0F;
        ItemFrameRightBorderR.rotateAngleY = 0F;
        ItemFrameRightBorderR.rotateAngleZ = 0F;
        ItemFrameRightBorderR.renderWithRotation(par7);

        ItemFrameRightBorderL.rotateAngleX = 0F;
        ItemFrameRightBorderL.rotateAngleY = 0F;
        ItemFrameRightBorderL.rotateAngleZ = 0F;
        ItemFrameRightBorderL.renderWithRotation(par7);

        BombBay.rotateAngleX = 0F;
        BombBay.rotateAngleY = 0F;
        BombBay.rotateAngleZ = 0F;
        BombBay.renderWithRotation(par7);

    }

}
