import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.text.TextFormatting;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;


public class Ark {

	/**
	Explosion particles!
	else
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
	*/
	
	
	
//GuiEntityAirshipV1Core
	/**
	 * 
	 
	 
		//int i = (this.width - this.xSize) / 2;
        //int j = (this.height - this.ySize) / 2;
        //int x = airship.getFuelScaled(10);
            
        //int l = this.getCookProgressScaled(24);
      //Light bulbs that are lite up.
        //this.drawTexturedModalRect(
        //		this.guiLeft + 129, this.guiTop + 48,//i + 79, j + 34, 
        //		176, 14, 
        //		16 + 1, 16);
	 
    //private int getCookProgressScaled(int pixels)
    //{
    //    int i = this.airship.getField(2);
    //    int j = this.airship.getField(3);
    //    return j != 0 && i != 0 ? i * pixels / j : 0;
    //}


////this.fontRendererObj.drawString(s, 8, 6, 4210752);
		// This sets the Airship name in the top center.
		//this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		
		
		
		
		/**
		if (EntityAirshipCore.isBurning(this.airship))
        {
			int x = airship.getFuelScaled(10);
            //int k = this.getBurnLeftScaled(13);
            //LogHelper.info("Test!");
            this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 
            		176,  50,//12 - k, 
            		8, 48 - x);
        }
		int l = this.getCookProgressScaled(24);
		//Light bulbs that are lite up.
        this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 
        176, 14, 
        l + 1, 16);
	}
	
	private int getCookProgressScaled(int pixels)
    {
        int i = this.airship.getField(2);
        //int j = this.airship.getField(3);
        return i != 0 && i != 0 ? i * pixels / i : 0;
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(2);

        if (i == 0)
        {
            i = 200;
        }
        
        return this.airship.getField(0) * pixels / i;
    }
    
    
    
    
    
    
    
}

	 
	 * 
	 */
	
	
//EntityAirshipCore.java

	/**
	 * 
	 * 
	//private int airshipClientBurnTime;
	
	//public static final int fuel_slots = 1;
	//public static final int total_slots = fuel_slots; //+ other variables
	//public static final int first_fuel_slot = 9;
	
	//private int [] burnTimeRemaining = new int[fuel_slots];
	//private int [] burnTimeInitialValue = new int[fuel_slots];
	
	//private int cookTime;
	//private static final short cook_time_for_completion = 200; // 10 Seconds IRL
	//private int cachedNumberOfBurningSlots = -1;
	
	//private static ItemStack[] inventoryFuel = new ItemStack[1];
	//private static ItemStack[] furnaceItemStacks = new ItemStack[3];
	//public ItemStack[] inventory;
	//public ItemStack[] furnaceItemStacks = new ItemStack[3];
	
	//private int nowBurnTime;
	//private int lastBurnTime;
	//private boolean canAirshipFly;
	
	
	/////////OnUpdate
        //else
        //{
        //	canAirshipFly = false;
        //}
        
        //this.getAirshipBurning();
		
        //if (this.worldObj.isRemote)
        //{
        //	LogHelper.info("Is Burning = " + isAirshipBurning());
        //	LogHelper.info("Can fly = " + canAirshipFly);
        //}
         * 
         * //NetworkHandler.sendToServer(new MessageAirshipBurning());
        	//LogHelper.info("Is Burning = " + isAirshipBurning());
        	//LogHelper.info("Can fly = " + canAirshipFly);
        	
        	//if(isAirshipBurning())
        	//{
        	//	if (this.worldObj.isRemote)
            //    {
            //    	this.controlAirshipBurning();
            //    } 
        	//}
        	
        	//if(!isAirshipBurning())
        	//{
        	//	if (this.worldObj.isRemote)
            //    {
            //    	this.controlAirship();
            //    } 
        	//}
            
            
            
        //this.setMinecartPowered(this.fuel > 0);

        //if (this.isMinecartPowered() && this.rand.nextInt(4) == 0)
        //{
        //    this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.8D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        //}
        //if(!this.worldObj.isRemote)
        //{
        //	LogHelper.info(inventory[9]);
        //}
	
        	//int test = getItemBurnTime(inventory[9]);
        	
        	//LogHelper.info("Testing = " + test);
        	
	//LogHelper.info(isBurning());
	 * 
	 * 
	 * 
	 * //this.deltaRotation -= AirshipSpeedTurn;
                //this.alphaRotation -= AirshipSpeedTurn;
                
                //-0.2F;//  -0.4    += -1.0F;
	 * 
	 * 
	
    public void controlAirshipBurning()
    {
        if (this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            if (this.leftInputDown)
            {
                this.deltaRotation -= AirshipSpeedTurn;
                this.alphaRotation -= AirshipSpeedTurn;
                
                //-0.2F;//  -0.4    += -1.0F;
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
            	
            		f += AirshipSpeedForward; //0.0125F;//+= 0.04F;
            	
            }

            if (this.backInputDown)
            {
            	
            		f -= AirshipSpeedForward * 0.5; //0.0125F;//+= 0.04F;
            	
            }
            
            if (this.upInputDown)
            {
            	
            		f1 += AirshipSpeedUp;//0.005F;
            	
            }
            
            if (this.downInputDown)
            {
                f1 -= AirshipSpeedDown;//0.005F;
            }
            
            

            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            this.motionY += (double)(3.017453292F * f1);
            
            this.rotationPitch += 10;
        }
    }
    
	
	
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length
				//9
				;
	}
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
		////return (EntityAirshipCore)player.getRidingEntity() == this;
		//this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	
	
	
	//private static final byte cook_field_id = 0;
	//private static final byte first_burn_time_remaining_id = 1;
	//private static final byte first_burn_time_initial_field_id = first_burn_time_remaining_id;
	//private static final byte number_of_fields = first_burn_time_initial_field_id + (byte)fuel;
	
	//@Override
	//public int getField(int id) 
	//{
		//return 0;
		
	//}
	
	//@Override
	//public void setField(int id, int value){}
	
	//@Override
	//public int getFieldCount() 
	//{
	//	return 0;
	//}
	
	/////////////writeEntityToNBT
	 
    	//compound.setString("Type", this.getBoatType().getName());
        
		//if (this.hasCustomName()) 
		//{
			//compound.setString("CustomName", this.getCustomName());
		//}
	/////////////readEntityFromNBT
	
    	
        //if (compound.hasKey("Type", 8))
        //{
        //    this.setBoatType(EntityAirshipCore.Type.getTypeFromString(compound.getString("Type")));
        //}
        
		//if (compound.hasKey("CustomName", 8)) 
		//{
			//this.setCustomName(compound.getString("CustomName"));
		//}
	
    public Packet getDescriptionPacket() {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		writeToNBT(nbtTagCompound);
		//final int metadata = 0;
		return new SPacketEntity();
	}
	
	public void onDataPacket(NetworkManager net, SPacketEntity pkt) {
		NBTTagCompound nbtTagCompound = new NBTTagCompound();
		readEntityFromNBT(nbtTagCompound);
	}
	
	//@Override
	public static boolean isItemValidForFuelSlot(//int index, 
			ItemStack stack) 
	{
		//return true;
		
		if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
        
		
        	//ItemStack itemstack = furnaceItemStacks[1];
            
        	//ItemStack itemstack = inventory[10];
            return isItemFuel(stack);
            		//|| SlotFurnaceFuel.isBucket(stack) 
            		//&& (itemstack == null || itemstack.getItem() != Items.BUCKET);
        //}
		
		//return Items.COAL;
		 
		 
	}
	
	/**
    	//if(!canAirshipFly) 
        //{
        	int numberOfFuelBurning = burnFuel();
			
			if(numberOfFuelBurning > 0) 
			{
				//canAirshipFly = true;
				cookTime += numberOfFuelBurning;
			} 
			else 
			{
				//canAirshipFly = false;
				//cookTime -= 2;
				cookTime = 0;
			}
			
			if(cookTime < 0) 
			{
				cookTime = 0;
			}
			
			////if(cookTime >= cook_time_for_completion) 
			////{
				//smeltItem();
			////	cookTime = 1;
			////}
			//while(cookTime > 0)
			//{
			//	canAirshipFly = true;
			//}
		//} 
        //else 
        //{
		//	cookTime = 0;
		//}
    	

		////int numberBurning = numberOfBurningFuelSlots();
		////if(cachedNumberOfBurningSlots != numberBurning) 
		////{
		////	cachedNumberOfBurningSlots = numberBurning;
		////}
		 * 
		 * 
		
        
    /**
	private int burnFuel()
	{
		int burningCount = 0;
		boolean inventoryChanged = false;
		
		for(int i = 0; i < fuel_slots; i++)
		{
			int fuelSlotNumber = 9;//i + first_fuel_slot;
			if(burnTimeRemaining[i] > 0)
			{
				--burnTimeRemaining[i];
				++burningCount;
			}
			if(burnTimeRemaining[i] == 0)
			{
				if(inventory[fuelSlotNumber] != null && getItemBurnTime(inventory[fuelSlotNumber]) > 0)
				{
					burnTimeRemaining[i] = burnTimeInitialValue[i] = getItemBurnTime(inventory[fuelSlotNumber]);
					--inventory[fuelSlotNumber].stackSize;
					++burningCount;
					inventoryChanged = true;
					
					if(inventory[fuelSlotNumber].stackSize == 0)
					{
						inventory[fuelSlotNumber] = inventory[fuelSlotNumber].getItem().getContainerItem(inventory[fuelSlotNumber]);
						
					}
					
				}
				
			}
			
		}
		
		if(inventoryChanged)
		{
			markDirty();
		}
		return burningCount;
		
	}
	
	*/
    
    
	/**
	private boolean canSmelt()
	{
		return smeltItem(false);
	}
	
	private void smeltItem()
	{
		smeltItem(true);
	}
	
	private boolean smeltItem(boolean performSmelt) {
		Integer firstSuitableInputSlot = null;
		Integer firstSuitableOutputSlot = null;
		ItemStack result = null;
		
		for(int inputSlot = 0
				//first_input_slot
				; inputSlot < 10
				//first_input_slot + input_slots
				; inputSlot++) {
			if(inventory[inputSlot] != null) {
				result = getSmeltingResultForItem(inventory[inputSlot]);
				if(result != null) {
					for(int outputSlot = 1
							
							//first_output_slot
							; outputSlot < 4
							//first_output_slot + output_slots
							; outputSlot++) {
						ItemStack outputStack = inventory[outputSlot];
						if(outputStack == null) {
							firstSuitableInputSlot = inputSlot;
							firstSuitableOutputSlot = outputSlot;
							break;
						}
						if(outputStack.getItem() == result.getItem() && (!outputStack.getHasSubtypes() || outputStack.getMetadata() == outputStack.getMetadata()) && ItemStack.areItemStackTagsEqual(outputStack, result)) {
							int combinedSize = inventory[outputSlot].stackSize + result.stackSize;
							if(combinedSize <= getInventoryStackLimit() && combinedSize <= inventory[outputSlot].getMaxStackSize()) {
								firstSuitableInputSlot = inputSlot;
								firstSuitableOutputSlot = outputSlot;
								break;
							}
						}
					}
					if(firstSuitableInputSlot != null) {
						break;
					}
				}
			}
		}
		if(firstSuitableInputSlot == null) {
			return false;
		}
		if(!performSmelt) {
			return true;
		}
		inventory[firstSuitableInputSlot].stackSize--;
		if(inventory[firstSuitableInputSlot].stackSize <= 0) {
			inventory[firstSuitableInputSlot] = null;
		}
		if(inventory[firstSuitableOutputSlot] == null) {
			inventory[firstSuitableOutputSlot] = result.copy();
		} else {
			inventory[firstSuitableOutputSlot].stackSize += result.stackSize;
		}
		markDirty();
		return true;
	}
		
	public static ItemStack getSmeltingResultForItem(ItemStack stack)
	{
		return FurnaceRecipes.instance().getSmeltingResult(stack);
	}
	*/
	//public static short getItemBurnTime(ItemStack stack)
	//{
	//	int burntime = EntityAirshipCore.getItemBurnTime(stack);
	//	return (short)MathHelper.clamp_int(burntime, 0, Short.MAX_VALUE);
	//}
	
