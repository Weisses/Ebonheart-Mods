package com.viesis.viescraft.testbed;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.EntityAirshipBase;
import com.viesis.viescraft.init.InitItemsVC;

public class juneSeventhEntityAirshipBase {

}
public class EntityAirshipBase extends 

//EntityLivingBase // Too far back, cannot attack!
//EntityLiving  //  Leads do not work at all
EntityCreature // tested leads here.  no graphic on connecting rope.
//EntityAgeable
//EntityAnimal
//EntityChicken // tested leads here.  no graphic on connecting rope.
//EntityFuelVC
//implements IInventoryChangedListener
{
	Random random = new Random();
	
	private float AirshipSpeedTurn = 0.18F;
  private float AirshipSpeedForward = 0.0125F;
  private float AirshipSpeedUp = 0.0125F;
  private float AirshipSpeedDown = 0.0125F;
  
	public float momentum;
  public float deltaRotation;
  public float alphaRotation;
  
  public double waterLevel;
  
  public float boatGlide;
  public EntityAirshipBase.Status status;
  public EntityAirshipBase.Status previousStatus;
  public double lastYd;
  
	public boolean leftInputDown;
  public boolean rightInputDown;
  public boolean forwardInputDown;
  public boolean backInputDown;
  public boolean upInputDown;
  public boolean downInputDown;
  public boolean openInputDown;
	
	public double airshipPitch;
	public double airshipYaw;
  public double fallY;
  public double fallZ;
  public int fallSteps;
  public double fallXRot;
	
	public EntityAirshipBase(World worldIn) 
	{
		super(worldIn);
		
		this.preventEntitySpawning = true;
      this.setSize(1.0F, 0.35F);
      
	}

	public EntityAirshipBase(World worldIn, double x, double y, double z)
  {
      this(worldIn);
      this.setPosition(x, y, z);
      this.motionX = 0.0D;
      this.motionY = 0.0D;
      this.motionZ = 0.0D;
      this.prevPosX = x;
      this.prevPosY = y;
      this.prevPosZ = z;
  }
	
	protected void initEntityAI()
  {
		//this.tasks.addTask(0, new EntityAIFall(this, 1.0D));
      //this.tasks.addTask(0, new EntityAISwimming(this));
      //this.tasks.addTask(1, new EntityAIPanic(this, 1.4D));
      //this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
      //this.tasks.addTask(3, new EntityAITempt(this, 1.0D, false, TEMPTATION_ITEMS));
      //this.tasks.addTask(4, new EntityAIFollowParent(this, 1.1D));
      //this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
      //this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
      //this.tasks.addTask(7, new EntityAILookIdle(this));
  }


  protected void applyEntityAttributes()
  {
      super.applyEntityAttributes();
      
      this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(1.0D);
  }

  
  
  
  
  
  public boolean processInteract(EntityPlayer player, EnumHand hand, @Nullable ItemStack stack)
  {
      
      if (player.isSneaking())
      {
      	LogHelper.info("Opening inventory");
          ////this.openGUI(player);
          return true;
      }
      else if (this.isBeingRidden())
      {
          return super.processInteract(player, hand, stack);
      }
      else
      {
          if (stack != null)
          {
              
              HorseArmorType horsearmortype = HorseArmorType.getByItemStack(stack);

              if (horsearmortype != HorseArmorType.NONE)
              {
                     // if (!this.isTame())
                      //{
                      //    this.makeHorseRearWithSound();
                     //     return true;
                     // }
              	LogHelper.info("Opening inventory 2");
                      ////this.openGUI(player);
              	return true;
              }
              
              boolean flag = false;
              
              float f = 0.0F;
              int i = 0;
              int j = 0;

              if (stack.getItem() == Items.WHEAT)
              {
              	f = 2.0F;
                  i = 20;
                  j = 3;
              }
              else if (Block.getBlockFromItem(stack.getItem()) == Blocks.HAY_BLOCK)
              {
                  f = 20.0F;
                  i = 180;
              }
                  

              if (this.getHealth() < this.getMaxHealth() && f > 0.0F)
              {
                  this.heal(f);
                  flag = true;
              }


              if (!flag && stack.getItem() == Item.getItemFromBlock(Blocks.CHEST))
              {
                  //this.setChested(true);
                  //this.playSound(SoundEvents.ENTITY_DONKEY_CHEST, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                  flag = true;
                  //this.initAirshipChest();
              }

              if (!flag && stack.getItem() == Items.SADDLE)
              {
                  ////this.openGUI(player);
                  return true;
              }

              if (flag)
              {
                  if (!player.capabilities.isCreativeMode)
                  {
                      --stack.stackSize;
                  }

                  return true;
              }
          }

          if (!this.isBeingRidden())
          {
              if (stack != null && stack.interactWithEntity(player, this, hand))
              {
                  return true;
              }
              else
              {
                  this.mountTo(player);
                  return true;
              }
          }
          else
          {
              return super.processInteract(player, hand, stack);
          }
      }
  }

  private void mountTo(EntityPlayer player)
  {
      if (!this.worldObj.isRemote)
      {
          player.startRiding(this);
      }
  }
  
  /**
 	 * Set the position and rotation values directly without any clamping.
   */ 
  @SideOnly(Side.CLIENT)
  public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
  {
      this.airshipPitch = x;
      this.fallY = y;
      this.fallZ = z;
      this.airshipYaw = (double)yaw;
      this.fallXRot = (double)pitch;
      this.fallSteps = 10;
  }
  
  
  
  
  
  //==================================//
  //            On Update             //
	//==================================//
  
  /**
   * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
   * use this to react to sunlight and start to burn.
   */
  public void onLivingUpdate()
  {
  	
      super.onLivingUpdate();
      
      
      
      //if (!this.onGround && this.motionY < 0.0D)
      //{
      //    this.motionY *= 0.6D;
      //}
      //LogHelper.info(this.getControllingPassenger() == null);
      
      
      //this.motionY = 0;
      
  }

  
  
  /**
   * Called to update the entity's position/logic.
   */ 
  public void onUpdate()
  {
  	this.previousStatus = this.status;
      this.status = this.getAirshipStatus();
      
      this.prevPosX = this.posX;
      this.prevPosY = this.posY;
      this.prevPosZ = this.posZ;
      
      super.onUpdate();
      this.tickFall();
      
      this.motionY = 0;
      
      if (this.getControllingPassenger() instanceof EntityPlayer && 
      		this.isBeingRidden())
      {
          this.updateMotion();
          
          if (this.worldObj.isRemote)
          {
          	this.updateInputs();
          	this.controlAirship();
          	
          	
          }
          
          this.moveEntity(this.motionX, this.motionY, this.motionZ);
      }
      else
      {
      	
          this.motionX = 0.0D;
          this.motionY = 0.0D;
          this.motionZ = 0.0D;
      }
  }
  
  
  
  
  
      
/**
      //this.doBlockCollisions();
      List<Entity> list = this.worldObj.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntitySelectors.<Entity>getTeamCollisionPredicate(this));

      if (!list.isEmpty())
      {
          boolean flag = !this.worldObj.isRemote && !(this.getControllingPassenger() instanceof EntityPlayer);

          for (int j = 0; j < list.size(); ++j)
          {
             Entity entity = (Entity)list.get(j);

              if (!entity.isPassenger(this))
              {
              	if (flag && this.getPassengers().size() < 2 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                  if (flag && this.getPassengers().size() < 1 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                  {
                      entity.startRiding(this);
                  }
                 else
                  {
                      this.applyEntityCollision(entity);
                  }
              }
          }
      }
  }
*/
  //**
  // * Downward empty movement.
  // 
  private void tickFall()
  {
      if (this.fallSteps > 0 && !this.canPassengerSteer())
      {
          double d0 = this.posX + (this.airshipPitch - this.posX) / (double)this.fallSteps;
          double d1 = this.posY + (this.fallY - this.posY) / (double)this.fallSteps;
          double d2 = this.posZ + (this.fallZ - this.posZ) / (double)this.fallSteps;
          double d3 = MathHelper.wrapDegrees(this.airshipYaw - (double)this.rotationYaw);
          this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.fallSteps);
          this.rotationPitch = (float)((double)this.rotationPitch + (this.fallXRot - (double)this.rotationPitch) / (double)this.fallSteps);
          --this.fallSteps;
          this.setPosition(d0, d1, d2);
          this.setRotation(this.rotationYaw, this.rotationPitch);
      }
  }
  
  @Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
	{
		
	}
  
  @Override
  public void fall(float distance, float damageMultiplier)
  {
  }

  
  
  
	//==================================//
  //              Sounds              //
	//==================================//
  
  protected SoundEvent getAmbientSound()
  {
      return SoundEvents.ENTITY_CHICKEN_AMBIENT;
  }

  protected SoundEvent getHurtSound()
  {
      return SoundEvents.ENTITY_CHICKEN_HURT;
  }

  protected SoundEvent getDeathSound()
  {
      return SoundEvents.ENTITY_CHICKEN_DEATH;
  }

  protected void playStepSound(BlockPos pos, Block blockIn)
  {
      this.playSound(SoundEvents.ENTITY_CHICKEN_STEP, 0.15F, 1.0F);
  }
  
  
  
  
  
  
  //==================================//
  //      Airship / Player Logic      //
	//==================================//
  
  
  
  
  private void controlAirship()
  {
      if (this.isBeingRidden())
      {
          float f = 0.0F;
          float f1 = 0.0F;

          if (this.leftInputDown)
          {
              this.deltaRotation -= AirshipSpeedTurn;
              this.alphaRotation -= AirshipSpeedTurn;
          }

          if (this.rightInputDown)
          {
              this.deltaRotation += AirshipSpeedTurn; //0.2F;//  0.4    += 1.0F;
          }

          if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
          {
              f += 0.005F;
          }

          this.rotationYaw += this.deltaRotation;

          if (this.forwardInputDown)
          {
              f += AirshipSpeedForward;
          }

          if (this.backInputDown)
          {
              f -= AirshipSpeedForward * 0.5;
          }
          
          if (this.upInputDown)
          {
              f1 += AirshipSpeedUp;
          }
          
          if (this.downInputDown)
          {
              f1 -= AirshipSpeedDown;
          }
          
          

          this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
          this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
          this.motionY += (double)(2.5
          		//3.017453292F
          		* f1);
          
          this.rotationPitch += 10;
          
          
          
          
      }
  }
  
