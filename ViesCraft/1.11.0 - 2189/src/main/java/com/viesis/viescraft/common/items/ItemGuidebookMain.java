package com.viesis.viescraft.common.items;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.client.gui.GuiGuidebookControls;
import com.viesis.viescraft.client.gui.GuiGuidebookMain;
import com.viesis.viescraft.common.entity.airshipitems.v1.old.EntityItemAirshipV1Admin;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGuidebookMain extends Item {
	
	public ItemGuidebookMain() 
	{
		ItemHelper.setItemName(this, "guidebook_main");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemStackIn = playerIn.getHeldItem(handIn);
        
		if(worldIn.isRemote)
		{
			Minecraft.getMinecraft().displayGuiScreen(new GuiGuidebookMain());
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
