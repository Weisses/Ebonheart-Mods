package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonBalloon4 extends ModelBase
{
    ModelRenderer RopeL;
    ModelRenderer Balloon1;
    ModelRenderer Balloon2;
    ModelRenderer Balloon3;
    ModelRenderer BalloonFinFlatL;
    ModelRenderer BalloonTopFinFlatL;
    ModelRenderer BalloonTopFinFlatR;
    ModelRenderer BalloonFinFlatR;
    ModelRenderer RopeR;
    ModelRenderer Floor_Top;

    public ModelBalloonBalloon4()
    {
        this( 0.0f );
    }

    public ModelBalloonBalloon4( float par1 )
    {
        RopeL = new ModelRenderer( this, 248, 0 );
        RopeL.setTextureSize( 256, 256 );
        RopeL.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeL.setRotationPoint( -13.5F, -21F, -13.5F );
        Balloon1 = new ModelRenderer( this, 0, 0 );
        Balloon1.setTextureSize( 256, 256 );
        Balloon1.addBox( 0F, 0F, 0F, 30, 24, 30);
        Balloon1.setRotationPoint( -15F, -44F, -15F );
        Balloon2 = new ModelRenderer( this, 0, 54 );
        Balloon2.setTextureSize( 256, 256 );
        Balloon2.addBox( 0F, 0F, 0F, 26, 22, 36);
        Balloon2.setRotationPoint( -13F, -43F, -18F );
        Balloon3 = new ModelRenderer( this, 0, 112 );
        Balloon3.setTextureSize( 256, 256 );
        Balloon3.addBox( 0F, 0F, 0F, 24, 20, 40);
        Balloon3.setRotationPoint( -12F, -42F, -20F );
        BalloonFinFlatL = new ModelRenderer( this, 192, 208 );
        BalloonFinFlatL.setTextureSize( 256, 256 );
        BalloonFinFlatL.addBox( -20F, 0F, -12F, 20, 0, 24);
        BalloonFinFlatL.setRotationPoint( -15F, -33F, 1F );
        BalloonTopFinFlatL = new ModelRenderer( this, 210, 194 );
        BalloonTopFinFlatL.setTextureSize( 256, 256 );
        BalloonTopFinFlatL.addBox( -10F, 0F, -7F, 8, 0, 14);
        BalloonTopFinFlatL.setRotationPoint( -7F, -43F, 8F );
        BalloonTopFinFlatR = new ModelRenderer( this, 226, 194 );
        BalloonTopFinFlatR.setTextureSize( 256, 256 );
        BalloonTopFinFlatR.addBox( 2F, 0F, -7F, 8, 0, 14);
        BalloonTopFinFlatR.setRotationPoint( 7F, -43F, 8F );
        BalloonFinFlatR = new ModelRenderer( this, 192, 232 );
        BalloonFinFlatR.setTextureSize( 256, 256 );
        BalloonFinFlatR.addBox( 0F, 0F, -12F, 20, 0, 24);
        BalloonFinFlatR.setRotationPoint( 15F, -33F, 1F );
        RopeR = new ModelRenderer( this, 252, 0 );
        RopeR.setTextureSize( 256, 256 );
        RopeR.addBox( -1F, 0F, 0F, 1, 23, 1);
        RopeR.setRotationPoint( 13.5F, -21F, -13.5F );
        Floor_Top = new ModelRenderer( this, 180, 0 );
        Floor_Top.setTextureSize( 256, 256 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        RopeL.rotateAngleX = 0.1876229F;
        RopeL.rotateAngleY = -1.794455E-09F;
        RopeL.rotateAngleZ = -0.2094395F;
        RopeL.renderWithRotation(par7);

        Balloon1.rotateAngleX = 0F;
        Balloon1.rotateAngleY = 0F;
        Balloon1.rotateAngleZ = 0F;
        Balloon1.renderWithRotation(par7);

        Balloon2.rotateAngleX = 0F;
        Balloon2.rotateAngleY = 0F;
        Balloon2.rotateAngleZ = 0F;
        Balloon2.renderWithRotation(par7);

        Balloon3.rotateAngleX = 0F;
        Balloon3.rotateAngleY = 0F;
        Balloon3.rotateAngleZ = 0F;
        Balloon3.renderWithRotation(par7);

        BalloonFinFlatL.rotateAngleX = 0F;
        BalloonFinFlatL.rotateAngleY = 0F;
        BalloonFinFlatL.rotateAngleZ = 0.7853982F;
        BalloonFinFlatL.renderWithRotation(par7);

        BalloonTopFinFlatL.rotateAngleX = 0F;
        BalloonTopFinFlatL.rotateAngleY = 0F;
        BalloonTopFinFlatL.rotateAngleZ = 0.7853982F;
        BalloonTopFinFlatL.renderWithRotation(par7);

        BalloonTopFinFlatR.rotateAngleX = 0F;
        BalloonTopFinFlatR.rotateAngleY = 0F;
        BalloonTopFinFlatR.rotateAngleZ = -0.7853982F;
        BalloonTopFinFlatR.renderWithRotation(par7);

        BalloonFinFlatR.rotateAngleX = 0F;
        BalloonFinFlatR.rotateAngleY = 0F;
        BalloonFinFlatR.rotateAngleZ = -0.7853982F;
        BalloonFinFlatR.renderWithRotation(par7);

        RopeR.rotateAngleX = 0.1876229F;
        RopeR.rotateAngleY = 1.794455E-09F;
        RopeR.rotateAngleZ = 0.2094395F;
        RopeR.renderWithRotation(par7);

        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

    }

}
