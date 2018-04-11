package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonDisplaySymbol2 extends ModelBase
{
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

    public ModelBalloonDisplaySymbol2()
    {
        this( 0.0f );
    }

    public ModelBalloonDisplaySymbol2( float par1 )
    {
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
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
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
