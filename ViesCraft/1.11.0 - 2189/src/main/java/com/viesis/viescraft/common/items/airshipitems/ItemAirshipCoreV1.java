package com.viesis.viescraft.common.items.airshipitems;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;

public class ItemAirshipCoreV1 extends Item {
	
    protected String Wood0 = "Oak ";
    protected String Iron = "Iron ";
    protected String Redstone = "Redstone ";
    protected String Gold = "Gold ";
    protected String LapisLazuli = "Lapis Lazuli ";
    protected String Diamond = "Diamond ";
    protected String Emerald = "Emerald ";
    
    protected String Black = "Black ";
    protected String Blue = "Blue ";
    protected String Brown = "Brown ";
    protected String Cyan = "Cyan ";
    protected String Gray = "Gray ";
    protected String Green = "Green ";
    protected String LightBlue = "Light Blue ";
    protected String LightGray = "Light Gray ";
    protected String Lime = "Lime ";
    protected String Magenta = "Magenta ";
    protected String Orange = "Orange ";
    protected String Pink = "Pink ";
    protected String Purple = "Purple ";
    protected String Red = "Red ";
    protected String White = "White ";
    protected String Yellow = "Yellow ";
    protected String Admin = "Admin ";
    
	public ItemAirshipCoreV1() 
	{
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "Hold " + TextFormatting.WHITE + "[Shift + Right-Click]" + TextFormatting.DARK_PURPLE + " to throw this");
		toolTip.add(TextFormatting.DARK_PURPLE + "item and unleash the airship within.");
		toolTip.add(TextFormatting.DARK_PURPLE + "No assembly required!");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
}
