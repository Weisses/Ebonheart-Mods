package com.viesis.viescraft.common.items;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.client.gui.guidebooks.GuiGuidebookPaint;

public class OLDItemGuidebookPaint extends Item {
	
	public OLDItemGuidebookPaint() 
	{
		ItemHelper.setItemName(this, "guidebook_paint");
		this.setMaxStackSize(1);
		//this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	/**
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        //ItemStack itemStackIn = playerIn.getHeldItemMainhand();
        
		if(worldIn.isRemote)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiGuidebookPaint());
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
	*/
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.GRAY + "by Viesis");
		tooltip.add(TextFormatting.RED + "NOT USED. WILL BE REMOVED NEXT UPDATE!");
	}
}