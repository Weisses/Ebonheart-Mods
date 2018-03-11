package com.viesis.viescraft.client.entity.model;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitParticlesVCRender;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class ModelAirshipPropeller extends ModelBase {
	
	private float bladespin;
	private long lastframe;
	
	//fields
	ModelRenderer Propeller_1a;
	ModelRenderer Propeller_1b;
	ModelRenderer Propeller_1c;
	
	public ModelAirshipPropeller()
	{
		textureWidth = 256;
		textureHeight = 128;
		
		Propeller_1a = new ModelRenderer(this, 6, 76);
		Propeller_1a.addBox(-1F, -1F, -2F, 2, 2, 4);
		Propeller_1a.setRotationPoint(0F, 0F, 11F);
		Propeller_1a.setTextureSize(256, 128);
		Propeller_1a.mirror = true;
		setRotation(Propeller_1a, 0F, 0F, 0F);
		Propeller_1b = new ModelRenderer(this, 0, 76);
		Propeller_1b.addBox(-1F, -4F, 0F, 2, 8, 1);
		Propeller_1b.setRotationPoint(0F, 0F, 11F);
		Propeller_1b.setTextureSize(256, 128);
		Propeller_1b.mirror = true;
		setRotation(Propeller_1b, 0F, 0F, 0F);
		Propeller_1c = new ModelRenderer(this, 0, 86);
		Propeller_1c.addBox(-4F, -1F, 0F, 8, 2, 1);
		Propeller_1c.setRotationPoint(0F, 0F, 11F);
		Propeller_1c.setTextureSize(256, 128);
		Propeller_1c.mirror = true;
		setRotation(Propeller_1c, 0F, 0F, 0F);
	}
	
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		
		Propeller_1a.render(f5);
		Propeller_1b.render(f5);
		Propeller_1c.render(f5);
		
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		if(!Minecraft.getMinecraft().isGamePaused())
		{
			/**
			 * SOOOO OLD!
			long now = System.nanoTime();
			int elapsed = (int) ((now - lastframe) / (1000000));
			// 1000000 nanoseconds = .001 seconds
			bladespin = (float) elapsed / 300.0f;
			// 0.001 seconds / 300 = 3.3333 repeating.
			lastframe = now;
		    
			Propeller_R1a.rotateAngleZ += (bladespin * 3);
			Propeller_R1b.rotateAngleZ += (bladespin * 3);
			Propeller_R1c.rotateAngleZ += (bladespin * 3);
			Propeller_L1a.rotateAngleZ += (bladespin * 3);
			Propeller_L1b.rotateAngleZ += (bladespin * 3);
			Propeller_L1c.rotateAngleZ += (bladespin * 3);
			
			
			int randomTick = References.random.nextInt(100) + 1;
			
			if(randomTick < 20)
			{
				InitParticlesVCRender.generateSmokeParticles(entity);
			}*/
		}
	}
}
