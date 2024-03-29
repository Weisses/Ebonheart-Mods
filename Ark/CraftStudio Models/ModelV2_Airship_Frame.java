package net.minecraft.src;

public class ModelV2_Airship_Frame extends ModelBase
{
    ModelRenderer Engine_R1;
    ModelRenderer Engine_R1a;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_L1a;
    ModelRenderer Engine_FL2a;
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
    ModelRenderer BackEngineL;
    ModelRenderer BackEngineR;
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
    ModelRenderer Engine_R1b;
    ModelRenderer Engine_PipePivot_R;
    ModelRenderer Engine_PipePivot_L;
    ModelRenderer Engine_L1b;
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

    public ModelV2_Airship_Frame()
    {
        this( 0.0f );
    }

    public ModelV2_Airship_Frame( float par1 )
    {
        Engine_R1 = new ModelRenderer( this, 34, 76 );
        Engine_R1.setTextureSize( 256, 128 );
        Engine_R1.addBox( 0F, 1F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -13F, -2F, 6F );
        Engine_R1a = new ModelRenderer( this, 56, 88 );
        Engine_R1a.setTextureSize( 256, 128 );
        Engine_R1a.addBox( 0F, 0F, 1F, 1, 1, 6);
        Engine_R1a.setRotationPoint( -10.2F, 5F, 7.2F );
        Engine_L1 = new ModelRenderer( this, 34, 64 );
        Engine_L1.setTextureSize( 256, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 9F, -1F, 6F );
        Engine_L1a = new ModelRenderer( this, 56, 88 );
        Engine_L1a.setTextureSize( 256, 128 );
        Engine_L1a.addBox( 0F, 0F, 1F, 1, 1, 6);
        Engine_L1a.setRotationPoint( 8.8F, 5F, 7.2F );
        Engine_FL2a = new ModelRenderer( this, 102, 76 );
        Engine_FL2a.setTextureSize( 256, 128 );
        Engine_FL2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FL2a.setRotationPoint( 15F, -2F, -3F );
        Engine_FR2a = new ModelRenderer( this, 102, 64 );
        Engine_FR2a.setTextureSize( 256, 128 );
        Engine_FR2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FR2a.setRotationPoint( -19F, -2F, -3F );
        Pipe_L1a = new ModelRenderer( this, 64, 92 );
        Pipe_L1a.setTextureSize( 256, 128 );
        Pipe_L1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_L1a.setRotationPoint( 13F, 3F, 9F );
        Pipe_L1b = new ModelRenderer( this, 64, 85 );
        Pipe_L1b.setTextureSize( 256, 128 );
        Pipe_L1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_L1b.setRotationPoint( 17F, 3F, 3F );
        Pipe_R1a = new ModelRenderer( this, 64, 92 );
        Pipe_R1a.setTextureSize( 256, 128 );
        Pipe_R1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_R1a.setRotationPoint( -18F, 3F, 9F );
        Pipe_R1b = new ModelRenderer( this, 64, 85 );
        Pipe_R1b.setTextureSize( 256, 128 );
        Pipe_R1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_R1b.setRotationPoint( -18F, 3F, 3F );
        BalloonFrameRMa = new ModelRenderer( this, 240, 0 );
        BalloonFrameRMa.setTextureSize( 256, 128 );
        BalloonFrameRMa.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameRMa.setRotationPoint( -20F, -5F, -14F );
        BalloonFrameRT1a = new ModelRenderer( this, 202, 101 );
        BalloonFrameRT1a.setTextureSize( 256, 128 );
        BalloonFrameRT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1a.setRotationPoint( -12.5F, -7.5F, -12.5F );
        BalloonFrameRT1b = new ModelRenderer( this, 200, 100 );
        BalloonFrameRT1b.setTextureSize( 256, 128 );
        BalloonFrameRT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1b.setRotationPoint( -22.5F, -7.5F, -12.5F );
        BalloonFrameRB1a = new ModelRenderer( this, 198, 99 );
        BalloonFrameRB1a.setTextureSize( 256, 128 );
        BalloonFrameRB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1a.setRotationPoint( -12.5F, 2.5F, -12.5F );
        BalloonFrameRB1b = new ModelRenderer( this, 196, 98 );
        BalloonFrameRB1b.setTextureSize( 256, 128 );
        BalloonFrameRB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1b.setRotationPoint( -22.5F, 2.5F, -12.5F );
        BalloonFrameRT2a1 = new ModelRenderer( this, 192, 95 );
        BalloonFrameRT2a1.setTextureSize( 256, 128 );
        BalloonFrameRT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2a1.setRotationPoint( -13.5F, -6.5F, -13.5F );
        BalloonFrameRT2a2 = new ModelRenderer( this, 189, 93 );
        BalloonFrameRT2a2.setTextureSize( 256, 128 );
        BalloonFrameRT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2a2.setRotationPoint( -14.5F, -5.5F, -14.5F );
        BalloonFrameRT2b1 = new ModelRenderer( this, 188, 93 );
        BalloonFrameRT2b1.setTextureSize( 256, 128 );
        BalloonFrameRT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2b1.setRotationPoint( -21.5F, -6.5F, -13.5F );
        BalloonFrameRT2b2 = new ModelRenderer( this, 185, 91 );
        BalloonFrameRT2b2.setTextureSize( 256, 128 );
        BalloonFrameRT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2b2.setRotationPoint( -20.5F, -5.5F, -14.5F );
        BalloonFrameRB2a1 = new ModelRenderer( this, 184, 91 );
        BalloonFrameRB2a1.setTextureSize( 256, 128 );
        BalloonFrameRB2a1.addBox( 0F, 0F, -1F, 1, 1, 28);
        BalloonFrameRB2a1.setRotationPoint( -13.5F, 1.5F, -12.5F );
        BalloonFrameRB2a2 = new ModelRenderer( this, 181, 89 );
        BalloonFrameRB2a2.setTextureSize( 256, 128 );
        BalloonFrameRB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2a2.setRotationPoint( -14.5F, 0.5F, -14.5F );
        BalloonFrameRB2b1 = new ModelRenderer( this, 180, 89 );
        BalloonFrameRB2b1.setTextureSize( 256, 128 );
        BalloonFrameRB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRB2b1.setRotationPoint( -21.5F, 1.5F, -13.5F );
        BalloonFrameRB2b2 = new ModelRenderer( this, 177, 87 );
        BalloonFrameRB2b2.setTextureSize( 256, 128 );
        BalloonFrameRB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2b2.setRotationPoint( -20.5F, 0.5F, -14.5F );
        AnchorRa = new ModelRenderer( this, 0, 6 );
        AnchorRa.setTextureSize( 256, 128 );
        AnchorRa.addBox( 0F, 0F, 0F, 2, 2, 6);
        AnchorRa.setRotationPoint( -9.5F, 0.5F, -3F );
        JointR1a = new ModelRenderer( this, 14, 0 );
        JointR1a.setTextureSize( 256, 128 );
        JointR1a.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1a.setRotationPoint( -8.5F, 1.5F, -2F );
        JointR1b = new ModelRenderer( this, 14, 0 );
        JointR1b.setTextureSize( 256, 128 );
        JointR1b.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1b.setRotationPoint( -8.5F, 1.5F, 2F );
        BalloonFrameLMa = new ModelRenderer( this, 240, 8 );
        BalloonFrameLMa.setTextureSize( 256, 128 );
        BalloonFrameLMa.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameLMa.setRotationPoint( 14F, -5F, -14F );
        BalloonFrameLT1a = new ModelRenderer( this, 202, 101 );
        BalloonFrameLT1a.setTextureSize( 256, 128 );
        BalloonFrameLT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1a.setRotationPoint( 21.5F, -7.5F, -12.5F );
        BalloonFrameLT1b = new ModelRenderer( this, 200, 100 );
        BalloonFrameLT1b.setTextureSize( 256, 128 );
        BalloonFrameLT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1b.setRotationPoint( 11.5F, -7.5F, -12.5F );
        BalloonFrameLB1a = new ModelRenderer( this, 198, 99 );
        BalloonFrameLB1a.setTextureSize( 256, 128 );
        BalloonFrameLB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1a.setRotationPoint( 21.5F, 2.5F, -12.5F );
        BalloonFrameLB1b = new ModelRenderer( this, 196, 98 );
        BalloonFrameLB1b.setTextureSize( 256, 128 );
        BalloonFrameLB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1b.setRotationPoint( 11.5F, 2.5F, -12.5F );
        BalloonFrameLT2a1 = new ModelRenderer( this, 192, 95 );
        BalloonFrameLT2a1.setTextureSize( 256, 128 );
        BalloonFrameLT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2a1.setRotationPoint( 20.5F, -6.5F, -13.5F );
        BalloonFrameLT2a2 = new ModelRenderer( this, 189, 93 );
        BalloonFrameLT2a2.setTextureSize( 256, 128 );
        BalloonFrameLT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2a2.setRotationPoint( 19.5F, -5.5F, -14.5F );
        BalloonFrameLT2b1 = new ModelRenderer( this, 188, 93 );
        BalloonFrameLT2b1.setTextureSize( 256, 128 );
        BalloonFrameLT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2b1.setRotationPoint( 12.5F, -6.5F, -13.5F );
        BalloonFrameLT2b2 = new ModelRenderer( this, 185, 91 );
        BalloonFrameLT2b2.setTextureSize( 256, 128 );
        BalloonFrameLT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2b2.setRotationPoint( 13.5F, -5.5F, -14.5F );
        BalloonFrameLB2a1 = new ModelRenderer( this, 184, 91 );
        BalloonFrameLB2a1.setTextureSize( 256, 128 );
        BalloonFrameLB2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2a1.setRotationPoint( 20.5F, 1.5F, -13.5F );
        BalloonFrameLB2a2 = new ModelRenderer( this, 181, 89 );
        BalloonFrameLB2a2.setTextureSize( 256, 128 );
        BalloonFrameLB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2a2.setRotationPoint( 19.5F, 0.5F, -14.5F );
        BalloonFrameLB2b1 = new ModelRenderer( this, 180, 89 );
        BalloonFrameLB2b1.setTextureSize( 256, 128 );
        BalloonFrameLB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2b1.setRotationPoint( 12.5F, 1.5F, -13.5F );
        BalloonFrameLB2b2 = new ModelRenderer( this, 177, 87 );
        BalloonFrameLB2b2.setTextureSize( 256, 128 );
        BalloonFrameLB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2b2.setRotationPoint( 13.5F, 0.5F, -14.5F );
        AnchorLa = new ModelRenderer( this, 0, 6 );
        AnchorLa.setTextureSize( 256, 128 );
        AnchorLa.addBox( 0F, 0F, 0F, 2, 2, 6);
        AnchorLa.setRotationPoint( 7.5F, 0.5F, -3F );
        JointL1a = new ModelRenderer( this, 14, 0 );
        JointL1a.setTextureSize( 256, 128 );
        JointL1a.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1a.setRotationPoint( 8.5F, 1.5F, 2F );
        JointL1b = new ModelRenderer( this, 14, 0 );
        JointL1b.setTextureSize( 256, 128 );
        JointL1b.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1b.setRotationPoint( 8.5F, 1.5F, -2F );
        BackEngineL = new ModelRenderer( this, 92, 9 );
        BackEngineL.setTextureSize( 256, 128 );
        BackEngineL.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineL.setRotationPoint( 13F, -6F, 13F );
        BackEngineR = new ModelRenderer( this, 92, 0 );
        BackEngineR.setTextureSize( 256, 128 );
        BackEngineR.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineR.setRotationPoint( -21F, -6F, 13F );
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
        Engine_R1b = new ModelRenderer( this, 54, 95 );
        Engine_R1b.setTextureSize( 256, 128 );
        Engine_R1b.addBox( 0F, 0F, 0F, 4, 1, 1);
        Engine_R1b.setRotationPoint( -9.2F, 4F, 13.8F );
        Engine_PipePivot_R = new ModelRenderer( this, 68, 95 );
        Engine_PipePivot_R.setTextureSize( 256, 128 );
        Engine_PipePivot_R.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Engine_PipePivot_R.setRotationPoint( -9.5F, 4.5F, 14.5F );
        Engine_PipePivot_L = new ModelRenderer( this, 68, 95 );
        Engine_PipePivot_L.setTextureSize( 256, 128 );
        Engine_PipePivot_L.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Engine_PipePivot_L.setRotationPoint( 9.5F, 4.5F, 14.5F );
        Engine_L1b = new ModelRenderer( this, 54, 95 );
        Engine_L1b.setTextureSize( 256, 128 );
        Engine_L1b.addBox( 0F, 0F, 0F, 4, 1, 1);
        Engine_L1b.setRotationPoint( 5.2F, 4F, 13.8F );
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
        ItemFrameLeftInside.setRotationPoint( -23F, -2F, 0F );
        ItemFrameLeftBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameLeftBorderT.setTextureSize( 256, 128 );
        ItemFrameLeftBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderT.setRotationPoint( -23F, -8F, -0.5F );
        ItemFrameLeftBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameLeftBorderB.setTextureSize( 256, 128 );
        ItemFrameLeftBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameLeftBorderB.setRotationPoint( -23F, 4F, 0.5F );
        ItemFrameLeftBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameLeftBorderR.setTextureSize( 256, 128 );
        ItemFrameLeftBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderR.setRotationPoint( -23F, -1.5F, -6F );
        ItemFrameLeftBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameLeftBorderL.setTextureSize( 256, 128 );
        ItemFrameLeftBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameLeftBorderL.setRotationPoint( -23F, -2.5F, 6F );
        ItemFrameRightInside = new ModelRenderer( this, 49, 106 );
        ItemFrameRightInside.setTextureSize( 256, 128 );
        ItemFrameRightInside.addBox( 0F, -5.5F, -5.5F, 0, 11, 11);
        ItemFrameRightInside.setRotationPoint( 23F, -2F, 0F );
        ItemFrameRightBorderT = new ModelRenderer( this, 148, 104 );
        ItemFrameRightBorderT.setTextureSize( 256, 128 );
        ItemFrameRightBorderT.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderT.setRotationPoint( 23F, -8F, -0.5F );
        ItemFrameRightBorderB = new ModelRenderer( this, 146, 103 );
        ItemFrameRightBorderB.setTextureSize( 256, 128 );
        ItemFrameRightBorderB.addBox( -0.5F, -0.5F, -6F, 1, 1, 12);
        ItemFrameRightBorderB.setRotationPoint( 23F, 4F, 0.5F );
        ItemFrameRightBorderR = new ModelRenderer( this, 158, 115 );
        ItemFrameRightBorderR.setTextureSize( 256, 128 );
        ItemFrameRightBorderR.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderR.setRotationPoint( 23F, -1.5F, -6F );
        ItemFrameRightBorderL = new ModelRenderer( this, 162, 115 );
        ItemFrameRightBorderL.setTextureSize( 256, 128 );
        ItemFrameRightBorderL.addBox( -0.5F, -6F, -0.5F, 1, 12, 1);
        ItemFrameRightBorderL.setRotationPoint( 23F, -2.5F, 6F );
        BombBay = new ModelRenderer( this, 22, 26 );
        BombBay.setTextureSize( 256, 128 );
        BombBay.addBox( -4F, -0.5F, -4F, 8, 1, 8);
        BombBay.setRotationPoint( 0F, 7F, 0F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Engine_R1a.rotateAngleX = 0F;
        Engine_R1a.rotateAngleY = 0F;
        Engine_R1a.rotateAngleZ = -0.7853982F;
        Engine_R1a.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_L1a.rotateAngleX = 0F;
        Engine_L1a.rotateAngleY = 0F;
        Engine_L1a.rotateAngleZ = -0.7853982F;
        Engine_L1a.renderWithRotation(par7);

        Engine_FL2a.rotateAngleX = 0F;
        Engine_FL2a.rotateAngleY = 0F;
        Engine_FL2a.rotateAngleZ = 0F;
        Engine_FL2a.renderWithRotation(par7);

        Engine_FR2a.rotateAngleX = 0F;
        Engine_FR2a.rotateAngleY = 0F;
        Engine_FR2a.rotateAngleZ = 0F;
        Engine_FR2a.renderWithRotation(par7);

        Pipe_L1a.rotateAngleX = 0F;
        Pipe_L1a.rotateAngleY = 0F;
        Pipe_L1a.rotateAngleZ = 0F;
        Pipe_L1a.renderWithRotation(par7);

        Pipe_L1b.rotateAngleX = 0F;
        Pipe_L1b.rotateAngleY = 0F;
        Pipe_L1b.rotateAngleZ = 0F;
        Pipe_L1b.renderWithRotation(par7);

        Pipe_R1a.rotateAngleX = 0F;
        Pipe_R1a.rotateAngleY = 0F;
        Pipe_R1a.rotateAngleZ = 0F;
        Pipe_R1a.renderWithRotation(par7);

        Pipe_R1b.rotateAngleX = 0F;
        Pipe_R1b.rotateAngleY = 0F;
        Pipe_R1b.rotateAngleZ = 0F;
        Pipe_R1b.renderWithRotation(par7);

        BalloonFrameRMa.rotateAngleX = 0F;
        BalloonFrameRMa.rotateAngleY = 0F;
        BalloonFrameRMa.rotateAngleZ = 0F;
        BalloonFrameRMa.renderWithRotation(par7);

        BalloonFrameRT1a.rotateAngleX = 0F;
        BalloonFrameRT1a.rotateAngleY = 0F;
        BalloonFrameRT1a.rotateAngleZ = 0F;
        BalloonFrameRT1a.renderWithRotation(par7);

        BalloonFrameRT1b.rotateAngleX = 0F;
        BalloonFrameRT1b.rotateAngleY = 0F;
        BalloonFrameRT1b.rotateAngleZ = 0F;
        BalloonFrameRT1b.renderWithRotation(par7);

        BalloonFrameRB1a.rotateAngleX = 0F;
        BalloonFrameRB1a.rotateAngleY = 0F;
        BalloonFrameRB1a.rotateAngleZ = 0F;
        BalloonFrameRB1a.renderWithRotation(par7);

        BalloonFrameRB1b.rotateAngleX = 0F;
        BalloonFrameRB1b.rotateAngleY = 0F;
        BalloonFrameRB1b.rotateAngleZ = 0F;
        BalloonFrameRB1b.renderWithRotation(par7);

        BalloonFrameRT2a1.rotateAngleX = 0F;
        BalloonFrameRT2a1.rotateAngleY = 0F;
        BalloonFrameRT2a1.rotateAngleZ = 0F;
        BalloonFrameRT2a1.renderWithRotation(par7);

        BalloonFrameRT2a2.rotateAngleX = 0F;
        BalloonFrameRT2a2.rotateAngleY = 0F;
        BalloonFrameRT2a2.rotateAngleZ = 0F;
        BalloonFrameRT2a2.renderWithRotation(par7);

        BalloonFrameRT2b1.rotateAngleX = 0F;
        BalloonFrameRT2b1.rotateAngleY = 0F;
        BalloonFrameRT2b1.rotateAngleZ = 0F;
        BalloonFrameRT2b1.renderWithRotation(par7);

        BalloonFrameRT2b2.rotateAngleX = 0F;
        BalloonFrameRT2b2.rotateAngleY = 0F;
        BalloonFrameRT2b2.rotateAngleZ = 0F;
        BalloonFrameRT2b2.renderWithRotation(par7);

        BalloonFrameRB2a1.rotateAngleX = 0F;
        BalloonFrameRB2a1.rotateAngleY = 0F;
        BalloonFrameRB2a1.rotateAngleZ = 0F;
        BalloonFrameRB2a1.renderWithRotation(par7);

        BalloonFrameRB2a2.rotateAngleX = 0F;
        BalloonFrameRB2a2.rotateAngleY = 0F;
        BalloonFrameRB2a2.rotateAngleZ = 0F;
        BalloonFrameRB2a2.renderWithRotation(par7);

        BalloonFrameRB2b1.rotateAngleX = 0F;
        BalloonFrameRB2b1.rotateAngleY = 0F;
        BalloonFrameRB2b1.rotateAngleZ = 0F;
        BalloonFrameRB2b1.renderWithRotation(par7);

        BalloonFrameRB2b2.rotateAngleX = 0F;
        BalloonFrameRB2b2.rotateAngleY = 0F;
        BalloonFrameRB2b2.rotateAngleZ = 0F;
        BalloonFrameRB2b2.renderWithRotation(par7);

        AnchorRa.rotateAngleX = 0F;
        AnchorRa.rotateAngleY = 0F;
        AnchorRa.rotateAngleZ = 0F;
        AnchorRa.renderWithRotation(par7);

        JointR1a.rotateAngleX = 0.7853982F;
        JointR1a.rotateAngleY = 0F;
        JointR1a.rotateAngleZ = 0F;
        JointR1a.renderWithRotation(par7);

        JointR1b.rotateAngleX = 0.7853982F;
        JointR1b.rotateAngleY = 0F;
        JointR1b.rotateAngleZ = 0F;
        JointR1b.renderWithRotation(par7);

        BalloonFrameLMa.rotateAngleX = 0F;
        BalloonFrameLMa.rotateAngleY = 0F;
        BalloonFrameLMa.rotateAngleZ = 0F;
        BalloonFrameLMa.renderWithRotation(par7);

        BalloonFrameLT1a.rotateAngleX = 0F;
        BalloonFrameLT1a.rotateAngleY = 0F;
        BalloonFrameLT1a.rotateAngleZ = 0F;
        BalloonFrameLT1a.renderWithRotation(par7);

        BalloonFrameLT1b.rotateAngleX = 0F;
        BalloonFrameLT1b.rotateAngleY = 0F;
        BalloonFrameLT1b.rotateAngleZ = 0F;
        BalloonFrameLT1b.renderWithRotation(par7);

        BalloonFrameLB1a.rotateAngleX = 0F;
        BalloonFrameLB1a.rotateAngleY = 0F;
        BalloonFrameLB1a.rotateAngleZ = 0F;
        BalloonFrameLB1a.renderWithRotation(par7);

        BalloonFrameLB1b.rotateAngleX = 0F;
        BalloonFrameLB1b.rotateAngleY = 0F;
        BalloonFrameLB1b.rotateAngleZ = 0F;
        BalloonFrameLB1b.renderWithRotation(par7);

        BalloonFrameLT2a1.rotateAngleX = 0F;
        BalloonFrameLT2a1.rotateAngleY = 0F;
        BalloonFrameLT2a1.rotateAngleZ = 0F;
        BalloonFrameLT2a1.renderWithRotation(par7);

        BalloonFrameLT2a2.rotateAngleX = 0F;
        BalloonFrameLT2a2.rotateAngleY = 0F;
        BalloonFrameLT2a2.rotateAngleZ = 0F;
        BalloonFrameLT2a2.renderWithRotation(par7);

        BalloonFrameLT2b1.rotateAngleX = 0F;
        BalloonFrameLT2b1.rotateAngleY = 0F;
        BalloonFrameLT2b1.rotateAngleZ = 0F;
        BalloonFrameLT2b1.renderWithRotation(par7);

        BalloonFrameLT2b2.rotateAngleX = 0F;
        BalloonFrameLT2b2.rotateAngleY = 0F;
        BalloonFrameLT2b2.rotateAngleZ = 0F;
        BalloonFrameLT2b2.renderWithRotation(par7);

        BalloonFrameLB2a1.rotateAngleX = 0F;
        BalloonFrameLB2a1.rotateAngleY = 0F;
        BalloonFrameLB2a1.rotateAngleZ = 0F;
        BalloonFrameLB2a1.renderWithRotation(par7);

        BalloonFrameLB2a2.rotateAngleX = 0F;
        BalloonFrameLB2a2.rotateAngleY = 0F;
        BalloonFrameLB2a2.rotateAngleZ = 0F;
        BalloonFrameLB2a2.renderWithRotation(par7);

        BalloonFrameLB2b1.rotateAngleX = 0F;
        BalloonFrameLB2b1.rotateAngleY = 0F;
        BalloonFrameLB2b1.rotateAngleZ = 0F;
        BalloonFrameLB2b1.renderWithRotation(par7);

        BalloonFrameLB2b2.rotateAngleX = 0F;
        BalloonFrameLB2b2.rotateAngleY = 0F;
        BalloonFrameLB2b2.rotateAngleZ = 0F;
        BalloonFrameLB2b2.renderWithRotation(par7);

        AnchorLa.rotateAngleX = 0F;
        AnchorLa.rotateAngleY = 0F;
        AnchorLa.rotateAngleZ = 0F;
        AnchorLa.renderWithRotation(par7);

        JointL1a.rotateAngleX = 0.7853982F;
        JointL1a.rotateAngleY = 0F;
        JointL1a.rotateAngleZ = 0F;
        JointL1a.renderWithRotation(par7);

        JointL1b.rotateAngleX = 0.7853982F;
        JointL1b.rotateAngleY = 0F;
        JointL1b.rotateAngleZ = 0F;
        JointL1b.renderWithRotation(par7);

        BackEngineL.rotateAngleX = 0F;
        BackEngineL.rotateAngleY = 0F;
        BackEngineL.rotateAngleZ = 0F;
        BackEngineL.renderWithRotation(par7);

        BackEngineR.rotateAngleX = 0F;
        BackEngineR.rotateAngleY = 0F;
        BackEngineR.rotateAngleZ = 0F;
        BackEngineR.renderWithRotation(par7);

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

        Engine_R1b.rotateAngleX = 0.7853982F;
        Engine_R1b.rotateAngleY = 0F;
        Engine_R1b.rotateAngleZ = 0F;
        Engine_R1b.renderWithRotation(par7);

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
