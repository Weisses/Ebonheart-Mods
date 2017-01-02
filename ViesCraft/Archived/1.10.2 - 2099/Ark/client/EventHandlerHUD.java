package com.viesis.viescraft.common.utils.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;

public class EventHandlerHUD {
	
	private final Minecraft mc;
	//private EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().thePlayer;
	
	public EventHandlerHUD()
	{
		mc = Minecraft.getMinecraft();
		
		
		
	}

	  /* The RenderGameOverlayEvent.Pre event is called before each game overlay element is
	   * rendered. It is called multiple times. A list of existing overlay elements can be found
	   * in net.minecraftforge.client.event.RenderGameOverlayEvent.
	   *
	   * If you want something to be rendered under an existing vanilla element, you would render
	   * it here.
	   *
	   * Note that you can entirely remove the vanilla rendering by cancelling the event here.
	   */

	@SubscribeEvent(receiveCanceled=true)
	public void onEvent(RenderGameOverlayEvent.Pre event) 
	{
		//EntityPlayerSP entityPlayerSP = Minecraft.getMinecraft().thePlayer;
		
		if (Minecraft.getMinecraft().thePlayer == null)
		{
			return;  // just in case
		}
		
	    if(Minecraft.getMinecraft().thePlayer.getRidingEntity() instanceof EntityAirshipV1Core)
	    {
	    	//LogHelper.info("HUD On!");
	    	//GuiHUD.
	    	//GuiHUD.test();
	    	//GuiHUD.onRenderTextOverlay("test");
			
	    
	    
	    	switch (event.getType()) 
	    	{
	    		/////case HEALTH:
	        
	    			//statusBarRenderer.renderStatusBar(event.getResolution().getScaledWidth(), event.getResolution().getScaledHeight());        /* Call a helper method so that this method stays organized */
	        
	    			/* Don't render the vanilla heart bar */
	        
	    		/////	event.setCanceled(true);
	        
	    		/////	break;

	      
	    		//case ARMOR:
	        
	    			/* Don't render the vanilla armor bar, it's part of the status bar in the HEALTH event */
	        
	    		//	event.setCanceled(true);
	        
	    		//	break;

	      
	    		case HOTBAR:
	        /* Specify a color to render with. If you're familiar with Photoshop or something similar, this
	         * basically adds a layer on top with the "Multiply" blend mode. Using the color white
	         * will have no effect, and using the color black will make your texture completely black (but
	         * it will preserve transparency).
	         *
	         * The actual arguments for glColor3f are 3 float values from 0.0f to 1.0f. These represent the
	         * level of each color component using the RGB model, with 1.0f being the highest. To learn more
	         * about the RGB model, visit this link:
	         * http://en.wikipedia.org/wiki/RGB_color_model
	         *
	         * The line below turns the hotbar gold
	         */
	        
	    			GL11.glColor3f(1, 0.7f, 0);
	        
	    			break;

	      
	    		default: // If it's not one of the above cases, do nothing
	        
	    			break;
	    
	    	}
	    	
		return;
	    }
	    
	}

	  /* The RenderGameOverlayEvent.Post event is called after each game overlay element is rendered.
	   * Similar to the RenderGameOverlayEvent.Pre event, it is called multiple times.
	   * 
	   * If you want something to be rendered over an existing vanilla element, you would render
	   * it here.
	   */
	@SubscribeEvent(receiveCanceled=true)
	public void onEvent(RenderGameOverlayEvent.Post event) 
	{
	    
	    /* The matrix must be popped whenever it is pushed. In this example, I pushed
	     * in the FOOD and AIR cases, so I have to pop in those cases here.
	     */
	    switch (event.getType()) 
	    {
	      /////case HEALTH:
	      /////  break;
	      case HOTBAR:
	        /* Set the render color back to white, so that not everything appears gold. */
	        GL11.glColor3f(1, 1, 1);
	        break;
	      default: // If it's not one of the above cases, do nothing
	        break;
	    }
	}
	
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderTextOverlay(RenderGameOverlayEvent.Text event) 
	{
		if(Minecraft.getMinecraft().thePlayer.getRidingEntity() instanceof EntityAirshipV1Core)
	    {
			if ((Minecraft.getMinecraft().inGameHasFocus 
			|| (Minecraft.getMinecraft().currentScreen != null 
			&& (Minecraft.getMinecraft().currentScreen instanceof GuiChat))) 
			&& !Minecraft.getMinecraft().gameSettings.showDebugInfo)
			{
				//GuiHUD.renderTextToHud();
			}
	    }
	}
}
