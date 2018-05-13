package com.viesis.viescraft.common.items.airships;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.entity.EntityThrownAirship;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
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
						0, 0, 500, 500,
						64, 16, 8,
						0, 0, 0,
			    		0, false,
			    		255, 255, 255,
			    		0, 0, 0, 0, 0, 0, 0,
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
			    		this.storedInventory, "Creative");
				
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
		String colorName = TextFormatting.GOLD + "Creative";
		
		return TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.main.airship") + TextFormatting.GREEN + " - " + colorName + " " 
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
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		int mainTierCoreInfo = 5;
		int mainTierFrameInfo = 5;
		int mainTierEngineInfo = 5;
		int mainTierBalloonInfo = 5;
		
		int currentRedstoneInfo = 500;
		int currentModuleSlot1Info = 0;
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.airship.1") + this.getSecondaryLabelColor(stack.getMetadata()) + " " + References.localNameVC("vc.item.tt.airship.2"));
		//item and unleash the airship within.
		tooltip.add(this.getSecondaryLabelColor(stack.getMetadata()) + References.localNameVC("vc.item.tt.airship.3"));
		
		if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			//Core : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.core") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.redstone") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getStoredRedstone());
			//Frame : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.frame") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.speed") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierFrameInfo) + "+" + mainTierFrameInfo);
			//Engine : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.engine") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.fuel") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick());
			//Balloon : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.balloon") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.altitude") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
			
			tooltip.add("");
			//Stored Redstone : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.storedredstone") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GREEN + currentRedstoneInfo);
			//Current Module : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.current") + " " + References.localNameVC("vc.item.module.#") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "None");
		}
		else
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.shifthelper.0"));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
}
