package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonBalloon2 extends ModelBase
{
    ModelRenderer Floor_Top;
    ModelRenderer BalloonR1a;
    ModelRenderer BalloonR1b;
    ModelRenderer BalloonL1a;
    ModelRenderer BalloonL1b;

    public ModelBalloonBalloon2()
    {
        this( 0.0f );
    }

    public ModelBalloonBalloon2( float par1 )
    {
        Floor_Top = new ModelRenderer( this, 180, 0 );
        Floor_Top.setTextureSize( 256, 256 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        BalloonR1a = new ModelRenderer( this, 0, 0 );
        BalloonR1a.setTextureSize( 256, 256 );
        BalloonR1a.addBox( 0F, 0F, 0F, 8, 8, 26);
        BalloonR1a.setRotationPoint( -21F, -6F, -13F );
        BalloonR1b = new ModelRenderer( this, 0, 68 );
        BalloonR1b.setTextureSize( 256, 256 );
        BalloonR1b.addBox( 0F, 0F, 0F, 10, 10, 25);
        BalloonR1b.setRotationPoint( -22F, -7F, -12F );
        BalloonL1a = new ModelRenderer( this, 0, 34 );
        BalloonL1a.setTextureSize( 256, 256 );
        BalloonL1a.addBox( 0F, 0F, 0F, 8, 8, 26);
        BalloonL1a.setRotationPoint( 13F, -6F, -13F );
        BalloonL1b = new ModelRenderer( this, 0, 103 );
        BalloonL1b.setTextureSize( 256, 256 );
        BalloonL1b.addBox( 0F, 0F, 0F, 10, 10, 25);
        BalloonL1b.setRotationPoint( 12F, -7F, -12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

        BalloonR1a.rotateAngleX = 0F;
        BalloonR1a.rotateAngleY = 0F;
        BalloonR1a.rotateAngleZ = 0F;
        BalloonR1a.renderWithRotation(par7);

        BalloonR1b.rotateAngleX = 0F;
        BalloonR1b.rotateAngleY = 0F;
        BalloonR1b.rotateAngleZ = 0F;
        BalloonR1b.renderWithRotation(par7);

        BalloonL1a.rotateAngleX = 0F;
        BalloonL1a.rotateAngleY = 0F;
        BalloonL1a.rotateAngleZ = 0F;
        BalloonL1a.renderWithRotation(par7);

        BalloonL1b.rotateAngleX = 0F;
        BalloonL1b.rotateAngleY = 0F;
        BalloonL1b.rotateAngleZ = 0F;
        BalloonL1b.renderWithRotation(par7);

    }

}
