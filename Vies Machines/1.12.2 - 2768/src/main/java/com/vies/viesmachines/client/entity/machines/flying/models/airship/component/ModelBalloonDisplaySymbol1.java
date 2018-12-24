package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonDisplaySymbol1 extends ModelBase
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
    ModelRenderer DisplayStand;
    ModelRenderer DisplayStandTop;

    public ModelBalloonDisplaySymbol1()
    {
        this( 0.0f );
    }

    public ModelBalloonDisplaySymbol1( float par1 )
    {
        ItemFrameLeftInside = new ModelRenderer( this, 0, 114 );
        ItemFrameLeftInside.setTextureSize( 128, 128 );
        ItemFrameLeftInside.addBox( 0F, -3.5F, -3.5F, 0, 7, 7);
        ItemFrameLeftInside.setRotationPoint( -16.6F, -36F, 0F );
        ItemFrameLeftBorderT = new ModelRenderer( this, 110, 119 );
        ItemFrameLeftBorderT.setTextureSize( 128, 128 );
        ItemFrameLeftBorderT.addBox( -0.5F, -0.5F, -4F, 1, 1, 8);
        ItemFrameLeftBorderT.setRotationPoint( -16.5F, -40F, -0.5F );
        ItemFrameLeftBorderB = new ModelRenderer( this, 110, 119 );
        ItemFrameLeftBorderB.setTextureSize( 128, 128 );
        ItemFrameLeftBorderB.addBox( -0.5F, -0.5F, -4F, 1, 1, 8);
        ItemFrameLeftBorderB.setRotationPoint( -16.5F, -32F, 0.5F );
        ItemFrameLeftBorderR = new ModelRenderer( this, 124, 119 );
        ItemFrameLeftBorderR.setTextureSize( 128, 128 );
        ItemFrameLeftBorderR.addBox( -0.5F, -4F, -0.5F, 1, 8, 1);
        ItemFrameLeftBorderR.setRotationPoint( -16.5F, -35.5F, -4F );
        ItemFrameLeftBorderL = new ModelRenderer( this, 124, 119 );
        ItemFrameLeftBorderL.setTextureSize( 128, 128 );
        ItemFrameLeftBorderL.addBox( -0.5F, -4F, -0.5F, 1, 8, 1);
        ItemFrameLeftBorderL.setRotationPoint( -16.5F, -36.5F, 4F );
        ItemFrameRightInside = new ModelRenderer( this, 0, 114 );
        ItemFrameRightInside.setTextureSize( 128, 128 );
        ItemFrameRightInside.addBox( 0F, -3.5F, -3.5F, 0, 7, 7);
        ItemFrameRightInside.setRotationPoint( 16.6F, -36F, 0F );
        ItemFrameRightBorderT = new ModelRenderer( this, 110, 119 );
        ItemFrameRightBorderT.setTextureSize( 128, 128 );
        ItemFrameRightBorderT.addBox( -0.5F, -0.5F, -4F, 1, 1, 8);
        ItemFrameRightBorderT.setRotationPoint( 16.5F, -40F, -0.5F );
        ItemFrameRightBorderB = new ModelRenderer( this, 110, 119 );
        ItemFrameRightBorderB.setTextureSize( 128, 128 );
        ItemFrameRightBorderB.addBox( -0.5F, -0.5F, -4F, 1, 1, 8);
        ItemFrameRightBorderB.setRotationPoint( 16.5F, -32F, 0.5F );
        ItemFrameRightBorderR = new ModelRenderer( this, 124, 119 );
        ItemFrameRightBorderR.setTextureSize( 128, 128 );
        ItemFrameRightBorderR.addBox( -0.5F, -4F, -0.5F, 1, 8, 1);
        ItemFrameRightBorderR.setRotationPoint( 16.5F, -35.5F, -4F );
        ItemFrameRightBorderL = new ModelRenderer( this, 124, 119 );
        ItemFrameRightBorderL.setTextureSize( 128, 128 );
        ItemFrameRightBorderL.addBox( -0.5F, -4F, -0.5F, 1, 8, 1);
        ItemFrameRightBorderL.setRotationPoint( 16.5F, -36.5F, 4F );
        DisplayStand = new ModelRenderer( this, 10, 119 );
        DisplayStand.setTextureSize( 128, 128 );
        DisplayStand.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        DisplayStand.setRotationPoint( -6F, 0F, -13F );
        DisplayStandTop = new ModelRenderer( this, 0, 115 );
        DisplayStandTop.setTextureSize( 128, 128 );
        DisplayStandTop.addBox( -1F, -2F, -1F, 2, 4, 2);
        DisplayStandTop.setRotationPoint( -6F, 2F, -13F );
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

        DisplayStand.rotateAngleX = 0F;
        DisplayStand.rotateAngleY = 0F;
        DisplayStand.rotateAngleZ = 0F;
        DisplayStand.renderWithRotation(par7);

        DisplayStandTop.rotateAngleX = 0F;
        DisplayStandTop.rotateAngleY = 0F;
        DisplayStandTop.rotateAngleZ = 0F;
        DisplayStandTop.renderWithRotation(par7);

    }

}
