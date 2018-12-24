package com.vies.viesmachines.client.entity.machines.flying.models.airship;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipFrameSkids extends ModelBase
{
    ModelRenderer Frame_Skid_Brace_Left_Front;
    ModelRenderer Frame_Skid_Brace_Left_Back;
    ModelRenderer Frame_Skid_Bottom_Left;
    ModelRenderer Frame_Skid_Brace_Right_Front;
    ModelRenderer Frame_Skid_Brace_Right_Back;
    ModelRenderer Frame_Skid_Bottom_Right;

    public ModelAirshipFrameSkids()
    {
        this( 0.0f );
    }

    public ModelAirshipFrameSkids( float par1 )
    {
        Frame_Skid_Brace_Left_Front = new ModelRenderer( this, 0, 18 );
        Frame_Skid_Brace_Left_Front.setTextureSize( 128, 128 );
        Frame_Skid_Brace_Left_Front.addBox( -1F, -0.5F, -1F, 2, 4, 2);
        Frame_Skid_Brace_Left_Front.setRotationPoint( 6F, 6F, -7F );
        Frame_Skid_Brace_Left_Back = new ModelRenderer( this, 8, 18 );
        Frame_Skid_Brace_Left_Back.setTextureSize( 128, 128 );
        Frame_Skid_Brace_Left_Back.addBox( -1F, -0.5F, -1F, 2, 4, 2);
        Frame_Skid_Brace_Left_Back.setRotationPoint( 6.000001F, 6F, 7F );
        Frame_Skid_Bottom_Left = new ModelRenderer( this, 8, 0 );
        Frame_Skid_Bottom_Left.setTextureSize( 128, 128 );
        Frame_Skid_Bottom_Left.addBox( -2F, 0F, 0F, 4, 1, 24);
        Frame_Skid_Bottom_Left.setRotationPoint( 6F, 9F, -12F );
        Frame_Skid_Brace_Right_Front = new ModelRenderer( this, 16, 18 );
        Frame_Skid_Brace_Right_Front.setTextureSize( 128, 128 );
        Frame_Skid_Brace_Right_Front.addBox( -1F, -0.5F, -1F, 2, 4, 2);
        Frame_Skid_Brace_Right_Front.setRotationPoint( -6F, 6F, -7F );
        Frame_Skid_Brace_Right_Back = new ModelRenderer( this, 24, 18 );
        Frame_Skid_Brace_Right_Back.setTextureSize( 128, 128 );
        Frame_Skid_Brace_Right_Back.addBox( -1F, -0.5F, -1F, 2, 4, 2);
        Frame_Skid_Brace_Right_Back.setRotationPoint( -6F, 6F, 7F );
        Frame_Skid_Bottom_Right = new ModelRenderer( this, 8, 0 );
        Frame_Skid_Bottom_Right.setTextureSize( 128, 128 );
        Frame_Skid_Bottom_Right.addBox( -2F, 0F, 0F, 4, 1, 24);
        Frame_Skid_Bottom_Right.setRotationPoint( -6F, 9F, -12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Frame_Skid_Brace_Left_Front.rotateAngleX = 0F;
        Frame_Skid_Brace_Left_Front.rotateAngleY = -0.7853982F;
        Frame_Skid_Brace_Left_Front.rotateAngleZ = 0F;
        Frame_Skid_Brace_Left_Front.renderWithRotation(par7);

        Frame_Skid_Brace_Left_Back.rotateAngleX = 0F;
        Frame_Skid_Brace_Left_Back.rotateAngleY = -0.7853983F;
        Frame_Skid_Brace_Left_Back.rotateAngleZ = 0F;
        Frame_Skid_Brace_Left_Back.renderWithRotation(par7);

        Frame_Skid_Bottom_Left.rotateAngleX = 0F;
        Frame_Skid_Bottom_Left.rotateAngleY = 0F;
        Frame_Skid_Bottom_Left.rotateAngleZ = 0F;
        Frame_Skid_Bottom_Left.renderWithRotation(par7);

        Frame_Skid_Brace_Right_Front.rotateAngleX = 0F;
        Frame_Skid_Brace_Right_Front.rotateAngleY = -0.7853982F;
        Frame_Skid_Brace_Right_Front.rotateAngleZ = 0F;
        Frame_Skid_Brace_Right_Front.renderWithRotation(par7);

        Frame_Skid_Brace_Right_Back.rotateAngleX = 0F;
        Frame_Skid_Brace_Right_Back.rotateAngleY = -0.7853982F;
        Frame_Skid_Brace_Right_Back.rotateAngleZ = 0F;
        Frame_Skid_Brace_Right_Back.renderWithRotation(par7);

        Frame_Skid_Bottom_Right.rotateAngleX = 0F;
        Frame_Skid_Bottom_Right.rotateAngleY = 0F;
        Frame_Skid_Bottom_Right.rotateAngleZ = 0F;
        Frame_Skid_Bottom_Right.renderWithRotation(par7);

    }

}
