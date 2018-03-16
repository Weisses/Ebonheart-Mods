package com.viesis.viescraft.client.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAirshipPanel extends ModelBase
{
    ModelRenderer ControlPanelScreen;

    public ModelAirshipPanel()
    {
        this( 0.0f );
    }

    public ModelAirshipPanel( float par1 )
    {
        ControlPanelScreen = new ModelRenderer( this, 0, 0 );
        ControlPanelScreen.setTextureSize( 12, 4 );
        ControlPanelScreen.addBox( 0.5F, 0.5F, 0.5F, 6, 4, 0);
        ControlPanelScreen.setRotationPoint( -3.5F, -1.4F, -15.65F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        ControlPanelScreen.rotateAngleX = 0.7853982F;
        ControlPanelScreen.rotateAngleY = 0F;
        ControlPanelScreen.rotateAngleZ = 0F;
        ControlPanelScreen.renderWithRotation(par7);

    }

}
