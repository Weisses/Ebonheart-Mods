package com.viesis.viescraft.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipPropeller extends ModelBase
{
    ModelRenderer Propeller_1a;
    ModelRenderer Propeller_1b;
    ModelRenderer Propeller_1c;

    public ModelAirshipPropeller()
    {
        this( 0.0f );
    }

    public ModelAirshipPropeller( float par1 )
    {
        Propeller_1a = new ModelRenderer( this, 6, 119 );
        Propeller_1a.setTextureSize( 128, 128 );
        Propeller_1a.addBox( -1F, -1F, -2F, 2, 2, 4);
        Propeller_1a.setRotationPoint( 0F, 0F, 11F );
        Propeller_1b = new ModelRenderer( this, 0, 116 );
        Propeller_1b.setTextureSize( 128, 128 );
        Propeller_1b.addBox( -1F, -4F, 0F, 2, 8, 1);
        Propeller_1b.setRotationPoint( 0F, 0F, 11F );
        Propeller_1c = new ModelRenderer( this, 0, 125 );
        Propeller_1c.setTextureSize( 128, 128 );
        Propeller_1c.addBox( -4F, -1F, 0F, 8, 2, 1);
        Propeller_1c.setRotationPoint( 0F, 0F, 11F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Propeller_1a.rotateAngleX = 0F;
        Propeller_1a.rotateAngleY = 0F;
        Propeller_1a.rotateAngleZ = 0F;
        Propeller_1a.renderWithRotation(par7);

        Propeller_1b.rotateAngleX = 0F;
        Propeller_1b.rotateAngleY = 0F;
        Propeller_1b.rotateAngleZ = 0F;
        Propeller_1b.renderWithRotation(par7);

        Propeller_1c.rotateAngleX = 0F;
        Propeller_1c.rotateAngleY = 0F;
        Propeller_1c.rotateAngleZ = 0F;
        Propeller_1c.renderWithRotation(par7);

    }

}
