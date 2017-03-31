package com.viesis.viescraft.client.entity.render.airshipcolors.v3;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3Color;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3FrameOff;
import com.viesis.viescraft.client.entity.model.v3.ModelAirshipV3FrameOn;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirshipV3 extends Render<EntityAirshipV3Core> {
	
	/**
	 * Used in Rendering Airship textures.
	 */
	public static final ResourceLocation[] ENTITY_FRAME_TEXTURE = new ResourceLocation[] 
	{
		//Common
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood0.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood1.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood2.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood3.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood4.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood5.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_sandstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_brick.png"),
		
		//Uncommon
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_bone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_iron.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_redstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_gold.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_lapislazuli.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_slime.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_mycelium.png"),
		
		//Rare
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_netherbrick.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_soulsand.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_quartz.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_ice.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_glowstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_obsidian.png"),
		
		//Epic
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_diamond.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_emerald.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_prismarine.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_purpur.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_netherstar.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_mythic.png")
	};
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV3Color = new ModelAirshipV3Color();
	/** Instance of V3-On Model for rendering. */
	protected ModelBase modelAirshipV3FrameOn = new ModelAirshipV3FrameOn();
	/** Instance of V3-Off Model for rendering. */
	protected ModelBase modelAirshipV3FrameOff = new ModelAirshipV3FrameOff();
	/** Instance of the Control panel screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private int moduleNumber;
	
    public RenderAirshipV3(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(EntityAirshipV3Core entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        
        GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
		
        int randomTick = Reference.random.nextInt(100) + 1;
		
        //Draw current module icons in screen
        if(entity.getModuleSpeedMinor())
		{
			this.moduleNumber = 1;
		}
        else if(entity.getModuleSpeedMajor())
		{
			this.moduleNumber = 2;
		}
		else if(entity.getModuleInventorySmall())
		{
        	this.moduleNumber = 3;
		}
        else if(entity.getModuleInventoryLarge())
		{
			this.moduleNumber = 4;
		}
        else if(entity.getModuleFuelInfinite())
		{
			this.moduleNumber = 5;
		}
        else if(entity.getModuleWaterLanding())
		{
			this.moduleNumber = 6;
		}
        else if(entity.getModuleMaxAltitude())
		{
			this.moduleNumber = 7;
		}
        else if(entity.getModuleMinorEfficiency())
		{
			this.moduleNumber = 8;
		}
        else if(entity.getModuleMajorEfficiency())
		{
			this.moduleNumber = 9;
		}
        else
        {
        	this.moduleNumber = 0;
        }
		
        float red = entity.metaColorRed / 255.0f;
        float green = entity.metaColorGreen / 255.0f;
        float blue = entity.metaColorBlue / 255.0f;
        
        if(entity.getPowered() > 0)
        {
        	if(entity.frameVisualActive == true)
        	{
        		this.bindTexture(ENTITY_FRAME_TEXTURE[entity.metaFrameVisual]);
        	}
        	else
        	{
        		this.bindTexture(ENTITY_FRAME_TEXTURE[entity.metaFrameCore]);
        	}
        	
        	this.modelAirshipV3FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        else
        {
        	if(entity.frameVisualActive == true)
        	{
        		this.bindTexture(ENTITY_FRAME_TEXTURE[entity.metaFrameVisual]);
        	}
        	else
        	{
        		this.bindTexture(ENTITY_FRAME_TEXTURE[entity.metaFrameCore]);
        	}
        	
        	this.modelAirshipV3FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        
    	this.bindTexture(Reference.ENTITY_SCREEN_TEXTURE[this.moduleNumber]);
    	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(red, green, blue, 1F);
    	this.bindTexture(Reference.ENTITY_BALLOON_TEXTURE[entity.metaBalloon]);
    	this.modelAirshipV3Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	GlStateManager.color(1F, 1F, 1F, 1F);
    	
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
        
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void setupRotation(EntityAirshipV3Core entity, float p_188311_2_, float p_188311_3_)
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
    protected ResourceLocation getEntityTexture(EntityAirshipV3Core entity)
    {
        return null;
    }
}
