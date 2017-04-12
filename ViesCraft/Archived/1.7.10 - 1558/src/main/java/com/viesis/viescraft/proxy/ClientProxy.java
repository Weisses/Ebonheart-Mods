package com.viesis.viescraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.MinecraftForge;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Particle;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.InitBlocksVCRender;
import com.viesis.viescraft.client.InitEntityVCRender;
import com.viesis.viescraft.client.InitItemsVCRender;
import com.viesis.viescraft.client.InitTileEntityVCRender;
import com.viesis.viescraft.client.gui.v1.GuiV1HUD;
import com.viesis.viescraft.client.gui.v2.GuiV2HUD;
import com.viesis.viescraft.client.gui.v3.GuiV3HUD;
import com.viesis.viescraft.client.gui.v4.GuiV4HUD;
import com.viesis.viescraft.client.particle.EntitySmokeFX;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		
		Keybinds.init();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		InitItemsVCRender.registerRenders();
		InitBlocksVCRender.registerRenders();
		InitTileEntityVCRender.registerRenders();
		InitEntityVCRender.registerRenders();
		
		MinecraftForge.EVENT_BUS.register(new GuiV1HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV2HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV3HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV4HUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
	
	//=============================================================
	
	/**
	 * Particles
	 */
	
	@Override
	public void generateSmokeParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    
	    Particle particleSprint = new EntitySmokeFX(
	    	theEntity.worldObj, 
	    	theEntity.posX - (double)(MathHelper.sin(-theEntity.rotationYaw * 0.017453292F) * 01.005F), 
	    	theEntity.posY + 0.5D, 
	        theEntity.posZ - (double)(MathHelper.cos(theEntity.rotationYaw * 0.017453292F) * 01.005F), 
	        motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleSprint);        
	}
	
	
	/**
	@Override
	public void generateSprintParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    Particle particleSprint = new EntitySprintFX(
	    	theEntity.worldObj, 
	    	theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	        theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() * theEntity.height, 
	        theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	        motionX, 
	        motionY, 
	        motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleSprint);        
	}
	
	@Override
	public void generateUnholyParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    Particle particleUnholy = new EntityUnholyFX(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	@Override
	public void generateFlightParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    Particle particleFlight = new EntityFlightFX(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.worldObj.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleFlight);        
	}
	
	@Override
	public void generateEnchEbonParticles(Entity theEntity)
	{
	    double motionX = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.worldObj.rand.nextGaussian() * 0.02D;
	    Particle particleEnchEbon = new EntityEnchEbonFX(
	          theEntity.worldObj, 
	          theEntity.posX + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.1D + theEntity.worldObj.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.worldObj.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleEnchEbon);        
	}
	*/
}
