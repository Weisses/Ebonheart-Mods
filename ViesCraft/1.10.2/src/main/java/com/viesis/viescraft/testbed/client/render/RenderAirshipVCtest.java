package com.viesis.viescraft.testbed.client.render;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.passive.HorseType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Maps;
import com.viesis.viescraft.testbed.client.model.ModelAirshipVC;
import com.viesis.viescraft.testbed.common.entity.EntityAirshipVCtest;


@SideOnly(Side.CLIENT)
public class RenderAirshipVCtest extends RenderLiving<EntityAirshipVCtest>
{
    private static final Map<String, ResourceLocation> LAYERED_LOCATION_CACHE = Maps.<String, ResourceLocation>newHashMap();

    public RenderAirshipVCtest(RenderManager rendermanagerIn, ModelAirshipVC model, float shadowSizeIn)
    {
        super(rendermanagerIn, model, shadowSizeIn);
    }

    /**
     * Allows the render to do state modifications necessary before the model is rendered.
     */
    protected void preRenderCallback(EntityAirshipVCtest entitylivingbaseIn, float partialTickTime)
    {
        float f = 1.0F;
        HorseType horsetype = entitylivingbaseIn.getType();

        if (horsetype == HorseType.DONKEY)
        {
            f *= 0.87F;
        }
        else if (horsetype == HorseType.MULE)
        {
            f *= 0.92F;
        }

        GlStateManager.scale(f, f, f);
        super.preRenderCallback(entitylivingbaseIn, partialTickTime);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(EntityAirshipVCtest entity)
    {
        return !entity.hasLayeredTextures() ? entity.getType().getTexture() : this.getOrCreateLayeredResourceLoc(entity);
    }

    @Nullable
    private ResourceLocation getOrCreateLayeredResourceLoc(EntityAirshipVCtest p_188328_1_)
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
}