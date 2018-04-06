package net.minecraft.src;

public class ModelV3_Airship_Frame extends ModelBase
{
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1c;
    ModelRenderer Base_Side_R1;
    ModelRenderer Base_Side_L2;
    ModelRenderer Base_Side_L3;
    ModelRenderer Base_Side_L4;
    ModelRenderer Base_Side_R11;
    ModelRenderer Base_Side_R2;
    ModelRenderer Base_Side_R3;
    ModelRenderer Base_Side_R4;
    ModelRenderer Engine_R1;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_FL2a;
    ModelRenderer Engine_FR2a;
    ModelRenderer Pole1;
    ModelRenderer Pole2;
    ModelRenderer Engine_R1c;
    ModelRenderer Engine_L1c;
    ModelRenderer BalloonFrameBLMa;
    ModelRenderer BalloonFrameBRMa;
    ModelRenderer BalloonFrameTR1a;
    ModelRenderer BalloonFrameTR1b;
    ModelRenderer BalloonFrameTR2a;
    ModelRenderer BalloonFrameTR2b;
    ModelRenderer BalloonFrameBR1a;
    ModelRenderer BalloonFrameBR1b;
    ModelRenderer BalloonFrameBR2a;
    ModelRenderer BalloonFrameBR2b;
    ModelRenderer BalloonFrameTL1a;
    ModelRenderer BalloonFrameTL1b;
    ModelRenderer BalloonFrameTL2a;
    ModelRenderer BalloonFrameTL2b;
    ModelRenderer BalloonFrameBL1a;
    ModelRenderer BalloonFrameBL1b;
    ModelRenderer BalloonFrameBL2a;
    ModelRenderer BalloonFrameBL2b;
    ModelRenderer BalloonFrameTR3a;
    ModelRenderer BalloonFrameTR3b;
    ModelRenderer BalloonFrameTR4a;
    ModelRenderer BalloonFrameTR4b;
    ModelRenderer BalloonFrameBR3a;
    ModelRenderer BalloonFrameBR3b;
    ModelRenderer BalloonFrameBR4a;
    ModelRenderer BalloonFrameBR4b;
    ModelRenderer BalloonFrameTL3a;
    ModelRenderer BalloonFrameTL3b;
    ModelRenderer BalloonFrameTL4a;
    ModelRenderer BalloonFrameTL4b;
    ModelRenderer BalloonFrameBL3a;
    ModelRenderer BalloonFrameBL3b;
    ModelRenderer BalloonFrameBL4a;
    ModelRenderer BalloonFrameBL4b;
    ModelRenderer BalloonFrameTLM1f;
    ModelRenderer BalloonFrameTRM1f;
    ModelRenderer BalloonFrameTLM1b;
    ModelRenderer BalloonFrameTRM1b;
    ModelRenderer BaseWoodChest;
    ModelRenderer Base_1a;
    ModelRenderer Base_Seat_1b;
    ModelRenderer Base_Side_1a;
    ModelRenderer Base_Side_1b;
    ModelRenderer Base_Side_2a;
    ModelRenderer Base_Side_2b;
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

    public ModelV3_Airship_Frame()
    {
        this( 0.0f );
    }

