package com.foxy_571.cradia.entity.client;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.TieredArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class TieredArrowRenderer extends ArrowRenderer<TieredArrow> {
    public TieredArrowRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TieredArrow tieredArrow) {
        String tierName = tieredArrow.getTierName();
        return ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "textures/entity/projectiles/" + tierName + "_arrow.png");
    }
}
