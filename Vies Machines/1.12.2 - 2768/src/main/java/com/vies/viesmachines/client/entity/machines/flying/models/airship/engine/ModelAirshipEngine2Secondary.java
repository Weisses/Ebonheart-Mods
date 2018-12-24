package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine2Secondary extends ModelBase
{
    ModelRenderer Secondary_Engine_Left_Stud1;
    ModelRenderer Secondary_Engine_Left_Stud2;
    ModelRenderer Secondary_Engine_Right_Stud1;
    ModelRenderer Secondary_Engine_Right_Stud2;
    ModelRenderer Secondary_Engine_Left_Stud3;
    ModelRenderer Secondary_Engine_Right_Stud3;

    public ModelAirshipEngine2Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine2Secondary( float par1 )
    {
        Secondary_Engine_Left_Stud1 = new ModelRenderer( this, 28, 48 );
        Secondary_Engine_Left_Stud1.setTextureSize( 128, 128 );
        Secondary_Engine_Left_Stud1.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Secondary_Engine_Left_Stud1.setRotationPoint( 2.6F, -0.1000004F, 12.1F );
        Secondary_Engine_Left_Stud2 = new ModelRenderer( this, 32, 48 );
        Secondary_Engine_Left_Stud2.setTextureSize( 128, 128 );
        Secondary_Engine_Left_Stud2.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Secondary_Engine_Left_Stud2.setRotationPoint( 5.6F, -0.1000004F, 12.1F );
        Secondary_Engine_Right_Stud1 = new ModelRenderer( this, 36, 48 );
        Secondary_Engine_Right_Stud1.setTextureSize( 128, 128 );
        Secondary_Engine_Right_Stud1.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Secondary_Engine_Right_Stud1.setRotationPoint( -2.6F, -0.1000004F, 12.1F );
        Secondary_Engine_Right_Stud2 = new ModelRenderer( this, 40, 48 );
        Secondary_Engine_Right_Stud2.setTextureSize( 128, 128 );
        Secondary_Engine_Right_Stud2.addBox( -0.5F, -1F, -0.5F, 1, 2, 1);
        Secondary_Engine_Right_Stud2.setRotationPoint( -5.6F, -0.1000004F, 12.1F );
        Secondary_Engine_Left_Stud3 = new ModelRenderer( this, 28, 51 );
        Secondary_Engine_Left_Stud3.setTextureSize( 128, 128 );
        Secondary_Engine_Left_Stud3.addBox( -1F, -0.5F, -1F, 2, 1, 2);
        Secondary_Engine_Left_Stud3.setRotationPoint( 4.1F, 0.3999996F, 16.6F );
        Secondary_Engine_Right_Stud3 = new ModelRenderer( this, 36, 51 );
        Secondary_Engine_Right_Stud3.setTextureSize( 128, 128 );
        Secondary_Engine_Right_Stud3.addBox( -1F, -0.5F, -1F, 2, 1, 2);
        Secondary_Engine_Right_Stud3.setRotationPoint( -4.1F, 0.3999996F, 16.6F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Secondary_Engine_Left_Stud1.rotateAngleX = 0F;
        Secondary_Engine_Left_Stud1.rotateAngleY = 0F;
        Secondary_Engine_Left_Stud1.rotateAngleZ = 0F;
        Secondary_Engine_Left_Stud1.renderWithRotation(par7);

        Secondary_Engine_Left_Stud2.rotateAngleX = 0F;
        Secondary_Engine_Left_Stud2.rotateAngleY = 0F;
        Secondary_Engine_Left_Stud2.rotateAngleZ = 0F;
        Secondary_Engine_Left_Stud2.renderWithRotation(par7);

        Secondary_Engine_Right_Stud1.rotateAngleX = 0F;
        Secondary_Engine_Right_Stud1.rotateAngleY = 0F;
        Secondary_Engine_Right_Stud1.rotateAngleZ = 0F;
        Secondary_Engine_Right_Stud1.renderWithRotation(par7);

        Secondary_Engine_Right_Stud2.rotateAngleX = 0F;
        Secondary_Engine_Right_Stud2.rotateAngleY = 0F;
        Secondary_Engine_Right_Stud2.rotateAngleZ = 0F;
        Secondary_Engine_Right_Stud2.renderWithRotation(par7);

        Secondary_Engine_Left_Stud3.rotateAngleX = 0F;
        Secondary_Engine_Left_Stud3.rotateAngleY = 0F;
        Secondary_Engine_Left_Stud3.rotateAngleZ = 0F;
        Secondary_Engine_Left_Stud3.renderWithRotation(par7);

        Secondary_Engine_Right_Stud3.rotateAngleX = 0F;
        Secondary_Engine_Right_Stud3.rotateAngleY = 0F;
        Secondary_Engine_Right_Stud3.rotateAngleZ = 0F;
        Secondary_Engine_Right_Stud3.renderWithRotation(par7);

    }

}