//**
  // * Update the boat's speed, based on momentum.
  // 
  private void updateMotion()
  {
      this.momentum = 0.9F;
      
      if (this.previousStatus == EntityAirshipBase.Status.IN_AIR && this.status != EntityAirshipBase.Status.IN_AIR && this.status != EntityAirshipBase.Status.ON_LAND)
      {
          this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
          this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
          this.motionY = 0.0D;
          this.lastYd = 0.0D;
          this.status = EntityAirshipBase.Status.IN_WATER;
      }
      else
      {
          if (this.status == EntityAirshipBase.Status.IN_WATER)
          {
          	this.momentum = 0.45F;
          }
          else if (this.status == EntityAirshipBase.Status.UNDER_FLOWING_WATER 
      	  || this.status == EntityAirshipBase.Status.UNDER_WATER)
          {
          	if (!this.worldObj.isRemote)
          	{
          		this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
          		
          		int drop1 = random.nextInt(100) + 1;
          		int drop2 = random.nextInt(100) + 1;
          		int drop3 = random.nextInt(100) + 1;
          		int drop4 = random.nextInt(100) + 1;
          		int drop5 = random.nextInt(100) + 1;
          		
          	    if (drop1 < 75)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_balloon, 1, 0.0F);
              	}
          	    
          	    if (drop2 < 55)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
              	
          	    	if (drop3 < 35)
                  	{
              	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
                  	}
              	}
          	    
          	    if (drop4 < 35)
              	{
          	    	this.dropItemWithOffset(Items.MINECART, 1, 0.0F);
              	}
          	    
          	    if (drop5 < 15)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_ignition, 1, 0.0F);
              	}
          	}
          	this.setDead();
          }
          else if (this.status == EntityAirshipBase.Status.IN_AIR
          	  || this.status == EntityAirshipBase.Status.ON_LAND)
          {
          	this.momentum = 0.9F;
          }
          
          this.motionX *= (double)this.momentum;
          this.motionZ *= (double)this.momentum;
          this.deltaRotation *= this.momentum;
          
          if(this.getControllingPassenger() == null)
      	{
          	this.motionY += -0.001D;
      	}
          else
          {
          	this.motionY *= (double)this.momentum;//+= d1;
          }
      }
      
      //if(!this.isDead)
      //{
      //	this.momentum = 0.1F;
      //}
      
      
      

      this.motionX *= (double)this.momentum;
      this.motionZ *= (double)this.momentum;
      this.deltaRotation *= this.momentum;
      this.motionY *= (double)this.momentum;
      
      
      //if(this.getControllingPassenger() == null)
      //{
      	//this.motionY += -10.1D;
      //	LogHelper.info("No passenger");
      	
      //	this.motionY += -1.1;
          	
      //}
      //else
      //{
      //	LogHelper.info("Passenger!");
      	
      //	this.motionY = 0;
      	
      //}
      
      //this.motionY *= (double)this.momentum;
