package com.vies.viesmachines.client.tileentity.model;

import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelKitFabricator extends ModelBase
{
    ModelRenderer base1;
    ModelRenderer base2;
    ModelRenderer top_mount_item;
    ModelRenderer top_mount;
    ModelRenderer side_right;
    ModelRenderer side_left;
    ModelRenderer side_back;
    ModelRenderer inner_lining_left;
    ModelRenderer inner_lining_right;
    ModelRenderer inner_lining_back;
    ModelRenderer inner_lining_top;
    ModelRenderer inner_lining_bottom;
    ModelRenderer glass_case_stand;
    ModelRenderer glass_case;

    public ModelKitFabricator()
    {
        this( 0.0f );
    }

    public ModelKitFabricator( float par1 )
    {
        base1 = new ModelRenderer( this, 0, 16 );
        base1.setTextureSize( 64, 64 );
        base1.addBox( -7F, -1.5F, -5F, 14, 3, 10);
        base1.setRotationPoint( 0F, 22.49F, 0.01F );
        base2 = new ModelRenderer( this, 0, 33 );
        base2.setTextureSize( 64, 64 );
        base2.addBox( -6.5F, -1F, -2F, 13, 2, 4);
        base2.setRotationPoint( 0F, 22.95F, -6F );
        top_mount_item = new ModelRenderer( this, 18, 43 );
        top_mount_item.setTextureSize( 64, 64 );
        top_mount_item.addBox( -2F, -2F, -0.5F, 4, 4, 1);
        top_mount_item.setRotationPoint( 0F, 10.45F, -5.99F );
        top_mount = new ModelRenderer( this, 28, 29 );
        top_mount.setTextureSize( 64, 64 );
        top_mount.addBox( -4F, -2.5F, -5F, 8, 5, 10);
        top_mount.setRotationPoint( 0F, 10.45F, -0.99F );
        side_right = new ModelRenderer( this, 0, 39 );
        side_right.setTextureSize( 64, 64 );
        side_right.addBox( -2F, -8F, -4.5F, 4, 16, 9);
        side_right.setRotationPoint( 6F, 15.95F, -0.5F );
        side_left = new ModelRenderer( this, 0, 39 );
        side_left.setTextureSize( 64, 64 );
        side_left.addBox( -2F, -8F, -4.5F, 4, 16, 9);
        side_left.setRotationPoint( -6F, 15.95F, -0.5F );
        side_back = new ModelRenderer( this, 24, 44 );
        side_back.setTextureSize( 64, 64 );
        side_back.addBox( -8F, -8F, -2F, 16, 16, 4);
        side_back.setRotationPoint( 0F, 15.95F, 6F );
        inner_lining_left = new ModelRenderer( this, 46, -9 );
        inner_lining_left.setTextureSize( 64, 64 );
        inner_lining_left.addBox( 0F, -4F, -4.5F, 0, 8, 9);
        inner_lining_left.setRotationPoint( -3.99F, 16.95F, 0.1F );
        inner_lining_right = new ModelRenderer( this, 46, -9 );
        inner_lining_right.setTextureSize( 64, 64 );
        inner_lining_right.addBox( 0F, -4F, -4.5F, 0, 8, 9);
        inner_lining_right.setRotationPoint( 3.99F, 16.95F, 0.1F );
        inner_lining_back = new ModelRenderer( this, 47, 0 );
        inner_lining_back.setTextureSize( 64, 64 );
        inner_lining_back.addBox( -4F, -4F, 0F, 8, 8, 0);
        inner_lining_back.setRotationPoint( 0F, 16.95F, 3.99F );
        inner_lining_top = new ModelRenderer( this, 38, 0 );
        inner_lining_top.setTextureSize( 64, 64 );
        inner_lining_top.addBox( -4F, 0F, -4.5F, 8, 0, 9);
        inner_lining_top.setRotationPoint( 0F, 13.01F, 0.1F );
        inner_lining_bottom = new ModelRenderer( this, 38, 0 );
        inner_lining_bottom.setTextureSize( 64, 64 );
        inner_lining_bottom.addBox( -4F, 0F, -4.5F, 8, 0, 9);
        inner_lining_bottom.setRotationPoint( 0F, 20.95F, 0.1F );
        glass_case_stand = new ModelRenderer( this, 48, 23 );
        glass_case_stand.setTextureSize( 64, 64 );
        glass_case_stand.addBox( -2F, -1F, -2F, 4, 2, 4);
        glass_case_stand.setRotationPoint( 0F, 21F, 0F );
        glass_case = new ModelRenderer( this, -1, -1 );
        glass_case.setTextureSize( 64, 64 );
        glass_case.addBox( -4F, -4F, -4.5F, 8, 8, 9);
        glass_case.setRotationPoint( 0F, 16.95F, 0F );
    }

   public void render(TileEntityKitFabricator te, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        base1.rotateAngleX = 0F;
        base1.rotateAngleY = 0F;
        base1.rotateAngleZ = 0F;
        base1.renderWithRotation(par7);

        base2.rotateAngleX = 0F;
        base2.rotateAngleY = 0F;
        base2.rotateAngleZ = 0F;
        base2.renderWithRotation(par7);

        top_mount_item.rotateAngleX = 0F;
        top_mount_item.rotateAngleY = 0F;
        top_mount_item.rotateAngleZ = 0F;
        top_mount_item.renderWithRotation(par7);

        top_mount.rotateAngleX = 0F;
        top_mount.rotateAngleY = 0F;
        top_mount.rotateAngleZ = 0F;
        top_mount.renderWithRotation(par7);

        side_right.rotateAngleX = 0F;
        side_right.rotateAngleY = 0F;
        side_right.rotateAngleZ = 0F;
        side_right.renderWithRotation(par7);

        side_left.rotateAngleX = 0F;
        side_left.rotateAngleY = 0F;
        side_left.rotateAngleZ = 0F;
        side_left.renderWithRotation(par7);

        side_back.rotateAngleX = 0F;
        side_back.rotateAngleY = 0F;
        side_back.rotateAngleZ = 0F;
        side_back.renderWithRotation(par7);

        inner_lining_left.rotateAngleX = 0F;
        inner_lining_left.rotateAngleY = 0F;
        inner_lining_left.rotateAngleZ = 0F;
        inner_lining_left.renderWithRotation(par7);

        inner_lining_right.rotateAngleX = 0F;
        inner_lining_right.rotateAngleY = 0F;
        inner_lining_right.rotateAngleZ = 0F;
        inner_lining_right.renderWithRotation(par7);

        inner_lining_back.rotateAngleX = 0F;
        inner_lining_back.rotateAngleY = 0F;
        inner_lining_back.rotateAngleZ = 0F;
        inner_lining_back.renderWithRotation(par7);

        inner_lining_top.rotateAngleX = 0F;
        inner_lining_top.rotateAngleY = 0F;
        inner_lining_top.rotateAngleZ = 0F;
        inner_lining_top.renderWithRotation(par7);

        inner_lining_bottom.rotateAngleX = 0F;
        inner_lining_bottom.rotateAngleY = 0F;
        inner_lining_bottom.rotateAngleZ = 0F;
        inner_lining_bottom.renderWithRotation(par7);

        glass_case_stand.rotateAngleX = 0F;
        glass_case_stand.rotateAngleY = 0F;
        glass_case_stand.rotateAngleZ = 0F;
        glass_case_stand.renderWithRotation(par7);

        glass_case.rotateAngleX = 0F;
        glass_case.rotateAngleY = 0F;
        glass_case.rotateAngleZ = 0F;
        glass_case.renderWithRotation(par7);

    }

}