	/**
	public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return 0;//this.furnaceBurnTime;
            case 1:
                return 0;//this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return 0;//this.burnTimeRemaining;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                //this.furnaceBurnTime = value;
                break;
            case 1:
                //this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                //this.totalCookTime = value;
        }
    }

    public int getFieldCount()
    {
        return 4;
    }
	*/	
	
	
    //@SideOnly(Side.CLIENT)
    //public static boolean isAirshipBurning(IInventory inventory)
    //{
        
    //	return inventory.getField(2) > 0;
    //}
	
	/**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    //public static int getItemBurnTime(ItemStack stack)
    //{
    //    if (stack == null)
    //    {
    //        return 0;
    //    }
    //    else
    //    {
    //        Item item = stack.getItem();

    //        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
    //        {
    //            Block block = Block.getBlockFromItem(item);

                //if (block == Blocks.WOODEN_SLAB)
                //{
                //    return 150;
                //}

                //if (block.getDefaultState().getMaterial() == Material.WOOD)
                //{
                //    return 300;
                //}

                //if (block == Blocks.COAL_BLOCK)
                //{
                //    return 16000;
                //}
      //      }

            //if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            //if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            //if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            //if (item == Items.STICK) return 100;
    //        if (item == Items.COAL) return 1800;
            //if (item == Items.LAVA_BUCKET) return 20000;
            //if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            //if (item == Items.BLAZE_ROD) return 2400;
    //        return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
    //    }
    //}
	
	
    //@Override
	//public static boolean isItemFuel(ItemStack stack)
    //{
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
    //    return getItemBurnTime(stack) > 0;
    //}
    
    
	//public static boolean getItemMaxBurnTime(ItemStack stack)
    //{
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
    //    return getItemBurnTime(stack) > 0;
    //}
    
	/**
	@SideOnly(Side.CLIENT)
    public int getFuelScaled(int i) {
    	
    	//ItemStack stack = new ItemStack(Items.COAL);
    	////////ItemStack item = getStackInSlot(9);
    	//ItemStack stackq = inventory[9];
    	
    	////////int maxFuel = 1;
    	
    	//int test = getItemBurnTime(item);
    	//Item item = stack.getItem();
    	//int[] item = burnTimeRemaining;
    	//burnTimeRemaining;
    	//int maxFuel = 10;
    	//int maxFuel = burnTimeRemaining;
    	
    	/////////if (item == new ItemStack(Items.COAL)
    	///////////&& item != null)
    	////////////{
    	////////////	maxFuel = 1800; //1600;
    		
    	////////////}
    	/**
        if (item == new ItemStack(Items.LAVA_BUCKET)
        && item != null)
        {
        	maxFuel = 20000;
        }
        if (item == new ItemStack(Item.getItemFromBlock(Blocks.SAPLING))
        && item != null)
        {
        	maxFuel = 100;
        }
        if (item == new ItemStack(Items.BLAZE_ROD)
        && item != null)
        {
        	maxFuel = 2400;
        }
    	*/
	/**	if (this.totalFuelTime == 0)
        {
			this.totalFuelTime = this.getFuelTime(this.inventory[9]);
        }
		
    		return (airshipBurnTime * i) / totalFuelTime;
    	
    	//return (cookTime * i) / 360;
		
		//return i;//(cookTime * i) / maxFuel;//(maxFuel / 5);//320;
	}
	*/
	
