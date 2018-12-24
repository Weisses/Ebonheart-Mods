package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent4Primary extends ModelBase
{
    ModelRenderer BalloonFinR1d;
    ModelRenderer BalloonFinR2d;
    ModelRenderer BalloonFinL1a;
    ModelRenderer BalloonFinL1b;
    ModelRenderer BalloonFinL1c;
    ModelRenderer BalloonFinL1d;
    ModelRenderer BalloonFinL2a;
    ModelRenderer BalloonFinL2b;
    ModelRenderer BalloonFinL2c;
    ModelRenderer BalloonFinL2d;
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1b;
    ModelRenderer Anchor_1c;
    ModelRenderer Anchor_1d;
    ModelRenderer Anchor_2a;
    ModelRenderer Anchor_2b;
    ModelRenderer Anchor_2c;
    ModelRenderer Anchor_2d;
    ModelRenderer Rope_1c;
    ModelRenderer Rope_1c1;
    ModelRenderer Engine_R1;
    ModelRenderer Engine_R2a;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_L2a;
    ModelRenderer EnginePipe_L1c;
    ModelRenderer EnginePipe_L1d;
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
    ModelRenderer BalloonFinR1a;
    ModelRenderer BalloonFinR1b;
    ModelRenderer BalloonFinR1c;
    ModelRenderer BalloonFinR2a;
    ModelRenderer BalloonFinR2b;
    ModelRenderer BalloonFinR2c;

    public ModelAirshipComponent4Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent4Primary( float par1 )
    {
        BalloonFinR1d = new ModelRenderer( this, 17, 0 );
        BalloonFinR1d.setTextureSize( 128, 128 );
        BalloonFinR1d.addBox( -2F, -2F, -3F, 2, 3, 6);
        BalloonFinR1d.setRotationPoint( 16F, -33F, 0F );
        BalloonFinR2d = new ModelRenderer( this, 27, 0 );
        BalloonFinR2d.setTextureSize( 128, 128 );
        BalloonFinR2d.addBox( -2F, -2F, -2F, 2, 2, 4);
        BalloonFinR2d.setRotationPoint( 8.5F, -43F, 7F );
        BalloonFinL1a = new ModelRenderer( this, 82, 126 );
        BalloonFinL1a.setTextureSize( 128, 128 );
        BalloonFinL1a.addBox( -21.5F, -0.5F, -0.5F, 22, 1, 1);
        BalloonFinL1a.setRotationPoint( -15F, -33F, 2F );
        BalloonFinL1b = new ModelRenderer( this, 86, 126 );
        BalloonFinL1b.setTextureSize( 128, 128 );
        BalloonFinL1b.addBox( -20F, -0.5F, -0.5F, 20, 1, 1);
        BalloonFinL1b.setRotationPoint( -15F, -33F, 0F );
        BalloonFinL1c = new ModelRenderer( this, 90, 126 );
        BalloonFinL1c.setTextureSize( 128, 128 );
        BalloonFinL1c.addBox( -18F, -0.5F, -0.5F, 18, 1, 1);
        BalloonFinL1c.setRotationPoint( -15F, -33F, -2F );
        BalloonFinL1d = new ModelRenderer( this, 17, 0 );
        BalloonFinL1d.setTextureSize( 128, 128 );
        BalloonFinL1d.addBox( -2F, -2F, -3F, 2, 3, 6);
        BalloonFinL1d.setRotationPoint( -14F, -33F, 0F );
        BalloonFinL2a = new ModelRenderer( this, 110, 126 );
        BalloonFinL2a.setTextureSize( 128, 128 );
        BalloonFinL2a.addBox( -7.5F, -0.5F, -0.5F, 8, 1, 1);
        BalloonFinL2a.setRotationPoint( -8F, -44F, 6F );
        BalloonFinL2b = new ModelRenderer( this, 108, 126 );
        BalloonFinL2b.setTextureSize( 128, 128 );
        BalloonFinL2b.addBox( -8.5F, -0.5F, -0.5F, 9, 1, 1);
        BalloonFinL2b.setRotationPoint( -8F, -44F, 7F );
        BalloonFinL2c = new ModelRenderer( this, 106, 126 );
        BalloonFinL2c.setTextureSize( 128, 128 );
        BalloonFinL2c.addBox( -9.5F, -0.5F, -0.5F, 10, 1, 1);
        BalloonFinL2c.setRotationPoint( -8F, -44F, 8F );
        BalloonFinL2d = new ModelRenderer( this, 27, 0 );
        BalloonFinL2d.setTextureSize( 128, 128 );
        BalloonFinL2d.addBox( -2F, -2F, -2F, 2, 2, 4);
        BalloonFinL2d.setRotationPoint( -6.5F, -43F, 7F );
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
        Anchor_2a = new ModelRenderer( this, 26, 9 );
        Anchor_2a.setTextureSize( 128, 128 );
        Anchor_2a.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2a.setRotationPoint( -14F, -22F, -14F );
        Anchor_2b = new ModelRenderer( this, 26, 9 );
        Anchor_2b.setTextureSize( 128, 128 );
        Anchor_2b.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2b.setRotationPoint( -14F, -22F, 11F );
        Anchor_2c = new ModelRenderer( this, 26, 9 );
        Anchor_2c.setTextureSize( 128, 128 );
        Anchor_2c.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2c.setRotationPoint( 11F, -22F, -14F );
        Anchor_2d = new ModelRenderer( this, 26, 9 );
        Anchor_2d.setTextureSize( 128, 128 );
        Anchor_2d.addBox( 0F, 0F, 0F, 3, 3, 3);
        Anchor_2d.setRotationPoint( 11F, -22F, 11F );
        Rope_1c = new ModelRenderer( this, 40, 4 );
        Rope_1c.setTextureSize( 128, 128 );
        Rope_1c.addBox( 0F, 0F, 0F, 1, 23, 1);
        Rope_1c.setRotationPoint( -13.5F, -21F, 12.5F );
        Rope_1c1 = new ModelRenderer( this, 40, 4 );
        Rope_1c1.setTextureSize( 128, 128 );
        Rope_1c1.addBox( -1F, 0F, 0F, 1, 23, 1);
        Rope_1c1.setRotationPoint( 13.5F, -21F, 12.5F );
        Engine_R1 = new ModelRenderer( this, 0, 54 );
        Engine_R1.setTextureSize( 128, 128 );
        Engine_R1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -19F, -32F, -2F );
        Engine_R2a = new ModelRenderer( this, 0, 66 );
        Engine_R2a.setTextureSize( 128, 128 );
        Engine_R2a.addBox( 0F, -2F, 0F, 4, 6, 8);
        Engine_R2a.setRotationPoint( -22F, -28F, 0F );
        Engine_L1 = new ModelRenderer( this, 20, 54 );
        Engine_L1.setTextureSize( 128, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 15F, -32F, -2F );
        Engine_L2a = new ModelRenderer( this, 24, 66 );
        Engine_L2a.setTextureSize( 128, 128 );
        Engine_L2a.addBox( 0F, 0F, 0F, 4, 6, 8);
        Engine_L2a.setRotationPoint( 18F, -30F, 0F );
        EnginePipe_L1c = new ModelRenderer( this, 40, 4 );
        EnginePipe_L1c.setTextureSize( 128, 128 );
        EnginePipe_L1c.addBox( -0.5F, 0F, -0.5F, 1, 12, 1);
        EnginePipe_L1c.setRotationPoint( 16F, -28.5F, 3F );
        EnginePipe_L1d = new ModelRenderer( this, 40, 4 );
        EnginePipe_L1d.setTextureSize( 128, 128 );
        EnginePipe_L1d.addBox( -0.5F, 0F, -0.5F, 1, 12, 1);
        EnginePipe_L1d.setRotationPoint( -16F, -28.5F, 3F );
        BalloonFrameTL1a1 = new ModelRenderer( this, 64, 96 );
        BalloonFrameTL1a1.setTextureSize( 128, 128 );
        BalloonFrameTL1a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameTL1a1.setRotationPoint( 15F, -44F, -15F );
        BalloonFrameTL1a2 = new ModelRenderer( this, 64, 96 );
        BalloonFrameTL1a2.setTextureSize( 128, 128 );
        BalloonFrameTL1a2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameTL1a2.setRotationPoint( 14F, -43F, -15F );
        BalloonFrameTR1b1 = new ModelRenderer( this, 64, 96 );
        BalloonFrameTR1b1.setTextureSize( 128, 128 );
        BalloonFrameTR1b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameTR1b1.setRotationPoint( -15F, -44F, -15F );
        BalloonFrameTR1b2 = new ModelRenderer( this, 64, 96 );
        BalloonFrameTR1b2.setTextureSize( 128, 128 );
        BalloonFrameTR1b2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameTR1b2.setRotationPoint( -14F, -43F, -15F );
        BalloonFrameBL1a1 = new ModelRenderer( this, 64, 96 );
        BalloonFrameBL1a1.setTextureSize( 128, 128 );
        BalloonFrameBL1a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameBL1a1.setRotationPoint( 15F, -20F, -15F );
        BalloonFrameBL1a2 = new ModelRenderer( this, 64, 96 );
        BalloonFrameBL1a2.setTextureSize( 128, 128 );
        BalloonFrameBL1a2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameBL1a2.setRotationPoint( 14F, -21F, -15F );
        BalloonFrameBR1b1 = new ModelRenderer( this, 64, 96 );
        BalloonFrameBR1b1.setTextureSize( 128, 128 );
        BalloonFrameBR1b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameBR1b1.setRotationPoint( -15F, -20F, -15F );
        BalloonFrameBR1b2 = new ModelRenderer( this, 64, 96 );
        BalloonFrameBR1b2.setTextureSize( 128, 128 );
        BalloonFrameBR1b2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 31);
        BalloonFrameBR1b2.setRotationPoint( -14F, -21F, -15F );
        BalloonFrameTL2a1 = new ModelRenderer( this, 52, 90 );
        BalloonFrameTL2a1.setTextureSize( 128, 128 );
        BalloonFrameTL2a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 37);
        BalloonFrameTL2a1.setRotationPoint( 13F, -43F, -18F );
        BalloonFrameTR2b1 = new ModelRenderer( this, 52, 90 );
        BalloonFrameTR2b1.setTextureSize( 128, 128 );
        BalloonFrameTR2b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 37);
        BalloonFrameTR2b1.setRotationPoint( -13F, -43F, -18.04F );
        BalloonFrameBL2a1 = new ModelRenderer( this, 52, 90 );
        BalloonFrameBL2a1.setTextureSize( 128, 128 );
        BalloonFrameBL2a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 37);
        BalloonFrameBL2a1.setRotationPoint( 13F, -21F, -18F );
        BalloonFrameBR2b1 = new ModelRenderer( this, 52, 90 );
        BalloonFrameBR2b1.setTextureSize( 128, 128 );
        BalloonFrameBR2b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 37);
        BalloonFrameBR2b1.setRotationPoint( -13F, -21F, -18F );
        BalloonFrameTL3a1 = new ModelRenderer( this, 44, 86 );
        BalloonFrameTL3a1.setTextureSize( 128, 128 );
        BalloonFrameTL3a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 41);
        BalloonFrameTL3a1.setRotationPoint( 12F, -42F, -20F );
        BalloonFrameTR3b1 = new ModelRenderer( this, 44, 86 );
        BalloonFrameTR3b1.setTextureSize( 128, 128 );
        BalloonFrameTR3b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 41);
        BalloonFrameTR3b1.setRotationPoint( -12F, -42F, -20F );
        BalloonFrameBL3a1 = new ModelRenderer( this, 44, 86 );
        BalloonFrameBL3a1.setTextureSize( 128, 128 );
        BalloonFrameBL3a1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 41);
        BalloonFrameBL3a1.setRotationPoint( 12F, -22F, -20F );
        BalloonFrameBR3b1 = new ModelRenderer( this, 44, 86 );
        BalloonFrameBR3b1.setTextureSize( 128, 128 );
        BalloonFrameBR3b1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 41);
        BalloonFrameBR3b1.setRotationPoint( -12F, -22F, -20F );
        BalloonFrameFa = new ModelRenderer( this, 124, 111 );
        BalloonFrameFa.setTextureSize( 128, 128 );
        BalloonFrameFa.addBox( -0.5F, -0.5F, -0.7F, 1, 16, 1);
        BalloonFrameFa.setRotationPoint( 0F, -32F, -20F );
        BalloonFrameFb = new ModelRenderer( this, 124, 111 );
        BalloonFrameFb.setTextureSize( 128, 128 );
        BalloonFrameFb.addBox( -0.5F, -15.5F, -0.7F, 1, 16, 1);
        BalloonFrameFb.setRotationPoint( 0F, -32F, -20F );
        BalloonFrameFc = new ModelRenderer( this, 124, 111 );
        BalloonFrameFc.setTextureSize( 128, 128 );
        BalloonFrameFc.addBox( -0.5F, -0.5F, -0.7F, 1, 16, 1);
        BalloonFrameFc.setRotationPoint( 0F, -32F, -20F );
        BalloonFrameFd = new ModelRenderer( this, 124, 111 );
        BalloonFrameFd.setTextureSize( 128, 128 );
        BalloonFrameFd.addBox( -0.5F, -15.5F, -0.7F, 1, 16, 1);
        BalloonFrameFd.setRotationPoint( 0F, -32F, -20F );
        BalloonFrameBa = new ModelRenderer( this, 124, 111 );
        BalloonFrameBa.setTextureSize( 128, 128 );
        BalloonFrameBa.addBox( -0.5F, -0.5F, -1.3F, 1, 16, 1);
        BalloonFrameBa.setRotationPoint( 0F, -32F, 21F );
        BalloonFrameBb = new ModelRenderer( this, 124, 111 );
        BalloonFrameBb.setTextureSize( 128, 128 );
        BalloonFrameBb.addBox( -0.5F, -15.5F, -1.3F, 1, 16, 1);
        BalloonFrameBb.setRotationPoint( 0F, -32F, 21F );
        BalloonFrameBc = new ModelRenderer( this, 124, 111 );
        BalloonFrameBc.setTextureSize( 128, 128 );
        BalloonFrameBc.addBox( -0.5F, -0.5F, -1.3F, 1, 16, 1);
        BalloonFrameBc.setRotationPoint( 0F, -32F, 21F );
        BalloonFrameBd = new ModelRenderer( this, 124, 111 );
        BalloonFrameBd.setTextureSize( 128, 128 );
        BalloonFrameBd.addBox( -0.5F, -15.5F, -1.3F, 1, 16, 1);
        BalloonFrameBd.setRotationPoint( 0F, -32F, 21F );
        BalloonFrameFM = new ModelRenderer( this, 112, 30 );
        BalloonFrameFM.setTextureSize( 128, 128 );
        BalloonFrameFM.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameFM.setRotationPoint( 0F, -32F, -20F );
        BalloonFrameBM = new ModelRenderer( this, 112, 30 );
        BalloonFrameBM.setTextureSize( 128, 128 );
        BalloonFrameBM.addBox( -3F, -3F, -1F, 6, 6, 2);
        BalloonFrameBM.setRotationPoint( 0F, -32F, 20F );
        BalloonFinR1a = new ModelRenderer( this, 82, 126 );
        BalloonFinR1a.setTextureSize( 128, 128 );
        BalloonFinR1a.addBox( -0.5F, -0.5F, -0.5F, 22, 1, 1);
        BalloonFinR1a.setRotationPoint( 15F, -33F, 2F );
        BalloonFinR1b = new ModelRenderer( this, 86, 126 );
        BalloonFinR1b.setTextureSize( 128, 128 );
        BalloonFinR1b.addBox( 0F, -0.5F, -0.5F, 20, 1, 1);
        BalloonFinR1b.setRotationPoint( 15F, -33F, 0F );
        BalloonFinR1c = new ModelRenderer( this, 67, 126 );
        BalloonFinR1c.setTextureSize( 128, 128 );
        BalloonFinR1c.addBox( 0F, -0.5F, -0.5F, 18, 1, 1);
        BalloonFinR1c.setRotationPoint( 15F, -33F, -2F );
        BalloonFinR2a = new ModelRenderer( this, 110, 126 );
        BalloonFinR2a.setTextureSize( 128, 128 );
        BalloonFinR2a.addBox( -0.5F, -0.5F, -0.5F, 8, 1, 1);
        BalloonFinR2a.setRotationPoint( 8F, -44F, 6F );
        BalloonFinR2b = new ModelRenderer( this, 108, 126 );
        BalloonFinR2b.setTextureSize( 128, 128 );
        BalloonFinR2b.addBox( -0.5F, -0.5F, -0.5F, 9, 1, 1);
        BalloonFinR2b.setRotationPoint( 8F, -44F, 7F );
        BalloonFinR2c = new ModelRenderer( this, 106, 126 );
        BalloonFinR2c.setTextureSize( 128, 128 );
        BalloonFinR2c.addBox( -0.5F, -0.5F, -0.5F, 10, 1, 1);
        BalloonFinR2c.setRotationPoint( 8F, -44F, 8F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        BalloonFinR1d.rotateAngleX = 0F;
        BalloonFinR1d.rotateAngleY = 0F;
        BalloonFinR1d.rotateAngleZ = 0F;
        BalloonFinR1d.renderWithRotation(par7);

        BalloonFinR2d.rotateAngleX = 0F;
        BalloonFinR2d.rotateAngleY = 0F;
        BalloonFinR2d.rotateAngleZ = 0F;
        BalloonFinR2d.renderWithRotation(par7);

        BalloonFinL1a.rotateAngleX = -0.3537134F;
        BalloonFinL1a.rotateAngleY = 0.3781936F;
        BalloonFinL1a.rotateAngleZ = 0.7170152F;
        BalloonFinL1a.renderWithRotation(par7);

        BalloonFinL1b.rotateAngleX = 0F;
        BalloonFinL1b.rotateAngleY = 0F;
        BalloonFinL1b.rotateAngleZ = 0.7853982F;
        BalloonFinL1b.renderWithRotation(par7);

        BalloonFinL1c.rotateAngleX = 0.350055F;
        BalloonFinL1c.rotateAngleY = -0.3737303F;
        BalloonFinL1c.rotateAngleZ = 0.7185537F;
        BalloonFinL1c.renderWithRotation(par7);

        BalloonFinL1d.rotateAngleX = 0F;
        BalloonFinL1d.rotateAngleY = 0F;
        BalloonFinL1d.rotateAngleZ = 0F;
        BalloonFinL1d.renderWithRotation(par7);

        BalloonFinL2a.rotateAngleX = 0.4037271F;
        BalloonFinL2a.rotateAngleY = -0.4413864F;
        BalloonFinL2a.rotateAngleZ = 0.6936369F;
        BalloonFinL2a.renderWithRotation(par7);

        BalloonFinL2b.rotateAngleX = 0F;
        BalloonFinL2b.rotateAngleY = 0F;
        BalloonFinL2b.rotateAngleZ = 0.7853982F;
        BalloonFinL2b.renderWithRotation(par7);

        BalloonFinL2c.rotateAngleX = -0.4612685F;
        BalloonFinL2c.rotateAngleY = 0.5201722F;
        BalloonFinL2c.rotateAngleZ = 0.6605868F;
        BalloonFinL2c.renderWithRotation(par7);

        BalloonFinL2d.rotateAngleX = 0F;
        BalloonFinL2d.rotateAngleY = 0F;
        BalloonFinL2d.rotateAngleZ = 0F;
        BalloonFinL2d.renderWithRotation(par7);

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

        Rope_1c.rotateAngleX = -0.1876229F;
        Rope_1c.rotateAngleY = 1.794455E-09F;
        Rope_1c.rotateAngleZ = -0.2094395F;
        Rope_1c.renderWithRotation(par7);

        Rope_1c1.rotateAngleX = -0.1876229F;
        Rope_1c1.rotateAngleY = -1.794455E-09F;
        Rope_1c1.rotateAngleZ = 0.2094395F;
        Rope_1c1.renderWithRotation(par7);

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

        EnginePipe_L1c.rotateAngleX = 0.8726647F;
        EnginePipe_L1c.rotateAngleY = -1.407323E-12F;
        EnginePipe_L1c.rotateAngleZ = 0.2094395F;
        EnginePipe_L1c.renderWithRotation(par7);

        EnginePipe_L1d.rotateAngleX = 0.8726647F;
        EnginePipe_L1d.rotateAngleY = 1.407323E-12F;
        EnginePipe_L1d.rotateAngleZ = -0.2094395F;
        EnginePipe_L1d.renderWithRotation(par7);

        BalloonFrameTL1a1.rotateAngleX = 0F;
        BalloonFrameTL1a1.rotateAngleY = 0F;
        BalloonFrameTL1a1.rotateAngleZ = 0F;
        BalloonFrameTL1a1.renderWithRotation(par7);

        BalloonFrameTL1a2.rotateAngleX = 0F;
        BalloonFrameTL1a2.rotateAngleY = 0F;
        BalloonFrameTL1a2.rotateAngleZ = 0F;
        BalloonFrameTL1a2.renderWithRotation(par7);

        BalloonFrameTR1b1.rotateAngleX = 0F;
        BalloonFrameTR1b1.rotateAngleY = 0F;
        BalloonFrameTR1b1.rotateAngleZ = 0F;
        BalloonFrameTR1b1.renderWithRotation(par7);

        BalloonFrameTR1b2.rotateAngleX = 0F;
        BalloonFrameTR1b2.rotateAngleY = 0F;
        BalloonFrameTR1b2.rotateAngleZ = 0F;
        BalloonFrameTR1b2.renderWithRotation(par7);

        BalloonFrameBL1a1.rotateAngleX = 0F;
        BalloonFrameBL1a1.rotateAngleY = 0F;
        BalloonFrameBL1a1.rotateAngleZ = 0F;
        BalloonFrameBL1a1.renderWithRotation(par7);

        BalloonFrameBL1a2.rotateAngleX = 0F;
        BalloonFrameBL1a2.rotateAngleY = 0F;
        BalloonFrameBL1a2.rotateAngleZ = 0F;
        BalloonFrameBL1a2.renderWithRotation(par7);

        BalloonFrameBR1b1.rotateAngleX = 0F;
        BalloonFrameBR1b1.rotateAngleY = 0F;
        BalloonFrameBR1b1.rotateAngleZ = 0F;
        BalloonFrameBR1b1.renderWithRotation(par7);

        BalloonFrameBR1b2.rotateAngleX = 0F;
        BalloonFrameBR1b2.rotateAngleY = 0F;
        BalloonFrameBR1b2.rotateAngleZ = 0F;
        BalloonFrameBR1b2.renderWithRotation(par7);

        BalloonFrameTL2a1.rotateAngleX = 0F;
        BalloonFrameTL2a1.rotateAngleY = 0F;
        BalloonFrameTL2a1.rotateAngleZ = 0F;
        BalloonFrameTL2a1.renderWithRotation(par7);

        BalloonFrameTR2b1.rotateAngleX = 0F;
        BalloonFrameTR2b1.rotateAngleY = 0F;
        BalloonFrameTR2b1.rotateAngleZ = 0F;
        BalloonFrameTR2b1.renderWithRotation(par7);

        BalloonFrameBL2a1.rotateAngleX = 0F;
        BalloonFrameBL2a1.rotateAngleY = 0F;
        BalloonFrameBL2a1.rotateAngleZ = 0F;
        BalloonFrameBL2a1.renderWithRotation(par7);

        BalloonFrameBR2b1.rotateAngleX = 0F;
        BalloonFrameBR2b1.rotateAngleY = 0F;
        BalloonFrameBR2b1.rotateAngleZ = 0F;
        BalloonFrameBR2b1.renderWithRotation(par7);

        BalloonFrameTL3a1.rotateAngleX = 0F;
        BalloonFrameTL3a1.rotateAngleY = 0F;
        BalloonFrameTL3a1.rotateAngleZ = 0F;
        BalloonFrameTL3a1.renderWithRotation(par7);

        BalloonFrameTR3b1.rotateAngleX = 0F;
        BalloonFrameTR3b1.rotateAngleY = 0F;
        BalloonFrameTR3b1.rotateAngleZ = 0F;
        BalloonFrameTR3b1.renderWithRotation(par7);

        BalloonFrameBL3a1.rotateAngleX = 0F;
        BalloonFrameBL3a1.rotateAngleY = 0F;
        BalloonFrameBL3a1.rotateAngleZ = 0F;
        BalloonFrameBL3a1.renderWithRotation(par7);

        BalloonFrameBR3b1.rotateAngleX = 0F;
        BalloonFrameBR3b1.rotateAngleY = 0F;
        BalloonFrameBR3b1.rotateAngleZ = 0F;
        BalloonFrameBR3b1.renderWithRotation(par7);

        BalloonFrameFa.rotateAngleX = 0F;
        BalloonFrameFa.rotateAngleY = 0F;
        BalloonFrameFa.rotateAngleZ = 0.8726646F;
        BalloonFrameFa.renderWithRotation(par7);

        BalloonFrameFb.rotateAngleX = 0F;
        BalloonFrameFb.rotateAngleY = 0F;
        BalloonFrameFb.rotateAngleZ = -0.8726646F;
        BalloonFrameFb.renderWithRotation(par7);

        BalloonFrameFc.rotateAngleX = 0F;
        BalloonFrameFc.rotateAngleY = 0F;
        BalloonFrameFc.rotateAngleZ = -0.8726646F;
        BalloonFrameFc.renderWithRotation(par7);

        BalloonFrameFd.rotateAngleX = 0F;
        BalloonFrameFd.rotateAngleY = 0F;
        BalloonFrameFd.rotateAngleZ = 0.8726646F;
        BalloonFrameFd.renderWithRotation(par7);

        BalloonFrameBa.rotateAngleX = 0F;
        BalloonFrameBa.rotateAngleY = 0F;
        BalloonFrameBa.rotateAngleZ = 0.8726646F;
        BalloonFrameBa.renderWithRotation(par7);

        BalloonFrameBb.rotateAngleX = 0F;
        BalloonFrameBb.rotateAngleY = 0F;
        BalloonFrameBb.rotateAngleZ = -0.8726646F;
        BalloonFrameBb.renderWithRotation(par7);

        BalloonFrameBc.rotateAngleX = 0F;
        BalloonFrameBc.rotateAngleY = 0F;
        BalloonFrameBc.rotateAngleZ = -0.8726646F;
        BalloonFrameBc.renderWithRotation(par7);

        BalloonFrameBd.rotateAngleX = 0F;
        BalloonFrameBd.rotateAngleY = 0F;
        BalloonFrameBd.rotateAngleZ = 0.8726646F;
        BalloonFrameBd.renderWithRotation(par7);

        BalloonFrameFM.rotateAngleX = 0F;
        BalloonFrameFM.rotateAngleY = 0F;
        BalloonFrameFM.rotateAngleZ = 0F;
        BalloonFrameFM.renderWithRotation(par7);

        BalloonFrameBM.rotateAngleX = 0F;
        BalloonFrameBM.rotateAngleY = 0F;
        BalloonFrameBM.rotateAngleZ = 0F;
        BalloonFrameBM.renderWithRotation(par7);

        BalloonFinR1a.rotateAngleX = -0.3537134F;
        BalloonFinR1a.rotateAngleY = -0.3781936F;
        BalloonFinR1a.rotateAngleZ = -0.7170152F;
        BalloonFinR1a.renderWithRotation(par7);

        BalloonFinR1b.rotateAngleX = 0F;
        BalloonFinR1b.rotateAngleY = 0F;
        BalloonFinR1b.rotateAngleZ = -0.7853982F;
        BalloonFinR1b.renderWithRotation(par7);

        BalloonFinR1c.rotateAngleX = 0.350055F;
        BalloonFinR1c.rotateAngleY = 0.3737303F;
        BalloonFinR1c.rotateAngleZ = -0.7185537F;
        BalloonFinR1c.renderWithRotation(par7);

        BalloonFinR2a.rotateAngleX = 0.4037271F;
        BalloonFinR2a.rotateAngleY = 0.4413864F;
        BalloonFinR2a.rotateAngleZ = -0.6936369F;
        BalloonFinR2a.renderWithRotation(par7);

        BalloonFinR2b.rotateAngleX = 0F;
        BalloonFinR2b.rotateAngleY = 0F;
        BalloonFinR2b.rotateAngleZ = -0.7853982F;
        BalloonFinR2b.renderWithRotation(par7);

        BalloonFinR2c.rotateAngleX = -0.4612685F;
        BalloonFinR2c.rotateAngleY = -0.5201722F;
        BalloonFinR2c.rotateAngleZ = -0.6605868F;
        BalloonFinR2c.renderWithRotation(par7);

    }

}