/**        if (this.isInWater())//this.status == EntityAirshipBase.Status.UNDER_FLOWING_WATER 
          //  || this.status == EntityAirshipBase.Status.UNDER_WATER)
        {
        	if (!this.worldObj.isRemote)
            {
        		this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
              		
              	int drop1 = random.nextInt(100) + 1;
              	int drop2 = random.nextInt(100) + 1;
              	int drop3 = random.nextInt(100) + 1;
              	int drop4 = random.nextInt(100) + 1;
              	int drop5 = random.nextInt(100) + 1;
              		
              	if (drop1 < 75)
                {
              	    this.dropItemWithOffset(InitItemsVC.airship_balloon, 1, 0.0F);
                }
              	    
              	if (drop2 < 55)
                {
              		this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
                  	
              	    if (drop3 < 35)
                    {
                  	    this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
                    }
                }
              	    
              	if (drop4 < 35)
                {
              	    this.dropItemWithOffset(Items.MINECART, 1, 0.0F);
                }
              	    
              	if (drop5 < 15)
                {
              	    this.dropItemWithOffset(InitItemsVC.airship_ignition, 1, 0.0F);
                }
            }
            this.setDead();//.isDead;//AirshipDead();
        }
      */
      
      //if(this.getControllingPassenger() == null)
  	//{
      //	this.motionY += -0.001D;
      	
  	//}
      //else
      //{
      //	this.motionY *= (double)this.momentum;//+= d1;
      //}
      
  }
