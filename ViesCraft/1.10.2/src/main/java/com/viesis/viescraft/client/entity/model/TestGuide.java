package com.viesis.viescraft.client.entity.model;

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.ImmutableList;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.client.model.IPerspectiveAwareModel;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

	
@SuppressWarnings("deprecation")
public class TestGuide implements IPerspectiveAwareModel {

    private static final ModelResourceLocation path = new ModelResourceLocation("botania:lexicon_default", "inventory");

    @Override
    public Pair<? extends IBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType) {
        IBakedModel original = Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelShapes().getModelManager().getModel(path);
        /*if(cameraTransformType == ItemCameraTransforms.TransformType.FIRST_PERSON_RIGHT_HAND && ConfigHandler.lexicon3dModel)
            return Pair.of(this, null); todo 1.9 */
        return ((IPerspectiveAwareModel) original).handlePerspective(cameraTransformType);
    }

    @Nonnull
    @Override public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) { return ImmutableList.of(); }
    @Override public boolean isAmbientOcclusion() { return false; }
    @Override public boolean isGui3d() { return false; }
    @Override public boolean isBuiltInRenderer() { return false; }
    @Nonnull
    @Override public TextureAtlasSprite getParticleTexture() { return Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite("botania:items/lexicon"); }
    @Nonnull
    @Override public ItemCameraTransforms getItemCameraTransforms() { return ItemCameraTransforms.DEFAULT; }
    @Nonnull
    @Override public ItemOverrideList getOverrides() { return ItemOverrideList.NONE; }
}