	//public int getFuelTime(@Nullable ItemStack stack)
    //{
    //    return 200;
    //}
	/**
    public boolean getAirshipBurning()
    {
    	boolean flag1 = false;
    	
    	if (!isAirshipBurning())
        {
        	if(this.airshipBurnTime > 0)
        	{
        		flag1 = true;
        	}
        	else
        	{
        		flag1 = false;
        	}
        	
        }
    	return flag1;
    }
    */
	/**
    public int getClientItemBurnTime()
    {
    	//int nowBurnTime = 0;
    	//int lastBurnTime;
    	
    	
    	if (nowBurnTime > 0)
        {
    		nowBurnTime = this.getItemBurnTime(this.inventory[9]);
        }
    	
    	if (nowBurnTime == 0)
        {
    		nowBurnTime = this.getItemBurnTime(this.inventory[9]);
        }
    	lastBurnTime = nowBurnTime;
    	
		return nowBurnTime;
    }
    
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inventory, index);
	
	//ItemStack stack = this.getStackInSlot(index);
		//this.setInventorySlotContents(index, null);
		//return stack;
	}
	
    
    /**
     * Returns the amount of fuel remaining from the burning item
     * @param fuelSlot
     * @return
     
    public double fractionOfFuelRemaining(int fuelSlot)
	{
		if(burnTimeInitialValue[fuelSlot] <= 0)
		{
			return 0;
		}
		double fraction = burnTimeRemaining[fuelSlot] / (double)burnTimeInitialValue[fuelSlot];
		return MathHelper.clamp_double(fraction, 0.0, 1.0);
	}
    */
    /**
     * Converts ticks to seconds.
     * @param fuelSlot
     * @return
     
    public int secondsOfFuelRemaining(int fuelSlot)
    {
    	if(burnTimeRemaining[fuelSlot] <=0 )
    	{
    		return 0;
    	}
    	return burnTimeRemaining[fuelSlot] / 20;
    }
    */
    /**
     * Number of fuel slots that have fuel burning in them.
     * @return
     
    public int numberOfBurningFuelSlots()
    {
    	int burningCount = 0;
    	for(int burnTime : burnTimeRemaining)
    	{
    		if(burnTime > 0)
    		{
    			++burningCount;
    		}
    	}
    	return burningCount;
    }
    */
    /**
     * Time of completion.
     * @return
     
    public double fractionOfCookTimeComplete()
    {
    	double fraction = cookTime / (double)cook_time_for_completion;
    	return MathHelper.clamp_double(fraction, 0.0, 1.0);
    }
    
    
    
    
    
    
    
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
        this.inventory[index] = stack;
        
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        
        if (index == 0 && !flag)
        {
            this.totalFuelTime = this.getFuelTime(stack);
            this.fuelTime = 0;
            this.markDirty();
        }
		
		if (index < 0 || index >= this.getSizeInventory())
		{
			return;
		}

		if (stack != null && stack.stackSize > this.getInventoryStackLimit())
		{
			stack.stackSize = this.getInventoryStackLimit();
		}

		if (stack != null && stack.stackSize == 0)
		{
			stack = null;
		}

		this.inventory[index] = stack;
		this.markDirty();
		
		
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
		
		if (this.getStackInSlot(index) != null) 
		{
			ItemStack itemstack;

			if (this.getStackInSlot(index).stackSize <= count) 
			{
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, null);
				this.markDirty();
				return itemstack;
			} 
			else 
			{
				itemstack = this.getStackInSlot(index).splitStack(count);

				if (this.getStackInSlot(index).stackSize <= 0) 
				{
					this.setInventorySlotContents(index, null);
				} 
				else 
				{
					//Just to show that changes happened
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}

				this.markDirty();
				return itemstack;
			}
		} 
		else 
		{
			return null;
		}
		
	}
	
    public void fuelFlight()
    {
    	//if(!canAirshipFly) 
        //{
        	int numberOfFuelBurning = burnFuel();
			
			if(numberOfFuelBurning > 0) 
			{
				//canAirshipFly = true;
				cookTime += numberOfFuelBurning;
			} 
			else 
			{
				//canAirshipFly = false;
				//cookTime -= 2;
				cookTime = 0;
			}
			
			if(cookTime < 0) 
			{
				cookTime = 0;
			}
			
			////if(cookTime >= cook_time_for_completion) 
			////{
				//smeltItem();
			////	cookTime = 1;
			////}
			//while(cookTime > 0)
			//{
			//	canAirshipFly = true;
			//}
		//} 
        //else 
        //{
		//	cookTime = 0;
		//}
    	

		int numberBurning = numberOfBurningFuelSlots();
		if(cachedNumberOfBurningSlots != numberBurning) {
			cachedNumberOfBurningSlots = numberBurning;
			
		}
        
    }
    
	
	
	*/
	
//KeyBinds.java

	/**
	 * 
	 * 
	// Define the "ping" binding, with (unlocalized) name "key.ping" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
	       
		//ping = new KeyBinding("key.vc.inventory", Keyboard.KEY_O, "key.categories.viescraft");
	       
		// Define the "pong" binding, with (unlocalized) name "key.pong" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)
	    
	// Register both KeyBindings to the ClientRegistry
	       //ClientRegistry.registerKeyBinding(ping);
	       //ClientRegistry.registerKeyBinding(pong);
		
		
		
	public static void init1()
	{
		// declare an array of key bindings
		keyBindings = new KeyBinding[2]; 
		
		// instantiate the key bindings
		keyBindings[0] = new KeyBinding("key.structure.desc", Keyboard.KEY_P, "key.magicbeans.category");
		keyBindings[1] = new KeyBinding("key.hud.desc", Keyboard.KEY_H, "key.magicbeans.category");
		
		// register all the key bindings
		for (int i = 0; i < keyBindings.length; ++i) 
		{
			ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event)
	{
	    // DEBUG
	    System.out.println("Key Input Event");

	    // make local copy of key binding array
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
	   
	    // check each enumerated key binding type for pressed and take appropriate action
	    if (keyBindings[0].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[0].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[1].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[1].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	}

	*/
	

	//MessageGuiOpenBlack.java
		/**
		 * 
		 * 
		
		
		
	//@Override
	//public boolean canInteractWith(EntityPlayer playerIn) {
	//	return this.airship.isUseableByPlayer(playerIn);
	//}

	/**
     * Take a stack from the specified inventory slot.
     
    @Nullable
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index != 9)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            //else if (index != 1 && index != 0)
            //{
            //    if (FurnaceRecipes.instance().getSmeltingResult(itemstack1) != null)
            //    {
            //        if (!this.mergeItemStack(itemstack1, 0, 1, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (TileEntityFurnace.isItemFuel(itemstack1))
            //    {
            //        if (!this.mergeItemStack(itemstack1, 1, 2, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (index >= 3 && index < 30)
            //    {
            //        if (!this.mergeItemStack(itemstack1, 30, 39, false))
            //        {
            //            return null;
            //        }
            //    }
            //    else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
            //    {
            //        return null;
            //    }
            //}
            //else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            //{
            //    return null;
            //}

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemstack1);
        }

        return itemstack;
    }
	*/
	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = null;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();

			if (fromSlot < 9) {
				// From TE Inventory to Player Inventory
				if (!this.mergeItemStack(current, 9, 45, true))
					return null;
			} else {
				// From Player Inventory to TE Inventory
				if (!this.mergeItemStack(current, 0, 9, false))
					return null;
			}

			if (current.stackSize == 0)
				slot.putStack((ItemStack) null);
			else
				slot.onSlotChanged();

			if (current.stackSize == previous.stackSize)
				return null;
			slot.onPickupFromSlot(playerIn, current);
		}

		return previous;
	}
	
	
	
	// SlotFuel is a slot for fuel items
		//public class SlotFuel extends Slot {
	//		public SlotFuel(IInventory inventoryIn, int index, int xPosition,
	//				int yPosition) {
	//			super(inventoryIn, index, xPosition, yPosition);
	//		}

			// if this function returns false, the player won't be able to insert
			// the given item into this slot
	//		@Override
	//		public boolean isItemValid(ItemStack stack) {
	//			return EntityAirshipCore.isItemValidForFuelSlot(stack);
	//		}
	//	}
}
		/**
		public void addListener(IContainerListener listener)
	    {
	        super.addListener(listener);
	        listener.sendAllWindowProperties(this, this.airship);
	    }

	    /**
	     * Looks for changes made in the container, sends them to every listener.
	     */
		/**  public void detectAndSendChanges()
	    {
	        super.detectAndSendChanges();

	        for (int i = 0; i < this.listeners.size(); ++i)
	        {
	            IContainerListener icontainerlistener = (IContainerListener)this.listeners.get(i);

	            if (this.cookTime != this.airship.getField(2))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 2, this.airship.getField(2));
	            }

	            if (this.furnaceBurnTime != this.airship.getField(0))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 0, this.airship.getField(0));
	            }

	            if (this.currentItemBurnTime != this.airship.getField(1))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 1, this.airship.getField(1));
	            }

	            if (this.totalCookTime != this.airship.getField(3))
	            {
	                icontainerlistener.sendProgressBarUpdate(this, 3, this.airship.getField(3));
	            }
	        }

	        this.cookTime = this.airship.getField(2);
	        this.furnaceBurnTime = this.airship.getField(0);
	        this.currentItemBurnTime = this.airship.getField(1);
	        this.totalCookTime = this.airship.getField(3);
	    }

	    //@SideOnly(Side.CLIENT)
	    //public void updateProgressBar(int id, int data)
	    //{
	    //    this.airship.setField(id, data);
	    //}
			
		}
		*/
//MessageGuiOpenBlack.java
	/**
	 * 
	 * 
	//if(player.openContainer instanceof ContainerAirshipBlack) {
	//Unused
	//	LogHelper.info("Gui is NOT airship!");
	//	player.closeScreen();
		
		
	//}else {
		player.openGui(ViesCraft.instance, GuiHandler.GUI_AIRSHIP_BLACK, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		
	//	LogHelper.info("Gui IS airship!");
		
	//}
	//LogHelper.info("Gui opened successfully!");
	//LogHelper.info(" ");
	
	*/
	
	
//InitEntityVC.java
	/**
	 * 
	 * 
	//register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
	//register(EntityAirshipVC.class, "AirshipEbonheart", 64, 1, true);
	
	//register(EntityItemAirship.class, "item.airship", 64, 20, true);
	//register(EntityAirshipVCtest.class, "AirshipEbonheartNEW", 64, 1, true);
	
	//register(EntityItemAirshipFurnace.class, "vc.ItemAirshipFurnace", 64, 20, true);
	
	
	////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.BLACK.getName(), 64, 1, true);
	////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.RED.getName(), 64, 1, true);
	
	
	
	//register(EntityAirshipBase.class, "AirshipEbonheart", 64, 1, true);
	//register(EntityAirshipBase2.class, "AirshipV2", 64, 1, true);
	
	//register(EntityAirshipFurnace.class, "AirshipVCFurnace", 64, 1, true);
	
	
	*/
	
