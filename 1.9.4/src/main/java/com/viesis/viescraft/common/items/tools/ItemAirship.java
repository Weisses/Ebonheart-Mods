package com.viesis.viescraft.common.items.tools;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.EntityAirshipEA;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAirship extends Item {
		
		
	    //private final EntityBoat.Type type;

	    public ItemAirship(
	    		//EntityBoat.Type typeIn
	    		)
	    {
	    	super();
	        //this.type = typeIn;
	        this.maxStackSize = 1;
	        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
	        //this.setUnlocalizedName("ebon_airship." + typeIn.getName());
	        ItemHelper.setItemName(this, "ebon_airship");
	    }

	    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
	    {
	        float f = 1.0F;
	        float f1 = playerIn.prevRotationPitch + (playerIn.rotationPitch - playerIn.prevRotationPitch) * f;
	        float f2 = playerIn.prevRotationYaw + (playerIn.rotationYaw - playerIn.prevRotationYaw) * f;
	        double d0 = playerIn.prevPosX + (playerIn.posX - playerIn.prevPosX) * (double)f;
	        double d1 = playerIn.prevPosY + (playerIn.posY - playerIn.prevPosY) * (double)f + (double)playerIn.getEyeHeight();
	        double d2 = playerIn.prevPosZ + (playerIn.posZ - playerIn.prevPosZ) * (double)f;
	        Vec3d vec3d = new Vec3d(d0, d1, d2);
	        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
	        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
	        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
	        float f6 = MathHelper.sin(-f1 * 0.017453292F);
	        float f7 = f4 * f5;
	        float f8 = f3 * f5;
	        double d3 = 5.0D;
	        Vec3d vec3d1 = vec3d.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
	        RayTraceResult raytraceresult = worldIn.rayTraceBlocks(vec3d, vec3d1, true);

	        if (raytraceresult == null)
	        {
	            return new ActionResult(EnumActionResult.PASS, itemStackIn);
	        }
	        else
	        {
	            Vec3d vec3d2 = playerIn.getLook(f);
	            boolean flag = false;
	            List<Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, playerIn.getEntityBoundingBox().addCoord(vec3d2.xCoord * d3, vec3d2.yCoord * d3, vec3d2.zCoord * d3).expandXyz(1.0D));

	            for (int i = 0; i < list.size(); ++i)
	            {
	                Entity entity = (Entity)list.get(i);

	                if (entity.canBeCollidedWith())
	                {
	                    AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox().expandXyz((double)entity.getCollisionBorderSize());

	                    if (axisalignedbb.isVecInside(vec3d))
	                    {
	                        flag = true;
	                    }
	                }
	            }

	            if (flag)
	            {
	                return new ActionResult(EnumActionResult.PASS, itemStackIn);
	            }
	            else if (raytraceresult.typeOfHit != RayTraceResult.Type.BLOCK)
	            {
	                return new ActionResult(EnumActionResult.PASS, itemStackIn);
	            }
	            else
	            {
	                Block block = worldIn.getBlockState(raytraceresult.getBlockPos()).getBlock();
	                boolean flag1 = block == Blocks.WATER || block == Blocks.FLOWING_WATER;
	                EntityAirshipEA EntityAirshipEA = new EntityAirshipEA(worldIn, raytraceresult.hitVec.xCoord, flag1 ? raytraceresult.hitVec.yCoord - 0.12D : raytraceresult.hitVec.yCoord, raytraceresult.hitVec.zCoord);
	                //EntityAirshipEA.setBoatType(this.type);
	                EntityAirshipEA.rotationYaw = playerIn.rotationYaw;

	                if (!worldIn.getCollisionBoxes(EntityAirshipEA, EntityAirshipEA.getEntityBoundingBox().expandXyz(-0.1D)).isEmpty())
	                {
	                    return new ActionResult(EnumActionResult.FAIL, itemStackIn);
	                }
	                else
	                {
	                    if (!worldIn.isRemote)
	                    {
	                        worldIn.spawnEntityInWorld(EntityAirshipEA);
	                    }

	                    if (!playerIn.capabilities.isCreativeMode)
	                    {
	                        --itemStackIn.stackSize;
	                    }

	                    playerIn.addStat(StatList.getObjectUseStats(this));
	                    return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
	                }
	            }
	        }
	    }
	
	
}
