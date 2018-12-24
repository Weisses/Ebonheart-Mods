package com.vies.viesmachines.client.entity.machines.flying.models.airship.engine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipEngine0Secondary extends ModelBase
{
    ModelRenderer Primary_Engine_Stud1;
    ModelRenderer Primary_Engine_Stud2;

    public ModelAirshipEngine0Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipEngine0Secondary( float par1 )
    {
        Primary_Engine_Stud1 = new ModelRenderer( this, 0, 12 );
        Primary_Engine_Stud1.setTextureSize( 128, 128 );
        Primary_Engine_Stud1.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 5);
        Primary_Engine_Stud1.setRotationPoint( 1F, 1.299999F, 14.6F );
        Primary_Engine_Stud2 = new ModelRenderer( this, 12, 12 );
        Primary_Engine_Stud2.setTextureSize( 128, 128 );
        Primary_Engine_Stud2.addBox( -0.5F, -0.5F, -2.5F, 1, 1, 5);
        Primary_Engine_Stud2.setRotationPoint( -1F, 1.299999F, 14.6F );
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

    }

}
