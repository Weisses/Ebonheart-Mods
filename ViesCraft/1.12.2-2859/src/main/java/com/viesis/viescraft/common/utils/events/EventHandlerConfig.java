package com.viesis.viescraft.common.utils.events;

import java.util.List;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.client.MessageConfig;

public class EventHandlerConfig {
	
	public EventHandlerConfig()
	{
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	@SubscribeEvent
	public void onPlayerLoginEvent(PlayerLoggedInEvent event)
	{
		if(!event.player.world.isRemote)
		{
			NetworkHandler.sendToClient(new MessageConfig(), (EntityPlayerMP)event.player);
			
			//RecipeBook book = new RecipeBook();
			
			//for (IRecipe irecipe : ForgeRegistries.RECIPES) {
			//	book.unlock(irecipe);
				
				
			//}
			
			
			//List<IRecipe> list = Lists.<IRecipe>newArrayList();

            

            //event.player.unlockRecipes(this.getRecipes());
            
            //IRecipe irecipe = CraftingManager.getRecipe(new ResourceLocation("vc:recipes/airship_balloon"));
            //List<IRecipe> list = Lists.newArrayList(irecipe);
            //event.player.unlockRecipes(list);
            
            
            
            ////////////////////////////////event.player.unlockRecipes(VC_RECIPES);
            
			
			/*
			//if ("*".equals(args[2]))
            //{
                if (flag)
                {
                    entityplayermp.unlockRecipes(this.getRecipes());
                    notifyCommandListener(sender, this, "commands.recipe.give.success.all", new Object[] {entityplayermp.getName()});
                }
                else
                {
                    entityplayermp.resetRecipes(this.getRecipes());
                    notifyCommandListener(sender, this, "commands.recipe.take.success.all", new Object[] {entityplayermp.getName()});
                }
            }
            else
            {
                IRecipe irecipe = CraftingManager.getRecipe(new ResourceLocation(args[2]));

                if (irecipe == null)
                {
                    throw new CommandException("commands.recipe.unknownrecipe", new Object[] {args[2]});
                }

                if (irecipe.isDynamic())
                {
                    throw new CommandException("commands.recipe.unsupported", new Object[] {args[2]});
                }

                List<IRecipe> list = Lists.newArrayList(irecipe);

                if (flag == entityplayermp.getRecipeBook().isUnlocked(irecipe))
                {
                    String s = flag ? "commands.recipe.alreadyHave" : "commands.recipe.dontHave";
                    throw new CommandException(s, new Object[] {entityplayermp.getName(), irecipe.getRecipeOutput().getDisplayName()});
                }

                if (flag)
                {
                    entityplayermp.unlockRecipes(list);
                    notifyCommandListener(sender, this, "commands.recipe.give.success.one", new Object[] {entityplayermp.getName(), irecipe.getRecipeOutput().getDisplayName()});
                }
                else
                {
                    entityplayermp.resetRecipes(list);
                    notifyCommandListener(sender, this, "commands.recipe.take.success.one", new Object[] {irecipe.getRecipeOutput().getDisplayName(), entityplayermp.getName()});
                }
            }*/
            
			LogHelper.info("Logged in Server");
		}
	
	}
	
	@SubscribeEvent
	public void onPlayerLogoutEvent(PlayerLoggedOutEvent event)
	{
		
	}
	
	private List<IRecipe> getRecipes()
    {
		return Lists.newArrayList(CraftingManager.REGISTRY);
    }
	
	public static final ResourceLocation[] VC_RECIPES = new ResourceLocation[] 
	{
		new ResourceLocation(References.MOD_ID, "recipes/airship_balloon.json"),
	};
}
