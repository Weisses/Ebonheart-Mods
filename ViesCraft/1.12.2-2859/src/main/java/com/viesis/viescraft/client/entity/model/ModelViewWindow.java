package com.viesis.viescraft.client.entity.model;

import net.minecraft.client.model.IMultipassModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelViewWindow extends ModelBase implements IMultipassModel
{
    ModelRenderer Seat_Driver_Bombbay_Hole;
    public ModelRenderer noWater;
    
    public ModelViewWindow()
    {
        this( 0.0f );
    }

    public ModelViewWindow( float par1 )
    {
        Seat_Driver_Bombbay_Hole = new ModelRenderer( this, 0, 0 );
        Seat_Driver_Bombbay_Hole.setTextureSize( 32, 16 );
        Seat_Driver_Bombbay_Hole.addBox( 0.5F, 0.5F, 0.5F, 9, 1, 7);
        Seat_Driver_Bombbay_Hole.setRotationPoint( -5F, 3.4F, -6F );
        

        this.noWater = (new ModelRenderer(this, 0, 0)).setTextureSize(128, 64);
        this.noWater.addBox(-14.0F, -9.0F, -3.0F, 28, 16, 3, 0.0F);
        this.noWater.setRotationPoint(0.0F, -3.0F, 1.0F);
        this.noWater.rotateAngleX = ((float)Math.PI / 2F);
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Seat_Driver_Bombbay_Hole.rotateAngleX = 0F;
        Seat_Driver_Bombbay_Hole.rotateAngleY = 0F;
        Seat_Driver_Bombbay_Hole.rotateAngleZ = 0F;
        Seat_Driver_Bombbay_Hole.renderWithRotation(par7);

    }

	@Override
	public void renderMultipass(Entity p_187054_1_, float p_187054_2_, float p_187054_3_, float p_187054_4_, float p_187054_5_, float p_187054_6_, float scale)
	{
		//GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
	    GlStateManager.colorMask(false, false, false, false);
	    this.noWater.render(scale);
	    GlStateManager.colorMask(true, true, true, true);
		
	}
}
