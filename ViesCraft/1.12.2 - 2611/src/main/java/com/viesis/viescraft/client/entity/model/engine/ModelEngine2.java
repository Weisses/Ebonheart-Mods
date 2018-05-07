package com.viesis.viescraft.client.entity.model.engine;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEngine2 extends ModelBase
{
    ModelRenderer Engine_Pipe;
    ModelRenderer Engine_LeftChassis;
    ModelRenderer Engine_LeftSmokestack;
    ModelRenderer Engine_LeftSmallBox;
    ModelRenderer Engine_RightChassis;
    ModelRenderer Engine_RightSmokestack;
    ModelRenderer Engine_RightSmallBox;

    public ModelEngine2()
    {
        this( 0.0f );
    }

    public ModelEngine2( float par1 )
    {
        Engine_Pipe = new ModelRenderer( this, 28, 20 );
        Engine_Pipe.setTextureSize( 128, 128 );
        Engine_Pipe.addBox( -1.5F, -1F, -1F, 3, 2, 2);
        Engine_Pipe.setRotationPoint( 0F, 3F, 15F );
        Engine_LeftChassis = new ModelRenderer( this, 0, 24 );
        Engine_LeftChassis.setTextureSize( 128, 128 );
        Engine_LeftChassis.addBox( 0.5F, 0F, 0F, 5, 6, 6);
        Engine_LeftChassis.setRotationPoint( 1F, -0.5F, 11F );
        Engine_LeftSmokestack = new ModelRenderer( this, 16, 24 );
        Engine_LeftSmokestack.setTextureSize( 128, 128 );
        Engine_LeftSmokestack.addBox( 0F, 0F, 0F, 2, 4, 2);
        Engine_LeftSmokestack.setRotationPoint( 3F, -4.5F, 14F );
        Engine_LeftSmallBox = new ModelRenderer( this, 0, 36 );
        Engine_LeftSmallBox.setTextureSize( 128, 128 );
        Engine_LeftSmallBox.addBox( -1.5F, -1F, -1F, 3, 2, 2);
        Engine_LeftSmallBox.setRotationPoint( 4F, 3F, 17F );
        Engine_RightChassis = new ModelRenderer( this, 22, 24 );
        Engine_RightChassis.setTextureSize( 128, 128 );
        Engine_RightChassis.addBox( -5.5F, 0F, 0F, 5, 6, 6);
        Engine_RightChassis.setRotationPoint( -1F, -0.5F, 11F );
        Engine_RightSmokestack = new ModelRenderer( this, 38, 24 );
        Engine_RightSmokestack.setTextureSize( 128, 128 );
        Engine_RightSmokestack.addBox( -2F, 0F, 0F, 2, 4, 2);
        Engine_RightSmokestack.setRotationPoint( -3F, -4.5F, 14F );
        Engine_RightSmallBox = new ModelRenderer( this, 10, 36 );
        Engine_RightSmallBox.setTextureSize( 128, 128 );
        Engine_RightSmallBox.addBox( -1.5F, -1F, -1F, 3, 2, 2);
        Engine_RightSmallBox.setRotationPoint( -4F, 3F, 17F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
	   EntityAirshipCore airshipIn = (EntityAirshipCore) par1Entity;
	   
        Engine_Pipe.rotateAngleX = 0F;
        Engine_Pipe.rotateAngleY = 0F;
        Engine_Pipe.rotateAngleZ = 0F;
        Engine_Pipe.renderWithRotation(par7);

        Engine_LeftChassis.rotateAngleX = 0F;
        Engine_LeftChassis.rotateAngleY = 0F;
        Engine_LeftChassis.rotateAngleZ = 0F;
        Engine_LeftChassis.renderWithRotation(par7);

        Engine_LeftSmokestack.rotateAngleX = 0F;
        Engine_LeftSmokestack.rotateAngleY = 0F;
        Engine_LeftSmokestack.rotateAngleZ = 0F;
        Engine_LeftSmokestack.renderWithRotation(par7);

        Engine_LeftSmallBox.rotateAngleX = 0.7853982F;
        Engine_LeftSmallBox.rotateAngleY = 0F;
        Engine_LeftSmallBox.rotateAngleZ = 0F;
        Engine_LeftSmallBox.renderWithRotation(par7);

        Engine_RightChassis.rotateAngleX = 0F;
        Engine_RightChassis.rotateAngleY = 0F;
        Engine_RightChassis.rotateAngleZ = 0F;
        Engine_RightChassis.renderWithRotation(par7);

        Engine_RightSmokestack.rotateAngleX = 0F;
        Engine_RightSmokestack.rotateAngleY = 0F;
        Engine_RightSmokestack.rotateAngleZ = 0F;
        Engine_RightSmokestack.renderWithRotation(par7);

        Engine_RightSmallBox.rotateAngleX = 0.7853982F;
        Engine_RightSmallBox.rotateAngleY = 0F;
        Engine_RightSmallBox.rotateAngleZ = 0F;
        Engine_RightSmallBox.renderWithRotation(par7);
        
        //Airship smoke particles while on
        if(airshipIn.getStoredFuel() > 0)
        {
	        int randomTick = References.random.nextInt(100) + 1;
			
			if(randomTick < 20)
			{
				if(!Minecraft.getMinecraft().isGamePaused())
				{
					InitParticlesVCRender.generateAirshipSmokeParticles2(par1Entity, 0, 0, 0);
				}
			}
        }
    }
}
