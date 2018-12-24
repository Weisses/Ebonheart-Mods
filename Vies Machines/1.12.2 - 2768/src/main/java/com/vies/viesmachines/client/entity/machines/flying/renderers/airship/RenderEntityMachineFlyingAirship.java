package com.vies.viesmachines.client.entity.machines.flying.renderers.airship;

import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.InitParticlesVMRender;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityMachineFlyingAirship extends RenderEntityMachineFlyingAirshipBase {
	
	//==================================================
    // TODO             Constructor
	//==================================================
	
	public RenderEntityMachineFlyingAirship(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn)
    {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
        this.shadowSize = 1.0F;
    }
    
	
	
	//==================================================
    // TODO            Render Logic
	//==================================================
    
	/** Enable multiple textures on one model. */
    @Override
    public boolean isMultipass()
    {
        return true;
    }
    
	@Override
    public void doRender(EntityMachineFlyingAirship entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
    	// Needed to fix the texture overlap clipping:
    	GL11.glEnable(GL11.GL_CULL_FACE);
        
    	// Initial setup:
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        // Sets all models correctly depending on machine values:
        this.getCurrentModelAirshipFramePrimary(entity);
        this.getCurrentModelAirshipFrameSecondary(entity);
        this.getCurrentModelAirshipEnginePrimary(entity);
        this.getCurrentModelAirshipEngineSecondary(entity);
        this.getCurrentModelAirshipComponentPrimary(entity);
        this.getCurrentModelAirshipComponentSecondary(entity);
        
        //==================================================
        
        // Create temporary colors:
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = entity.getVisualFrameColorRed() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = entity.getVisualFrameColorBlue() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualFrameColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = entity.getVisualFrameColorGreen() / 255.0F;
        }
        
        //==================================================
        
        // Render the Frame ONLY:
        if (entity.getPreviewPart() == 1)
        {
        	this.resetColorTransparency();
        	
        	this.renderEngineDisplaySymbol(entity, partialTicks);
            this.selectedModelControlPanel(entity, partialTicks);
            
            this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
            // Renders the Primary Frame:
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            // Renders the Display Banner:
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
        	// Renders the skids when a machine is on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
        }
        // Render the Engine ONLY:
        else if (entity.getPreviewPart() == 2)
        {
        	this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
        	// Renders the Primary Engine:
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Component ONLY:
        else if (entity.getPreviewPart() == 3)
        {
        	this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
        	// Renders the Primary Component:
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            // Renders the Component Propellers:
            this.airshipPropellersRegular(entity, frameRed, frameGreen, frameBlue);
        }
        // Render the WHOLE machine: (Primary)
        else
        {
        	this.resetColorTransparency();
        	 
        	this.renderEngineDisplaySymbol(entity, partialTicks);
            this.selectedModelControlPanel(entity, partialTicks);
            
            // Transparency check:
            if(entity.getVisualFrameTransparent())
            {
            	GlStateManager.enableBlend();
            	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }
            
            this.frameTextureColorChecking(entity, frameRed, frameGreen, frameBlue);
            
            // Renders the Display Banner:
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Renders the skids when a machine is on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	this.modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Renders the Frame ONLY:
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            // Renders the Engine ONLY:
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            // Renders the Component ONLY:
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            // Renders the Component Propellers:
            this.airshipPropellersRegular(entity, frameRed, frameGreen, frameBlue);
        }
        
        this.resetColorTransparency();
        
        
        
        //==================================================
        
        
        
        // Create temporary colors:
        float componentRed;
        float componentGreen;
        float componentBlue;
        
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorRed() <= 30)
        {
        	componentRed = 30 / 255.0F;
        }
        else
        {
        	componentRed = entity.getVisualComponentColorRed() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorBlue() <= 30)
        {
        	componentBlue = 30 / 255.0F;
        }
        else
        {
        	componentBlue = entity.getVisualComponentColorBlue() / 255.0F;
        }
        // Fix for Black Color. If 0 was allowed, you would not see the texture at all:
        if(entity.getVisualComponentColorGreen() <= 30)
        {
        	componentGreen = 30 / 255.0F;
        }
        else
        {
        	componentGreen = entity.getVisualComponentColorGreen() / 255.0F;
        }
        
        //==================================================
        
        this.componentTextureColorChecking(entity, componentRed, componentGreen, componentBlue);
        
        // Render the Secondary Frame ONLY:
        if (entity.getPreviewPart() == 1)
        {
        	this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Secondary Engine ONLY:
        else if (entity.getPreviewPart() == 2)
        {
        	this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Secondary Component ONLY:
        else if (entity.getPreviewPart() == 3)
        {
        	this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the WHOLE machine: (Secondary)
        else
        {
            // Transparency check:
            if(entity.getVisualComponentTransparent())
            {
            	GlStateManager.enableBlend();
            	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            }
            
            // Renders the Frame ONLY:
            this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            // Renders the Engine ONLY:
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            // Renders the Component ONLY:
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        
        this.resetColorTransparency();
        
        
        
        //==================================================
        
        
        
        // Responsible for Display Banner item rotation:
        if(this.baseitemSpin >= 360)
        {
        	this.baseitemSpin = 0;
        }
        else
        {
        	this.baseitemSpin = (this.baseitemSpin + 0.1F);
        }
        
        
        
        //==================================================
        
        
        
        // Renders engine smoke when a machine is on:
        if (entity.isFuelBurning())
        {
        	int randomTick = References.random.nextInt(100) + 1;
    		
        	if (entity.getVisualModelEngine() == 0)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVMRender.generateAirshipSmokeParticles0(entity, 0, -0.15, 0);
        			}
        		}
        	}
        	if (entity.getVisualModelEngine() == 1)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVMRender.generateAirshipSmokeParticles1(entity, 0, -0.05, 0);
        			}
        		}
        	}
        	if (entity.getVisualModelEngine() == 2)
        	{
        		if (randomTick < 20)
        		{
        			if (!Minecraft.getMinecraft().isGamePaused())
        			{
        				InitParticlesVMRender.generateAirshipSmokeParticles2(entity, 0, 0, 0);
        			}
        		}
        	}
        }
		
        // Need to remove the texture overlap clipping fix at the end.
    	GL11.glDisable(GL11.GL_CULL_FACE);
        
        
        
        //==================================================
        
        
    	
        // Renders all hover-over machine info:
        if(VMConfiguration.renderNameplates)
    	{
        	this.renderMachineInfo(entity);
    	}
        
        
        
        //==================================================
        
        
    	
        //Messes up for some reason? May have to fix but could just ditch.
        //if (!this.renderOutlines)
        //{
        //    this.renderLeash(entity, x, y, z, entityYaw, partialTicks);
        //}
        
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    public void renderMultipass(EntityMachineFlyingAirship entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();

    	// Needed to fix the texture overlap clipping:
    	GL11.glEnable(GL11.GL_CULL_FACE);
        
    	// Initial setup:
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        // Sets all models correctly depending on machine values:
        this.getCurrentModelAirshipFramePrimary(entity);
        this.getCurrentModelAirshipFrameSecondary(entity);
        this.getCurrentModelAirshipEnginePrimary(entity);
        this.getCurrentModelAirshipEngineSecondary(entity);
        this.getCurrentModelAirshipComponentPrimary(entity);
        this.getCurrentModelAirshipComponentSecondary(entity);
        
        //==================================================
        
        // Render the Primary Frame ONLY:
        if (entity.getPreviewPart() == 1)
        {
        	// Draws the Main Control Panel Screen 'Power' gauge:
            if (entity.getPoweredOn())
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_on.png"));
            }
            else
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_off.png"));
            }
        	
            // Renders the Main Control Panel Screen:
            this.modelMachineControlPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
            // Binds and Renders the Frame overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        	
            // Binds and Renders the Display Banner overlay:
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Binds and Renders the Frame overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_frame_secondary.png"));
            this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Primary Engine ONLY:
        else if (entity.getPreviewPart() == 2)
        {
        	// Binds and Renders the Engine overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_engine_primary.png"));
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders the Engine overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_engine_secondary.png"));
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        }
        // Render the Primary Component ONLY:
        else if (entity.getPreviewPart() == 3)
        {
        	// Binds and Renders the Component overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_component_primary.png"));
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders the Component overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_component_secondary.png"));
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders the Component Propeller overlay:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_propeller.png"));
        	this.airshipPropellersMultipass(entity);
        }
        // Render the WHOLE machine: (Primary)
        else
        {
        	// Draws the Main Control Panel Screen 'Power' gauge:
            if (entity.getPoweredOn())
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_on.png"));
            }
            else
            {
            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel_off.png"));
            }
        	
            // Renders the Main Control Panel Screen:
            this.modelMachineControlPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
            // Binds and Renders the Frame overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_frame_primary.png"));
            this.currentModelFramePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Renders skids when a machine in on the ground:
            if (entity.status == entity.status.ON_LAND)
            {
            	 modelAirshipSkids.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Binds and Renders the Display Banner overlay:
            if (entity.getVisualEngineDisplayType() > 0)
            {
            	this.modelAirshipFrameDisplayBannerStand.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            }
            
            // Binds and Renders the Frame overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_frame_secondary.png"));
            this.currentModelFrameSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders Engine overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_engine_primary.png"));
            this.currentModelEnginePrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders Engine overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_engine_secondary.png"));
            this.currentModelEngineSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders Component overlay: (Primary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_component_primary.png"));
            this.currentModelComponentPrimary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders Component overlay: (Secondary)
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_component_secondary.png"));
            this.currentModelComponentSecondary.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
            
            // Binds and Renders the Component Propeller overlay:
            this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_propeller.png"));
        	this.airshipPropellersMultipass(entity);
        }
        
        // Need to remove the texture overlap clipping fix at the end.
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
    
    
    
    
    
    
    
    
    
    
    

    

    /** Main Airship Propeller logic. */
    protected void airshipPropellersRegular(EntityMachineFlyingAirship entity, float componentRed, float componentGreen, float componentBlue)
    {
    	this.componentTextureColorChecking(entity, componentRed, componentGreen, componentBlue);
    	
        // Component model 0 positioning:
    	if (entity.getVisualModelComponent() == 0)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
    	// Component model 1 positioning:
    	if (entity.getVisualModelComponent() == 1)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	        	this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
    	// Component model 2 positioning:
    	if (entity.getVisualModelComponent() == 2)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(1.125F, -0.131F, 0.2425F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-1.125F, -0.131F, 0.2425F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
    }
    
    /** Overlay Airship Propeller logic. */
    protected void airshipPropellersMultipass(EntityMachineFlyingAirship entity)
    {
    	// Binds the Component Propeller overlay:
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/overlay_airship_propeller.png"));
        
        // Component model 0 positioning:
    	if (entity.getVisualModelComponent() == 0)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.910F, -0.0675F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
    	// Component model 1 positioning:
    	if (entity.getVisualModelComponent() == 1)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-0.968F, -0.08F, 0F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
        
    	// Component model 2 positioning:
    	if (entity.getVisualModelComponent() == 2)
        {
        	// Left:
        	GlStateManager.pushMatrix();
        	{
	        	GlStateManager.translate(1.125F, -0.131F, 0.2425F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(-entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
        	}
        	GlStateManager.popMatrix();
            
            // Right:
            GlStateManager.pushMatrix();
            {
	            GlStateManager.translate(-1.125F, -0.131F, 0.2425F);
	        	
	        	if(entity.isFuelBurning())
	        	{
		        	// Spins propeller:
			        GlStateManager.rotate(entity.updateTick * 25, 0F, 0F, 1F);
	        	}
	        	
	            this.modelAirshipPropeller.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            }
        	GlStateManager.popMatrix();
        }
    }
    
    /** Checks to see if frame coloring should be applied and binds the correct texture. */
    private void frameTextureColorChecking(EntityMachineFlyingAirship entity, float frameRed, float frameGreen, float frameBlue)
    {
    	// Coloring check:
        if(entity.getVisualFrameColor())
        {
        	// Color logic applied:
        	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        	
        	if (entity.getVisualFrameTexture() >= 1000)
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/holidays/grayscale_bg_" + EnumsVM.VisualTextureHoliday.byId(entity.getVisualFrameTexture() - 1000).getRegistryName() + ".png"));
        	}
        	else
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/grayscale_bg_" + EnumsVM.VisualMachineTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        	}
        }
        else
        {
        	if (entity.getVisualFrameTexture() >= 1000)
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/holidays/bg_" + EnumsVM.VisualTextureHoliday.byId(entity.getVisualFrameTexture() - 1000).getRegistryName() + ".png"));
        	}
        	else
        	{
        		// Texture to bind:
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/bg_" + EnumsVM.VisualMachineTexture.byId(entity.getVisualFrameTexture()).getRegistryName() + ".png"));
        	}
        }
    }
    
    /** Checks to see if component coloring should be applied and binds the correct texture. */
    private void componentTextureColorChecking(EntityMachineFlyingAirship entity, float componentRed, float componentGreen, float componentBlue)
    {
    	// Coloring check:
        if(entity.getVisualComponentColor())
        {
        	// Color logic applied:
        	GlStateManager.color(componentRed, componentGreen, componentBlue, 1F);
        	
        	if (entity.getVisualComponentTexture() >= 1000)
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/holidays/grayscale_bg_" + EnumsVM.VisualTextureHoliday.byId(entity.getVisualComponentTexture() - 1000).getRegistryName() + ".png"));
        	}
        	else
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/grayscale_bg_" + EnumsVM.VisualMachineTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        	}
        }
        else
        {
        	if (entity.getVisualComponentTexture() >= 1000)
        	{
        		// Texture to bind:
                this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/holidays/bg_" + EnumsVM.VisualTextureHoliday.byId(entity.getVisualComponentTexture() - 1000).getRegistryName() + ".png"));
        	}
        	else
        	{
        		// Texture to bind:
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/machines/bg_" + EnumsVM.VisualMachineTexture.byId(entity.getVisualComponentTexture()).getRegistryName() + ".png"));
        	}
        }
    }
    
    /** Resets the colors and turns off transparency. */
    private void resetColorTransparency()
    {
    	// Reset the colors:
    	GlStateManager.color(1F, 1F, 1F, 1F);
    	// Turn off transparency:
        GlStateManager.disableBlend();
    }
}
