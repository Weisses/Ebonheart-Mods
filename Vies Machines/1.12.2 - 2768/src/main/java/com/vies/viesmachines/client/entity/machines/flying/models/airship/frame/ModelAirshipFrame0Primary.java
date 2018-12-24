package com.vies.viesmachines.client.entity.machines.flying.models.airship.frame;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipFrame0Primary extends ModelBase
{
    ModelRenderer Primary_Control_Panel;
    ModelRenderer Primary_Control_Brace;
    ModelRenderer Primary_Floor_Top_1;
    ModelRenderer Primary_Floor_Top_1a;
    ModelRenderer Primary_Floor_Top_2;
    ModelRenderer Primary_Floor_Top_2aLeft;
    ModelRenderer Primary_Floor_Top_2aRight;
    ModelRenderer Primary_Floor_Top_3;
    ModelRenderer Primary_Floor_Top_3a;
    ModelRenderer Primary_Floor_Bottom;
    ModelRenderer Primary_Side_Front_1;
    ModelRenderer Primary_Side_Right_1;
    ModelRenderer Primary_Side_Right_12;
    ModelRenderer Primary_Side_Right_123;
    ModelRenderer Primary_Side_Left_1;
    ModelRenderer Primary_Side_Left_12;
    ModelRenderer Primary_Side_Left_123;
    ModelRenderer Primary_Side_Back_1;
    ModelRenderer Primary_Side_Edge_Front_Left;
    ModelRenderer Primary_Side_Edge_Front_Left_a;
    ModelRenderer Primary_Side_Edge_Front_Left_b;
    ModelRenderer Primary_Side_Edge_Front_Left_2;
    ModelRenderer Primary_Side_Edge_Front_Left_3;
    ModelRenderer Primary_Side_Edge_Front_Right;
    ModelRenderer Primary_Side_Edge_Front_Right_a;
    ModelRenderer Primary_Side_Edge_Front_Right_b;
    ModelRenderer Primary_Side_Edge_Front_Right_2;
    ModelRenderer Primary_Side_Edge_Front_Right_3;
    ModelRenderer Primary_Side_Edge_Back_Left;
    ModelRenderer Primary_Side_Edge_Back_Left_a;
    ModelRenderer Primary_Side_Edge_Back_Left_b;
    ModelRenderer Primary_Side_Edge_Back_Left_2;
    ModelRenderer Primary_Side_Edge_Back_Left_3;
    ModelRenderer Primary_Side_Edge_Back_Right;
    ModelRenderer Primary_Side_Edge_Back_Right_a;
    ModelRenderer Primary_Side_Edge_Back_Right_b;
    ModelRenderer Primary_Side_Edge_Back_Right_2;
    ModelRenderer Primary_Side_Edge_Back_Right_3;
    //ModelRenderer Display_Stand_Base;
    //ModelRenderer Display_Stand_Top;

    public ModelAirshipFrame0Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipFrame0Primary( float par1 )
    {
        Primary_Control_Panel = new ModelRenderer( this, 0, 0 );
        Primary_Control_Panel.setTextureSize( 128, 128 );
        Primary_Control_Panel.addBox( 0F, 0F, 0F, 7, 5, 1);
        Primary_Control_Panel.setRotationPoint( -3.5F, -1.700001F, -16F );
        Primary_Control_Brace = new ModelRenderer( this, 0, 6 );
        Primary_Control_Brace.setTextureSize( 128, 128 );
        Primary_Control_Brace.addBox( -0.5F, 0.5F, 0F, 6, 3, 1);
        Primary_Control_Brace.setRotationPoint( -2.5F, -2F, -15.5F );
        Primary_Floor_Top_1 = new ModelRenderer( this, 0, 10 );
        Primary_Floor_Top_1.setTextureSize( 128, 128 );
        Primary_Floor_Top_1.addBox( 0F, 0.5F, 11.5F, 14, 1, 1);
        Primary_Floor_Top_1.setRotationPoint( -7F, 4F, -25.5F );
        Primary_Floor_Top_1a = new ModelRenderer( this, 0, 12 );
        Primary_Floor_Top_1a.setTextureSize( 128, 128 );
        Primary_Floor_Top_1a.addBox( 0F, 0.5F, 11.5F, 14, 1, 1);
        Primary_Floor_Top_1a.setRotationPoint( -7F, 3F, -25.5F );
        Primary_Floor_Top_2 = new ModelRenderer( this, 44, 37 );
        Primary_Floor_Top_2.setTextureSize( 128, 128 );
        Primary_Floor_Top_2.addBox( -1F, 0.5F, -1F, 16, 1, 26);
        Primary_Floor_Top_2.setRotationPoint( -7F, 4F, -12F );
        Primary_Floor_Top_2aLeft = new ModelRenderer( this, 12, 25 );
        Primary_Floor_Top_2aLeft.setTextureSize( 128, 128 );
        Primary_Floor_Top_2aLeft.addBox( -7.5F, 0.5F, 0F, 1, 1, 24);
        Primary_Floor_Top_2aLeft.setRotationPoint( 15.5F, 3F, -12F );
        Primary_Floor_Top_2aRight = new ModelRenderer( this, 12, 25 );
        Primary_Floor_Top_2aRight.setTextureSize( 128, 128 );
        Primary_Floor_Top_2aRight.addBox( 6.5F, 0.5F, 0F, 1, 1, 24);
        Primary_Floor_Top_2aRight.setRotationPoint( -15.5F, 3F, -12F );
        Primary_Floor_Top_3 = new ModelRenderer( this, 0, 14 );
        Primary_Floor_Top_3.setTextureSize( 128, 128 );
        Primary_Floor_Top_3.addBox( 0F, 0.5F, -12.5F, 14, 1, 1);
        Primary_Floor_Top_3.setRotationPoint( -7F, 4F, 25.5F );
        Primary_Floor_Top_3a = new ModelRenderer( this, 0, 16 );
        Primary_Floor_Top_3a.setTextureSize( 128, 128 );
        Primary_Floor_Top_3a.addBox( 0F, 0.5F, -12.5F, 14, 1, 1);
        Primary_Floor_Top_3a.setRotationPoint( -7F, 3F, 25.5F );
        Primary_Floor_Bottom = new ModelRenderer( this, 0, 101 );
        Primary_Floor_Bottom.setTextureSize( 128, 128 );
        Primary_Floor_Bottom.addBox( 0F, 0.5F, -1F, 14, 1, 26);
        Primary_Floor_Bottom.setRotationPoint( -7F, 5F, -12F );
        Primary_Side_Front_1 = new ModelRenderer( this, 0, 25 );
        Primary_Side_Front_1.setTextureSize( 128, 128 );
        Primary_Side_Front_1.addBox( 0F, 0F, 0F, 14, 4, 1);
        Primary_Side_Front_1.setRotationPoint( -7F, 0.5F, -15F );
        Primary_Side_Right_1 = new ModelRenderer( this, 78, 0 );
        Primary_Side_Right_1.setTextureSize( 128, 128 );
        Primary_Side_Right_1.addBox( 0F, 0F, 1F, 1, 4, 24);
        Primary_Side_Right_1.setRotationPoint( -10F, 0.5F, -13F );
        Primary_Side_Right_12 = new ModelRenderer( this, 40, 4 );
        Primary_Side_Right_12.setTextureSize( 128, 128 );
        Primary_Side_Right_12.addBox( -1F, 1.5F, 1F, 1, 1, 24);
        Primary_Side_Right_12.setRotationPoint( -8F, 3F, -13F );
        Primary_Side_Right_123 = new ModelRenderer( this, 12, 25 );
        Primary_Side_Right_123.setTextureSize( 128, 128 );
        Primary_Side_Right_123.addBox( -1F, 1.5F, 1F, 1, 1, 24);
        Primary_Side_Right_123.setRotationPoint( -7F, 4F, -13F );
        Primary_Side_Left_1 = new ModelRenderer( this, 78, 0 );
        Primary_Side_Left_1.setTextureSize( 128, 128 );
        Primary_Side_Left_1.addBox( 0F, 0F, 1F, 1, 4, 24);
        Primary_Side_Left_1.setRotationPoint( 9F, 0.5F, -13F );
        Primary_Side_Left_12 = new ModelRenderer( this, 40, 4 );
        Primary_Side_Left_12.setTextureSize( 128, 128 );
        Primary_Side_Left_12.addBox( 0F, 1.5F, 1F, 1, 1, 24);
        Primary_Side_Left_12.setRotationPoint( 8F, 3F, -13F );
        Primary_Side_Left_123 = new ModelRenderer( this, 12, 25 );
        Primary_Side_Left_123.setTextureSize( 128, 128 );
        Primary_Side_Left_123.addBox( 0F, 1.5F, 1F, 1, 1, 24);
        Primary_Side_Left_123.setRotationPoint( 7F, 4F, -13F );
        Primary_Side_Back_1 = new ModelRenderer( this, 0, 30 );
        Primary_Side_Back_1.setTextureSize( 128, 128 );
        Primary_Side_Back_1.addBox( -14F, 0F, 0F, 14, 4, 1);
        Primary_Side_Back_1.setRotationPoint( 7F, 0.5F, 14F );
        Primary_Side_Edge_Front_Left = new ModelRenderer( this, 0, 35 );
        Primary_Side_Edge_Front_Left.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Left.addBox( -2F, 0.5F, -0.5F, 4, 3, 1);
        Primary_Side_Edge_Front_Left.setRotationPoint( 8F, 0.5F, -13F );
        Primary_Side_Edge_Front_Left_a = new ModelRenderer( this, 20, 35 );
        Primary_Side_Edge_Front_Left_a.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Left_a.addBox( 0F, -0.5F, 0F, 1, 5, 1);
        Primary_Side_Edge_Front_Left_a.setRotationPoint( 7F, 0F, -14F );
        Primary_Side_Edge_Front_Left_b = new ModelRenderer( this, 24, 35 );
        Primary_Side_Edge_Front_Left_b.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Left_b.addBox( 0F, -0.5F, 0F, 1, 5, 1);
        Primary_Side_Edge_Front_Left_b.setRotationPoint( 8F, 0F, -13F );
        Primary_Side_Edge_Front_Left_2 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Front_Left_2.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Left_2.addBox( -1.5F, 1.5F, -0.5F, 3, 1, 1);
        Primary_Side_Edge_Front_Left_2.setRotationPoint( 7.5F, 2.5F, -12.5F );
        Primary_Side_Edge_Front_Left_3 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Front_Left_3.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Left_3.addBox( -0.5F, 1.5F, -0.5F, 1, 1, 1);
        Primary_Side_Edge_Front_Left_3.setRotationPoint( 7F, 3.5F, -12F );
        Primary_Side_Edge_Front_Right = new ModelRenderer( this, 10, 35 );
        Primary_Side_Edge_Front_Right.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Right.addBox( -2F, 0.5F, -0.5F, 4, 3, 1);
        Primary_Side_Edge_Front_Right.setRotationPoint( -8F, 0.5F, -13F );
        Primary_Side_Edge_Front_Right_a = new ModelRenderer( this, 28, 35 );
        Primary_Side_Edge_Front_Right_a.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Right_a.addBox( -1F, -0.5F, 0F, 1, 5, 1);
        Primary_Side_Edge_Front_Right_a.setRotationPoint( -7F, 0F, -14F );
        Primary_Side_Edge_Front_Right_b = new ModelRenderer( this, 32, 35 );
        Primary_Side_Edge_Front_Right_b.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Right_b.addBox( -1F, -0.5F, 0F, 1, 5, 1);
        Primary_Side_Edge_Front_Right_b.setRotationPoint( -8F, 0F, -13F );
        Primary_Side_Edge_Front_Right_2 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Front_Right_2.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Right_2.addBox( -1.5F, 1.5F, -0.5F, 3, 1, 1);
        Primary_Side_Edge_Front_Right_2.setRotationPoint( -7.5F, 2.5F, -12.5F );
        Primary_Side_Edge_Front_Right_3 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Front_Right_3.setTextureSize( 128, 128 );
        Primary_Side_Edge_Front_Right_3.addBox( -0.5F, 1.5F, -0.5F, 1, 1, 1);
        Primary_Side_Edge_Front_Right_3.setRotationPoint( -7F, 3.5F, -12F );
        Primary_Side_Edge_Back_Left = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Back_Left.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Left.addBox( -2F, 0.5F, -0.5F, 4, 3, 1);
        Primary_Side_Edge_Back_Left.setRotationPoint( 8F, 0.5F, 13F );
        Primary_Side_Edge_Back_Left_a = new ModelRenderer( this, 20, 41 );
        Primary_Side_Edge_Back_Left_a.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Left_a.addBox( 0F, -0.5F, -1F, 1, 5, 1);
        Primary_Side_Edge_Back_Left_a.setRotationPoint( 7F, 0F, 14F );
        Primary_Side_Edge_Back_Left_b = new ModelRenderer( this, 24, 41 );
        Primary_Side_Edge_Back_Left_b.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Left_b.addBox( 0F, -0.5F, -1F, 1, 5, 1);
        Primary_Side_Edge_Back_Left_b.setRotationPoint( 8F, 0F, 13F );
        Primary_Side_Edge_Back_Left_2 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Back_Left_2.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Left_2.addBox( -1.5F, 1.5F, -0.5F, 3, 1, 1);
        Primary_Side_Edge_Back_Left_2.setRotationPoint( 7.5F, 2.5F, 12.5F );
        Primary_Side_Edge_Back_Left_3 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Back_Left_3.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Left_3.addBox( -0.5F, 1.5F, -0.5F, 1, 1, 1);
        Primary_Side_Edge_Back_Left_3.setRotationPoint( 7F, 3.5F, 12F );
        Primary_Side_Edge_Back_Right = new ModelRenderer( this, 10, 39 );
        Primary_Side_Edge_Back_Right.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Right.addBox( -2F, 0.5F, -0.5F, 4, 3, 1);
        Primary_Side_Edge_Back_Right.setRotationPoint( -8F, 0.5F, 13F );
        Primary_Side_Edge_Back_Right_a = new ModelRenderer( this, 28, 41 );
        Primary_Side_Edge_Back_Right_a.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Right_a.addBox( -1F, -0.5F, -1F, 1, 5, 1);
        Primary_Side_Edge_Back_Right_a.setRotationPoint( -7F, 0F, 14F );
        Primary_Side_Edge_Back_Right_b = new ModelRenderer( this, 32, 41 );
        Primary_Side_Edge_Back_Right_b.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Right_b.addBox( -1F, -0.5F, -1F, 1, 5, 1);
        Primary_Side_Edge_Back_Right_b.setRotationPoint( -8F, 0F, 13F );
        Primary_Side_Edge_Back_Right_2 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Back_Right_2.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Right_2.addBox( -1.5F, 1.5F, -0.5F, 3, 1, 1);
        Primary_Side_Edge_Back_Right_2.setRotationPoint( -7.5F, 2.5F, 12.5F );
        Primary_Side_Edge_Back_Right_3 = new ModelRenderer( this, 0, 39 );
        Primary_Side_Edge_Back_Right_3.setTextureSize( 128, 128 );
        Primary_Side_Edge_Back_Right_3.addBox( -0.5F, 1.5F, -0.5F, 1, 1, 1);
        Primary_Side_Edge_Back_Right_3.setRotationPoint( -7F, 3.5F, 12F );
       // Display_Stand_Base = new ModelRenderer( this, 16, 0 );
        //Display_Stand_Base.setTextureSize( 128, 128 );
        //Display_Stand_Base.addBox( -1F, -2F, -1F, 2, 4, 2);
        //Display_Stand_Base.setRotationPoint( -6F, 2F, -13F );
        //Display_Stand_Top = new ModelRenderer( this, 22, 0 );
        //Display_Stand_Top.setTextureSize( 128, 128 );
        //Display_Stand_Top.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        //Display_Stand_Top.setRotationPoint( -6F, 0F, -13F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Primary_Control_Panel.rotateAngleX = 0.7853982F;
        Primary_Control_Panel.rotateAngleY = 0F;
        Primary_Control_Panel.rotateAngleZ = 0F;
        Primary_Control_Panel.renderWithRotation(par7);

        Primary_Control_Brace.rotateAngleX = 0F;
        Primary_Control_Brace.rotateAngleY = 0F;
        Primary_Control_Brace.rotateAngleZ = 0F;
        Primary_Control_Brace.renderWithRotation(par7);

        Primary_Floor_Top_1.rotateAngleX = 0F;
        Primary_Floor_Top_1.rotateAngleY = 0F;
        Primary_Floor_Top_1.rotateAngleZ = 0F;
        Primary_Floor_Top_1.renderWithRotation(par7);

        Primary_Floor_Top_1a.rotateAngleX = 0F;
        Primary_Floor_Top_1a.rotateAngleY = 0F;
        Primary_Floor_Top_1a.rotateAngleZ = 0F;
        Primary_Floor_Top_1a.renderWithRotation(par7);

        Primary_Floor_Top_2.rotateAngleX = 0F;
        Primary_Floor_Top_2.rotateAngleY = 0F;
        Primary_Floor_Top_2.rotateAngleZ = 0F;
        Primary_Floor_Top_2.renderWithRotation(par7);

        Primary_Floor_Top_2aLeft.rotateAngleX = 0F;
        Primary_Floor_Top_2aLeft.rotateAngleY = 0F;
        Primary_Floor_Top_2aLeft.rotateAngleZ = 0F;
        Primary_Floor_Top_2aLeft.renderWithRotation(par7);

        Primary_Floor_Top_2aRight.rotateAngleX = 0F;
        Primary_Floor_Top_2aRight.rotateAngleY = 0F;
        Primary_Floor_Top_2aRight.rotateAngleZ = 0F;
        Primary_Floor_Top_2aRight.renderWithRotation(par7);

        Primary_Floor_Top_3.rotateAngleX = 0F;
        Primary_Floor_Top_3.rotateAngleY = 0F;
        Primary_Floor_Top_3.rotateAngleZ = 0F;
        Primary_Floor_Top_3.renderWithRotation(par7);

        Primary_Floor_Top_3a.rotateAngleX = 0F;
        Primary_Floor_Top_3a.rotateAngleY = 0F;
        Primary_Floor_Top_3a.rotateAngleZ = 0F;
        Primary_Floor_Top_3a.renderWithRotation(par7);

        Primary_Floor_Bottom.rotateAngleX = 0F;
        Primary_Floor_Bottom.rotateAngleY = 0F;
        Primary_Floor_Bottom.rotateAngleZ = 0F;
        Primary_Floor_Bottom.renderWithRotation(par7);

        Primary_Side_Front_1.rotateAngleX = 0F;
        Primary_Side_Front_1.rotateAngleY = 0F;
        Primary_Side_Front_1.rotateAngleZ = 0F;
        Primary_Side_Front_1.renderWithRotation(par7);

        Primary_Side_Right_1.rotateAngleX = 0F;
        Primary_Side_Right_1.rotateAngleY = 0F;
        Primary_Side_Right_1.rotateAngleZ = 0F;
        Primary_Side_Right_1.renderWithRotation(par7);

        Primary_Side_Right_12.rotateAngleX = 0F;
        Primary_Side_Right_12.rotateAngleY = 0F;
        Primary_Side_Right_12.rotateAngleZ = 0F;
        Primary_Side_Right_12.renderWithRotation(par7);

        Primary_Side_Right_123.rotateAngleX = 0F;
        Primary_Side_Right_123.rotateAngleY = 0F;
        Primary_Side_Right_123.rotateAngleZ = 0F;
        Primary_Side_Right_123.renderWithRotation(par7);

        Primary_Side_Left_1.rotateAngleX = 0F;
        Primary_Side_Left_1.rotateAngleY = 0F;
        Primary_Side_Left_1.rotateAngleZ = 0F;
        Primary_Side_Left_1.renderWithRotation(par7);

        Primary_Side_Left_12.rotateAngleX = 0F;
        Primary_Side_Left_12.rotateAngleY = 0F;
        Primary_Side_Left_12.rotateAngleZ = 0F;
        Primary_Side_Left_12.renderWithRotation(par7);

        Primary_Side_Left_123.rotateAngleX = 0F;
        Primary_Side_Left_123.rotateAngleY = 0F;
        Primary_Side_Left_123.rotateAngleZ = 0F;
        Primary_Side_Left_123.renderWithRotation(par7);

        Primary_Side_Back_1.rotateAngleX = 0F;
        Primary_Side_Back_1.rotateAngleY = 0F;
        Primary_Side_Back_1.rotateAngleZ = 0F;
        Primary_Side_Back_1.renderWithRotation(par7);

        Primary_Side_Edge_Front_Left.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Left.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Front_Left.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Left.renderWithRotation(par7);

        Primary_Side_Edge_Front_Left_a.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Left_a.rotateAngleY = 0F;
        Primary_Side_Edge_Front_Left_a.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Left_a.renderWithRotation(par7);

        Primary_Side_Edge_Front_Left_b.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Left_b.rotateAngleY = 0F;
        Primary_Side_Edge_Front_Left_b.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Left_b.renderWithRotation(par7);

        Primary_Side_Edge_Front_Left_2.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Left_2.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Front_Left_2.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Left_2.renderWithRotation(par7);

        Primary_Side_Edge_Front_Left_3.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Left_3.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Front_Left_3.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Left_3.renderWithRotation(par7);

        Primary_Side_Edge_Front_Right.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Right.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Front_Right.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Right.renderWithRotation(par7);

        Primary_Side_Edge_Front_Right_a.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Right_a.rotateAngleY = 0F;
        Primary_Side_Edge_Front_Right_a.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Right_a.renderWithRotation(par7);

        Primary_Side_Edge_Front_Right_b.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Right_b.rotateAngleY = 0F;
        Primary_Side_Edge_Front_Right_b.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Right_b.renderWithRotation(par7);

        Primary_Side_Edge_Front_Right_2.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Right_2.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Front_Right_2.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Right_2.renderWithRotation(par7);

        Primary_Side_Edge_Front_Right_3.rotateAngleX = 0F;
        Primary_Side_Edge_Front_Right_3.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Front_Right_3.rotateAngleZ = 0F;
        Primary_Side_Edge_Front_Right_3.renderWithRotation(par7);

        Primary_Side_Edge_Back_Left.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Left.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Back_Left.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Left.renderWithRotation(par7);

        Primary_Side_Edge_Back_Left_a.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Left_a.rotateAngleY = 0F;
        Primary_Side_Edge_Back_Left_a.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Left_a.renderWithRotation(par7);

        Primary_Side_Edge_Back_Left_b.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Left_b.rotateAngleY = 0F;
        Primary_Side_Edge_Back_Left_b.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Left_b.renderWithRotation(par7);

        Primary_Side_Edge_Back_Left_2.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Left_2.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Back_Left_2.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Left_2.renderWithRotation(par7);

        Primary_Side_Edge_Back_Left_3.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Left_3.rotateAngleY = 0.7853982F;
        Primary_Side_Edge_Back_Left_3.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Left_3.renderWithRotation(par7);

        Primary_Side_Edge_Back_Right.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Right.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Back_Right.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Right.renderWithRotation(par7);

        Primary_Side_Edge_Back_Right_a.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Right_a.rotateAngleY = 0F;
        Primary_Side_Edge_Back_Right_a.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Right_a.renderWithRotation(par7);

        Primary_Side_Edge_Back_Right_b.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Right_b.rotateAngleY = 0F;
        Primary_Side_Edge_Back_Right_b.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Right_b.renderWithRotation(par7);

        Primary_Side_Edge_Back_Right_2.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Right_2.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Back_Right_2.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Right_2.renderWithRotation(par7);

        Primary_Side_Edge_Back_Right_3.rotateAngleX = 0F;
        Primary_Side_Edge_Back_Right_3.rotateAngleY = -0.7853982F;
        Primary_Side_Edge_Back_Right_3.rotateAngleZ = 0F;
        Primary_Side_Edge_Back_Right_3.renderWithRotation(par7);

        //Display_Stand_Base.rotateAngleX = 0F;
        //Display_Stand_Base.rotateAngleY = 0F;
        //Display_Stand_Base.rotateAngleZ = 0F;
        //Display_Stand_Base.renderWithRotation(par7);

        //Display_Stand_Top.rotateAngleX = 0F;
        //Display_Stand_Top.rotateAngleY = 0F;
        //Display_Stand_Top.rotateAngleZ = 0F;
        //Display_Stand_Top.renderWithRotation(par7);


    }

}
