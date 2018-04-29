package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonFrame0 extends ModelBase
{
    ModelRenderer Anchor_1R;
    ModelRenderer BalloonFrameTR3a;
    ModelRenderer BalloonFrameTR3b;
    ModelRenderer BalloonFrameTR4a;
    ModelRenderer BalloonFrameTR4b;
    ModelRenderer BalloonFrameBR3a;
    ModelRenderer BalloonFrameBR3b;
    ModelRenderer BalloonFrameBR4a;
    ModelRenderer BalloonFrameBR4b;
    ModelRenderer Anchor_1L;
    ModelRenderer BalloonFrameTL3a;
    ModelRenderer BalloonFrameTL3b;
    ModelRenderer BalloonFrameTL4a;
    ModelRenderer BalloonFrameTL4b;
    ModelRenderer BalloonFrameBL3a;
    ModelRenderer BalloonFrameBL3b;
    ModelRenderer BalloonFrameBL4a;
    ModelRenderer BalloonFrameBL4b;

    public ModelBalloonFrame0()
    {
        this( 0.0f );
    }

    public ModelBalloonFrame0( float par1 )
    {
        Anchor_1R = new ModelRenderer( this, 9, 0 );
        Anchor_1R.setTextureSize( 128, 128 );
        Anchor_1R.addBox( 0F, 0F, -1F, 3, 2, 4);
        Anchor_1R.setRotationPoint( -10F, 0F, -1F );
        BalloonFrameTR3a = new ModelRenderer( this, 92, 110 );
        BalloonFrameTR3a.setTextureSize( 128, 128 );
        BalloonFrameTR3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR3a.setRotationPoint( -10F, -4F, -8F );
        BalloonFrameTR3b = new ModelRenderer( this, 92, 110 );
        BalloonFrameTR3b.setTextureSize( 128, 128 );
        BalloonFrameTR3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTR3b.setRotationPoint( -16F, -4F, -8F );
        BalloonFrameTR4a = new ModelRenderer( this, 88, 108 );
        BalloonFrameTR4a.setTextureSize( 128, 128 );
        BalloonFrameTR4a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTR4a.setRotationPoint( -11F, -3F, -8F );
        BalloonFrameTR4b = new ModelRenderer( this, 88, 108 );
        BalloonFrameTR4b.setTextureSize( 128, 128 );
        BalloonFrameTR4b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTR4b.setRotationPoint( -15F, -3F, -8F );
        BalloonFrameBR3a = new ModelRenderer( this, 92, 110 );
        BalloonFrameBR3a.setTextureSize( 128, 128 );
        BalloonFrameBR3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR3a.setRotationPoint( -10F, 2F, -8F );
        BalloonFrameBR3b = new ModelRenderer( this, 92, 110 );
        BalloonFrameBR3b.setTextureSize( 128, 128 );
        BalloonFrameBR3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBR3b.setRotationPoint( -16F, 2F, -8F );
        BalloonFrameBR4a = new ModelRenderer( this, 88, 108 );
        BalloonFrameBR4a.setTextureSize( 128, 128 );
        BalloonFrameBR4a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBR4a.setRotationPoint( -11F, 1F, -8F );
        BalloonFrameBR4b = new ModelRenderer( this, 88, 108 );
        BalloonFrameBR4b.setTextureSize( 128, 128 );
        BalloonFrameBR4b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBR4b.setRotationPoint( -15F, 1F, -8F );
        Anchor_1L = new ModelRenderer( this, 9, 0 );
        Anchor_1L.setTextureSize( 128, 128 );
        Anchor_1L.addBox( -3F, 0F, -1F, 3, 2, 4);
        Anchor_1L.setRotationPoint( 10F, 0F, -1F );
        BalloonFrameTL3a = new ModelRenderer( this, 92, 110 );
        BalloonFrameTL3a.setTextureSize( 128, 128 );
        BalloonFrameTL3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL3a.setRotationPoint( 10F, -4F, -8F );
        BalloonFrameTL3b = new ModelRenderer( this, 92, 110 );
        BalloonFrameTL3b.setTextureSize( 128, 128 );
        BalloonFrameTL3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameTL3b.setRotationPoint( 16F, -4F, -8F );
        BalloonFrameTL4a = new ModelRenderer( this, 88, 108 );
        BalloonFrameTL4a.setTextureSize( 128, 128 );
        BalloonFrameTL4a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTL4a.setRotationPoint( 11F, -3F, -8F );
        BalloonFrameTL4b = new ModelRenderer( this, 88, 108 );
        BalloonFrameTL4b.setTextureSize( 128, 128 );
        BalloonFrameTL4b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTL4b.setRotationPoint( 15F, -3F, -8F );
        BalloonFrameBL3a = new ModelRenderer( this, 92, 110 );
        BalloonFrameBL3a.setTextureSize( 128, 128 );
        BalloonFrameBL3a.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL3a.setRotationPoint( 10F, 2F, -8F );
        BalloonFrameBL3b = new ModelRenderer( this, 92, 110 );
        BalloonFrameBL3b.setTextureSize( 128, 128 );
        BalloonFrameBL3b.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 17);
        BalloonFrameBL3b.setRotationPoint( 16F, 2F, -8F );
        BalloonFrameBL4a = new ModelRenderer( this, 88, 108 );
        BalloonFrameBL4a.setTextureSize( 128, 128 );
        BalloonFrameBL4a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBL4a.setRotationPoint( 11F, 1F, -8F );
        BalloonFrameBL4b = new ModelRenderer( this, 88, 108 );
        BalloonFrameBL4b.setTextureSize( 128, 128 );
        BalloonFrameBL4b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBL4b.setRotationPoint( 15F, 1F, -8F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Anchor_1R.rotateAngleX = 0F;
        Anchor_1R.rotateAngleY = 0F;
        Anchor_1R.rotateAngleZ = 0F;
        Anchor_1R.renderWithRotation(par7);

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

        Anchor_1L.rotateAngleX = 0F;
        Anchor_1L.rotateAngleY = 0F;
        Anchor_1L.rotateAngleZ = 0F;
        Anchor_1L.renderWithRotation(par7);

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

    }

}
