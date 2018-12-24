package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent0Primary extends ModelBase
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
    ModelRenderer BalloonFrameBRBase;
    ModelRenderer Anchor_1L;
    ModelRenderer BalloonFrameTL3a;
    ModelRenderer BalloonFrameTL3b;
    ModelRenderer BalloonFrameTL4a;
    ModelRenderer BalloonFrameTL4b;
    ModelRenderer BalloonFrameBL3a;
    ModelRenderer BalloonFrameBL3b;
    ModelRenderer BalloonFrameBL4a;
    ModelRenderer BalloonFrameBL4b;
    ModelRenderer BalloonFrameBLBase;

    public ModelAirshipComponent0Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent0Primary( float par1 )
    {
        Anchor_1R = new ModelRenderer( this, 82, 20 );
        Anchor_1R.setTextureSize( 128, 128 );
        Anchor_1R.addBox( 0F, 0F, -1F, 3, 2, 4);
        Anchor_1R.setRotationPoint( -11.6F, -0.1000004F, -1F );
        BalloonFrameTR3a = new ModelRenderer( this, 88, 108 );
        BalloonFrameTR3a.setTextureSize( 128, 128 );
        BalloonFrameTR3a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTR3a.setRotationPoint( -11.6F, -4.1F, -8F );
        BalloonFrameTR3b = new ModelRenderer( this, 86, 107 );
        BalloonFrameTR3b.setTextureSize( 128, 128 );
        BalloonFrameTR3b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTR3b.setRotationPoint( -17.6F, -4.1F, -8F );
        BalloonFrameTR4a = new ModelRenderer( this, 84, 104 );
        BalloonFrameTR4a.setTextureSize( 128, 128 );
        BalloonFrameTR4a.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameTR4a.setRotationPoint( -12.6F, -3.1F, -8F );
        BalloonFrameTR4b = new ModelRenderer( this, 82, 103 );
        BalloonFrameTR4b.setTextureSize( 128, 128 );
        BalloonFrameTR4b.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameTR4b.setRotationPoint( -16.6F, -3.1F, -8F );
        BalloonFrameBR3a = new ModelRenderer( this, 82, 104 );
        BalloonFrameBR3a.setTextureSize( 128, 128 );
        BalloonFrameBR3a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBR3a.setRotationPoint( -11.6F, 1.9F, -8F );
        BalloonFrameBR3b = new ModelRenderer( this, 80, 103 );
        BalloonFrameBR3b.setTextureSize( 128, 128 );
        BalloonFrameBR3b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBR3b.setRotationPoint( -17.6F, 1.9F, -8F );
        BalloonFrameBR4a = new ModelRenderer( this, 76, 101 );
        BalloonFrameBR4a.setTextureSize( 128, 128 );
        BalloonFrameBR4a.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameBR4a.setRotationPoint( -12.6F, 0.8999996F, -8F );
        BalloonFrameBR4b = new ModelRenderer( this, 74, 100 );
        BalloonFrameBR4b.setTextureSize( 128, 128 );
        BalloonFrameBR4b.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameBR4b.setRotationPoint( -16.6F, 0.8999996F, -8F );
        BalloonFrameBRBase = new ModelRenderer( this, 62, 24 );
        BalloonFrameBRBase.setTextureSize( 128, 128 );
        BalloonFrameBRBase.addBox( -2F, -2F, -0.5F, 4, 4, 1);
        BalloonFrameBRBase.setRotationPoint( -14.6F, -1.1F, 9.5F );
        Anchor_1L = new ModelRenderer( this, 82, 20 );
        Anchor_1L.setTextureSize( 128, 128 );
        Anchor_1L.addBox( -3F, 0F, -1F, 3, 2, 4);
        Anchor_1L.setRotationPoint( 11.6F, -0.1000004F, -1F );
        BalloonFrameTL3a = new ModelRenderer( this, 44, 108 );
        BalloonFrameTL3a.setTextureSize( 128, 128 );
        BalloonFrameTL3a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTL3a.setRotationPoint( 11.6F, -4.1F, -8F );
        BalloonFrameTL3b = new ModelRenderer( this, 42, 107 );
        BalloonFrameTL3b.setTextureSize( 128, 128 );
        BalloonFrameTL3b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameTL3b.setRotationPoint( 17.6F, -4.1F, -8F );
        BalloonFrameTL4a = new ModelRenderer( this, 38, 104 );
        BalloonFrameTL4a.setTextureSize( 128, 128 );
        BalloonFrameTL4a.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameTL4a.setRotationPoint( 12.6F, -3.1F, -8F );
        BalloonFrameTL4b = new ModelRenderer( this, 36, 103 );
        BalloonFrameTL4b.setTextureSize( 128, 128 );
        BalloonFrameTL4b.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameTL4b.setRotationPoint( 16.6F, -3.1F, -8F );
        BalloonFrameBL3a = new ModelRenderer( this, 36, 104 );
        BalloonFrameBL3a.setTextureSize( 128, 128 );
        BalloonFrameBL3a.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBL3a.setRotationPoint( 11.6F, 1.9F, -8F );
        BalloonFrameBL3b = new ModelRenderer( this, 34, 103 );
        BalloonFrameBL3b.setTextureSize( 128, 128 );
        BalloonFrameBL3b.addBox( -0.5F, -0.5F, -1.5F, 1, 1, 19);
        BalloonFrameBL3b.setRotationPoint( 17.6F, 1.9F, -8F );
        BalloonFrameBL4a = new ModelRenderer( this, 30, 100 );
        BalloonFrameBL4a.setTextureSize( 128, 128 );
        BalloonFrameBL4a.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameBL4a.setRotationPoint( 12.6F, 0.8999996F, -8F );
        BalloonFrameBL4b = new ModelRenderer( this, 28, 99 );
        BalloonFrameBL4b.setTextureSize( 128, 128 );
        BalloonFrameBL4b.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 21);
        BalloonFrameBL4b.setRotationPoint( 16.6F, 0.8999996F, -8F );
        BalloonFrameBLBase = new ModelRenderer( this, 72, 24 );
        BalloonFrameBLBase.setTextureSize( 128, 128 );
        BalloonFrameBLBase.addBox( -2F, -2F, -0.5F, 4, 4, 1);
        BalloonFrameBLBase.setRotationPoint( 14.6F, -1.1F, 9.5F );
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

        BalloonFrameBRBase.rotateAngleX = 0F;
        BalloonFrameBRBase.rotateAngleY = 0F;
        BalloonFrameBRBase.rotateAngleZ = 0F;
        BalloonFrameBRBase.renderWithRotation(par7);

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

        BalloonFrameBLBase.rotateAngleX = 0F;
        BalloonFrameBLBase.rotateAngleY = 0F;
        BalloonFrameBLBase.rotateAngleZ = 0F;
        BalloonFrameBLBase.renderWithRotation(par7);

    }

}
