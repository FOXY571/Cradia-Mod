package com.foxy_571.cradia.entity.client;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.NauadianSkeleton;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class NauadianSkeletonRenderer extends SkeletonRenderer<NauadianSkeleton> {
    public NauadianSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull NauadianSkeleton entity) {
        return ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "textures/entity/nauadian_skeleton.png");
    }
}
