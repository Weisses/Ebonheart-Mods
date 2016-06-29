// Date: 6/25/2016 5:29:31 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.viesis.viescraft.client.model;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipVC extends ModelBase
{
	private float bladespin;
	private long lastframe;
	
  //fields
    ModelRenderer Balloon_1a;
    ModelRenderer Base_1a;
    ModelRenderer Base_Seat_1a;
    ModelRenderer Base_Seat_1b;
    ModelRenderer Base_Side_1a;
    ModelRenderer Base_Side_1b;
    ModelRenderer Base_Side_2a;
    ModelRenderer Base_Side_2b;
    ModelRenderer Anchor_1a;
    ModelRenderer Anchor_1b;
    ModelRenderer Anchor_1c;
    ModelRenderer Anchor_1d;
    ModelRenderer Anchor_2a;
    ModelRenderer Anchor_2b;
    ModelRenderer Anchor_2c;
    ModelRenderer Anchor_2d;
    ModelRenderer Rope_1a;
    ModelRenderer Rope_1b;
    ModelRenderer Rope_1c;
    ModelRenderer Rope_1d;
    ModelRenderer Base_Front_1a;
    ModelRenderer Base_Front_1c;
    ModelRenderer Base_Back_1a;
    ModelRenderer Base_Back_1c;
    ModelRenderer Base_Corner_F1;
    ModelRenderer Base_Corner_F2;
    ModelRenderer Base_Corner_B1;
    ModelRenderer Base_Corner_B2;
    ModelRenderer Engine_M1a;
    ModelRenderer Engine_M1b;
    ModelRenderer Engine_M1c;
    ModelRenderer Engine_M1d;
    ModelRenderer Engine_R1;
    ModelRenderer Engine_R1a;
    ModelRenderer Engine_R1b;
    ModelRenderer Engine_L1;
    ModelRenderer Engine_L1a;
    ModelRenderer Engine_L1b;
    ModelRenderer Propeller_1a;
    ModelRenderer Propeller_1b;
    ModelRenderer Propeller_1c;
  
  public ModelAirshipVC()
  {
    textureWidth = 256;
    textureHeight = 128;
    
    
      Balloon_1a = new ModelRenderer(this, 128, 64);
      Balloon_1a.addBox(0F, 0F, 0F, 32, 32, 32);
      Balloon_1a.setRotationPoint(-16F, -52F, -16F);
      Balloon_1a.setTextureSize(256, 128);
      Balloon_1a.mirror = true;
      setRotation(Balloon_1a, 0F, 0F, 0F);
      Base_1a = new ModelRenderer(this, 0, 0);
      Base_1a.addBox(0F, 0F, 0F, 14, 2, 24);
      Base_1a.setRotationPoint(-7F, 5F, -12F);
      Base_1a.setTextureSize(256, 128);
      Base_1a.mirror = true;
      setRotation(Base_1a, 0F, 0F, 0F);
      Base_Seat_1a = new ModelRenderer(this, 0, 32);
      Base_Seat_1a.addBox(0F, 0F, 0F, 10, 2, 8);
      Base_Seat_1a.setRotationPoint(-5F, 4F, 3F);
      Base_Seat_1a.setTextureSize(256, 128);
      Base_Seat_1a.mirror = true;
      setRotation(Base_Seat_1a, 0F, 0F, 0F);
      Base_Seat_1b = new ModelRenderer(this, 0, 42);
      Base_Seat_1b.addBox(0F, 0F, 0F, 10, 2, 8);
      Base_Seat_1b.setRotationPoint(-5F, 4F, -6F);
      Base_Seat_1b.setTextureSize(256, 128);
      Base_Seat_1b.mirror = true;
      setRotation(Base_Seat_1b, 0F, 0F, 0F);
      Base_Side_1a = new ModelRenderer(this, 0, 64);
      Base_Side_1a.addBox(0F, 0F, 0F, 1, 4, 26);
      Base_Side_1a.setRotationPoint(8F, 1F, -13F);
      Base_Side_1a.setTextureSize(256, 128);
      Base_Side_1a.mirror = true;
      setRotation(Base_Side_1a, 0F, 0F, 0F);
      Base_Side_1b = new ModelRenderer(this, 92, 0);
      Base_Side_1b.addBox(0F, 0F, 0F, 1, 2, 24);
      Base_Side_1b.setRotationPoint(7F, 4F, -12F);
      Base_Side_1b.setTextureSize(256, 128);
      Base_Side_1b.mirror = true;
      setRotation(Base_Side_1b, 0F, 0F, 0F);
      Base_Side_2a = new ModelRenderer(this, 0, 64);
      Base_Side_2a.addBox(0F, 0F, 0F, 1, 4, 26);
      Base_Side_2a.setRotationPoint(-9F, 1F, -13F);
      Base_Side_2a.setTextureSize(256, 128);
      Base_Side_2a.mirror = true;
      setRotation(Base_Side_2a, 0F, 0F, 0F);
      Base_Side_2b = new ModelRenderer(this, 92, 0);
      Base_Side_2b.addBox(0F, 0F, 0F, 1, 2, 24);
      Base_Side_2b.setRotationPoint(-8F, 4F, -12F);
      Base_Side_2b.setTextureSize(256, 128);
      Base_Side_2b.mirror = true;
      setRotation(Base_Side_2b, 0F, 0F, 0F);
      Anchor_1a = new ModelRenderer(this, 0, 0);
      Anchor_1a.addBox(0F, 0F, 0F, 3, 2, 2);
      Anchor_1a.setRotationPoint(7F, 0F, -10F);
      Anchor_1a.setTextureSize(256, 128);
      Anchor_1a.mirror = true;
      setRotation(Anchor_1a, 0F, 0F, 0F);
      Anchor_1b = new ModelRenderer(this, 0, 4);
      Anchor_1b.addBox(0F, 0F, 0F, 3, 2, 2);
      Anchor_1b.setRotationPoint(-10F, 0F, -10F);
      Anchor_1b.setTextureSize(256, 128);
      Anchor_1b.mirror = true;
      setRotation(Anchor_1b, 0F, 0F, 0F);
      Anchor_1c = new ModelRenderer(this, 0, 8);
      Anchor_1c.addBox(0F, 0F, 0F, 3, 2, 2);
      Anchor_1c.setRotationPoint(-10F, 0F, 8F);
      Anchor_1c.setTextureSize(256, 128);
      Anchor_1c.mirror = true;
      setRotation(Anchor_1c, 0F, 0F, 0F);
      Anchor_1d = new ModelRenderer(this, 0, 12);
      Anchor_1d.addBox(0F, 0F, 0F, 3, 2, 2);
      Anchor_1d.setRotationPoint(7F, 0F, 8F);
      Anchor_1d.setTextureSize(256, 128);
      Anchor_1d.mirror = true;
      setRotation(Anchor_1d, 0F, 0F, 0F);
      Anchor_2a = new ModelRenderer(this, 64, 0);
      Anchor_2a.addBox(0F, 0F, 0F, 3, 2, 3);
      Anchor_2a.setRotationPoint(-14F, -21F, -14F);
      Anchor_2a.setTextureSize(256, 128);
      Anchor_2a.mirror = true;
      setRotation(Anchor_2a, 0F, 0F, 0F);
      Anchor_2b = new ModelRenderer(this, 64, 5);
      Anchor_2b.addBox(0F, 0F, 0F, 3, 2, 3);
      Anchor_2b.setRotationPoint(-14F, -21F, 11F);
      Anchor_2b.setTextureSize(256, 128);
      Anchor_2b.mirror = true;
      setRotation(Anchor_2b, 0F, 0F, 0F);
      Anchor_2c = new ModelRenderer(this, 64, 10);
      Anchor_2c.addBox(0F, 0F, 0F, 3, 2, 3);
      Anchor_2c.setRotationPoint(11F, -21F, -14F);
      Anchor_2c.setTextureSize(256, 128);
      Anchor_2c.mirror = true;
      setRotation(Anchor_2c, 0F, 0F, 0F);
      Anchor_2d = new ModelRenderer(this, 64, 15);
      Anchor_2d.addBox(0F, 0F, 0F, 3, 2, 3);
      Anchor_2d.setRotationPoint(11F, -21F, 11F);
      Anchor_2d.setTextureSize(256, 128);
      Anchor_2d.mirror = true;
      setRotation(Anchor_2d, 0F, 0F, 0F);
      Rope_1a = new ModelRenderer(this, 76, 0);
      Rope_1a.addBox(0F, 0F, 0F, 1, 23, 1);
      Rope_1a.setRotationPoint(12F, -21F, -13F);
      Rope_1a.setTextureSize(256, 128);
      Rope_1a.mirror = true;
      setRotation(Rope_1a, 0.1570796F, 0F, 0.1745329F);
      Rope_1b = new ModelRenderer(this, 80, 0);
      Rope_1b.addBox(0F, 0F, 0F, 1, 23, 1);
      Rope_1b.setRotationPoint(12F, -21F, 12F);
      Rope_1b.setTextureSize(256, 128);
      Rope_1b.mirror = true;
      setRotation(Rope_1b, -0.1570796F, 0F, 0.1745329F);
      Rope_1c = new ModelRenderer(this, 84, 0);
      Rope_1c.addBox(0F, 0F, 0F, 1, 23, 1);
      Rope_1c.setRotationPoint(-13F, -21F, 12F);
      Rope_1c.setTextureSize(256, 128);
      Rope_1c.mirror = true;
      setRotation(Rope_1c, -0.1570796F, 0F, -0.1745329F);
      Rope_1d = new ModelRenderer(this, 88, 0);
      Rope_1d.addBox(0F, 0F, 0F, 1, 23, 1);
      Rope_1d.setRotationPoint(-13F, -21F, -13F);
      Rope_1d.setTextureSize(256, 128);
      Rope_1d.mirror = true;
      setRotation(Rope_1d, 0.1570796F, 0F, -0.1745329F);
      Base_Front_1a = new ModelRenderer(this, 0, 94);
      Base_Front_1a.addBox(0F, 0F, 0F, 16, 4, 1);
      Base_Front_1a.setRotationPoint(-8F, 1F, -14F);
      Base_Front_1a.setTextureSize(256, 128);
      Base_Front_1a.mirror = true;
      setRotation(Base_Front_1a, 0F, 0F, 0F);
      Base_Front_1c = new ModelRenderer(this, 0, 104);
      Base_Front_1c.addBox(0F, 0F, 0F, 16, 2, 1);
      Base_Front_1c.setRotationPoint(-8F, 4F, -13F);
      Base_Front_1c.setTextureSize(256, 128);
      Base_Front_1c.mirror = true;
      setRotation(Base_Front_1c, 0F, 0F, 0F);
      Base_Back_1a = new ModelRenderer(this, 0, 99);
      Base_Back_1a.addBox(0F, 0F, 0F, 16, 4, 1);
      Base_Back_1a.setRotationPoint(-8F, 1F, 13F);
      Base_Back_1a.setTextureSize(256, 128);
      Base_Back_1a.mirror = true;
      setRotation(Base_Back_1a, 0F, 0F, 0F);
      Base_Back_1c = new ModelRenderer(this, 0, 107);
      Base_Back_1c.addBox(0F, 0F, 0F, 16, 2, 1);
      Base_Back_1c.setRotationPoint(-8F, 4F, 12F);
      Base_Back_1c.setTextureSize(256, 128);
      Base_Back_1c.mirror = true;
      setRotation(Base_Back_1c, 0F, 0F, 0F);
      Base_Corner_F1 = new ModelRenderer(this, 0, 64);
      Base_Corner_F1.addBox(0F, 0F, 0F, 1, 5, 1);
      Base_Corner_F1.setRotationPoint(8F, 0F, -14F);
      Base_Corner_F1.setTextureSize(256, 128);
      Base_Corner_F1.mirror = true;
      setRotation(Base_Corner_F1, 0F, 0F, 0F);
      Base_Corner_F2 = new ModelRenderer(this, 4, 64);
      Base_Corner_F2.addBox(0F, 0F, 0F, 1, 5, 1);
      Base_Corner_F2.setRotationPoint(-9F, 0F, -14F);
      Base_Corner_F2.setTextureSize(256, 128);
      Base_Corner_F2.mirror = true;
      setRotation(Base_Corner_F2, 0F, 0F, 0F);
      Base_Corner_B1 = new ModelRenderer(this, 8, 64);
      Base_Corner_B1.addBox(0F, 0F, 0F, 1, 5, 1);
      Base_Corner_B1.setRotationPoint(8F, 0F, 13F);
      Base_Corner_B1.setTextureSize(256, 128);
      Base_Corner_B1.mirror = true;
      setRotation(Base_Corner_B1, 0F, 0F, 0F);
      Base_Corner_B2 = new ModelRenderer(this, 12, 64);
      Base_Corner_B2.addBox(0F, 0F, 0F, 1, 5, 1);
      Base_Corner_B2.setRotationPoint(-9F, 0F, 13F);
      Base_Corner_B2.setTextureSize(256, 128);
      Base_Corner_B2.mirror = true;
      setRotation(Base_Corner_B2, 0F, 0F, 0F);
      Engine_M1a = new ModelRenderer(this, 54, 64);
      Engine_M1a.addBox(0F, 0F, 0F, 6, 6, 6);
      Engine_M1a.setRotationPoint(-3F, 0F, 11F);
      Engine_M1a.setTextureSize(256, 128);
      Engine_M1a.mirror = true;
      setRotation(Engine_M1a, 0F, 0F, 0F);
      Engine_M1b = new ModelRenderer(this, 0, 60);
      Engine_M1b.addBox(0F, 0F, 0F, 12, 2, 2);
      Engine_M1b.setRotationPoint(-6F, 2F, 14F);
      Engine_M1b.setTextureSize(256, 128);
      Engine_M1b.mirror = true;
      setRotation(Engine_M1b, 0F, 0F, 0F);
      Engine_M1c = new ModelRenderer(this, 35, 88);
      Engine_M1c.addBox(0F, 0F, 0F, 8, 1, 1);
      Engine_M1c.setRotationPoint(-4F, 6F, 12F);
      Engine_M1c.setTextureSize(256, 128);
      Engine_M1c.mirror = true;
      setRotation(Engine_M1c, 0F, 0F, 0F);
      Engine_M1d = new ModelRenderer(this, 1, 16);
      Engine_M1d.addBox(0F, 0F, 0F, 2, 4, 2);
      Engine_M1d.setRotationPoint(-1F, -4F, 12F);
      Engine_M1d.setTextureSize(256, 128);
      Engine_M1d.mirror = true;
      setRotation(Engine_M1d, 0F, 0F, 0F);
      Engine_R1 = new ModelRenderer(this, 34, 76);
      Engine_R1.addBox(0F, 0F, 0F, 4, 6, 6);
      Engine_R1.setRotationPoint(-13F, 0F, 0F);
      Engine_R1.setTextureSize(256, 128);
      Engine_R1.mirror = true;
      setRotation(Engine_R1, 0F, 0F, 0F);
      Engine_R1a = new ModelRenderer(this, 54, 76);
      Engine_R1a.addBox(0F, 0F, 0F, 1, 1, 10);
      Engine_R1a.setRotationPoint(-10F, 4F, 5F);
      Engine_R1a.setTextureSize(256, 128);
      Engine_R1a.mirror = true;
      setRotation(Engine_R1a, 0F, 0F, 0F);
      Engine_R1b = new ModelRenderer(this, 54, 84);
      Engine_R1b.addBox(0F, 0F, 0F, 4, 1, 1);
      Engine_R1b.setRotationPoint(-9F, 4F, 14F);
      Engine_R1b.setTextureSize(256, 128);
      Engine_R1b.mirror = true;
      setRotation(Engine_R1b, 0F, 0F, 0F);
      Engine_L1 = new ModelRenderer(this, 34, 64);
      Engine_L1.addBox(0F, 0F, 0F, 4, 6, 6);
      Engine_L1.setRotationPoint(9F, 0F, 0F);
      Engine_L1.setTextureSize(256, 128);
      Engine_L1.mirror = true;
      setRotation(Engine_L1, 0F, 0F, 0F);
      Engine_L1a = new ModelRenderer(this, 54, 87);
      Engine_L1a.addBox(0F, 0F, 0F, 1, 1, 10);
      Engine_L1a.setRotationPoint(9F, 4F, 5F);
      Engine_L1a.setTextureSize(256, 128);
      Engine_L1a.mirror = true;
      setRotation(Engine_L1a, 0F, 0F, 0F);
      Engine_L1b = new ModelRenderer(this, 54, 95);
      Engine_L1b.addBox(0F, 0F, 0F, 4, 1, 1);
      Engine_L1b.setRotationPoint(5F, 4F, 14F);
      Engine_L1b.setTextureSize(256, 128);
      Engine_L1b.mirror = true;
      setRotation(Engine_L1b, 0F, 0F, 0F);
      Propeller_1a = new ModelRenderer(this, 6, 76);
      Propeller_1a.addBox(-1F, -1F, -2F, 2, 2, 4);
      Propeller_1a.setRotationPoint(0F, 3F, 18F);
      Propeller_1a.setTextureSize(256, 128);
      Propeller_1a.mirror = true;
      setRotation(Propeller_1a, 0F, 0F, 0F);
      Propeller_1b = new ModelRenderer(this, 0, 76);
      Propeller_1b.addBox(-1F, -4F, 0F, 2, 8, 1);
      Propeller_1b.setRotationPoint(0F, 3F, 18F);
      Propeller_1b.setTextureSize(256, 128);
      Propeller_1b.mirror = true;
      setRotation(Propeller_1b, 0F, 0F, 0F);
      Propeller_1c = new ModelRenderer(this, 0, 86);
      Propeller_1c.addBox(-4F, -1F, 0F, 8, 2, 1);
      Propeller_1c.setRotationPoint(0F, 3F, 18F);
      Propeller_1c.setTextureSize(256, 128);
      Propeller_1c.mirror = true;
      setRotation(Propeller_1c, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Balloon_1a.render(f5);
    Base_1a.render(f5);
    Base_Seat_1a.render(f5);
    Base_Seat_1b.render(f5);
    Base_Side_1a.render(f5);
    Base_Side_1b.render(f5);
    Base_Side_2a.render(f5);
    Base_Side_2b.render(f5);
    Anchor_1a.render(f5);
    Anchor_1b.render(f5);
    Anchor_1c.render(f5);
    Anchor_1d.render(f5);
    Anchor_2a.render(f5);
    Anchor_2b.render(f5);
    Anchor_2c.render(f5);
    Anchor_2d.render(f5);
    Rope_1a.render(f5);
    Rope_1b.render(f5);
    Rope_1c.render(f5);
    Rope_1d.render(f5);
    Base_Front_1a.render(f5);
    Base_Front_1c.render(f5);
    Base_Back_1a.render(f5);
    Base_Back_1c.render(f5);
    Base_Corner_F1.render(f5);
    Base_Corner_F2.render(f5);
    Base_Corner_B1.render(f5);
    Base_Corner_B2.render(f5);
    Engine_M1a.render(f5);
    Engine_M1b.render(f5);
    Engine_M1c.render(f5);
    Engine_M1d.render(f5);
    Engine_R1.render(f5);
    Engine_R1a.render(f5);
    Engine_R1b.render(f5);
    Engine_L1.render(f5);
    Engine_L1a.render(f5);
    Engine_L1b.render(f5);
    
    if(ViesCraftConfig.modelAnimation)
	{
    	Propeller_1a.render(f5);
    	Propeller_1b.render(f5);
    	Propeller_1c.render(f5);
	}
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    
    
    if(ViesCraftConfig.modelAnimation)
	{
    	long now = System.nanoTime();
    	int elapsed = (int) ((now - lastframe) / (1000000));
    	// 1000000 nanoseconds = .001 seconds
	
    	bladespin = (float) elapsed / 300.0f;
    	// 0.001 seconds / 300 = 3.3333 repeating.
	
    	lastframe = now;
	
    
    	this.Propeller_1a.rotateAngleZ += (bladespin * 2);
    	this.Propeller_1b.rotateAngleZ += (bladespin * 2);
    	this.Propeller_1c.rotateAngleZ += (bladespin * 2);
	}
  }

}
