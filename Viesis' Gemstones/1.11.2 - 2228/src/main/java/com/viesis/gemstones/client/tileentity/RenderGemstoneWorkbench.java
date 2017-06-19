package com.viesis.gemstones.client.tileentity;

import org.lwjgl.opengl.GL11;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.client.model.ModelGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.storage.MapData;

public class RenderGemstoneWorkbench extends TileEntitySpecialRenderer<TileEntityGemstoneWorkbench> {
	
	ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private ModelGemstoneWorkbench model;
	
	public RenderGemstoneWorkbench() 
	{
		this.model = new ModelGemstoneWorkbench();
	}
	
	@Override
	public void renderTileEntityAt(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage) 
	{
		if (te.getName() != null 
		&& this.rendererDispatcher.cameraHitResult != null 
		&& te.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos()))
        {
            this.setLightmapDisabled(true);
            this.drawNameplate(te, TextFormatting.RED + "Test", x, y + 0.5D, z, 16);
            this.drawNameplate(te, TextFormatting.GREEN + "1", x, y + 0.25D, z, 16);
            this.drawNameplate(te, TextFormatting.GOLD + "2", x, y, z, 16);
            this.setLightmapDisabled(false);
        }
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		
		this.model.renderModel(0.0625f);
		
		this.renderItem(te, z, z, z, partialTicks, destroyStage);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	public boolean isGlobalRenderer(TileEntityGemstoneWorkbench te) 
	{
        return true;
    }
	
	private void renderItem(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        //if(te.gemstoneMeta == 0)
        //{
        	ItemStack itemstack = new ItemStack(InitItemsVG.gemstone_item_basic_v1, 1, te.gemstoneMeta);//itemFrame.getDisplayedItem();
        //}
        
    	//BlockPos blockpos = te.getPos();
    	//double d0 = (double)blockpos.getX();// - te.posX + x;
        //double d1 = (double)blockpos.getY();// - te.posY + y;
        //double d2 = (double)blockpos.getZ();// - te.posZ + z;
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        //GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		
		//GlStateManager.translate(x + 0.5D, y + 0.5D, z + 0.5D);
		GlStateManager.scale(2.5F, 2.5F, 2.5F);
		
		float angle = (((float)te.getWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		GlStateManager.rotate(angle, 0F, 1F, 0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		GlStateManager.popMatrix();
		
        /**
        if (!itemstack.isEmpty())
        {
            EntityItem entityitem = new EntityItem(itemFrame.getWorld(), 0.0D, 0.0D, 0.0D, itemstack);
            Item item = entityitem.getEntityItem().getItem();
            entityitem.getEntityItem().setCount(1);
            entityitem.hoverStart = 0.0F;
            GlStateManager.pushMatrix();
            GlStateManager.disableLighting();
            int i = 1;//itemFrame.getRotation();

            if (item instanceof net.minecraft.item.ItemMap)
            {
                i = i % 4 * 2;
            }

            GlStateManager.rotate((float)i * 360.0F / 8.0F, 0.0F, 0.0F, 1.0F);
/**
            net.minecraftforge.client.event.RenderItemInFrameEvent event = new net.minecraftforge.client.event.RenderItemInFrameEvent(itemFrame, this);
            if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
            {
            if (item instanceof net.minecraft.item.ItemMap)
            {
                //this.renderManager.renderEngine.bindTexture(MAP_BACKGROUND_TEXTURES);
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                float f = 0.0078125F;
                GlStateManager.scale(0.0078125F, 0.0078125F, 0.0078125F);
                GlStateManager.translate(-64.0F, -64.0F, 0.0F);
                MapData mapdata = Items.FILLED_MAP.getMapData(entityitem.getEntityItem(), itemFrame.getWorld());
                GlStateManager.translate(0.0F, 0.0F, -1.0F);

                if (mapdata != null)
                {
                    Minecraft.getMinecraft().entityRenderer.getMapItemRenderer().renderMap(mapdata, true);
                }
            }
            else
            {
                GlStateManager.scale(0.5F, 0.5F, 0.5F);
                GlStateManager.pushAttrib();
                RenderHelper.enableStandardItemLighting();
                //this.itemRenderer.renderItem(entityitem.getEntityItem(), ItemCameraTransforms.TransformType.FIXED);
                RenderHelper.disableStandardItemLighting();
                GlStateManager.popAttrib();
            }
            }

            GlStateManager.enableLighting();
            GlStateManager.popMatrix();
        }
	*/
    }
}
