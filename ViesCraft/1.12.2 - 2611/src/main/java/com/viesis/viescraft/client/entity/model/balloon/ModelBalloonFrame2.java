package com.viesis.viescraft.client.entity.model.balloon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBalloonFrame2 extends ModelBase
{
    ModelRenderer Engine_R1;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_FL2a;
    ModelRenderer Engine_FR2a;
    ModelRenderer Pipe_L1a;
    ModelRenderer Pipe_L1b;
    ModelRenderer Pipe_R1a;
    ModelRenderer Pipe_R1b;
    ModelRenderer BalloonFrameRMa;
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
    ModelRenderer AnchorRa;
    ModelRenderer JointR1a;
    ModelRenderer JointR1b;
    ModelRenderer BalloonFrameLMa;
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
    ModelRenderer AnchorLa;
    ModelRenderer JointL1a;
    ModelRenderer JointL1b;
    ModelRenderer BackEngineL;
    ModelRenderer BackEngineR;

    public ModelBalloonFrame2()
    {
        this( 0.0f );
    }

    public ModelBalloonFrame2( float par1 )
    {
        Engine_R1 = new ModelRenderer( this, 34, 76 );
        Engine_R1.setTextureSize( 256, 128 );
        Engine_R1.addBox( 0F, 1F, 0F, 4, 6, 6);
        Engine_R1.setRotationPoint( -13F, -2F, 6F );
        Engine_L1 = new ModelRenderer( this, 34, 64 );
        Engine_L1.setTextureSize( 256, 128 );
        Engine_L1.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_L1.setRotationPoint( 9F, -1F, 6F );
        Engine_FL2a = new ModelRenderer( this, 102, 76 );
        Engine_FL2a.setTextureSize( 256, 128 );
        Engine_FL2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FL2a.setRotationPoint( 15F, -2F, -3F );
        Engine_FR2a = new ModelRenderer( this, 102, 64 );
        Engine_FR2a.setTextureSize( 256, 128 );
        Engine_FR2a.addBox( 0F, 0F, 0F, 4, 6, 6);
        Engine_FR2a.setRotationPoint( -19F, -2F, -3F );
        Pipe_L1a = new ModelRenderer( this, 78, 99 );
        Pipe_L1a.setTextureSize( 256, 128 );
        Pipe_L1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_L1a.setRotationPoint( 13F, 3F, 9F );
        Pipe_L1b = new ModelRenderer( this, 78, 92 );
        Pipe_L1b.setTextureSize( 256, 128 );
        Pipe_L1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_L1b.setRotationPoint( 17F, 3F, 3F );
        Pipe_R1a = new ModelRenderer( this, 78, 99 );
        Pipe_R1a.setTextureSize( 256, 128 );
        Pipe_R1a.addBox( 0F, 0F, 0F, 5, 1, 1);
        Pipe_R1a.setRotationPoint( -18F, 3F, 9F );
        Pipe_R1b = new ModelRenderer( this, 78, 92 );
        Pipe_R1b.setTextureSize( 256, 128 );
        Pipe_R1b.addBox( 0F, 0F, 0F, 1, 1, 6);
        Pipe_R1b.setRotationPoint( -18F, 3F, 3F );
        BalloonFrameRMa = new ModelRenderer( this, 240, 0 );
        BalloonFrameRMa.setTextureSize( 256, 128 );
        BalloonFrameRMa.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameRMa.setRotationPoint( -20F, -5F, -14F );
        BalloonFrameRT1a = new ModelRenderer( this, 202, 101 );
        BalloonFrameRT1a.setTextureSize( 256, 128 );
        BalloonFrameRT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1a.setRotationPoint( -12.5F, -7.5F, -12.5F );
        BalloonFrameRT1b = new ModelRenderer( this, 200, 100 );
        BalloonFrameRT1b.setTextureSize( 256, 128 );
        BalloonFrameRT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRT1b.setRotationPoint( -22.5F, -7.5F, -12.5F );
        BalloonFrameRB1a = new ModelRenderer( this, 198, 99 );
        BalloonFrameRB1a.setTextureSize( 256, 128 );
        BalloonFrameRB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1a.setRotationPoint( -12.5F, 2.5F, -12.5F );
        BalloonFrameRB1b = new ModelRenderer( this, 196, 98 );
        BalloonFrameRB1b.setTextureSize( 256, 128 );
        BalloonFrameRB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameRB1b.setRotationPoint( -22.5F, 2.5F, -12.5F );
        BalloonFrameRT2a1 = new ModelRenderer( this, 192, 95 );
        BalloonFrameRT2a1.setTextureSize( 256, 128 );
        BalloonFrameRT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2a1.setRotationPoint( -13.5F, -6.5F, -13.5F );
        BalloonFrameRT2a2 = new ModelRenderer( this, 189, 93 );
        BalloonFrameRT2a2.setTextureSize( 256, 128 );
        BalloonFrameRT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2a2.setRotationPoint( -14.5F, -5.5F, -14.5F );
        BalloonFrameRT2b1 = new ModelRenderer( this, 188, 93 );
        BalloonFrameRT2b1.setTextureSize( 256, 128 );
        BalloonFrameRT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRT2b1.setRotationPoint( -21.5F, -6.5F, -13.5F );
        BalloonFrameRT2b2 = new ModelRenderer( this, 185, 91 );
        BalloonFrameRT2b2.setTextureSize( 256, 128 );
        BalloonFrameRT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRT2b2.setRotationPoint( -20.5F, -5.5F, -14.5F );
        BalloonFrameRB2a1 = new ModelRenderer( this, 184, 91 );
        BalloonFrameRB2a1.setTextureSize( 256, 128 );
        BalloonFrameRB2a1.addBox( 0F, 0F, -1F, 1, 1, 28);
        BalloonFrameRB2a1.setRotationPoint( -13.5F, 1.5F, -12.5F );
        BalloonFrameRB2a2 = new ModelRenderer( this, 181, 89 );
        BalloonFrameRB2a2.setTextureSize( 256, 128 );
        BalloonFrameRB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2a2.setRotationPoint( -14.5F, 0.5F, -14.5F );
        BalloonFrameRB2b1 = new ModelRenderer( this, 180, 89 );
        BalloonFrameRB2b1.setTextureSize( 256, 128 );
        BalloonFrameRB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameRB2b1.setRotationPoint( -21.5F, 1.5F, -13.5F );
        BalloonFrameRB2b2 = new ModelRenderer( this, 177, 87 );
        BalloonFrameRB2b2.setTextureSize( 256, 128 );
        BalloonFrameRB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameRB2b2.setRotationPoint( -20.5F, 0.5F, -14.5F );
        AnchorRa = new ModelRenderer( this, 0, 0 );
        AnchorRa.setTextureSize( 256, 128 );
        AnchorRa.addBox( -0.5F, 0F, 0F, 3, 2, 6);
        AnchorRa.setRotationPoint( -9.5F, 0.5F, -3F );
        JointR1a = new ModelRenderer( this, 10, 0 );
        JointR1a.setTextureSize( 256, 128 );
        JointR1a.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1a.setRotationPoint( -8.5F, 1.5F, -2F );
        JointR1b = new ModelRenderer( this, 10, 0 );
        JointR1b.setTextureSize( 256, 128 );
        JointR1b.addBox( -4F, -0.5F, -0.5F, 4, 1, 1);
        JointR1b.setRotationPoint( -8.5F, 1.5F, 2F );
        BalloonFrameLMa = new ModelRenderer( this, 240, 8 );
        BalloonFrameLMa.setTextureSize( 256, 128 );
        BalloonFrameLMa.addBox( 0F, 0F, 0F, 6, 6, 2);
        BalloonFrameLMa.setRotationPoint( 14F, -5F, -14F );
        BalloonFrameLT1a = new ModelRenderer( this, 202, 101 );
        BalloonFrameLT1a.setTextureSize( 256, 128 );
        BalloonFrameLT1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1a.setRotationPoint( 21.5F, -7.5F, -12.5F );
        BalloonFrameLT1b = new ModelRenderer( this, 200, 100 );
        BalloonFrameLT1b.setTextureSize( 256, 128 );
        BalloonFrameLT1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLT1b.setRotationPoint( 11.5F, -7.5F, -12.5F );
        BalloonFrameLB1a = new ModelRenderer( this, 198, 99 );
        BalloonFrameLB1a.setTextureSize( 256, 128 );
        BalloonFrameLB1a.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1a.setRotationPoint( 21.5F, 2.5F, -12.5F );
        BalloonFrameLB1b = new ModelRenderer( this, 196, 98 );
        BalloonFrameLB1b.setTextureSize( 256, 128 );
        BalloonFrameLB1b.addBox( 0F, 0F, 0F, 1, 1, 26);
        BalloonFrameLB1b.setRotationPoint( 11.5F, 2.5F, -12.5F );
        BalloonFrameLT2a1 = new ModelRenderer( this, 192, 95 );
        BalloonFrameLT2a1.setTextureSize( 256, 128 );
        BalloonFrameLT2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2a1.setRotationPoint( 20.5F, -6.5F, -13.5F );
        BalloonFrameLT2a2 = new ModelRenderer( this, 189, 93 );
        BalloonFrameLT2a2.setTextureSize( 256, 128 );
        BalloonFrameLT2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2a2.setRotationPoint( 19.5F, -5.5F, -14.5F );
        BalloonFrameLT2b1 = new ModelRenderer( this, 188, 93 );
        BalloonFrameLT2b1.setTextureSize( 256, 128 );
        BalloonFrameLT2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLT2b1.setRotationPoint( 12.5F, -6.5F, -13.5F );
        BalloonFrameLT2b2 = new ModelRenderer( this, 185, 91 );
        BalloonFrameLT2b2.setTextureSize( 256, 128 );
        BalloonFrameLT2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLT2b2.setRotationPoint( 13.5F, -5.5F, -14.5F );
        BalloonFrameLB2a1 = new ModelRenderer( this, 184, 91 );
        BalloonFrameLB2a1.setTextureSize( 256, 128 );
        BalloonFrameLB2a1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2a1.setRotationPoint( 20.5F, 1.5F, -13.5F );
        BalloonFrameLB2a2 = new ModelRenderer( this, 181, 89 );
        BalloonFrameLB2a2.setTextureSize( 256, 128 );
        BalloonFrameLB2a2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2a2.setRotationPoint( 19.5F, 0.5F, -14.5F );
        BalloonFrameLB2b1 = new ModelRenderer( this, 180, 89 );
        BalloonFrameLB2b1.setTextureSize( 256, 128 );
        BalloonFrameLB2b1.addBox( 0F, 0F, 0F, 1, 1, 28);
        BalloonFrameLB2b1.setRotationPoint( 12.5F, 1.5F, -13.5F );
        BalloonFrameLB2b2 = new ModelRenderer( this, 177, 87 );
        BalloonFrameLB2b2.setTextureSize( 256, 128 );
        BalloonFrameLB2b2.addBox( 0F, 0F, 0F, 1, 1, 29);
        BalloonFrameLB2b2.setRotationPoint( 13.5F, 0.5F, -14.5F );
        AnchorLa = new ModelRenderer( this, 0, 0 );
        AnchorLa.setTextureSize( 256, 128 );
        AnchorLa.addBox( -0.5F, 0F, 0F, 3, 2, 6);
        AnchorLa.setRotationPoint( 7.5F, 0.5F, -3F );
        JointL1a = new ModelRenderer( this, 10, 0 );
        JointL1a.setTextureSize( 256, 128 );
        JointL1a.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1a.setRotationPoint( 8.5F, 1.5F, 2F );
        JointL1b = new ModelRenderer( this, 10, 0 );
        JointL1b.setTextureSize( 256, 128 );
        JointL1b.addBox( 0F, -0.5F, -0.5F, 4, 1, 1);
        JointL1b.setRotationPoint( 8.5F, 1.5F, -2F );
        BackEngineL = new ModelRenderer( this, 92, 9 );
        BackEngineL.setTextureSize( 256, 128 );
        BackEngineL.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineL.setRotationPoint( 13F, -6F, 13F );
        BackEngineR = new ModelRenderer( this, 92, 0 );
        BackEngineR.setTextureSize( 256, 128 );
        BackEngineR.addBox( 0F, 0F, 0F, 8, 8, 1);
        BackEngineR.setRotationPoint( -21F, -6F, 13F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Engine_R1.rotateAngleX = 0F;
        Engine_R1.rotateAngleY = 0F;
        Engine_R1.rotateAngleZ = 0F;
        Engine_R1.renderWithRotation(par7);

        Engine_L1.rotateAngleX = 0F;
        Engine_L1.rotateAngleY = 0F;
        Engine_L1.rotateAngleZ = 0F;
        Engine_L1.renderWithRotation(par7);

        Engine_FL2a.rotateAngleX = 0F;
        Engine_FL2a.rotateAngleY = 0F;
        Engine_FL2a.rotateAngleZ = 0F;
        Engine_FL2a.renderWithRotation(par7);

        Engine_FR2a.rotateAngleX = 0F;
        Engine_FR2a.rotateAngleY = 0F;
        Engine_FR2a.rotateAngleZ = 0F;
        Engine_FR2a.renderWithRotation(par7);

        Pipe_L1a.rotateAngleX = 0F;
        Pipe_L1a.rotateAngleY = 0F;
        Pipe_L1a.rotateAngleZ = 0F;
        Pipe_L1a.renderWithRotation(par7);

        Pipe_L1b.rotateAngleX = 0F;
        Pipe_L1b.rotateAngleY = 0F;
        Pipe_L1b.rotateAngleZ = 0F;
        Pipe_L1b.renderWithRotation(par7);

        Pipe_R1a.rotateAngleX = 0F;
        Pipe_R1a.rotateAngleY = 0F;
        Pipe_R1a.rotateAngleZ = 0F;
        Pipe_R1a.renderWithRotation(par7);

        Pipe_R1b.rotateAngleX = 0F;
        Pipe_R1b.rotateAngleY = 0F;
        Pipe_R1b.rotateAngleZ = 0F;
        Pipe_R1b.renderWithRotation(par7);

        BalloonFrameRMa.rotateAngleX = 0F;
        BalloonFrameRMa.rotateAngleY = 0F;
        BalloonFrameRMa.rotateAngleZ = 0F;
        BalloonFrameRMa.renderWithRotation(par7);

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

        AnchorRa.rotateAngleX = 0F;
        AnchorRa.rotateAngleY = 0F;
        AnchorRa.rotateAngleZ = 0F;
        AnchorRa.renderWithRotation(par7);

        JointR1a.rotateAngleX = 0F;
        JointR1a.rotateAngleY = 0F;
        JointR1a.rotateAngleZ = 0F;
        JointR1a.renderWithRotation(par7);

        JointR1b.rotateAngleX = 0F;
        JointR1b.rotateAngleY = 0F;
        JointR1b.rotateAngleZ = 0F;
        JointR1b.renderWithRotation(par7);

        BalloonFrameLMa.rotateAngleX = 0F;
        BalloonFrameLMa.rotateAngleY = 0F;
        BalloonFrameLMa.rotateAngleZ = 0F;
        BalloonFrameLMa.renderWithRotation(par7);

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

        AnchorLa.rotateAngleX = 0F;
        AnchorLa.rotateAngleY = 0F;
        AnchorLa.rotateAngleZ = 0F;
        AnchorLa.renderWithRotation(par7);

        JointL1a.rotateAngleX = 0F;
        JointL1a.rotateAngleY = 0F;
        JointL1a.rotateAngleZ = 0F;
        JointL1a.renderWithRotation(par7);

        JointL1b.rotateAngleX = 0F;
        JointL1b.rotateAngleY = 0F;
        JointL1b.rotateAngleZ = 0F;
        JointL1b.renderWithRotation(par7);

        BackEngineL.rotateAngleX = 0F;
        BackEngineL.rotateAngleY = 0F;
        BackEngineL.rotateAngleZ = 0F;
        BackEngineL.renderWithRotation(par7);

        BackEngineR.rotateAngleX = 0F;
        BackEngineR.rotateAngleY = 0F;
        BackEngineR.rotateAngleZ = 0F;
        BackEngineR.renderWithRotation(par7);

    }

}
