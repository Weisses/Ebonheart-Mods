package com.viesis.viescraft.client.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanelold;
import com.viesis.viescraft.client.entity.model.ModelAirshipPropeller;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Balloon;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Frame;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2Balloon;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2Frame;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Balloon;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Frame;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4Balloon;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4Frame;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.init.InitBlocksVC;

@SideOnly(Side.CLIENT)
public class RenderAirship extends Render<EntityAirshipCore> {
	
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
	
	/** Instance of Panel Screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	/** Instance of Propeller Model for rendering. */
	protected ModelBase modelAirshipPropeller = new ModelAirshipPropeller();
	
	private ModelBase modelFrame;
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
        
        float bladespin1 = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        float bladespin = bladespin1 * 9;
        
        //Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        float balloonRed;
        float balloonGreen;
        float balloonBlue;
        
        //Frame Colors
        if(entity.getFrameSkinColorRed() <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = entity.getFrameSkinColorRed() / 255.0F;
        }
        if(entity.getFrameSkinColorBlue() <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = entity.getFrameSkinColorBlue() / 255.0F;
        }
        if(entity.getFrameSkinColorGreen() <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = entity.getFrameSkinColorGreen() / 255.0F;
        }
        
        //Balloon Colors
        if(entity.getBalloonPatternColorRed() <= 30)
        {
        	balloonRed = 30 / 255.0F;
        }
        else
        {
        	balloonRed = entity.getBalloonPatternColorRed() / 255.0F;
        }
        if(entity.getBalloonPatternColorBlue() <= 30)
        {
        	balloonBlue = 30 / 255.0F;
        }
        else
        {
        	balloonBlue = entity.getBalloonPatternColorBlue() / 255.0F;
        }
        if(entity.getBalloonPatternColorGreen() <= 30)
        {
        	balloonGreen = 30 / 255.0F;
        }
        else
        {
        	balloonGreen = entity.getBalloonPatternColorGreen() / 255.0F;
        }
        
        
        
        //Changes models based on airship Core meta
        if(entity.getCoreModelVisualFrame() == 1)
        {
        	modelFrame = this.modelAirshipV1Frame;
        	modelBalloon = this.modelAirshipV1Balloon;
        	
        	//Propellers
            if(entity.getCoreModelVisualFrame() == 1)
            {
            	//Right Propeller
            	GlStateManager.pushMatrix();
    	        {
    	        	GlStateManager.translate(-0.874, 0.064, 0);
    	        	
    	        	if(entity.getStoredFuel() > 0)
    		        {
    	        		GlStateManager.rotate(bladespin, 0F, 0F, 1F);
    		        }
    	        	
    		        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.VisualFrameSkin.byId(entity.getFrameSkinVisual()).getRegistryName() + ".png"));
    		        modelAirshipPropeller.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
    	        }
    	        GlStateManager.popMatrix();
    	        
