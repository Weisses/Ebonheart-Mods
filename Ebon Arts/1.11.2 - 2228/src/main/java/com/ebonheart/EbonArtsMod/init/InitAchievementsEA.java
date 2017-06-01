package com.ebonheart.EbonArtsMod.init;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.ebonheart.EbonArtsMod.api.AchievementsEA;
import com.ebonheart.EbonArtsMod.api.References;

public class InitAchievementsEA extends AchievementsEA {
	
	public static final AchievementPage achievementPageEA = new AchievementPage(References.MOD_NAME);
	
    public static void init()
    {
        AchievementPage.registerAchievementPage(achievementPageEA);
        
        addAchievements();
    }
    
    private static void addAchievements()
    {
    	mine_draconium_ore = addAchievement(MINE_DRACONIUM_ORE, "mine_draconium_ore", -1, -1, new ItemStack(InitBlocksEA.draconium_ore), null);
    	glowing_disc = addAchievement(GLOWING_DISC, "glowing_disc", -3, -2, new ItemStack(InitItemsEA.glowing_disc), mine_draconium_ore);//.func_180788_c();
		
		mine_velious_ore = addAchievement(MINE_VELIOUS_ORE, "mine_velious_ore", -2, 0, new ItemStack(InitBlocksEA.velious_ore), (Achievement)null);//.func_180788_c();
		shimmering_disc = addAchievement(SHIMMERING_DISC, "shimmering_disc", -4, 0, new ItemStack(InitItemsEA.shimmering_disc), (Achievement)mine_velious_ore);//.func_180788_c();
		
		mine_arcanite_ore = addAchievement(MINE_ARCANITE_ORE, "mine_arcanite_ore", 3, -1, new ItemStack(InitBlocksEA.arcanite_ore), (Achievement)null);//.func_180788_c();
		laminate_disc = addAchievement(LAMINATE_DISC, "laminate_disc", 5, -2, new ItemStack(InitItemsEA.laminate_disc), (Achievement)mine_arcanite_ore);//.func_180788_c();
		
		mine_katcheen_ore = addAchievement(MINE_KATCHEEN_ORE, "mine_katcheen_ore", 4, 0, new ItemStack(InitBlocksEA.katcheen_ore), (Achievement)null);//.func_180788_c();
		resilient_disc = addAchievement(RESILIENT_DISC, "resilient_disc", 6, 0, new ItemStack(InitItemsEA.resilient_disc), (Achievement)mine_katcheen_ore);//.func_180788_c();
		
		mine_necrocite_ore = addAchievement(MINE_NECROCITE_ORE, "mine_necrocite_ore", -1, 1, new ItemStack(InitBlocksEA.necrocite_ore), (Achievement)null);//.func_180788_c();
		dismal_disc = addAchievement(DISMAL_DISC, "dismal_disc", -3, 2, new ItemStack(InitItemsEA.dismal_disc), (Achievement)mine_necrocite_ore);//.func_180788_c();
		necrosis = addAchievement(NECROSIS, "necrosis", -5, 1, new ItemStack(InitItemsEA.necrosis), (Achievement)mine_necrocite_ore).setSpecial();//.func_180788_c();
		
		mine_soularite_ore = addAchievement(MINE_SOULARITE_ORE, "mine_soularite_ore", 3, 1, new ItemStack(InitBlocksEA.soularite_ore), (Achievement)null);//.func_180788_c();
		ethereal_disc = addAchievement(ETHEREAL_DISC, "ethereal_disc", 5, 2, new ItemStack(InitItemsEA.ethereal_disc), (Achievement)mine_soularite_ore);//.func_180788_c();
		consecration = addAchievement(CONSECRATION, "consecration", 7, 1, new ItemStack(InitItemsEA.consecration), (Achievement)mine_soularite_ore).setSpecial();//.func_180788_c();
		
		ebonheart = addAchievement(EBONHEART, "ebonheart", 1, 0, new ItemStack(InitItemsEA.ebonheart), (Achievement)null);//.func_180788_c();
		enchanted_ebonheart = addAchievement(ENCHANTED_EBONHEART, "enchanted_ebonheart", 1, -2, new ItemStack(InitItemsEA.enchanted_ebonheart), (Achievement)ebonheart);//.func_180788_c();
		
		empowered_blade = addAchievement(EMPOWERED_BLADE, "empowered_blade", 1, 2, new ItemStack(InitItemsEA.empowered_blade), (Achievement)ebonheart);//.func_180788_c();
		deception = addAchievement(DECEPTION, "deception", -1, 3, new ItemStack(InitItemsEA.deception), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		frostbite = addAchievement(FROSTBITE, "frostbite", -1, 4, new ItemStack(InitItemsEA.frostbite), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		massacre = addAchievement(MASSACRE, "massacre", 3, 3, new ItemStack(InitItemsEA.massacre), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		blazefury = addAchievement(BLAZEFURY, "blazefury", 3, 4, new ItemStack(InitItemsEA.blazefury), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		despair = addAchievement(DESPAIR, "despair", -1, 5, new ItemStack(InitItemsEA.despair), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		souleater = addAchievement(SOULEATER, "souleater", 3, 5, new ItemStack(InitItemsEA.souleater), (Achievement)empowered_blade).setSpecial();//.func_180788_c();
		
		nether_bound = addAchievement(NETHER_BOUND, "nether_bound", -3, 4, new ItemStack(InitItemsEA.obsidian_shards), (Achievement)null);//.func_180788_c();
		nether_doomed = addAchievement(NETHER_DOOMED, "nether_doomed", 5, 4, new ItemStack(InitItemsEA.glowstone_shards), (Achievement)null);//.func_180788_c();
		
		burnished_armor = addAchievement(BURNISHED_ARMOR, "burnished_armor", -1, -3, new ItemStack(InitItemsEA.burnished_chestplate), (Achievement)enchanted_ebonheart).setSpecial();//.func_180788_c();
		scalemail_armor = addAchievement(SCALEMAIL_ARMOR, "scalemail_armor", 3, -3, new ItemStack(InitItemsEA.scalemail_chestplate), (Achievement)enchanted_ebonheart).setSpecial();//.func_180788_c();
		vengeance_armor = addAchievement(VENGEANCE_ARMOR, "vengeance_armor", -1, -4, new ItemStack(InitItemsEA.vengeance_chestplate), (Achievement)enchanted_ebonheart).setSpecial();//.func_180788_c();
		celestial_armor = addAchievement(CELESTIAL_ARMOR, "celestial_armor", 3, -4, new ItemStack(InitItemsEA.celestial_chestplate), (Achievement)enchanted_ebonheart).setSpecial();//.func_180788_c();
		
    }
    
    private static Achievement addAchievement(String unlocalizedName, String identifier, int column, int row, ItemStack iconStack, Achievement parent)
    {
        Achievement achievement = new Achievement(unlocalizedName, References.MOD_ID + ":" + identifier, column, row, iconStack, parent);
        achievement.registerStat();
        achievementPageEA.getAchievements().add(achievement);
        return achievement;
    }
}