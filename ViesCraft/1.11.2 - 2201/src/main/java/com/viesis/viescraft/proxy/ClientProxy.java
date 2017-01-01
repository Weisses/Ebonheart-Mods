package com.viesis.viescraft.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

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
		
		//InitEntityV1VCRender.registerRenders();
		//InitEntityV2VCRender.registerRenders();
		//InitEntityV3VCRender.registerRenders();
		//InitEntityV4VCRender.registerRenders();
		
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
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleSprint = new EntitySmokeFX(
	    	theEntity.world, 
	    	theEntity.posX - (double)(MathHelper.sin(-theEntity.rotationYaw * 0.017453292F) * 01.005F), 
	    	theEntity.posY + 0.5D, 
	        theEntity.posZ - (double)(MathHelper.cos(theEntity.rotationYaw * 0.017453292F) * 01.005F), 
	        motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleSprint);        
	}
}
