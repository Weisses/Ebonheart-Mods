package com.vies.viesmachines.common.items.tools;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.item.MessageGuiRadioExpansion;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionAlreadyKnown;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply1;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply2;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply3;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply4;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply5;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply6;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionApply7;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionFull;
import com.vies.viesmachines.network.server.world.toolradioexpansion.PlayerMessageToolRadioExpansionNoRecord;
import com.vies.viesmachines.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemToolRadioExpansion extends Item {
	
	private String procName;
	
	public ItemToolRadioExpansion() 
	{
		this.setMaxStackSize(1);
		
		this.procName = "ToolsProc";
		
		ItemHelper.setItemName(this, "item_tool_radio_expansion");
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			EntityMachineBase machine = (EntityMachineBase) entity;
			
			if (!machine.getBroken())
			{
				if(stack.hasTagCompound())
				{
					if (!machine.getLearnedRecordSlot1().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot2().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot3().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot4().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot5().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot6().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
					&& !machine.getLearnedRecordSlot7().equals(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG))))
					{
						if (machine.getTierComponent() == 0)
						{
							if (machine.getLearnedRecordSlot1().equals(""))
							{
								machine.setLearnedRecordSlot1(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
								}
							}
							else
							{
								if(player.world.isRemote)
								{
									// Record slots are full:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
								}
							}
						}
						
						
						if (machine.getTierComponent() == 1)
						{
							if (machine.getLearnedRecordSlot1().equals(""))
							{
								machine.setLearnedRecordSlot1(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
								}
							}
							else if (machine.getLearnedRecordSlot2().equals(""))
							{
								machine.setLearnedRecordSlot2(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
								}
							}
							else if (machine.getLearnedRecordSlot3().equals(""))
							{
								machine.setLearnedRecordSlot3(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
								}
							}
							else
							{
								if(player.world.isRemote)
								{
									// Record slots are full:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
								}
							}
						}
						
						
						
						if (machine.getTierComponent() == 2)
						{
							if (machine.getLearnedRecordSlot1().equals(""))
							{
								machine.setLearnedRecordSlot1(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
								}
							}
							else if (machine.getLearnedRecordSlot2().equals(""))
							{
								machine.setLearnedRecordSlot2(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
								}
							}
							else if (machine.getLearnedRecordSlot3().equals(""))
							{
								machine.setLearnedRecordSlot3(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
								}
							}
							else if (machine.getLearnedRecordSlot4().equals(""))
							{
								machine.setLearnedRecordSlot4(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply4());
								}
							}
							else if (machine.getLearnedRecordSlot5().equals(""))
							{
								machine.setLearnedRecordSlot5(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply5());
								}
							}
							else
							{
								if(player.world.isRemote)
								{
									// Record slots are full:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
								}
							}
						}
						
						
						
						if (machine.getTierComponent() == 3)
						{
							if (machine.getLearnedRecordSlot1().equals(""))
							{
								machine.setLearnedRecordSlot1(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
								}
							}
							else if (machine.getLearnedRecordSlot2().equals(""))
							{
								machine.setLearnedRecordSlot2(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
								}
							}
							else if (machine.getLearnedRecordSlot3().equals(""))
							{
								machine.setLearnedRecordSlot3(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
								}
							}
							else if (machine.getLearnedRecordSlot4().equals(""))
							{
								machine.setLearnedRecordSlot4(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply4());
								}
							}
							else if (machine.getLearnedRecordSlot5().equals(""))
							{
								machine.setLearnedRecordSlot5(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply5());
								}
							}
							else if (machine.getLearnedRecordSlot6().equals(""))
							{
								machine.setLearnedRecordSlot6(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply6());
								}
							}
							else if (machine.getLearnedRecordSlot7().equals(""))
							{
								machine.setLearnedRecordSlot7(machine.addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
								
								if(player.world.isRemote)
								{
									// Record applied:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply7());
								}
							}
							else
							{
								if(player.world.isRemote)
								{
									// Record slots are full:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
								}
							}
						}
						
					}
					else
					{
						if(player.world.isRemote)
						{
							// Already knows record:
							NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionAlreadyKnown());
						}
						
					}
				
				}
				else
				{
					if(player.world.isRemote)
					{
						// No record selected:
						NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionNoRecord());
					}
				}
				return true;
			}
			return true;
        }
		else if (entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					
					
					if (!((EntityMachineBase) entity.getRidingEntity()).getBroken())
					{
						if(stack.hasTagCompound())
						{
							if (!((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot1().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot2().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot3().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot4().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot5().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot6().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)))
							&& !((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot7().equals(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG))))
							{
								if (((EntityMachineBase) entity.getRidingEntity()).getTierComponent() == 0)
								{
									if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot1().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot1(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
										}
									}
									else
									{
										if(player.world.isRemote)
										{
											// Record slots are full:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
										}
									}
								}
								
								
								if (((EntityMachineBase) entity.getRidingEntity()).getTierComponent() == 1)
								{
									if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot1().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot1(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot2().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot2(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot3().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot3(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
										}
									}
									else
									{
										if(player.world.isRemote)
										{
											// Record slots are full:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
										}
									}
								}
								
								
								
								if (((EntityMachineBase) entity.getRidingEntity()).getTierComponent() == 2)
								{
									if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot1().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot1(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot2().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot2(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot3().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot3(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot4().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot4(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply4());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot5().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot5(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply5());
										}
									}
									else
									{
										if(player.world.isRemote)
										{
											// Record slots are full:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
										}
									}
								}
								
								
								
								if (((EntityMachineBase) entity.getRidingEntity()).getTierComponent() == 3)
								{
									if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot1().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot1(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply1());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot2().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot2(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply2());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot3().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot3(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply3());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot4().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot4(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply4());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot5().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot5(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply5());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot6().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot6(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply6());
										}
									}
									else if (((EntityMachineBase) entity.getRidingEntity()).getLearnedRecordSlot7().equals(""))
									{
										((EntityMachineBase) entity.getRidingEntity()).setLearnedRecordSlot7(((EntityMachineBase) entity.getRidingEntity()).addSongtoRecordList(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)));
										
										if(player.world.isRemote)
										{
											// Record applied:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionApply7());
										}
									}
									else
									{
										if(player.world.isRemote)
										{
											// Record slots are full:
											NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionFull());
										}
									}
								}
								
							}
							else
							{
								if(player.world.isRemote)
								{
									// Already knows record:
									NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionAlreadyKnown());
								}
								
							}
						
						}
						else
						{
							if(player.world.isRemote)
							{
								// No record selected:
								NetworkHandler.sendToServer(new PlayerMessageToolRadioExpansionNoRecord());
							}
						}
						return true;
					}
					return true;
				}
				return true;
			}
			return true;
        }
        return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if (entity.world.isRemote)
        {
            return false;
        }
		return false;
    }
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
        
    	if(playerIn.isSneaking())
    	{
    		if(playerIn.world.isRemote)
    		{
    			NetworkHandler.sendToServer(new MessageGuiRadioExpansion());
    			//NetworkHandler.sendToServer(new GuiRadioExpansionSelectMusic(playerIn, itemstack));
        		//Minecraft.getMinecraft().displayGuiScreen(new GuiRadioExpansionSelectMusic(playerIn, itemstack));
			}
    		return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
        }
        return new ActionResult<ItemStack>(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		if(stack.hasTagCompound())
		{
			tooltip.add(
					References.Old_I18n.translateToLocal("viesmachines.gui.currentsong.0") + " : " + 
					this.stringToFlashGolden(
					References.localNameVC( "item." + CommonProxy.musicListRecord.get(stack.getTagCompound().getInteger(References.TOOL_RECORD_TO_ADD_TAG)).getResourcePath().toString() + ".desc")
					, 1, false, TextFormatting.DARK_AQUA, 0));
		}
		else
		{
			tooltip.add(TextFormatting.RED + References.Old_I18n.translateToLocal("viesmachines.gui.norecordselected.0") + ".");
		}
		
		tooltip.add("");
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1") 
		+ " " + TextFormatting.GOLD + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
		tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.3"));
		tooltip.add("");
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines.leftclick") + " " + TextFormatting.GOLD + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.5"));
		tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.6"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.UNCOMMON;
    }

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }/** Makes the inserted string flash. */
	protected static String stringToFlashGolden(String parString, int parShineLocation, boolean parReturnToBlack, TextFormatting colorIn, int colorTypeIn)
	{
		int stringLength = parString.length();
		
		TextFormatting color1 = TextFormatting.WHITE;
		TextFormatting color2 = TextFormatting.YELLOW;
		
		if (colorTypeIn == 1)
		{
			color1 = TextFormatting.LIGHT_PURPLE;
			color2 = TextFormatting.DARK_PURPLE;
		}
		
		if(stringLength < 1)
		{
			return "";
		}
		
		String outputString = "";
		
		for(int i = 0; i < stringLength; i++)
		{
			if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 0)
			{
				outputString = outputString + color1 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 1)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 87)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else
			{
				outputString = outputString + colorIn + parString.substring(i, i + 1);        
			}
		}
		
		// Return color to a common one after (most chat is white, but for other GUI might want black):
		if(parReturnToBlack)
		{
			return outputString + TextFormatting.BLACK;
		}
		
		return outputString + TextFormatting.WHITE;
	}
}
