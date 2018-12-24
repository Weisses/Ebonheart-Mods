package com.vies.viesmachines.client.entity.machines.flying.models.airship;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipFrameDisplayBannerStand extends ModelBase
{
    ModelRenderer Display_Stand_Base;
    ModelRenderer Display_Stand_Top;

    public ModelAirshipFrameDisplayBannerStand()
    {
        this( 0.0f );
    }

    public ModelAirshipFrameDisplayBannerStand( float par1 )
    {
        Display_Stand_Base = new ModelRenderer( this, 16, 0 );
        Display_Stand_Base.setTextureSize( 128, 128 );
        Display_Stand_Base.addBox( -1F, -2F, -1F, 2, 4, 2);
        Display_Stand_Base.setRotationPoint( -6F, 2F, -13F );
        Display_Stand_Top = new ModelRenderer( this, 22, 0 );
        Display_Stand_Top.setTextureSize( 128, 128 );
        Display_Stand_Top.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Display_Stand_Top.setRotationPoint( -6F, 0F, -13F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        
        Display_Stand_Base.rotateAngleX = 0F;
        Display_Stand_Base.rotateAngleY = 0F;
        Display_Stand_Base.rotateAngleZ = 0F;
        Display_Stand_Base.renderWithRotation(par7);

        Display_Stand_Top.rotateAngleX = 0F;
        Display_Stand_Top.rotateAngleY = 0F;
        Display_Stand_Top.rotateAngleZ = 0F;
        Display_Stand_Top.renderWithRotation(par7);


    }

}
