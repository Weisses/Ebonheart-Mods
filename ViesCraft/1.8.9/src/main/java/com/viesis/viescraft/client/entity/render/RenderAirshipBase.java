package com.viesis.viescraft.client.entity.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.model.ModelAirshipBase;
import com.viesis.viescraft.common.entity.EntityAirshipBase;

@SideOnly(Side.CLIENT)
public class RenderAirshipBase extends Render<EntityAirshipBase>
{
	
	public static final ResourceLocation ENTITY_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/models/airship_base.png");
	//public static final ResourceLocation ENTITY_TEXTURE1 = new ResourceLocation(Reference.MOD_ID, "textures/models/viesdenburg1.png");
    
	//private static final ResourceLocation[] BOAT_TEXTURES = new ResourceLocation[] {new ResourceLocation("textures/entity/boat/boat_oak.png"), new ResourceLocation("textures/entity/boat/boat_spruce.png"), new ResourceLocation("textures/entity/boat/boat_birch.png"), new ResourceLocation("textures/entity/boat/boat_jungle.png"), new ResourceLocation("textures/entity/boat/boat_acacia.png"), new ResourceLocation("textures/entity/boat/boat_darkoak.png")};
    /** instance of ModelTest for rendering */
	protected ModelBase modelTest = new ModelAirshipBase();
	

    public RenderAirshipBase(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityAirshipBase entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	
    	GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y + 0.25F, (float)z);
        GlStateManager.rotate(180.0F - entityYaw, 0.0F, 1.0F, 0.0F);
        float f = (float)entity.getTimeSinceHit() - partialTicks;
        float f1 = entity.getDamageTaken() - partialTicks;

        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F * (float)entity.getForwardDirection(), 1.0F, 0.0F, 0.0F);
        }

        float f2 = 0.75F;
        GlStateManager.scale(f2, f2, f2);
        GlStateManager.scale(1.0F / f2, 1.0F / f2, 1.0F / f2);
        this.bindEntityTexture(entity);
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        this.modelTest.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    	
    	/**
        GlStateManager.pushMatrix();
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);

        if (this.renderOutlines)
        {
            GlStateManager.enableColorMaterial();
            GlStateManager.enableOutlineMode(this.getTeamColor(entity));
        }

        this.modelTest.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        //this.modelTest1.render(entity, partialTicks, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);

        if (this.renderOutlines)
        {
            GlStateManager.disableOutlineMode();
            GlStateManager.disableColorMaterial();
        }

        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        */
    }

    public void setupRotation(EntityAirshipBase p_188311_1_, float p_188311_2_, float p_188311_3_)
    {
        GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        float f = (float)p_188311_1_.getTimeSinceHit() - p_188311_3_;
        float f1 = p_188311_1_.getDamageTaken() - p_188311_3_;

        
        float g = (float)p_188311_1_.getTimeSinceHit() - p_188311_3_;
        float g1 = p_188311_1_.getDamageTaken() - p_188311_3_;

        
        
        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }

        if (f > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F *  
            		//1
            		(float)p_188311_1_.getForwardDirection()
            		, 0.0F, 0.0F, 1.0F);
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
    protected ResourceLocation getEntityTexture(EntityAirshipBase entity)
    {
        return ENTITY_TEXTURE;
    }

    //public boolean isMultipass()
    //{
    //    return true;
    //}

    //public void renderMultipass(EntityAirshipEA p_188300_1_, double p_188300_2_, double p_188300_4_, double p_188300_6_, float p_188300_8_, float p_188300_9_)
    //{
    //    GlStateManager.pushMatrix();
    ///    this.setupTranslation(p_188300_2_, p_188300_4_, p_188300_6_);
    //    this.setupRotation(p_188300_1_, p_188300_8_, p_188300_9_);
    //    this.bindEntityTexture(p_188300_1_);
    //    ((IMultipassModel)this.modelTest).renderMultipass(p_188300_1_, p_188300_9_, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    //    GlStateManager.popMatrix();
    //}
}