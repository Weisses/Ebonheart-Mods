package com.viesis.viescraft.api.compat.jei;

import javax.annotation.Nonnull;

public abstract class BlankModPlugin implements IModPlugin {
	@Override
	public void register(@Nonnull IModRegistry registry) {

	}

	@Override
	public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {

	}
}