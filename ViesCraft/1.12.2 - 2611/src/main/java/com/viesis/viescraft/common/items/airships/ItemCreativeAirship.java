package com.viesis.viescraft.common.items.airships;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.EntityThrownAirship;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeAirship extends ItemCreativeAirshipBase {
	
	public ItemCreativeAirship(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
		this.storedInventory = new NBTTagCompound();
		
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityThrownAirship entityairship = new EntityThrownAirship(worldIn, playerIn, 
						5, 5, 5, 5,
						0,
						0, 0, 0, 1000,
						0, 0, 0,
			    		0, false,
			    		255, 255, 255,
			    		0, 0, 0,
			    		0, false,
			    		200, 180, 140,
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		true, 3, 
			    		this.storedInventory, "Airship");
				
				entityairship.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntity(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
        
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = TextFormatting.GOLD + "" + TextFormatting.BOLD + "Airship";
		
		return colorName 
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ " ("
				+ TextFormatting.BLUE
				+ "C"
				+ TextFormatting.GREEN
				+ "r"
				+ TextFormatting.AQUA
				+ "e"
				+ TextFormatting.RED
				+ "a"
				+ TextFormatting.LIGHT_PURPLE
				+ "t"
				+ TextFormatting.YELLOW
				+ "i"
				+ TextFormatting.WHITE
				+ "v"
				+ TextFormatting.DARK_AQUA
				+ "e"
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ ") ";
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		
		int mainTierCoreInfo = 5;
		int mainTierFrameInfo = 5;
		int mainTierEngineInfo = 5;
		int mainTierBalloonInfo = 5;
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		//item and unleash the airship within.
		tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.1") + this.getPrimaryLabelColor(stack.getMetadata()) + " " + I18n.translateToLocal("vc.item.tt.airship.2"));
		tooltip.add(this.getPrimaryLabelColor(5) + I18n.translateToLocal("vc.item.tt.airship.3"));
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Core = 0 || Frame < 0
		tooltip.add(TextFormatting.DARK_GREEN + "|" 
				+ TextFormatting.BLACK + "-iiiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"+ TextFormatting.BLACK + "l" 
				+ TextFormatting.DARK_GREEN + "|");
		
		//Engine < 0 || Balloon < 0
		tooltip.add(TextFormatting.DARK_GREEN + "|" 
				+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
				+ TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "iiii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "l" 
				+ TextFormatting.DARK_GREEN + "|");
		
		tooltip.add(TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "ii"
				+ TextFormatting.DARK_GREEN + "--------------"
				+ TextFormatting.BLACK + "il"
				+ TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "il"
				+ TextFormatting.DARK_GREEN + "--------------"
				+ TextFormatting.BLACK + "ii"
				+ TextFormatting.DARK_GREEN + "|");
		
		float speedModCal = EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		String altMax = "";
		
		if(mainTierBalloonInfo == 0)
		{
			altMax = TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(mainTierBalloonInfo) + df.format(EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
		}
		else if(mainTierBalloonInfo >= 5)
		{
			altMax = TextFormatting.BLACK + "il" + this.getPrimaryLabelColor(mainTierBalloonInfo) + "\u221e" + TextFormatting.BLACK + "ii";
		}
		else
		{
			altMax = this.getPrimaryLabelColor(mainTierBalloonInfo) + df.format(EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
		}
		
		//----- || Airship Speed
		tooltip.add(TextFormatting.DARK_GREEN + "|"
				//+ TextFormatting.BLACK + "iiii" + TextFormatting.BLACK + "il" + TextFormatting.BLUE + I18n.translateToLocal("Rarity") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				//+ TextFormatting.YELLOW + "Uncommon"
				+ TextFormatting.BLACK + "---------------l" 
				+ TextFormatting.DARK_GREEN + "|" 
				+ TextFormatting.BLACK + "iiill" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(mainTierFrameInfo) + "+" + speedMod + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--l"
				+ TextFormatting.DARK_GREEN + "|");
		
		if(mainTierBalloonInfo == 5)
		{
			//Airship Fuel and Altitude
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + "-" + df.format(EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick()) + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + TextFormatting.RED + " \u221e " + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "iiiiill" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		else
		{
			//Airship Fuel and Altitude
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + "-" + df.format(EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick()) + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i" 
					+ TextFormatting.GRAY + "(" + altMax + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "-iiil" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
}
