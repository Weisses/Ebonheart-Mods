package com.vies.viesmachines.client.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EngineOnMovingSoundVM extends MovingSound {
	
    private final Entity machine;
    private float distance = 0.0F;
    private SoundEvent sound;
    
    public EngineOnMovingSoundVM(Entity machineIn, SoundEvent soundIn)
    {
        super(soundIn, SoundCategory.AMBIENT);
        this.machine = machineIn;
        this.repeat = true;
        this.repeatDelay = 0;
        this.sound = soundIn;
    }
    
    @Override
    public void update()
    {
    	if (this.machine.isDead)
        {
        	this.donePlaying = true;
        }
        else
        {
        	this.xPosF = (float)this.machine.posX;
            this.yPosF = (float)this.machine.posY;
            this.zPosF = (float)this.machine.posZ;
            float f = MathHelper.sqrt(this.machine.motionX * this.machine.motionX + this.machine.motionZ * this.machine.motionZ);
            
            if ((double)f >= 0.01D)
            {
                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 0.5F);
                this.volume = 0.25F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
            }
            else
            {
                this.distance = 0.0F;
                this.volume = 0.25F;
            }
        }
    }
}
