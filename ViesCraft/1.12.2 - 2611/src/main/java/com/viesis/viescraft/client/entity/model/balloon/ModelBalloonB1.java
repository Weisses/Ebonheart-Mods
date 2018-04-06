package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonB1 extends ModelBase
{
    ModelRenderer Floor_Top;
    ModelRenderer Balloon1;
    ModelRenderer Balloon2;
    ModelRenderer Balloon3;
    ModelRenderer RopeFL;
    ModelRenderer RopeFR;
    ModelRenderer RopeBL;
    ModelRenderer RopeBR;

    public ModelBalloonB1()
    {
        this( 0.0f );
    }

    public ModelBalloonB1( float par1 )
    {
        Floor_Top = new ModelRenderer( this, -8, -8 );
        Floor_Top.setTextureSize( 512, 256 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        Balloon1 = new ModelRenderer( this, 0, 0 );
        Balloon1.setTextureSize( 512, 256 );
        Balloon1.addBox( 0F, 0F, 0F, 32, 32, 32);
        Balloon1.setRotationPoint( -16F, -52F, -16F );
        Balloon2 = new ModelRenderer( this, 0, 64 );
        Balloon2.setTextureSize( 512, 256 );
        Balloon2.addBox( 0F, 0F, 0F, 30, 30, 38);
        Balloon2.setRotationPoint( -15F, -51F, -19F );
        Balloon3 = new ModelRenderer( this, 0, 132 );
        Balloon3.setTextureSize( 512, 256 );
        Balloon3.addBox( 0F, 0F, 0F, 26, 26, 44);
        Balloon3.setRotationPoint( -13F, -49F, -22F );
        RopeFL = new ModelRenderer( this, 492, 0 );
        RopeFL.setTextureSize( 512, 256 );
        RopeFL.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeFL.setRotationPoint( 12.5F, -21F, -13F );
        RopeFR = new ModelRenderer( this, 500, 0 );
        RopeFR.setTextureSize( 512, 256 );
        RopeFR.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeFR.setRotationPoint( -13.5F, -21F, -13F );
        RopeBL = new ModelRenderer( this, 500, 0 );
        RopeBL.setTextureSize( 512, 256 );
        RopeBL.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeBL.setRotationPoint( 12.5F, -21F, 12F );
        RopeBR = new ModelRenderer( this, 508, 0 );
        RopeBR.setTextureSize( 512, 256 );
        RopeBR.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeBR.setRotationPoint( -13.5F, -21F, 12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

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

        RopeFL.rotateAngleX = 0.1658063F;
        RopeFL.rotateAngleY = 5.656693E-10F;
        RopeFL.rotateAngleZ = 0.2094395F;
        RopeFL.renderWithRotation(par7);

        RopeFR.rotateAngleX = 0.1658063F;
        RopeFR.rotateAngleY = -5.656693E-10F;
        RopeFR.rotateAngleZ = -0.2094395F;
        RopeFR.renderWithRotation(par7);

        RopeBL.rotateAngleX = -0.1658063F;
        RopeBL.rotateAngleY = -5.656693E-10F;
        RopeBL.rotateAngleZ = 0.2094395F;
        RopeBL.renderWithRotation(par7);

        RopeBR.rotateAngleX = -0.1658063F;
        RopeBR.rotateAngleY = 5.656693E-10F;
        RopeBR.rotateAngleZ = -0.2094395F;
        RopeBR.renderWithRotation(par7);

    }

}