//InitBlocksVC.java
	/**
	 * 
	 *
draconium_ore = registerBlock(new BlockOreDraconium(2, 0.4f, 10f));
		velious_ore = registerBlock(new BlockOreVelious(2, 15f));
		arcanite_ore = registerBlock(new BlockOreArcanite(2, 20f));
		katcheen_ore = registerBlock(new BlockOreKatcheen(3, 30f));
		necrocite_ore = registerBlock(new BlockOreNecrocite(3, 30f));
		soularite_ore = registerBlock(new BlockOreSoularite(3, 30f));
		ebonheart_ore = registerBlock(new BlockOreEbonheart(3, 30f));
		ebon_ore = registerBlock(new BlockMultiOre("ore/ebon_ore"));
		ebon_ore_nether = registerBlock(new BlockMultiOre("ore/ebon_ore_nether"));
		
		draconium_block = registerBlock(new BlockEA("gem/draconium/draconium_block").setResistance(4.0F));
		velious_block = registerBlock(new BlockEA("gem/velious/velious_block").setResistance(15.0F));
		arcanite_block = registerBlock(new BlockEA("gem/arcanite/arcanite_block").setResistance(30.0F));
		katcheen_block = registerBlock(new BlockEA("gem/katcheen/katcheen_block").setResistance(100.0F));
		necrocite_block = registerBlock(new BlockEA("gem/necrocite/necrocite_block").setResistance(45.0F));
		soularite_block = registerBlock(new BlockEA("gem/soularite/soularite_block").setResistance(45.0F));
		ebonheart_block = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block").setResistance(2000.0F));
		obsidian_block = registerBlock(new BlockEA("gem/obsidian/obsidian_block").setResistance(2000.0F));
		glowstone_block = registerBlock(new BlockEA("gem/glowstone/glowstone_block").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_brick = registerBlock(new BlockEA("gem/draconium/draconium_block_brick").setResistance(4.0F));
		velious_block_brick = registerBlock(new BlockEA("gem/velious/velious_block_brick").setResistance(15.0F));
		arcanite_block_brick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_brick").setResistance(30.0F));
		katcheen_block_brick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_brick").setResistance(100.0F));
		necrocite_block_brick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_brick").setResistance(45.0F));
		soularite_block_brick = registerBlock(new BlockEA("gem/soularite/soularite_block_brick").setResistance(45.0F));
		ebonheart_block_brick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_brick").setResistance(2000.0F));
		obsidian_block_brick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_brick").setResistance(2000.0F));
		glowstone_block_brick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f));
		
		double_draconium_slab = new BlockDoubleSlab("slab/draconium/double_draconium_slab").setResistance(4.0F);
		double_velious_slab = new BlockDoubleSlab("slab/velious/double_velious_slab").setResistance(15.0F);
		double_arcanite_slab = new BlockDoubleSlab("slab/arcanite/double_arcanite_slab").setResistance(30.0F);
		double_katcheen_slab = new BlockDoubleSlab("slab/katcheen/double_katcheen_slab").setResistance(100.0F);
		double_necrocite_slab = new BlockDoubleSlab("slab/necrocite/double_necrocite_slab").setResistance(45.0F);
		double_soularite_slab = new BlockDoubleSlab("slab/soularite/double_soularite_slab").setResistance(45.0F);
		double_ebonheart_slab = new BlockDoubleSlab("slab/ebonheart/double_ebonheart_slab").setResistance(2000.0F);
		double_obsidian_slab = new BlockDoubleSlab("slab/obsidian/double_obsidian_slab").setResistance(2000.0F);
		double_glowstone_slab = new BlockDoubleSlab("slab/glowstone/double_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		draconium_slab = new BlockHalfSlab("slab/draconium/draconium_slab").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		velious_slab = new BlockHalfSlab("slab/velious/velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		arcanite_slab = new BlockHalfSlab("slab/arcanite/arcanite_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		katcheen_slab = new BlockHalfSlab("slab/katcheen/katcheen_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		necrocite_slab = new BlockHalfSlab("slab/necrocite/necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		soularite_slab = new BlockHalfSlab("slab/soularite/soularite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		ebonheart_slab = new BlockHalfSlab("slab/ebonheart/ebonheart_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		obsidian_slab = new BlockHalfSlab("slab/obsidian/obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		glowstone_slab = new BlockHalfSlab("slab/glowstone/glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		
		
		
		GameRegistry.registerBlock(double_draconium_slab, ItemBlockSlab.class, "slab/draconium/double_draconium_slab", draconium_slab, double_draconium_slab, true);
		GameRegistry.registerBlock(double_velious_slab, ItemBlockSlab.class, "slab/velious/double_velious_slab", velious_slab, double_velious_slab, true);
		GameRegistry.registerBlock(double_arcanite_slab, ItemBlockSlab.class, "slab/arcanite/double_arcanite_slab", arcanite_slab, double_arcanite_slab, true);
		GameRegistry.registerBlock(double_katcheen_slab, ItemBlockSlab.class, "slab/katcheen/double_katcheen_slab", katcheen_slab, double_katcheen_slab, true);
		GameRegistry.registerBlock(double_necrocite_slab, ItemBlockSlab.class, "slab/necrocite/double_necrocite_slab", necrocite_slab, double_necrocite_slab, true);
		GameRegistry.registerBlock(double_soularite_slab, ItemBlockSlab.class, "slab/soularite/double_soularite_slab", soularite_slab, double_soularite_slab, true);
		GameRegistry.registerBlock(double_ebonheart_slab, ItemBlockSlab.class, "slab/ebonheart/double_ebonheart_slab", ebonheart_slab, double_ebonheart_slab, true);
		GameRegistry.registerBlock(double_obsidian_slab, ItemBlockSlab.class, "slab/obsidian/double_obsidian_slab", obsidian_slab, double_obsidian_slab, true);
		GameRegistry.registerBlock(double_glowstone_slab, ItemBlockSlab.class, "slab/glowstone/double_glowstone_slab", glowstone_slab, double_glowstone_slab, true);
		
		GameRegistry.registerBlock(draconium_slab, ItemBlockSlab.class, "slab/draconium/draconium_slab", draconium_slab, double_draconium_slab, false);
		GameRegistry.registerBlock(velious_slab, ItemBlockSlab.class, "slab/velious/velious_slab", velious_slab, double_velious_slab, false);
		GameRegistry.registerBlock(arcanite_slab, ItemBlockSlab.class, "slab/arcanite/arcanite_slab", arcanite_slab, double_arcanite_slab, false);
		GameRegistry.registerBlock(katcheen_slab, ItemBlockSlab.class, "slab/katcheen/katcheen_slab", katcheen_slab, double_katcheen_slab, false);
		GameRegistry.registerBlock(necrocite_slab, ItemBlockSlab.class, "slab/necrocite/necrocite_slab", necrocite_slab, double_necrocite_slab, false);
		GameRegistry.registerBlock(soularite_slab, ItemBlockSlab.class, "slab/soularite/soularite_slab", soularite_slab, double_soularite_slab, false);
		GameRegistry.registerBlock(ebonheart_slab, ItemBlockSlab.class, "slab/ebonheart/ebonheart_slab", ebonheart_slab, double_ebonheart_slab, false);
		GameRegistry.registerBlock(obsidian_slab, ItemBlockSlab.class, "slab/obsidian/obsidian_slab", obsidian_slab, double_obsidian_slab, false);
		GameRegistry.registerBlock(glowstone_slab, ItemBlockSlab.class, "slab/glowstone/glowstone_slab", glowstone_slab, double_glowstone_slab, false);
		
		
		
		draconium_stairs = registerBlock(new EABlockStairs("stairs/draconium_stairs", draconium_block).setResistance(4.0F));
		velious_stairs = registerBlock(new EABlockStairs("stairs/velious_stairs", velious_block).setResistance(15.0F));
		arcanite_stairs = registerBlock(new EABlockStairs("stairs/arcanite_stairs", arcanite_block).setResistance(30.0F));
		katcheen_stairs = registerBlock(new EABlockStairs("stairs/katcheen_stairs", katcheen_block).setResistance(100.0F));
		necrocite_stairs = registerBlock(new EABlockStairs("stairs/necrocite_stairs", necrocite_block).setResistance(45.0F));
		soularite_stairs = registerBlock(new EABlockStairs("stairs/soularite_stairs", soularite_block).setResistance(45.0F));
		ebonheart_stairs = registerBlock(new EABlockStairs("stairs/ebonheart_stairs", ebonheart_block).setResistance(2000.0F));
		obsidian_stairs = registerBlock(new EABlockStairs("stairs/obsidian_stairs", obsidian_block).setResistance(2000.0F));
		glowstone_stairs = registerBlock(new EABlockStairs("stairs/glowstone_stairs", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence = registerBlock(new EABlockFence("fence/draconium_fence").setResistance(4.0F));
		velious_fence = registerBlock(new EABlockFence("fence/velious_fence").setResistance(15.0F));
		arcanite_fence = registerBlock(new EABlockFence("fence/arcanite_fence").setResistance(30.0F));
		katcheen_fence = registerBlock(new EABlockFence("fence/katcheen_fence").setResistance(100.0F));
		necrocite_fence = registerBlock(new EABlockFence("fence/necrocite_fence").setResistance(45.0F));
		soularite_fence = registerBlock(new EABlockFence("fence/soularite_fence").setResistance(45.0F));
		ebonheart_fence = registerBlock(new EABlockFence("fence/ebonheart_fence").setResistance(2000.0F));
		obsidian_fence = registerBlock(new EABlockFence("fence/obsidian_fence").setResistance(2000.0F));
		glowstone_fence = registerBlock(new EABlockFence("fence/glowstone_fence").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence_gate = registerBlock(new EABlockFenceGate("fence/draconium_fence_gate").setResistance(4.0F));
		velious_fence_gate = registerBlock(new EABlockFenceGate("fence/velious_fence_gate").setResistance(15.0F));
		arcanite_fence_gate = registerBlock(new EABlockFenceGate("fence/arcanite_fence_gate").setResistance(30.0F));
		katcheen_fence_gate = registerBlock(new EABlockFenceGate("fence/katcheen_fence_gate").setResistance(100.0F));
		necrocite_fence_gate = registerBlock(new EABlockFenceGate("fence/necrocite_fence_gate").setResistance(45.0F));
		soularite_fence_gate = registerBlock(new EABlockFenceGate("fence/soularite_fence_gate").setResistance(45.0F));
		ebonheart_fence_gate = registerBlock(new EABlockFenceGate("fence/ebonheart_fence_gate").setResistance(2000.0F));
		obsidian_fence_gate = registerBlock(new EABlockFenceGate("fence/obsidian_fence_gate").setResistance(2000.0F));
		glowstone_fence_gate = registerBlock(new EABlockFenceGate("fence/glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_wall = registerBlock(new EABlockWall("wall/draconium_wall", draconium_block).setResistance(4.0F));
		velious_wall = registerBlock(new EABlockWall("wall/velious_wall", velious_block).setResistance(15.0F));
		arcanite_wall = registerBlock(new EABlockWall("wall/arcanite_wall", arcanite_block).setResistance(30.0F));
		katcheen_wall = registerBlock(new EABlockWall("wall/katcheen_wall", katcheen_block).setResistance(100.0F));
		necrocite_wall = registerBlock(new EABlockWall("wall/necrocite_wall", necrocite_block).setResistance(45.0F));
		soularite_wall = registerBlock(new EABlockWall("wall/soularite_wall", soularite_block).setResistance(45.0F));
		ebonheart_wall = registerBlock(new EABlockWall("wall/ebonheart_wall", ebonheart_block).setResistance(2000.0F));
		obsidian_wall = registerBlock(new EABlockWall("wall/obsidian_wall", obsidian_block).setResistance(2000.0F));
		glowstone_wall = registerBlock(new EABlockWall("wall/glowstone_wall", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		draconium_trapdoor = registerBlock(new EABlockTrapDoor("door/draconium_trapdoor").setResistance(4.0F));
		velious_trapdoor = registerBlock(new EABlockTrapDoor("door/velious_trapdoor").setResistance(4.0F));
		arcanite_trapdoor = registerBlock(new EABlockTrapDoor("door/arcanite_trapdoor").setResistance(4.0F));
		katcheen_trapdoor = registerBlock(new EABlockTrapDoor("door/katcheen_trapdoor").setResistance(4.0F));
		necrocite_trapdoor = registerBlock(new EABlockTrapDoor("door/necrocite_trapdoor").setResistance(4.0F));
		soularite_trapdoor = registerBlock(new EABlockTrapDoor("door/soularite_trapdoor").setResistance(4.0F));
		ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("door/ebonheart_trapdoor").setResistance(4.0F));
		obsidian_trapdoor = registerBlock(new EABlockTrapDoor("door/obsidian_trapdoor").setResistance(4.0F));
		glowstone_trapdoor = registerBlock(new EABlockTrapDoor("door/glowstone_trapdoor").setResistance(4.0F));
		
		draconium_ladder = registerBlock(new EABlockLadder("ladder/draconium_ladder"));
		velious_ladder = registerBlock(new EABlockLadder("ladder/velious_ladder"));
		arcanite_ladder = registerBlock(new EABlockLadder("ladder/arcanite_ladder"));
		katcheen_ladder = registerBlock(new EABlockLadder("ladder/katcheen_ladder"));
		necrocite_ladder = registerBlock(new EABlockLadder("ladder/necrocite_ladder"));
		soularite_ladder = registerBlock(new EABlockLadder("ladder/soularite_ladder"));
		ebonheart_ladder = registerBlock(new EABlockLadder("ladder/ebonheart_ladder"));
		obsidian_ladder = registerBlock(new EABlockLadder("ladder/obsidian_ladder"));
		glowstone_ladder = registerBlock(new EABlockLadder("ladder/glowstone_ladder").setLightLevel(1.0f));
		
		draconium_pillar = registerBlock(new EABlockPillar("pillar/draconium_pillar").setResistance(4.0F));
		velious_pillar = registerBlock(new EABlockPillar("pillar/velious_pillar").setResistance(15.0F));
		arcanite_pillar = registerBlock(new EABlockPillar("pillar/arcanite_pillar").setResistance(30.0F));
		katcheen_pillar = registerBlock(new EABlockPillar("pillar/katcheen_pillar").setResistance(100.0F));
		necrocite_pillar = registerBlock(new EABlockPillar("pillar/necrocite_pillar").setResistance(45.0F));
		soularite_pillar = registerBlock(new EABlockPillar("pillar/soularite_pillar").setResistance(45.0F));
		ebonheart_pillar = registerBlock(new EABlockPillar("pillar/ebonheart_pillar").setResistance(2000.0F));
		obsidian_pillar = registerBlock(new EABlockPillar("pillar/obsidian_pillar").setResistance(2000.0F));
		glowstone_pillar = registerBlock(new EABlockPillar("pillar/glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_fancybrick = registerBlock(new BlockEA("gem/draconium/draconium_block_fancybrick").setResistance(4.0F));
		velious_block_fancybrick = registerBlock(new BlockEA("gem/velious/velious_block_fancybrick").setResistance(15.0F));
		arcanite_block_fancybrick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_fancybrick").setResistance(30.0F));
		katcheen_block_fancybrick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_fancybrick").setResistance(100.0F));
		necrocite_block_fancybrick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_fancybrick").setResistance(45.0F));
		soularite_block_fancybrick = registerBlock(new BlockEA("gem/soularite/soularite_block_fancybrick").setResistance(45.0F));
		ebonheart_block_fancybrick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_fancybrick").setResistance(2000.0F));
		obsidian_block_fancybrick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_fancybrick").setResistance(2000.0F));
		glowstone_block_fancybrick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f));
		
		
		
		cobble_mystic_block_normal = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_normal"));
		cobble_mystic_block_glass = registerBlock(new BlockMysticCobblestoneGlass("gem/mystic/cobblestone/cobble_mystic_block_glass"));
		cobble_mystic_block_white = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_white"));
		cobble_mystic_block_orange = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_orange"));
		cobble_mystic_block_magenta = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_magenta"));
		cobble_mystic_block_lightblue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightblue"));
		cobble_mystic_block_yellow = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_yellow"));
		cobble_mystic_block_lime = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lime"));
		cobble_mystic_block_pink = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_pink"));
		cobble_mystic_block_gray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_gray"));
		cobble_mystic_block_lightgray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightgray"));
		cobble_mystic_block_cyan = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_cyan"));
		cobble_mystic_block_purple = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_purple"));
		cobble_mystic_block_blue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_blue"));
		cobble_mystic_block_brown = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_brown"));
		cobble_mystic_block_green = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_green"));
		cobble_mystic_block_red = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_red"));
		cobble_mystic_block_black = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_black"));
		
		mystic_block_normal = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_normal"));
		mystic_block_glass = registerBlock(new BlockMysticStoneGlass("gem/mystic/stone/mystic_block_glass"));
		mystic_block_white = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_white"));
		mystic_block_orange = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_orange"));
		mystic_block_magenta = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_magenta"));
		mystic_block_lightblue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightblue"));
		mystic_block_yellow = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_yellow"));
		mystic_block_lime = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lime"));
		mystic_block_pink = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_pink"));
		mystic_block_gray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_gray"));
		mystic_block_lightgray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightgray"));
		mystic_block_cyan = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_cyan"));
		mystic_block_purple = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_purple"));
		mystic_block_blue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_blue"));
		mystic_block_brown = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_brown"));
		mystic_block_green = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_green"));
		mystic_block_red = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_red"));
		mystic_block_black = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_black"));
		
		wood_mystic_block_normal = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_normal"));
		wood_mystic_block_glass = registerBlock(new BlockMysticWoodGlass("gem/mystic/wood/wood_mystic_block_glass"));
		wood_mystic_block_white = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_white"));
		wood_mystic_block_orange = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_orange"));
		wood_mystic_block_magenta = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_magenta"));
		wood_mystic_block_lightblue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightblue"));
		wood_mystic_block_yellow = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_yellow"));
		wood_mystic_block_lime = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lime"));
		wood_mystic_block_pink = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_pink"));
		wood_mystic_block_gray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_gray"));
		wood_mystic_block_lightgray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightgray"));
		wood_mystic_block_cyan = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_cyan"));
		wood_mystic_block_purple = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_purple"));
		wood_mystic_block_blue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_blue"));
		wood_mystic_block_brown = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_brown"));
		wood_mystic_block_green = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_green"));
		wood_mystic_block_red = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_red"));
		wood_mystic_block_black = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_black"));
		
		paper_block = registerBlock(new EABlockDirectional("paper_block").setResistance(4.0F));
		leather_block = registerBlock(new EABlockDirectional("leather_block").setResistance(4.0F));
		reed_block = registerBlock(new EABlockDirectional("reed_block").setResistance(4.0F));
		
		hellion_fruit = registerBlock(new HellionFruitCrop());
		sacred_fruit = registerBlock(new SacredFruitCrop());
		dragon_fruit = registerBlock(new DragonFruitCrop());
		
		
		
		//----------------------------------------------
		
		
		
		cryptic_draconium_block = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_brick").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_brick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_brick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_brick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		double_cryptic_draconium_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_draconium_slab").setResistance(4.0F);
		double_cryptic_velious_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_velious_slab").setResistance(15.0F);
		double_cryptic_arcanite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_arcanite_slab").setResistance(30.0F);
		double_cryptic_katcheen_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_katcheen_slab").setResistance(100.0F);
		double_cryptic_necrocite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_necrocite_slab").setResistance(45.0F);
		double_cryptic_soularite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_soularite_slab").setResistance(45.0F);
		double_cryptic_ebonheart_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_ebonheart_slab").setResistance(2000.0F);
		double_cryptic_obsidian_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_obsidian_slab").setResistance(2000.0F);
		double_cryptic_glowstone_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		cryptic_draconium_slab = new BlockHalfSlab("cryptic/slab/cryptic_draconium_slab").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_velious_slab = new BlockHalfSlab("cryptic/slab/cryptic_velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_arcanite_slab = new BlockHalfSlab("cryptic/slab/cryptic_arcanite_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_katcheen_slab = new BlockHalfSlab("cryptic/slab/cryptic_katcheen_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_necrocite_slab = new BlockHalfSlab("cryptic/slab/cryptic_necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_soularite_slab = new BlockHalfSlab("cryptic/slab/cryptic_soularite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_ebonheart_slab = new BlockHalfSlab("cryptic/slab/cryptic_ebonheart_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_obsidian_slab = new BlockHalfSlab("cryptic/slab/cryptic_obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_glowstone_slab = new BlockHalfSlab("cryptic/slab/cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		
		
		
		GameRegistry.registerBlock(double_cryptic_draconium_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_draconium_slab", cryptic_draconium_slab, double_cryptic_draconium_slab, true);
		GameRegistry.registerBlock(double_cryptic_velious_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_velious_slab", cryptic_velious_slab, double_cryptic_velious_slab, true);
		GameRegistry.registerBlock(double_cryptic_arcanite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_arcanite_slab", cryptic_arcanite_slab, double_cryptic_arcanite_slab, true);
		GameRegistry.registerBlock(double_cryptic_katcheen_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_katcheen_slab", cryptic_katcheen_slab, double_cryptic_katcheen_slab, true);
		GameRegistry.registerBlock(double_cryptic_necrocite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_necrocite_slab", cryptic_necrocite_slab, double_cryptic_necrocite_slab, true);
		GameRegistry.registerBlock(double_cryptic_soularite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_soularite_slab", cryptic_soularite_slab, double_cryptic_soularite_slab, true);
		GameRegistry.registerBlock(double_cryptic_ebonheart_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_ebonheart_slab", cryptic_ebonheart_slab, double_cryptic_ebonheart_slab, true);
		GameRegistry.registerBlock(double_cryptic_obsidian_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_obsidian_slab", cryptic_obsidian_slab, double_cryptic_obsidian_slab, true);
		GameRegistry.registerBlock(double_cryptic_glowstone_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_glowstone_slab", cryptic_glowstone_slab, double_cryptic_glowstone_slab, true);
		
		GameRegistry.registerBlock(cryptic_draconium_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_draconium_slab", cryptic_draconium_slab, double_cryptic_draconium_slab, false);
		GameRegistry.registerBlock(cryptic_velious_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_velious_slab", cryptic_velious_slab, double_cryptic_velious_slab, false);
		GameRegistry.registerBlock(cryptic_arcanite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_arcanite_slab", cryptic_arcanite_slab, double_cryptic_arcanite_slab, false);
		GameRegistry.registerBlock(cryptic_katcheen_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_katcheen_slab", cryptic_katcheen_slab, double_cryptic_katcheen_slab, false);
		GameRegistry.registerBlock(cryptic_necrocite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_necrocite_slab", cryptic_necrocite_slab, double_cryptic_necrocite_slab, false);
		GameRegistry.registerBlock(cryptic_soularite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_soularite_slab", cryptic_soularite_slab, double_cryptic_soularite_slab, false);
		GameRegistry.registerBlock(cryptic_ebonheart_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_ebonheart_slab", cryptic_ebonheart_slab, double_cryptic_ebonheart_slab, false);
		GameRegistry.registerBlock(cryptic_obsidian_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_obsidian_slab", cryptic_obsidian_slab, double_cryptic_obsidian_slab, false);
		GameRegistry.registerBlock(cryptic_glowstone_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_glowstone_slab", cryptic_glowstone_slab, double_cryptic_glowstone_slab, false);
		
		
		
		cryptic_draconium_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_draconium_stairs", cryptic_draconium_block).setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_velious_stairs", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_arcanite_stairs", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_katcheen_stairs", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_necrocite_stairs", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_soularite_stairs", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_ebonheart_stairs", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_obsidian_stairs", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_glowstone_stairs", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_draconium_fence").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_velious_fence").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_arcanite_fence").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_katcheen_fence").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_necrocite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_soularite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_ebonheart_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_obsidian_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_glowstone_fence").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_draconium_fence_gate").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_velious_fence_gate").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_arcanite_fence_gate").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_katcheen_fence_gate").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_necrocite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_soularite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_ebonheart_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_obsidian_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_draconium_wall", cryptic_draconium_block).setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_velious_wall", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_arcanite_wall", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_katcheen_wall", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_necrocite_wall", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_soularite_wall", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_ebonheart_wall", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_obsidian_wall", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_glowstone_wall", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		//cryptic_draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		//cryptic_velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		//cryptic_arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		//cryptic_katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		//cryptic_necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		//cryptic_soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		//cryptic_ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		//cryptic_obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		//cryptic_glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		cryptic_draconium_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_draconium_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_velious_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_arcanite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_katcheen_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_necrocite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_soularite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_ebonheart_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_obsidian_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_glowstone_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_draconium_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_velious_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_arcanite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_katcheen_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_necrocite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_soularite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_ebonheart_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_obsidian_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_glowstone_ladder").setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_draconium_pillar").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_velious_pillar").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_arcanite_pillar").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_katcheen_pillar").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_necrocite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_soularite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_ebonheart_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_obsidian_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_fancybrick").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_fancybrick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_fancybrick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_fancybrick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		*/
	
