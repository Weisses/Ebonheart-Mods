package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.armor;

import java.util.List;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.api.util.LogHelper;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.common.items.MaterialHelper;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

//Ender
public class ItemVoidArmor extends ItemArmor {
	
	public static boolean isTeleported = false;
	Random random = new Random();
	public float width;
	public float height;
	private static int cooldown;
	boolean flag = false;
	
	public ItemVoidArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.VOID, renderIndexIn, equipmentSlotIn);
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(EbonArtsMod.tabEbonArtsItems);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return Items.ENDER_EYE == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "Strong scales are woven in a flexible");
		toolTip.add(TextFormatting.DARK_AQUA + "mesh, enhancing acrobatics.");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + "Set Bonus:");
		toolTip.add(TextFormatting.GREEN + "Ability - Double Jump.");
		toolTip.add(TextFormatting.GREEN + "Ability - Safe Fall.");
		//toolTip.add(TextFormatting.GREEN + "Speed increased by 110%");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsEA.void_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsEA.void_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsEA.void_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsEA.void_boots) 
		{
			player.fallDistance = 0;
			
			//if(!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS))
			//{
			//	player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS);
			//	player.fallDistance = 0;
			//}
			
			if(isTeleported) 
			{
				//if(player.onGround)
				//{
					cooldown++;
					
					if(cooldown > 1000)
					{
						isTeleported = false;
						LogHelper.info("isTeleport is false!");
						cooldown = 0;
					}
				//}
				
			}
			
			
			if (world.isRemote)
			{
				if(Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed())
				{
					
					if(!player.onGround && !isTeleported)
					{
						
						int blockReachDistance = 10;
						float partialTicks = 10.1F;
						
						double posX;
						double posY;
						double posZ;
						double playerPosX;
						double playerPosY;
						double playerPosZ;
						
						int i = 512;
						
						playerPosX = player.getPositionVector().xCoord;
						playerPosY = player.getPositionVector().yCoord;
						playerPosZ = player.getPositionVector().zCoord;
						
						//EnumFacing playerFacing = player.getHorizontalFacing();
						//BlockPos pos = new BlockPos(player.rayTrace(blockReachDistance, partialTicks).hitVec.xCoord, player.rayTrace(blockReachDistance, partialTicks).hitVec.yCoord, player.rayTrace(blockReachDistance, partialTicks).hitVec.zCoord);//.getBlockPos());
						posX = player.rayTrace(blockReachDistance, partialTicks).hitVec.xCoord;
						posY = player.rayTrace(blockReachDistance, partialTicks).hitVec.yCoord;
						posZ = player.rayTrace(blockReachDistance, partialTicks).hitVec.zCoord;
						
						//.offset(player.getHorizontalFacing())
						//player.getTeleportDirection()
						
						//player.teleportTo_(posX, posY, posZ);
						
						//LogHelper.info("Teleport SUCCESS!");
						LogHelper.info("Player  Coors:" +  "X: " + playerPosX + " | Y: " + playerPosY + " | Z: " + playerPosZ);
						LogHelper.info("Raycast Coors:" +  "X: " + posX + " | Y: " + posY + " | Z: " + posZ);
							
						
						double d0 = playerPosX;
				        double d1 = playerPosY;
				        double d2 = playerPosZ;
						
				        
						for (int j = 0; j < i; ++j)
				        {
							
							double d6 = (double)j / ((double)i - 1.0D);
							float f = (random.nextFloat() - 0.5F) * 0.2F;
			                float f1 = (random.nextFloat() - 0.5F) * 0.2F;
			                float f2 = (random.nextFloat() - 0.5F) * 0.2F;
			                double d3 = d0 + (posX - player.getPosition().getX()) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 4.0D;
			                double d4 = d1 + (posY - player.getPosition().getY()) * d6 + random.nextDouble() * (double)this.height;
			                double d5 = d2 + (posZ - player.getPosition().getZ()) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 4.0D;
			                
			                world.spawnParticle(EnumParticleTypes.PORTAL, d3, d4, d5, (double)f, (double)f1, (double)f2, new int[0]);
						
				        }
						
						
						
						//if (posZ > 0)
						//{
						//	double minusOne = posZ - 1;
						//}
						//=====================================
						
						while (posX - playerPosX > 2)
						{
						player.addVelocity(player.motionX + 1, player.motionY + 1, player.motionZ + 1);
						}
						
						//else
						//{
						//	player.addVelocity(0, 0, 0 );
						//}
						//player.setPosition(posX - 0.1 , posY - 0.1, posZ - 0.1);
						
						
						//====================================
						//if(playerFacing == EnumFacing.NORTH)
						//{
							
							
							
						//}
						//player.setPosition(posX, posY, posZ);
						//player.moveEntity(posX, posY, posZ);
						//player.moveToBlockPosAndAngles(pos, player.rotationYaw, player.rotationPitch);
						isTeleported = true;
						LogHelper.info("teleport is true!");
						//LogHelper.info("facing: " + player.getHorizontalFacing());
						
						
						//if (!flag)
				        //{
						//	if (world.getCubes(player, player.getEntityBoundingBox()).isEmpty() && !world.isAnyLiquid(player.getEntityBoundingBox()))
			            //    {
			             //       flag = true;
			             //   }
							//player.moveToBlockPosAndAngles(pos, player.rotationYaw, player.rotationPitch);
						//	player.setPositionAndUpdate(posX, posY, posZ);
						//	for (int j = 0; j < i; ++j)
				        //    {
				        //        double d6 = (double)j / ((double)i - 1.0D);
				        //        float f = (random.nextFloat() - 0.5F) * 0.2F;
				        //        float f1 = (random.nextFloat() - 0.5F) * 0.2F;
				         //       float f2 = (random.nextFloat() - 0.5F) * 0.2F;
				        //        double d3 = playerPosX + (playerPosX - playerPosX) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				       //         double d4 = playerPosY + (playerPosY - playerPosY) * d6 + random.nextDouble() * (double)this.height;
				        //        double d5 = playerPosZ + (playerPosZ - playerPosZ) * d6 + (random.nextDouble() - 0.5D) * (double)this.width * 2.0D;
				       //         world.spawnParticle(EnumParticleTypes.PORTAL, d3, d4, d5, (double)f, (double)f1, (double)f2, new int[0]);
				       //     }
							
				            //player.setPositionAndUpdate(posX, posY, posZ);
				            //return false;
				        //}
				        //else
				        //{
				            //int i = 128;

				            

				            
				       // }
						
						//player.resetCooldown();
						//player.getCooldownPeriod();
						
						//for (int cooldown = 0; cooldown < 501; ++cooldown)
				        //{
							
						//	if(cooldown > 499)
						//	{
						//		isTeleported = false;
						//	}
							
				        //}
					}
				}
			}
		}
		//else
		//{
		//	player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS);
		//}
	}
}