/**
      if (this.previousStatus == EntityAirshipBase.Status.IN_AIR && this.status != EntityAirshipBase.Status.IN_AIR && this.status != EntityAirshipBase.Status.ON_LAND)
      {
          this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
          this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
          this.motionY = 0.0D;
          this.lastYd = 0.0D;
          this.status = EntityAirshipBase.Status.IN_WATER;
      }
      else
      {
          if (this.status == EntityAirshipBase.Status.IN_WATER)
          {
          	this.momentum = 0.45F;
          }
          else if (this.status == EntityAirshipBase.Status.UNDER_FLOWING_WATER 
      	  || this.status == EntityAirshipBase.Status.UNDER_WATER)
          {
          	if (!this.worldObj.isRemote)
          	{
          		this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
          		
          		int drop1 = random.nextInt(100) + 1;
          		int drop2 = random.nextInt(100) + 1;
          		int drop3 = random.nextInt(100) + 1;
          		int drop4 = random.nextInt(100) + 1;
          		int drop5 = random.nextInt(100) + 1;
          		
          	    if (drop1 < 75)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_balloon, 1, 0.0F);
              	}
          	    
          	    if (drop2 < 55)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
              	
          	    	if (drop3 < 35)
                  	{
              	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
                  	}
              	}
          	    
          	    if (drop4 < 35)
              	{
          	    	this.dropItemWithOffset(Items.MINECART, 1, 0.0F);
              	}
          	    
          	    if (drop5 < 15)
              	{
          	    	this.dropItemWithOffset(InitItemsVC.airship_ignition, 1, 0.0F);
              	}
          	}
          	//this.setAirshipDead();
          	
          	this.isDead;
          }
          else if (this.status == EntityAirshipBase.Status.IN_AIR
          	  || this.status == EntityAirshipBase.Status.ON_LAND)
          {
          	this.momentum = 0.9F;
          }
          
          this.motionX *= (double)this.momentum;
          this.motionZ *= (double)this.momentum;
          this.deltaRotation *= this.momentum;
          
          if(this.getControllingPassenger() == null)
      	{
          	this.motionY += d5;
      	}
          else
          {
          	this.motionY *= (double)this.momentum;//+= d1;
          }
      }
      
      */
      
      
  
  
  
  
  
  //==================================//
  //             Controls             //
	//==================================//
  
  @SideOnly(Side.CLIENT)
  public void updateInputs()
  {
  	
  	this.leftInputDown = Keybinds.vcLeft.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown();//.isPressed();
      this.rightInputDown = Keybinds.vcRight.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown();
      this.forwardInputDown = Keybinds.vcForward.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown();//.isPressed();
      this.backInputDown = Keybinds.vcBack.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown();
      this.upInputDown = Keybinds.vcUp.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
      this.downInputDown = Keybinds.vcDown.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindPlayerList.isKeyDown();
         	
      this.openInputDown = Keybinds.vcInventory.isPressed();
      
  }
  
  
  
  
	//==================================//
  //               Misc               //
	//==================================//
  
  /**
   * Main entity item drop.
   */
	public Item getItemBoat()
  {
      return InitItemsVC.item_airship_base;
  }
	
	/**
   * Called when the entity is attacked.
   */
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
  {
      Entity entity = source.getEntity();
      
      if (this.isEntityInvulnerable(source))
      {
          return false;
      }
      else if (!this.isDead)
      {
      	
      }
      
      return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false : super.attackEntityFrom(source, amount);
  }
	
	/**
   * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
   */ 
  @SideOnly(Side.CLIENT)
  public void performHurtAnimation()
  {
  	//this.setForwardDirection(-this.getForwardDirection());
      //this.setTimeSinceHit(10);
  }
	
  public void updatePassenger(Entity passenger)
  {
      if (this.isPassenger(passenger))
      {
          float f = 0.0F;
          float f1 = (float)((this.isDead ? 0.009999999776482582D : this.getMountedYOffset()) + passenger.getYOffset());

          if (this.getPassengers().size() > 1)
          {
              int i = this.getPassengers().indexOf(passenger);

              if (i == 0)
              {
                  f = 0.2F;
              }
              else
              {
                  f = -0.6F;
              }

              if (passenger instanceof EntityAnimal)
              {
                  f = (float)((double)f + 0.2D);
              }
          }

          Vec3d vec3d = (new Vec3d((double)f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * 0.017453292F - ((float)Math.PI / 2F));
          passenger.setPosition(this.posX + vec3d.xCoord, this.posY + (double)f1, this.posZ + vec3d.zCoord);
          passenger.rotationYaw += this.deltaRotation;
          passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
          this.applyYawToEntity(passenger);

          if (passenger instanceof EntityAnimal && this.getPassengers().size() > 1)
          {
              int j = passenger.getEntityId() % 2 == 0 ? 90 : 270;
              passenger.setRenderYawOffset(((EntityAnimal)passenger).renderYawOffset + (float)j);
              passenger.setRotationYawHead(passenger.getRotationYawHead() + (float)j);
          }
      }
  }

  //**
  // * Applies this boat's yaw to the given entity. Used to update the orientation of its passenger.
  // 
  protected void applyYawToEntity(Entity entityToUpdate)
  {
      entityToUpdate.setRenderYawOffset(this.rotationYaw);
      float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
      float f1 = MathHelper.clamp_float(f, -105.0F, 105.0F);
      entityToUpdate.prevRotationYaw += f1 - f;
      entityToUpdate.rotationYaw += f1 - f;
      entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
  }

  //**
  // * Applies this entity's orientation (pitch/yaw) to another entity. Used to update passenger orientation.
  // 
  @SideOnly(Side.CLIENT)
  public void applyOrientationToEntity(Entity entityToUpdate)
  {
      this.applyYawToEntity(entityToUpdate);
  }
	
  /**
   * Called when the mob's health reaches 0.
   */
  public void onDeath(DamageSource cause)
  {
      super.onDeath(cause);

      if (!this.worldObj.isRemote)
      {
          //this.dropChestItems();
      }
  }
	
  /**
   * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
   * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
   */
  //@Nullable
  //public Entity getControllingPassenger()
  //{
  //    return this.getPassengers().isEmpty() ? null : (Entity)this.getPassengers().get(0);
  //}
	
  public boolean canBeSteered()
  {
      Entity entity = this.getControllingPassenger();
      return entity instanceof EntityLivingBase;
  }
  
  
  
  @Override
  public void setDead()
  {
  	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
      this.isDead = true;
      
      if (!this.worldObj.isRemote)
  	{
      	this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.0D, 0.0D, new int[0]);
      	
      	for (int ii = 0; ii < 10; ++ii)
      	{
      		int d = random.nextInt(100) + 1;
      		
      		if (d <= 2)
      		{
      			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
      					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					this.posY + 0.5D,
      					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					0.0D, 0.0D, 0.0D, new int[0]);
      		}
      		if (d <= 15)
      		{
      			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
      					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					this.posY + 0.5D,
      					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					0.0D, 0.25D, 0.0D, new int[0]);
      		}
      		if (d <= 25)
      		{
      			this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
      					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					this.posY + 0.5D,
      					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
      					0.0D, 0.0D, 0.0D, new int[0]);
      		}
      	}
  	}
  }
  
  
  
  
  protected boolean canTriggerWalking()
  {
      return false;
  }
	
	/**
   * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
   * pushable on contact, like boats or minecarts.
   */
  @Nullable
  public AxisAlignedBB getCollisionBox(Entity entityIn)
  {
      return entityIn.getEntityBoundingBox();
  }

  /**
   * Returns the collision bounding box for this entity
   */
  @Nullable
  public AxisAlignedBB getCollisionBoundingBox()
  {
      return this.getEntityBoundingBox();
  }

  /**
   * Returns true if this entity should push and be pushed by other entities when colliding.
   */
  public boolean canBePushed()
  {
      return true;
  }

  /**
   * Returns the Y offset from the entity's position for any entity riding this one.
   */
  public double getMountedYOffset()
  {
      return -0.1D;
  }
  
  /**
   * Applies a velocity to the entities, to push them away from eachother.
   */
  public void applyEntityCollision(Entity entityIn)
  {
      if (entityIn instanceof EntityAirshipBase)
      {
          if (entityIn.getEntityBoundingBox().minY < this.getEntityBoundingBox().maxY)
          {
              super.applyEntityCollision(entityIn);
          }
      }
      else if (entityIn.getEntityBoundingBox().minY <= this.getEntityBoundingBox().minY)
      {
          super.applyEntityCollision(entityIn);
      }
  }
  
  /**
   * Returns true if other Entities should be prevented from moving through this Entity.
   */
  public boolean canBeCollidedWith()
  {
      return !this.isDead;
  }
  
  /**
   * Gets the horizontal facing direction of this Entity, adjusted to take specially-treated entity types into
   * account.
   */
  public EnumFacing getAdjustedHorizontalFacing()
  {
      return this.getHorizontalFacing().rotateY();
  }
  
  /**
   * How many passengers the entity can seat.
   */
  protected boolean canFitPassenger(Entity passenger)
  {
      return this.getPassengers().size() < 2;
  }
  
  /**
   * Gets the driver.
   */
  @Nullable
  public Entity getControllingPassenger()
  {
      List<Entity> list = this.getPassengers();
      return list.isEmpty() ? null : (Entity)list.get(0);
  }
  
  /**
   * Action when someone does the /kill command.
   */
  @Override
  public void onKillCommand()
  {
      
  }
  
  
  
  
  
  
