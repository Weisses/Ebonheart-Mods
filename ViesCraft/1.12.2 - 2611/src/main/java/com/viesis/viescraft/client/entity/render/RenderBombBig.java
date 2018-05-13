package com.viesis.viescraft.client.entity.render;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.entity.model.bomb.ModelBombBig;
import com.viesis.viescraft.common.entity.EntityBombBig;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderBombBig extends Render<EntityBombBig> {
	
	/** Instance of V1 Balloon Model for rendering. */
	protected ModelBase modelBombBig = new ModelBombBig();
	
    public RenderBombBig(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
        this.shadowSize = 1.0F;
    }
    
    @Override
    public void doRender(EntityBombBig entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        float bombspin = (((float)entity.getEntityWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
        GlStateManager.rotate((bombspin), 0F, 1F, 0F);		
    	
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/bombs/bomb_big.png"));
        modelBombBig.render(entity, partialTicks, 0F, 0F, 0F, 0F, 0.0625F);
        
        int randomTick = References.random.nextInt(100) + 1;
		
		if(randomTick < 20)
		{
			if(!Minecraft.getMinecraft().isGamePaused())
			{
				InitParticlesVCRender.generateBombFuseSmokeParticles(entity);
				InitParticlesVCRender.generateBombFuseFlameParticles(entity);
			}
		}
		
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    public void setupRotation(EntityBombBig entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
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
    protected ResourceLocation getEntityTexture(EntityBombBig entity)
    {
        return null;
    }
    
    /**
     * Places an item on an airship model.
     */
    private void renderItemOnAirship(EntityAirshipCore airshipIn, double posXIn, double posYIn, double posZIn, 
    		ItemStack itemstackIn, double scaleXIn, double scaleYIn, double scaleZIn, 
    		float spinIn, int spinModIn, float yTransformIn)
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
        
        GlStateManager.rotate(yTransformIn, 0.0F, 1.0F, 0.0F);
        
        //Spins item
        GlStateManager.rotate(spinIn * spinModIn, 0F, 1F, 0F);
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		
		GlStateManager.popMatrix();
    }
}
