package com.vies.viesmachines.client.sound;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class JukeboxMovingSoundVM extends MovingSound {
	
	private final EntityMachineBase machine;
    private float distance = 0.0F;
    private SoundEvent sound;
    
    public JukeboxMovingSoundVM(EntityMachineBase machineIn, SoundEvent soundIn)
    {
        super(soundIn, SoundCategory.RECORDS);
        this.machine = machineIn;
        this.repeat = false;
        this.repeatDelay = 0;
        this.sound = soundIn;
    }
    
    @Override
    public void update()
    {
    	SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
    	
    	if (this.machine.isDead
    	|| this.machine.getBroken())
        {
        	this.donePlaying = true;
    		Minecraft.getMinecraft().gameSettings.setSoundLevel(SoundCategory.MUSIC, 1.0F);
        }
        else
        {
        	this.xPosF = (float)this.machine.posX;
            this.yPosF = (float)this.machine.posY;
            this.zPosF = (float)this.machine.posZ;
            float f = MathHelper.sqrt(this.machine.motionX * this.machine.motionX + this.machine.motionZ * this.machine.motionZ);
            
            if ((double)f >= 0.01D)
            {
                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
                this.volume = 0.5F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
            }
            else
            {
                this.distance = 0.0F;
                this.volume = 0.5F;
            }
            
            if(Minecraft.getMinecraft().gameSettings.getSoundLevel(SoundCategory.MUSIC) != 0.0F)
            {
            	Minecraft.getMinecraft().gameSettings.setSoundLevel(SoundCategory.MUSIC, 0.0F);
            }
        }
    }
}
