package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonFrame1 extends ModelBase
{
    ModelRenderer Anchor_2a;
    ModelRenderer Anchor_2b;
    ModelRenderer Anchor_2c;
    ModelRenderer Anchor_2d;
    ModelRenderer BalloonFrameRT1;
    ModelRenderer BalloonFrameRB1;
    ModelRenderer BalloonFrameLT1;
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
    ModelRenderer BalloonFrameB3a;
    ModelRenderer BalloonFrameB3b;
    ModelRenderer BalloonFrameB3c;
    ModelRenderer BalloonFrameB3d;
    ModelRenderer BalloonFrameLM1a;
    ModelRenderer BalloonFrameRM1a;
    ModelRenderer BalloonFrameFrontDial;
    ModelRenderer BalloonFrameBackDial;
    ModelRenderer Anchor_2a1;
    ModelRenderer Anchor_2b1;
    ModelRenderer Anchor_2c1;
    ModelRenderer Anchor_2d1;
    ModelRenderer Engine_R1;
    ModelRenderer Engine_R2a;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_L2a;
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1b;
    ModelRenderer Anchor_1c;
    ModelRenderer Anchor_1d;

    public ModelBalloonFrame1()
    {
        this( 0.0f );
    }

    public ModelBalloonFrame1( float par1 )
    {
        Anchor_2a = new ModelRenderer( this, 0, 4 );
        Anchor_2a.setTextureSize( 128, 128 );
        Anchor_2a.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2a.setRotationPoint( -14F, -22F, -14F );
        Anchor_2b = new ModelRenderer( this, 0, 4 );
        Anchor_2b.setTextureSize( 128, 128 );
        Anchor_2b.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2b.setRotationPoint( -14F, -22F, 11F );
        Anchor_2c = new ModelRenderer( this, 0, 4 );
        Anchor_2c.setTextureSize( 128, 128 );
        Anchor_2c.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2c.setRotationPoint( 11F, -22F, -14F );
        Anchor_2d = new ModelRenderer( this, 0, 4 );
        Anchor_2d.setTextureSize( 128, 128 );
        Anchor_2d.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2d.setRotationPoint( 11F, -22F, 11F );
        BalloonFrameRT1 = new ModelRenderer( this, 60, 94 );
        BalloonFrameRT1.setTextureSize( 128, 128 );
        BalloonFrameRT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameRT1.setRotationPoint( -16.5F, -52.5F, -16.5F );
        BalloonFrameRB1 = new ModelRenderer( this, 60, 94 );
        BalloonFrameRB1.setTextureSize( 128, 128 );
        BalloonFrameRB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameRB1.setRotationPoint( -16.5F, -20.5F, -16.5F );
        BalloonFrameLT1 = new ModelRenderer( this, 60, 94 );
        BalloonFrameLT1.setTextureSize( 128, 128 );
        BalloonFrameLT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameLT1.setRotationPoint( 15.5F, -52.5F, -16.5F );
        BalloonFrameLB1 = new ModelRenderer( this, 60, 94 );
        BalloonFrameLB1.setTextureSize( 128, 128 );
        BalloonFrameLB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameLB1.setRotationPoint( 15.5F, -20.5F, -16.5F );
        BalloonFrameMT1 = new ModelRenderer( this, 60, 94 );
        BalloonFrameMT1.setTextureSize( 128, 128 );
        BalloonFrameMT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameMT1.setRotationPoint( -0.5F, -52.5F, -16.5F );
        BalloonFrameRT2a = new ModelRenderer( this, 48, 88 );
        BalloonFrameRT2a.setTextureSize( 128, 128 );
        BalloonFrameRT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRT2a.setRotationPoint( -15.5F, -51.5F, -19.5F );
        BalloonFrameRT2b = new ModelRenderer( this, 48, 88 );
        BalloonFrameRT2b.setTextureSize( 128, 128 );
        BalloonFrameRT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRT2b.setRotationPoint( -14.5F, -50.5F, -19.5F );
        BalloonFrameMT2 = new ModelRenderer( this, 48, 87 );
        BalloonFrameMT2.setTextureSize( 128, 128 );
        BalloonFrameMT2.addBox( 0F, 0F, 0F, 1, 2, 39);
        BalloonFrameMT2.setRotationPoint( -0.5F, -51.5F, -19.5F );
        BalloonFrameLT2a = new ModelRenderer( this, 48, 88 );
        BalloonFrameLT2a.setTextureSize( 128, 128 );
        BalloonFrameLT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLT2a.setRotationPoint( 14.5F, -51.5F, -19.5F );
        BalloonFrameLT2b = new ModelRenderer( this, 48, 88 );
        BalloonFrameLT2b.setTextureSize( 128, 128 );
        BalloonFrameLT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLT2b.setRotationPoint( 13.5F, -50.5F, -19.5F );
        BalloonFrameRM2 = new ModelRenderer( this, 46, 88 );
        BalloonFrameRM2.setTextureSize( 128, 128 );
        BalloonFrameRM2.addBox( 0F, 0F, -1F, 2, 1, 39);
        BalloonFrameRM2.setRotationPoint( -15.5F, -36.5F, -18.5F );
        BalloonFrameLM2 = new ModelRenderer( this, 46, 88 );
        BalloonFrameLM2.setTextureSize( 128, 128 );
        BalloonFrameLM2.addBox( 0F, 0F, 0F, 2, 1, 39);
        BalloonFrameLM2.setRotationPoint( 13.5F, -36.5F, -19.5F );
        BalloonFrameRB2a = new ModelRenderer( this, 48, 88 );
        BalloonFrameRB2a.setTextureSize( 128, 128 );
        BalloonFrameRB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRB2a.setRotationPoint( -15.5F, -21.5F, -19.5F );
        BalloonFrameRB2b = new ModelRenderer( this, 48, 88 );
        BalloonFrameRB2b.setTextureSize( 128, 128 );
        BalloonFrameRB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameRB2b.setRotationPoint( -14.5F, -22.5F, -19.5F );
        BalloonFrameLB2a = new ModelRenderer( this, 48, 88 );
        BalloonFrameLB2a.setTextureSize( 128, 128 );
        BalloonFrameLB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLB2a.setRotationPoint( 14.5F, -21.5F, -19.5F );
        BalloonFrameLB2b = new ModelRenderer( this, 48, 88 );
        BalloonFrameLB2b.setTextureSize( 128, 128 );
        BalloonFrameLB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        BalloonFrameLB2b.setRotationPoint( 13.5F, -22.5F, -19.5F );
        BalloonFrameRT3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameRT3.setTextureSize( 128, 128 );
        BalloonFrameRT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRT3.setRotationPoint( -13.5F, -49.5F, -22.5F );
        BalloonFrameMT3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameMT3.setTextureSize( 128, 128 );
        BalloonFrameMT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameMT3.setRotationPoint( -0.5F, -49.5F, -22.5F );
        BalloonFrameLT3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameLT3.setTextureSize( 128, 128 );
        BalloonFrameLT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLT3.setRotationPoint( 12.5F, -49.5F, -22.5F );
        BalloonFrameRM3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameRM3.setTextureSize( 128, 128 );
        BalloonFrameRM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRM3.setRotationPoint( -13.5F, -36.5F, -22.5F );
        BalloonFrameLM3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameLM3.setTextureSize( 128, 128 );
        BalloonFrameLM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLM3.setRotationPoint( 12.5F, -36.5F, -22.5F );
        BalloonFrameRB3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameRB3.setTextureSize( 128, 128 );
        BalloonFrameRB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameRB3.setRotationPoint( -13.5F, -23.5F, -22.5F );
        BalloonFrameLB3 = new ModelRenderer( this, 36, 82 );
        BalloonFrameLB3.setTextureSize( 128, 128 );
        BalloonFrameLB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        BalloonFrameLB3.setRotationPoint( 12.5F, -23.5F, -22.5F );
        BalloonFrameF3a = new ModelRenderer( this, 124, 114 );
        BalloonFrameF3a.setTextureSize( 128, 128 );
        BalloonFrameF3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        BalloonFrameF3a.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3b = new ModelRenderer( this, 76, 126 );
        BalloonFrameF3b.setTextureSize( 128, 128 );
        BalloonFrameF3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        BalloonFrameF3b.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3c = new ModelRenderer( this, 124, 90 );
        BalloonFrameF3c.setTextureSize( 128, 128 );
        BalloonFrameF3c.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        BalloonFrameF3c.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameF3d = new ModelRenderer( this, 124, 90 );
        BalloonFrameF3d.setTextureSize( 128, 128 );
        BalloonFrameF3d.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        BalloonFrameF3d.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameB3a = new ModelRenderer( this, 124, 114 );
        BalloonFrameB3a.setTextureSize( 128, 128 );
        BalloonFrameB3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        BalloonFrameB3a.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3b = new ModelRenderer( this, 76, 126 );
        BalloonFrameB3b.setTextureSize( 128, 128 );
        BalloonFrameB3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        BalloonFrameB3b.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3c = new ModelRenderer( this, 124, 90 );
        BalloonFrameB3c.setTextureSize( 128, 128 );
        BalloonFrameB3c.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        BalloonFrameB3c.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameB3d = new ModelRenderer( this, 124, 90 );
        BalloonFrameB3d.setTextureSize( 128, 128 );
        BalloonFrameB3d.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        BalloonFrameB3d.setRotationPoint( 0F, -36F, 22F );
        BalloonFrameLM1a = new ModelRenderer( this, 60, 94 );
        BalloonFrameLM1a.setTextureSize( 128, 128 );
        BalloonFrameLM1a.addBox( 0F, 0F, 0F, 1, 1, 33);
        BalloonFrameLM1a.setRotationPoint( 15.5F, -36.5F, -16.5F );
        BalloonFrameRM1a = new ModelRenderer( this, 60, 94 );
        BalloonFrameRM1a.setTextureSize( 128, 128 );
        BalloonFrameRM1a.addBox( -1F, 0F, 0F, 1, 1, 33);
        BalloonFrameRM1a.setRotationPoint( -15.5F, -36.5F, -16.5F );
        BalloonFrameFrontDial = new ModelRenderer( this, 112, 0 );
        BalloonFrameFrontDial.setTextureSize( 128, 128 );
        BalloonFrameFrontDial.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameFrontDial.setRotationPoint( 0F, -36F, -22F );
        BalloonFrameBackDial = new ModelRenderer( this, 112, 0 );
        BalloonFrameBackDial.setTextureSize( 128, 128 );
        BalloonFrameBackDial.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameBackDial.setRotationPoint( 0F, -36F, 22F );
        Anchor_2a1 = new ModelRenderer( this, 0, 4 );
        Anchor_2a1.setTextureSize( 128, 128 );
        Anchor_2a1.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2a1.setRotationPoint( -14F, -22F, -14F );
        Anchor_2b1 = new ModelRenderer( this, 0, 4 );
        Anchor_2b1.setTextureSize( 128, 128 );
        Anchor_2b1.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2b1.setRotationPoint( -14F, -22F, 11F );
        Anchor_2c1 = new ModelRenderer( this, 0, 4 );
        Anchor_2c1.setTextureSize( 128, 128 );
        Anchor_2c1.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2c1.setRotationPoint( 11F, -22F, -14F );
        Anchor_2d1 = new ModelRenderer( this, 0, 4 );
        Anchor_2d1.setTextureSize( 128, 128 );
        Anchor_2d1.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2d1.setRotationPoint( 11F, -22F, 11F );
        Engine_R1 = new ModelRenderer( this, 44, 0 );
        Engine_R1.setTextureSize( 128, 128 );
        Engine_R1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -13F, 0F, 0F );
        Engine_R2a = new ModelRenderer( this, 44, 12 );
        Engine_R2a.setTextureSize( 128, 128 );
        Engine_R2a.addBox( 0F, -2F, 0F, 4, 6, 8);
        Engine_R2a.setRotationPoint( -16F, 0F, 2F );
        Engine_L1 = new ModelRenderer( this, 64, 0 );
        Engine_L1.setTextureSize( 128, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 9F, 0F, 0F );
        Engine_L2a = new ModelRenderer( this, 68, 12 );
        Engine_L2a.setTextureSize( 128, 128 );
        Engine_L2a.addBox( 0F, 0F, 0F, 4, 6, 8);
        Engine_L2a.setRotationPoint( 12F, -2F, 2F );
        Anchor_1a = new ModelRenderer( this, 35, 0 );
        Anchor_1a.setTextureSize( 128, 128 );
        Anchor_1a.addBox( -3F, 0F, 0F, 3, 2, 2);
        Anchor_1a.setRotationPoint( 10F, 0F, -10F );
        Anchor_1b = new ModelRenderer( this, 35, 0 );
        Anchor_1b.setTextureSize( 128, 128 );
        Anchor_1b.addBox( 0F, 0F, 0F, 3, 2, 2);
        Anchor_1b.setRotationPoint( -10F, 0F, -10F );
        Anchor_1c = new ModelRenderer( this, 35, 0 );
        Anchor_1c.setTextureSize( 128, 128 );
        Anchor_1c.addBox( 0F, 0F, -2F, 3, 2, 2);
        Anchor_1c.setRotationPoint( -10F, 0F, 10F );
        Anchor_1d = new ModelRenderer( this, 35, 0 );
        Anchor_1d.setTextureSize( 128, 128 );
        Anchor_1d.addBox( -3F, 0F, -2F, 3, 2, 2);
        Anchor_1d.setRotationPoint( 10F, 0F, 10F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
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

        BalloonFrameRB1.rotateAngleX = 0F;
        BalloonFrameRB1.rotateAngleY = 0F;
        BalloonFrameRB1.rotateAngleZ = 0F;
        BalloonFrameRB1.renderWithRotation(par7);

        BalloonFrameLT1.rotateAngleX = 0F;
        BalloonFrameLT1.rotateAngleY = 0F;
        BalloonFrameLT1.rotateAngleZ = 0F;
        BalloonFrameLT1.renderWithRotation(par7);

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

        BalloonFrameLM1a.rotateAngleX = 0F;
        BalloonFrameLM1a.rotateAngleY = 0F;
        BalloonFrameLM1a.rotateAngleZ = 0F;
        BalloonFrameLM1a.renderWithRotation(par7);

        BalloonFrameRM1a.rotateAngleX = 0F;
        BalloonFrameRM1a.rotateAngleY = 0F;
        BalloonFrameRM1a.rotateAngleZ = 0F;
        BalloonFrameRM1a.renderWithRotation(par7);

        BalloonFrameFrontDial.rotateAngleX = 0F;
        BalloonFrameFrontDial.rotateAngleY = 0F;
        BalloonFrameFrontDial.rotateAngleZ = 0F;
        BalloonFrameFrontDial.renderWithRotation(par7);

        BalloonFrameBackDial.rotateAngleX = 0F;
        BalloonFrameBackDial.rotateAngleY = 0F;
        BalloonFrameBackDial.rotateAngleZ = 0F;
        BalloonFrameBackDial.renderWithRotation(par7);

        Anchor_2a1.rotateAngleX = 0F;
        Anchor_2a1.rotateAngleY = 0F;
        Anchor_2a1.rotateAngleZ = 0F;
        Anchor_2a1.renderWithRotation(par7);

        Anchor_2b1.rotateAngleX = 0F;
        Anchor_2b1.rotateAngleY = 0F;
        Anchor_2b1.rotateAngleZ = 0F;
        Anchor_2b1.renderWithRotation(par7);

        Anchor_2c1.rotateAngleX = 0F;
        Anchor_2c1.rotateAngleY = 0F;
        Anchor_2c1.rotateAngleZ = 0F;
        Anchor_2c1.renderWithRotation(par7);

        Anchor_2d1.rotateAngleX = 0F;
        Anchor_2d1.rotateAngleY = 0F;
        Anchor_2d1.rotateAngleZ = 0F;
        Anchor_2d1.renderWithRotation(par7);

        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Engine_R2a.rotateAngleX = 0F;
        Engine_R2a.rotateAngleY = 0F;
        Engine_R2a.rotateAngleZ = 0F;
        Engine_R2a.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_L2a.rotateAngleX = 0F;
        Engine_L2a.rotateAngleY = 0F;
        Engine_L2a.rotateAngleZ = 0F;
        Engine_L2a.renderWithRotation(par7);

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

    }

}
