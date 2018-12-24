package com.vies.viesmachines.init;

import com.vies.viesmachines.api.References;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler 
{
	public static final ResourceLocation MACHINE_GROUND = LootTableList.register(new ResourceLocation(References.MOD_ID, "machine_ground"));
	public static final ResourceLocation MACHINE_WATER = LootTableList.register(new ResourceLocation(References.MOD_ID, "machine_water"));
	public static final ResourceLocation MACHINE_FLYING = LootTableList.register(new ResourceLocation(References.MOD_ID, "machine_flying"));
}
