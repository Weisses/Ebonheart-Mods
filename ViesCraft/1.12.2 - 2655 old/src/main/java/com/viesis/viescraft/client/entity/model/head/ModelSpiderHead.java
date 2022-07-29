package com.viesis.viescraft.client.entity.model.head;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelSpiderHead extends ModelBase
{
	/** The spider's head box */
    public ModelRenderer spiderHead;

    public ModelSpiderHead()
    {
        this.spiderHead = new ModelRenderer(this, 32, 4);
        this.spiderHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.spiderHead.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        
        this.spiderHead.render(scale);
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
        this.spiderHead.rotateAngleY = netHeadYaw * 0.017453292F;
        this.spiderHead.rotateAngleX = headPitch * 0.017453292F;
    }
}