    public ModelV3_Airship_Frame( float par1 )
    {
        Anchor_1a = new ModelRenderer( this, 13, 17 );
        Anchor_1a.setTextureSize( 256, 128 );
        Anchor_1a.addBox( 0.5F, 0F, -0.5F, 2, 2, 3);
        Anchor_1a.setRotationPoint( 7F, 0F, 7F );
        Anchor_1c = new ModelRenderer( this, 13, 12 );
        Anchor_1c.setTextureSize( 256, 128 );
        Anchor_1c.addBox( 0.5F, 0F, -0.5F, 2, 2, 3);
        Anchor_1c.setRotationPoint( -10F, 0F, 7F );
        Base_Side_R1 = new ModelRenderer( this, 3, 1 );
        Base_Side_R1.setTextureSize( 256, 128 );
        Base_Side_R1.addBox( -1F, 0F, 0F, 1, 1, 1);
        Base_Side_R1.setRotationPoint( -8F, 0F, -10F );
        Base_Side_L2 = new ModelRenderer( this, 3, 1 );
        Base_Side_L2.setTextureSize( 256, 128 );
        Base_Side_L2.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_L2.setRotationPoint( -9F, 0F, -6F );
        Base_Side_L3 = new ModelRenderer( this, 3, 1 );
        Base_Side_L3.setTextureSize( 256, 128 );
        Base_Side_L3.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_L3.setRotationPoint( -9F, 0F, -2F );
        Base_Side_L4 = new ModelRenderer( this, 3, 1 );
        Base_Side_L4.setTextureSize( 256, 128 );
        Base_Side_L4.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_L4.setRotationPoint( -9F, 0F, 2F );
        Base_Side_R11 = new ModelRenderer( this, 3, 1 );
        Base_Side_R11.setTextureSize( 256, 128 );
        Base_Side_R11.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_R11.setRotationPoint( 8F, 0F, -10F );
        Base_Side_R2 = new ModelRenderer( this, 3, 1 );
        Base_Side_R2.setTextureSize( 256, 128 );
        Base_Side_R2.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_R2.setRotationPoint( 8F, 0F, -6F );
        Base_Side_R3 = new ModelRenderer( this, 3, 1 );
        Base_Side_R3.setTextureSize( 256, 128 );
        Base_Side_R3.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_R3.setRotationPoint( 8F, 0F, -2F );
        Base_Side_R4 = new ModelRenderer( this, 3, 1 );
        Base_Side_R4.setTextureSize( 256, 128 );
        Base_Side_R4.addBox( 0F, 0F, 0F, 1, 1, 1);
        Base_Side_R4.setRotationPoint( 8F, 0F, 2F );
        Engine_R1 = new ModelRenderer( this, 72, 65 );
        Engine_R1.setTextureSize( 256, 128 );
        Engine_R1.addBox( 0F, 1F, -2.5F, 4, 6, 11);
        Engine_R1.setRotationPoint( -13F, -14F, 8F );
        Engine_L1 = new ModelRenderer( this, 73, 49 );
        Engine_L1.setTextureSize( 256, 128 );
        Engine_L1.addBox( 0F, 0F, -2F, 4, 6, 10);
        Engine_L1.setRotationPoint( 9F, -13F, 8F );
        Engine_FL2a = new ModelRenderer( this, 102, 76 );
        Engine_FL2a.setTextureSize( 256, 128 );
        Engine_FL2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FL2a.setRotationPoint( 15F, -7F, 4F );
        Engine_FR2a = new ModelRenderer( this, 102, 64 );
        Engine_FR2a.setTextureSize( 256, 128 );
        Engine_FR2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FR2a.setRotationPoint( -19F, -7F, 4F );
        Pole1 = new ModelRenderer( this, 63, 44 );
        Pole1.setTextureSize( 256, 128 );
        Pole1.addBox( -0.5F, -9F, -1F, 1, 10, 2);
        Pole1.setRotationPoint( -8.5F, 0F, 8F );
        Pole2 = new ModelRenderer( this, 57, 44 );
        Pole2.setTextureSize( 256, 128 );
        Pole2.addBox( -0.5F, -9F, -1F, 1, 10, 2);
        Pole2.setRotationPoint( 8.5F, 0F, 8F );
        Engine_R1c = new ModelRenderer( this, 54, 84 );
        Engine_R1c.setTextureSize( 256, 128 );
        Engine_R1c.addBox( -0.5F, 0F, -0.5F, 1, 13, 1);
        Engine_R1c.setRotationPoint( -10F, -9F, 15F );
        Engine_L1c = new ModelRenderer( this, 54, 84 );
        Engine_L1c.setTextureSize( 256, 128 );
        Engine_L1c.addBox( -0.5F, 0F, -0.5F, 1, 13, 1);
        Engine_L1c.setRotationPoint( 10F, -9F, 15F );
        BalloonFrameBLMa = new ModelRenderer( this, 130, 6 );
        BalloonFrameBLMa.setTextureSize( 256, 128 );
        BalloonFrameBLMa.addBox( -3F, -3F, 0F, 5, 5, 1);
        BalloonFrameBLMa.setRotationPoint( 17.5F, 1.5F, 13.5F );
        BalloonFrameBRMa = new ModelRenderer( this, 130, 0 );
        BalloonFrameBRMa.setTextureSize( 256, 128 );
        BalloonFrameBRMa.addBox( -3F, -3F, 0F, 5, 5, 1);
        BalloonFrameBRMa.setRotationPoint( -16.5F, 1.5F, 13.5F );
        BalloonFrameTR1a = new ModelRenderer( this, 198, 99 );
        BalloonFrameTR1a.setTextureSize( 256, 128 );
        BalloonFrameTR1a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameTR1a.setRotationPoint( -13F, -14F, -10F );
        BalloonFrameTR1b = new ModelRenderer( this, 196, 98 );
        BalloonFrameTR1b.setTextureSize( 256, 128 );
        BalloonFrameTR1b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameTR1b.setRotationPoint( -21F, -14F, -10F );
        BalloonFrameTR2a = new ModelRenderer( this, 192, 95 );
        BalloonFrameTR2a.setTextureSize( 256, 128 );
        BalloonFrameTR2a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameTR2a.setRotationPoint( -14F, -13F, -11F );
        BalloonFrameTR2b = new ModelRenderer( this, 190, 94 );
        BalloonFrameTR2b.setTextureSize( 256, 128 );
        BalloonFrameTR2b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameTR2b.setRotationPoint( -20F, -13F, -11F );
        BalloonFrameBR1a = new ModelRenderer( this, 190, 95 );
        BalloonFrameBR1a.setTextureSize( 256, 128 );
        BalloonFrameBR1a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameBR1a.setRotationPoint( -13F, -6F, -10F );
        BalloonFrameBR1b = new ModelRenderer( this, 188, 94 );
        BalloonFrameBR1b.setTextureSize( 256, 128 );
        BalloonFrameBR1b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameBR1b.setRotationPoint( -21F, -6F, -10F );
        BalloonFrameBR2a = new ModelRenderer( this, 184, 91 );
        BalloonFrameBR2a.setTextureSize( 256, 128 );
        BalloonFrameBR2a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameBR2a.setRotationPoint( -14F, -7F, -11F );
        BalloonFrameBR2b = new ModelRenderer( this, 182, 90 );
        BalloonFrameBR2b.setTextureSize( 256, 128 );
        BalloonFrameBR2b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameBR2b.setRotationPoint( -20F, -7F, -11F );
        BalloonFrameTL1a = new ModelRenderer( this, 182, 91 );
        BalloonFrameTL1a.setTextureSize( 256, 128 );
        BalloonFrameTL1a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameTL1a.setRotationPoint( 21F, -14F, -10F );
        BalloonFrameTL1b = new ModelRenderer( this, 180, 90 );
        BalloonFrameTL1b.setTextureSize( 256, 128 );
        BalloonFrameTL1b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameTL1b.setRotationPoint( 13F, -14F, -10F );
        BalloonFrameTL2a = new ModelRenderer( this, 176, 87 );
        BalloonFrameTL2a.setTextureSize( 256, 128 );
        BalloonFrameTL2a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameTL2a.setRotationPoint( 20F, -13F, -11F );
        BalloonFrameTL2b = new ModelRenderer( this, 174, 86 );
        BalloonFrameTL2b.setTextureSize( 256, 128 );
        BalloonFrameTL2b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameTL2b.setRotationPoint( 14F, -13F, -11F );
        BalloonFrameBL1a = new ModelRenderer( this, 174, 87 );
        BalloonFrameBL1a.setTextureSize( 256, 128 );
        BalloonFrameBL1a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameBL1a.setRotationPoint( 21F, -6F, -10F );
        BalloonFrameBL1b = new ModelRenderer( this, 172, 86 );
        BalloonFrameBL1b.setTextureSize( 256, 128 );
        BalloonFrameBL1b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 28);
        BalloonFrameBL1b.setRotationPoint( 13F, -6F, -10F );
        BalloonFrameBL2a = new ModelRenderer( this, 168, 83 );
        BalloonFrameBL2a.setTextureSize( 256, 128 );
        BalloonFrameBL2a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameBL2a.setRotationPoint( 20F, -7F, -11F );
        BalloonFrameBL2b = new ModelRenderer( this, 166, 82 );
        BalloonFrameBL2b.setTextureSize( 256, 128 );
        BalloonFrameBL2b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 30);
        BalloonFrameBL2b.setRotationPoint( 14F, -7F, -11F );
        BalloonFrameTR3a = new ModelRenderer( this, 220, 94 );
        BalloonFrameTR3a.setTextureSize( 256, 128 );
        BalloonFrameTR3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR3a.setRotationPoint( -14F, -2F, -2F );
        BalloonFrameTR3b = new ModelRenderer( this, 218, 93 );
        BalloonFrameTR3b.setTextureSize( 256, 128 );
        BalloonFrameTR3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR3b.setRotationPoint( -20F, -2F, -2F );
        BalloonFrameTR4a = new ModelRenderer( this, 216, 92 );
        BalloonFrameTR4a.setTextureSize( 256, 128 );
        BalloonFrameTR4a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR4a.setRotationPoint( -15F, -1F, -3F );
        BalloonFrameTR4b = new ModelRenderer( this, 214, 91 );
        BalloonFrameTR4b.setTextureSize( 256, 128 );
        BalloonFrameTR4b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR4b.setRotationPoint( -19F, -1F, -3F );
        BalloonFrameBR3a = new ModelRenderer( this, 212, 90 );
        BalloonFrameBR3a.setTextureSize( 256, 128 );
        BalloonFrameBR3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR3a.setRotationPoint( -14F, 4F, -2F );
        BalloonFrameBR3b = new ModelRenderer( this, 210, 89 );
        BalloonFrameBR3b.setTextureSize( 256, 128 );
        BalloonFrameBR3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR3b.setRotationPoint( -20F, 4F, -2F );
        BalloonFrameBR4a = new ModelRenderer( this, 208, 88 );
        BalloonFrameBR4a.setTextureSize( 256, 128 );
        BalloonFrameBR4a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR4a.setRotationPoint( -15F, 3F, -3F );
        BalloonFrameBR4b = new ModelRenderer( this, 206, 87 );
        BalloonFrameBR4b.setTextureSize( 256, 128 );
        BalloonFrameBR4b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR4b.setRotationPoint( -19F, 3F, -3F );
        BalloonFrameTL3a = new ModelRenderer( this, 204, 86 );
        BalloonFrameTL3a.setTextureSize( 256, 128 );
        BalloonFrameTL3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL3a.setRotationPoint( 20F, -2F, -2F );
        BalloonFrameTL3b = new ModelRenderer( this, 202, 85 );
        BalloonFrameTL3b.setTextureSize( 256, 128 );
        BalloonFrameTL3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL3b.setRotationPoint( 14F, -2F, -2F );
        BalloonFrameTL4a = new ModelRenderer( this, 200, 84 );
        BalloonFrameTL4a.setTextureSize( 256, 128 );
        BalloonFrameTL4a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL4a.setRotationPoint( 19F, -1F, -3F );
        BalloonFrameTL4b = new ModelRenderer( this, 198, 83 );
        BalloonFrameTL4b.setTextureSize( 256, 128 );
        BalloonFrameTL4b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL4b.setRotationPoint( 15F, -1F, -3F );
        BalloonFrameBL3a = new ModelRenderer( this, 196, 82 );
        BalloonFrameBL3a.setTextureSize( 256, 128 );
        BalloonFrameBL3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL3a.setRotationPoint( 20F, 4F, -2F );
        BalloonFrameBL3b = new ModelRenderer( this, 194, 81 );
        BalloonFrameBL3b.setTextureSize( 256, 128 );
        BalloonFrameBL3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL3b.setRotationPoint( 14F, 4F, -2F );
        BalloonFrameBL4a = new ModelRenderer( this, 192, 80 );
        BalloonFrameBL4a.setTextureSize( 256, 128 );
        BalloonFrameBL4a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL4a.setRotationPoint( 19F, 3F, -3F );
        BalloonFrameBL4b = new ModelRenderer( this, 190, 79 );
        BalloonFrameBL4b.setTextureSize( 256, 128 );
        BalloonFrameBL4b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL4b.setRotationPoint( 15F, 3F, -3F );
        BalloonFrameTLM1f = new ModelRenderer( this, 240, 0 );
        BalloonFrameTLM1f.setTextureSize( 256, 128 );
        BalloonFrameTLM1f.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameTLM1f.setRotationPoint( -20F, -13F, -11F );
        BalloonFrameTRM1f = new ModelRenderer( this, 240, 8 );
        BalloonFrameTRM1f.setTextureSize( 256, 128 );
        BalloonFrameTRM1f.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameTRM1f.setRotationPoint( 14F, -13F, -11F );
        BalloonFrameTLM1b = new ModelRenderer( this, 240, 0 );
        BalloonFrameTLM1b.setTextureSize( 256, 128 );
        BalloonFrameTLM1b.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameTLM1b.setRotationPoint( -17F, -10F, 17F );
        BalloonFrameTRM1b = new ModelRenderer( this, 240, 8 );
        BalloonFrameTRM1b.setTextureSize( 256, 128 );
        BalloonFrameTRM1b.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameTRM1b.setRotationPoint( 17F, -10F, 17F );
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
        ItemFrameLeftInside.setRotationPoint( -22F, -10F, 3F );
        ItemFrameLeftBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameLeftBorderT.setTextureSize( 256, 128 );
        ItemFrameLeftBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderT.setRotationPoint( -22F, -16F, 2.5F );
        ItemFrameLeftBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameLeftBorderB.setTextureSize( 256, 128 );
        ItemFrameLeftBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderB.setRotationPoint( -22F, -4F, 3.5F );
        ItemFrameLeftBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameLeftBorderR.setTextureSize( 256, 128 );
        ItemFrameLeftBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderR.setRotationPoint( -22F, -9.5F, -3F );
        ItemFrameLeftBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameLeftBorderL.setTextureSize( 256, 128 );
        ItemFrameLeftBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderL.setRotationPoint( -22F, -10.5F, 9F );
        ItemFrameRightInside = new ModelRenderer( this, 49, 106 );
        ItemFrameRightInside.setTextureSize( 256, 128 );
        ItemFrameRightInside.addBox( 0F, -5.5F, -5.5F, 0, 11, 11);
        ItemFrameRightInside.setRotationPoint( 22F, -10F, 3F );
        ItemFrameRightBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameRightBorderT.setTextureSize( 256, 128 );
        ItemFrameRightBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderT.setRotationPoint( 22F, -16F, 2.5F );
        ItemFrameRightBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameRightBorderB.setTextureSize( 256, 128 );
        ItemFrameRightBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderB.setRotationPoint( 22F, -4F, 3.5F );
        ItemFrameRightBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameRightBorderR.setTextureSize( 256, 128 );
        ItemFrameRightBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderR.setRotationPoint( 22F, -9.5F, -3F );
        ItemFrameRightBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameRightBorderL.setTextureSize( 256, 128 );
        ItemFrameRightBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderL.setRotationPoint( 22F, -10.5F, 9F );
        BombBay = new ModelRenderer( this, 22, 26 );
        BombBay.setTextureSize( 256, 128 );
        BombBay.addBox( -4F, -0.5F, -4F, 8, 1, 8);
        BombBay.setRotationPoint( 0F, 7F, 0F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Anchor_1a.rotateAngleX = 0F;
        Anchor_1a.rotateAngleY = 0F;
        Anchor_1a.rotateAngleZ = 0F;
        Anchor_1a.renderWithRotation(par7);

        Anchor_1c.rotateAngleX = 0F;
        Anchor_1c.rotateAngleY = 0F;
        Anchor_1c.rotateAngleZ = 0F;
        Anchor_1c.renderWithRotation(par7);

        Base_Side_R1.rotateAngleX = 0F;
        Base_Side_R1.rotateAngleY = 0F;
        Base_Side_R1.rotateAngleZ = 0F;
        Base_Side_R1.renderWithRotation(par7);

        Base_Side_L2.rotateAngleX = 0F;
        Base_Side_L2.rotateAngleY = 0F;
        Base_Side_L2.rotateAngleZ = 0F;
        Base_Side_L2.renderWithRotation(par7);

        Base_Side_L3.rotateAngleX = 0F;
        Base_Side_L3.rotateAngleY = 0F;
        Base_Side_L3.rotateAngleZ = 0F;
        Base_Side_L3.renderWithRotation(par7);

        Base_Side_L4.rotateAngleX = 0F;
        Base_Side_L4.rotateAngleY = 0F;
        Base_Side_L4.rotateAngleZ = 0F;
        Base_Side_L4.renderWithRotation(par7);

        Base_Side_R11.rotateAngleX = 0F;
        Base_Side_R11.rotateAngleY = 0F;
        Base_Side_R11.rotateAngleZ = 0F;
        Base_Side_R11.renderWithRotation(par7);

        Base_Side_R2.rotateAngleX = 0F;
        Base_Side_R2.rotateAngleY = 0F;
        Base_Side_R2.rotateAngleZ = 0F;
        Base_Side_R2.renderWithRotation(par7);

        Base_Side_R3.rotateAngleX = 0F;
        Base_Side_R3.rotateAngleY = 0F;
        Base_Side_R3.rotateAngleZ = 0F;
        Base_Side_R3.renderWithRotation(par7);

        Base_Side_R4.rotateAngleX = 0F;
        Base_Side_R4.rotateAngleY = 0F;
        Base_Side_R4.rotateAngleZ = 0F;
        Base_Side_R4.renderWithRotation(par7);

        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_FL2a.rotateAngleX = 0F;
        Engine_FL2a.rotateAngleY = 0F;
        Engine_FL2a.rotateAngleZ = 0F;
        Engine_FL2a.renderWithRotation(par7);

        Engine_FR2a.rotateAngleX = 0F;
        Engine_FR2a.rotateAngleY = 0F;
        Engine_FR2a.rotateAngleZ = 0F;
        Engine_FR2a.renderWithRotation(par7);

        Pole1.rotateAngleX = 0F;
        Pole1.rotateAngleY = 0F;
        Pole1.rotateAngleZ = -0.2617994F;
        Pole1.renderWithRotation(par7);

        Pole2.rotateAngleX = 0F;
        Pole2.rotateAngleY = 0F;
        Pole2.rotateAngleZ = 0.2617994F;
        Pole2.renderWithRotation(par7);

        Engine_R1c.rotateAngleX = 0F;
        Engine_R1c.rotateAngleY = 0F;
        Engine_R1c.rotateAngleZ = -0.3490658F;
        Engine_R1c.renderWithRotation(par7);

        Engine_L1c.rotateAngleX = 0F;
        Engine_L1c.rotateAngleY = 0F;
        Engine_L1c.rotateAngleZ = 0.3490658F;
        Engine_L1c.renderWithRotation(par7);

        BalloonFrameBLMa.rotateAngleX = 0F;
        BalloonFrameBLMa.rotateAngleY = 0F;
        BalloonFrameBLMa.rotateAngleZ = 0F;
        BalloonFrameBLMa.renderWithRotation(par7);

        BalloonFrameBRMa.rotateAngleX = 0F;
        BalloonFrameBRMa.rotateAngleY = 0F;
        BalloonFrameBRMa.rotateAngleZ = 0F;
        BalloonFrameBRMa.renderWithRotation(par7);

        BalloonFrameTR1a.rotateAngleX = 0F;
        BalloonFrameTR1a.rotateAngleY = 0F;
        BalloonFrameTR1a.rotateAngleZ = 0F;
        BalloonFrameTR1a.renderWithRotation(par7);

        BalloonFrameTR1b.rotateAngleX = 0F;
        BalloonFrameTR1b.rotateAngleY = 0F;
        BalloonFrameTR1b.rotateAngleZ = 0F;
        BalloonFrameTR1b.renderWithRotation(par7);

        BalloonFrameTR2a.rotateAngleX = 0F;
        BalloonFrameTR2a.rotateAngleY = 0F;
        BalloonFrameTR2a.rotateAngleZ = 0F;
        BalloonFrameTR2a.renderWithRotation(par7);

        BalloonFrameTR2b.rotateAngleX = 0F;
        BalloonFrameTR2b.rotateAngleY = 0F;
        BalloonFrameTR2b.rotateAngleZ = 0F;
        BalloonFrameTR2b.renderWithRotation(par7);

        BalloonFrameBR1a.rotateAngleX = 0F;
        BalloonFrameBR1a.rotateAngleY = 0F;
        BalloonFrameBR1a.rotateAngleZ = 0F;
        BalloonFrameBR1a.renderWithRotation(par7);

        BalloonFrameBR1b.rotateAngleX = 0F;
        BalloonFrameBR1b.rotateAngleY = 0F;
        BalloonFrameBR1b.rotateAngleZ = 0F;
        BalloonFrameBR1b.renderWithRotation(par7);

        BalloonFrameBR2a.rotateAngleX = 0F;
        BalloonFrameBR2a.rotateAngleY = 0F;
        BalloonFrameBR2a.rotateAngleZ = 0F;
        BalloonFrameBR2a.renderWithRotation(par7);

        BalloonFrameBR2b.rotateAngleX = 0F;
        BalloonFrameBR2b.rotateAngleY = 0F;
        BalloonFrameBR2b.rotateAngleZ = 0F;
        BalloonFrameBR2b.renderWithRotation(par7);

        BalloonFrameTL1a.rotateAngleX = 0F;
        BalloonFrameTL1a.rotateAngleY = 0F;
        BalloonFrameTL1a.rotateAngleZ = 0F;
        BalloonFrameTL1a.renderWithRotation(par7);

        BalloonFrameTL1b.rotateAngleX = 0F;
        BalloonFrameTL1b.rotateAngleY = 0F;
        BalloonFrameTL1b.rotateAngleZ = 0F;
        BalloonFrameTL1b.renderWithRotation(par7);

        BalloonFrameTL2a.rotateAngleX = 0F;
        BalloonFrameTL2a.rotateAngleY = 0F;
        BalloonFrameTL2a.rotateAngleZ = 0F;
        BalloonFrameTL2a.renderWithRotation(par7);

        BalloonFrameTL2b.rotateAngleX = 0F;
        BalloonFrameTL2b.rotateAngleY = 0F;
        BalloonFrameTL2b.rotateAngleZ = 0F;
        BalloonFrameTL2b.renderWithRotation(par7);

        BalloonFrameBL1a.rotateAngleX = 0F;
        BalloonFrameBL1a.rotateAngleY = 0F;
        BalloonFrameBL1a.rotateAngleZ = 0F;
        BalloonFrameBL1a.renderWithRotation(par7);

        BalloonFrameBL1b.rotateAngleX = 0F;
        BalloonFrameBL1b.rotateAngleY = 0F;
        BalloonFrameBL1b.rotateAngleZ = 0F;
        BalloonFrameBL1b.renderWithRotation(par7);

        BalloonFrameBL2a.rotateAngleX = 0F;
        BalloonFrameBL2a.rotateAngleY = 0F;
        BalloonFrameBL2a.rotateAngleZ = 0F;
        BalloonFrameBL2a.renderWithRotation(par7);

        BalloonFrameBL2b.rotateAngleX = 0F;
        BalloonFrameBL2b.rotateAngleY = 0F;
        BalloonFrameBL2b.rotateAngleZ = 0F;
        BalloonFrameBL2b.renderWithRotation(par7);

        BalloonFrameTR3a.rotateAngleX = 0F;
        BalloonFrameTR3a.rotateAngleY = 0F;
        BalloonFrameTR3a.rotateAngleZ = 0F;
        BalloonFrameTR3a.renderWithRotation(par7);

        BalloonFrameTR3b.rotateAngleX = 0F;
        BalloonFrameTR3b.rotateAngleY = 0F;
        BalloonFrameTR3b.rotateAngleZ = 0F;
        BalloonFrameTR3b.renderWithRotation(par7);

        BalloonFrameTR4a.rotateAngleX = 0F;
        BalloonFrameTR4a.rotateAngleY = 0F;
        BalloonFrameTR4a.rotateAngleZ = 0F;
        BalloonFrameTR4a.renderWithRotation(par7);

        BalloonFrameTR4b.rotateAngleX = 0F;
        BalloonFrameTR4b.rotateAngleY = 0F;
        BalloonFrameTR4b.rotateAngleZ = 0F;
        BalloonFrameTR4b.renderWithRotation(par7);

        BalloonFrameBR3a.rotateAngleX = 0F;
        BalloonFrameBR3a.rotateAngleY = 0F;
        BalloonFrameBR3a.rotateAngleZ = 0F;
        BalloonFrameBR3a.renderWithRotation(par7);

        BalloonFrameBR3b.rotateAngleX = 0F;
        BalloonFrameBR3b.rotateAngleY = 0F;
        BalloonFrameBR3b.rotateAngleZ = 0F;
        BalloonFrameBR3b.renderWithRotation(par7);

        BalloonFrameBR4a.rotateAngleX = 0F;
        BalloonFrameBR4a.rotateAngleY = 0F;
        BalloonFrameBR4a.rotateAngleZ = 0F;
        BalloonFrameBR4a.renderWithRotation(par7);

        BalloonFrameBR4b.rotateAngleX = 0F;
        BalloonFrameBR4b.rotateAngleY = 0F;
        BalloonFrameBR4b.rotateAngleZ = 0F;
        BalloonFrameBR4b.renderWithRotation(par7);

        BalloonFrameTL3a.rotateAngleX = 0F;
        BalloonFrameTL3a.rotateAngleY = 0F;
        BalloonFrameTL3a.rotateAngleZ = 0F;
        BalloonFrameTL3a.renderWithRotation(par7);

        BalloonFrameTL3b.rotateAngleX = 0F;
        BalloonFrameTL3b.rotateAngleY = 0F;
        BalloonFrameTL3b.rotateAngleZ = 0F;
        BalloonFrameTL3b.renderWithRotation(par7);

        BalloonFrameTL4a.rotateAngleX = 0F;
        BalloonFrameTL4a.rotateAngleY = 0F;
        BalloonFrameTL4a.rotateAngleZ = 0F;
        BalloonFrameTL4a.renderWithRotation(par7);

        BalloonFrameTL4b.rotateAngleX = 0F;
        BalloonFrameTL4b.rotateAngleY = 0F;
        BalloonFrameTL4b.rotateAngleZ = 0F;
        BalloonFrameTL4b.renderWithRotation(par7);

        BalloonFrameBL3a.rotateAngleX = 0F;
        BalloonFrameBL3a.rotateAngleY = 0F;
        BalloonFrameBL3a.rotateAngleZ = 0F;
        BalloonFrameBL3a.renderWithRotation(par7);

        BalloonFrameBL3b.rotateAngleX = 0F;
        BalloonFrameBL3b.rotateAngleY = 0F;
        BalloonFrameBL3b.rotateAngleZ = 0F;
        BalloonFrameBL3b.renderWithRotation(par7);

        BalloonFrameBL4a.rotateAngleX = 0F;
        BalloonFrameBL4a.rotateAngleY = 0F;
        BalloonFrameBL4a.rotateAngleZ = 0F;
        BalloonFrameBL4a.renderWithRotation(par7);

        BalloonFrameBL4b.rotateAngleX = 0F;
        BalloonFrameBL4b.rotateAngleY = 0F;
        BalloonFrameBL4b.rotateAngleZ = 0F;
        BalloonFrameBL4b.renderWithRotation(par7);

        BalloonFrameTLM1f.rotateAngleX = 0F;
        BalloonFrameTLM1f.rotateAngleY = 0F;
        BalloonFrameTLM1f.rotateAngleZ = 0F;
        BalloonFrameTLM1f.renderWithRotation(par7);

        BalloonFrameTRM1f.rotateAngleX = 0F;
        BalloonFrameTRM1f.rotateAngleY = 0F;
        BalloonFrameTRM1f.rotateAngleZ = 0F;
        BalloonFrameTRM1f.renderWithRotation(par7);

        BalloonFrameTLM1b.rotateAngleX = 0F;
        BalloonFrameTLM1b.rotateAngleY = 0F;
        BalloonFrameTLM1b.rotateAngleZ = 0F;
        BalloonFrameTLM1b.renderWithRotation(par7);

        BalloonFrameTRM1b.rotateAngleX = 0F;
        BalloonFrameTRM1b.rotateAngleY = 0F;
        BalloonFrameTRM1b.rotateAngleZ = 0F;
        BalloonFrameTRM1b.renderWithRotation(par7);

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
