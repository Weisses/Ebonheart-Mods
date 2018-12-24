package com.vies.viesmachines.client.entity.machines.flying.models.airship.frame;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipFrame1Secondary extends ModelBase {
	
    ModelRenderer Secondary_Floor_Top;
    
    public ModelAirshipFrame1Secondary()
    {
        this( 0.0f );
    }

    public ModelAirshipFrame1Secondary( float par1 )
    {
        Secondary_Floor_Top = new ModelRenderer( this, 70, 0 );
        Secondary_Floor_Top.setTextureSize( 128, 128 );
        Secondary_Floor_Top.addBox( -1F, 1F, -1F, 16, 0, 26);
        Secondary_Floor_Top.setRotationPoint( -7F, 2.9F, -12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Secondary_Floor_Top.rotateAngleX = 0F;
        Secondary_Floor_Top.rotateAngleY = 0F;
        Secondary_Floor_Top.rotateAngleZ = 0F;
        Secondary_Floor_Top.renderWithRotation(par7);

    }

}
