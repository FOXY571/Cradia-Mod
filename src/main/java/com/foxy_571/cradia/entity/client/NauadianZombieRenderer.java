package com.foxy_571.cradia.entity.client;

import com.foxy_571.cradia.Cradia;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class NauadianZombieRenderer extends ZombieRenderer {
    public NauadianZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Zombie entity) {
        return ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "textures/entity/nauadian_zombie.png");
    }
}