/**
//player.posX = posX;
						//player.posY = posY;
						//player.posZ = posZ;
						
						//;
						 * //player.getTeleportDirection();
						//player.rayTrace(blockReachDistance, partialTicks);
						//BlockPos pos = new BlockPos(player.rayTrace(10, partialTicks).hitVec);
						
						 

//BlockPos pos = new BlockPos(player.rayTrace(10, 1).sideHit.getDirectionVec());
//BlockPos pos = new BlockPos(player.rayTrace(10, 1).getBlockPos().getDistance(this.getX(), p_185332_2_, p_185332_3_));
//if (//playerPosX + 10 <= posX
						//		posX != null
								//posX <= playerPosX + 10 || posX >= playerPosX - 10
						 //&& posY <= playerPosY + 10 || posY >= playerPosY - 10
						 //&& posZ <= playerPosZ + 10 || posZ >= playerPosZ - 10
						//		)
						//{
						
						//test = (posD - posY);
						//test1 = posX >= 10 || posX <= -10; 
						if (posX <= playerPosX + 10 || posX >= playerPosX - 10
						 && posY <= playerPosY + 10 || posY >= playerPosY - 10
						 && posZ <= playerPosZ + 10 || posZ >= playerPosZ - 10)
						{
						
						
						//player.addVelocity((posX - playerPosX) * 0.1, (posY - playerPosY) * 0.1, (posZ - playerPosZ) * 0.1);
						//test3 = player.playerLocation.offset(player.getHorizontalFacing(), 10);
						//player.teleportTo_(posX, 
						//		posY, 
						//		posZ);
						//test2 = player.getTeleportDirection().getDirectionVec().getY();
						//player.addVelocity((posX - playerPosX), (posY - playerPosY), (posZ - playerPosZ));
						//player.getRotatedYaw(null)
						//}
						//else
						//{
						//	LogHelper.info("Teleport FAILED!");
						//	LogHelper.info("Player  Coors:" +  "X: " + playerPosX + " | Y: " + playerPosY + " | Z: " + playerPosZ);
						//	LogHelper.info("Raycast Coors:" +  "X: " + posX + " | Y: " + posY + " | Z: " + posZ);
							
						//}
						
						
						//player.teleportTo_(posX, posY, posZ);
						//LogHelper.info("Teleported!");
						//LogHelper.info("Player  Coors:" +  "X: " + playerPosX + " | Y: " + playerPosY + " | Z: " + playerPosZ);
						//LogHelper.info("Raycast Coors:" +  "X: " + posX + " | Y: " + posY + " | Z: " + posZ);
						
						
						//player.teleportTo_(posX, posY, posZ);
						//isTeleported = true;
						//LogHelper.info("Coors:" +  "X: " + posX + " | Y: " + pos.getY() + " | Z: " + posZ);
					
						

**/