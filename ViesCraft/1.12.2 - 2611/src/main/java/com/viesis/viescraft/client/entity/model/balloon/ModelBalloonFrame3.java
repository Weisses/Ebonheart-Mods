package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonFrame3 extends ModelBase
{
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1b;
    ModelRenderer Engine_FL2a;
    ModelRenderer Engine_FR2a;
    ModelRenderer Pole1;
    ModelRenderer Pole2;
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

    public ModelBalloonFrame3()
    {
        this( 0.0f );
    }

    public ModelBalloonFrame3( float par1 )
    {
        Anchor_1a = new ModelRenderer( this, 0, 18 );
        Anchor_1a.setTextureSize( 256, 128 );
        Anchor_1a.addBox( 0F, 0F, -1F, 3, 2, 4);
        Anchor_1a.setRotationPoint( 7F, 0F, 7F );
        Anchor_1b = new ModelRenderer( this, 0, 12 );
        Anchor_1b.setTextureSize( 256, 128 );
        Anchor_1b.addBox( 0F, 0F, -1F, 3, 2, 4);
        Anchor_1b.setRotationPoint( -10F, 0F, 7F );
        Engine_FL2a = new ModelRenderer( this, 102, 76 );
        Engine_FL2a.setTextureSize( 256, 128 );
        Engine_FL2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FL2a.setRotationPoint( 15F, -7F, 4F );
        Engine_FR2a = new ModelRenderer( this, 102, 64 );
        Engine_FR2a.setTextureSize( 256, 128 );
        Engine_FR2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FR2a.setRotationPoint( -19F, -7F, 4F );
        Pole1 = new ModelRenderer( this, 2, 0 );
        Pole1.setTextureSize( 256, 128 );
        Pole1.addBox( -0.5F, -9F, -1F, 1, 10, 2);
        Pole1.setRotationPoint( -9F, 0F, 8F );
        Pole2 = new ModelRenderer( this, 2, 0 );
        Pole2.setTextureSize( 256, 128 );
        Pole2.addBox( -0.5F, -9F, -1F, 1, 10, 2);
        Pole2.setRotationPoint( 9F, 0F, 8F );
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
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Anchor_1a.rotateAngleX = 0F;
        Anchor_1a.rotateAngleY = 0F;
        Anchor_1a.rotateAngleZ = 0F;
        Anchor_1a.renderWithRotation(par7);

        Anchor_1b.rotateAngleX = 0F;
        Anchor_1b.rotateAngleY = 0F;
        Anchor_1b.rotateAngleZ = 0F;
        Anchor_1b.renderWithRotation(par7);

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
        Pole1.rotateAngleZ = -0.7853982F;
        Pole1.renderWithRotation(par7);

        Pole2.rotateAngleX = 0F;
        Pole2.rotateAngleY = 0F;
        Pole2.rotateAngleZ = 0.7853982F;
        Pole2.renderWithRotation(par7);

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

    }

}
