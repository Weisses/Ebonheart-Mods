package com.viesis.viescraft.testbed.common.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateClimber;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.BossInfo;
import net.minecraft.world.BossInfoServer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.viesis.viescraft.api.gui.GuiHandler;

public class EntityVC extends EntityLiving {
	
	private BlockPos homePosition = BlockPos.ORIGIN;
	private float maximumHomeDistance = -1.0F;
	
	public EntityVC(World worldIn) 
	{
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
     * Sets home position and max distance for it
     */
    public void setHomePosAndDistance(BlockPos pos, int distance)
    {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }
	
	/**
     * Applies logic related to leashes, for example dragging the entity or breaking the leash.
     */
    protected void updateLeashedState()
    {
        super.updateLeashedState();

        if (this.getLeashed() && this.getLeashedToEntity() != null && this.getLeashedToEntity().worldObj == this.worldObj)
        {
            Entity entity = this.getLeashedToEntity();
            this.setHomePosAndDistance(new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 5);
            float f = this.getDistanceToEntity(entity);

            //if (this instanceof EntityTameable && ((EntityTameable)this).isSitting())
            //{
            //    if (f > 10.0F)
            //    {
            //        this.clearLeashed(true, true);
            //    }

            //    return;
            //}

            //if (!this.isMovementAITaskSet)
            //{
            //    this.tasks.addTask(2, this.aiBase);

            //    if (this.getNavigator() instanceof PathNavigateGround)
            //    {
            //        this.restoreWaterCost = this.getPathPriority(PathNodeType.WATER);
            //        this.setPathPriority(PathNodeType.WATER, 0.0F);
            //    }

            //    this.isMovementAITaskSet = true;
            //}

            this.onLeashDistance(f);

            if (f > 4.0F)
            {
                this.getNavigator().tryMoveToEntityLiving(entity, 1.0D);
            }

            if (f > 6.0F)
            {
                double d0 = (entity.posX - this.posX) / (double)f;
                double d1 = (entity.posY - this.posY) / (double)f;
                double d2 = (entity.posZ - this.posZ) / (double)f;
                this.motionX += d0 * Math.abs(d0) * 0.4D;
                this.motionY += d1 * Math.abs(d1) * 0.4D;
                this.motionZ += d2 * Math.abs(d2) * 0.4D;
            }

            if (f > 10.0F)
            {
                this.clearLeashed(true, true);
            }
        }
        //else if (!this.getLeashed() && this.isMovementAITaskSet)
        //{
        //    this.isMovementAITaskSet = false;
            //this.tasks.removeTask(this.aiBase);

        //    if (this.getNavigator() instanceof PathNavigateGround)
        //    {
        //        this.setPathPriority(PathNodeType.WATER, this.restoreWaterCost);
        //    }

        //    this.detachHome();
        //}
    }

    protected void onLeashDistance(float p_142017_1_)
    {
    }
	
	
}
	
	
