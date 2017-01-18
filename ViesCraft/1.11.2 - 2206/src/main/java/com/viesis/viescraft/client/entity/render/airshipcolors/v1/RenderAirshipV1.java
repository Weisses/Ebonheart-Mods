package com.viesis.viescraft.client.entity.render.airshipcolors.v1;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Color;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOff;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOn;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirshipV1 extends Render<EntityAirshipV1Core> {
	
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
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_wood0.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_iron.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_redstone.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_gold.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_lapislazuli.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_obsidian.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_diamond.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_emerald.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_netherbrick.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_purpur.png")
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
	
	private static final int[][] multi = new int[][]{
		  { 0, 100, 0},
		  { 0, 100, 0},
		  { 0, 0, 100},
		  { 0, 0, 0},
		  { 0, 0, 0}
		};
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV1Color = new ModelAirshipV1Color();
	/** Instance of V1-On Model for rendering. */
	protected ModelBase modelAirshipV1FrameOn = new ModelAirshipV1FrameOn();
	/** Instance of V1-Off Model for rendering. */
	protected ModelBase modelAirshipV1FrameOff = new ModelAirshipV1FrameOff();
	/** Instance of the Control panel screen Model for rendering. */
	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
	
	private int moduleNumber;
	
    public RenderAirshipV1(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(EntityAirshipV1Core entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        
        GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
		
        int randomTick = Reference.random.nextInt(100) + 1;
		
        //Draw current module icons in screen
		if(entity.getModuleInventorySmall())
		{
        	this.moduleNumber = 1;
		}
        else if(entity.getModuleInventoryLarge())
		{
			this.moduleNumber = 2;
		}
        else if(entity.getModuleSpeedMinor())
		{
			this.moduleNumber = 3;
			
			if(randomTick < 30)
			{
				//InitParticlesVCRender.generateRunicParticles(entity);
				InitParticlesVCRender.generateColorFlameParticles(entity);
			}
		}
        else if(entity.getModuleSpeedMajor())
		{
			this.moduleNumber = 4;
			
			if(randomTick < 25)
			{
				InitParticlesVCRender.generateFlameParticles(entity);
			}
		}
        else if(entity.getModuleFuelInfinite())
		{
			this.moduleNumber = 5;
		}
        else
        {
        	this.moduleNumber = 0;
        }
		
        if(entity.getPowered() > 0)
        {
        	
        	this.bindTexture(ENTITY_COLOR_TEXTURE[entity.getAirshipMetaColor()]);
        	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
        	this.bindTexture(ENTITY_FRAME_TEXTURE[entity.getAirshipMetaFrame()]);
        	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_SCREEN_TEXTURE[this.moduleNumber]);
        	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        else
        {
        	
        	
        	this.bindTexture(ENTITY_COLOR_TEXTURE[entity.getAirshipMetaColor()]);
        	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
        	//GlStateManager.color(multi[0][0], multi[0][1], multi[0][2], 1F);
        	
        	this.bindTexture(ENTITY_FRAME_TEXTURE[entity.getAirshipMetaFrame()]);
        	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        	
        	//GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        	
        	
        	this.bindTexture(ENTITY_SCREEN_TEXTURE[this.moduleNumber]);
        	this.modelAirshipPanel.render(entity, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        }
        
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
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityAirshipV1Core entity)
    {
        return null;
    }
}