//==================================//
  //          Airship Status          //
	//==================================//
  
  
  
  /**
   * Determines whether the boat is in water, gliding on land, or in air
   */
  private EntityAirshipBase.Status getAirshipStatus()
  {
      EntityAirshipBase.Status EntityAirshipEA$status = this.getUnderwaterStatus();

      if (EntityAirshipEA$status != null)
      {
          this.waterLevel = this.getEntityBoundingBox().maxY;
          return EntityAirshipEA$status;
      }
      else if (this.checkInWater())
      {
          return EntityAirshipBase.Status.IN_WATER;
      }
      else
      {
          float f = this.getBoatGlide();

          if (f > 0.0F)
          {
              this.boatGlide = f;
              return EntityAirshipBase.Status.ON_LAND;
          }
          else
          {
              return EntityAirshipBase.Status.IN_AIR;
          }
      }
  }

  public float getWaterLevelAbove()
  {
      AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
      int i = MathHelper.floor_double(axisalignedbb.minX);
      int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
      int k = MathHelper.floor_double(axisalignedbb.maxY);
      int l = MathHelper.ceiling_double_int(axisalignedbb.maxY - this.lastYd);
      int i1 = MathHelper.floor_double(axisalignedbb.minZ);
      int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
      BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

      try
      {
          label78:

          for (int k1 = k; k1 < l; ++k1)
          {
              float f = 0.0F;
              int l1 = i;

              while (true)
              {
                  if (l1 >= j)
                  {
                      if (f < 1.0F)
                      {
                          float f2 = (float)blockpos$pooledmutableblockpos.getY() + f;
                          return f2;
                      }

                      break;
                  }

                  for (int i2 = i1; i2 < j1; ++i2)
                  {
                      blockpos$pooledmutableblockpos.setPos(l1, k1, i2);
                      IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                      if (iblockstate.getMaterial() == Material.WATER)
                      {
                          f = Math.max(f, getBlockLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos));
                      }

                      if (f >= 1.0F)
                      {
                          continue label78;
                      }
                  }

                  ++l1;
              }
          }

          float f1 = (float)(l + 1);
          return f1;
      }
      finally
      {
          blockpos$pooledmutableblockpos.release();
      }
  }

  /**
   * Decides how much the boat should be gliding on the land (based on any slippery blocks)
   */
  public float getBoatGlide()
  {
      AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
      AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
      int i = MathHelper.floor_double(axisalignedbb1.minX) - 1;
      int j = MathHelper.ceiling_double_int(axisalignedbb1.maxX) + 1;
      int k = MathHelper.floor_double(axisalignedbb1.minY) - 1;
      int l = MathHelper.ceiling_double_int(axisalignedbb1.maxY) + 1;
      int i1 = MathHelper.floor_double(axisalignedbb1.minZ) - 1;
      int j1 = MathHelper.ceiling_double_int(axisalignedbb1.maxZ) + 1;
      List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
      float f = 0.0F;
      int k1 = 0;
      BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

      try
      {
          for (int l1 = i; l1 < j; ++l1)
          {
              for (int i2 = i1; i2 < j1; ++i2)
              {
                  int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);

                  if (j2 != 2)
                  {
                      for (int k2 = k; k2 < l; ++k2)
                      {
                          if (j2 <= 0 || k2 != k && k2 != l - 1)
                          {
                              blockpos$pooledmutableblockpos.setPos(l1, k2, i2);
                              IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);
                              iblockstate.addCollisionBoxToList(this.worldObj, blockpos$pooledmutableblockpos, axisalignedbb1, list, this);

                              if (!list.isEmpty())
                              {
                                  f += iblockstate.getBlock().slipperiness;
                                  ++k1;
                              }

                              list.clear();
                          }
                      }
                  }
              }
          }
      }
      finally
      {
          blockpos$pooledmutableblockpos.release();
      }

      return f / (float)k1;
  }

  private boolean checkInWater()
  {
      AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
      int i = MathHelper.floor_double(axisalignedbb.minX);
      int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
      int k = MathHelper.floor_double(axisalignedbb.minY);
      int l = MathHelper.ceiling_double_int(axisalignedbb.minY + 0.001D);
      int i1 = MathHelper.floor_double(axisalignedbb.minZ);
      int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
      boolean flag = false;
      this.waterLevel = Double.MIN_VALUE;
      BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

      try
      {
          for (int k1 = i; k1 < j; ++k1)
          {
              for (int l1 = k; l1 < l; ++l1)
              {
                  for (int i2 = i1; i2 < j1; ++i2)
                  {
                      blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                      IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                      if (iblockstate.getMaterial() == Material.WATER)
                      {
                          float f = getLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos);
                          this.waterLevel = Math.max((double)f, this.waterLevel);
                          flag |= axisalignedbb.minY < (double)f;
                      }
                  }
              }
          }
      }
      finally
      {
          blockpos$pooledmutableblockpos.release();
      }

      return flag;
  }

  /**
   * Decides whether the boat is currently underwater.
   */
  @Nullable
  private EntityAirshipBase.Status getUnderwaterStatus()
  {
      AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
      double d0 = axisalignedbb.maxY + 0.001D;
      int i = MathHelper.floor_double(axisalignedbb.minX);
      int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
      int k = MathHelper.floor_double(axisalignedbb.maxY);
      int l = MathHelper.ceiling_double_int(d0);
      int i1 = MathHelper.floor_double(axisalignedbb.minZ);
      int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
      boolean flag = false;
      BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

      try
      {
          for (int k1 = i; k1 < j; ++k1)
          {
              for (int l1 = k; l1 < l; ++l1)
              {
                  for (int i2 = i1; i2 < j1; ++i2)
                  {
                      blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                      IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                      if (iblockstate.getMaterial() == Material.WATER && d0 < (double)getLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos))
                      {
                          if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                          {
                              EntityAirshipBase.Status EntityAirshipEA$status = EntityAirshipBase.Status.UNDER_FLOWING_WATER;
                              return EntityAirshipEA$status;
                          }

                          flag = true;
                      }
                  }
              }
          }
      }
      finally
      {
          blockpos$pooledmutableblockpos.release();
      }

      return flag ? EntityAirshipBase.Status.UNDER_WATER : null;
  }

  public static float getBlockLiquidHeight(IBlockState p_184456_0_, IBlockAccess p_184456_1_, BlockPos p_184456_2_)
  {
      int i = ((Integer)p_184456_0_.getValue(BlockLiquid.LEVEL)).intValue();
      return (i & 7) == 0 && p_184456_1_.getBlockState(p_184456_2_.up()).getMaterial() == Material.WATER ? 1.0F : 1.0F - BlockLiquid.getLiquidHeightPercent(i);
  }

  public static float getLiquidHeight(IBlockState p_184452_0_, IBlockAccess p_184452_1_, BlockPos p_184452_2_)
  {
      return (float)p_184452_2_.getY() + getBlockLiquidHeight(p_184452_0_, p_184452_1_, p_184452_2_);
  }

  
  
  public static enum Status
  {
      IN_WATER,
      UNDER_WATER,
      UNDER_FLOWING_WATER,
      ON_LAND,
      IN_AIR;
  } 
  
  
  
  
  
	
	
}
	
	
  
  
