package com.foxy_571.cradia.entity.client;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.entity.custom.ThrownDagger;
import com.foxy_571.cradia.model.DaggerModel;
import com.foxy_571.cradia.model.ModModelLayerLocations;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ThrownDaggerRenderer extends EntityRenderer<ThrownDagger> {
    private final DaggerModel model;

    public ThrownDaggerRenderer(EntityRendererProvider.Context context) {
        super(context);
        model = new DaggerModel(context.bakeLayer(ModModelLayerLocations.DAGGER_LAYER));
    }

    @Override
    public void render(ThrownDagger entity, float entityYaw, float partialTicks, PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
        poseStack.pushPose();

        poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTicks, entity.yRotO, entity.getYRot()) - 90.0F));
        poseStack.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(partialTicks, entity.xRotO, entity.getXRot()) + 90.0F));

        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(buffer, model.renderType(getTextureLocation(entity)), false, false);
        model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY);

        poseStack.popPose();

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ThrownDagger thrownDagger) {
        String tierName = thrownDagger.getTierName();
        return ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "textures/entity/projectiles/" + tierName + "_dagger.png");
    }
}
