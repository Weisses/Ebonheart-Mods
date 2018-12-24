package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine0Primary extends ModelBase
{
    ModelRenderer Primary_Engine_Chassis;
    ModelRenderer Primary_Engine_Smokestack;

    public ModelAirshipEngine0Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine0Primary( float par1 )
    {
        Primary_Engine_Chassis = new ModelRenderer( this, 0, 4 );
        Primary_Engine_Chassis.setTextureSize( 128, 128 );
        Primary_Engine_Chassis.addBox( 1F, 1F, 1F, 4, 4, 4);
        Primary_Engine_Chassis.setRotationPoint( -3F, -0.6000004F, 11.6F );
        Primary_Engine_Smokestack = new ModelRenderer( this, 0, 0 );
        Primary_Engine_Smokestack.setTextureSize( 128, 128 );
        Primary_Engine_Smokestack.addBox( 0F, 1F, 0F, 2, 2, 2);
        Primary_Engine_Smokestack.setRotationPoint( -1F, -2.6F, 13.6F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Primary_Engine_Chassis.rotateAngleX = 0F;
        Primary_Engine_Chassis.rotateAngleY = 0F;
        Primary_Engine_Chassis.rotateAngleZ = 0F;
        Primary_Engine_Chassis.renderWithRotation(par7);

        Primary_Engine_Smokestack.rotateAngleX = 0F;
        Primary_Engine_Smokestack.rotateAngleY = 0F;
        Primary_Engine_Smokestack.rotateAngleZ = 0F;
        Primary_Engine_Smokestack.renderWithRotation(par7);

    }

}
