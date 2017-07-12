package com.viesis.gemstones.client.tileentity;

import org.lwjgl.opengl.GL11;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.VGEnum.GemstoneTypeItemV1;
import com.viesis.gemstones.client.InitParticlesVGRender;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class RenderGemstoneWorkbench extends TileEntitySpecialRenderer<TileEntityGemstoneWorkbench> {
	
	//private ModelGemstoneWorkbench model;
	
	public RenderGemstoneWorkbench() 
	{
		//this.model = new ModelGemstoneWorkbench();
	}
	
	@Override
	public void renderTileEntityAt(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage) 
	{
		if(!te.inventory.getStackInSlot(0).isEmpty()
		&& te.isOn
		&& !Minecraft.getMinecraft().isGamePaused()
		&& te.cutTime >= 1)
		{
			int d = References.random.nextInt(100) + 1;
			
			if (d <= 50)
			{
				InitParticlesVGRender.generateRunicWorkbenchParticles(te);
			}
		}
		
		if (te.getName() != null 
		&& this.rendererDispatcher.cameraHitResult != null 
		&& te.getPos().equals(this.rendererDispatcher.cameraHitResult.getBlockPos()))
        {
			if(te.isOn)
			{
				this.setLightmapDisabled(true);
				
				
				if(te.inventory.getStackInSlot(1).getCount() > 63)
            	{
            		this.drawNameplate(te, TextFormatting.LIGHT_PURPLE + "Full", x, y + 0.5D, z, 16);
            	}
				else
				{
	            	if(te.cutTime >= 180)
	            	{
	            		this.drawNameplate(te, TextFormatting.AQUA + " |||||||||||||||||||| ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 160)
	            	{
	            		this.drawNameplate(te, TextFormatting.AQUA + " ||||||||||||||||||  ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 140)
	            	{
	            		this.drawNameplate(te, TextFormatting.GREEN + " ||||||||||||||||   ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 120)
	            	{
	            		this.drawNameplate(te, TextFormatting.GREEN + " ||||||||||||||    ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 100)
	            	{
	            		this.drawNameplate(te, TextFormatting.YELLOW + " ||||||||||||     ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 80)
	            	{
	            		this.drawNameplate(te, TextFormatting.YELLOW + " ||||||||||      ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 60)
	            	{
	            		this.drawNameplate(te, TextFormatting.GOLD + " ||||||||       ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 40)
	            	{
	            		this.drawNameplate(te, TextFormatting.GOLD + " ||||||        ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 20)
	            	{
	            		this.drawNameplate(te, TextFormatting.DARK_RED + " ||||         ", x, y + 0.5D, z, 16);
	            	}
	            	else if(te.cutTime >= 1)
	            	{
	            		this.drawNameplate(te, TextFormatting.DARK_RED + " ||          ", x, y + 0.5D, z, 16);
	            	}
		            
		            this.drawNameplate(te, TextFormatting.WHITE + "[          ]", x, y + 0.5D, z, 16);
				}
				
		        this.drawNameplate(te, TextFormatting.WHITE + "Gem: " + TextFormatting.YELLOW + GemstoneTypeItemV1.byMetadata(te.gemstoneMeta).getLocalizedName(), x, y + 0.25D, z, 16);
	            this.drawNameplate(te, TextFormatting.WHITE + "Power: " + TextFormatting.GREEN + "On", x, y, z, 16);
	            this.setLightmapDisabled(false);
			}
			else
			{
				if(te.inventory.getStackInSlot(1).getCount() > 63)
            	{
            		this.drawNameplate(te, TextFormatting.LIGHT_PURPLE + "Full", x, y + 0.5D, z, 16);
            	}
				
				this.setLightmapDisabled(true);
	            this.drawNameplate(te, TextFormatting.WHITE + "Gem: " + TextFormatting.YELLOW + GemstoneTypeItemV1.byMetadata(te.gemstoneMeta).getLocalizedName(), x, y + 0.25D, z, 16);
	            this.drawNameplate(te, TextFormatting.WHITE + "Power: " + TextFormatting.RED + "Off", x, y, z, 16);
	            this.setLightmapDisabled(false);
			}
        }
		
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.05f, (float)z + 0.5f);
		GL11.glRotatef(0, 0f, 0f, 1f);
		//this.bindTexture(texture);
		GL11.glPushMatrix();
		
		/////this.model.renderModel(0.0625f);
		
		this.renderItemGem(te, x, y, z, partialTicks, destroyStage);
		this.renderItemFuel(te, x, y, z, partialTicks, destroyStage);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	public boolean isGlobalRenderer(TileEntityGemstoneWorkbench te) 
	{
        return true;
    }
	
	private void renderItemGem(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack = new ItemStack(InitItemsVG.gemstone_item_basic_v1, 1, te.gemstoneMeta);//itemFrame.getDisplayedItem();
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
		float angle = (((float)te.getWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		GlStateManager.rotate(angle + angle, 0F, 1F, 0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemFuel(TileEntityGemstoneWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack = te.inventory.getStackInSlot(0);
        
        if(itemstack.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        
        if(itemstack.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack.getItem()) != Blocks.AIR)
        {
            Block block = Block.getBlockFromItem(itemstack.getItem());
            GL11.glTranslatef(0, - 0.73f, 0);
        }
        else
        {
        	GL11.glTranslatef(0, - 0.6f, 0);
            GlStateManager.scale(0.5F, 0.5F, 0.5F);
        }
        
		float angle = (((float)te.getWorld().getTotalWorldTime() + partialTicks) / 20.0F) * (180F / (float)Math.PI);
		GlStateManager.rotate(angle, 0F, 1F, 0F);
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
}
