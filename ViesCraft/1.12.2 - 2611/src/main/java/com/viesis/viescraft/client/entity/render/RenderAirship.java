package com.viesis.viescraft.client.entity.render;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Color;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOff;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOn;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2Color;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2FrameOff;
import com.viesis.viescraft.client.entity.model.v2.ModelAirshipV2FrameOn;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Color;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3FrameOff;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3FrameOn;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4Color;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4FrameOff;
import com.viesis.viescraft.client.entity.model.v4.ModelAirshipV4FrameOn;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirship extends Render<EntityAirshipCore> {
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV1Color = new ModelAirshipV1Color();
	/** Instance of V1-On Model for rendering. */
	protected ModelBase modelAirshipV1FrameOn = new ModelAirshipV1FrameOn();
	/** Instance of V1-Off Model for rendering. */
	protected ModelBase modelAirshipV1FrameOff = new ModelAirshipV1FrameOff();
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV2Color = new ModelAirshipV2Color();
	/** Instance of V2-On Model for rendering. */
	protected ModelBase modelAirshipV2FrameOn = new ModelAirshipV2FrameOn();
	/** Instance of V2-Off Model for rendering. */
	protected ModelBase modelAirshipV2FrameOff = new ModelAirshipV2FrameOff();
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV3Color = new ModelAirshipV3Color();
	/** Instance of V3-On Model for rendering. */
	protected ModelBase modelAirshipV3FrameOn = new ModelAirshipV3FrameOn();
	/** Instance of V3-Off Model for rendering. */
	protected ModelBase modelAirshipV3FrameOff = new ModelAirshipV3FrameOff();
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV4Color = new ModelAirshipV4Color();
	/** Instance of V4-On Model for rendering. */
	protected ModelBase modelAirshipV4FrameOn = new ModelAirshipV4FrameOn();
	/** Instance of V4-Off Model for rendering. */
	protected ModelBase modelAirshipV4FrameOff = new ModelAirshipV4FrameOff();
	
	/** Instance of the Control Panel Screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private int moduleNumber;
	
    public RenderAirship(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    public static final ResourceLocation[] TEST_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(References.MOD_ID, "textures/models/frames/visualframe_bg_plank_oak.png"),
		new ResourceLocation(References.MOD_ID, "textures/models/test/overlay_0.png"),
		
	};
    
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
        
        float angle = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		
        this.renderItemOnAirship(entity, 0, 0, 0, new ItemStack(Items.IRON_INGOT, 1), 0.5, 0.5, 0.5, angle, 1);
    	
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEST_TEXTURE[0]);
    	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	//if(entity.metaTierType == 3
    	//		|| entity.metaTierType == 5)
    	//{
    	//	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/screens/module_type_" + EnumsVC.ModuleType.byId(entity.getModuleVariantSlot1()).getName() + ".png"));
        //	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	//}
    	
    	//LogHelper.info("Type = " + entity.metaTierType);
    	
        
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
        
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEST_TEXTURE[1]);
    	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
    	

        
        //if(!this.getBalloonVisualColor())
        //{
        //	this.metaBalloonColorRed = 210;
        //	this.metaBalloonColorGreen = 180;
        //	this.metaBalloonColorBlue = 140;
        //}
        
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.AirshipTierBalloon.byId(entity.getMetaTierBalloon()).getName() +".png"));
    	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
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
     * Places an item on an airship model.
     */
    private void renderItemOnAirship(EntityAirshipCore airshipIn, double posXIn, double posYIn, double posZIn, 
    		ItemStack itemstackIn, double scaleXIn, double scaleYIn, double scaleZIn, 
    		float spinIn, int spinModIn)
    {
        ItemStack itemstack = itemstackIn;
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        
        GlStateManager.scale(scaleXIn, scaleYIn, scaleZIn);
        GlStateManager.translate(posXIn, posYIn, posZIn);
        
        /////Flips the model right side up.
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        
        //Spins item
        GlStateManager.rotate(spinIn * spinModIn, 0F, 1F, 0F);
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		
		GlStateManager.popMatrix();
    }
}




























/**

@SideOnly(Side.CLIENT)
public class RenderAirshipV1 extends Render<EntityAirshipV1Core> {
	
	/** Instance of Color Model for rendering. *
	protected ModelBase modelAirshipV1Color = new ModelAirshipV1Color();
	/** Instance of V1-On Model for rendering. *
	protected ModelBase modelAirshipV1FrameOn = new ModelAirshipV1FrameOn();
	/** Instance of V1-Off Model for rendering. *
	protected ModelBase modelAirshipV1FrameOff = new ModelAirshipV1FrameOff();
	/** Instance of the Control Panel Screen Model for rendering. *
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private int moduleNumber;
	
    public RenderAirshipV1(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    public static final ResourceLocation[] TEST_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(References.MOD_ID, "textures/models/test/background_0.png"),
		new ResourceLocation(References.MOD_ID, "textures/models/test/overlay_0.png"),
		
	};
    
    @Override
    public boolean isMultipass()
    {
        return true;
    }
    
    @Override
    public void doRender(EntityAirshipV1Core entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEST_TEXTURE[0]);
    	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    public void renderMultipass(EntityAirshipV1Core entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
    	FMLClientHandler.instance().getClient().renderEngine.bindTexture(TEST_TEXTURE[1]);
    	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/airship_visualballoon_" + EnumsVC.AirshipTierCore.byId(entity.getMetaTierCore()).getName() +".png"));
    	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
    
        
		
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
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        
	    	GlStateManager.color(1F, 1F, 1F, 1F);
	    }
	    else
	    {
	    	if(entity.getPowered() > 0)
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	        }
	        else
	        {
	        	if(entity.getFrameVisual() == 0)
	        	{
	        		this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.AirshipTierFrame.byId(entity.getMetaTierFrame()).getName() +".png"));
	        	}
	        	else
	        	{
	            	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/v1/airship_visualframe_" + EnumsVC.VisualFrame.byId(entity.getFrameVisual()).getName() +".png"));
	            }
	        	
	        	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
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
	    	
	    	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    	
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
    		
        	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	}
    	GlStateManager.disableBlend();
    	*/
/**        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }*
    
    public void setupRotation(EntityAirshipV1Core entity, float p_188311_2_, float p_188311_3_)
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
     *
    @Override
    protected ResourceLocation getEntityTexture(EntityAirshipV1Core entity)
    {
        return null;
    }
}


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