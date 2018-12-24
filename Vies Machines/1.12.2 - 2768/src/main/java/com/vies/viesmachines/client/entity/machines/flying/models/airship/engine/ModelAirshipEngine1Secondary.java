package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine1Secondary extends ModelBase
{
    ModelRenderer Primary_Engine_Stud1;
    ModelRenderer Primary_Engine_Stud2;
    ModelRenderer Primary_Engine_Stud3;
    ModelRenderer Primary_Engine_Stud4;

    public ModelAirshipEngine1Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine1Secondary( float par1 )
    {
        Primary_Engine_Stud1 = new ModelRenderer( this, 26, 30 );
        Primary_Engine_Stud1.setTextureSize( 128, 128 );
        Primary_Engine_Stud1.addBox( 0.5F, 1F, 0.5F, 1, 2, 1);
        Primary_Engine_Stud1.setRotationPoint( 1F, -2.1F, 11.1F );
        Primary_Engine_Stud2 = new ModelRenderer( this, 30, 30 );
        Primary_Engine_Stud2.setTextureSize( 128, 128 );
        Primary_Engine_Stud2.addBox( -1.5F, 1F, 0.5F, 1, 2, 1);
        Primary_Engine_Stud2.setRotationPoint( -1F, -2.1F, 11.1F );
        Primary_Engine_Stud3 = new ModelRenderer( this, 26, 33 );
        Primary_Engine_Stud3.setTextureSize( 128, 128 );
        Primary_Engine_Stud3.addBox( -1.5F, 1.5F, 0F, 1, 1, 2);
        Primary_Engine_Stud3.setRotationPoint( -1F, 2.4F, 15.6F );
        Primary_Engine_Stud4 = new ModelRenderer( this, 32, 33 );
        Primary_Engine_Stud4.setTextureSize( 128, 128 );
        Primary_Engine_Stud4.addBox( 0.5F, 1.5F, 0F, 1, 1, 2);
        Primary_Engine_Stud4.setRotationPoint( 1F, 2.4F, 15.6F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Primary_Engine_Stud1.rotateAngleX = 0F;
        Primary_Engine_Stud1.rotateAngleY = 0F;
        Primary_Engine_Stud1.rotateAngleZ = 0F;
        Primary_Engine_Stud1.renderWithRotation(par7);

        Primary_Engine_Stud2.rotateAngleX = 0F;
        Primary_Engine_Stud2.rotateAngleY = 0F;
        Primary_Engine_Stud2.rotateAngleZ = 0F;
        Primary_Engine_Stud2.renderWithRotation(par7);

        Primary_Engine_Stud3.rotateAngleX = 0F;
        Primary_Engine_Stud3.rotateAngleY = 0F;
        Primary_Engine_Stud3.rotateAngleZ = 0F;
        Primary_Engine_Stud3.renderWithRotation(par7);

        Primary_Engine_Stud4.rotateAngleX = 0F;
        Primary_Engine_Stud4.rotateAngleY = 0F;
        Primary_Engine_Stud4.rotateAngleZ = 0F;
        Primary_Engine_Stud4.renderWithRotation(par7);

    }

}
