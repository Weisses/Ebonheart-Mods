package com.viesis.viescraft.common.utils.events;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHUDactivator extends Item
{
  public ItemHUDactivator()
  {
    this.setMaxStackSize(1);
    this.setCreativeTab(CreativeTabs.MISC);   // the item will appear on the Miscellaneous tab in creative
  }

  // if the item is being held in the hotbar, switch to survival mode.
  // The HUD rendering is switched on in the EventHandlerOverlay code, not here.
  @Override
  public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
    final int FIRST_HOTBAR_SLOT_NUMBER = 0;
    final int LAST_HOTBAR_SLOT_NUMBER = 8;

    if (itemSlot < FIRST_HOTBAR_SLOT_NUMBER || itemSlot > LAST_HOTBAR_SLOT_NUMBER) return;
    if (worldIn.isRemote) return;
    if (!(entityIn instanceof EntityPlayerMP)) return;
    EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entityIn;
    if (entityPlayerMP.interactionManager.getGameType() != WorldSettings.getGameTypeById(0)) {
      entityPlayerMP.setGameType(WorldSettings.getGameTypeById(0));
    }
  }

  // adds 'tooltip' text
  @SideOnly(Side.CLIENT)
  @SuppressWarnings("unchecked")
  @Override
  public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
    tooltip.add("Place the activator in your hotbar");
    tooltip.add(" to activate the custom HUD.");
  }
}
