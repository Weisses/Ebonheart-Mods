package com.viesis.viescraft.client.entity.render;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.entity.model.ModelAirshipVC;
import com.viesis.viescraft.common.entity.EntityAirshipBase;

public class RenderEntityAirshipBase extends RenderLiving<EntityAirshipBase>
{
	public static final ResourceLocation ENTITY_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/models/viesdenburg.png");
    //private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.<String, ResourceLocation>newHashMap();

    public RenderEntityAirshipBase(RenderManager rendermanagerIn, ModelAirshipVC model, float shadowSizeIn)
    {
        super(rendermanagerIn, model, shadowSizeIn);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityAirshipBase entitylivingbaseIn, float partialTickTime)
    {
    	
    	//float f = 0.1F;
    	
        float f = 1.0F;
        //HorseType horsetype = entitylivingbaseIn.getType();

        //if (horsetype == HorseType.DONKEY)
        //{
        //    f *= 0.87F;
        //}
        //else if (horsetype == HorseType.MULE)
        //{
        //    f *= 0.92F;
        //}

        
        GlStateManager.scale(f, f, f);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    
    

	@Override
	protected ResourceLocation getEntityTexture(EntityAirshipBase entity) 
	{
		return ENTITY_TEXTURE;
	}
    
/**    protected ResourceLocation getEntityTexture(testVC entity)
    {
        return !entity.hasLayeredTextures() ? entity.getType().getTexture() : this.getOrCreateLayeredResourceLoc(entity);
    }

    @Nullable
    private ResourceLocation getOrCreateLayeredResourceLoc(testVC p_188328_1_)
    {
        String s = p_188328_1_.getHorseTexture();

        if (!p_188328_1_.hasTexture())
        {
            return null;
        }
        else
        {
            ResourceLocation resourcelocation = (ResourceLocation)LAYERED_LOCATION_CACHE.get(s);

            if (resourcelocation == null)
            {
                resourcelocation = new ResourceLocation(s);
                Minecraft.getMinecraft().getTextureManager().loadTexture(resourcelocation, new LayeredTexture(p_188328_1_.getVariantTexturePaths()));
                LAYERED_LOCATION_CACHE.put(s, resourcelocation);
            }

            return resourcelocation;
        }
    }
    
    */
    
}