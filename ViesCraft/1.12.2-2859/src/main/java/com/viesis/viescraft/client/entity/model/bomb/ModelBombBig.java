package com.viesis.viescraft.client.entity.model.bomb;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBombBig extends ModelBase
{
    ModelRenderer BombBase1a;
    ModelRenderer BombBase1b;
    ModelRenderer BombBase1c;
    ModelRenderer BombBase2;
    ModelRenderer BombBase3;
    ModelRenderer FinL;
    ModelRenderer FinR;

    public ModelBombBig()
    {
        this( 0.0f );
    }

    public ModelBombBig( float par1 )
    {
        BombBase1a = new ModelRenderer( this, 0, 24 );
        BombBase1a.setTextureSize( 64, 32 );
        BombBase1a.addBox( -2F, -2F, -2F, 4, 4, 4);
        BombBase1a.setRotationPoint( 0F, -6F, 0F );
        BombBase1b = new ModelRenderer( this, 2, 13 );
        BombBase1b.setTextureSize( 64, 32 );
        BombBase1b.addBox( -1.5F, -4F, -1.5F, 3, 8, 3);
        BombBase1b.setRotationPoint( 0F, -7.5F, 0F );
        BombBase1c = new ModelRenderer( this, 4, 0 );
        BombBase1c.setTextureSize( 64, 32 );
        BombBase1c.addBox( -1F, -5.5F, -1F, 2, 11, 2);
        BombBase1c.setRotationPoint( 0F, -8.5F, 0F );
        BombBase2 = new ModelRenderer( this, 17, 26 );
        BombBase2.setTextureSize( 64, 32 );
        BombBase2.addBox( -2.5F, -1.5F, -1.5F, 5, 3, 3);
        BombBase2.setRotationPoint( 0F, -6F, 0F );
        BombBase3 = new ModelRenderer( this, 17, 18 );
        BombBase3.setTextureSize( 64, 32 );
        BombBase3.addBox( -1.5F, -1.5F, -2.5F, 3, 3, 5);
        BombBase3.setRotationPoint( 0F, -6F, 0F );
        FinL = new ModelRenderer( this, 34, 26 );
        FinL.setTextureSize( 64, 32 );
        FinL.addBox( -0.5F, -2F, -1F, 1, 4, 2);
        FinL.setRotationPoint( 0F, -14F, -2F );
        FinR = new ModelRenderer( this, 40, 26 );
        FinR.setTextureSize( 64, 32 );
        FinR.addBox( -0.5F, -2F, -1F, 1, 4, 2);
        FinR.setRotationPoint( 0F, -14F, 2F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        BombBase1a.rotateAngleX = 0F;
        BombBase1a.rotateAngleY = 0F;
        BombBase1a.rotateAngleZ = 0F;
        BombBase1a.renderWithRotation(par7);

        BombBase1b.rotateAngleX = 0F;
        BombBase1b.rotateAngleY = -0.7853982F;
        BombBase1b.rotateAngleZ = 0F;
        BombBase1b.renderWithRotation(par7);

        BombBase1c.rotateAngleX = 0F;
        BombBase1c.rotateAngleY = 0F;
        BombBase1c.rotateAngleZ = 0F;
        BombBase1c.renderWithRotation(par7);

        BombBase2.rotateAngleX = 0.7853982F;
        BombBase2.rotateAngleY = 0F;
        BombBase2.rotateAngleZ = 0F;
        BombBase2.renderWithRotation(par7);

        BombBase3.rotateAngleX = 0F;
        BombBase3.rotateAngleY = 0F;
        BombBase3.rotateAngleZ = -0.7853982F;
        BombBase3.renderWithRotation(par7);

        FinL.rotateAngleX = 0.9075713F;
        FinL.rotateAngleY = 0F;
        FinL.rotateAngleZ = 0F;
        FinL.renderWithRotation(par7);

        FinR.rotateAngleX = -0.9075713F;
        FinR.rotateAngleY = 0F;
        FinR.rotateAngleZ = 0F;
        FinR.renderWithRotation(par7);

    }

}
