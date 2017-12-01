package com.viesis.viescraft.common.items.airshipitems;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipBase extends Item {
    
    References rf;
    
	protected int metaModuleVariantSlot1;
	
	protected int metaTierCore;
	protected int metaTierEngine;
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
	
	//Modules
	/** Selected Altitude */
	public int selectedModuleAltitude;
	/** Learned Altitude */
	public boolean learnedModuleAltitude;
	/** Selected Speed */
	public int selectedModuleSpeed;
	/** Learned Speed */
	public boolean learnedModuleSpeed;
	/** Selected Storage */
	public int selectedModuleStorage;
	/** Learned Storage */
	public boolean learnedModuleStorage;
	/** Selected Fuel */
	public int selectedModuleFuel;
	/** Learned Fuel */
	public boolean learnedModuleFuel;
	/** Selected Music */
	public int selectedModuleMusic;
	/** Learned Music */
	public boolean learnedModuleMusic;
	/** Selected Cruise */
	public int selectedModuleCruise;
	/** Learned Cruise */
	public boolean learnedModuleCruise;
	/** Selected Water */
	public int selectedModuleWater;
	/** Learned Water */
	public boolean learnedModuleWater;
	/** Selected Fuel Infinite */
	public int selectedModuleFuelInfinite;
	/** Learned Fuel Infinite */
	public boolean learnedModuleFuelInfinite;
	
	public ItemAirshipBase()
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
		
		//Are there tags?
		if(stack.hasTagCompound())
        {
			if(stack.getMetadata() == 0
			&& stack.getTagCompound().getInteger("TierCore") == 0)
			{
				//Frame || Core
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i"
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||");
			}
			else if(stack.getMetadata() == 0
				 && stack.getTagCompound().getInteger("TierCore") != 0)
			{
				//Frame || Core
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i"
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierCore")) + EnumsVC.AirshipTierCore.byId(stack.getTagCompound().getInteger("TierCore")).getLocalizedName() + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||");
			}
			else if(stack.getMetadata() != 0
				 && stack.getTagCompound().getInteger("TierCore") == 0)
			{
				//Frame || Core
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getMetadata()) + EnumsVC.AirshipTierEngine.byId(stack.getMetadata()).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
						);
			}
			else if(stack.getMetadata() != 0
				 && stack.getTagCompound().getInteger("TierCore") != 0)
			{
				//Frame || Core
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getMetadata()) + EnumsVC.AirshipTierEngine.byId(stack.getMetadata()).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierCore")) + EnumsVC.AirshipTierCore.byId(stack.getTagCompound().getInteger("TierCore")).getLocalizedName() + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||");
			}
			
			
			//===================================================
			
			
			if(stack.getTagCompound().getInteger("TierEngine") == 0
			     && stack.getTagCompound().getInteger("TierBalloon") == 0)
			{
				//Engine || Balloon
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
						);
			}
			else if(stack.getTagCompound().getInteger("TierEngine") == 0
			&& stack.getTagCompound().getInteger("TierBalloon") != 0)
			{
				//Engine || Balloon
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierBalloon")) + EnumsVC.AirshipTierBalloon.byId(stack.getTagCompound().getInteger("TierBalloon")).getLocalizedName() + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||"
						);
			}
			else if(stack.getTagCompound().getInteger("TierEngine") != 0
			     && stack.getTagCompound().getInteger("TierBalloon") == 0)
			{
				//Engine || Balloon
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierEngine")) + EnumsVC.AirshipTierEngine.byId(stack.getTagCompound().getInteger("TierEngine")).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
						);
			}
			else if(stack.getTagCompound().getInteger("TierEngine") != 0
			     && stack.getTagCompound().getInteger("TierBalloon") != 0)
			{
				//Engine || Balloon
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierEngine")) + EnumsVC.AirshipTierEngine.byId(stack.getTagCompound().getInteger("TierEngine")).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
						+ TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierBalloon")) + EnumsVC.AirshipTierBalloon.byId(stack.getTagCompound().getInteger("TierBalloon")).getLocalizedName() + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "i" + TextFormatting.DARK_GREEN + "||"
						);
			}
        }
		else
		{
			//Frame || Core
			toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
					+ TextFormatting.DARK_GREEN + "||"
					+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
					);
			
			//Engine || Balloon
			toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
					+ TextFormatting.DARK_GREEN + "||"
					+ TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---" + TextFormatting.DARK_GREEN + "||"
					);
		}
		
		toolTip.add(TextFormatting.DARK_GREEN + "||---------------||---------------||");
		
		//Are there tags?
		if(stack.hasTagCompound())
        {
			float speedModCal = EnumsVC.AirshipTierCore.byId(stack.getTagCompound().getInteger("TierCore")).getSpeedModifier() * 100;
			String speedMod = df.format(speedModCal);
			
			String altMax = "";
			
			if(stack.getTagCompound().getInteger("TierBalloon") == 0)
			{
				altMax = TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierBalloon")) + df.format(EnumsVC.AirshipTierBalloon.byId(stack.getTagCompound().getInteger("TierBalloon")).getMaxAltitude());
			}
			else if(stack.getTagCompound().getInteger("TierBalloon") >= 5)
			{
				altMax = TextFormatting.BLACK + "il" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierBalloon")) + "\u221e" + TextFormatting.BLACK + "ii";
			}
			else
			{
				altMax = this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierBalloon")) + df.format(EnumsVC.AirshipTierBalloon.byId(stack.getTagCompound().getInteger("TierBalloon")).getMaxAltitude());
			}
			
			//----- || Airship Speed
			toolTip.add(TextFormatting.DARK_GREEN + "||"
					+ TextFormatting.BLACK + "---------------" 
					+ TextFormatting.DARK_GREEN + "||" 
					+ TextFormatting.BLACK + "iii" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierCore")) + "+" + speedMod + TextFormatting.GRAY + ")"
					+ TextFormatting.BLACK + "--i"
					+ TextFormatting.DARK_GREEN + "||");
			
			if(stack.getTagCompound().getInteger("TierBalloon") == 5)
			{
				//Airship Fuel and Altitude
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierEngine")) + "-" + df.format(EnumsVC.AirshipTierEngine.byId(stack.getTagCompound().getInteger("TierEngine")).getFuelPerTick()) + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "--ii" + TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "l" 
						+ TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + TextFormatting.RED + " \u221e " + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--l" + TextFormatting.DARK_GREEN + "||"
						);
			}
			else
			{
				//Airship Fuel and Altitude
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getTagCompound().getInteger("TierEngine")) + "-" + df.format(EnumsVC.AirshipTierEngine.byId(stack.getTagCompound().getInteger("TierEngine")).getFuelPerTick()) + TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "--ii" + TextFormatting.DARK_GREEN + "||"
						+ TextFormatting.BLACK + "l" 
						+ TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + altMax + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--i" + TextFormatting.DARK_GREEN + "||"
						);
			}
        }
		else
		{
			//Airship Speed
			toolTip.add(TextFormatting.DARK_GREEN + "||"
					+ TextFormatting.BLACK + "---------------" 
					+ TextFormatting.DARK_GREEN + "||" 
					+ TextFormatting.BLACK + "iii" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + TextFormatting.GRAY + "+0" + TextFormatting.GRAY + ")"
					+ TextFormatting.BLACK + "--i"
					+ TextFormatting.DARK_GREEN + "||"
					);
			
			//Airship Fuel and Altitude
			toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "ii" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.GRAY + "(" + TextFormatting.GRAY + "-60" + TextFormatting.GRAY + ")"
					+ TextFormatting.BLACK + "--ii" + TextFormatting.DARK_GREEN + "||"
					+ TextFormatting.BLACK + "l"
					+ TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + TextFormatting.GRAY + "75" + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--i" + TextFormatting.DARK_GREEN + "||"
					);
		}
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.hasTagCompound())
        {
			//Visual Frame
			if(stack.getTagCompound().getInteger("FrameVisual") != 0)
			{
				toolTip.add(TextFormatting.BLACK + "----ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.9") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + TextFormatting.GREEN + EnumsVC.VisualFrame.byId(stack.getTagCompound().getInteger("FrameVisual")).getLocalizedName() + TextFormatting.GRAY + ")");
			}
			else
			{
				toolTip.add(TextFormatting.BLACK + "----ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.9") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
			}
			
			//Visual Balloon
			if(stack.getTagCompound().getInteger("BalloonVisual") != 0)
			{
				toolTip.add(TextFormatting.BLACK + "---ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.10") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + TextFormatting.GREEN + EnumsVC.VisualBalloon.byId(stack.getTagCompound().getInteger("BalloonVisual")).getLocalizedName() + TextFormatting.GRAY + ")");
			}
			else
			{
				toolTip.add(TextFormatting.BLACK + "---ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.10") + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
			}
        }
		else
		{
			toolTip.add(TextFormatting.BLACK + "----ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.9") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
			toolTip.add(TextFormatting.BLACK + "---ii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.10") + TextFormatting.DARK_BLUE + " : " 
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8"));
		}
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	private TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.WHITE;
			case 2:
				return stringColorLabel = TextFormatting.YELLOW;
			case 3:
				return stringColorLabel = TextFormatting.AQUA;
			case 4:
				return stringColorLabel = TextFormatting.LIGHT_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
        	case 0:
        		return EnumRarity.COMMON;
        	case 1:
            	return EnumRarity.COMMON;
            case 2:
            	return EnumRarity.UNCOMMON;
            case 3:
            	return EnumRarity.RARE;
            case 4:
            	return EnumRarity.EPIC;
            case 5:
            	return EnumRarity.EPIC;
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EnumsVC.AirshipTierCore contents : EnumsVC.AirshipTierCore.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}
