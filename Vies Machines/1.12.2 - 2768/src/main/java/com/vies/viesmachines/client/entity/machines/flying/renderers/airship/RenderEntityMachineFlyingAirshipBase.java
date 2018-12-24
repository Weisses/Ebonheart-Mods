package com.vies.viesmachines.client.entity.machines.flying.renderers.airship;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.entity.machines.base.ModelMachineControlPanel;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.ModelAirshipFrameDisplayBannerStand;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.ModelAirshipFrameSkids;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.ModelAirshipPropeller;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent2Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent2Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent3Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent3Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent4Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.component.ModelAirshipComponent4Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine2Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.engine.ModelAirshipEngine2Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame0Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame0Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame1Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame1Secondary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame2Primary;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.frame.ModelAirshipFrame2Secondary;
import com.vies.viesmachines.client.entity.model.head.ModelChickenHead;
import com.vies.viesmachines.client.entity.model.head.ModelCowHead;
import com.vies.viesmachines.client.entity.model.head.ModelPigHead;
import com.vies.viesmachines.client.entity.model.head.ModelSpiderHead;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragonHead;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityHanging;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderEntityMachineFlyingAirshipBase extends RenderLiving<EntityMachineFlyingAirship> {
	
	protected ModelBase modelAirshipSkids = new ModelAirshipFrameSkids();
	
	protected ModelBase modelAirshipFrameDisplayBannerStand = new ModelAirshipFrameDisplayBannerStand();
	
	protected ModelBase modelMachineControlPanel = new ModelMachineControlPanel();

	protected ModelBase modelAirshipPropeller = new ModelAirshipPropeller();
  	
	protected ModelBase modelAirshipFrame0Primary = new ModelAirshipFrame0Primary();
	protected ModelBase modelAirshipFrame0Secondary = new ModelAirshipFrame0Secondary();
	protected ModelBase modelAirshipFrame1Primary = new ModelAirshipFrame1Primary();
	protected ModelBase modelAirshipFrame1Secondary = new ModelAirshipFrame1Secondary();
	protected ModelBase modelAirshipFrame2Primary = new ModelAirshipFrame2Primary();
	protected ModelBase modelAirshipFrame2Secondary = new ModelAirshipFrame2Secondary();
	
	protected ModelBase modelAirshipEngine0Primary = new ModelAirshipEngine0Primary();
	protected ModelBase modelAirshipEngine0Secondary = new ModelAirshipEngine0Secondary();
	protected ModelBase modelAirshipEngine1Primary = new ModelAirshipEngine1Primary();
	protected ModelBase modelAirshipEngine1Secondary = new ModelAirshipEngine1Secondary();
	protected ModelBase modelAirshipEngine2Primary = new ModelAirshipEngine2Primary();
	protected ModelBase modelAirshipEngine2Secondary = new ModelAirshipEngine2Secondary();
	
	protected ModelBase modelAirshipComponent0Primary = new ModelAirshipComponent0Primary();
	protected ModelBase modelAirshipComponent0Secondary = new ModelAirshipComponent0Secondary();
	protected ModelBase modelAirshipComponent1Primary = new ModelAirshipComponent1Primary();
	protected ModelBase modelAirshipComponent1Secondary = new ModelAirshipComponent1Secondary();
	protected ModelBase modelAirshipComponent2Primary = new ModelAirshipComponent2Primary();
	protected ModelBase modelAirshipComponent2Secondary = new ModelAirshipComponent2Secondary();
	protected ModelBase modelAirshipComponent3Primary = new ModelAirshipComponent3Primary();
	protected ModelBase modelAirshipComponent3Secondary = new ModelAirshipComponent3Secondary();
	protected ModelBase modelAirshipComponent4Primary = new ModelAirshipComponent4Primary();
	protected ModelBase modelAirshipComponent4Secondary = new ModelAirshipComponent4Secondary();
	
  	protected ModelBase currentModelFramePrimary;
  	protected ModelBase currentModelFrameSecondary;
  	protected ModelBase currentModelEnginePrimary;
  	protected ModelBase currentModelEngineSecondary;
  	protected ModelBase currentModelComponentPrimary;
  	protected ModelBase currentModelComponentSecondary;
	
    private final ModelDragonHead dragonHead = new ModelDragonHead(0.0F);
    private final ModelSkeletonHead skeletonHead = new ModelSkeletonHead(0, 0, 64, 32);
    private final ModelSkeletonHead humanoidHead = new ModelHumanoidHead();
    private final ModelChickenHead chickenHead = new ModelChickenHead();
    private final ModelPigHead pigHead = new ModelPigHead();
    private final ModelCowHead cowHead = new ModelCowHead();
    private final ModelSpiderHead spiderHead = new ModelSpiderHead();
    
    private static final ModelSkeletonHead humanoidHead1 = new ModelHumanoidHead();
    
    protected float baseitemSpin;
	
    
    
	//==================================================
    // TODO             Constructor
	//==================================================
	
	public RenderEntityMachineFlyingAirshipBase(RenderManager rendermanagerIn, ModelBase modelbaseIn, float shadowsizeIn)
    {
        super(rendermanagerIn, modelbaseIn, shadowsizeIn);
    }
	
	
	
	//==================================================
    // TODO         Overrides in Renderer
	//==================================================
    
	public void setupRotation(EntityMachineFlyingAirship entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }
    
    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F + 0.25F, (float)p_188309_5_);
    }
    
    @Override
    protected ResourceLocation getEntityTexture(EntityMachineFlyingAirship entity)
    {
        return null;
    }
    
    @Override
    public boolean shouldRender(EntityMachineFlyingAirship livingEntity, ICamera camera, double camX, double camY, double camZ)
    {
        if (super.shouldRender(livingEntity, camera, camX, camY, camZ))
        {
            return true;
        }
        else if (livingEntity.getLeashed() && livingEntity.getLeashHolder() != null)
        {
            Entity entity = livingEntity.getLeashHolder();
            return camera.isBoundingBoxInFrustum(entity.getRenderBoundingBox());
        }
        else
        {
            return false;
        }
    }
    
    private double interpolateValue(double start, double end, double pct)
    {
        return start + (end - start) * pct;
    }
    
    @Override
    protected void renderLeash(EntityMachineFlyingAirship entityLivingIn, double x, double y, double z, float entityYaw, float partialTicks)
    {
        Entity entity = entityLivingIn.getLeashHolder();

        if (entity != null)
        {
            y = y - (1.6D - (double)entityLivingIn.height) * 0.5D;
            Tessellator tessellator = Tessellator.getInstance();
            BufferBuilder bufferbuilder = tessellator.getBuffer();
            double d0 = this.interpolateValue((double)entity.prevRotationYaw, (double)entity.rotationYaw, (double)(partialTicks * 0.5F)) * 0.01745329238474369D;
            double d1 = this.interpolateValue((double)entity.prevRotationPitch, (double)entity.rotationPitch, (double)(partialTicks * 0.5F)) * 0.01745329238474369D;
            double d2 = Math.cos(d0);
            double d3 = Math.sin(d0);
            double d4 = Math.sin(d1);

            if (entity instanceof EntityHanging)
            {
                d2 = 0.0D;
                d3 = 0.0D;
                d4 = -1.0D;
            }

            double d5 = Math.cos(d1);
            double d6 = this.interpolateValue(entity.prevPosX, entity.posX, (double)partialTicks) - d2 * 0.7D - d3 * 0.5D * d5;
            double d7 = this.interpolateValue(entity.prevPosY + (double)entity.getEyeHeight() * 0.7D, entity.posY + (double)entity.getEyeHeight() * 0.7D, (double)partialTicks) - d4 * 0.5D - 0.25D;
            double d8 = this.interpolateValue(entity.prevPosZ, entity.posZ, (double)partialTicks) - d3 * 0.7D + d2 * 0.5D * d5;
            double d9 = this.interpolateValue((double)entityLivingIn.prevRenderYawOffset, (double)entityLivingIn.renderYawOffset, (double)partialTicks) * 0.01745329238474369D + (Math.PI / 2D);
            d2 = Math.cos(d9) * (double)entityLivingIn.width * 0.4D;
            d3 = Math.sin(d9) * (double)entityLivingIn.width * 0.4D;
            double d10 = this.interpolateValue(entityLivingIn.prevPosX, entityLivingIn.posX, (double)partialTicks) + d2;
            double d11 = this.interpolateValue(entityLivingIn.prevPosY, entityLivingIn.posY, (double)partialTicks);
            double d12 = this.interpolateValue(entityLivingIn.prevPosZ, entityLivingIn.posZ, (double)partialTicks) + d3;
            x = x + d2;
            z = z + d3;
            double d13 = (double)((float)(d6 - d10));
            double d14 = (double)((float)(d7 - d11));
            double d15 = (double)((float)(d8 - d12));
            GlStateManager.disableTexture2D();
            GlStateManager.disableLighting();
            GlStateManager.disableCull();
            int i = 24;
            double d16 = 0.025D;
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for (int j = 0; j <= 24; ++j)
            {
                float f = 0.5F;
                float f1 = 0.4F;
                float f2 = 0.3F;

                if (j % 2 == 0)
                {
                    f *= 0.7F;
                    f1 *= 0.7F;
                    f2 *= 0.7F;
                }

                float f3 = (float)j / 24.0F;
                bufferbuilder.pos(x + d13 * (double)f3 + 0.0D, y + d14 * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)j) / 18.0F + 0.125F), z + d15 * (double)f3).color(f, f1, f2, 1.0F).endVertex();
                bufferbuilder.pos(x + d13 * (double)f3 + 0.025D, y + d14 * (double)(f3 * f3 + f3) * 0.5D + (double)((24.0F - (float)j) / 18.0F + 0.125F) + 0.025D, z + d15 * (double)f3).color(f, f1, f2, 1.0F).endVertex();
            }

            tessellator.draw();
            bufferbuilder.begin(5, DefaultVertexFormats.POSITION_COLOR);

            for (int k = 0; k <= 24; ++k)
            {
                float f4 = 0.5F;
                float f5 = 0.4F;
                float f6 = 0.3F;

                if (k % 2 == 0)
                {
                    f4 *= 0.7F;
                    f5 *= 0.7F;
                    f6 *= 0.7F;
                }

                float f7 = (float)k / 24.0F;
                bufferbuilder.pos(x + d13 * (double)f7 + 0.0D, y + d14 * (double)(f7 * f7 + f7) * 0.5D + (double)((24.0F - (float)k) / 18.0F + 0.125F) + 0.025D, z + d15 * (double)f7).color(f4, f5, f6, 1.0F).endVertex();
                bufferbuilder.pos(x + d13 * (double)f7 + 0.025D, y + d14 * (double)(f7 * f7 + f7) * 0.5D + (double)((24.0F - (float)k) / 18.0F + 0.125F), z + d15 * (double)f7 + 0.025D).color(f4, f5, f6, 1.0F).endVertex();
            }

            tessellator.draw();
            GlStateManager.enableLighting();
            GlStateManager.enableTexture2D();
            GlStateManager.enableCull();
        }
    }
    
    /** Disables the overhead generic Minecraft name logic. */
    @Override
    protected boolean canRenderName(EntityMachineFlyingAirship entity)
    {
        return false;//super.canRenderName(entity) && (entity.getAlwaysRenderNameTagForRender() || entity.hasCustomName() && entity == this.renderManager.pointedEntity);
    }
    
	
    
	//==================================================
    // TODO           Item Display Logic
	//==================================================
    
	/** Renders a symbol. */
    protected void renderSymbol(EntityMachineFlying airshipIn, ItemStack itemstackIn, int locationIn)
    {
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        {
        	// Other logic to go here:
        	
        	// Display Banner frame positioning:
	    	GlStateManager.pushMatrix();
	    	{
		    	// Positioning:
	    		GlStateManager.translate(-0.375F, -0.0675F, -0.8125F);
		    	// Scaling:
		    	GlStateManager.scale(0.3F, 0.3F, 0.3F);
		    	
	            //Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            //Flips on the Y axis
	            GlStateManager.rotate(270, 0.0F, 1.0F, 0.0F);
		    	
	            // Spins Block/Item:
		        GlStateManager.rotate(this.baseitemSpin * 5, 0F, 1F, 0F);
		        
		        // Renders the Block/Item:
		        Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	    	}
	        GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }
    
    /** Renders a block/item. */
    protected void renderBlockItem(EntityMachineFlying airshipIn, ItemStack itemstackIn, int locationIn)
    {
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        {	
	        // Other logic to go here:
	        
	        // Display Banner frame positioning:
	    	GlStateManager.pushMatrix();
	    	{
	    		// Is this a block?
		    	if(itemstackIn.getItem() instanceof ItemBlock)
				{
		    		GlStateManager.translate(-0.375F, 0F, -0.8125F);
		        	GlStateManager.scale(0.5F, 0.5F, 0.5F);
				}
	        	else
	        	{
	    	    	GlStateManager.translate(-0.375F, -0.062F, -0.8125F);
	            	GlStateManager.scale(0.25F, 0.25F, 0.25F);
	        	}
		    	
	            // Flips the model right side up:
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            // Flips on the Y axis:
	            GlStateManager.rotate(270, 0.0F, 1.0F, 0.0F);
		    	
		        // Spins Block/Item:
		        GlStateManager.rotate(this.baseitemSpin * 5, 0F, 1F, 0F);
		        
		        // Renders the Block/Item:
		        Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	    	}
	        GlStateManager.popMatrix();
        }
        GlStateManager.popMatrix();
    }
    
    /** Renders an entity head. */
    protected void renderEntityHead(int skullType, float posX, float posY, float posZ, int locationIn)
    {
        ModelBase modelbase = this.skeletonHead;

        switch(skullType)
		{
		    case 0:
		    default:
		        this.bindTexture(References.STEVE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 1:
		        this.bindTexture(References.STEVE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 2:
		        this.bindTexture(References.ALEX_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 3:
		        this.bindTexture(References.CHICKEN_TEXTURES);
		        modelbase = this.chickenHead;
		        break;
		    case 4:
		        this.bindTexture(References.PIG_TEXTURES);
		        modelbase = this.pigHead;
		        break;
		    case 5:
		        this.bindTexture(References.COW_TEXTURES);
		        modelbase = this.cowHead;
		        break;
		    case 6:
		        this.bindTexture(References.ZOMBIE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 7:
		        this.bindTexture(References.SKELETON_TEXTURES);
		        break;
		    case 8:
		        this.bindTexture(References.SPIDER_TEXTURES);
		        modelbase = this.spiderHead;
		        break;
		    case 9:
		        this.bindTexture(References.CREEPER_TEXTURES);
		        break;
		    case 10:
		        this.bindTexture(References.WITHER_SKELETON_TEXTURES);
		        break;
		    case 11:
		    	this.bindTexture(References.DRAGON_TEXTURES);
		        modelbase = this.dragonHead;
		        break;
		    case 12:
		        this.bindTexture(References.HEROBRINE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		}
        
        GlStateManager.pushMatrix();
        {
        	// Needed to fix the texture overlap clipping:
        	GlStateManager.disableCull();
	        
        	// May not be needed?!?
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        // Other logic to go here:
	        
	        // Display Banner frame positioning :
	    	GlStateManager.pushMatrix();
	        {
		    	// Dragon Entity Head special positioning:
		    	if(skullType == 11)
		    	{
		    		GlStateManager.scale(0.55, 0.55, 0.55);
		    		GlStateManager.translate(-0.3F, -0.03F, -0.65F);
		    	}
		    	
		    	// Positioning:
		    	GlStateManager.translate(-0.375F, -0.03F, -0.8125F);
		    	// Scaling:
		    	GlStateManager.scale(0.25F, 0.25F, 0.25F);
		        
		        // Spins Entity Head:
		        GlStateManager.rotate(-this.baseitemSpin * 5, 0F, 1F, 0F);
		        
		        // Renders the Entity Head:
		        modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        }
	        GlStateManager.popMatrix();
	        
	        // Need to remove the texture overlap clipping fix at the end.
	    	GlStateManager.enableCull();
	        
	    	// Need to remove the texture overlap clipping fix at the end. Maybe!?!?
	    	GlStateManager.disableRescaleNormal();
	        GlStateManager.disableAlpha();
        } 
        GlStateManager.popMatrix();
    }
    
    //TODO Supporter Heads add here!
	/** Renders a supporter head. */
    protected void renderSupporterHead(int skullType, float posX, float posY, float posZ, int locationIn)
    {
        ModelBase modelbase = this.humanoidHead;

        switch (skullType)
		{
		    case 0:
		    default:
		        this.bindTexture(References.SUPPORTER_VIES_TEXTURES);
		        break;
		    case 1:
		        this.bindTexture(References.SUPPORTER_VIES_TEXTURES);
		        break;
		    case 2:
		        this.bindTexture(References.SUPPORTER_SOULFORGE7_TEXTURES);
		        break;
		    case 3:
		        this.bindTexture(References.SUPPORTER_NEMANOR_TEXTURES);
		        break;
		    case 4:
		        this.bindTexture(References.SUPPORTER_VELOURVAULTSUIT_TEXTURES);
		        break;
		}

        GlStateManager.pushMatrix();
        {
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        // Other logic to go here:
	        
	        // Display Banner frame positioning :
	    	GlStateManager.pushMatrix();
	        {
		    	// Positioning:
	        	GlStateManager.translate(-0.375F, -0.03F, -0.8125F);
	        	// Scaling:
		    	GlStateManager.scale(0.25F, 0.25F, 0.25F);
		        
		    	// Spins Supporter Head:
		    	GlStateManager.rotate(-this.baseitemSpin * 5, 0F, 1F, 0F);
		        
		    	// Renders the Supporter Head:
		        modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        }
	        GlStateManager.popMatrix();
	        
	        // Need to remove the texture overlap clipping fix at the end.
	    	GlStateManager.enableCull();
	        
	    	// Need to remove the texture overlap clipping fix at the end. Maybe!?!?
	    	GlStateManager.disableRescaleNormal();
	        GlStateManager.disableAlpha();
        }
        GlStateManager.popMatrix();
        
        //This rotates something like a planet!!! So freaking cool!
        /**
        if(locationIn == 3)
        {
        	GlStateManager.scale(0.25F, 0.25F, 0.25F);
            GlStateManager.translate(-1.25F, 0.25F, -3.25F);
            
            float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
            
            //Spins Item
            GlStateManager.rotate(-itemSpin * 2, 0F, 1F, 0F);
        }
        
        if(locationIn == 3)
        {
        	GlStateManager.scale(0.25F, 0.25F, 0.25F);
            GlStateManager.translate(-1.25F, 0.25F, -3.25F);
            
            float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
            
            //Spins Item
            GlStateManager.rotate(-itemSpin * 2, 0F, 1F, 0F);
        }
        
        modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
        
        GlStateManager.popMatrix();*/
    }
    
    /** Main wrapper for the Engine Display system. */
    protected void renderEngineDisplaySymbol(EntityMachineFlying airshipIn, float partialTicks)
    {
    	// Displays the Block/Item:
    	if(airshipIn.getVisualEngineDisplayType() == 1)
    	{
    		this.renderBlockItem(airshipIn, new ItemStack(Item.getItemById(airshipIn.getVisualEngineDisplayItemstack()), 1, airshipIn.getVisualEngineDisplayItemstackMeta()), airshipIn.getVisualModelComponent());
    	}
    	// Displays the Entity Head:
    	else if(airshipIn.getVisualEngineDisplayType() == 2)
    	{
    		this.renderEntityHead(airshipIn.getVisualEngineDisplayHead(), 0, 0, 0, airshipIn.getVisualModelComponent());
    	}
    	// Displays the Supporter Head:
    	else if(airshipIn.getVisualEngineDisplayType() == 3)
    	{
    		this.renderSupporterHead(airshipIn.getVisualEngineDisplaySupporterHead(), 0, 0, 0, airshipIn.getVisualModelComponent());
    	}
    	// Displays the Holiday:
    	else if(airshipIn.getVisualEngineDisplayType() == 4)
    	{
    		//this.renderItemOnDisplaySpin((float)0, (float)1, (float)1, 2);//.engineDisplayHeadVisual);
    	}
    	// Displays the Holiday Symbols:
    	else if (airshipIn.getVisualEngineDisplayType() >= 1000)
    	{
    		this.renderSymbol(airshipIn, EnumsVM.VisualDisplaySymbolHoliday.byId(airshipIn.getVisualEngineDisplayType() - 1000).getItemStack(), airshipIn.getVisualModelComponent());
    	}
    	// Displays the Symbols:
    	else if (airshipIn.getVisualEngineDisplayType() >= 10
    	&& airshipIn.getVisualEngineDisplayType() <= EnumsVM.VisualDisplaySymbol.values().length + 10)
    	{
    		this.renderSymbol(airshipIn, EnumsVM.VisualDisplaySymbol.byId(airshipIn.getVisualEngineDisplayType() - 10).getItemStack(), airshipIn.getVisualModelComponent());
    	}
    }
    
    /** Renders the particles. Currently unused. */
    protected void renderEngineParticles(EntityMachineFlying entity, int particleActive)
    {
    	GlStateManager.pushMatrix();
    	
    	if(!Minecraft.getMinecraft().isGamePaused())
		{
	    	int randomTick = References.random.nextInt(100) + 1;
	    	
	        //Default = No particle
	        if(particleActive == 0)
	        {
	        	
	        }
	        //Runes
	        if(particleActive == 1)
	        {
	        	//InitParticlesVCRender.generateParticleRunesNormal(entity);
	        }
	        //Rainbow Runes
	        if(particleActive == 2)
	        {
	        	//InitParticlesVCRender.generateParticleRunesRainbow(entity);
	        }
	        //Flames
	        if(particleActive == 3)
	        {
	        	if(randomTick < 20)
				{
	        		//InitParticlesVCRender.generateParticleFlamesNormal(entity);
				}
	        }
	        //Rainbow Flames
	        if(particleActive == 4)
	        {
	        	if(randomTick < 20)
				{
	        		//nitParticlesVCRender.generateParticleFlamesColor(entity);
				}
	        }
    	}
        GlStateManager.popMatrix();
    }
    
    
    
	//==================================================
    // TODO             Custom Logic
	//==================================================
    
    /** Gets the Font Renderer. */
    protected FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
    
    /** Renders all of the machine info over the entity. */
    protected void renderMachineInfo(EntityMachineFlyingAirship entity)
    {
    	if(entity.isBeingRidden())
        {
        	
        }
        else
        {
        	EntityPlayerSP playerIn = Minecraft.getMinecraft().player;
        	float prevAirshipYaw = playerIn.rotationYaw;
        	float nameplateYaw = (prevAirshipYaw%360) - entity.rotationYaw;
        	Entity raytraceHitTarget = Minecraft.getMinecraft().objectMouseOver.entityHit;
        	
        	if (raytraceHitTarget instanceof EntityMachineBase)
        	{
        		if(raytraceHitTarget == entity)
        		{
        			if (!playerIn.isSneaking())
		    		{
        				// Explosion vulnerability warning:
        				if (entity.getBroken())
        				{
        					GlStateManager.pushMatrix();
    	    		    	{
    	    		    		GlStateManager.scale(0.75F, 0.75F, 0.75F);
    	    		    		GlStateManager.rotate(180, 1, 0, 0);
    	    		    		
    	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.RED + this.stringToFlashGolden("* WARNING - Vulnerable to Explosions! *", 0, false, TextFormatting.DARK_RED, 1), 0F, 1.40F, 0F, 0, nameplateYaw, 0F, false, false);
    	    		        }
    	    		    	GlStateManager.popMatrix();
        				}
        				// Custom Name:
	        			GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.75F, 0.75F, 0.75F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), EnumsVM.SelectColor.byId(entity.getVisualNameColor()).getTextColor() + entity.getCustomNameTag(), 0F, 1.07F, 0F, 0, nameplateYaw, 0F, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
	    		    	
	    		    	if (entity.getBroken())
	    		    	{
	    		    		GlStateManager.pushMatrix();
	    		    		{
	    		    			GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    		    			GlStateManager.rotate(180, 1, 0, 0);
	    		    			
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.DARK_RED + "!!! Broken !!!", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		GlStateManager.popMatrix();
	    		    	}
	    		    	else
	    		    	{
	    		    		this.renderFuelGauge(entity, nameplateYaw);
	    		    	}
    		    		
	    		    	// Health and Energy and Shift info:
	    		    	GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		TextFormatting healthColor = TextFormatting.RED;
	    		    		TextFormatting energyColor = TextFormatting.YELLOW;
	    		    		TextFormatting durabilityColor = TextFormatting.GREEN;
	    		    		
	    		    		if (entity.getHealth() == 0)
	    		    		{
	    		    			healthColor = TextFormatting.DARK_RED;
	    		    		}
	    		    		if (entity.getEnergy() == 0)
	    		    		{
	    		    			energyColor = TextFormatting.DARK_RED;
	    		    		}
	    		    		if (entity.getDurability() == 0)
	    		    		{
	    		    			durabilityColor = TextFormatting.DARK_RED;
	    		    		}
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), healthColor + "Health : " + TextFormatting.WHITE + (int)entity.getHealth() + " (" + this.getColorTextHealth(entity) + entity.getHealthPercent() + "%" + TextFormatting.WHITE + ")", 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), energyColor + "Energy : " + TextFormatting.WHITE + entity.getEnergy() + " (" + this.getColorTextEnergy(entity) + entity.getEnergyPercent() + "%" + TextFormatting.WHITE + ")", 0F, 0.75F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), durabilityColor + "Durability : " + TextFormatting.WHITE + entity.getDurability() + " (" + this.getColorTextDurability(entity) + entity.getDurabilityPercent() + "%" + TextFormatting.WHITE + ")", 0F, 0.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
		    		}
		    		else
		    		{
		    			// Health and Energy and Shift info:
	    		    	GlStateManager.pushMatrix();
	    		    	{
	    		    		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	    		    		GlStateManager.rotate(180, 1, 0, 0);
	    		    		
	    		    		String ammoType = "Standard";
	    		    		
	    		    		TextFormatting colorForUse = TextFormatting.YELLOW;
	    		    		
	    		    		
	    		    		
	    		    		if (entity.getAmmoType() == 1)
	    		    		{
	    		    			ammoType = "Electrical";
	    		    		}
	    		    		if (entity.getAmmoType() == 2)
	    		    		{
	    		    			ammoType = "Explosive";
	    		    		}
	    		    		
	    		    		// Frame info:
	    		    		if (entity.getTierFrame() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Frame : " + TextFormatting.GRAY + "None", 0F, 1.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierFrame() == 1)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Frame : " + TextFormatting.YELLOW + "Tier " + entity.getTierFrame(), 0F, 1.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierFrame() == 2)
	    		    		{
    		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Frame : " + TextFormatting.AQUA + "Tier " + entity.getTierFrame(), 0F, 1.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Frame : " + TextFormatting.LIGHT_PURPLE + "Tier " + entity.getTierFrame(), 0F, 1.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		
	    		    		// Engine info:
	    		    		if (entity.getTierEngine() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Engine : " + TextFormatting.GRAY + "None", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierEngine() == 1)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Engine : " + TextFormatting.YELLOW + "Tier " + entity.getTierEngine(), 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierEngine() == 2)
	    		    		{
    		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Engine : " + TextFormatting.AQUA + "Tier " + entity.getTierEngine(), 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Engine : " + TextFormatting.LIGHT_PURPLE + "Tier " + entity.getTierEngine(), 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		
	    		    		// Component info:
	    		    		if (entity.getTierComponent() == 0)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Component : " + TextFormatting.GRAY + "None", 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierComponent() == 1)
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Component : " + TextFormatting.YELLOW + "Tier " + entity.getTierComponent(), 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else if (entity.getTierComponent() == 2)
	    		    		{
    		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Component : " + TextFormatting.AQUA + "Tier " + entity.getTierComponent(), 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		else
	    		    		{
	    		    			EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Component : " + TextFormatting.LIGHT_PURPLE + "Tier " + entity.getTierComponent(), 0F, 1.00F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		}
	    		    		
	    		    		// Ammo Type info:
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Ammo Type : " + TextFormatting.WHITE  + ammoType, 0F, 0.75F, 0F, 0, nameplateYaw, 0F, false, false);
	    		    		
	    		    		// Ammo Amount info:
	    		    		EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.BLUE + "Ammo Amount : " + TextFormatting.WHITE  + entity.getAmmoAmount() + "/" + EnumsVM.FlyingMachineComponentTier.byId(entity.getTierComponent()).getMaxAmmoModifier(), 0F, 0.50F, 0F, 0, nameplateYaw, 0F, false, false);
	    		        }
	    		    	GlStateManager.popMatrix();
		    		}
        		}
        	}
        }
    }
    
    /** Fuel bar name plate logic. */
    protected void renderFuelGauge(EntityMachineFlyingAirship entity, float nameplateYaw)
    {
    	// Render airship fuel bar:
    	GlStateManager.pushMatrix();
		{
			int percentFive = (int) (entity.getFuelTotal() * 0.05);
    		
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.rotate(180, 1, 0, 0);
			
			if(entity.getFuel() == 0)
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "          "+ "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 19))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||||||||" + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 18))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "|||||||||||||||||| " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 17))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||||  " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 16))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA+ "||||||||||||||||||||" + "||||||||||||||   " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 15))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||||||    " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 14))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||||     " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 13))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||||      " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 12))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN+ "||||||||||||||||||||" + "||||||       " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 11))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW+ "||||||||||||||||||||" + "||||        " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 10))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW+ "||||||||||||||||||||" + "||         " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 9))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "||||||||||||||||||||" + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 8))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "|||||||||||||||||| " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 7))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||||||  " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 6))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||||   " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 5))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||||    " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 4))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||||     " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 3))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||||||      " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 2))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||||       " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 1))
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||        " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
			else if(entity.getFuel() >= (percentFive * 0) + 1)
			{
				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||         " + "          " + TextFormatting.WHITE + "]", 0F, 1.25F, 0F, 0, nameplateYaw, 0F, false, false);
			}
		}
		GlStateManager.popMatrix();
    }
    
    /** Returns the correct Primary Frame to render based on getVisualModelFrame(). */
    protected ModelBase getCurrentModelAirshipFramePrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelFrame())
    	{
	    	case 0:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame0Primary;
	    	case 1:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame1Primary;
	    	case 2:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame2Primary;
	    	default:
	    		return this.currentModelFramePrimary = this.modelAirshipFrame0Primary;
    	}
    }
    /** Returns the correct Secondary Frame to render based on getVisualModelFrame(). */
    protected ModelBase getCurrentModelAirshipFrameSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelFrame())
    	{
	    	case 0:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame0Secondary;
	    	case 1:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame1Secondary;
	    	case 2:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame2Secondary;
	    	default:
	    		return this.currentModelFrameSecondary = this.modelAirshipFrame0Secondary;
    	}
    }
    
    /** Returns the correct Primary Engine to render based on getVisualModelEngine(). */
    protected ModelBase getCurrentModelAirshipEnginePrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelEngine())
    	{
	    	case 0:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine0Primary;
	    	case 1:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine1Primary;
	    	case 2:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine2Primary;
	    	default:
	    		return this.currentModelEnginePrimary = this.modelAirshipEngine0Primary;
    	}
    }
    /** Returns the correct Secondary Engine to render based on getVisualModelEngine(). */
    protected ModelBase getCurrentModelAirshipEngineSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelEngine())
    	{
	    	case 0:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine0Secondary;
	    	case 1:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine1Secondary;
	    	case 2:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine2Secondary;
	    	default:
	    		return this.currentModelEngineSecondary = this.modelAirshipEngine0Secondary;
    	}
    }
    
    /** Returns the correct Primary Component to render based on getVisualModelComponent(). */
    protected ModelBase getCurrentModelAirshipComponentPrimary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelComponent())
    	{
	    	case 0:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent0Primary;
	    	case 1:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent1Primary;
	    	case 2:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent2Primary;
	    	case 3:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent3Primary;
	    	case 4:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent4Primary;
	    	default:
	    		return this.currentModelComponentPrimary = this.modelAirshipComponent0Primary;
    	}
    }
    /** Returns the correct Secondary Component to render based on getVisualModelComponent(). */
    protected ModelBase getCurrentModelAirshipComponentSecondary(EntityMachineFlyingAirship airshipIn)
    {
    	switch(airshipIn.getVisualModelComponent())
    	{
	    	case 0:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent0Secondary;
	    	case 1:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent1Secondary;
	    	case 2:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent2Secondary;
	    	case 3:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent3Secondary;
	    	case 4:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent4Secondary;
	    	default:
	    		return this.currentModelComponentSecondary = this.modelAirshipComponent0Secondary;
    	}
    }
    
	/** Makes the inserted string flash. */
	protected static String stringToFlashGolden(String parString, int parShineLocation, boolean parReturnToBlack, TextFormatting colorIn, int colorTypeIn)
	{
		int stringLength = parString.length();
		
		TextFormatting color1 = TextFormatting.WHITE;
		TextFormatting color2 = TextFormatting.YELLOW;
		
		if (colorTypeIn == 1)
		{
			color1 = TextFormatting.LIGHT_PURPLE;
			color2 = TextFormatting.DARK_PURPLE;
		}
		
		if(stringLength < 1)
		{
			return "";
		}
		
		String outputString = "";
		
		for(int i = 0; i < stringLength; i++)
		{
			if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 0)
			{
				outputString = outputString + color1 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 1)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 87)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else
			{
				outputString = outputString + colorIn + parString.substring(i, i + 1);        
			}
		}
		
		// Return color to a common one after (most chat is white, but for other GUI might want black):
		if(parReturnToBlack)
		{
			return outputString + TextFormatting.BLACK;
		}
		
		return outputString + TextFormatting.WHITE;
	}
	
	/** Health text color. */
	protected TextFormatting getColorTextHealth(EntityMachineFlyingAirship machine)
	{
		TextFormatting textColor = TextFormatting.WHITE;

		if (machine.getHealthPercent() <= 1)
		{
			textColor = TextFormatting.DARK_RED;
		}
		else if (machine.getHealthPercent() <= (100 * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (machine.getHealthPercent() <= (100 * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (machine.getHealthPercent() <= (100 * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (machine.getHealthPercent() <= (100 * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (machine.getHealthPercent() == 100)
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/** Energy text color. */
	protected TextFormatting getColorTextEnergy(EntityMachineFlyingAirship machine)
	{
		TextFormatting textColor = TextFormatting.WHITE;

		if (machine.getEnergyPercent() <= 1)
		{
			textColor = TextFormatting.DARK_RED;
		}
		else if (machine.getEnergyPercent() <= (100 * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (machine.getEnergyPercent() <= (100 * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (machine.getEnergyPercent() <= (100 * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (machine.getEnergyPercent() <= (100 * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (machine.getEnergyPercent() == 100)
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/** Durability text color. */
	protected TextFormatting getColorTextDurability(EntityMachineFlyingAirship machine)
	{
		TextFormatting textColor = TextFormatting.WHITE;
		
		if (machine.getDurabilityPercent() <= 1)
		{
			textColor = TextFormatting.DARK_RED;
		}
		else if (machine.getDurabilityPercent() <= (100 * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (machine.getDurabilityPercent() <= (100 * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (machine.getDurabilityPercent() <= (100 * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (machine.getDurabilityPercent() <= (100 * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (machine.getDurabilityPercent() == 100)
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/** This is the Control Panel Model for the Main Render Method. */
	protected void selectedModelControlPanel(EntityMachineFlying entityIn, float partialTicks)
    {
    	// Draws the Main Control Panel Screen:
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel.png"));
    	this.modelMachineControlPanel.render(entityIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
        // Control panel item renderer: (Frame)
        if(entityIn.getTierFrame() == 0)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025, -6.3225, new ItemStack(ItemsVM.MACHINE_FRAME, 1));
        }
        if(entityIn.getTierFrame() == 1)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025, -6.3225, new ItemStack(ItemsVM.UPGRADE_FRAME_TIER1, 1));
        }
        if(entityIn.getTierFrame() == 2)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025, -6.3225, new ItemStack(ItemsVM.UPGRADE_FRAME_TIER2, 1));
        }
        if(entityIn.getTierFrame() == 3)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025, -6.3225, new ItemStack(ItemsVM.UPGRADE_FRAME_TIER3, 1));
        }
        
        // Control panel item renderer: (Engine)
        if(entityIn.getTierEngine() == 0)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38, -6.3225 + 0.38, new ItemStack(ItemsVM.MACHINE_ENGINE, 1));
        }
        if(entityIn.getTierEngine() == 1)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38, -6.3225 + 0.38, new ItemStack(ItemsVM.UPGRADE_ENGINE_TIER1, 1));
        }
        if(entityIn.getTierEngine() == 2)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38, -6.3225 + 0.38, new ItemStack(ItemsVM.UPGRADE_ENGINE_TIER2, 1));
        }
        if(entityIn.getTierEngine() == 3)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38, -6.3225 + 0.38, new ItemStack(ItemsVM.UPGRADE_ENGINE_TIER3, 1));
        }
        
        // Control panel item renderer: (Component)
        if(entityIn.getTierComponent() == 0)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38 + 0.38, -6.3225 + 0.38 + 0.38, new ItemStack(ItemsVM.MACHINE_COMPONENT_FLYING, 1));
        }
        if(entityIn.getTierComponent() == 1)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38 + 0.38, -6.3225 + 0.38 + 0.38, new ItemStack(ItemsVM.UPGRADE_COMPONENT_TIER1, 1));
        }
        if(entityIn.getTierComponent() == 2)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38 + 0.38, -6.3225 + 0.38 + 0.38, new ItemStack(ItemsVM.UPGRADE_COMPONENT_TIER2, 1));
        }
        if(entityIn.getTierComponent() == 3)
        {
	        this.renderItemOnPanel(entityIn, 0.98, -0.6025 + 0.38 + 0.38, -6.3225 + 0.38 + 0.38, new ItemStack(ItemsVM.UPGRADE_COMPONENT_TIER3, 1));
        }
        
        // Control panel item renderer: (Fuel Slot)
        if(!entityIn.inventory.getStackInSlot(0).isEmpty())
        {
	        this.renderItemOnPanel(entityIn, 0.98-0.625, -0.6025 + 0.38 + 0.38, -6.3225 + 0.38 + 0.38, entityIn.inventory.getStackInSlot(0));
        }
    }
    
    /** Places an item on the control panel. */
	protected void renderItemOnPanel(EntityMachineFlying airshipIn, double posXIn, double posYIn, double posZIn, ItemStack itemstackIn)
    {
    	GlStateManager.pushMatrix();
    	{
	        if (itemstackIn.isEmpty())
			{
				return;
			}
	        
	        if (itemstackIn.getItem() instanceof ItemBlock)
	        {
	        	// Scaling:
	        	GlStateManager.scale(0.14, 0.14, 0.14);
	            // Positioning:
	        	GlStateManager.translate(posXIn, posYIn + 0.05, posZIn + 0.05);
	            
	            // Flips the model right side up:
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            // Flips on the X axis:
	            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
	            
	    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	        }
	        else
	        {
	        	// Scaling:
	        	GlStateManager.scale(0.14, 0.14, 0.14);
	        	// Positioning:
	            GlStateManager.translate(posXIn, posYIn, posZIn);
	            
	            // Flips the model right side up:
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            // Flips on the X axis:
	            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
	            
	            // Renders the Supporter Head:
		        Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	        }
    	}
		GlStateManager.popMatrix();
    }
    
	
	
}
