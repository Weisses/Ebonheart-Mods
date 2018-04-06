package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonF1 extends ModelBase
{
    //ModelRenderer Floor_Top;
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1b;
    ModelRenderer Anchor_1c;
    ModelRenderer Anchor_1d;
    ModelRenderer Anchor_2a;
    ModelRenderer Anchor_2b;
    ModelRenderer Anchor_2c;
    ModelRenderer Anchor_2d;
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

    public ModelBalloonF1()
    {
        this( 0.0f );
    }

    public ModelBalloonF1( float par1 )
    {
        //Floor_Top = new ModelRenderer( this, 47, 27 );
        //Floor_Top.setTextureSize( 256, 128 );
        //Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        //Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
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
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        //Floor_Top.rotateAngleX = 0F;
        //Floor_Top.rotateAngleY = 0F;
        //Floor_Top.rotateAngleZ = 0F;
        //Floor_Top.renderWithRotation(par7);

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

    }

}