//ViesCraftConfig.java
	/**
	 * 
	 *
	//final String RECIPES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.GREEN + "Recipes";
	final String PARTICLES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
	
	//ViesCraft.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item recipes.");
	//weaponRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
	//armorRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + ARMORRECIPE_NAME, ARMORRECIPE_DEFAULT).getBoolean(ARMORRECIPE_DEFAULT);
	//toolRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + TOOLRECIPE_NAME, TOOLRECIPE_DEFAULT).getBoolean(TOOLRECIPE_DEFAULT);
	//decraftRecipe1 = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + DECRAFTRECIPE1_NAME, DECRAFTRECIPE1_DEFAULT).getBoolean(DECRAFTRECIPE1_DEFAULT);
	
	//vanillaRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + VANILLARECIPE_NAME, VANILLARECIPE_DEFAULT).getBoolean(VANILLARECIPE_DEFAULT);
	//horseRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + HORSERECIPE_NAME, HORSERECIPE_DEFAULT).getBoolean(HORSERECIPE_DEFAULT);
	//musicRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + MUSICRECIPE_NAME, MUSICRECIPE_DEFAULT).getBoolean(MUSICRECIPE_DEFAULT);
	
	
	//decraftRecipe2 = ViesCraft.config.get(RECIPES, DECRAFTRECIPE2_NAME, DECRAFTRECIPE2_DEFAULT).getBoolean(DECRAFTRECIPE2_DEFAULT);
	
	
	ViesCraft.config.addCustomCategoryComment(PARTICLES, "Enable or disable airship animation.");
	modelAnimation = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELANIMATION_NAME, MODELANIMATION_DEFAULT).getBoolean(MODELANIMATION_DEFAULT);
	modelTurnAngle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELTURNANGLE_NAME, MODELTURNANGLE_DEFAULT).getBoolean(MODELTURNANGLE_DEFAULT);
	
	//plantParticle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + PLANTANIMATION_NAME, PLANTANIMATION_DEFAULT).getBoolean(PLANTANIMATION_DEFAULT);
	
	*/
	
	
