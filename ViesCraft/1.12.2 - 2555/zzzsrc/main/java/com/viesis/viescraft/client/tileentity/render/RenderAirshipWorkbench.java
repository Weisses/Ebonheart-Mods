package com.viesis.viescraft.client.tileentity.render;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.tileentity.model.ModelAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderAirshipWorkbench extends TileEntitySpecialRenderer<TileEntityAirshipWorkbench> {
	
	ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/models/airship_workbench.png");
	private ModelAirshipWorkbench model;
	
	public RenderAirshipWorkbench() 
	{
		this.model = new ModelAirshipWorkbench();
	}
	
	@Override
	public void render(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5f, (float)y + 1.5f, (float)z + 0.5f);
		GL11.glRotatef(180, 0f, 0f, 1f);
		this.bindTexture(texture);
		GL11.glPushMatrix();
		
		this.model.renderModel(0.0625f);
		
		this.renderItemSlot0(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot1(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot2(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot3(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot4(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot5(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot6(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot7(te, x, y, z, partialTicks, destroyStage);
		this.renderItemSlot8(te, x, y, z, partialTicks, destroyStage);
		
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
	
	private void renderItemSlot0(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack0 = te.inventory.getStackInSlot(0);
        
        if(itemstack0.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack0.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack0.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(-0.44F, 1.1F, 0.25F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(-0.44F, 1.1F, 0.31F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack0, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot1(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack1 = te.inventory.getStackInSlot(1);
        
        if(itemstack1.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack1.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack1.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0, 1.1F, 0.25F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0, 1.1F, 0.31F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack1, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot2(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack2 = te.inventory.getStackInSlot(2);
        
        if(itemstack2.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack2.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack2.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0.44F, 1.1F, 0.25F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0.44F, 1.1F, 0.31F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack2, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot3(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack3 = te.inventory.getStackInSlot(3);
        
        if(itemstack3.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack3.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack3.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(-0.44F, 1.1F, -0.19F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(-0.44F, 1.1F, -0.13F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack3, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot4(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack4 = te.inventory.getStackInSlot(4);
        
        if(itemstack4.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack4.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack4.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0, 1.1F, -0.19F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0, 1.1F, -0.13F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack4, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot5(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack5 = te.inventory.getStackInSlot(5);
        
        if(itemstack5.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack5.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack5.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0.44F, 1.1F, -0.19F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0.44F, 1.1F, -0.13F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack5, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot6(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack6 = te.inventory.getStackInSlot(6);
        
        if(itemstack6.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack6.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack6.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(-0.44F, 1.1F, -0.62F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(-0.44F, 1.1F, -0.56F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack6, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot7(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack7 = te.inventory.getStackInSlot(7);
        
        if(itemstack7.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack7.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack7.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0, 1.1F, -0.62F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0, 1.1F, -0.56F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack7, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
	
	private void renderItemSlot8(TileEntityAirshipWorkbench te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        ItemStack itemstack8 = te.inventory.getStackInSlot(8);
        
        if(itemstack8.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        
        if(itemstack8.getItem() instanceof ItemBlock && Block.getBlockFromItem(itemstack8.getItem()) != Blocks.AIR)
        {
        	GL11.glTranslatef(0.44F, 1.1F, -0.62F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        else
        {
	        GL11.glTranslatef(0.44F, 1.1F, -0.56F);
			GlStateManager.rotate(180, 0F, 1F, 1F);
        }
        
		Minecraft.getMinecraft().getRenderItem().renderItem(itemstack8, TransformType.GROUND);
		GlStateManager.popMatrix();
    }
}
