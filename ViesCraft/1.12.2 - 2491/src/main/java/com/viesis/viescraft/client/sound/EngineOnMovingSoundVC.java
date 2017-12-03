package com.viesis.viescraft.client.sound;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.Entity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EngineOnMovingSoundVC extends MovingSound {
	
    private final Entity airship;
    private float distance = 0.0F;
    private SoundEvent sound;
    
    public EngineOnMovingSoundVC(Entity airshipIn, SoundEvent soundIn)
    {
        super(soundIn, SoundCategory.AMBIENT);
        this.airship = airshipIn;
        this.repeat = true;
        this.repeatDelay = 0;
        this.sound = soundIn;
    }
    
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update()
    {
    	if (this.airship.isDead)
        {
        	this.donePlaying = true;
        }
        else
        {
        	this.xPosF = (float)this.airship.posX;
            this.yPosF = (float)this.airship.posY;
            this.zPosF = (float)this.airship.posZ;
            float f = MathHelper.sqrt_double(this.airship.motionX * this.airship.motionX + this.airship.motionZ * this.airship.motionZ);
            
            if ((double)f >= 0.01D)
            {
                this.distance = MathHelper.clamp_float(this.distance + 0.0025F, 0.0F, 0.5F);
                this.volume = 0.25F + MathHelper.clamp_float(f, 0.0F, 0.5F) * 0.7F;
            }
            else
            {
                this.distance = 0.0F;
                this.volume = 0.25F;
            }
        }
    }
}
