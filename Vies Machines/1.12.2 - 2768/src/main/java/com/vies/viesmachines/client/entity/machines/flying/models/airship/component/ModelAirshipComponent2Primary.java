package com.vies.viesmachines.client.entity.machines.flying.models.airship.component;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipComponent2Primary extends ModelBase
{
    ModelRenderer AnchorRa;
    ModelRenderer Engine_FR2a;
    ModelRenderer Engine_R1;
    ModelRenderer Pipe_R1a;
    ModelRenderer Pipe_R1b;
    ModelRenderer BalloonFrameRT1a;
    ModelRenderer BalloonFrameRT1b;
    ModelRenderer BalloonFrameRB1a;
    ModelRenderer BalloonFrameRB1b;
    ModelRenderer BalloonFrameRT2a1;
    ModelRenderer BalloonFrameRT2a2;
    ModelRenderer BalloonFrameRT2b1;
    ModelRenderer BalloonFrameRT2b2;
    ModelRenderer BalloonFrameRB2a1;
    ModelRenderer BalloonFrameRB2a2;
    ModelRenderer BalloonFrameRB2b1;
    ModelRenderer BalloonFrameRB2b2;
    ModelRenderer JointR1a;
    ModelRenderer JointR1b;
    ModelRenderer BalloonFrameFrontRightDial;
    ModelRenderer BackEngineL;
    ModelRenderer AnchorLa;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_FL2a;
    ModelRenderer Pipe_L1a;
    ModelRenderer Pipe_L1b;
    ModelRenderer BalloonFrameLT1a;
    ModelRenderer BalloonFrameLT1b;
    ModelRenderer BalloonFrameLB1a;
    ModelRenderer BalloonFrameLB1b;
    ModelRenderer BalloonFrameLT2a1;
    ModelRenderer BalloonFrameLT2a2;
    ModelRenderer BalloonFrameLT2b1;
    ModelRenderer BalloonFrameLT2b2;
    ModelRenderer BalloonFrameLB2a1;
    ModelRenderer BalloonFrameLB2a2;
    ModelRenderer BalloonFrameLB2b1;
    ModelRenderer BalloonFrameLB2b2;
    ModelRenderer JointL1a;
    ModelRenderer JointL1b;
    ModelRenderer BalloonFrameFrontLeftDial;
    ModelRenderer BackEngineR;

    public ModelAirshipComponent2Primary()
    {
        this( 0.0f );
    }

    public ModelAirshipComponent2Primary( float par1 )
    {
        AnchorRa = new ModelRenderer( this, 0, 38 );
        AnchorRa.setTextureSize( 128, 128 );
        AnchorRa.addBox( -0.5F, 0F, 0F, 3, 2, 6);
        AnchorRa.setRotationPoint( -10.5F, 0.3999996F, -3.1F );
        Engine_FR2a = new ModelRenderer( this, 0, 26 );
        Engine_FR2a.setTextureSize( 128, 128 );
        Engine_FR2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FR2a.setRotationPoint( -20F, -2.1F, -3.1F );
        Engine_R1 = new ModelRenderer( this, 0, 14 );
        Engine_R1.setTextureSize( 128, 128 );
        Engine_R1.addBox( 0F, 1F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -14F, -2.1F, 5.9F );
        Pipe_R1a = new ModelRenderer( this, 14, 18 );
        Pipe_R1a.setTextureSize( 128, 128 );
        Pipe_R1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_R1a.setRotationPoint( -19F, 2.9F, 8.9F );
        Pipe_R1b = new ModelRenderer( this, 32, 6 );
        Pipe_R1b.setTextureSize( 128, 128 );
        Pipe_R1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_R1b.setRotationPoint( -19F, 2.9F, 2.9F );
        BalloonFrameRT1a = new ModelRenderer( this, 74, 101 );
        BalloonFrameRT1a.setTextureSize( 128, 128 );
        BalloonFrameRT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1a.setRotationPoint( -13.5F, -7.6F, -12.6F );
        BalloonFrameRT1b = new ModelRenderer( this, 74, 101 );
        BalloonFrameRT1b.setTextureSize( 128, 128 );
        BalloonFrameRT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1b.setRotationPoint( -23.5F, -7.6F, -12.6F );
        BalloonFrameRB1a = new ModelRenderer( this, 74, 101 );
        BalloonFrameRB1a.setTextureSize( 128, 128 );
        BalloonFrameRB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1a.setRotationPoint( -13.5F, 2.4F, -12.6F );
        BalloonFrameRB1b = new ModelRenderer( this, 74, 101 );
        BalloonFrameRB1b.setTextureSize( 128, 128 );
        BalloonFrameRB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1b.setRotationPoint( -23.5F, 2.4F, -12.6F );
        BalloonFrameRT2a1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameRT2a1.setTextureSize( 128, 128 );
        BalloonFrameRT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2a1.setRotationPoint( -14.5F, -6.6F, -13.6F );
        BalloonFrameRT2a2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameRT2a2.setTextureSize( 128, 128 );
        BalloonFrameRT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2a2.setRotationPoint( -15.5F, -5.6F, -14.6F );
        BalloonFrameRT2b1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameRT2b1.setTextureSize( 128, 128 );
        BalloonFrameRT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2b1.setRotationPoint( -22.5F, -6.6F, -13.6F );
        BalloonFrameRT2b2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameRT2b2.setTextureSize( 128, 128 );
        BalloonFrameRT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2b2.setRotationPoint( -21.5F, -5.6F, -14.6F );
        BalloonFrameRB2a1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameRB2a1.setTextureSize( 128, 128 );
        BalloonFrameRB2a1.addBox( 0F, 0F, -1F, 1, 1, 28);
        BalloonFrameRB2a1.setRotationPoint( -14.5F, 1.4F, -12.6F );
        BalloonFrameRB2a2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameRB2a2.setTextureSize( 128, 128 );
        BalloonFrameRB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2a2.setRotationPoint( -15.5F, 0.3999996F, -14.6F );
        BalloonFrameRB2b1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameRB2b1.setTextureSize( 128, 128 );
        BalloonFrameRB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRB2b1.setRotationPoint( -22.5F, 1.4F, -13.6F );
        BalloonFrameRB2b2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameRB2b2.setTextureSize( 128, 128 );
        BalloonFrameRB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2b2.setRotationPoint( -21.5F, 0.3999996F, -14.6F );
        JointR1a = new ModelRenderer( this, 118, 125 );
        JointR1a.setTextureSize( 128, 128 );
        JointR1a.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1a.setRotationPoint( -9.5F, 1.4F, -2.1F );
        JointR1b = new ModelRenderer( this, 118, 125 );
        JointR1b.setTextureSize( 128, 128 );
        JointR1b.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1b.setRotationPoint( -9.5F, 1.4F, 1.9F );
        BalloonFrameFrontRightDial = new ModelRenderer( this, 112, 0 );
        BalloonFrameFrontRightDial.setTextureSize( 128, 128 );
        BalloonFrameFrontRightDial.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameFrontRightDial.setRotationPoint( -21F, -5.1F, -14.1F );
        BackEngineL = new ModelRenderer( this, 110, 39 );
        BackEngineL.setTextureSize( 128, 128 );
        BackEngineL.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineL.setRotationPoint( 14F, -6.1F, 12.9F );
        AnchorLa = new ModelRenderer( this, 0, 38 );
        AnchorLa.setTextureSize( 128, 128 );
        AnchorLa.addBox( -0.5F, 0F, 0F, 3, 2, 6);
        AnchorLa.setRotationPoint( 8.5F, 0.3999996F, -3.1F );
        Engine_L1 = new ModelRenderer( this, 20, 14 );
        Engine_L1.setTextureSize( 128, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 10F, -1.1F, 5.9F );
        Engine_FL2a = new ModelRenderer( this, 20, 26 );
        Engine_FL2a.setTextureSize( 128, 128 );
        Engine_FL2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FL2a.setRotationPoint( 16F, -2.1F, -3.1F );
        Pipe_L1a = new ModelRenderer( this, 14, 18 );
        Pipe_L1a.setTextureSize( 128, 128 );
        Pipe_L1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_L1a.setRotationPoint( 14F, 2.9F, 8.9F );
        Pipe_L1b = new ModelRenderer( this, 32, 6 );
        Pipe_L1b.setTextureSize( 128, 128 );
        Pipe_L1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_L1b.setRotationPoint( 18F, 2.9F, 2.9F );
        BalloonFrameLT1a = new ModelRenderer( this, 74, 101 );
        BalloonFrameLT1a.setTextureSize( 128, 128 );
        BalloonFrameLT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1a.setRotationPoint( 22.5F, -7.6F, -12.6F );
        BalloonFrameLT1b = new ModelRenderer( this, 74, 101 );
        BalloonFrameLT1b.setTextureSize( 128, 128 );
        BalloonFrameLT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1b.setRotationPoint( 12.5F, -7.6F, -12.6F );
        BalloonFrameLB1a = new ModelRenderer( this, 74, 101 );
        BalloonFrameLB1a.setTextureSize( 128, 128 );
        BalloonFrameLB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1a.setRotationPoint( 22.5F, 2.4F, -12.6F );
        BalloonFrameLB1b = new ModelRenderer( this, 74, 101 );
        BalloonFrameLB1b.setTextureSize( 128, 128 );
        BalloonFrameLB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1b.setRotationPoint( 12.5F, 2.4F, -12.6F );
        BalloonFrameLT2a1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameLT2a1.setTextureSize( 128, 128 );
        BalloonFrameLT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2a1.setRotationPoint( 21.5F, -6.6F, -13.6F );
        BalloonFrameLT2a2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameLT2a2.setTextureSize( 128, 128 );
        BalloonFrameLT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2a2.setRotationPoint( 20.5F, -5.6F, -14.6F );
        BalloonFrameLT2b1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameLT2b1.setTextureSize( 128, 128 );
        BalloonFrameLT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2b1.setRotationPoint( 13.5F, -6.6F, -13.6F );
        BalloonFrameLT2b2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameLT2b2.setTextureSize( 128, 128 );
        BalloonFrameLT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2b2.setRotationPoint( 14.5F, -5.6F, -14.6F );
        BalloonFrameLB2a1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameLB2a1.setTextureSize( 128, 128 );
        BalloonFrameLB2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2a1.setRotationPoint( 21.5F, 1.4F, -13.6F );
        BalloonFrameLB2a2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameLB2a2.setTextureSize( 128, 128 );
        BalloonFrameLB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2a2.setRotationPoint( 20.5F, 0.3999996F, -14.6F );
        BalloonFrameLB2b1 = new ModelRenderer( this, 70, 99 );
        BalloonFrameLB2b1.setTextureSize( 128, 128 );
        BalloonFrameLB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2b1.setRotationPoint( 13.5F, 1.4F, -13.6F );
        BalloonFrameLB2b2 = new ModelRenderer( this, 68, 98 );
        BalloonFrameLB2b2.setTextureSize( 128, 128 );
        BalloonFrameLB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2b2.setRotationPoint( 14.5F, 0.3999996F, -14.6F );
        JointL1a = new ModelRenderer( this, 118, 125 );
        JointL1a.setTextureSize( 128, 128 );
        JointL1a.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1a.setRotationPoint( 9.5F, 1.4F, 1.9F );
        JointL1b = new ModelRenderer( this, 118, 125 );
        JointL1b.setTextureSize( 128, 128 );
        JointL1b.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1b.setRotationPoint( 9.5F, 1.4F, -2.1F );
        BalloonFrameFrontLeftDial = new ModelRenderer( this, 112, 0 );
        BalloonFrameFrontLeftDial.setTextureSize( 128, 128 );
        BalloonFrameFrontLeftDial.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameFrontLeftDial.setRotationPoint( 15F, -5.1F, -14.1F );
        BackEngineR = new ModelRenderer( this, 110, 39 );
        BackEngineR.setTextureSize( 128, 128 );
        BackEngineR.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineR.setRotationPoint( -22F, -6.1F, 12.9F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        AnchorRa.rotateAngleX = 0F;
        AnchorRa.rotateAngleY = 0F;
        AnchorRa.rotateAngleZ = 0F;
        AnchorRa.renderWithRotation(par7);

        Engine_FR2a.rotateAngleX = 0F;
        Engine_FR2a.rotateAngleY = 0F;
        Engine_FR2a.rotateAngleZ = 0F;
        Engine_FR2a.renderWithRotation(par7);

        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Pipe_R1a.rotateAngleX = 0F;
        Pipe_R1a.rotateAngleY = 0F;
        Pipe_R1a.rotateAngleZ = 0F;
        Pipe_R1a.renderWithRotation(par7);

        Pipe_R1b.rotateAngleX = 0F;
        Pipe_R1b.rotateAngleY = 0F;
        Pipe_R1b.rotateAngleZ = 0F;
        Pipe_R1b.renderWithRotation(par7);

        BalloonFrameRT1a.rotateAngleX = 0F;
        BalloonFrameRT1a.rotateAngleY = 0F;
        BalloonFrameRT1a.rotateAngleZ = 0F;
        BalloonFrameRT1a.renderWithRotation(par7);

        BalloonFrameRT1b.rotateAngleX = 0F;
        BalloonFrameRT1b.rotateAngleY = 0F;
        BalloonFrameRT1b.rotateAngleZ = 0F;
        BalloonFrameRT1b.renderWithRotation(par7);

        BalloonFrameRB1a.rotateAngleX = 0F;
        BalloonFrameRB1a.rotateAngleY = 0F;
        BalloonFrameRB1a.rotateAngleZ = 0F;
        BalloonFrameRB1a.renderWithRotation(par7);

        BalloonFrameRB1b.rotateAngleX = 0F;
        BalloonFrameRB1b.rotateAngleY = 0F;
        BalloonFrameRB1b.rotateAngleZ = 0F;
        BalloonFrameRB1b.renderWithRotation(par7);

        BalloonFrameRT2a1.rotateAngleX = 0F;
        BalloonFrameRT2a1.rotateAngleY = 0F;
        BalloonFrameRT2a1.rotateAngleZ = 0F;
        BalloonFrameRT2a1.renderWithRotation(par7);

        BalloonFrameRT2a2.rotateAngleX = 0F;
        BalloonFrameRT2a2.rotateAngleY = 0F;
        BalloonFrameRT2a2.rotateAngleZ = 0F;
        BalloonFrameRT2a2.renderWithRotation(par7);

        BalloonFrameRT2b1.rotateAngleX = 0F;
        BalloonFrameRT2b1.rotateAngleY = 0F;
        BalloonFrameRT2b1.rotateAngleZ = 0F;
        BalloonFrameRT2b1.renderWithRotation(par7);

        BalloonFrameRT2b2.rotateAngleX = 0F;
        BalloonFrameRT2b2.rotateAngleY = 0F;
        BalloonFrameRT2b2.rotateAngleZ = 0F;
        BalloonFrameRT2b2.renderWithRotation(par7);

        BalloonFrameRB2a1.rotateAngleX = 0F;
        BalloonFrameRB2a1.rotateAngleY = 0F;
        BalloonFrameRB2a1.rotateAngleZ = 0F;
        BalloonFrameRB2a1.renderWithRotation(par7);

        BalloonFrameRB2a2.rotateAngleX = 0F;
        BalloonFrameRB2a2.rotateAngleY = 0F;
        BalloonFrameRB2a2.rotateAngleZ = 0F;
        BalloonFrameRB2a2.renderWithRotation(par7);

        BalloonFrameRB2b1.rotateAngleX = 0F;
        BalloonFrameRB2b1.rotateAngleY = 0F;
        BalloonFrameRB2b1.rotateAngleZ = 0F;
        BalloonFrameRB2b1.renderWithRotation(par7);

        BalloonFrameRB2b2.rotateAngleX = 0F;
        BalloonFrameRB2b2.rotateAngleY = 0F;
        BalloonFrameRB2b2.rotateAngleZ = 0F;
        BalloonFrameRB2b2.renderWithRotation(par7);

        JointR1a.rotateAngleX = 0F;
        JointR1a.rotateAngleY = 0F;
        JointR1a.rotateAngleZ = 0F;
        JointR1a.renderWithRotation(par7);

        JointR1b.rotateAngleX = 0F;
        JointR1b.rotateAngleY = 0F;
        JointR1b.rotateAngleZ = 0F;
        JointR1b.renderWithRotation(par7);

        BalloonFrameFrontRightDial.rotateAngleX = 0F;
        BalloonFrameFrontRightDial.rotateAngleY = 0F;
        BalloonFrameFrontRightDial.rotateAngleZ = 0F;
        BalloonFrameFrontRightDial.renderWithRotation(par7);

        BackEngineL.rotateAngleX = 0F;
        BackEngineL.rotateAngleY = 0F;
        BackEngineL.rotateAngleZ = 0F;
        BackEngineL.renderWithRotation(par7);

        AnchorLa.rotateAngleX = 0F;
        AnchorLa.rotateAngleY = 0F;
        AnchorLa.rotateAngleZ = 0F;
        AnchorLa.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_FL2a.rotateAngleX = 0F;
        Engine_FL2a.rotateAngleY = 0F;
        Engine_FL2a.rotateAngleZ = 0F;
        Engine_FL2a.renderWithRotation(par7);

        Pipe_L1a.rotateAngleX = 0F;
        Pipe_L1a.rotateAngleY = 0F;
        Pipe_L1a.rotateAngleZ = 0F;
        Pipe_L1a.renderWithRotation(par7);

        Pipe_L1b.rotateAngleX = 0F;
        Pipe_L1b.rotateAngleY = 0F;
        Pipe_L1b.rotateAngleZ = 0F;
        Pipe_L1b.renderWithRotation(par7);

        BalloonFrameLT1a.rotateAngleX = 0F;
        BalloonFrameLT1a.rotateAngleY = 0F;
        BalloonFrameLT1a.rotateAngleZ = 0F;
        BalloonFrameLT1a.renderWithRotation(par7);

        BalloonFrameLT1b.rotateAngleX = 0F;
        BalloonFrameLT1b.rotateAngleY = 0F;
        BalloonFrameLT1b.rotateAngleZ = 0F;
        BalloonFrameLT1b.renderWithRotation(par7);

        BalloonFrameLB1a.rotateAngleX = 0F;
        BalloonFrameLB1a.rotateAngleY = 0F;
        BalloonFrameLB1a.rotateAngleZ = 0F;
        BalloonFrameLB1a.renderWithRotation(par7);

        BalloonFrameLB1b.rotateAngleX = 0F;
        BalloonFrameLB1b.rotateAngleY = 0F;
        BalloonFrameLB1b.rotateAngleZ = 0F;
        BalloonFrameLB1b.renderWithRotation(par7);

        BalloonFrameLT2a1.rotateAngleX = 0F;
        BalloonFrameLT2a1.rotateAngleY = 0F;
        BalloonFrameLT2a1.rotateAngleZ = 0F;
        BalloonFrameLT2a1.renderWithRotation(par7);

        BalloonFrameLT2a2.rotateAngleX = 0F;
        BalloonFrameLT2a2.rotateAngleY = 0F;
        BalloonFrameLT2a2.rotateAngleZ = 0F;
        BalloonFrameLT2a2.renderWithRotation(par7);

        BalloonFrameLT2b1.rotateAngleX = 0F;
        BalloonFrameLT2b1.rotateAngleY = 0F;
        BalloonFrameLT2b1.rotateAngleZ = 0F;
        BalloonFrameLT2b1.renderWithRotation(par7);

        BalloonFrameLT2b2.rotateAngleX = 0F;
        BalloonFrameLT2b2.rotateAngleY = 0F;
        BalloonFrameLT2b2.rotateAngleZ = 0F;
        BalloonFrameLT2b2.renderWithRotation(par7);

        BalloonFrameLB2a1.rotateAngleX = 0F;
        BalloonFrameLB2a1.rotateAngleY = 0F;
        BalloonFrameLB2a1.rotateAngleZ = 0F;
        BalloonFrameLB2a1.renderWithRotation(par7);

        BalloonFrameLB2a2.rotateAngleX = 0F;
        BalloonFrameLB2a2.rotateAngleY = 0F;
        BalloonFrameLB2a2.rotateAngleZ = 0F;
        BalloonFrameLB2a2.renderWithRotation(par7);

        BalloonFrameLB2b1.rotateAngleX = 0F;
        BalloonFrameLB2b1.rotateAngleY = 0F;
        BalloonFrameLB2b1.rotateAngleZ = 0F;
        BalloonFrameLB2b1.renderWithRotation(par7);

        BalloonFrameLB2b2.rotateAngleX = 0F;
        BalloonFrameLB2b2.rotateAngleY = 0F;
        BalloonFrameLB2b2.rotateAngleZ = 0F;
        BalloonFrameLB2b2.renderWithRotation(par7);

        JointL1a.rotateAngleX = 0F;
        JointL1a.rotateAngleY = 0F;
        JointL1a.rotateAngleZ = 0F;
        JointL1a.renderWithRotation(par7);

        JointL1b.rotateAngleX = 0F;
        JointL1b.rotateAngleY = 0F;
        JointL1b.rotateAngleZ = 0F;
        JointL1b.renderWithRotation(par7);

        BalloonFrameFrontLeftDial.rotateAngleX = 0F;
        BalloonFrameFrontLeftDial.rotateAngleY = 0F;
        BalloonFrameFrontLeftDial.rotateAngleZ = 0F;
        BalloonFrameFrontLeftDial.renderWithRotation(par7);

        BackEngineR.rotateAngleX = 0F;
        BackEngineR.rotateAngleY = 0F;
        BackEngineR.rotateAngleZ = 0F;
        BackEngineR.renderWithRotation(par7);

    }

}
