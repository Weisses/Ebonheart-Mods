package com.vies.viesmachines.client.tileentity.model;

import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelKitFabricatorPowered extends ModelBase
{
    ModelRenderer powered_indicator_top;
    ModelRenderer powered_indicator_side_left;
    ModelRenderer powered_indicator_side_right;

    public ModelKitFabricatorPowered()
    {
        this( 0.0f );
    }

    public ModelKitFabricatorPowered( float par1 )
    {
        powered_indicator_top = new ModelRenderer( this, 8, 0 );
        powered_indicator_top.setTextureSize( 32, 16 );
        powered_indicator_top.addBox( -2F, -1F, -2F, 4, 2, 4);
        powered_indicator_top.setRotationPoint( 0F, 8F, 0F );
        powered_indicator_side_left = new ModelRenderer( this, 0, 0 );
        powered_indicator_side_left.setTextureSize( 32, 16 );
        powered_indicator_side_left.addBox( -1F, -6F, -1F, 2, 12, 2);
        powered_indicator_side_left.setRotationPoint( -6F, 15F, -5F );
        powered_indicator_side_right = new ModelRenderer( this, 0, 0 );
        powered_indicator_side_right.setTextureSize( 32, 16 );
        powered_indicator_side_right.addBox( -1F, -6F, -1F, 2, 12, 2);
        powered_indicator_side_right.setRotationPoint( 6F, 15F, -5F );
    }

   public void render(TileEntityKitFabricator te, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        powered_indicator_top.rotateAngleX = 0F;
        powered_indicator_top.rotateAngleY = 0F;
        powered_indicator_top.rotateAngleZ = 0F;
        powered_indicator_top.renderWithRotation(par7);

        powered_indicator_side_left.rotateAngleX = 0F;
        powered_indicator_side_left.rotateAngleY = 0F;
        powered_indicator_side_left.rotateAngleZ = 0F;
        powered_indicator_side_left.renderWithRotation(par7);

        powered_indicator_side_right.rotateAngleX = 0F;
        powered_indicator_side_right.rotateAngleY = 0F;
        powered_indicator_side_right.rotateAngleZ = 0F;
        powered_indicator_side_right.renderWithRotation(par7);

    }

}
