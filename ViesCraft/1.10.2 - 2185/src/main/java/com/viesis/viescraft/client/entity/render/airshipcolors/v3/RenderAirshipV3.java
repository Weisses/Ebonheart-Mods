package com.viesis.viescraft.client.entity.render.airshipcolors.v3;

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
	
	private static final ResourceLocation[] ENTITY_COLOR_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_normal.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_black.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_blue.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_brown.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_cyan.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_gray.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_green.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_lightblue.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_lightgray.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_lime.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_magenta.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_orange.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_pink.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_purple.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_red.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_white.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_yellow.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_rainbow.png")
	};
	
	private static final ResourceLocation[] ENTITY_FRAME_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_wood0.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_iron.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_redstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_gold.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_lapislazuli.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_obsidian.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_diamond.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_emerald.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_netherbrick.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v3/airship_v3_frame_purpur.png")
	};
	
	private static final ResourceLocation[] ENTITY_SCREEN_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/no_module.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_small.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_inv_large.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_minor.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_speed_major.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/screens/module_fuel_infinite.png")
	};
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV3Color = new ModelAirshipV3Color();
	/** Instance of V3-On Model for rendering. */
	protected ModelBase modelAirshipV3FrameOn = new ModelAirshipV3FrameOn();
	/** Instance of V3-Off Model for rendering. */
	protected ModelBase modelAirshipV3FrameOff = new ModelAirshipV3FrameOff();
	/** Instance of the Control panel screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private EntityAirshipV3Core airship;
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
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.airship = entity;
        
        //Draw current module icons in screen
		if(this.airship.getModuleInventorySmall())
		{
        	this.moduleNumber = 1;
		}
        else if(this.airship.getModuleInventoryLarge())
		{
			this.moduleNumber = 2;
		}
        else if(this.airship.getModuleSpeedMinor())
		{
			this.moduleNumber = 3;
		}
        else if(this.airship.getModuleSpeedMajor())
		{
			this.moduleNumber = 4;
		}
        else if(this.airship.getModuleFuelInfinite())
		{
			this.moduleNumber = 5;
		}
        else
        {
        	this.moduleNumber = 0;
        }
		
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
        
        if(entity.getPowered() > 0)
        {
        	this.bindTexture(ENTITY_COLOR_TEXTURE[entity.getAirshipMetaColor()]);
        	this.modelAirshipV3Color.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_FRAME_TEXTURE[entity.getAirshipMetaFrame()]);
        	this.modelAirshipV3FrameOn.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_SCREEN_TEXTURE[this.moduleNumber]);
        	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        }
        else
        {
        	this.bindTexture(ENTITY_COLOR_TEXTURE[entity.getAirshipMetaColor()]);
        	this.modelAirshipV3Color.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_FRAME_TEXTURE[entity.getAirshipMetaFrame()]);
        	this.modelAirshipV3FrameOff.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_SCREEN_TEXTURE[this.moduleNumber]);
        	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
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
    	GlStateManager.translate(0F, 0.25F, 0F);
        
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
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F, (float)p_188309_5_);
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
