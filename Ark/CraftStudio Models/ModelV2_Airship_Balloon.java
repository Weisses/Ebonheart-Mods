package net.minecraft.src;

public class ModelV2_Airship_Balloon extends ModelBase
{
    ModelRenderer BaseWoodFloor;
    ModelRenderer BaseWoodChest;
    ModelRenderer BalloonTR1;
    ModelRenderer BalloonTL1;
    ModelRenderer BalloonBL1;
    ModelRenderer BalloonBL2;
    ModelRenderer BalloonBR1;
    ModelRenderer BalloonBR2;

    public ModelV2_Airship_Balloon()
    {
        this( 0.0f );
    }

    public ModelV2_Airship_Balloon( float par1 )
    {
        BaseWoodFloor = new ModelRenderer( this, 436, 0 );
        BaseWoodFloor.setTextureSize( 512, 256 );
        BaseWoodFloor.addBox( 0F, 0F, 0F, 14, 0, 24);
        BaseWoodFloor.setRotationPoint( -7F, 5F, -12F );
        BaseWoodChest = new ModelRenderer( this, 452, 24 );
        BaseWoodChest.setTextureSize( 512, 256 );
        BaseWoodChest.addBox( 0F, 0F, 0F, 10, 2, 8);
        BaseWoodChest.setRotationPoint( -5F, 4F, 3F );
        BalloonTR1 = new ModelRenderer( this, 115, 192 );
        BalloonTR1.setTextureSize( 512, 256 );
        BalloonTR1.addBox( 0F, 0F, 0F, 8, 8, 27);
        BalloonTR1.setRotationPoint( -21F, -14F, -10F );
        BalloonTL1 = new ModelRenderer( this, 115, 192 );
        BalloonTL1.setTextureSize( 512, 256 );
        BalloonTL1.addBox( 0F, 0F, 0F, 8, 8, 27);
        BalloonTL1.setRotationPoint( 13F, -14F, -10F );
        BalloonBL1 = new ModelRenderer( this, 0, 132 );
        BalloonBL1.setTextureSize( 512, 256 );
        BalloonBL1.addBox( 0F, 0F, 0F, 6, 6, 16);
        BalloonBL1.setRotationPoint( 14F, -2F, -2F );
        BalloonBL2 = new ModelRenderer( this, 0, 154 );
        BalloonBL2.setTextureSize( 512, 256 );
        BalloonBL2.addBox( 0F, 0F, 0F, 4, 4, 16);
        BalloonBL2.setRotationPoint( 15F, -1F, -3F );
        BalloonBR1 = new ModelRenderer( this, 0, 132 );
        BalloonBR1.setTextureSize( 512, 256 );
        BalloonBR1.addBox( 0F, 0F, 0F, 6, 6, 16);
        BalloonBR1.setRotationPoint( -20F, -2F, -2F );
        BalloonBR2 = new ModelRenderer( this, 0, 154 );
        BalloonBR2.setTextureSize( 512, 256 );
        BalloonBR2.addBox( 0F, 0F, 0F, 4, 4, 16);
        BalloonBR2.setRotationPoint( -19F, -1F, -3F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        BaseWoodFloor.rotateAngleX = 0F;
        BaseWoodFloor.rotateAngleY = 0F;
        BaseWoodFloor.rotateAngleZ = 0F;
        BaseWoodFloor.renderWithRotation(par7);

        BaseWoodChest.rotateAngleX = 0F;
        BaseWoodChest.rotateAngleY = 0F;
        BaseWoodChest.rotateAngleZ = 0F;
        BaseWoodChest.renderWithRotation(par7);

        BalloonTR1.rotateAngleX = 0F;
        BalloonTR1.rotateAngleY = 0F;
        BalloonTR1.rotateAngleZ = 0F;
        BalloonTR1.renderWithRotation(par7);

        BalloonTL1.rotateAngleX = 0F;
        BalloonTL1.rotateAngleY = 0F;
        BalloonTL1.rotateAngleZ = 0F;
        BalloonTL1.renderWithRotation(par7);

        BalloonBL1.rotateAngleX = 0F;
        BalloonBL1.rotateAngleY = 0F;
        BalloonBL1.rotateAngleZ = 0F;
        BalloonBL1.renderWithRotation(par7);

        BalloonBL2.rotateAngleX = 0F;
        BalloonBL2.rotateAngleY = 0F;
        BalloonBL2.rotateAngleZ = 0F;
        BalloonBL2.renderWithRotation(par7);

        BalloonBR1.rotateAngleX = 0F;
        BalloonBR1.rotateAngleY = 0F;
        BalloonBR1.rotateAngleZ = 0F;
        BalloonBR1.renderWithRotation(par7);

        BalloonBR2.rotateAngleX = 0F;
        BalloonBR2.rotateAngleY = 0F;
        BalloonBR2.rotateAngleZ = 0F;
        BalloonBR2.renderWithRotation(par7);

    }

}
