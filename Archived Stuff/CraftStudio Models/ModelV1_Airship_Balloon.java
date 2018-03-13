package net.minecraft.src;

public class ModelV1_Airship_Balloon extends ModelBase
{
    ModelRenderer Balloon1;
    ModelRenderer Balloon2;
    ModelRenderer Balloon3;
    ModelRenderer RopeFL;
    ModelRenderer RopeFR;
    ModelRenderer RopeBL;
    ModelRenderer RopeBR;
    ModelRenderer BaseWoodFloor;
    ModelRenderer BaseWoodChest;

    public ModelV1_Airship_Balloon()
    {
        this( 0.0f );
    }

    public ModelV1_Airship_Balloon( float par1 )
    {
        Balloon1 = new ModelRenderer( this, 0, 0 );
        Balloon1.setTextureSize( 512, 256 );
        Balloon1.addBox( 0F, 0F, 0F, 32, 32, 32);
        Balloon1.setRotationPoint( -16F, -52F, -16F );
        Balloon2 = new ModelRenderer( this, 0, 64 );
        Balloon2.setTextureSize( 512, 256 );
        Balloon2.addBox( 0F, 0F, 0F, 30, 30, 38);
        Balloon2.setRotationPoint( -15F, -51F, -19F );
        Balloon3 = new ModelRenderer( this, 0, 132 );
        Balloon3.setTextureSize( 512, 256 );
        Balloon3.addBox( 0F, 0F, 0F, 26, 26, 44);
        Balloon3.setRotationPoint( -13F, -49F, -22F );
        RopeFL = new ModelRenderer( this, 492, 0 );
        RopeFL.setTextureSize( 512, 256 );
        RopeFL.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeFL.setRotationPoint( 12.5F, -21F, -13F );
        RopeFR = new ModelRenderer( this, 500, 0 );
        RopeFR.setTextureSize( 512, 256 );
        RopeFR.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeFR.setRotationPoint( -13.5F, -21F, -13F );
        RopeBL = new ModelRenderer( this, 500, 0 );
        RopeBL.setTextureSize( 512, 256 );
        RopeBL.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeBL.setRotationPoint( 12.5F, -21F, 12F );
        RopeBR = new ModelRenderer( this, 508, 0 );
        RopeBR.setTextureSize( 512, 256 );
        RopeBR.addBox( 0F, 0F, 0F, 1, 23, 1);
        RopeBR.setRotationPoint( -13.5F, -21F, 12F );
        BaseWoodFloor = new ModelRenderer( this, 436, 0 );
        BaseWoodFloor.setTextureSize( 512, 256 );
        BaseWoodFloor.addBox( 0F, 0F, 0F, 14, 0, 24);
        BaseWoodFloor.setRotationPoint( -7F, 5F, -12F );
        BaseWoodChest = new ModelRenderer( this, 452, 24 );
        BaseWoodChest.setTextureSize( 512, 256 );
        BaseWoodChest.addBox( 0F, 0F, 0F, 10, 2, 8);
        BaseWoodChest.setRotationPoint( -5F, 4F, 3F );
    }

   public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
   {
        Balloon1.rotateAngleX = 0F;
        Balloon1.rotateAngleY = 0F;
        Balloon1.rotateAngleZ = 0F;
        Balloon1.renderWithRotation(par7);

        Balloon2.rotateAngleX = 0F;
        Balloon2.rotateAngleY = 0F;
        Balloon2.rotateAngleZ = 0F;
        Balloon2.renderWithRotation(par7);

        Balloon3.rotateAngleX = 0F;
        Balloon3.rotateAngleY = 0F;
        Balloon3.rotateAngleZ = 0F;
        Balloon3.renderWithRotation(par7);

        RopeFL.rotateAngleX = 0.1658063F;
        RopeFL.rotateAngleY = 9.843647E-10F;
        RopeFL.rotateAngleZ = 0.2094395F;
        RopeFL.renderWithRotation(par7);

        RopeFR.rotateAngleX = 0.1658063F;
        RopeFR.rotateAngleY = -9.843647E-10F;
        RopeFR.rotateAngleZ = -0.2094395F;
        RopeFR.renderWithRotation(par7);

        RopeBL.rotateAngleX = -0.1658063F;
        RopeBL.rotateAngleY = -9.843647E-10F;
        RopeBL.rotateAngleZ = 0.2094395F;
        RopeBL.renderWithRotation(par7);

        RopeBR.rotateAngleX = -0.1658063F;
        RopeBR.rotateAngleY = 9.843647E-10F;
        RopeBR.rotateAngleZ = -0.2094395F;
        RopeBR.renderWithRotation(par7);

        BaseWoodFloor.rotateAngleX = 0F;
        BaseWoodFloor.rotateAngleY = 0F;
        BaseWoodFloor.rotateAngleZ = 0F;
        BaseWoodFloor.renderWithRotation(par7);

        BaseWoodChest.rotateAngleX = 0F;
        BaseWoodChest.rotateAngleY = 0F;
        BaseWoodChest.rotateAngleZ = 0F;
        BaseWoodChest.renderWithRotation(par7);

    }

}