//AirshipHandler.java
	/**
	 * 
	 *
	@SubscribeEvent
    public void onPlayerTick1(PlayerInteractEvent.EntityInteract event) 
    {
		
		//EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		if(event.getTarget() instanceof EntityAirshipBlack
		&& Minecraft.getMinecraft().thePlayer.isSneaking()
				)
		{
			//LogHelper.info("Test successful!");
			//LogHelper.info(event.getTarget());
			
			//event.getEntityPlayer().openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.getEntityPlayer().worldObj, event.getEntityPlayer().getPosition().getX(), event.getEntityPlayer().getPosition().getY(), event.getEntityPlayer().getPosition().getZ());
			
			
		}
    }
    
    //================================
     
    ///if (event.player.getRidingEntity() instanceof EntityAirshipBlack 
			///	&& EntityAirshipBlack.openInputDown)
            ///{
				/////PacketDispatcher.sendToServer(new OpenGuiMessage(GuiHandler.GUI_AIRSHIP_BLACK));

				//event.player.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.player.worldObj, event.player.getPosition().getX(), event.player.getPosition().getY(), event.player.getPosition().getZ());
				
				//LogHelper.info("Test 3 successful!");
            	//this.openGUI(this.worldObj, playerVC);
            	
            			//Minecraft.getMinecraft().thePlayer
            			
            			
            	//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            			
            ///}
			//if (EntityAirshipBlack.openInputDown
			//		&& Minecraft.getMinecraft().currentScreen instanceof GuiEntityAirshipBlack
					
			//		)
            //{
				
				//event.player.closeScreen();//openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.player.worldObj, event.player.getPosition().getX(), event.player.getPosition().getY(), event.player.getPosition().getZ());
				
			//	LogHelper.info("Test 4 successful!");
            	//this.openGUI(this.worldObj, playerVC);
            	
            			//Minecraft.getMinecraft().thePlayer
            			
            			
            	//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            			
            //}
			
			
			//if (//event.player.getRidingEntity().getPassengers()
				//event.player.getRidingEntity().isBeingRidden() instanceof EntityAnimal
				//&& 
			//	event.player.getRidingEntity().isRidingOrBeingRiddenBy(entityIn) == entityIn instanceof EntityAnimal
			//	) 
			//{
			//	isAnimalPassenger = true;
			//}
			
		//if (isAnimalPassenger) 
    	//{
		//	LogHelper.info("Airship's passenger is an animal!");
			//event.player.addStat(InitAchievementsVC.airship_lava);
    	//}
    	 * 
    	 * 
    	 * || event.player.getRidingEntity() instanceof EntityAirshipBlack
		|| event.player.getRidingEntity() instanceof EntityAirshipBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipBrown
		|| event.player.getRidingEntity() instanceof EntityAirshipCyan
		|| event.player.getRidingEntity() instanceof EntityAirshipGray
		|| event.player.getRidingEntity() instanceof EntityAirshipGreen
		|| event.player.getRidingEntity() instanceof EntityAirshipLightBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipLightGray
		|| event.player.getRidingEntity() instanceof EntityAirshipLime
		|| event.player.getRidingEntity() instanceof EntityAirshipMagenta
		|| event.player.getRidingEntity() instanceof EntityAirshipOrange
		|| event.player.getRidingEntity() instanceof EntityAirshipPink
		|| event.player.getRidingEntity() instanceof EntityAirshipPurple
		|| event.player.getRidingEntity() instanceof EntityAirshipRed
		|| event.player.getRidingEntity() instanceof EntityAirshipWhite
		//|| event.player.getRidingEntity() instanceof EntityAirshipYellow
	
				
    	 * 
	*/
	
