package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent1Primary extends ModelBase
{
    ModelRenderer Component_Anchor_Top_FR_Big;
    ModelRenderer Component_Anchor_Top_FR_Small;
    ModelRenderer Component_Anchor_Bottom_FR;
    ModelRenderer Component_Anchor_Top_FL_Big;
    ModelRenderer Component_Anchor_Top_FL_Small;
    ModelRenderer Component_Anchor_Bottom_FL;
    ModelRenderer Component_Anchor_Top_BR_Big;
    ModelRenderer Component_Anchor_Top_BR_Small;
    ModelRenderer Component_Anchor_Bottom_BR;
    ModelRenderer Component_Anchor_Top_BL_Big;
    ModelRenderer Component_Anchor_Top_BL_Small;
    ModelRenderer Component_Anchor_Bottom_BL;
    ModelRenderer Component_BalloonFrameRT1;
    ModelRenderer Component_BalloonFrameRB1;
    ModelRenderer Component_BalloonFrameLT1;
    ModelRenderer Component_BalloonFrameLB1;
    ModelRenderer Component_BalloonFrameMT1;
    ModelRenderer Component_BalloonFrameRT2a;
    ModelRenderer Component_BalloonFrameRT2b;
    ModelRenderer Component_BalloonFrameMT2;
    ModelRenderer Component_BalloonFrameLT2a;
    ModelRenderer Component_BalloonFrameLT2b;
    ModelRenderer Component_BalloonFrameRM2;
    ModelRenderer Component_BalloonFrameLM2;
    ModelRenderer Component_BalloonFrameRB2a;
    ModelRenderer Component_BalloonFrameRB2b;
    ModelRenderer Component_BalloonFrameLB2a;
    ModelRenderer Component_BalloonFrameLB2b;
    ModelRenderer Component_BalloonFrameRT3;
    ModelRenderer Component_BalloonFrameMT3;
    ModelRenderer Component_BalloonFrameLT3;
    ModelRenderer Component_BalloonFrameRM3;
    ModelRenderer Component_BalloonFrameLM3;
    ModelRenderer Component_BalloonFrameRB3;
    ModelRenderer Component_BalloonFrameLB3;
    ModelRenderer Component_BalloonFrameF3a;
    ModelRenderer Component_BalloonFrameF3b;
    ModelRenderer Component_BalloonFrameF3c;
    ModelRenderer Component_BalloonFrameF3d;
    ModelRenderer Component_BalloonFrameB3a;
    ModelRenderer Component_BalloonFrameB3b;
    ModelRenderer Component_BalloonFrameB3c;
    ModelRenderer Component_BalloonFrameB3d;
    ModelRenderer Component_BalloonFrameLM1a;
    ModelRenderer Component_BalloonFrameRM1a;
    ModelRenderer Component_Front_Dial_Outer;
    ModelRenderer Component_Front_Dial_Inner;
    ModelRenderer Component_Back_Dial_Outer;
    ModelRenderer Component_Back_Dial_Inner;
    ModelRenderer Component_Engine_Left_Base1;
    ModelRenderer Component_Engine_Left_Base1_Panel;
    ModelRenderer Component_Engine_Left_Base1_Stud1;
    ModelRenderer Component_Engine_Left_Base1_Stud2;
    ModelRenderer Component_Engine_Left_Base1_Stud3;
    ModelRenderer Component_Engine_Left_Base2;
    ModelRenderer Component_Engine_Left_Base3;
    ModelRenderer Component_Engine_Left_Base3_Stud1;
    ModelRenderer Component_Engine_Right_Base1;
    ModelRenderer Component_Engine_Right_Base1_Panel;
    ModelRenderer Component_Engine_Right_Base1_Stud1;
    ModelRenderer Component_Engine_Right_Base1_Stud2;
    ModelRenderer Component_Engine_Right_Base1_Stud3;
    ModelRenderer Component_Engine_Right_Base2;
    ModelRenderer Component_Engine_Right_Base3;
    ModelRenderer Component_Engine_Right_Base3_Stud1;

    public ModelAirshipComponent1Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent1Primary( float par1 )
    {
        Component_Anchor_Top_FR_Big = new ModelRenderer( this, 0, 0 );
        Component_Anchor_Top_FR_Big.setTextureSize( 128, 128 );
        Component_Anchor_Top_FR_Big.addBox( 0F, 0F, 0F, 3, 3, 3);
        Component_Anchor_Top_FR_Big.setRotationPoint( -14F, -22F, -13.9F );
        Component_Anchor_Top_FR_Small = new ModelRenderer( this, 0, 6 );
        Component_Anchor_Top_FR_Small.setTextureSize( 128, 128 );
        Component_Anchor_Top_FR_Small.addBox( -2.5F, 0.5F, -2.5F, 2, 2, 2);
        Component_Anchor_Top_FR_Small.setRotationPoint( -11F, -21F, -10.9F );
        Component_Anchor_Bottom_FR = new ModelRenderer( this, 0, 10 );
        Component_Anchor_Bottom_FR.setTextureSize( 128, 128 );
        Component_Anchor_Bottom_FR.addBox( 0.5F, 0F, 0F, 2, 2, 2);
        Component_Anchor_Bottom_FR.setRotationPoint( -11.1F, -0.2000008F, -10F );
        Component_Anchor_Top_FL_Big = new ModelRenderer( this, 12, 0 );
        Component_Anchor_Top_FL_Big.setTextureSize( 128, 128 );
        Component_Anchor_Top_FL_Big.addBox( 0F, 0F, 0F, 3, 3, 3);
        Component_Anchor_Top_FL_Big.setRotationPoint( 11F, -22F, -13.9F );
        Component_Anchor_Top_FL_Small = new ModelRenderer( this, 8, 6 );
        Component_Anchor_Top_FL_Small.setTextureSize( 128, 128 );
        Component_Anchor_Top_FL_Small.addBox( 0.5F, 0.5F, -2.5F, 2, 2, 2);
        Component_Anchor_Top_FL_Small.setRotationPoint( 11F, -21F, -10.9F );
        Component_Anchor_Bottom_FL = new ModelRenderer( this, 8, 10 );
        Component_Anchor_Bottom_FL.setTextureSize( 128, 128 );
        Component_Anchor_Bottom_FL.addBox( -2.5F, 0F, 0F, 2, 2, 2);
        Component_Anchor_Bottom_FL.setRotationPoint( 11.1F, -0.2000008F, -10F );
        Component_Anchor_Top_BR_Big = new ModelRenderer( this, 24, 0 );
        Component_Anchor_Top_BR_Big.setTextureSize( 128, 128 );
        Component_Anchor_Top_BR_Big.addBox( 0F, 0F, 0F, 3, 3, 3);
        Component_Anchor_Top_BR_Big.setRotationPoint( -14F, -22F, 10.9F );
        Component_Anchor_Top_BR_Small = new ModelRenderer( this, 16, 6 );
        Component_Anchor_Top_BR_Small.setTextureSize( 128, 128 );
        Component_Anchor_Top_BR_Small.addBox( -2.5F, 0.5F, 0.5F, 2, 2, 2);
        Component_Anchor_Top_BR_Small.setRotationPoint( -11F, -21F, 10.9F );
        Component_Anchor_Bottom_BR = new ModelRenderer( this, 16, 10 );
        Component_Anchor_Bottom_BR.setTextureSize( 128, 128 );
        Component_Anchor_Bottom_BR.addBox( 0.5F, 0F, -2F, 2, 2, 2);
        Component_Anchor_Bottom_BR.setRotationPoint( -11.1F, -0.2000008F, 10F );
        Component_Anchor_Top_BL_Big = new ModelRenderer( this, 36, 0 );
        Component_Anchor_Top_BL_Big.setTextureSize( 128, 128 );
        Component_Anchor_Top_BL_Big.addBox( 0F, 0F, 0F, 3, 3, 3);
        Component_Anchor_Top_BL_Big.setRotationPoint( 11F, -22F, 10.9F );
        Component_Anchor_Top_BL_Small = new ModelRenderer( this, 24, 6 );
        Component_Anchor_Top_BL_Small.setTextureSize( 128, 128 );
        Component_Anchor_Top_BL_Small.addBox( 0.5F, 0.5F, 0.5F, 2, 2, 2);
        Component_Anchor_Top_BL_Small.setRotationPoint( 11F, -21F, 10.9F );
        Component_Anchor_Bottom_BL = new ModelRenderer( this, 24, 10 );
        Component_Anchor_Bottom_BL.setTextureSize( 128, 128 );
        Component_Anchor_Bottom_BL.addBox( -2.5F, 0F, -2F, 2, 2, 2);
        Component_Anchor_Bottom_BL.setRotationPoint( 11.1F, -0.2000008F, 10F );
        Component_BalloonFrameRT1 = new ModelRenderer( this, 60, 94 );
        Component_BalloonFrameRT1.setTextureSize( 128, 128 );
        Component_BalloonFrameRT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameRT1.setRotationPoint( -16.5F, -52.5F, -16.5F );
        Component_BalloonFrameRB1 = new ModelRenderer( this, 58, 93 );
        Component_BalloonFrameRB1.setTextureSize( 128, 128 );
        Component_BalloonFrameRB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameRB1.setRotationPoint( -16.5F, -20.5F, -16.5F );
        Component_BalloonFrameLT1 = new ModelRenderer( this, 56, 92 );
        Component_BalloonFrameLT1.setTextureSize( 128, 128 );
        Component_BalloonFrameLT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameLT1.setRotationPoint( 15.5F, -52.5F, -16.5F );
        Component_BalloonFrameLB1 = new ModelRenderer( this, 54, 91 );
        Component_BalloonFrameLB1.setTextureSize( 128, 128 );
        Component_BalloonFrameLB1.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameLB1.setRotationPoint( 15.5F, -20.5F, -16.5F );
        Component_BalloonFrameMT1 = new ModelRenderer( this, 52, 90 );
        Component_BalloonFrameMT1.setTextureSize( 128, 128 );
        Component_BalloonFrameMT1.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameMT1.setRotationPoint( -0.5F, -52.5F, -16.5F );
        Component_BalloonFrameRT2a = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameRT2a.setTextureSize( 128, 128 );
        Component_BalloonFrameRT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameRT2a.setRotationPoint( -15.5F, -51.5F, -19.5F );
        Component_BalloonFrameRT2b = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameRT2b.setTextureSize( 128, 128 );
        Component_BalloonFrameRT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameRT2b.setRotationPoint( -14.5F, -50.5F, -19.5F );
        Component_BalloonFrameMT2 = new ModelRenderer( this, 48, 87 );
        Component_BalloonFrameMT2.setTextureSize( 128, 128 );
        Component_BalloonFrameMT2.addBox( 0F, 0F, 0F, 1, 2, 39);
        Component_BalloonFrameMT2.setRotationPoint( -0.5F, -51.5F, -19.5F );
        Component_BalloonFrameLT2a = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameLT2a.setTextureSize( 128, 128 );
        Component_BalloonFrameLT2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameLT2a.setRotationPoint( 14.5F, -51.5F, -19.5F );
        Component_BalloonFrameLT2b = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameLT2b.setTextureSize( 128, 128 );
        Component_BalloonFrameLT2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameLT2b.setRotationPoint( 13.5F, -50.5F, -19.5F );
        Component_BalloonFrameRM2 = new ModelRenderer( this, 46, 88 );
        Component_BalloonFrameRM2.setTextureSize( 128, 128 );
        Component_BalloonFrameRM2.addBox( 0F, 0F, -1F, 2, 1, 39);
        Component_BalloonFrameRM2.setRotationPoint( -15.5F, -36.5F, -18.5F );
        Component_BalloonFrameLM2 = new ModelRenderer( this, 46, 88 );
        Component_BalloonFrameLM2.setTextureSize( 128, 128 );
        Component_BalloonFrameLM2.addBox( 0F, 0F, 0F, 2, 1, 39);
        Component_BalloonFrameLM2.setRotationPoint( 13.5F, -36.5F, -19.5F );
        Component_BalloonFrameRB2a = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameRB2a.setTextureSize( 128, 128 );
        Component_BalloonFrameRB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameRB2a.setRotationPoint( -15.5F, -21.5F, -19.5F );
        Component_BalloonFrameRB2b = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameRB2b.setTextureSize( 128, 128 );
        Component_BalloonFrameRB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameRB2b.setRotationPoint( -14.5F, -22.5F, -19.5F );
        Component_BalloonFrameLB2a = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameLB2a.setTextureSize( 128, 128 );
        Component_BalloonFrameLB2a.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameLB2a.setRotationPoint( 14.5F, -21.5F, -19.5F );
        Component_BalloonFrameLB2b = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameLB2b.setTextureSize( 128, 128 );
        Component_BalloonFrameLB2b.addBox( 0F, 0F, 0F, 1, 1, 39);
        Component_BalloonFrameLB2b.setRotationPoint( 13.5F, -22.5F, -19.5F );
        Component_BalloonFrameRT3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameRT3.setTextureSize( 128, 128 );
        Component_BalloonFrameRT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameRT3.setRotationPoint( -13.5F, -49.5F, -22.5F );
        Component_BalloonFrameMT3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameMT3.setTextureSize( 128, 128 );
        Component_BalloonFrameMT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameMT3.setRotationPoint( -0.5F, -49.5F, -22.5F );
        Component_BalloonFrameLT3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameLT3.setTextureSize( 128, 128 );
        Component_BalloonFrameLT3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameLT3.setRotationPoint( 12.5F, -49.5F, -22.5F );
        Component_BalloonFrameRM3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameRM3.setTextureSize( 128, 128 );
        Component_BalloonFrameRM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameRM3.setRotationPoint( -13.5F, -36.5F, -22.5F );
        Component_BalloonFrameLM3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameLM3.setTextureSize( 128, 128 );
        Component_BalloonFrameLM3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameLM3.setRotationPoint( 12.5F, -36.5F, -22.5F );
        Component_BalloonFrameRB3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameRB3.setTextureSize( 128, 128 );
        Component_BalloonFrameRB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameRB3.setRotationPoint( -13.5F, -23.5F, -22.5F );
        Component_BalloonFrameLB3 = new ModelRenderer( this, 36, 82 );
        Component_BalloonFrameLB3.setTextureSize( 128, 128 );
        Component_BalloonFrameLB3.addBox( 0F, 0F, 0F, 1, 1, 45);
        Component_BalloonFrameLB3.setRotationPoint( 12.5F, -23.5F, -22.5F );
        Component_BalloonFrameF3a = new ModelRenderer( this, 124, 114 );
        Component_BalloonFrameF3a.setTextureSize( 128, 128 );
        Component_BalloonFrameF3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        Component_BalloonFrameF3a.setRotationPoint( 0F, -36F, -22F );
        Component_BalloonFrameF3b = new ModelRenderer( this, 76, 126 );
        Component_BalloonFrameF3b.setTextureSize( 128, 128 );
        Component_BalloonFrameF3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        Component_BalloonFrameF3b.setRotationPoint( 0F, -36F, -22F );
        Component_BalloonFrameF3c = new ModelRenderer( this, 120, 90 );
        Component_BalloonFrameF3c.setTextureSize( 128, 128 );
        Component_BalloonFrameF3c.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        Component_BalloonFrameF3c.setRotationPoint( 0F, -36F, -22F );
        Component_BalloonFrameF3d = new ModelRenderer( this, 116, 90 );
        Component_BalloonFrameF3d.setTextureSize( 128, 128 );
        Component_BalloonFrameF3d.addBox( -0.5F, -18.5F, -0.7F, 1, 37, 1);
        Component_BalloonFrameF3d.setRotationPoint( 0F, -36F, -22F );
        Component_BalloonFrameB3a = new ModelRenderer( this, 120, 114 );
        Component_BalloonFrameB3a.setTextureSize( 128, 128 );
        Component_BalloonFrameB3a.addBox( -0.5F, -12.5F, -0.5F, 1, 13, 1);
        Component_BalloonFrameB3a.setRotationPoint( 0F, -36F, 22F );
        Component_BalloonFrameB3b = new ModelRenderer( this, 76, 124 );
        Component_BalloonFrameB3b.setTextureSize( 128, 128 );
        Component_BalloonFrameB3b.addBox( -12.5F, -0.5F, -0.5F, 25, 1, 1);
        Component_BalloonFrameB3b.setRotationPoint( 0F, -36F, 22F );
        Component_BalloonFrameB3c = new ModelRenderer( this, 112, 90 );
        Component_BalloonFrameB3c.setTextureSize( 128, 128 );
        Component_BalloonFrameB3c.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        Component_BalloonFrameB3c.setRotationPoint( 0F, -36F, 22F );
        Component_BalloonFrameB3d = new ModelRenderer( this, 124, 90 );
        Component_BalloonFrameB3d.setTextureSize( 128, 128 );
        Component_BalloonFrameB3d.addBox( -0.5F, -18.5F, -0.3F, 1, 37, 1);
        Component_BalloonFrameB3d.setRotationPoint( 0F, -36F, 22F );
        Component_BalloonFrameLM1a = new ModelRenderer( this, 50, 89 );
        Component_BalloonFrameLM1a.setTextureSize( 128, 128 );
        Component_BalloonFrameLM1a.addBox( 0F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameLM1a.setRotationPoint( 15.5F, -36.5F, -16.5F );
        Component_BalloonFrameRM1a = new ModelRenderer( this, 48, 88 );
        Component_BalloonFrameRM1a.setTextureSize( 128, 128 );
        Component_BalloonFrameRM1a.addBox( -1F, 0F, 0F, 1, 1, 33);
        Component_BalloonFrameRM1a.setRotationPoint( -15.5F, -36.5F, -16.5F );
        Component_Front_Dial_Outer = new ModelRenderer( this, 112, 24 );
        Component_Front_Dial_Outer.setTextureSize( 128, 128 );
        Component_Front_Dial_Outer.addBox( -3F, -3F, -1F, 6, 6, 2);
        Component_Front_Dial_Outer.setRotationPoint( 0F, -36F, -22F );
        Component_Front_Dial_Inner = new ModelRenderer( this, 114, 32 );
        Component_Front_Dial_Inner.setTextureSize( 128, 128 );
        Component_Front_Dial_Inner.addBox( -2.5F, -2.5F, -1F, 5, 5, 2);
        Component_Front_Dial_Inner.setRotationPoint( 0F, -36F, -22.5F );
        Component_Back_Dial_Outer = new ModelRenderer( this, 96, 24 );
        Component_Back_Dial_Outer.setTextureSize( 128, 128 );
        Component_Back_Dial_Outer.addBox( -3F, -3F, -1F, 6, 6, 2);
        Component_Back_Dial_Outer.setRotationPoint( 0F, -36F, 22F );
        Component_Back_Dial_Inner = new ModelRenderer( this, 100, 32 );
        Component_Back_Dial_Inner.setTextureSize( 128, 128 );
        Component_Back_Dial_Inner.addBox( -2.5F, -2.5F, -1F, 5, 5, 2);
        Component_Back_Dial_Inner.setRotationPoint( 0F, -36F, 22.5F );
        Component_Engine_Left_Base1 = new ModelRenderer( this, 92, 0 );
        Component_Engine_Left_Base1.setTextureSize( 128, 128 );
        Component_Engine_Left_Base1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Component_Engine_Left_Base1.setRotationPoint( 9.5F, -0.5F, 0F );
        Component_Engine_Left_Base1_Panel = new ModelRenderer( this, 90, 0 );
        Component_Engine_Left_Base1_Panel.setTextureSize( 128, 128 );
        Component_Engine_Left_Base1_Panel.addBox( -0.5F, -1.5F, -1.5F, 1, 3, 3);
        Component_Engine_Left_Base1_Panel.setRotationPoint( 13.5F, 3.5F, 2F );
        Component_Engine_Left_Base1_Stud1 = new ModelRenderer( this, 107, 4 );
        Component_Engine_Left_Base1_Stud1.setTextureSize( 128, 128 );
        Component_Engine_Left_Base1_Stud1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Left_Base1_Stud1.setRotationPoint( 12.5F, 0.5F, 0F );
        Component_Engine_Left_Base1_Stud2 = new ModelRenderer( this, 107, 2 );
        Component_Engine_Left_Base1_Stud2.setTextureSize( 128, 128 );
        Component_Engine_Left_Base1_Stud2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Left_Base1_Stud2.setRotationPoint( 12.5F, 4.5F, 0F );
        Component_Engine_Left_Base1_Stud3 = new ModelRenderer( this, 107, 0 );
        Component_Engine_Left_Base1_Stud3.setTextureSize( 128, 128 );
        Component_Engine_Left_Base1_Stud3.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Left_Base1_Stud3.setRotationPoint( 12.5F, 4.5F, 6F );
        Component_Engine_Left_Base2 = new ModelRenderer( this, 76, 0 );
        Component_Engine_Left_Base2.setTextureSize( 128, 128 );
        Component_Engine_Left_Base2.addBox( 0F, 1F, 2.5F, 4, 4, 3);
        Component_Engine_Left_Base2.setRotationPoint( 11.5F, -2.299999F, 2F );
        Component_Engine_Left_Base3 = new ModelRenderer( this, 60, 0 );
        Component_Engine_Left_Base3.setTextureSize( 128, 128 );
        Component_Engine_Left_Base3.addBox( -2F, -2F, 0F, 4, 4, 8);
        Component_Engine_Left_Base3.setRotationPoint( 15.5F, -1.299999F, 2F );
        Component_Engine_Left_Base3_Stud1 = new ModelRenderer( this, 62, 0 );
        Component_Engine_Left_Base3_Stud1.setTextureSize( 128, 128 );
        Component_Engine_Left_Base3_Stud1.addBox( -1F, -1F, -0.5F, 2, 2, 1);
        Component_Engine_Left_Base3_Stud1.setRotationPoint( 15.5F, -1.299999F, 2F );
        Component_Engine_Right_Base1 = new ModelRenderer( this, 92, 12 );
        Component_Engine_Right_Base1.setTextureSize( 128, 128 );
        Component_Engine_Right_Base1.addBox( -4F, 0F, 0F, 4, 6, 6);
        Component_Engine_Right_Base1.setRotationPoint( -9.5F, -0.5F, 0F );
        Component_Engine_Right_Base1_Panel = new ModelRenderer( this, 90, 12 );
        Component_Engine_Right_Base1_Panel.setTextureSize( 128, 128 );
        Component_Engine_Right_Base1_Panel.addBox( -0.5F, -1.5F, -1.5F, 1, 3, 3);
        Component_Engine_Right_Base1_Panel.setRotationPoint( -13.5F, 3.5F, 2F );
        Component_Engine_Right_Base1_Stud1 = new ModelRenderer( this, 107, 16 );
        Component_Engine_Right_Base1_Stud1.setTextureSize( 128, 128 );
        Component_Engine_Right_Base1_Stud1.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Right_Base1_Stud1.setRotationPoint( -12.5F, 0.5F, 0F );
        Component_Engine_Right_Base1_Stud2 = new ModelRenderer( this, 107, 14 );
        Component_Engine_Right_Base1_Stud2.setTextureSize( 128, 128 );
        Component_Engine_Right_Base1_Stud2.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Right_Base1_Stud2.setRotationPoint( -12.5F, 4.5F, 0F );
        Component_Engine_Right_Base1_Stud3 = new ModelRenderer( this, 107, 12 );
        Component_Engine_Right_Base1_Stud3.setTextureSize( 128, 128 );
        Component_Engine_Right_Base1_Stud3.addBox( -0.5F, -0.5F, -0.5F, 1, 1, 1);
        Component_Engine_Right_Base1_Stud3.setRotationPoint( -12.5F, 4.5F, 6F );
        Component_Engine_Right_Base2 = new ModelRenderer( this, 76, 12 );
        Component_Engine_Right_Base2.setTextureSize( 128, 128 );
        Component_Engine_Right_Base2.addBox( -4F, 1F, 2.5F, 4, 4, 3);
        Component_Engine_Right_Base2.setRotationPoint( -11.5F, -2.299999F, 2F );
        Component_Engine_Right_Base3 = new ModelRenderer( this, 60, 12 );
        Component_Engine_Right_Base3.setTextureSize( 128, 128 );
        Component_Engine_Right_Base3.addBox( -2F, -2F, 0F, 4, 4, 8);
        Component_Engine_Right_Base3.setRotationPoint( -15.5F, -1.299999F, 2F );
        Component_Engine_Right_Base3_Stud1 = new ModelRenderer( this, 62, 12 );
        Component_Engine_Right_Base3_Stud1.setTextureSize( 128, 128 );
        Component_Engine_Right_Base3_Stud1.addBox( -1F, -1F, -0.5F, 2, 2, 1);
        Component_Engine_Right_Base3_Stud1.setRotationPoint( -15.5F, -1.299999F, 2F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Component_Anchor_Top_FR_Big.rotateAngleX = 0F;
        Component_Anchor_Top_FR_Big.rotateAngleY = 0F;
        Component_Anchor_Top_FR_Big.rotateAngleZ = 0F;
        Component_Anchor_Top_FR_Big.renderWithRotation(par7);

        Component_Anchor_Top_FR_Small.rotateAngleX = 0F;
        Component_Anchor_Top_FR_Small.rotateAngleY = 0F;
        Component_Anchor_Top_FR_Small.rotateAngleZ = 0F;
        Component_Anchor_Top_FR_Small.renderWithRotation(par7);

        Component_Anchor_Bottom_FR.rotateAngleX = 0F;
        Component_Anchor_Bottom_FR.rotateAngleY = 0F;
        Component_Anchor_Bottom_FR.rotateAngleZ = 0F;
        Component_Anchor_Bottom_FR.renderWithRotation(par7);

        Component_Anchor_Top_FL_Big.rotateAngleX = 0F;
        Component_Anchor_Top_FL_Big.rotateAngleY = 0F;
        Component_Anchor_Top_FL_Big.rotateAngleZ = 0F;
        Component_Anchor_Top_FL_Big.renderWithRotation(par7);

        Component_Anchor_Top_FL_Small.rotateAngleX = 0F;
        Component_Anchor_Top_FL_Small.rotateAngleY = 0F;
        Component_Anchor_Top_FL_Small.rotateAngleZ = 0F;
        Component_Anchor_Top_FL_Small.renderWithRotation(par7);

        Component_Anchor_Bottom_FL.rotateAngleX = 0F;
        Component_Anchor_Bottom_FL.rotateAngleY = 0F;
        Component_Anchor_Bottom_FL.rotateAngleZ = 0F;
        Component_Anchor_Bottom_FL.renderWithRotation(par7);

        Component_Anchor_Top_BR_Big.rotateAngleX = 0F;
        Component_Anchor_Top_BR_Big.rotateAngleY = 0F;
        Component_Anchor_Top_BR_Big.rotateAngleZ = 0F;
        Component_Anchor_Top_BR_Big.renderWithRotation(par7);

        Component_Anchor_Top_BR_Small.rotateAngleX = 0F;
        Component_Anchor_Top_BR_Small.rotateAngleY = 0F;
        Component_Anchor_Top_BR_Small.rotateAngleZ = 0F;
        Component_Anchor_Top_BR_Small.renderWithRotation(par7);

        Component_Anchor_Bottom_BR.rotateAngleX = 0F;
        Component_Anchor_Bottom_BR.rotateAngleY = 0F;
        Component_Anchor_Bottom_BR.rotateAngleZ = 0F;
        Component_Anchor_Bottom_BR.renderWithRotation(par7);

        Component_Anchor_Top_BL_Big.rotateAngleX = 0F;
        Component_Anchor_Top_BL_Big.rotateAngleY = 0F;
        Component_Anchor_Top_BL_Big.rotateAngleZ = 0F;
        Component_Anchor_Top_BL_Big.renderWithRotation(par7);

        Component_Anchor_Top_BL_Small.rotateAngleX = 0F;
        Component_Anchor_Top_BL_Small.rotateAngleY = 0F;
        Component_Anchor_Top_BL_Small.rotateAngleZ = 0F;
        Component_Anchor_Top_BL_Small.renderWithRotation(par7);

        Component_Anchor_Bottom_BL.rotateAngleX = 0F;
        Component_Anchor_Bottom_BL.rotateAngleY = 0F;
        Component_Anchor_Bottom_BL.rotateAngleZ = 0F;
        Component_Anchor_Bottom_BL.renderWithRotation(par7);

        Component_BalloonFrameRT1.rotateAngleX = 0F;
        Component_BalloonFrameRT1.rotateAngleY = 0F;
        Component_BalloonFrameRT1.rotateAngleZ = 0F;
        Component_BalloonFrameRT1.renderWithRotation(par7);

        Component_BalloonFrameRB1.rotateAngleX = 0F;
        Component_BalloonFrameRB1.rotateAngleY = 0F;
        Component_BalloonFrameRB1.rotateAngleZ = 0F;
        Component_BalloonFrameRB1.renderWithRotation(par7);

        Component_BalloonFrameLT1.rotateAngleX = 0F;
        Component_BalloonFrameLT1.rotateAngleY = 0F;
        Component_BalloonFrameLT1.rotateAngleZ = 0F;
        Component_BalloonFrameLT1.renderWithRotation(par7);

        Component_BalloonFrameLB1.rotateAngleX = 0F;
        Component_BalloonFrameLB1.rotateAngleY = 0F;
        Component_BalloonFrameLB1.rotateAngleZ = 0F;
        Component_BalloonFrameLB1.renderWithRotation(par7);

        Component_BalloonFrameMT1.rotateAngleX = 0F;
        Component_BalloonFrameMT1.rotateAngleY = 0F;
        Component_BalloonFrameMT1.rotateAngleZ = 0F;
        Component_BalloonFrameMT1.renderWithRotation(par7);

        Component_BalloonFrameRT2a.rotateAngleX = 0F;
        Component_BalloonFrameRT2a.rotateAngleY = 0F;
        Component_BalloonFrameRT2a.rotateAngleZ = 0F;
        Component_BalloonFrameRT2a.renderWithRotation(par7);

        Component_BalloonFrameRT2b.rotateAngleX = 0F;
        Component_BalloonFrameRT2b.rotateAngleY = 0F;
        Component_BalloonFrameRT2b.rotateAngleZ = 0F;
        Component_BalloonFrameRT2b.renderWithRotation(par7);

        Component_BalloonFrameMT2.rotateAngleX = 0F;
        Component_BalloonFrameMT2.rotateAngleY = 0F;
        Component_BalloonFrameMT2.rotateAngleZ = 0F;
        Component_BalloonFrameMT2.renderWithRotation(par7);

        Component_BalloonFrameLT2a.rotateAngleX = 0F;
        Component_BalloonFrameLT2a.rotateAngleY = 0F;
        Component_BalloonFrameLT2a.rotateAngleZ = 0F;
        Component_BalloonFrameLT2a.renderWithRotation(par7);

        Component_BalloonFrameLT2b.rotateAngleX = 0F;
        Component_BalloonFrameLT2b.rotateAngleY = 0F;
        Component_BalloonFrameLT2b.rotateAngleZ = 0F;
        Component_BalloonFrameLT2b.renderWithRotation(par7);

        Component_BalloonFrameRM2.rotateAngleX = 0F;
        Component_BalloonFrameRM2.rotateAngleY = 0F;
        Component_BalloonFrameRM2.rotateAngleZ = 0F;
        Component_BalloonFrameRM2.renderWithRotation(par7);

        Component_BalloonFrameLM2.rotateAngleX = 0F;
        Component_BalloonFrameLM2.rotateAngleY = 0F;
        Component_BalloonFrameLM2.rotateAngleZ = 0F;
        Component_BalloonFrameLM2.renderWithRotation(par7);

        Component_BalloonFrameRB2a.rotateAngleX = 0F;
        Component_BalloonFrameRB2a.rotateAngleY = 0F;
        Component_BalloonFrameRB2a.rotateAngleZ = 0F;
        Component_BalloonFrameRB2a.renderWithRotation(par7);

        Component_BalloonFrameRB2b.rotateAngleX = 0F;
        Component_BalloonFrameRB2b.rotateAngleY = 0F;
        Component_BalloonFrameRB2b.rotateAngleZ = 0F;
        Component_BalloonFrameRB2b.renderWithRotation(par7);

        Component_BalloonFrameLB2a.rotateAngleX = 0F;
        Component_BalloonFrameLB2a.rotateAngleY = 0F;
        Component_BalloonFrameLB2a.rotateAngleZ = 0F;
        Component_BalloonFrameLB2a.renderWithRotation(par7);

        Component_BalloonFrameLB2b.rotateAngleX = 0F;
        Component_BalloonFrameLB2b.rotateAngleY = 0F;
        Component_BalloonFrameLB2b.rotateAngleZ = 0F;
        Component_BalloonFrameLB2b.renderWithRotation(par7);

        Component_BalloonFrameRT3.rotateAngleX = 0F;
        Component_BalloonFrameRT3.rotateAngleY = 0F;
        Component_BalloonFrameRT3.rotateAngleZ = 0F;
        Component_BalloonFrameRT3.renderWithRotation(par7);

        Component_BalloonFrameMT3.rotateAngleX = 0F;
        Component_BalloonFrameMT3.rotateAngleY = 0F;
        Component_BalloonFrameMT3.rotateAngleZ = 0F;
        Component_BalloonFrameMT3.renderWithRotation(par7);

        Component_BalloonFrameLT3.rotateAngleX = 0F;
        Component_BalloonFrameLT3.rotateAngleY = 0F;
        Component_BalloonFrameLT3.rotateAngleZ = 0F;
        Component_BalloonFrameLT3.renderWithRotation(par7);

        Component_BalloonFrameRM3.rotateAngleX = 0F;
        Component_BalloonFrameRM3.rotateAngleY = 0F;
        Component_BalloonFrameRM3.rotateAngleZ = 0F;
        Component_BalloonFrameRM3.renderWithRotation(par7);

        Component_BalloonFrameLM3.rotateAngleX = 0F;
        Component_BalloonFrameLM3.rotateAngleY = 0F;
        Component_BalloonFrameLM3.rotateAngleZ = 0F;
        Component_BalloonFrameLM3.renderWithRotation(par7);

        Component_BalloonFrameRB3.rotateAngleX = 0F;
        Component_BalloonFrameRB3.rotateAngleY = 0F;
        Component_BalloonFrameRB3.rotateAngleZ = 0F;
        Component_BalloonFrameRB3.renderWithRotation(par7);

        Component_BalloonFrameLB3.rotateAngleX = 0F;
        Component_BalloonFrameLB3.rotateAngleY = 0F;
        Component_BalloonFrameLB3.rotateAngleZ = 0F;
        Component_BalloonFrameLB3.renderWithRotation(par7);

        Component_BalloonFrameF3a.rotateAngleX = 0F;
        Component_BalloonFrameF3a.rotateAngleY = 0F;
        Component_BalloonFrameF3a.rotateAngleZ = 0F;
        Component_BalloonFrameF3a.renderWithRotation(par7);

        Component_BalloonFrameF3b.rotateAngleX = 0F;
        Component_BalloonFrameF3b.rotateAngleY = 0F;
        Component_BalloonFrameF3b.rotateAngleZ = 0F;
        Component_BalloonFrameF3b.renderWithRotation(par7);

        Component_BalloonFrameF3c.rotateAngleX = 0F;
        Component_BalloonFrameF3c.rotateAngleY = 0F;
        Component_BalloonFrameF3c.rotateAngleZ = -0.7853982F;
        Component_BalloonFrameF3c.renderWithRotation(par7);

        Component_BalloonFrameF3d.rotateAngleX = 0F;
        Component_BalloonFrameF3d.rotateAngleY = 0F;
        Component_BalloonFrameF3d.rotateAngleZ = 0.7853982F;
        Component_BalloonFrameF3d.renderWithRotation(par7);

        Component_BalloonFrameB3a.rotateAngleX = 0F;
        Component_BalloonFrameB3a.rotateAngleY = 0F;
        Component_BalloonFrameB3a.rotateAngleZ = 0F;
        Component_BalloonFrameB3a.renderWithRotation(par7);

        Component_BalloonFrameB3b.rotateAngleX = 0F;
        Component_BalloonFrameB3b.rotateAngleY = 0F;
        Component_BalloonFrameB3b.rotateAngleZ = 0F;
        Component_BalloonFrameB3b.renderWithRotation(par7);

        Component_BalloonFrameB3c.rotateAngleX = 0F;
        Component_BalloonFrameB3c.rotateAngleY = 0F;
        Component_BalloonFrameB3c.rotateAngleZ = -0.7853982F;
        Component_BalloonFrameB3c.renderWithRotation(par7);

        Component_BalloonFrameB3d.rotateAngleX = 0F;
        Component_BalloonFrameB3d.rotateAngleY = 0F;
        Component_BalloonFrameB3d.rotateAngleZ = 0.7853982F;
        Component_BalloonFrameB3d.renderWithRotation(par7);

        Component_BalloonFrameLM1a.rotateAngleX = 0F;
        Component_BalloonFrameLM1a.rotateAngleY = 0F;
        Component_BalloonFrameLM1a.rotateAngleZ = 0F;
        Component_BalloonFrameLM1a.renderWithRotation(par7);

        Component_BalloonFrameRM1a.rotateAngleX = 0F;
        Component_BalloonFrameRM1a.rotateAngleY = 0F;
        Component_BalloonFrameRM1a.rotateAngleZ = 0F;
        Component_BalloonFrameRM1a.renderWithRotation(par7);

        Component_Front_Dial_Outer.rotateAngleX = 0F;
        Component_Front_Dial_Outer.rotateAngleY = 0F;
        Component_Front_Dial_Outer.rotateAngleZ = 0F;
        Component_Front_Dial_Outer.renderWithRotation(par7);

        Component_Front_Dial_Inner.rotateAngleX = 0F;
        Component_Front_Dial_Inner.rotateAngleY = 0F;
        Component_Front_Dial_Inner.rotateAngleZ = 0F;
        Component_Front_Dial_Inner.renderWithRotation(par7);

        Component_Back_Dial_Outer.rotateAngleX = 0F;
        Component_Back_Dial_Outer.rotateAngleY = 0F;
        Component_Back_Dial_Outer.rotateAngleZ = 0F;
        Component_Back_Dial_Outer.renderWithRotation(par7);

        Component_Back_Dial_Inner.rotateAngleX = 0F;
        Component_Back_Dial_Inner.rotateAngleY = 0F;
        Component_Back_Dial_Inner.rotateAngleZ = 0F;
        Component_Back_Dial_Inner.renderWithRotation(par7);

        Component_Engine_Left_Base1.rotateAngleX = 0F;
        Component_Engine_Left_Base1.rotateAngleY = 0F;
        Component_Engine_Left_Base1.rotateAngleZ = 0F;
        Component_Engine_Left_Base1.renderWithRotation(par7);

        Component_Engine_Left_Base1_Panel.rotateAngleX = 0F;
        Component_Engine_Left_Base1_Panel.rotateAngleY = 0F;
        Component_Engine_Left_Base1_Panel.rotateAngleZ = 0F;
        Component_Engine_Left_Base1_Panel.renderWithRotation(par7);

        Component_Engine_Left_Base1_Stud1.rotateAngleX = 0F;
        Component_Engine_Left_Base1_Stud1.rotateAngleY = 0F;
        Component_Engine_Left_Base1_Stud1.rotateAngleZ = 0F;
        Component_Engine_Left_Base1_Stud1.renderWithRotation(par7);

        Component_Engine_Left_Base1_Stud2.rotateAngleX = 0F;
        Component_Engine_Left_Base1_Stud2.rotateAngleY = 0F;
        Component_Engine_Left_Base1_Stud2.rotateAngleZ = 0F;
        Component_Engine_Left_Base1_Stud2.renderWithRotation(par7);

        Component_Engine_Left_Base1_Stud3.rotateAngleX = 0F;
        Component_Engine_Left_Base1_Stud3.rotateAngleY = 0F;
        Component_Engine_Left_Base1_Stud3.rotateAngleZ = 0F;
        Component_Engine_Left_Base1_Stud3.renderWithRotation(par7);

        Component_Engine_Left_Base2.rotateAngleX = 0F;
        Component_Engine_Left_Base2.rotateAngleY = 0F;
        Component_Engine_Left_Base2.rotateAngleZ = 0F;
        Component_Engine_Left_Base2.renderWithRotation(par7);

        Component_Engine_Left_Base3.rotateAngleX = 0F;
        Component_Engine_Left_Base3.rotateAngleY = 0F;
        Component_Engine_Left_Base3.rotateAngleZ = -0.7853982F;
        Component_Engine_Left_Base3.renderWithRotation(par7);

        Component_Engine_Left_Base3_Stud1.rotateAngleX = 0F;
        Component_Engine_Left_Base3_Stud1.rotateAngleY = 0F;
        Component_Engine_Left_Base3_Stud1.rotateAngleZ = 0F;
        Component_Engine_Left_Base3_Stud1.renderWithRotation(par7);

        Component_Engine_Right_Base1.rotateAngleX = 0F;
        Component_Engine_Right_Base1.rotateAngleY = 0F;
        Component_Engine_Right_Base1.rotateAngleZ = 0F;
        Component_Engine_Right_Base1.renderWithRotation(par7);

        Component_Engine_Right_Base1_Panel.rotateAngleX = 0F;
        Component_Engine_Right_Base1_Panel.rotateAngleY = 0F;
        Component_Engine_Right_Base1_Panel.rotateAngleZ = 0F;
        Component_Engine_Right_Base1_Panel.renderWithRotation(par7);

        Component_Engine_Right_Base1_Stud1.rotateAngleX = 0F;
        Component_Engine_Right_Base1_Stud1.rotateAngleY = 0F;
        Component_Engine_Right_Base1_Stud1.rotateAngleZ = 0F;
        Component_Engine_Right_Base1_Stud1.renderWithRotation(par7);

        Component_Engine_Right_Base1_Stud2.rotateAngleX = 0F;
        Component_Engine_Right_Base1_Stud2.rotateAngleY = 0F;
        Component_Engine_Right_Base1_Stud2.rotateAngleZ = 0F;
        Component_Engine_Right_Base1_Stud2.renderWithRotation(par7);

        Component_Engine_Right_Base1_Stud3.rotateAngleX = 0F;
        Component_Engine_Right_Base1_Stud3.rotateAngleY = 0F;
        Component_Engine_Right_Base1_Stud3.rotateAngleZ = 0F;
        Component_Engine_Right_Base1_Stud3.renderWithRotation(par7);

        Component_Engine_Right_Base2.rotateAngleX = 0F;
        Component_Engine_Right_Base2.rotateAngleY = 0F;
        Component_Engine_Right_Base2.rotateAngleZ = 0F;
        Component_Engine_Right_Base2.renderWithRotation(par7);

        Component_Engine_Right_Base3.rotateAngleX = 0F;
        Component_Engine_Right_Base3.rotateAngleY = 0F;
        Component_Engine_Right_Base3.rotateAngleZ = 0.7853982F;
        Component_Engine_Right_Base3.renderWithRotation(par7);

        Component_Engine_Right_Base3_Stud1.rotateAngleX = 0F;
        Component_Engine_Right_Base3_Stud1.rotateAngleY = 0F;
        Component_Engine_Right_Base3_Stud1.rotateAngleZ = 0F;
        Component_Engine_Right_Base3_Stud1.renderWithRotation(par7);

    }

}
