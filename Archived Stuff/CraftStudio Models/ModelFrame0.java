package net.minecraft.src;

public class ModelFrame0 extends ModelBase
{
    ModelRenderer Floor_Latch;
    ModelRenderer Floor_Top;
    ModelRenderer Floor_Bottom;
    ModelRenderer Bomb_Bay;
    ModelRenderer Seat_Driver;
    ModelRenderer Side_Left_1;
    ModelRenderer Side_Left_2;
    ModelRenderer Base_Side_2a;
    ModelRenderer Base_Side_2b;
    ModelRenderer Anchor_Right_Front;
    ModelRenderer Anchor_Right_Back;
    ModelRenderer Anchor_Left_Front;
    ModelRenderer Anchor_Left_Back;
    ModelRenderer Base_Front_1a1;
    ModelRenderer Base_Front_1aR;
    ModelRenderer Base_Front_1aL;
    ModelRenderer Base_Front_1aM;
    ModelRenderer Base_Front_1c;
    ModelRenderer Base_Back_1a;
    ModelRenderer Base_Back_1c;
    ModelRenderer Control_Panel;
    ModelRenderer Control_Brace;
    ModelRenderer Skid_Brace_RightFront;
    ModelRenderer Skid_Brace_RightBack;
    ModelRenderer Skid_Bottom_Right;
    ModelRenderer Skid_Brace_LeftFront;
    ModelRenderer Skid_Brace_LeftBack;
    ModelRenderer Skid_Bottom_Left;

    public ModelFrame0()
    {
        this( 0.0f );
    }