//KeyBinds.java

	/**
	 * 
	 * 
	
    //@Override
    //public void openGUI(World world, EntityPlayer player)
    //{
    	//player.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
    //}
	//LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
       //Minecraft.getMinecraft().gameSettings.isKeyDown(Keybinds.vcInventory))     
	
            	
            	//LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
            	//if( Minecraft.getMinecraft().setIngameNotInFocus()
            	///		Minecraft.getMinecraft().currentScreen == ((GuiEntityAirshipBlack)null)
            	//		Minecraft.getMinecraft().thePlayer.get
            	//	)
            	//{
            		
            	//}
            		//Minecraft.getMinecraft().currentScreen == GuiHandler.GUI_AIRSHIP_BLACK
            	
            	//PacketDispatcher.sendToServer(new OpenGuiMessage(GuiHandler.GUI_AIRSHIP_BLACK));
        //LogHelper.info(Minecraft.getMinecraft().inGameHasFocus);
            	//this.openGUI(this.worldObj, playerVC);
            	//Minecraft.getMinecraft().thePlayer.displayGui(null);
            			//Minecraft.getMinecraft().thePlayer
            			
            			//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            	//ViesCraft.network.sendTo(new SomeMessage(), somePlayer);
            			
            	///}	
            	///else if (Minecraft.getMinecraft().currentScreen != ((GuiEntityAirshipBlack)null)
            	///		)
            	///{
            	///	NetworkHandler.sendToServer(new MessageGuiCloseBlack());
            	
            	///}    	
	
    //public String getCustomName() 
    //{
	//	return this.customName;
	//}
    
	//public void setCustomName(String customName) 
	//{
	//	this.customName = customName;
	//}
    
	//@Override
	//public String getName() 
	//{
		//return this.hasCustomName() ? this.customName : "container.vc.airship.black";
	//}
	
	//@Override
	//public boolean hasCustomName() 
	//{
	//	return this.customName != null && !this.customName.equals("");
	//}
	
	//@Override
	//public ITextComponent getDisplayName() 
	//{
	//	return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	//}

	*/
	
