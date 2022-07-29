package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonBalloon0 extends ModelBase
{
    ModelRenderer Floor_Top;
    ModelRenderer BalloonBR1;
    ModelRenderer BalloonBR2;
    ModelRenderer BalloonBL1;
    ModelRenderer BalloonBL2;

    public ModelBalloonBalloon0()
    {
        this( 0.0f );
    }

    public ModelBalloonBalloon0( float par1 )
    {
        Floor_Top = new ModelRenderer( this, 180, 0 );
        Floor_Top.setTextureSize( 256, 256 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        BalloonBR1 = new ModelRenderer( this, 0, 22 );
        BalloonBR1.setTextureSize( 256, 256 );
        BalloonBR1.addBox( 0F, 0F, 0F, 6, 6, 16);
        BalloonBR1.setRotationPoint( -16F, -4F, -8F );
        BalloonBR2 = new ModelRenderer( this, 0, 0 );
        BalloonBR2.setTextureSize( 256, 256 );
        BalloonBR2.addBox( 0F, 0F, -1F, 4, 4, 18);
        BalloonBR2.setRotationPoint( -15F, -3F, -8F );
        BalloonBL1 = new ModelRenderer( this, 0, 22 );
        BalloonBL1.setTextureSize( 256, 256 );
        BalloonBL1.addBox( -6F, 0F, 0F, 6, 6, 16);
        BalloonBL1.setRotationPoint( 16F, -4F, -8F );
        BalloonBL2 = new ModelRenderer( this, 0, 0 );
        BalloonBL2.setTextureSize( 256, 256 );
        BalloonBL2.addBox( -4F, 0F, -1F, 4, 4, 18);
        BalloonBL2.setRotationPoint( 15F, -3F, -8F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

        BalloonBR1.rotateAngleX = 0F;
        BalloonBR1.rotateAngleY = 0F;
        BalloonBR1.rotateAngleZ = 0F;
        BalloonBR1.renderWithRotation(par7);

        BalloonBR2.rotateAngleX = 0F;
        BalloonBR2.rotateAngleY = 0F;
        BalloonBR2.rotateAngleZ = 0F;
        BalloonBR2.renderWithRotation(par7);

        BalloonBL1.rotateAngleX = 0F;
        BalloonBL1.rotateAngleY = 0F;
        BalloonBL1.rotateAngleZ = 0F;
        BalloonBL1.renderWithRotation(par7);

        BalloonBL2.rotateAngleX = 0F;
        BalloonBL2.rotateAngleY = 0F;
        BalloonBL2.rotateAngleZ = 0F;
        BalloonBL2.renderWithRotation(par7);

    }

}
