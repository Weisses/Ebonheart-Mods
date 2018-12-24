package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent2Secondary extends ModelBase
{
    ModelRenderer BalloonR1a;
    ModelRenderer BalloonR1b;
    ModelRenderer BalloonL1a;
    ModelRenderer BalloonL1b;

    public ModelAirshipComponent2Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent2Secondary( float par1 )
    {
        BalloonR1a = new ModelRenderer( this, 25, 25 );
        BalloonR1a.setTextureSize( 256, 256 );
        BalloonR1a.addBox( 0F, 0F, 12.5F, 8, 8, 1);
        BalloonR1a.setRotationPoint( -22F, -6.1F, -25.6F );
        BalloonR1b = new ModelRenderer( this, 0, 68 );
        BalloonR1b.setTextureSize( 256, 256 );
        BalloonR1b.addBox( 0F, 0F, 0F, 10, 10, 25);
        BalloonR1b.setRotationPoint( -23F, -7.1F, -12.1F );
        BalloonL1a = new ModelRenderer( this, 25, 59 );
        BalloonL1a.setTextureSize( 256, 256 );
        BalloonL1a.addBox( 0F, 0F, 12.5F, 8, 8, 1);
        BalloonL1a.setRotationPoint( 14F, -6.1F, -25.6F );
        BalloonL1b = new ModelRenderer( this, 0, 103 );
        BalloonL1b.setTextureSize( 256, 256 );
        BalloonL1b.addBox( 0F, 0F, 0F, 10, 10, 25);
        BalloonL1b.setRotationPoint( 13F, -7.1F, -12.1F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
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
