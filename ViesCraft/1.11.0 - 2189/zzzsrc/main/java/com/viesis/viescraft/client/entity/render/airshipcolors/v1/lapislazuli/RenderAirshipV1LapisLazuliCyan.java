package com.viesis.viescraft.client.entity.render.airshipcolors.v1.lapislazuli;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1Color;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOff;
import com.viesis.viescraft.client.entity.model.v1.ModelAirshipV1FrameOn;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.v1.lapislazuli.EntityAirshipV1LapisLazuliCyan;
import com.viesis.viescraft.configs.ViesCraftConfig;

@SideOnly(Side.CLIENT)
public class RenderAirshipV1LapisLazuliCyan extends Render<EntityAirshipV1LapisLazuliCyan> {
	
	private static final ResourceLocation[] ENTITY_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/color/airship_color_cyan.png"),
		new ResourceLocation(Reference.MOD_ID, "textures/models/v1/airship_v1_frame_lapislazuli.png")
	};
	
	/** Instance of Color Model for rendering. */
	protected ModelBase modelAirshipV1Color = new ModelAirshipV1Color();
	/** Instance of V1-On Model for rendering. */
	protected ModelBase modelAirshipV1FrameOn = new ModelAirshipV1FrameOn();
	/** Instance of V1-Off Model for rendering. */
	protected ModelBase modelAirshipV1FrameOff = new ModelAirshipV1FrameOff();
	
	private EntityAirshipV1Core airship;
	
    public RenderAirshipV1LapisLazuliCyan(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    /**
     * Renders the desired {@code T} type Entity.
     */
    @Override
    public void doRender(EntityAirshipV1LapisLazuliCyan entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.airship = entity;
        
        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }
        
        if(entity.getPowered() > 0)
        {
        	this.bindTexture(ENTITY_TEXTURE[0]);
        	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_TEXTURE[1]);
        	this.modelAirshipV1FrameOn.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        }
        else
        {
        	this.bindTexture(ENTITY_TEXTURE[0]);
        	this.modelAirshipV1Color.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        	this.bindTexture(ENTITY_TEXTURE[1]);
        	this.modelAirshipV1FrameOff.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        }
        
        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }
        
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void setupRotation(EntityAirshipV1LapisLazuliCyan entity, float p_188311_2_, float p_188311_3_)
    {
        GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        float f = (float)entity.getTimeSinceHit() - p_188311_3_;
        float f1 = entity.getDamageTaken() - p_188311_3_;
        
        float g = (float)entity.getTimeSinceHit() - p_188311_3_;
        float g1 = entity.getDamageTaken() - p_188311_3_;
        
        if(ViesCraftConfig.modelTurnAngle)
		{
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
    protected ResourceLocation getEntityTexture(EntityAirshipV1LapisLazuliCyan entity)
    {
        return ENTITY_TEXTURE[entity.getBoatType().ordinal()];
    }
}
