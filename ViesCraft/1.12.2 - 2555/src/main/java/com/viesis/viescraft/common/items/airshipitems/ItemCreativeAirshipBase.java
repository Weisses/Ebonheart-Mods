package com.viesis.viescraft.common.items.airshipitems;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.api.EnumsVC;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
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
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		//item and unleash the airship within.
		tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.1") + this.getPrimaryLabelColor(stack.getMetadata()) + " " + I18n.translateToLocal("vc.item.tt.airship.2"));
		tooltip.add(this.getPrimaryLabelColor(stack.getMetadata()) + I18n.translateToLocal("vc.item.tt.airship.3"));
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Frame || Core
		tooltip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierEngine.byId(5).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierCore.byId(5).getLocalizedName() + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||");
		
		//Engine || Balloon
		tooltip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierEngine.byId(5).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + EnumsVC.AirshipTierBalloon.byId(5).getLocalizedName() + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||"
				);
		
		
		tooltip.add(TextFormatting.DARK_GREEN + "||---------------||---------------||");
		
		
		//----- || Airship Speed
		tooltip.add(TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "---------------" 
				+ TextFormatting.DARK_GREEN + "||" 
				+ TextFormatting.BLACK + "iii" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(5) + "+5" + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "--i"
				+ TextFormatting.DARK_GREEN + "||");
		
		//Airship Fuel and Altitude
		tooltip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(5) + "-" + df.format(EnumsVC.AirshipTierEngine.byId(5).getFuelPerTick()) + TextFormatting.GRAY + ")"
				+ TextFormatting.BLACK + "--ii" + TextFormatting.DARK_GREEN + "||"
				+ TextFormatting.BLACK + "l" 
				+ TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.GRAY + "(" + TextFormatting.RED + "200" + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--i" + TextFormatting.DARK_GREEN + "||"
				);
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Visual Frame
		tooltip.add(TextFormatting.BLACK + "----ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.9") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
		tooltip.add(TextFormatting.BLACK + "---ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.10") + TextFormatting.DARK_BLUE + " : " 
				+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
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
