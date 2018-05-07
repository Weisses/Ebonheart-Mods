package com.viesis.viescraft.client.entity.render;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.entity.model.ModelAirshipPanel;
import com.viesis.viescraft.client.entity.model.ModelAirshipPropeller;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonBalloon0;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonBalloon1;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonBalloon2;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonBalloon3;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonBalloon4;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonDisplaySymbol0;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonDisplaySymbol1;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonDisplaySymbol2;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonDisplaySymbol3;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonDisplaySymbol4;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonFrame0;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonFrame1;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonFrame2;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonFrame3;
import com.viesis.viescraft.client.entity.model.balloon.ModelBalloonFrame4;
import com.viesis.viescraft.client.entity.model.engine.ModelEngine0;
import com.viesis.viescraft.client.entity.model.engine.ModelEngine1;
import com.viesis.viescraft.client.entity.model.engine.ModelEngine2;
import com.viesis.viescraft.client.entity.model.engine.ModelEngine3;
import com.viesis.viescraft.client.entity.model.engine.ModelEngine4;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame0;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame1;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame2;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame3;
import com.viesis.viescraft.client.entity.model.frame.ModelFrame4;
import com.viesis.viescraft.client.entity.model.head.ModelChickenHead;
import com.viesis.viescraft.client.entity.model.head.ModelCowHead;
import com.viesis.viescraft.client.entity.model.head.ModelPigHead;
import com.viesis.viescraft.client.entity.model.head.ModelSpiderHead;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelDragonHead;
import net.minecraft.client.model.ModelHumanoidHead;
import net.minecraft.client.model.ModelSkeletonHead;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirshipBase extends Render<EntityAirshipCore> {
	
	//Frames
  	protected ModelBase modelFrame0 = new ModelFrame0();
  	protected ModelBase modelFrame1 = new ModelFrame1();
  	protected ModelBase modelFrame2 = new ModelFrame2();
  	protected ModelBase modelFrame3 = new ModelFrame3();
  	protected ModelBase modelFrame4 = new ModelFrame4();
  	
  	//Engines
  	protected ModelBase modelEngine0 = new ModelEngine0();
  	protected ModelBase modelEngine1 = new ModelEngine1();
  	protected ModelBase modelEngine2 = new ModelEngine2();
  	protected ModelBase modelEngine3 = new ModelEngine3();
  	protected ModelBase modelEngine4 = new ModelEngine4();
  	
  	//Default Balloon
  	protected ModelBase modelBalloonF0 = new ModelBalloonFrame0();
  	protected ModelBase modelBalloonB0 = new ModelBalloonBalloon0();
  	protected ModelBase modelBalloonDS0 = new ModelBalloonDisplaySymbol0();
  		
  	//Viesdenburg Balloon
  	protected ModelBase modelBalloonF1 = new ModelBalloonFrame1();
  	protected ModelBase modelBalloonB1 = new ModelBalloonBalloon1();
  	protected ModelBase modelBalloonDS1 = new ModelBalloonDisplaySymbol1();
  	
  	//Viesigible Balloon
  	protected ModelBase modelBalloonF2 = new ModelBalloonFrame2();
  	protected ModelBase modelBalloonB2 = new ModelBalloonBalloon2();
  	protected ModelBase modelBalloonDS2 = new ModelBalloonDisplaySymbol2();
  	
  	//Vieseplin Balloon
  	protected ModelBase modelBalloonF3 = new ModelBalloonFrame3();
  	protected ModelBase modelBalloonB3 = new ModelBalloonBalloon3();
  	protected ModelBase modelBalloonDS3 = new ModelBalloonDisplaySymbol3();
  	
  	//Viesakron Balloon
  	protected ModelBase modelBalloonF4 = new ModelBalloonFrame4();
  	protected ModelBase modelBalloonB4 = new ModelBalloonBalloon4();
  	protected ModelBase modelBalloonDS4 = new ModelBalloonDisplaySymbol4();
  	
  	

  	/** Instance of Panel Screen Model for rendering. */
  	protected ModelBase modelAirshipPanel = new ModelAirshipPanel();
  	
  	/** Instance of Propeller Model for rendering. */
  	protected ModelBase modelAirshipPropeller = new ModelAirshipPropeller();
  	
  	
  	
  	protected ModelBase currentModelFrame;
  	protected ModelBase currentModelEngine;
  	protected ModelBase currentModelBalloonF;
  	protected ModelBase currentModelBalloonB;
  	protected ModelBase currentModelBalloonDS;
  	
  	
  	
  	public static final ResourceLocation STEVE_TEXTURES = new ResourceLocation("textures/entity/steve.png");
    public static final ResourceLocation ALEX_TEXTURES = new ResourceLocation("textures/entity/alex.png");
    public static final ResourceLocation CHICKEN_TEXTURES = new ResourceLocation("textures/entity/chicken.png");
    public static final ResourceLocation PIG_TEXTURES = new ResourceLocation("textures/entity/pig/pig.png");
    public static final ResourceLocation COW_TEXTURES = new ResourceLocation("textures/entity/cow/cow.png");
    public static final ResourceLocation ZOMBIE_TEXTURES = new ResourceLocation("textures/entity/zombie/zombie.png");
    public static final ResourceLocation SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/skeleton.png");
    public static final ResourceLocation SPIDER_TEXTURES = new ResourceLocation("textures/entity/spider/spider.png");
    public static final ResourceLocation CREEPER_TEXTURES = new ResourceLocation("textures/entity/creeper/creeper.png");
    public static final ResourceLocation WITHER_SKELETON_TEXTURES = new ResourceLocation("textures/entity/skeleton/wither_skeleton.png");
    public static final ResourceLocation DRAGON_TEXTURES = new ResourceLocation("textures/entity/enderdragon/dragon.png");
    public static final ResourceLocation HEROBRINE_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/herobrine.png");
    
    
    
    private static final ResourceLocation SUPPORTER_VIES_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/vies.png");
    private static final ResourceLocation SUPPORTER_SOULFORGE7_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/soulforge7.png");
    private static final ResourceLocation SUPPORTER_NEMANOR_TEXTURES = new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/nemanor.png");
    
    
    
    private final ModelDragonHead dragonHead = new ModelDragonHead(0.0F);
    private final ModelSkeletonHead skeletonHead = new ModelSkeletonHead(0, 0, 64, 32);
    private final ModelSkeletonHead humanoidHead = new ModelHumanoidHead();
    private final ModelChickenHead chickenHead = new ModelChickenHead();
    private final ModelPigHead pigHead = new ModelPigHead();
    private final ModelCowHead cowHead = new ModelCowHead();
    private final ModelSpiderHead spiderHead = new ModelSpiderHead();
    
    
    
    
    private static final ModelSkeletonHead humanoidHead1 = new ModelHumanoidHead();
    
    
    public RenderAirshipBase(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityAirshipCore entity) 
	{
		return null;
	}
    
	//================================================
	
	/**
     * Renders a symbol.
     */
    protected void renderSymbol(EntityAirshipCore airshipIn, ItemStack itemstackIn, int locationIn)
    {
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        	
	        //Viesdenburg
	        if(locationIn == 1)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
	        	GlStateManager.translate(1.025F, 2.125F, 0F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.025F, 2.125F, 0F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
	        	GlStateManager.translate(1.435F, 0.0F, 0F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.435F, 0.0F, 0F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                
	        	GlStateManager.translate(1.365F, 0.5F, 0.18F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.365F, 0.5F, 0.18F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                
	        	GlStateManager.translate(0.97F, 1.438F, -0.595F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-0.97F, 1.438F, -0.595F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        
	        
	        //Spinning
	    	GlStateManager.pushMatrix();
	    	
	    	GlStateManager.translate(-0.375F, -0.0675F, -0.8125F);
        	GlStateManager.scale(0.3F, 0.3F, 0.3F);
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the Y axis
            GlStateManager.rotate(270, 0.0F, 1.0F, 0.0F);
	    	
	    	float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        //Spins Item
	        GlStateManager.rotate(itemSpin * 2, 0F, 1F, 0F);
	        
	        Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	        
	        GlStateManager.popMatrix();
        
        GlStateManager.popMatrix();
    }
    
    /**
     * Renders a block/item.
     */
    protected void renderBlockItem(EntityAirshipCore airshipIn, ItemStack itemstackIn, int locationIn)
    {
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        GlStateManager.pushMatrix();
        	
	        //Viesdenburg
	        if(locationIn == 1)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(-0.277F, -0.56F, 0F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
	        	GlStateManager.translate(1.025F, 2.125F, 0F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(0.277F, -0.56F, 0F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.025F, 2.125F, 0F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(-0.37F, -0.03F, 0F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
	        	GlStateManager.translate(1.435F, 0.0F, 0F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(0.37F, -0.03F, 0F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
		    	GlStateManager.scale(1F, 1F, 1F);
		    	//Flips the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.435F, 0.0F, 0F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(-0.365F, -0.157F, 0.05F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                
	        	GlStateManager.translate(1.36F, 0.5F, 0.18F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(0.36F, -0.157F, 0.05F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-1.365F, 0.5F, 0.18F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(-0.25F, -0.39F, -0.15F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
                
	        	GlStateManager.translate(0.97F, 1.438F, -0.595F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	            
	            //Right
	        	GlStateManager.pushMatrix();
	        	
	        	if(itemstackIn.getItem() instanceof ItemBlock)
				{
					GlStateManager.translate(0F, 0.05F, 0F);
					GlStateManager.scale(1F, 1F, 1F);
				}
	        	else
	        	{
	        		GlStateManager.translate(0.25F, -0.39F, -0.15F);
					GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        	}
	        	
	        	//GlStateManager.translate(0.375F, 0F, -0.8125F);
    	    	GlStateManager.scale(1F, 1F, 1F);
    	    	//Flips the model right side up.
                GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	        	
	        	GlStateManager.translate(-0.97F, 1.438F, -0.595F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	            Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	            
	            GlStateManager.popMatrix();
	        }
	        
	        
	        
	        //Spinning
	    	GlStateManager.pushMatrix();
	    	
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
	    	
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the Y axis
            GlStateManager.rotate(270, 0.0F, 1.0F, 0.0F);
	    	
	    	float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        //Spins Item
	        GlStateManager.rotate(itemSpin * 2, 0F, 1F, 0F);
	        
	        Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
	        
	        GlStateManager.popMatrix();
        
        GlStateManager.popMatrix();
    }
    
    /**
	 * Renders an entity head.
	 */
    protected void renderEntityHead(int skullType, float posX, float posY, float posZ, int locationIn)
    {
        ModelBase modelbase = this.skeletonHead;

        switch(skullType)
		{
		    case 0:
		    default:
		        this.bindTexture(STEVE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 1:
		        this.bindTexture(STEVE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 2:
		        this.bindTexture(ALEX_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 3:
		        this.bindTexture(CHICKEN_TEXTURES);
		        modelbase = this.chickenHead;
		        break;
		    case 4:
		        this.bindTexture(PIG_TEXTURES);
		        modelbase = this.pigHead;
		        break;
		    case 5:
		        this.bindTexture(COW_TEXTURES);
		        modelbase = this.cowHead;
		        break;
		    case 6:
		        this.bindTexture(ZOMBIE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		    case 7:
		        this.bindTexture(SKELETON_TEXTURES);
		        break;
		    case 8:
		        this.bindTexture(SPIDER_TEXTURES);
		        modelbase = this.spiderHead;
		        break;
		    case 9:
		        this.bindTexture(CREEPER_TEXTURES);
		        break;
		    case 10:
		        this.bindTexture(WITHER_SKELETON_TEXTURES);
		        break;
		    case 11:
		        this.bindTexture(DRAGON_TEXTURES);
		        modelbase = this.dragonHead;
		        GlStateManager.scale(0.55, 0.55, 0.55);
		        break;
		    case 12:
		        this.bindTexture(HEROBRINE_TEXTURES);
		        modelbase = this.humanoidHead;
		        break;
		}

        GlStateManager.pushMatrix();
        
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        //Default
	        if(locationIn == 0)
	        {
	        	GlStateManager.pushMatrix();
	        	
	            GlStateManager.popMatrix();
	        }
	        //Viesdenburg
	        if(locationIn == 1)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(0.79F, -1.76F, 0.0F);
	        	}
	        	
	        	GlStateManager.translate(1.038F, -2.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(-0.79F, -1.76F, 0.0F);
	        	}
	        	
	            GlStateManager.translate(-1.038F, -2.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	            GlStateManager.popMatrix();
	        }
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(1.125F, -0.02F, 0F);
	        	}
	        	
	        	GlStateManager.translate(1.438F, 0.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(-1.125F, -0.02F, 0F);
	        	}
	        	
	            GlStateManager.translate(-1.438F, 0.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(1.08F, -0.43F, 0.15F);
	        	}
	        	
	        	GlStateManager.translate(1.37F, -0.44F, 0.185F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(-1.08F, -0.43F, 0.15F);
	        	}
	        	
	            GlStateManager.translate(-1.37F, -0.44F, 0.185F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(0.74F, -1.2F, -0.5F);
	        	}
	        	
	        	GlStateManager.translate(0.97F, -1.375F, -0.595F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	        	//Dragon
	        	if(skullType == 11)
	        	{
	        		GlStateManager.translate(-0.74F, -1.2F, -0.5F);
	        	}
	        	
	            GlStateManager.translate(-0.97F, -1.375F, -0.595F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        
	        
	        
	        //Spinning
	        GlStateManager.pushMatrix();
	    	
	    	float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	    	//Dragon
	    	if(skullType == 11)
	    	{
	    		GlStateManager.translate(-0.3F, -0.03F, -0.65F);
	    	}
	    	
	    	GlStateManager.translate(-0.375F, -0.03F, -0.8125F);
	    	GlStateManager.scale(0.25F, 0.25F, 0.25F);
	        
	        //Spins Item
	        GlStateManager.rotate(-itemSpin * 2, 0F, 1F, 0F);
	        
	        modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        
	        GlStateManager.popMatrix();
	        
        GlStateManager.popMatrix();
    }
    //TODO Supporter Heads add here!
	/**
	 * Renders a supporter head.
	 */
    protected void renderSupporterHead(int skullType, float posX, float posY, float posZ, 
    		int locationIn)
    {
        ModelBase modelbase = this.humanoidHead;

        switch (skullType)
		{
		    case 0:
		    default:
		        this.bindTexture(SUPPORTER_VIES_TEXTURES);
		        break;
		    case 1:
		        this.bindTexture(SUPPORTER_VIES_TEXTURES);
		        break;
		    case 2:
		        this.bindTexture(SUPPORTER_SOULFORGE7_TEXTURES);
		        break;
		    case 3:
		        this.bindTexture(SUPPORTER_NEMANOR_TEXTURES);
		        break;
		}

        GlStateManager.pushMatrix();
        
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        //Default
	        if(locationIn == 0)
	        {
	        	GlStateManager.pushMatrix();
	        	
	            GlStateManager.popMatrix();
	        }
	        //Viesdenburg
	        if(locationIn == 1)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.038F, -2.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.038F, -2.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	            GlStateManager.popMatrix();
	        }
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.438F, 0.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.438F, 0.0625F, 0F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.37F, -0.44F, 0.185F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.37F, -0.44F, 0.185F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(0.97F, -1.375F, -0.595F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(270, 0F, 1F, 0F);
	            
	        	modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-0.97F, -1.375F, -0.595F);
	            GlStateManager.scale(0.75F, 0.75F, 0.75F);
	            GlStateManager.rotate(90, 0F, 1F, 0F);
	            
	            modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            GlStateManager.popMatrix();
	        }
	        
	        
	        
	        //Spinning
	        GlStateManager.pushMatrix();
	    	
	    	float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	    	GlStateManager.translate(-0.375F, -0.03F, -0.8125F);
	    	GlStateManager.scale(0.25F, 0.25F, 0.25F);
	        
	        //Spins Item
	        GlStateManager.rotate(-itemSpin * 2, 0F, 1F, 0F);
	        
	        modelbase.render((Entity)null, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        
	        GlStateManager.popMatrix();
	        
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
    
    
    
    /**
     * Main wrapper for the Engine Display system
     */
    protected void renderEngineDisplaySymbol(EntityAirshipCore airshipIn, float partialTicks)
    {
    	if(airshipIn.getEngineDisplayTypeVisual() == 1)
    	{
    		this.renderBlockItem(airshipIn, new ItemStack(Item.getItemById(airshipIn.engineDisplayItemstackVisual), 1, airshipIn.engineDisplayItemstackMetaVisual), airshipIn.getCoreModelVisualBalloon());
    	}
    	else if(airshipIn.getEngineDisplayTypeVisual() == 2)
    	{
    		this.renderEntityHead(airshipIn.engineDisplayHeadVisual, 0, 0, 0, airshipIn.coreModelVisualBalloon);
    	}
    	else if(airshipIn.getEngineDisplayTypeVisual() == 3)
    	{
    		this.renderSupporterHead(airshipIn.engineDisplaySupporterHeadVisual, 0, 0, 0, airshipIn.coreModelVisualBalloon);
    	}
    	else if(airshipIn.getEngineDisplayTypeVisual() == 4)
    	{
    		
    		
    		//this.renderItemOnDisplaySpin//((float)0, (float)1, (float)1, 2);//.engineDisplayHeadVisual);
    	}
    	else if(airshipIn.getEngineDisplayTypeVisual() >= 10)
    	{
    		this.renderSymbol(airshipIn, new ItemStack(ItemsVC.ITEM_DISPLAY_SYMBOL, 1, EnumsVC.MainDisplaySymbol.byId(airshipIn.engineDisplayTypeVisual).getMetadata()), airshipIn.getCoreModelVisualBalloon());
    	}
    	
    	
    	
    	
    	
    	
    	//Front rotating item
        /**this.renderItemOnDisplay(airshipIn, 0, 0.6, -4.5, new ItemStack(
        		
        		
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 0.25, 0.25, 0.25, bladespin, 2, 0F);
    	
        
    	//Left item
        this.renderItemOnDisplay(airshipIn, 1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, 0, 0, 270.0F);
    	
        //Right item
        this.renderItemOnDisplay(airshipIn, -1.05, -2.125, 0, new ItemStack(
        		Item.getItemFromBlock(Blocks.COBBLESTONE)
        		//Items.DIAMOND_SWORD
        		, 1), 1, 1, 1, 0, 0, 90.0F);
        */
    }
    
    /**
	 * Renders a supporter head.
	 */
    protected void renderEngineSmokeParticles(EntityAirshipCore entity, int locationIn)
    {
    	GlStateManager.pushMatrix();
        
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        //Default
	        if(locationIn == 0)
	        {
	        	//InitParticlesVCRender.generateAirshipSmokeParticles0(entity, 0.0D, -0.15D, 0.0D);
	        }
	        //Viesdenburg
	        if(locationIn == 1)
	        {
	        	//InitParticlesVCRender.generateAirshipSmokeParticles1(entity, 0.0D, 0.02D, 0D);
	        }
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	
	            //Left
	        	//InitParticlesVCRender.generateAirshipSmokeParticles2(entity, 0, 0, 0);
	            
	            
	        	
	        	//InitParticlesVCRender.generateAirshipSmokeParticles2a(entity, 0.0D, -0.02D, 0.0D);
	        	//Right
	        	//InitParticlesVCRender.generateAirshipSmokeParticles2b(entity, 0.0D, -0.02D, 0.0D);
	        }
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	
	        }
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	
	        }
	        
        GlStateManager.popMatrix();
    }
    
    
    
    
    
    protected ModelBase getCurrentModelFrame(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.coreModelVisualFrame)
    	{
	    	case 0:
	    		return currentModelFrame = this.modelFrame0;
	    	case 1:
	    		return currentModelFrame = this.modelFrame1;
	    	case 2:
	    		return currentModelFrame = this.modelFrame2;
	    	case 3:
	    		return currentModelFrame = this.modelFrame3;
	    	case 4:
	    		return currentModelFrame = this.modelFrame4;
	    	default:
	    		return currentModelFrame = this.modelFrame0;
    	}
    }
    
    protected ModelBase getCurrentModelEngine(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.coreModelVisualEngine)
    	{
	    	case 0:
	    		return currentModelEngine = this.modelEngine0;
	    	case 1:
	    		return currentModelEngine = this.modelEngine1;
	    	case 2:
	    		return currentModelEngine = this.modelEngine2;
	    	case 3:
	    		return currentModelEngine = this.modelEngine3;
	    	case 4:
	    		return currentModelEngine = this.modelEngine4;
	    	default:
	    		return currentModelEngine = this.modelEngine0;
    	}
    }
    
    protected ModelBase getCurrentModelBalloonF(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.coreModelVisualBalloon)
    	{
	    	case 0:
	    		return currentModelBalloonF = this.modelBalloonF0;
	    	case 1:
	    		return currentModelBalloonF = this.modelBalloonF1;
	    	case 2:
	    		return currentModelBalloonF = this.modelBalloonF2;
	    	case 3:
	    		return currentModelBalloonF = this.modelBalloonF3;
	    	case 4:
	    		return currentModelBalloonF = this.modelBalloonF4;
	    	default:
	    		return currentModelBalloonF = this.modelBalloonF0;
    	}
    }
    protected ModelBase getCurrentModelBalloonDS(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.coreModelVisualBalloon)
    	{
	    	case 0:
	    		return currentModelBalloonDS = this.modelBalloonDS0;
	    	case 1:
	    		return currentModelBalloonDS = this.modelBalloonDS1;
	    	case 2:
	    		return currentModelBalloonDS = this.modelBalloonDS2;
	    	case 3:
	    		return currentModelBalloonDS = this.modelBalloonDS3;
	    	case 4:
	    		return currentModelBalloonDS = this.modelBalloonDS4;
	    	default:
	    		return currentModelBalloonDS = this.modelBalloonDS0;
    	}
    }
    protected ModelBase getCurrentModelBalloonB(EntityAirshipCore airshipIn)
    {
    	switch(airshipIn.coreModelVisualBalloon)
    	{
	    	case 0:
	    		return currentModelBalloonB = this.modelBalloonB0;
	    	case 1:
	    		return currentModelBalloonB = this.modelBalloonB1;
	    	case 2:
	    		return currentModelBalloonB = this.modelBalloonB2;
	    	case 3:
	    		return currentModelBalloonB = this.modelBalloonB3;
	    	case 4:
	    		return currentModelBalloonB = this.modelBalloonB4;
	    	default:
	    		return currentModelBalloonB = this.modelBalloonB0;
    	}
    }
    
    protected void getCurrentModel(EntityAirshipCore entity)
    {
    	this.getCurrentModelFrame(entity);
        this.getCurrentModelEngine(entity);
        this.getCurrentModelBalloonF(entity);
        this.getCurrentModelBalloonDS(entity);
        this.getCurrentModelBalloonB(entity);
    }
    
    protected TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.WHITE;
			case 2:
				return stringColorLabel = TextFormatting.YELLOW;
			case 3:
				return stringColorLabel = TextFormatting.AQUA;
			case 4:
				return stringColorLabel = TextFormatting.LIGHT_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}
    
    protected FontRenderer getFontRenderer()
    {
        return Minecraft.getMinecraft().fontRenderer;
    }
    
    
}