package com.viesis.viescraft.client.entity.render;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderAirship extends RenderAirshipBase {
	
    public RenderAirship(RenderManager renderManagerIn)
    {
        super(renderManagerIn);
    }
    
    @Override
    public boolean isMultipass()
    {
        return true;
    }
    
    @Override
    public void doRender(EntityAirshipCore entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();
    	
    	/**
    	Scoreboard scoreboard = Minecraft.getMinecraft().player.getWorldScoreboard();
    	
    	if(scoreboard != null)
    	{
    		if(scoreboard.getTeam("VCAirshipTier0") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier0");
    			scoreboard.getTeam("VCAirshipTier0").setColor(TextFormatting.GRAY);
    		}
    		if(scoreboard.getTeam("VCAirshipTier1") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier1");
    			scoreboard.getTeam("VCAirshipTier1").setColor(TextFormatting.WHITE);
    		}
    		if(scoreboard.getTeam("VCAirshipTier2") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier2");
    			scoreboard.getTeam("VCAirshipTier2").setColor(TextFormatting.GOLD);
    		}
    		if(scoreboard.getTeam("VCAirshipTier3") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier3");
    			scoreboard.getTeam("VCAirshipTier3").setColor(TextFormatting.AQUA);
    		}
    		if(scoreboard.getTeam("VCAirshipTier4") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier4");
    			scoreboard.getTeam("VCAirshipTier4").setColor(TextFormatting.LIGHT_PURPLE);
    		}
    		if(scoreboard.getTeam("VCAirshipTier5") == null) 
    		{
    			scoreboard.createTeam("VCAirshipTier5");
    			scoreboard.getTeam("VCAirshipTier5").setColor(TextFormatting.RED);
    		}
    	}
    	
    	scoreboard.addPlayerToTeam(entity.getCachedUniqueIdString(), "VCAirshipTier" + entity.getMainTierCore());
    	
    	LogHelper.info(entity.getTeam().getName());
		*/	
    	
    	
    	
        GL11.glEnable(GL11.GL_CULL_FACE);
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.getCurrentModel(entity);
        
        //this.selectedModelViewWindow(entity, partialTicks);
        this.selectedModelControlPanel(entity, partialTicks);
        
    	this.selectedModelMainFrame(entity, partialTicks);
    	this.selectedModelMainEngine(entity, partialTicks);
    	this.selectedModelMainBalloonF(entity, partialTicks);
    	this.selectedModelMainBalloonB(entity, partialTicks);
    	//this.selectedModelMainPropeller(entity, partialTicks, entity.coreModelVisualBalloon);
    	
    	if(entity.getEngineDisplayTypeVisual() != 0)
    	{
    		this.selectedModelMainBalloonDS(entity, partialTicks);
    	}
    	
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	
    	//Renders the Display Symbol System
    	this.renderEngineDisplaySymbol(entity, partialTicks);
    	
    	//Renders the Particle System
    	this.renderEngineParticles(entity, entity.engineParticleVisual);
    	
    	//if(Minecraft.getMinecraft().objectMouseOver.entityHit == entity)
    	//{
    	//	entity.setGlowing(true);
    	//}
    	//else
    	//{
    	//	entity.setGlowing(false);
    	//}
    	
    	if(ViesCraftConfig.renderNameplates)
    	{
    		if(entity.isBeingRidden())
	        {
	        	
	        }
	        else
	        {
	        	EntityPlayerSP playerIn = Minecraft.getMinecraft().player;
	        	float prevAirshipYaw = playerIn.rotationYaw;
	        	float nameplateYaw = (prevAirshipYaw%360) - entity.rotationYaw;
	        	
	        	//Render airship name
	        	if(entity.getName() != null)
	        	{
	        		GlStateManager.pushMatrix();
		    		{
		    			GlStateManager.scale(0.5F, 0.5F, 0.5F);
		    			GlStateManager.rotate(180, 1, 0, 0);
		    			
		    			EntityRenderer.drawNameplate(this.getFontRenderer(), this.getPrimaryLabelColor(entity.getMainTierCore()) + entity.customName, 0F, 1.35F, 0F, 0, nameplateYaw, 0F, false, false);
		    		}
		    		GlStateManager.popMatrix();
	        	}
	        	
	    		if(entity.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				|| entity.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				|| entity.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
	    		{
	    			
	    		}
	    		else
	    		{
					//Render airship fuel bar
		        	GlStateManager.pushMatrix();
		    		{
		    			int percentTen = entity.getStoredFuelTotal() / 10;
		        		
		    			GlStateManager.scale(0.5F, 0.5F, 0.5F);
		    			GlStateManager.rotate(180, 1, 0, 0);
		    			
		    			if(entity.getStoredFuel() == 0)
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "          " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 9))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA + "||||||||||||||||||||" + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 8))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.AQUA + "|||||||||||||||||| " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 7))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN + "||||||||||||||||  " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 6))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GREEN + "||||||||||||||   " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 5))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "||||||||||||    " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 4))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.YELLOW + "||||||||||     " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 3))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||||      " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 2))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.GOLD + "||||||       " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 1))
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||||        " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    			else if(entity.getStoredFuel() >= (percentTen * 0) + 1)
		    			{
		    				EntityRenderer.drawNameplate(this.getFontRenderer(), TextFormatting.WHITE + "[" + TextFormatting.DARK_RED + "||         " + TextFormatting.WHITE + "]", 0F, 1.125F, 0F, 0, nameplateYaw, 0F, false, false);
		    			}
		    		}
		    		GlStateManager.popMatrix();
	    		}
	        }
    	}
    	
    	if(baseitemSpin >= 360)
        {
        	baseitemSpin = 0;
        }
        else
        {
        	baseitemSpin = baseitemSpin + 0.1F;
        }
    	
    	
    	
        GlStateManager.popMatrix();
        
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }
    
    @Override
    public void renderMultipass(EntityAirshipCore entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
    	GlStateManager.pushMatrix();

        GL11.glEnable(GL11.GL_CULL_FACE);
        
        this.setupTranslation(x, y, z);
        this.setupRotation(entity, entityYaw, partialTicks);
        this.bindEntityTexture(entity);
        
        this.getCurrentModel(entity);
        
        this.selectedModelMultiFrame(entity, partialTicks);
    	this.selectedModelMultiEngine(entity, partialTicks);
        this.selectedModelMultiBalloonF(entity, partialTicks);
    	this.selectedModelMultiBalloonB(entity, partialTicks);
    	this.selectedModelMultiPropeller(entity, partialTicks, entity.coreModelVisualBalloon);

    	if(entity.getEngineDisplayTypeVisual() != 0)
    	{
    		this.selectedModelMultiBalloonDS(entity, partialTicks);
    	}
    	
    	GL11.glDisable(GL11.GL_CULL_FACE);
    	
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
        
    }
    
    public void setupRotation(EntityAirshipCore entity, float p_188311_2_, float p_188311_3_)
    {
    	GlStateManager.rotate(180.0F - p_188311_2_, 0.0F, 1.0F, 0.0F);
        
    	float f = (float)entity.getTimeSinceHit() - p_188311_3_;
        float f1 = entity.getDamageTaken() - p_188311_3_;
        
        float g = (float)entity.getTimeSinceHit() - p_188311_3_;
        float g1 = entity.getDamageTaken() - p_188311_3_;
        
        //This actually rotates things!!!!
    	//long angle = (System.currentTimeMillis() / 40) % 360;
        
        if(entity.leftInputDown)
        {
        	GlStateManager.rotate(5, 0.0F, 0.0F, 0.1F);
        }
        
        if(entity.leftInputDown
        && entity.backInputDown)
        {
        	GlStateManager.rotate(10, 0.0F, 0.0F, -0.1F);
        }
        
        if(entity.rightInputDown)
        {
        	GlStateManager.rotate(5, 0.0F, 0.0F, -0.1F);
        }
        
        if(entity.rightInputDown
        && entity.backInputDown)
        {
        	GlStateManager.rotate(10, 0.0F, 0.0F, 0.1F);
        }
        
        if (f1 < 0.0F)
        {
            f1 = 0.0F;
        }
        
        if (f > 0.0F)
        {
            GlStateManager.rotate(MathHelper.sin(f) * f * f1 / 10.0F * (float)entity.getForwardDirection(), 0.0F, 0.0F, 1.0F);
        }
        
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
    }
    
    public void setupTranslation(double p_188309_1_, double p_188309_3_, double p_188309_5_)
    {
        GlStateManager.translate((float)p_188309_1_, (float)p_188309_3_ + 0.375F + 0.25F, (float)p_188309_5_);
    }
    
    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    @Override
    protected ResourceLocation getEntityTexture(EntityAirshipCore entity)
    {
        return null;
    }
    
    /**
     * Places an item on the control panel.
     */
    private void renderItemOnPanel(EntityAirshipCore airshipIn, double posXIn, double posYIn, double posZIn, ItemStack itemstackIn)
    {
    	GlStateManager.pushMatrix();
        
        if(itemstackIn.isEmpty())
		{
			return;
		}
        
        if(itemstackIn.getItem() instanceof ItemBlock)
        {
        	GlStateManager.scale(0.14, 0.14, 0.14);
            GlStateManager.translate(posXIn, posYIn + 0.05, posZIn + 0.05);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the X axis
            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        else
        {
        	GlStateManager.scale(0.14, 0.14, 0.14);
            GlStateManager.translate(posXIn, posYIn, posZIn);
            
            //Flips the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            //Flips on the X axis
            GlStateManager.rotate(-45, 1.0F, 0.0F, 0.0F);
            
    		Minecraft.getMinecraft().getRenderItem().renderItem(itemstackIn, TransformType.GROUND);
        }
        
		GlStateManager.popMatrix();
    }
    
    
    
    //========================================================
	//========================================================
	//========================================================
    
    
    
    /**
     * This is the Frame Model for the Main Render Method.
     */
    private void selectedModelMainFrame(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.frameSkinColorRed <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.frameSkinColorRed / 255.0F;
        }
        if(airshipIn.frameSkinColorBlue <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.frameSkinColorBlue / 255.0F;
        }
        if(airshipIn.frameSkinColorGreen <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.frameSkinColorGreen / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
        if(airshipIn.frameSkinColor)
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
        else
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
    	currentModelFrame.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Frame Model for the Multipass Render Method.
     */
    private void selectedModelMultiFrame(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay.png"));
        currentModelFrame.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    //==================================================
    
    
    
    /**
     * This is the Engine Model for the Main Render Method.
     */
    private void selectedModelMainEngine(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.frameSkinColorRed <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.frameSkinColorRed / 255.0F;
        }
        if(airshipIn.frameSkinColorBlue <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.frameSkinColorBlue / 255.0F;
        }
        if(airshipIn.frameSkinColorGreen <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.frameSkinColorGreen / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
        if(airshipIn.frameSkinColor)
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
        else
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
    	currentModelEngine.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Engine Model for the Multipass Render Method.
     */
    private void selectedModelMultiEngine(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Balloon Logic
        if(airshipIn.balloonPatternTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/engines/overlay_engine.png"));
        currentModelEngine.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    //==================================================
    
    /**
     * This is the Balloon Frame Model for the Main Render Method.
     */
    private void selectedModelMainBalloonF(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.frameSkinColorRed <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.frameSkinColorRed / 255.0F;
        }
        if(airshipIn.frameSkinColorBlue <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.frameSkinColorBlue / 255.0F;
        }
        if(airshipIn.frameSkinColorGreen <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.frameSkinColorGreen / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
        if(airshipIn.frameSkinColor)
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
        else
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
    	currentModelBalloonF.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Frame Model for the Multipass Render Method.
     */
    private void selectedModelMultiBalloonF(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/overlay_frame.png"));
        currentModelBalloonF.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Display Symbol Model for the Main Render Method.
     */
    private void selectedModelMainBalloonDS(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float frameRed;
        float frameGreen;
        float frameBlue;
        
        //Frame Colors
        if(airshipIn.frameSkinColorRed <= 30)
        {
        	frameRed = 30 / 255.0F;
        }
        else
        {
        	frameRed = airshipIn.frameSkinColorRed / 255.0F;
        }
        if(airshipIn.frameSkinColorBlue <= 30)
        {
        	frameBlue = 30 / 255.0F;
        }
        else
        {
        	frameBlue = airshipIn.frameSkinColorBlue / 255.0F;
        }
        if(airshipIn.frameSkinColorGreen <= 30)
        {
        	frameGreen = 30 / 255.0F;
        }
        else
        {
        	frameGreen = airshipIn.frameSkinColorGreen / 255.0F;
        }
        
        //Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
        
        if(airshipIn.frameSkinColor)
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
        else
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
        }
    	currentModelBalloonDS.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
    	GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Frame Model for the Multipass Render Method.
     */
    private void selectedModelMultiBalloonDS(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Frame Logic
        if(airshipIn.frameSkinTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/overlay_frame.png"));
        currentModelBalloonDS.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    
    
    /**
     * This is the Balloon Model for the Main Render Method.
     */
    private void selectedModelMainBalloonB(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Get Colors
        float balloonRed;
        float balloonGreen;
        float balloonBlue;
        
        //Balloon Colors
        if(airshipIn.balloonPatternColorRed <= 30)
        {
        	balloonRed = 30 / 255.0F;
        }
        else
        {
        	balloonRed = airshipIn.balloonPatternColorRed / 255.0F;
        }
        if(airshipIn.balloonPatternColorBlue <= 30)
        {
        	balloonBlue = 30 / 255.0F;
        }
        else
        {
        	balloonBlue = airshipIn.balloonPatternColorBlue / 255.0F;
        }
        if(airshipIn.balloonPatternColorGreen <= 30)
        {
        	balloonGreen = 30 / 255.0F;
        }
        else
        {
        	balloonGreen = airshipIn.balloonPatternColorGreen / 255.0F;
        }
        
        //Balloon Logic
        if(airshipIn.balloonPatternTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        GlStateManager.color(balloonRed, balloonGreen, balloonBlue, 1F);
    	
        if(airshipIn.balloonPatternColor)
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/grayscale_bg_" + EnumsVC.VisualBalloonPattern.byId(airshipIn.balloonPatternTexture).getRegistryName() + ".png"));
        }
        else
        {
        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/bg_" + EnumsVC.VisualBalloonPattern.byId(airshipIn.balloonPatternTexture).getRegistryName() + ".png"));
        }
    	currentModelBalloonB.render(airshipIn, 0.0F, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
        
        GlStateManager.color(1F, 1F, 1F, 1F);
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Balloon Model for the Multipass Render Method.
     */
    private void selectedModelMultiBalloonB(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Balloon Logic
        if(airshipIn.balloonPatternTransparent)
        {
        	GlStateManager.enableBlend();
        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        }
        
        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/balloons/overlay_balloon.png"));
        currentModelBalloonB.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
	    
        GlStateManager.disableBlend();
    }
    
    /**
     * This is the Control Panel Model for the Main Render Method.
     */
    private void selectedModelControlPanel(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_panel.png"));
    	this.modelAirshipPanel.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	
        //Control panel item renderer
        if(airshipIn.getMainTierCore() != 0)
        {
	        //Core Upgrade
	        this.renderItemOnPanel(airshipIn, 0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_CORE, 1, airshipIn.getMainTierCore()));
        }
        if(airshipIn.getMainTierFrame() != 0)
        {
	        //Frame Upgrade
	        this.renderItemOnPanel(airshipIn, 0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_FRAME, 1, airshipIn.getMainTierFrame()));
        }
        if(airshipIn.getMainTierEngine() != 0)
        {
	        //Engine Upgrade
	        this.renderItemOnPanel(airshipIn, -0.315, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_ENGINE, 1, airshipIn.getMainTierEngine()));
        }
        if(airshipIn.getMainTierBalloon() != 0)
        {
	        //Balloon Upgrade
	        this.renderItemOnPanel(airshipIn, -0.93, -0.26, -6.28, new ItemStack(ItemsVC.UPGRADE_BALLOON, 1, airshipIn.getMainTierBalloon()));
        }
        
        
        
        if(!airshipIn.inventory.getStackInSlot(0).isEmpty())
        {
	        //Fuel
	        this.renderItemOnPanel(airshipIn, 0.93, 0.43, -5.59, airshipIn.inventory.getStackInSlot(0));
        }
        //L2
        //this.renderItemOnPanel(entity, 0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        //L3
        //this.renderItemOnPanel(entity, -0.315, 0.43, -5.59, new ItemStack(Items.COAL, 1, 1));
        if(airshipIn.getModuleActiveSlot1() != 0)
        {
        	//Module
        	this.renderItemOnPanel(airshipIn, -0.93, 0.43, -5.59, new ItemStack(ItemsVC.MODULE_TYPE, 1, airshipIn.getModuleActiveSlot1()));
        }
        
    }
    
    /**
     * This is the View Window Model for the Main Render Method.
     * NOT USED ATM.
     */
    private void selectedModelViewWindow(EntityAirshipCore airshipIn, float partialTicks)
    {
    	//Draws the Main Control Panel Screen
    	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/model_airship_view_window.png"));
    	
    	if(airshipIn.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
    	|| airshipIn.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
    	|| airshipIn.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
    	{
    		this.modelViewWindow.render(airshipIn, partialTicks, 0.0F, 0F, 0.0F, 0.0F, 0.0625F);
    	}
    }

	/**
	 * This is the Propeller Model for the Main Render Method.
	 * NOT USED ATM.
	 */
    private void selectedModelMainPropeller(EntityAirshipCore airshipIn, float partialTicks, int locationIn)
    {
       GlStateManager.pushMatrix();
        
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        if(airshipIn.frameSkinColor)
	        {
	        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/grayscale_bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
	        }
	        else
	        {
	        	this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/bg_" + EnumsVC.VisualFrameSkinBackground.byId(airshipIn.frameSkinTexture).getRegistryName() + ".png"));
	        }
	        
	        boolean powered = airshipIn.getStoredFuel() > 0;
	        //float baseitemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        //float itemSpin = baseitemSpin * 9;
	        
	        
	        float itemSpin = baseitemSpin;// * 9;	
	        
	        //Get Colors
	        float frameRed;
	        float frameGreen;
	        float frameBlue;
	        
	        //Frame Colors
	        if(airshipIn.getFrameSkinColorRed() <= 30)
	        {
	        	frameRed = 30 / 255.0F;
	        }
	        else
	        {
	        	frameRed = airshipIn.getFrameSkinColorRed() / 255.0F;
	        }
	        if(airshipIn.getFrameSkinColorBlue() <= 30)
	        {
	        	frameBlue = 30 / 255.0F;
	        }
	        else
	        {
	        	frameBlue = airshipIn.getFrameSkinColorBlue() / 255.0F;
	        }
	        if(airshipIn.getFrameSkinColorGreen() <= 30)
	        {
	        	frameGreen = 30 / 255.0F;
	        }
	        else
	        {
	        	frameGreen = airshipIn.getFrameSkinColorGreen() / 255.0F;
	        }
	        
	        //Frame Logic
	        if(airshipIn.frameSkinTransparent)
	        {
	        	GlStateManager.enableBlend();
	        	GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	        }
	        
	        GlStateManager.color(frameRed, frameGreen, frameBlue, 1F);
	        
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
	        	
	        	GlStateManager.translate(0.875F, 0.0625F, 0F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-0.875F, 0.0625F, 0F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.0625F, -0.125F, 0.25F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.0625F, -0.125F, 0.25F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.0625F, 0.0625F, 0.28F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.0625F, 0.0625F, 0.28F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.25F, -1.6875F, -0.125F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.25F, -1.6875F, -0.125F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }

	    	GlStateManager.color(1F, 1F, 1F, 1F);
	        GlStateManager.disableBlend();
	        
        GlStateManager.popMatrix();
    }

	/**
	 * This is the Propeller Model for the Multipass Render Method.
	 */
    private void selectedModelMultiPropeller(EntityAirshipCore airshipIn, float partialTicks, int locationIn)
    {
       GlStateManager.pushMatrix();
        
	        GlStateManager.disableCull();
	        
	        GlStateManager.enableRescaleNormal();
	        GlStateManager.enableAlpha();
	        
	        this.bindTexture(new ResourceLocation(References.MOD_ID, "textures/models/frames/overlay.png"));
        	
	        boolean powered = airshipIn.getStoredFuel() > 0;
	        //float baseitemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        //float baseitemSpin = (((float)System.currentTimeMillis()//Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        float itemSpin;
	        
	        if(airshipIn.forwardInputDown
	        || airshipIn.backInputDown
	        || airshipIn.leftInputDown
	        || airshipIn.rightInputDown)
	        {
	        	itemSpin = baseitemSpin * 7;
	        }
	        else
	        {
	        	itemSpin = baseitemSpin * 1;
	        }
	        
	        // * 9;
	        
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
	        	
	        	GlStateManager.translate(0.875F, 0.0625F, 0F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-0.875F, 0.0625F, 0F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Viesigible
	        if(locationIn == 2)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.0625F, -0.125F, 0.25F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.0625F, -0.125F, 0.25F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Vieseplin
	        if(locationIn == 3)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.0625F, 0.0625F, 0.28F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.0625F, 0.0625F, 0.28F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        //Viesakron
	        if(locationIn == 4)
	        {
	        	//Left
	        	GlStateManager.pushMatrix();
	        	
	        	GlStateManager.translate(1.25F, -1.6875F, -0.125F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(-itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	        	
	        	GlStateManager.popMatrix();
	            
	            //Right
	            GlStateManager.pushMatrix();
	            
	            GlStateManager.translate(-1.25F, -1.6875F, -0.125F);
	        	
	        	if(powered)
	        	{
		        	//Spins Item
			        GlStateManager.rotate(itemSpin, 0F, 0F, 1F);
	        	}
	        	
	            modelAirshipPropeller.render(airshipIn, 0, 0.0F, 0.0F, 0, 0.0F, 0.0625F);
	            
	        	GlStateManager.popMatrix();
	        }
	        
        GlStateManager.popMatrix();
    }
}