    public ModelFrame0( float par1 )
    {
        Floor_Latch = new ModelRenderer( this, 150, 43 );
        Floor_Latch.setTextureSize( 256, 128 );
        Floor_Latch.addBox( 0F, 0F, 0F, 10, 2, 8);
        Floor_Latch.setRotationPoint( -5F, 4F, 3F );
        Floor_Top = new ModelRenderer( this, 0, 0 );
        Floor_Top.setTextureSize( 256, 128 );
        Floor_Top.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Top.setRotationPoint( -7F, 4.5F, -12F );
        Floor_Bottom = new ModelRenderer( this, 0, 0 );
        Floor_Bottom.setTextureSize( 256, 128 );
        Floor_Bottom.addBox( 0F, 0.5F, 0F, 14, 1, 24);
        Floor_Bottom.setRotationPoint( -7F, 5.5F, -12F );
        Bomb_Bay = new ModelRenderer( this, 22, 26 );
        Bomb_Bay.setTextureSize( 256, 128 );
        Bomb_Bay.addBox( -4F, -0.5F, -4F, 8, 1, 8);
        Bomb_Bay.setRotationPoint( 0F, 7F, 0F );
        Seat_Driver = new ModelRenderer( this, 0, 42 );
        Seat_Driver.setTextureSize( 256, 128 );
        Seat_Driver.addBox( 0F, 0F, 0F, 10, 2, 8);
        Seat_Driver.setRotationPoint( -5F, 4F, -6F );
        Side_Left_1 = new ModelRenderer( this, 92, 0 );
        Side_Left_1.setTextureSize( 256, 128 );
        Side_Left_1.addBox( 0F, 0F, 0F, 1, 2, 24);
        Side_Left_1.setRotationPoint( 7F, 4F, -12F );
        Side_Left_2 = new ModelRenderer( this, 0, 64 );
        Side_Left_2.setTextureSize( 256, 128 );
        Side_Left_2.addBox( 0F, 0F, 0F, 1, 4, 26);
        Side_Left_2.setRotationPoint( 8F, 1F, -13F );
        Base_Side_2a = new ModelRenderer( this, 0, 64 );
        Base_Side_2a.setTextureSize( 256, 128 );
        Base_Side_2a.addBox( 0F, 0F, 0F, 1, 4, 26);
        Base_Side_2a.setRotationPoint( -9F, 1F, -13F );
        Base_Side_2b = new ModelRenderer( this, 92, 0 );
        Base_Side_2b.setTextureSize( 256, 128 );
        Base_Side_2b.addBox( 0F, 0F, 0F, 1, 2, 24);
        Base_Side_2b.setRotationPoint( -8F, 4F, -12F );
        Anchor_Right_Front = new ModelRenderer( this, 0, 0 );
        Anchor_Right_Front.setTextureSize( 256, 128 );
        Anchor_Right_Front.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_Right_Front.setRotationPoint( -10F, 0F, -10F );
        Anchor_Right_Back = new ModelRenderer( this, 0, 0 );
        Anchor_Right_Back.setTextureSize( 256, 128 );
        Anchor_Right_Back.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_Right_Back.setRotationPoint( -10F, 0F, 8F );
        Anchor_Left_Front = new ModelRenderer( this, 0, 0 );
        Anchor_Left_Front.setTextureSize( 256, 128 );
        Anchor_Left_Front.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_Left_Front.setRotationPoint( 7F, 0F, -10F );
        Anchor_Left_Back = new ModelRenderer( this, 0, 0 );
        Anchor_Left_Back.setTextureSize( 256, 128 );
        Anchor_Left_Back.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Anchor_Left_Back.setRotationPoint( 7F, 0F, 8F );
        Base_Front_1a1 = new ModelRenderer( this, 2, 94 );
        Base_Front_1a1.setTextureSize( 256, 128 );
        Base_Front_1a1.addBox( 0F, 0F, 0F, 14, 4, 1);
        Base_Front_1a1.setRotationPoint( -7F, 1F, -15F );
        Base_Front_1aR = new ModelRenderer( this, 38, 99 );
        Base_Front_1aR.setTextureSize( 256, 128 );
        Base_Front_1aR.addBox( 0F, 0F, 0F, 1, 4, 1);
        Base_Front_1aR.setRotationPoint( -8F, 1F, -14F );
        Base_Front_1aL = new ModelRenderer( this, 34, 99 );
        Base_Front_1aL.setTextureSize( 256, 128 );
        Base_Front_1aL.addBox( 0F, 0F, 0F, 1, 4, 1);
        Base_Front_1aL.setRotationPoint( 7F, 1F, -14F );
        Base_Front_1aM = new ModelRenderer( this, 0, 110 );
        Base_Front_1aM.setTextureSize( 256, 128 );
        Base_Front_1aM.addBox( 0F, 0F, 0F, 14, 2, 1);
        Base_Front_1aM.setRotationPoint( -7F, 4F, -14F );
        Base_Front_1c = new ModelRenderer( this, 0, 104 );
        Base_Front_1c.setTextureSize( 256, 128 );
        Base_Front_1c.addBox( 0F, 0F, 0F, 16, 2, 1);
        Base_Front_1c.setRotationPoint( -8F, 4F, -13F );
        Base_Back_1a = new ModelRenderer( this, 0, 99 );
        Base_Back_1a.setTextureSize( 256, 128 );
        Base_Back_1a.addBox( 0F, 0F, 0F, 16, 4, 1);
        Base_Back_1a.setRotationPoint( -8F, 1F, 13F );
        Base_Back_1c = new ModelRenderer( this, 0, 107 );
        Base_Back_1c.setTextureSize( 256, 128 );
        Base_Back_1c.addBox( 0F, 0F, 0F, 16, 2, 1);
        Base_Back_1c.setRotationPoint( -8F, 4F, 12F );
        Control_Panel = new ModelRenderer( this, 0, 122 );
        Control_Panel.setTextureSize( 256, 128 );
        Control_Panel.addBox( 0F, 0F, 0F, 7, 5, 1);
        Control_Panel.setRotationPoint( -3.5F, -1F, -16F );
        Control_Brace = new ModelRenderer( this, 0, 117 );
        Control_Brace.setTextureSize( 256, 128 );
        Control_Brace.addBox( -0.5F, 0F, 0F, 6, 4, 1);
        Control_Brace.setRotationPoint( -2.5F, -0.5F, -15.5F );
        Skid_Brace_RightFront = new ModelRenderer( this, 248, 26 );
        Skid_Brace_RightFront.setTextureSize( 256, 128 );
        Skid_Brace_RightFront.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_RightFront.setRotationPoint( -6F, 6F, -6F );
        Skid_Brace_RightBack = new ModelRenderer( this, 248, 26 );
        Skid_Brace_RightBack.setTextureSize( 256, 128 );
        Skid_Brace_RightBack.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_RightBack.setRotationPoint( -6F, 6F, 6F );
        Skid_Bottom_Right = new ModelRenderer( this, 202, 26 );
        Skid_Bottom_Right.setTextureSize( 256, 128 );
        Skid_Bottom_Right.addBox( -1.5F, 0F, 0F, 3, 1, 24);
        Skid_Bottom_Right.setRotationPoint( -6F, 9F, -12F );
        Skid_Brace_LeftFront = new ModelRenderer( this, 248, 26 );
        Skid_Brace_LeftFront.setTextureSize( 256, 128 );
        Skid_Brace_LeftFront.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_LeftFront.setRotationPoint( 6F, 6F, -6F );
        Skid_Brace_LeftBack = new ModelRenderer( this, 248, 26 );
        Skid_Brace_LeftBack.setTextureSize( 256, 128 );
        Skid_Brace_LeftBack.addBox( -1F, 0F, -1F, 2, 3, 2);
        Skid_Brace_LeftBack.setRotationPoint( 6F, 6F, 6F );
        Skid_Bottom_Left = new ModelRenderer( this, 202, 26 );
        Skid_Bottom_Left.setTextureSize( 256, 128 );
        Skid_Bottom_Left.addBox( -1.5F, 0F, 0F, 3, 1, 24);
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

        Base_Side_2a.rotateAngleX = 0F;
        Base_Side_2a.rotateAngleY = 0F;
        Base_Side_2a.rotateAngleZ = 0F;
        Base_Side_2a.renderWithRotation(par7);

        Base_Side_2b.rotateAngleX = 0F;
        Base_Side_2b.rotateAngleY = 0F;
        Base_Side_2b.rotateAngleZ = 0F;
        Base_Side_2b.renderWithRotation(par7);

        Anchor_Right_Front.rotateAngleX = 0F;
        Anchor_Right_Front.rotateAngleY = 0F;
        Anchor_Right_Front.rotateAngleZ = 0F;
        Anchor_Right_Front.renderWithRotation(par7);

        Anchor_Right_Back.rotateAngleX = 0F;
        Anchor_Right_Back.rotateAngleY = 0F;
        Anchor_Right_Back.rotateAngleZ = 0F;
        Anchor_Right_Back.renderWithRotation(par7);

        Anchor_Left_Front.rotateAngleX = 0F;
        Anchor_Left_Front.rotateAngleY = 0F;
        Anchor_Left_Front.rotateAngleZ = 0F;
        Anchor_Left_Front.renderWithRotation(par7);

        Anchor_Left_Back.rotateAngleX = 0F;
        Anchor_Left_Back.rotateAngleY = 0F;
        Anchor_Left_Back.rotateAngleZ = 0F;
        Anchor_Left_Back.renderWithRotation(par7);

        Base_Front_1a1.rotateAngleX = 0F;
        Base_Front_1a1.rotateAngleY = 0F;
        Base_Front_1a1.rotateAngleZ = 0F;
        Base_Front_1a1.renderWithRotation(par7);

        Base_Front_1aR.rotateAngleX = 0F;
        Base_Front_1aR.rotateAngleY = 0F;
        Base_Front_1aR.rotateAngleZ = 0F;
        Base_Front_1aR.renderWithRotation(par7);

        Base_Front_1aL.rotateAngleX = 0F;
        Base_Front_1aL.rotateAngleY = 0F;
        Base_Front_1aL.rotateAngleZ = 0F;
        Base_Front_1aL.renderWithRotation(par7);

        Base_Front_1aM.rotateAngleX = 0F;
        Base_Front_1aM.rotateAngleY = 0F;
        Base_Front_1aM.rotateAngleZ = 0F;
        Base_Front_1aM.renderWithRotation(par7);

        Base_Front_1c.rotateAngleX = 0F;
        Base_Front_1c.rotateAngleY = 0F;
        Base_Front_1c.rotateAngleZ = 0F;
        Base_Front_1c.renderWithRotation(par7);

        Base_Back_1a.rotateAngleX = 0F;
        Base_Back_1a.rotateAngleY = 0F;
        Base_Back_1a.rotateAngleZ = 0F;
        Base_Back_1a.renderWithRotation(par7);

        Base_Back_1c.rotateAngleX = 0F;
        Base_Back_1c.rotateAngleY = 0F;
        Base_Back_1c.rotateAngleZ = 0F;
        Base_Back_1c.renderWithRotation(par7);

        Control_Panel.rotateAngleX = 0.7853982F;
        Control_Panel.rotateAngleY = 0F;
        Control_Panel.rotateAngleZ = 0F;
        Control_Panel.renderWithRotation(par7);

        Control_Brace.rotateAngleX = 0F;
        Control_Brace.rotateAngleY = 0F;
        Control_Brace.rotateAngleZ = 0F;
        Control_Brace.renderWithRotation(par7);

        Skid_Brace_RightFront.rotateAngleX = 0F;
        Skid_Brace_RightFront.rotateAngleY = -0.7853982F;
        Skid_Brace_RightFront.rotateAngleZ = 0F;
        Skid_Brace_RightFront.renderWithRotation(par7);

        Skid_Brace_RightBack.rotateAngleX = 0F;
        Skid_Brace_RightBack.rotateAngleY = -0.7853982F;
        Skid_Brace_RightBack.rotateAngleZ = 0F;
        Skid_Brace_RightBack.renderWithRotation(par7);

        Skid_Bottom_Right.rotateAngleX = 0F;
        Skid_Bottom_Right.rotateAngleY = 0F;
        Skid_Bottom_Right.rotateAngleZ = 0F;
        Skid_Bottom_Right.renderWithRotation(par7);

        Skid_Brace_LeftFront.rotateAngleX = 0F;
        Skid_Brace_LeftFront.rotateAngleY = -0.7853982F;
        Skid_Brace_LeftFront.rotateAngleZ = 0F;
        Skid_Brace_LeftFront.renderWithRotation(par7);

        Skid_Brace_LeftBack.rotateAngleX = 0F;
        Skid_Brace_LeftBack.rotateAngleY = -0.7853982F;
        Skid_Brace_LeftBack.rotateAngleZ = 0F;
        Skid_Brace_LeftBack.renderWithRotation(par7);

        Skid_Bottom_Left.rotateAngleX = 0F;
        Skid_Bottom_Left.rotateAngleY = 0F;
        Skid_Bottom_Left.rotateAngleZ = 0F;
        Skid_Bottom_Left.renderWithRotation(par7);

    }

}
