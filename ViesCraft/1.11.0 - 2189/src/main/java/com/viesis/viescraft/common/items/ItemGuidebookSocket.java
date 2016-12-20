package com.viesis.viescraft.common.items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.client.gui.GuiGuidebookMain;
import com.viesis.viescraft.client.gui.GuiGuidebookSocket;

public class ItemGuidebookSocket extends Item {
	
	public ItemGuidebookSocket() 
	{
		ItemHelper.setItemName(this, "guidebook_socket");
		this.setMaxStackSize(64);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        
		if(worldIn.isRemote)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiGuidebookSocket());
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
