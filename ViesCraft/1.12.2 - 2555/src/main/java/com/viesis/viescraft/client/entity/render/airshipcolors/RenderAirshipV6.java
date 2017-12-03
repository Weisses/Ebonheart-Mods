package com.viesis.viescraft.client.entity.render.airshipcolors;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.v6.ModelAirshipV6Color;
import com.viesis.viescraft.client.entity.model.v6.ModelAirshipV6FrameOff;
import com.viesis.viescraft.client.entity.model.v6.ModelAirshipV6FrameOn;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV6Core;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirshipV6 extends Render<EntityAirshipV6Core> {
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV6Color = new ModelAirshipV6Color();
	/** Instance of V6-On Model for rendering. */
	protected ModelBase modelAirshipV6FrameOn = new ModelAirshipV6FrameOn();
	/** Instance of V6-Off Model for rendering. */
	protected ModelBase modelAirshipV6FrameOff = new ModelAirshipV6FrameOff();
	/** Instance of the Control Panel Screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private int moduleNumber;
	
    public RenderAirshipV6(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    @Override
    public void doRender(EntityAirshipV6Core entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
		
        //Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        float balloonRed;
        float balloonGreen;
        float balloonBlue;
        
        //Frame
        if(entity.getFrameColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = entity.getFrameColorRed() / 255.0F;
        }
        if(entity.getFrameColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = entity.getFrameColorGreen() / 255.0F;
        }
        if(entity.getFrameColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = entity.getFrameColorBlue() / 255.0F;
        }
        
        //Balloon
        if(entity.getBalloonColorRed() <= 30)
        {
        	balloonRed = 30 / 255.0F;
        }
        else
        {
        	balloonRed = entity.getBalloonColorRed() / 255.0F;
        }
        if(entity.getBalloonColorGreen() <= 30)
        {
        	balloonGreen = 30 / 255.0F;
        }
        else
        {
        	balloonGreen = entity.getBalloonColorGreen() / 255.0F;
        }
        if(entity.getBalloonColorBlue() <= 30)
        {
        	balloonBlue = 30 / 255.0F;
        }
        else
        {
        	balloonBlue = entity.getBalloonColorBlue() / 255.0F;
        }
        
        //Draws the Frame
        //Should this be transparent?
        if(entity.getFrameVisualTransparent())
        {
	        GlStateManager.enableBlend();
    		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        if(entity.getFrameVisualColor())
        {
	        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
	    	
	        if(entity.getPowered() > 0)
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV6FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV6FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        
	    	GlStateManager.color(1F, 1F, 1F, 1F);
	    }
	    else
	    {
	    	if(entity.getPowered() > 0)
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV6FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v6/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV6FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	    }
    	GlStateManager.disableBlend();
    	
        //Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/screens/module_type_" + EnumsVC.ModuleType.byId(entity.getModuleVariantSlot1()).getName() + ".png"));
    	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	//Draws the Balloon
    	if(entity.getBalloonVisualTransparent())
        {
	        GlStateManager.enableBlend();
    		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
    	if(entity.getBalloonVisualColor())
        {
    		GlStateManager.color(balloonRed, balloonGreen, balloonBlue, 1F);
	    	
    		if(entity.getBalloonVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.AirshipTierCore.byId(entity.getMetaTierCore()).getName() +".png"));
        	}
        	else
        	{
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() +".png"));
            }
	    	
	    	this.modelAirshipV6Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    	
	    	GlStateManager.color(1F, 1F, 1F, 1F);
        }
    	else
    	{
    		if(entity.getBalloonVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.AirshipTierCore.byId(entity.getMetaTierCore()).getName() +".png"));
        	}
        	else
        	{
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() +".png"));
            }
    		
        	this.modelAirshipV6Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	}
    	GlStateManager.disableBlend();
    	
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void setupRotation(EntityAirshipV6Core entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
    	float f = (float)entity.getTimeSinceHit() - p_188311_3_;
        float f1 = entity.getDamageTaken() - p_188311_3_;
        
        float g = (float)entity.getTimeSinceHit() - p_188311_3_;
        float g1 = entity.getDamageTaken() - p_188311_3_;
        
        //This actually rotates things!!!!
    	//long angle = (System.currentTimeMillis() / 40) % 360;
        
        if(entity.leftInputDown)
        {
        	GlStateManager.rotate(5, 0.0F, 0.0F, 0.1F);
        }
        
        if(entity.leftInputDown
        && entity.backInputDown)
        {
        	GlStateManager.rotate(10, 0.0F, 0.0F, -0.1F);
        }
        
        if(entity.rightInputDown)
        {
        	GlStateManager.rotate(5, 0.0F, 0.0F, -0.1F);
        }
        
        if(entity.rightInputDown
        && entity.backInputDown)
        {
        	GlStateManager.rotate(10, 0.0F, 0.0F, 0.1F);
        }
        
        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        
        if (f > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F * (float)entity.getForwardDirection(), 0.0F, 0.0F, 1.0F);
        }
        
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }
    
    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F + 0.25F, (float)p_188309_5_);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityAirshipV6Core entity)
    {
        return null;
    }
}
