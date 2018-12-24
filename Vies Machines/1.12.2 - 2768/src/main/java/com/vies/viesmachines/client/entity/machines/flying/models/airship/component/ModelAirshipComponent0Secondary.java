package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent0Secondary extends ModelBase
{
    ModelRenderer BalloonBR1;
    ModelRenderer BalloonBR2;
    ModelRenderer BalloonBL1;
    ModelRenderer BalloonBL2;

    public ModelAirshipComponent0Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent0Secondary( float par1 )
    {
        BalloonBR1 = new ModelRenderer( this, 0, 104 );
        BalloonBR1.setTextureSize( 128, 128 );
        BalloonBR1.addBox( 0F, 0F, -1F, 6, 6, 18);
        BalloonBR1.setRotationPoint( -17.6F, -4.1F, -8F );
        BalloonBR2 = new ModelRenderer( this, 30, 114 );
        BalloonBR2.setTextureSize( 128, 128 );
        BalloonBR2.addBox( 0F, 0F, 6F, 4, 4, 4);
        BalloonBR2.setRotationPoint( -16.6F, -3.1F, -16F );
        BalloonBL1 = new ModelRenderer( this, 48, 104 );
        BalloonBL1.setTextureSize( 128, 128 );
        BalloonBL1.addBox( -6F, 0F, -1F, 6, 6, 18);
        BalloonBL1.setRotationPoint( 17.6F, -4.1F, -8F );
        BalloonBL2 = new ModelRenderer( this, 78, 114 );
        BalloonBL2.setTextureSize( 128, 128 );
        BalloonBL2.addBox( -4F, 0F, 6F, 4, 4, 4);
        BalloonBL2.setRotationPoint( 16.6F, -3.1F, -16F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
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
