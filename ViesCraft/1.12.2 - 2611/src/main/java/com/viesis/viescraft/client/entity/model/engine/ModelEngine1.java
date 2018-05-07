package com.viesis.viescraft.client.entity.model.engine;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelEngine1 extends ModelBase
{
    ModelRenderer Engine_Chassis;
    ModelRenderer Engine_Smokestack;
    ModelRenderer Engine_LeftPipe;
    ModelRenderer Engine_RightPipe;

    public ModelEngine1()
    {
        this( 0.0f );
    }

    public ModelEngine1( float par1 )
    {
        Engine_Chassis = new ModelRenderer( this, 0, 0 );
        Engine_Chassis.setTextureSize( 128, 128 );
        Engine_Chassis.addBox( 0F, 0F, 0F, 6, 6, 6);
        Engine_Chassis.setRotationPoint( -3F, -0.5F, 11F );
        Engine_Smokestack = new ModelRenderer( this, 18, 0 );
        Engine_Smokestack.setTextureSize( 128, 128 );
        Engine_Smokestack.addBox( 0F, 0F, 0F, 2, 4, 2);
        Engine_Smokestack.setRotationPoint( -1F, -4.5F, 12F );
        Engine_LeftPipe = new ModelRenderer( this, 0, 12 );
        Engine_LeftPipe.setTextureSize( 128, 128 );
        Engine_LeftPipe.addBox( 4.5F, 0F, 0F, 3, 2, 2);
        Engine_LeftPipe.setRotationPoint( -1.5F, 2F, 14F );
        Engine_RightPipe = new ModelRenderer( this, 0, 12 );
        Engine_RightPipe.setTextureSize( 128, 128 );
        Engine_RightPipe.addBox( -7.5F, 0F, 0F, 3, 2, 2);
        Engine_RightPipe.setRotationPoint( 1.5F, 2F, 14F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
	   EntityAirshipCore airshipIn = (EntityAirshipCore) par1Entity;
	   
        Engine_Chassis.rotateAngleX = 0F;
        Engine_Chassis.rotateAngleY = 0F;
        Engine_Chassis.rotateAngleZ = 0F;
        Engine_Chassis.renderWithRotation(par7);

        Engine_Smokestack.rotateAngleX = 0F;
        Engine_Smokestack.rotateAngleY = 0F;
        Engine_Smokestack.rotateAngleZ = 0F;
        Engine_Smokestack.renderWithRotation(par7);

        Engine_LeftPipe.rotateAngleX = 0F;
        Engine_LeftPipe.rotateAngleY = 0F;
        Engine_LeftPipe.rotateAngleZ = 0F;
        Engine_LeftPipe.renderWithRotation(par7);

        Engine_RightPipe.rotateAngleX = 0F;
        Engine_RightPipe.rotateAngleY = 0F;
        Engine_RightPipe.rotateAngleZ = 0F;
        Engine_RightPipe.renderWithRotation(par7);
        
        //Airship smoke particles while on
        if(airshipIn.getStoredFuel() > 0)
        {
	        int randomTick = References.random.nextInt(100) + 1;
			
			if(randomTick < 20)
			{
				if(!Minecraft.getMinecraft().isGamePaused())
				{
					InitParticlesVCRender.generateAirshipSmokeParticles1(par1Entity, 0, 0.04D, 0);
				}
			}
        }
    }
}