            	//Left Propeller
    	        GlStateManager.pushMatrix();
    	        {
    	        	GlStateManager.translate(0.874, 0.064, 0);
    	        	
    	        	if(entity.getStoredFuel() > 0)
    		        {
    	        		GlStateManager.rotate(-bladespin, 0F, 0F, 1F);
    		        }
    	        	
    		        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.VisualFrameSkin.byId(entity.getFrameSkinVisual()).getRegistryName() + ".png"));
    		        modelAirshipPropeller.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
    	        }
    	        GlStateManager.popMatrix();
            }
        }
        else if(entity.getCoreModelVisualFrame() == 2)
        {
        	modelFrame = this.modelAirshipV2Frame;
        	modelBalloon = this.modelAirshipV2Balloon;
        }
        else if(entity.getCoreModelVisualFrame() == 3)
        {
        	modelFrame = this.modelAirshipV3Frame;
        	modelBalloon = this.modelAirshipV3Balloon;
        }
        else if(entity.getCoreModelVisualFrame() == 4)
        {
        	modelFrame = this.modelAirshipV4Frame;
        	modelBalloon = this.modelAirshipV4Balloon;
        }
        else
        {
        	modelFrame = this.modelAirshipV1Frame;
        	modelBalloon = this.modelAirshipV1Balloon;
        }
        
        
        
    	
        
        //Frame Logic
        if(entity.getFrameSkinVisualTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        if(entity.getFrameSkinVisualColor())
        {
        	GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        	
        	if(entity.getFrameSkinVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getRegistryName() + ".png"));
        	}
        	else
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.VisualFrameSkin.byId(entity.getFrameSkinVisual()).getRegistryName() + ".png"));
        	}
        	
        	modelFrame.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        
	        GlStateManager.color(1F, 1F, 1F, 1F);
        }
        else
        {
        	if(entity.getFrameSkinVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getRegistryName() + ".png"));
        	}
        	else
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_" + EnumsVC.VisualFrameSkin.byId(entity.getFrameSkinVisual()).getRegistryName() + ".png"));
        	}
        	
        	modelFrame.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        GlStateManager.disableBlend();
        
        
        
        //Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel.png"));
    	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	
    	
        //Balloon Logic
        if(entity.getBalloonPatternVisualTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        if(entity.getBalloonPatternVisualColor())
        {
        	GlStateManager.color(balloonRed, balloonGreen, balloonBlue, 1F);
        	
	        if(entity.getBalloonPatternVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getRegistryName() + ".png"));
        	}
        	else
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloonPattern.byId(entity.getBalloonPatternVisual()).getRegistryName() + ".png"));
        	}
        	
        	modelBalloon.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        
	        GlStateManager.color(1F, 1F, 1F, 1F);
        }
        else
        {
        	if(entity.getBalloonPatternVisual() == 0)
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getRegistryName() + ".png"));
        	}
        	else
        	{
        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloonPattern.byId(entity.getBalloonPatternVisual()).getRegistryName() + ".png"));
        	}
        	
        	modelBalloon.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        GlStateManager.disableBlend();
        
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
        
        
        //Control panel item renderer
        if(entity.getMainTierCore() != 0)
        {
	        //Core Upgrade
	        this.renderItemOnPanel(entity, 0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_CORE, 1, entity.getMainTierCore()));
        }
        if(entity.getMainTierFrame() != 0)
        {
	        //Frame Upgrade
	        this.renderItemOnPanel(entity, 0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_FRAME, 1, entity.getMainTierFrame()));
        }
        if(entity.getMainTierEngine() != 0)
        {
	        //Engine Upgrade
	        this.renderItemOnPanel(entity, -0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_ENGINE, 1, entity.getMainTierEngine()));
        }
        if(entity.getMainTierBalloon() != 0)
        {
	        //Balloon Upgrade
	        this.renderItemOnPanel(entity, -0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_BALLOON, 1, entity.getMainTierBalloon()));
        }
        
        
        
        if(!entity.inventory.getStackInSlot(0).isEmpty())
        {
	        //Fuel
	        this.renderItemOnPanel(entity, 0.93, 0.43, -5.59, entity.inventory.getStackInSlot(0));
        }
        //L2
        //this.renderItemOnPanel(entity, 0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        //L3
        //this.renderItemOnPanel(entity, -0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        if(entity.getModuleActiveSlot1() != 0)
        {
        	//Module
        	this.renderItemOnPanel(entity, -0.93, 0.43, -5.59, new ItemStack(ItemsVC.MODULE_TYPE, 1, entity.getModuleActiveSlot1()));
        }
        
        
        
        //Front rotating item
        this.renderItemOnDisplay(entity, 0, 0.6, -4.5, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 0.25, 0.25, 0.25, bladespin1, 2, 0F);
    	
        
    	//Left item
        this.renderItemOnDisplay(entity, 1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, bladespin, 0, 270.0F);
    	
        //Right item
        this.renderItemOnDisplay(entity, -1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, bladespin, 0, 90.0F);
        
        
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
        
        float bladespin1 = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        float bladespin = bladespin1 * 9;
        
        //Changes models based on airship Core meta
        if(entity.getCoreModelVisualFrame() == 1)
        {
        	modelFrame = this.modelAirshipV1Frame;
        	modelBalloon = this.modelAirshipV1Balloon;
        	
        	//Propellers
            if(entity.getCoreModelVisualFrame() == 1)
            {
            	//Right Propeller
            	GlStateManager.pushMatrix();
    	        {
    	        	GlStateManager.translate(-0.874, 0.064, 0);
    	        	
    	        	if(entity.getStoredFuel() > 0)
    		        {
    	        		GlStateManager.rotate(bladespin, 0F, 0F, 1F);
    		        }
    	        	
    		        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_overlay_v" + entity.getCoreModelVisualFrame() + ".png"));
    		        modelAirshipPropeller.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
    	        }
    	        GlStateManager.popMatrix();
    	        
            	//Left Propeller
    	        GlStateManager.pushMatrix();
    	        {
    	        	GlStateManager.translate(0.874, 0.064, 0);
    	        	
    	        	if(entity.getStoredFuel() > 0)
    		        {
    	        		GlStateManager.rotate(-bladespin, 0F, 0F, 1F);
    		        }
    	        	
    	        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_overlay_v" + entity.getCoreModelVisualFrame() + ".png"));
    		        modelAirshipPropeller.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
    	        }
    	        GlStateManager.popMatrix();
            }
        }
        else if(entity.getCoreModelVisualFrame() == 2)
        {
        	modelFrame = this.modelAirshipV2Frame;
        	modelBalloon = this.modelAirshipV2Balloon;
        }
        else if(entity.getCoreModelVisualFrame() == 3)
        {
        	modelFrame = this.modelAirshipV3Frame;
        	modelBalloon = this.modelAirshipV3Balloon;
        }
        else if(entity.getCoreModelVisualFrame() == 4)
        {
        	modelFrame = this.modelAirshipV4Frame;
        	modelBalloon = this.modelAirshipV4Balloon;
        }
        else
        {
        	modelFrame = this.modelAirshipV1Frame;
        	modelBalloon = this.modelAirshipV1Balloon;
        }
        
        
        
        //Frame Logic
        if(entity.getFrameSkinVisualTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_overlay_v" + entity.getCoreModelVisualFrame() + ".png"));
    	modelFrame.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
        
        /**
        //Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/screens/module_type_" + EnumsVC.ModuleType.byId(entity.getModuleActiveSlot1()).getName() + ".png"));
    	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
        //Balloon Logic
        if(entity.getBalloonVisualTransparent())
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        if(entity.getBalloonVisualColor())
        {
        	GlStateManager.color(balloonRed, balloonGreen, balloonBlue, 1F);
        	
	        if(entity.getStoredFuel() > 0)
	        {
	        	if(entity.getBalloonVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getName() + ".png"));
	        	}
	        	else
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() + ".png"));
	        	}
	        	
	        	modelColor.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getBalloonVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getName() + ".png"));
	        	}
	        	else
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() + ".png"));
	        	}
	        	
	        	modelColor.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        
	        GlStateManager.color(1F, 1F, 1F, 1F);
        }
        else
        {
        	if(entity.getStoredFuel() > 0)
	        {
	        	if(entity.getBalloonVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getName() + ".png"));
	        	}
	        	else
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() + ".png"));
	        	}
	        	
	        	modelColor.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getBalloonVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.AirshipTierCore.byId(entity.getMainTierCore()).getName() + ".png"));
	        	}
	        	else
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/visualballoon_bg_" + EnumsVC.VisualBalloon.byId(entity.getBalloonVisual()).getName() + ".png"));
	        	}
	        	
	        	modelColor.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
        }
        GlStateManager.disableBlend();
        */
        
        
        
        
        //if(!this.getBalloonVisualColor())
        //{
        //	this.metaBalloonColorRed = 200;
        //	this.metaBalloonColorGreen = 180;
        //	this.metaBalloonColorBlue = 140;
        //}
        
    	//this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.AirshipTierBalloon.byId(entity.getMetaTierBalloon()).getName() +".png"));
    	//this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
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