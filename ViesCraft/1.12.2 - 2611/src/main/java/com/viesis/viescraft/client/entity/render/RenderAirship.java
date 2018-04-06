package com.viesis.viescraft.client.entity.render;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.ModelAirshipPropeller;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonB0;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonB1;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonF0;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonF1;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame0;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame1;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Balloon;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Frame;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2Balloon;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2Frame;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Balloon;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Frame;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4Balloon;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4Frame;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirship extends Render<EntityAirshipCore> {
	
	//Frames
	protected ModelBase modelFrame0 = new ModelFrame0();
	protected ModelBase modelFrame1 = new ModelFrame1();
	
	
	
	//Default Balloon
	protected ModelBase modelBalloonF0 = new ModelBalloonF0();
	protected ModelBase modelBalloonB0 = new ModelBalloonB0();
		
	//Viesdenburg Balloon
	protected ModelBase modelBalloonF1 = new ModelBalloonF1();
	protected ModelBase modelBalloonB1 = new ModelBalloonB1();
	
	
	

	/** Instance of Panel Screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	/** Instance of Propeller Model for rendering. */
	protected ModelBase modelAirshipPropeller = new ModelAirshipPropeller();
	
	
	
	
	/** Instance of V1 Balloon Model for rendering. */
	protected ModelBase modelAirshipV1Balloon = new ModelAirshipV1Balloon();
	/** Instance of V1 Frame Model for rendering. */
	protected ModelBase modelAirshipV1Frame = new ModelAirshipV1Frame();
	
	/** Instance of V2 Balloon Model for rendering. */
	protected ModelBase modelAirshipV2Balloon = new ModelAirshipV2Balloon();
	/** Instance of V2 Frame Model for rendering. */
	protected ModelBase modelAirshipV2Frame = new ModelAirshipV2Frame();
	
	/** Instance of V3 Balloon Model for rendering. */
	protected ModelBase modelAirshipV3Balloon = new ModelAirshipV3Balloon();
	/** Instance of V3 Frame Model for rendering. */
	protected ModelBase modelAirshipV3Frame = new ModelAirshipV3Frame();
	
	/** Instance of V4 Balloon Model for rendering. */
	protected ModelBase modelAirshipV4Balloon = new ModelAirshipV4Balloon();
	/** Instance of V4 Frame Model for rendering. */
	protected ModelBase modelAirshipV4Frame = new ModelAirshipV4Frame();
	
	
	private ModelBase currentModelFrame;
	
	private ModelBase currentModelBalloonF;
	private ModelBase currentModelBalloonB;
	
	private ModelBase currentModelEngine;
	
	
	private ModelBase modelBalloon;
	private int moduleNumber;
	
    public RenderAirship(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    @Override
    public boolean isMultipass()
    {
        return true;
    }
    
    @Override
    public void doRender(EntityAirshipCore entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.getCurrentModelFrame(entity);
        this.getCurrentModelBalloonF(entity);
        this.getCurrentModelBalloonB(entity);
        
    	this.selectedModelMainFrame(entity, partialTicks);
    	this.selectedModelMainBalloonF(entity, partialTicks);
    	this.selectedModelMainBalloonB(entity, partialTicks);
        
    	this.selectedModelControlPanel(entity, partialTicks);
    	
        
        
    	//Airship smoke particles while on
        if(entity.getStoredFuel() > 0)
        {
	        int randomTick = References.random.nextInt(100) + 1;
			
			if(randomTick < 20)
			{
				if(!Minecraft.getMinecraft().isGamePaused())
				{
					InitParticlesVCRender.generateAirshipSmokeParticles(entity);
				}
			}
        }
        
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    public void renderMultipass(EntityAirshipCore entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.getCurrentModelFrame(entity);
        this.getCurrentModelBalloonF(entity);
        this.getCurrentModelBalloonB(entity);
        
        this.selectedModelMultiFrame(entity, partialTicks);
    	this.selectedModelMultiBalloonF(entity, partialTicks);
    	//this.selectedModelMultiBalloonB(entity, partialTicks);
        
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
    
    public void setupRotation(EntityAirshipCore entity, float p_188311_2_, float p_188311_3_)
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
    protected ResourceLocation getEntityTexture(EntityAirshipCore entity)
    {
        return null;
    }
    
    /**
     * Places an item for display on an airship model.
     */
    private void renderItemOnDisplay(EntityAirshipCore airshipIn, double posXIn, double posYIn, double posZIn, 
    		ItemStack itemstackIn, double scaleXIn, double scaleYIn, double scaleZIn, 
    		float spinIn, int spinModIn, float yTransformIn)
    {
        GlStateManager.pushMatrix();
        
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        if(itemstackIn.getItem() instanceof ItemBlock)
        {
        	GlStateManager.scale(scaleXIn, scaleYIn, scaleZIn);
            GlStateManager.translate(posXIn, posYIn + 0.06, posZIn + 0.0005);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the Y axis
            GlStateManager.rotate(yTransformIn, 0.0F, 1.0F, 0.0F);
            //Spins item
            GlStateManager.rotate(spinIn * spinModIn, 0F, 1F, 0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        else
        {
        	GlStateManager.scale(scaleXIn, scaleYIn, scaleZIn);
            GlStateManager.translate(posXIn, posYIn, posZIn);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the Y axis
            GlStateManager.rotate(yTransformIn, 0.0F, 1.0F, 0.0F);
            //Spins item
            GlStateManager.rotate(spinIn * spinModIn, 0F, 1F, 0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        
		GlStateManager.popMatrix();
    }
    
    /**
     * Places an item on the control panel.
     */
    private void renderItemOnPanel(EntityAirshipCore airshipIn, double posXIn, double posYIn, double posZIn, ItemStack itemstackIn)
    {
    	GlStateManager.pushMatrix();
        
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        if(itemstackIn.getItem() instanceof ItemBlock)
        {
        	GlStateManager.scale(0.14, 0.14, 0.14);
            GlStateManager.translate(posXIn, posYIn + 0.05, posZIn + 0.05);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the X axis
            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        else
        {
        	GlStateManager.scale(0.14, 0.14, 0.14);
            GlStateManager.translate(posXIn, posYIn, posZIn);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the X axis
            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        
		GlStateManager.popMatrix();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * This is the Frame Model for the Main Render Method.
     */
    private void selectedModelMainFrame(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.getFrameSkinColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.getFrameSkinColorRed() / 255.0F;
        }
        if(airshipIn.getFrameSkinColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.getFrameSkinColorBlue() / 255.0F;
        }
        if(airshipIn.getFrameSkinColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.getFrameSkinColorGreen() / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.getFrameSkinTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
    	currentModelFrame.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Frame Model for the Multipass Render Method.
     */
    private void selectedModelMultiFrame(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Frame Logic
        if(airshipIn.getFrameSkinTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_" + airshipIn.getCoreModelVisualFrame() + ".png"));
        currentModelFrame.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    
    
    /**
     * This is the Balloon Frame Model for the Main Render Method.
     */
    private void selectedModelMainBalloonF(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.getFrameSkinColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.getFrameSkinColorRed() / 255.0F;
        }
        if(airshipIn.getFrameSkinColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.getFrameSkinColorBlue() / 255.0F;
        }
        if(airshipIn.getFrameSkinColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.getFrameSkinColorGreen() / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.getFrameSkinTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
    	currentModelBalloonF.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Frame Model for the Multipass Render Method.
     */
    private void selectedModelMultiBalloonF(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Frame Logic
        if(airshipIn.getFrameSkinTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay_balloon_" + airshipIn.getCoreModelVisualBalloon() + ".png"));
        currentModelBalloonF.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    
    
    /**
     * This is the Balloon Model for the Main Render Method.
     */
    private void selectedModelMainBalloonB(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float balloonRed;
        float balloonGreen;
        float balloonBlue;
        
        //Balloon Colors
        if(airshipIn.getBalloonPatternColorRed() <= 30)
        {
        	balloonRed = 30 / 255.0F;
        }
        else
        {
        	balloonRed = airshipIn.getBalloonPatternColorRed() / 255.0F;
        }
        if(airshipIn.getBalloonPatternColorBlue() <= 30)
        {
        	balloonBlue = 30 / 255.0F;
        }
        else
        {
        	balloonBlue = airshipIn.getBalloonPatternColorBlue() / 255.0F;
        }
        if(airshipIn.getBalloonPatternColorGreen() <= 30)
        {
        	balloonGreen = 30 / 255.0F;
        }
        else
        {
        	balloonGreen = airshipIn.getBalloonPatternColorGreen() / 255.0F;
        }
        
        //Balloon Logic
        if(airshipIn.getBalloonPatternTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(balloonRed, balloonGreen, balloonBlue, 1F);
    	
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/bg_" + EnumsVC.VisualBalloonPattern.byId(airshipIn.getBalloonPatternTexture()).getRegistryName() + ".png"));
    	currentModelBalloonB.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Model for the Multipass Render Method.
     */
    private void selectedModelMultiBalloonB(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Balloon Logic
        if(airshipIn.getBalloonPatternTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/overlay_" + EnumsVC.VisualBalloonPattern.byId(airshipIn.getBalloonPatternTexture()).getRegistryName() + ".png"));
        currentModelBalloonB.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Control Panel Model for the Main Render Method.
     */
    private void selectedModelControlPanel(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel.png"));
    	this.modelAirshipPanel.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
        //Control panel item renderer
        if(airshipIn.getMainTierCore() != 0)
        {
	        //Core Upgrade
	        this.renderItemOnPanel(airshipIn, 0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_CORE, 1, airshipIn.getMainTierCore()));
        }
        if(airshipIn.getMainTierFrame() != 0)
        {
	        //Frame Upgrade
	        this.renderItemOnPanel(airshipIn, 0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_FRAME, 1, airshipIn.getMainTierFrame()));
        }
        if(airshipIn.getMainTierEngine() != 0)
        {
	        //Engine Upgrade
	        this.renderItemOnPanel(airshipIn, -0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_ENGINE, 1, airshipIn.getMainTierEngine()));
        }
        if(airshipIn.getMainTierBalloon() != 0)
        {
	        //Balloon Upgrade
	        this.renderItemOnPanel(airshipIn, -0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_BALLOON, 1, airshipIn.getMainTierBalloon()));
        }
        
        
        
        if(!airshipIn.inventory.getStackInSlot(0).isEmpty())
        {
	        //Fuel
	        this.renderItemOnPanel(airshipIn, 0.93, 0.43, -5.59, airshipIn.inventory.getStackInSlot(0));
        }
        //L2
        //this.renderItemOnPanel(entity, 0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        //L3
        //this.renderItemOnPanel(entity, -0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        if(airshipIn.getModuleActiveSlot1() != 0)
        {
        	//Module
        	this.renderItemOnPanel(airshipIn, -0.93, 0.43, -5.59, new ItemStack(ItemsVC.MODULE_TYPE, 1, airshipIn.getModuleActiveSlot1()));
        }
        
        
        
        float bladespin = (((float)airshipIn.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        
        //Front rotating item
        this.renderItemOnDisplay(airshipIn, 0, 0.6, -4.5, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 0.25, 0.25, 0.25, bladespin, 2, 0F);
    	
        
    	//Left item
        this.renderItemOnDisplay(airshipIn, 1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, 0, 0, 270.0F);
    	
        //Right item
        this.renderItemOnDisplay(airshipIn, -1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, 0, 0, 90.0F);
        
        
    }
    
    
    
    
    
    private ModelBase getCurrentModelFrame(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.getCoreModelVisualFrame())
    	{
	    	case 0:
	    		return currentModelFrame = this.modelFrame0;
	    	case 1:
	    		return currentModelFrame = this.modelFrame1;
	    	//case 2:
	    	//	return currentModelFrame = this.modelFrame2;
	    	//case 3:
	    	//	return currentModelFrame = this.modelFrame3;
	    	//case 4:
	    	//	return currentModelFrame = this.modelFrame4;
	    	default:
	    		return currentModelFrame = this.modelFrame0;
    	}
    }
    
    private ModelBase getCurrentModelBalloonF(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.getCoreModelVisualBalloon())
    	{
	    	case 0:
	    		return currentModelBalloonF = this.modelBalloonF0;
	    	case 1:
	    		return currentModelBalloonF = this.modelBalloonF1;
	    	//case 2:
	    	//	return currentModelBalloonF = this.modelBalloonF2;
	    	//case 3:
	    	//	return currentModelBalloonF = this.modelBalloonF3;
	    	//case 4:
	    	//	return currentModelBalloonF = this.modelBalloonF4;
	    	default:
	    		return currentModelBalloonF = this.modelBalloonF0;
    	}
    }
    private ModelBase getCurrentModelBalloonB(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.getCoreModelVisualBalloon())
    	{
	    	case 0:
	    		return currentModelBalloonB = this.modelBalloonB0;
	    	case 1:
	    		return currentModelBalloonB = this.modelBalloonB1;
	    	//case 2:
	    	//	return currentModelBalloonB = this.modelBalloonB2;
	    	//case 3:
	    	//	return currentModelBalloonB = this.modelBalloonB3;
	    	//case 4:
	    	//	return currentModelBalloonB = this.modelBalloonB4;
	    	default:
	    		return currentModelBalloonB = this.modelBalloonB0;
    	}
    }
}




























/**



else if(entity.getModuleSpeedMinor())
{
	this.moduleNumber = 3;
	
    //int randomTick = Reference.random.nextInt(100) + 1;
		
	//if(randomTick < 30)
	//{
		//InitParticlesVCRender.generateRunicParticles(entity);
	//	InitParticlesVCRender.generateColorFlameParticles(entity);
	//}
}
else if(entity.getModuleSpeedMajor())
{
	this.moduleNumber = 4;
	
	//if(randomTick < 25)
	//{
	//	InitParticlesVCRender.generateFlameParticles(entity);
	//}
}
 */