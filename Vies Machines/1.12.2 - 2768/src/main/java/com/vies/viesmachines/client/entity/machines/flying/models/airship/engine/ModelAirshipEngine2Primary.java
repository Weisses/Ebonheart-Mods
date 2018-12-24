package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine2Primary extends ModelBase
{
    ModelRenderer Primary_Engine_Pipe;
    ModelRenderer Primary_Engine_Left_Chassis;
    ModelRenderer Primary_Engine_Left_Smokestack;
    ModelRenderer Primary_Engine_Left_SmallBox;
    ModelRenderer Primary_Engine_Right_Chassis;
    ModelRenderer Primary_Engine_Right_Smokestack;
    ModelRenderer Primary_Engine_Right_SmallBox;

    public ModelAirshipEngine2Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine2Primary( float par1 )
    {
        Primary_Engine_Pipe = new ModelRenderer( this, 16, 38 );
        Primary_Engine_Pipe.setTextureSize( 128, 128 );
        Primary_Engine_Pipe.addBox( -2F, -1F, -1F, 4, 2, 2);
        Primary_Engine_Pipe.setRotationPoint( 0F, 2.9F, 13.1F );
        Primary_Engine_Left_Chassis = new ModelRenderer( this, 0, 36 );
        Primary_Engine_Left_Chassis.setTextureSize( 128, 128 );
        Primary_Engine_Left_Chassis.addBox( 0.5F, 0F, 0F, 5, 6, 6);
        Primary_Engine_Left_Chassis.setRotationPoint( 1.1F, -0.6000004F, 11.1F );
        Primary_Engine_Left_Smokestack = new ModelRenderer( this, 0, 48 );
        Primary_Engine_Left_Smokestack.setTextureSize( 128, 128 );
        Primary_Engine_Left_Smokestack.addBox( 0F, 0F, 0F, 2, 4, 2);
        Primary_Engine_Left_Smokestack.setRotationPoint( 3.1F, -4.6F, 14.1F );
        Primary_Engine_Left_SmallBox = new ModelRenderer( this, 16, 52 );
        Primary_Engine_Left_SmallBox.setTextureSize( 128, 128 );
        Primary_Engine_Left_SmallBox.addBox( -1.5F, -1F, -1F, 3, 2, 2);
        Primary_Engine_Left_SmallBox.setRotationPoint( 4F, 2.9F, 17.1F );
        Primary_Engine_Right_Chassis = new ModelRenderer( this, 22, 36 );
        Primary_Engine_Right_Chassis.setTextureSize( 128, 128 );
        Primary_Engine_Right_Chassis.addBox( -5.5F, 0F, 0F, 5, 6, 6);
        Primary_Engine_Right_Chassis.setRotationPoint( -1.1F, -0.6000004F, 11.1F );
        Primary_Engine_Right_Smokestack = new ModelRenderer( this, 8, 48 );
        Primary_Engine_Right_Smokestack.setTextureSize( 128, 128 );
        Primary_Engine_Right_Smokestack.addBox( -2F, 0F, 0F, 2, 4, 2);
        Primary_Engine_Right_Smokestack.setRotationPoint( -3.1F, -4.6F, 14.1F );
        Primary_Engine_Right_SmallBox = new ModelRenderer( this, 16, 48 );
        Primary_Engine_Right_SmallBox.setTextureSize( 128, 128 );
        Primary_Engine_Right_SmallBox.addBox( -1.5F, -1F, -1F, 3, 2, 2);
        Primary_Engine_Right_SmallBox.setRotationPoint( -4F, 2.9F, 17.1F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Primary_Engine_Pipe.rotateAngleX = 0F;
        Primary_Engine_Pipe.rotateAngleY = 0F;
        Primary_Engine_Pipe.rotateAngleZ = 0F;
        Primary_Engine_Pipe.renderWithRotation(par7);

        Primary_Engine_Left_Chassis.rotateAngleX = 0F;
        Primary_Engine_Left_Chassis.rotateAngleY = 0F;
        Primary_Engine_Left_Chassis.rotateAngleZ = 0F;
        Primary_Engine_Left_Chassis.renderWithRotation(par7);

        Primary_Engine_Left_Smokestack.rotateAngleX = 0F;
        Primary_Engine_Left_Smokestack.rotateAngleY = 0F;
        Primary_Engine_Left_Smokestack.rotateAngleZ = 0F;
        Primary_Engine_Left_Smokestack.renderWithRotation(par7);

        Primary_Engine_Left_SmallBox.rotateAngleX = 0.7853982F;
        Primary_Engine_Left_SmallBox.rotateAngleY = 0F;
        Primary_Engine_Left_SmallBox.rotateAngleZ = 0F;
        Primary_Engine_Left_SmallBox.renderWithRotation(par7);

        Primary_Engine_Right_Chassis.rotateAngleX = 0F;
        Primary_Engine_Right_Chassis.rotateAngleY = 0F;
        Primary_Engine_Right_Chassis.rotateAngleZ = 0F;
        Primary_Engine_Right_Chassis.renderWithRotation(par7);

        Primary_Engine_Right_Smokestack.rotateAngleX = 0F;
        Primary_Engine_Right_Smokestack.rotateAngleY = 0F;
        Primary_Engine_Right_Smokestack.rotateAngleZ = 0F;
        Primary_Engine_Right_Smokestack.renderWithRotation(par7);

        Primary_Engine_Right_SmallBox.rotateAngleX = 0.7853982F;
        Primary_Engine_Right_SmallBox.rotateAngleY = 0F;
        Primary_Engine_Right_SmallBox.rotateAngleZ = 0F;
        Primary_Engine_Right_SmallBox.renderWithRotation(par7);

    }

}
