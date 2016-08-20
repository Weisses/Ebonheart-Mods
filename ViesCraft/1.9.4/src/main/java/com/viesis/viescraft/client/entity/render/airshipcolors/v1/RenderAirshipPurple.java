package com.viesis.viescraft.client.entity.render.airshipcolors.v1;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.model.ModelAirship;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPurple;
import com.viesis.viescraft.configs.ViesCraftConfig;

@SideOnly(Side.CLIENT)
public class RenderAirshipPurple extends Render<EntityAirshipPurple> {
	
	private static final ResourceLocation[] ENTITY_TEXTURE = new ResourceLocation[] 
	{
		new ResourceLocation(Reference.MOD_ID, "textures/models/airship_base_purple.png")//,
	};
	
	/** instance of ModelTest for rendering */
	protected ModelBase modelTest = new ModelAirship();
	
	
    public RenderAirshipPurple(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(EntityAirshipPurple entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
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
    }

    public void setupRotation(EntityAirshipPurple entity, float p_188311_2_, float p_188311_3_)
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
            GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F *  
            		//1
            		(float)entity.getForwardDirection()
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
    protected ResourceLocation getEntityTexture(EntityAirshipPurple entity)
    {
        return ENTITY_TEXTURE[entity.getBoatType().ordinal()];
    }

}
