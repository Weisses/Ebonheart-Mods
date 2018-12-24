package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent1Secondary extends ModelBase
{
    ModelRenderer Component_Balloon_Outer;
    ModelRenderer Component_Balloon_Middle_Front;
    ModelRenderer Component_Balloon_Middle_Back;
    ModelRenderer Component_Balloon_Inner_Front;
    ModelRenderer Component_Balloon_Inner_Back;
    ModelRenderer Component_Rope_FL;
    ModelRenderer Component_Rope_FR;
    ModelRenderer Component_Rope_BL;
    ModelRenderer Component_Rope_BR;
    ModelRenderer Component_Engine_Left_Base3_Pipe1;
    ModelRenderer Component_Engine_Left_Base3_Pipe2;
    ModelRenderer Component_Engine_Left_Base3_Pipe3;
    ModelRenderer Component_Engine_Right_Base3_Pipe1;
    ModelRenderer Component_Engine_Right_Base3_Pipe2;
    ModelRenderer Component_Engine_Right_Base3_Pipe3;

    public ModelAirshipComponent1Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent1Secondary( float par1 )
    {
        Component_Balloon_Outer = new ModelRenderer( this, 0, 64 );
        Component_Balloon_Outer.setTextureSize( 128, 128 );
        Component_Balloon_Outer.addBox( 0F, 0F, 0F, 32, 32, 32);
        Component_Balloon_Outer.setRotationPoint( -16F, -52F, -16F );
        Component_Balloon_Middle_Front = new ModelRenderer( this, 52, 90 );
        Component_Balloon_Middle_Front.setTextureSize( 128, 128 );
        Component_Balloon_Middle_Front.addBox( 0F, 0F, 15F, 30, 30, 8);
        Component_Balloon_Middle_Front.setRotationPoint( -15F, -51F, -34F );
        Component_Balloon_Middle_Back = new ModelRenderer( this, 52, 90 );
        Component_Balloon_Middle_Back.setTextureSize( 128, 128 );
        Component_Balloon_Middle_Back.addBox( 0F, 0F, 15F, 30, 30, 8);
        Component_Balloon_Middle_Back.setRotationPoint( -15F, -51F, -4F );
        Component_Balloon_Inner_Front = new ModelRenderer( this, 60, 94 );
        Component_Balloon_Inner_Front.setTextureSize( 128, 128 );
        Component_Balloon_Inner_Front.addBox( 0F, 0F, 18F, 26, 26, 8);
        Component_Balloon_Inner_Front.setRotationPoint( -13F, -49F, -40F );
        Component_Balloon_Inner_Back = new ModelRenderer( this, 60, 94 );
        Component_Balloon_Inner_Back.setTextureSize( 128, 128 );
        Component_Balloon_Inner_Back.addBox( 0F, 0F, -26F, 26, 26, 8);
        Component_Balloon_Inner_Back.setRotationPoint( -13F, -49F, 40F );
        Component_Rope_FL = new ModelRenderer( this, 124, 0 );
        Component_Rope_FL.setTextureSize( 128, 128 );
        Component_Rope_FL.addBox( 0F, -2.5F, -1F, 1, 23, 1);
        Component_Rope_FL.setRotationPoint( 12F, -19F, -12F );
        Component_Rope_FR = new ModelRenderer( this, 124, 0 );
        Component_Rope_FR.setTextureSize( 128, 128 );
        Component_Rope_FR.addBox( -1F, -2.5F, -1F, 1, 23, 1);
        Component_Rope_FR.setRotationPoint( -12F, -19F, -12F );
        Component_Rope_BL = new ModelRenderer( this, 124, 0 );
        Component_Rope_BL.setTextureSize( 128, 128 );
        Component_Rope_BL.addBox( 0F, -2.5F, 0F, 1, 23, 1);
        Component_Rope_BL.setRotationPoint( 12F, -19F, 12F );
        Component_Rope_BR = new ModelRenderer( this, 124, 0 );
        Component_Rope_BR.setTextureSize( 128, 128 );
        Component_Rope_BR.addBox( -1F, -2.5F, 0F, 1, 23, 1);
        Component_Rope_BR.setRotationPoint( -12F, -19F, 12F );
        Component_Engine_Left_Base3_Pipe1 = new ModelRenderer( this, 58, 3 );
        Component_Engine_Left_Base3_Pipe1.setTextureSize( 128, 128 );
        Component_Engine_Left_Base3_Pipe1.addBox( -2F, -1F, -0.5F, 4, 2, 1);
        Component_Engine_Left_Base3_Pipe1.setRotationPoint( 15.5F, -2.25F, 4F );
        Component_Engine_Left_Base3_Pipe2 = new ModelRenderer( this, 45, 1 );
        Component_Engine_Left_Base3_Pipe2.setTextureSize( 128, 128 );
        Component_Engine_Left_Base3_Pipe2.addBox( -2F, -1F, -2.5F, 4, 2, 5);
        Component_Engine_Left_Base3_Pipe2.setRotationPoint( 15.5F, -0.5F, 6F );
        Component_Engine_Left_Base3_Pipe3 = new ModelRenderer( this, 49, 8 );
        Component_Engine_Left_Base3_Pipe3.setTextureSize( 128, 128 );
        Component_Engine_Left_Base3_Pipe3.addBox( -2F, -1F, -0.5F, 4, 2, 1);
        Component_Engine_Left_Base3_Pipe3.setRotationPoint( 15.5F, -2.25F, 8F );
        Component_Engine_Right_Base3_Pipe1 = new ModelRenderer( this, 58, 15 );
        Component_Engine_Right_Base3_Pipe1.setTextureSize( 128, 128 );
        Component_Engine_Right_Base3_Pipe1.addBox( -2F, -1F, -0.5F, 4, 2, 1);
        Component_Engine_Right_Base3_Pipe1.setRotationPoint( -15.5F, -2.25F, 4F );
        Component_Engine_Right_Base3_Pipe2 = new ModelRenderer( this, 45, 13 );
        Component_Engine_Right_Base3_Pipe2.setTextureSize( 128, 128 );
        Component_Engine_Right_Base3_Pipe2.addBox( -2F, -1F, -2.5F, 4, 2, 5);
        Component_Engine_Right_Base3_Pipe2.setRotationPoint( -15.5F, -0.5F, 6F );
        Component_Engine_Right_Base3_Pipe3 = new ModelRenderer( this, 49, 20 );
        Component_Engine_Right_Base3_Pipe3.setTextureSize( 128, 128 );
        Component_Engine_Right_Base3_Pipe3.addBox( -2F, -1F, -0.5F, 4, 2, 1);
        Component_Engine_Right_Base3_Pipe3.setRotationPoint( -15.5F, -2.25F, 8F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Component_Balloon_Outer.rotateAngleX = 0F;
        Component_Balloon_Outer.rotateAngleY = 0F;
        Component_Balloon_Outer.rotateAngleZ = 0F;
        Component_Balloon_Outer.renderWithRotation(par7);

        Component_Balloon_Middle_Front.rotateAngleX = 0F;
        Component_Balloon_Middle_Front.rotateAngleY = 0F;
        Component_Balloon_Middle_Front.rotateAngleZ = 0F;
        Component_Balloon_Middle_Front.renderWithRotation(par7);

        Component_Balloon_Middle_Back.rotateAngleX = 0F;
        Component_Balloon_Middle_Back.rotateAngleY = 0F;
        Component_Balloon_Middle_Back.rotateAngleZ = 0F;
        Component_Balloon_Middle_Back.renderWithRotation(par7);

        Component_Balloon_Inner_Front.rotateAngleX = 0F;
        Component_Balloon_Inner_Front.rotateAngleY = 0F;
        Component_Balloon_Inner_Front.rotateAngleZ = 0F;
        Component_Balloon_Inner_Front.renderWithRotation(par7);

        Component_Balloon_Inner_Back.rotateAngleX = 0F;
        Component_Balloon_Inner_Back.rotateAngleY = 0F;
        Component_Balloon_Inner_Back.rotateAngleZ = 0F;
        Component_Balloon_Inner_Back.renderWithRotation(par7);

        Component_Rope_FL.rotateAngleX = 0.1832596F;
        Component_Rope_FL.rotateAngleY = -1.490884E-09F;
        Component_Rope_FL.rotateAngleZ = 0.1570796F;
        Component_Rope_FL.renderWithRotation(par7);

        Component_Rope_FR.rotateAngleX = 0.1832596F;
        Component_Rope_FR.rotateAngleY = 1.490884E-09F;
        Component_Rope_FR.rotateAngleZ = -0.1570796F;
        Component_Rope_FR.renderWithRotation(par7);

        Component_Rope_BL.rotateAngleX = -0.1832596F;
        Component_Rope_BL.rotateAngleY = 1.490884E-09F;
        Component_Rope_BL.rotateAngleZ = 0.1570796F;
        Component_Rope_BL.renderWithRotation(par7);

        Component_Rope_BR.rotateAngleX = -0.1832596F;
        Component_Rope_BR.rotateAngleY = -3.767372E-10F;
        Component_Rope_BR.rotateAngleZ = -0.1570796F;
        Component_Rope_BR.renderWithRotation(par7);

        Component_Engine_Left_Base3_Pipe1.rotateAngleX = 0F;
        Component_Engine_Left_Base3_Pipe1.rotateAngleY = 0F;
        Component_Engine_Left_Base3_Pipe1.rotateAngleZ = 0F;
        Component_Engine_Left_Base3_Pipe1.renderWithRotation(par7);

        Component_Engine_Left_Base3_Pipe2.rotateAngleX = 0F;
        Component_Engine_Left_Base3_Pipe2.rotateAngleY = 0F;
        Component_Engine_Left_Base3_Pipe2.rotateAngleZ = 0F;
        Component_Engine_Left_Base3_Pipe2.renderWithRotation(par7);

        Component_Engine_Left_Base3_Pipe3.rotateAngleX = 0F;
        Component_Engine_Left_Base3_Pipe3.rotateAngleY = 0F;
        Component_Engine_Left_Base3_Pipe3.rotateAngleZ = 0F;
        Component_Engine_Left_Base3_Pipe3.renderWithRotation(par7);

        Component_Engine_Right_Base3_Pipe1.rotateAngleX = 0F;
        Component_Engine_Right_Base3_Pipe1.rotateAngleY = 0F;
        Component_Engine_Right_Base3_Pipe1.rotateAngleZ = 0F;
        Component_Engine_Right_Base3_Pipe1.renderWithRotation(par7);

        Component_Engine_Right_Base3_Pipe2.rotateAngleX = 0F;
        Component_Engine_Right_Base3_Pipe2.rotateAngleY = 0F;
        Component_Engine_Right_Base3_Pipe2.rotateAngleZ = 0F;
        Component_Engine_Right_Base3_Pipe2.renderWithRotation(par7);

        Component_Engine_Right_Base3_Pipe3.rotateAngleX = 0F;
        Component_Engine_Right_Base3_Pipe3.rotateAngleY = 0F;
        Component_Engine_Right_Base3_Pipe3.rotateAngleZ = 0F;
        Component_Engine_Right_Base3_Pipe3.renderWithRotation(par7);

    }

}
