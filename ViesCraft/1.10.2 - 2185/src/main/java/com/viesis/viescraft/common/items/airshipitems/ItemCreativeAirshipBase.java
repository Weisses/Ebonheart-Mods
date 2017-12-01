package com.viesis.viescraft.common.items.airshipitems;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.api.EnumsVC;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeAirshipBase extends Item {
	
	protected int metaModuleVariantSlot1;
	
	protected int metaTierFrame;
	protected int metaTierBalloon;
	
	protected int metaFrameVisual;
	protected boolean metaFrameVisualTransparent;
	protected boolean metaFrameVisualColor;
	protected int metaFrameColorRed;
	protected int metaFrameColorGreen;
	protected int metaFrameColorBlue;
	
	protected int metaBalloonVisual;
	protected boolean metaBalloonVisualTransparent;
	protected boolean metaBalloonVisualColor;
	protected int metaBalloonColorRed;
	protected int metaBalloonColorGreen;
	protected int metaBalloonColorBlue;
	
	public ItemCreativeAirshipBase()
	{
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DecimalFormat df = new DecimalFormat("###.#");
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		//item and unleash the airship within.
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.1") + this.getPrimaryLabelColor(stack.getMetadata()) + " " + I18n.translateToLocal("vc.item.tt.airship.2"));
		toolTip.add(this.getPrimaryLabelColor(stack.getMetadata()) + I18n.translateToLocal("vc.item.tt.airship.3"));
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Frame || Core
		toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierEngine.byId(5).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierCore.byId(5).getLocalizedName() + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||");
		
		//Engine || Balloon
		toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierEngine.byId(5).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierBalloon.byId(5).getLocalizedName() + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||"
				);
		
		
		toolTip.add(TextFormatting.DARK_GREEN + "||---------------||---------------||");
		
		
		//----- || Airship Speed
		toolTip.add(TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "---------------" 
				+ TextFormatting.DARK_GREEN + "||" 
				+ TextFormatting.BLACK + "iii" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(5) + "+5" + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "--i"
				+ TextFormatting.DARK_GREEN + "||");
		
		//Airship Fuel and Altitude
		toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + "-" + df.format(EnumsVC.AirshipTierEngine.byId(5).getFuelPerTick()) + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "--ii" + TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "l" 
				+ TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + TextFormatting.RED + " \u221e " + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--l" + TextFormatting.DARK_GREEN + "||"
				);
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Visual Frame
		toolTip.add(TextFormatting.BLACK + "----ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.9") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
		toolTip.add(TextFormatting.BLACK + "---ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.10") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.EPIC;
    }
	
	private TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel = TextFormatting.RED;
		
		return stringColorLabel;
	}
}