//KeyBinds.java

	/**
	 * 
	 * 
	
	//private EntityAirshipV1Core airship;
	
	//private EntityPlayer player;
	//private int test;
	
	
	//private Entity entity;
	
	
	//private World worldIn; // = Minecraft.getMinecraft().thePlayer;
	
	//this.player = player;
		
		//this.airship.getDataManager().getDirty().get(airship.airshipOn);//.get(airship.airshipOn).getDataWatcher().addObject(ExtendedPlayer.angelHealthiD,
			   // 0.0F);
		//this.mc = mc;
		
		
	
	
	
	/**
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	//private final ResourceLocation overlayBar = new ResourceLocation(Reference.MOD_ID, "/textures/gui/mbe40_hud_overlay.png");
	private EntityAirshipV1Core airship;
	
	/* These two variables describe the size of the bar */
	//private final static int BAR_WIDTH = 81;
	//private final static int BAR_HEIGHT = 9;
	//private final static int BAR_SPACING_ABOVE_EXP_BAR = 3;   //pixels between the BAR and the Experience Bar below it
	/**
	private final int hudWidth;
	private final int hudHeight;
	
	private final int fieldWidth;
	
	private final int ledWidth;
    private final int ledHeight;
    
	private final int colorDimBlue;
	
	private boolean airshipOn;
	
	
	
	public GuiHUD(
		//IInventory playerInv, EntityAirshipV1Core airship
			) 
	{
		super();
		
		hudWidth = 182;
        hudHeight = 39;
        
        ledWidth = 11;
        ledHeight = 5;
        
        colorDimBlue = 0xcc000088;
        
        airshipOn = false;
        
        fontRenderer = mc.fontRendererObj;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
	}
	
	
	
	
	 * @return 
	*/
	/**
	public boolean getCurrentAltitude(
			//BlockPos entityPos
			) 
	{
		
		
        //if (airship.isAirshipBurning(airship))
        //{
        //	LogHelper.info(airship.getBoatType());
        //}
		//if (mc.theWorld.provider.isSurfaceWorld()) {
        //    BlockPos blockPos = new BlockPos(entityPos.getX(), entityPos.getY(), entityPos.getZ());
        //    while (mc.theWorld.isAirBlock(blockPos.down())) {
        //        blockPos = blockPos.down();
        //    }
            // calculate the entity's current altitude above the ground
        //    return entityPos.getY() - blockPos.getY();
        //}
		return airshipOn;
        
		//return 1000.0 * mc.theWorld.rand.nextGaussian();
    }
	
	
	//@SideOnly(Side.CLIENT)
	@SubscribeEvent//(priority = EventPriority.LOWEST)
	public void onRender(RenderGameOverlayEvent.Post event) 
	{
		event.hasResult();
		if (Minecraft.getMinecraft().thePlayer == null)
		{
			return;  // just in case
		}
		
		if(Minecraft.getMinecraft().thePlayer.getRidingEntity() instanceof EntityAirshipV1Core)
	    {
			
			airshipOn = getCurrentAltitude();
			
			ScaledResolution sr = new ScaledResolution(mc);
            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
            int hudY = 2; // top edge of GUI
            int textX = hudX + 30; // xcoord for text
            int textY = hudY + 22; // ycoord for text
            int ledX = 1;
			
            GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                                                 GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            //RenderHelper.enableGUIStandardItemLighting();
            Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/viescraft_hud.png"));
    		
            // Params: int screenX, int screenY, int textureX, int textureY, int width, int height
            drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight); // draw the main hud

            //if(airship.isClientAirshipBurning())
            //{
            //	
            //}
            
            
            //return;	
	    }
		
		return;
		
		
		
		/**
		if (event.isCancelable() || mc.gameSettings.showDebugInfo || mc.thePlayer.onGround) {
            return;
        }

        if (mc.inGameHasFocus && event.getType() == RenderGameOverlayEvent.ElementType.ALL) 
        {
            ScaledResolution sr = new ScaledResolution(mc);
            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
            int hudY = 2; // top edge of GUI
            int textX = hudX + 30; // xcoord for text
            int textY = hudY + 22; // ycoord for text
            int ledX = 1;

            if(Minecraft.getMinecraft().thePlayer.getRidingEntity() instanceof EntityAirshipV1Core)
    	    {
            //if (ParachuteCommonProxy.onParachute(mc.thePlayer)) 
            //{
                //mc.getTextureManager().bindTexture(hudTexture);

                GlStateManager.enableRescaleNormal();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                                                     GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                RenderHelper.enableGUIStandardItemLighting();
                Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/viescraft_hud.png"));
        		
                //BlockPos entityPos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minY, mc.thePlayer.posZ);
                //altitude = getCurrentAltitude(entityPos);
                //double homeDir = getHomeDirection();
                //double distance = getHomeDistance();
                double heading = (((mc.thePlayer.rotationYaw + 180.0) % 360) + 360) % 360;

                // Params: int screenX, int screenY, int textureX, int textureY, int width, int height
                drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight); // draw the main hud

                // determine which LED to light, homeDir is in range -180 to 180
                // for any value under -80 or over 80 the LED is fixed to the
                // left or right end of the slider respectively.
                ////if (homeDir < -80) {
                ////    ledX = 1;
                ////} else if ((homeDir - 80) * (homeDir - -80) < 0) {
                ////    ledX = (int) Math.floor((homeDir + 80.0) + 4);
                ////} else if (homeDir > 80) {
                ////    ledX = 170;
                ////}
                
                
                // AAD status
                //int aadIconX;
                //int aadIconY = 8;
                //if (ConfigHandler.getIsAADActive()) {
                //    aadIconX = 199;
                //} else {
                //    aadIconX = 182;
                //}
                ////drawTexturedModalRect(hudX + hudWidth + 2, hudY + 8, aadIconX, aadIconY, aadWidth, aadHeight); // draw the AAD indicator
/**
                // manual dismount indicator
                if (ConfigHandler.isAutoDismount()) { // auto dismount is engaged
                    drawTexturedModalRect(hudX - 18, hudY + yOffset, dark, lightY, 16, 16);
                } else { // auto dismount is disabled
                    if (altitude > 10) {
                        drawTexturedModalRect(hudX - 18, hudY + yOffset, green, lightY, 16, 16);
                    } else if (altitude <= 10 && altitude > 3) {
                        drawTexturedModalRect(hudX - 18, hudY + yOffset, red, lightY, 16, 16);
                    } else if (altitude <= 3) { // make this blink
                        if ((blink % blinkTime) == 0) {
                            blinkX = blinkX == red ? darkRed : red;
                        }
                        drawTexturedModalRect(hudX - 18, hudY + yOffset, blinkX, lightY, 16, 16);
                        blink++;
                    }
                }

                if (wayPointEnabled) {
                    double waypointDirection = getWaypointDirection(wayPointX, wayPointZ);
                    // draw the waypoint heading
                    if (waypointDirection < -80) {
                        ledX = 1;
                    } else if ((waypointDirection - 80) * (waypointDirection - -80) < 0) {
                        ledX = (int) Math.floor((waypointDirection + 80.0) + 4);
                    } else if (waypointDirection > 80) {
                        ledX = 170;
                    }
                    // draw the waypoint bar background
                    drawTexturedModalRect(hudX, hudY + hudHeight, 0, 0, hudWidth, ledHeight);
                    // draw the lit LED
                    drawTexturedModalRect(hudX + ledX, hudY + hudHeight, ledX, ledY, ledWidth, ledHeight);
                }
x
                // draw the altitude text
                fontRenderer.drawStringWithShadow(I18n.format("gui.hud.altitude"), hudX + 18, hudY + 12, colorDimBlue);
                ////fontRenderer.drawStringWithShadow(format(altitude), (textX + 5) - fieldWidth, textY, colorAltitude());
                // draw the compass heading text
                ////fontRenderer.drawStringWithShadow(I18n.format("gui.hud.compass"), hudX + 123, hudY + 12, colorDimBlue);
                ////fontRenderer.drawStringWithShadow(format(heading), (textX + 118) - fieldWidth, textY, colorCompass(heading));
                // draw the distance to the home point text
                ////fontRenderer.drawStringWithShadow(format(distance), (textX + 65) - fieldWidth, textY, colorDimGreen);
            }
            RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
        
        
    }
		
	
	
	
	
	/**
	public static void test()
	{
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());//, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		FontRenderer fontRender = Minecraft.getMinecraft().fontRendererObj;
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship.png"));
		//this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship.png"));
		Minecraft.getMinecraft().draw(
				height/2, width/2, //200, 5, //posX, posY
				0, 10, //texU, texV // where the uv texture is in the png
				400, 100, //width, height
				250, 250, 250, //red, green, blue
				0);  //alpha
		
		
		
		
		//this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//int i = (this.width - this.xSize) / 2;
        //int j = (this.height - this.ySize) / 2;
        
		//if (EntityAirshipV1Core.isAirshipBurning(airship))
        //{
			//int x = airship.getFuelScaled(10);
        //    int k = this.getBurnLeftScaled(47);
        //    this.drawTexturedModalRect(
        //    		this.guiLeft + 156, this.guiTop + 19, //i + 56, j + 36 + 12 - k, 
        //    		176,  50, //176, 12 - k, 
        //    		8, 1 + k); //8, 48 + k);//14, k + 1);
        //    this.drawTexturedModalRect(
        //    		this.guiLeft + 129, this.guiTop + 48,//i + 79, j + 34, 
        //    		176, 14, 
        //    		26, 16);
        //}
	}
	
/**
	private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(1);

        if (i == 0)
        {
        	i = (ViesCraftConfig.v1FuelBurnTime * 20);//i = 1200;
        }

        return this.airship.getField(0) * pixels / i;
    }
	*/
	/**
	public static void renderTextToHud() 
	{
		
		ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());//, Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
		FontRenderer fontRender = Minecraft.getMinecraft().fontRendererObj;
		int width = res.getScaledWidth();
		int height = res.getScaledHeight();

		String test = "Simple Test";
		int x = width / 2;
		int y = height / 2;
		int color = 0xffffff;
		Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(test, x, y, color);
		
	}
	
	
	
}

		
		
		
	
	
*/	
}
