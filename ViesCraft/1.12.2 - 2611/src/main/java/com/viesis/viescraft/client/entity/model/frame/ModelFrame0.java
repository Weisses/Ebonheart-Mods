package com.viesis.viescraft.client.entity.model.frame;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelFrame0 extends ModelBase
{
    ModelRenderer Floor_Latch;
    ModelRenderer Floor_Top;
    ModelRenderer Floor_Bottom;
    ModelRenderer Bomb_Bay;
    ModelRenderer Seat_Driver;
    ModelRenderer Side_Left_1;
    ModelRenderer Side_Left_2;
    ModelRenderer Side_Right_1;
    ModelRenderer Side_Right_2;
    ModelRenderer Side_Front_1;
    ModelRenderer Side_Front_2;
    ModelRenderer Side_Front_3;
    ModelRenderer Side_Edge_Left_Front;
    ModelRenderer Side_Edge_Right_Front;
    ModelRenderer Side_Back_1;
    ModelRenderer Side_Back_2;
    ModelRenderer Control_Panel;
    ModelRenderer Control_Brace;
    ModelRenderer Skid_Brace_Right_Front;
    ModelRenderer Skid_Brace_Right_Back;
    ModelRenderer Skid_Bottom_Right;
    ModelRenderer Skid_Brace_Left_Front;
    ModelRenderer Skid_Brace_Left_Back;
    ModelRenderer Skid_Bottom_Left;

    public ModelFrame0()
    {
        this( 0.0f );
    }

    public ModelFrame0( float par1 )
    {
        Floor_Latch = new ModelRenderer( this, 0, 36 );
        Floor_Latch.setTextureSize( 128, 128 );
        Floor_Latch.addBox( 0F, 0F, 0F, 10, 2, 8);
        Floor_Latch.setRotationPoint( -5F, 4F, 3F );
        Floor_Top = new ModelRenderer( this, 47, 27 );
        Floor_Top.setTextureSize( 128, 128 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        Floor_Bottom = new ModelRenderer( this, 0, 0 );
        Floor_Bottom.setTextureSize( 128, 128 );
        Floor_Bottom.addBox( 0F, 0.5F, -0.5F, 14, 1, 25);
        Floor_Bottom.setRotationPoint( -7F, 5.5F, -12.5F );
        Bomb_Bay = new ModelRenderer( this, 2, 46 );
        Bomb_Bay.setTextureSize( 128, 128 );
        Bomb_Bay.addBox( -4F, -0.5F, -4F, 8, 1, 8);
        Bomb_Bay.setRotationPoint( 0F, 7F, 0F );
        Seat_Driver = new ModelRenderer( this, 0, 26 );
        Seat_Driver.setTextureSize( 128, 128 );
        Seat_Driver.addBox( 0F, 0F, 0F, 10, 2, 8);
        Seat_Driver.setRotationPoint( -5F, 4F, -6F );
        Side_Left_1 = new ModelRenderer( this, 13, 59 );
        Side_Left_1.setTextureSize( 128, 128 );
        Side_Left_1.addBox( 0F, 0F, 0F, 1, 2, 24);
        Side_Left_1.setRotationPoint( 7F, 4F, -12F );
        Side_Left_2 = new ModelRenderer( this, 11, 29 );
        Side_Left_2.setTextureSize( 128, 128 );
        Side_Left_2.addBox( 0F, 0F, 0F, 1, 4, 26);
        Side_Left_2.setRotationPoint( 8F, 1F, -13F );
        Side_Right_1 = new ModelRenderer( this, 13, 59 );
        Side_Right_1.setTextureSize( 128, 128 );
        Side_Right_1.addBox( 0F, 0F, 0F, 1, 2, 24);
        Side_Right_1.setRotationPoint( -8F, 4F, -12F );
        Side_Right_2 = new ModelRenderer( this, 11, 29 );
        Side_Right_2.setTextureSize( 128, 128 );
        Side_Right_2.addBox( 0F, 0F, 0F, 1, 4, 26);
        Side_Right_2.setRotationPoint( -9F, 1F, -13F );
        Side_Front_1 = new ModelRenderer( this, 0, 69 );
        Side_Front_1.setTextureSize( 128, 128 );
        Side_Front_1.addBox( 0F, 0F, 0F, 16, 2, 1);
        Side_Front_1.setRotationPoint( -8F, 4F, -13F );
        Side_Front_2 = new ModelRenderer( this, 2, 75 );
        Side_Front_2.setTextureSize( 128, 128 );
        Side_Front_2.addBox( 0F, 0F, 0F, 14, 2, 1);
        Side_Front_2.setRotationPoint( -7F, 4F, -14F );
        Side_Front_3 = new ModelRenderer( this, 2, 59 );
        Side_Front_3.setTextureSize( 128, 128 );
        Side_Front_3.addBox( 0F, 0F, 0F, 14, 4, 1);
        Side_Front_3.setRotationPoint( -7F, 1F, -15F );
        Side_Edge_Left_Front = new ModelRenderer( this, 32, 77 );
        Side_Edge_Left_Front.setTextureSize( 128, 128 );
        Side_Edge_Left_Front.addBox( 0F, 0F, 0F, 1, 4, 1);
        Side_Edge_Left_Front.setRotationPoint( 7F, 1F, -14F );
        Side_Edge_Right_Front = new ModelRenderer( this, 32, 77 );
        Side_Edge_Right_Front.setTextureSize( 128, 128 );
        Side_Edge_Right_Front.addBox( 0F, 0F, 0F, 1, 4, 1);
        Side_Edge_Right_Front.setRotationPoint( -8F, 1F, -14F );
        Side_Back_1 = new ModelRenderer( this, 0, 72 );
        Side_Back_1.setTextureSize( 128, 128 );
        Side_Back_1.addBox( 0F, 0F, 0F, 16, 2, 1);
        Side_Back_1.setRotationPoint( -8F, 4F, 12F );
        Side_Back_2 = new ModelRenderer( this, 0, 64 );
        Side_Back_2.setTextureSize( 128, 128 );
        Side_Back_2.addBox( 0F, 0F, 0F, 16, 4, 1);
        Side_Back_2.setRotationPoint( -8F, 1F, 13F );
        Control_Panel = new ModelRenderer( this, 0, 0 );
        Control_Panel.setTextureSize( 128, 128 );
        Control_Panel.addBox( 0F, 0F, 0F, 7, 5, 1);
        Control_Panel.setRotationPoint( -3.5F, -1F, -16F );
        Control_Brace = new ModelRenderer( this, 1, 6 );
        Control_Brace.setTextureSize( 128, 128 );
        Control_Brace.addBox( -0.5F, 0F, 0F, 6, 4, 1);
        Control_Brace.setRotationPoint( -2.5F, -0.5F, -15.5F );
        Skid_Brace_Right_Front = new ModelRenderer( this, 26, 103 );
        Skid_Brace_Right_Front.setTextureSize( 128, 128 );
        Skid_Brace_Right_Front.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_Right_Front.setRotationPoint( -6F, 6F, -7F );
        Skid_Brace_Right_Back = new ModelRenderer( this, 26, 103 );
        Skid_Brace_Right_Back.setTextureSize( 128, 128 );
        Skid_Brace_Right_Back.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_Right_Back.setRotationPoint( -6F, 6F, 7F );
        Skid_Bottom_Right = new ModelRenderer( this, 11, 85 );
        Skid_Bottom_Right.setTextureSize( 128, 128 );
        Skid_Bottom_Right.addBox( -2F, 0F, 0F, 4, 1, 24);
        Skid_Bottom_Right.setRotationPoint( -6F, 9F, -12F );
        Skid_Brace_Left_Front = new ModelRenderer( this, 26, 103 );
        Skid_Brace_Left_Front.setTextureSize( 128, 128 );
        Skid_Brace_Left_Front.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_Left_Front.setRotationPoint( 6F, 6F, -7F );
        Skid_Brace_Left_Back = new ModelRenderer( this, 26, 103 );
        Skid_Brace_Left_Back.setTextureSize( 128, 128 );
        Skid_Brace_Left_Back.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_Left_Back.setRotationPoint( 6F, 6F, 7F );
        Skid_Bottom_Left = new ModelRenderer( this, 11, 85 );
        Skid_Bottom_Left.setTextureSize( 128, 128 );
        Skid_Bottom_Left.addBox( -2F, 0F, 0F, 4, 1, 24);
        Skid_Bottom_Left.setRotationPoint( 6F, 9F, -12F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Floor_Latch.rotateAngleX = 0F;
        Floor_Latch.rotateAngleY = 0F;
        Floor_Latch.rotateAngleZ = 0F;
        Floor_Latch.renderWithRotation(par7);

        Floor_Top.rotateAngleX = 0F;
        Floor_Top.rotateAngleY = 0F;
        Floor_Top.rotateAngleZ = 0F;
        Floor_Top.renderWithRotation(par7);

        Floor_Bottom.rotateAngleX = 0F;
        Floor_Bottom.rotateAngleY = 0F;
        Floor_Bottom.rotateAngleZ = 0F;
        Floor_Bottom.renderWithRotation(par7);

        Bomb_Bay.rotateAngleX = 0F;
        Bomb_Bay.rotateAngleY = 0F;
        Bomb_Bay.rotateAngleZ = 0F;
        Bomb_Bay.renderWithRotation(par7);

        Seat_Driver.rotateAngleX = 0F;
        Seat_Driver.rotateAngleY = 0F;
        Seat_Driver.rotateAngleZ = 0F;
        Seat_Driver.renderWithRotation(par7);

        Side_Left_1.rotateAngleX = 0F;
        Side_Left_1.rotateAngleY = 0F;
        Side_Left_1.rotateAngleZ = 0F;
        Side_Left_1.renderWithRotation(par7);

        Side_Left_2.rotateAngleX = 0F;
        Side_Left_2.rotateAngleY = 0F;
        Side_Left_2.rotateAngleZ = 0F;
        Side_Left_2.renderWithRotation(par7);

        Side_Right_1.rotateAngleX = 0F;
        Side_Right_1.rotateAngleY = 0F;
        Side_Right_1.rotateAngleZ = 0F;
        Side_Right_1.renderWithRotation(par7);

        Side_Right_2.rotateAngleX = 0F;
        Side_Right_2.rotateAngleY = 0F;
        Side_Right_2.rotateAngleZ = 0F;
        Side_Right_2.renderWithRotation(par7);

        Side_Front_1.rotateAngleX = 0F;
        Side_Front_1.rotateAngleY = 0F;
        Side_Front_1.rotateAngleZ = 0F;
        Side_Front_1.renderWithRotation(par7);

        Side_Front_2.rotateAngleX = 0F;
        Side_Front_2.rotateAngleY = 0F;
        Side_Front_2.rotateAngleZ = 0F;
        Side_Front_2.renderWithRotation(par7);

        Side_Front_3.rotateAngleX = 0F;
        Side_Front_3.rotateAngleY = 0F;
        Side_Front_3.rotateAngleZ = 0F;
        Side_Front_3.renderWithRotation(par7);

        Side_Edge_Left_Front.rotateAngleX = 0F;
        Side_Edge_Left_Front.rotateAngleY = 0F;
        Side_Edge_Left_Front.rotateAngleZ = 0F;
        Side_Edge_Left_Front.renderWithRotation(par7);

        Side_Edge_Right_Front.rotateAngleX = 0F;
        Side_Edge_Right_Front.rotateAngleY = 0F;
        Side_Edge_Right_Front.rotateAngleZ = 0F;
        Side_Edge_Right_Front.renderWithRotation(par7);

        Side_Back_1.rotateAngleX = 0F;
        Side_Back_1.rotateAngleY = 0F;
        Side_Back_1.rotateAngleZ = 0F;
        Side_Back_1.renderWithRotation(par7);

        Side_Back_2.rotateAngleX = 0F;
        Side_Back_2.rotateAngleY = 0F;
        Side_Back_2.rotateAngleZ = 0F;
        Side_Back_2.renderWithRotation(par7);

        Control_Panel.rotateAngleX = 0.7853982F;
        Control_Panel.rotateAngleY = 0F;
        Control_Panel.rotateAngleZ = 0F;
        Control_Panel.renderWithRotation(par7);

        Control_Brace.rotateAngleX = 0F;
        Control_Brace.rotateAngleY = 0F;
        Control_Brace.rotateAngleZ = 0F;
        Control_Brace.renderWithRotation(par7);

        Skid_Brace_Right_Front.rotateAngleX = 0F;
        Skid_Brace_Right_Front.rotateAngleY = -0.7853982F;
        Skid_Brace_Right_Front.rotateAngleZ = 0F;
        Skid_Brace_Right_Front.renderWithRotation(par7);

        Skid_Brace_Right_Back.rotateAngleX = 0F;
        Skid_Brace_Right_Back.rotateAngleY = -0.7853982F;
        Skid_Brace_Right_Back.rotateAngleZ = 0F;
        Skid_Brace_Right_Back.renderWithRotation(par7);

        Skid_Bottom_Right.rotateAngleX = 0F;
        Skid_Bottom_Right.rotateAngleY = 0F;
        Skid_Bottom_Right.rotateAngleZ = 0F;
        Skid_Bottom_Right.renderWithRotation(par7);

        Skid_Brace_Left_Front.rotateAngleX = 0F;
        Skid_Brace_Left_Front.rotateAngleY = -0.7853982F;
        Skid_Brace_Left_Front.rotateAngleZ = 0F;
        Skid_Brace_Left_Front.renderWithRotation(par7);

        Skid_Brace_Left_Back.rotateAngleX = 0F;
        Skid_Brace_Left_Back.rotateAngleY = -0.7853982F;
        Skid_Brace_Left_Back.rotateAngleZ = 0F;
        Skid_Brace_Left_Back.renderWithRotation(par7);

        Skid_Bottom_Left.rotateAngleX = 0F;
        Skid_Bottom_Left.rotateAngleY = 0F;
        Skid_Bottom_Left.rotateAngleZ = 0F;
        Skid_Bottom_Left.renderWithRotation(par7);

    }

}
