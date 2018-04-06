package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonF0 extends ModelBase
{
    ModelRenderer Floor_Top;
    
    public ModelBalloonF0()
    {
        this( 0.0f );
    }

    public ModelBalloonF0( float par1 )
    {
        Floor_Top = new ModelRenderer( this, 47, 27 );
        Floor_Top.setTextureSize( 256, 128 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

    }

}
