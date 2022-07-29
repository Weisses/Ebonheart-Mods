package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonDisplaySymbol0 extends ModelBase
{
    ModelRenderer DisplayStand;
    ModelRenderer DisplayStandTop;

    public ModelBalloonDisplaySymbol0()
    {
        this( 0.0f );
    }

    public ModelBalloonDisplaySymbol0( float par1 )
    {
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
