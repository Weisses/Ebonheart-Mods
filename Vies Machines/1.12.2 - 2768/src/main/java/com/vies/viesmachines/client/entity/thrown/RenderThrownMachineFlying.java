package com.vies.viesmachines.client.entity.thrown;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderThrownMachineFlying extends Render<EntityThrownMachineFlyingAirship> {
	
	private Item itemModel = ItemsVM.ITEM_MACHINE_FLYING_AIRSHIP;
	private float scale;
    
    public RenderThrownMachineFlying(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.scale = 0.5f;
        
        this.shadowSize = 0.15F;
        this.shadowOpaque = 0.75F;
    }
    
    public void doRender(EntityThrownMachineFlyingAirship entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        {
	        this.bindEntityTexture(entity);
	        GlStateManager.translate((float)x, (float)y, (float)z);
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.scale(this.scale, this.scale, this.scale);
	        TextureAtlasSprite textureatlassprite = Minecraft.getMinecraft().getRenderItem().getItemModelMesher().getParticleIcon(itemModel);
	        Tessellator tessellator = Tessellator.getInstance();
	        BufferBuilder bufferbuilder = tessellator.getBuffer();
	        float f = textureatlassprite.getMinU();
	        float f1 = textureatlassprite.getMaxU();
	        float f2 = textureatlassprite.getMinV();
	        float f3 = textureatlassprite.getMaxV();
	        float f4 = 1.0F;
	        float f5 = 0.5F;
	        float f6 = 0.25F;
	        GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
	        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
	        bufferbuilder.pos(-0.5D, -0.25D, 0.0D).tex((double)f, (double)f3).normal(0.0F, 1.0F, 0.0F).endVertex();
	        bufferbuilder.pos(0.5D, -0.25D, 0.0D).tex((double)f1, (double)f3).normal(0.0F, 1.0F, 0.0F).endVertex();
	        bufferbuilder.pos(0.5D, 0.75D, 0.0D).tex((double)f1, (double)f2).normal(0.0F, 1.0F, 0.0F).endVertex();
	        bufferbuilder.pos(-0.5D, 0.75D, 0.0D).tex((double)f, (double)f2).normal(0.0F, 1.0F, 0.0F).endVertex();
	        tessellator.draw();
	        GlStateManager.disableRescaleNormal();
        }
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityThrownMachineFlyingAirship entity)
    {
        return TextureMap.LOCATION_BLOCKS_TEXTURE;
    }
}
