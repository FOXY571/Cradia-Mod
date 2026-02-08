package com.foxy_571.cradia.item.custom;

import com.foxy_571.cradia.entity.custom.TieredArrow;
import com.foxy_571.cradia.item.tier.CradiaTier;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TieredArrowItem extends ArrowItem {
    private final CradiaTier tier;

    public TieredArrowItem(CradiaTier tier, Item.Properties properties) {
        super(properties);
        this.tier = tier;
    }

    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level level, @NotNull ItemStack ammo, @NotNull LivingEntity shooter, @Nullable ItemStack weapon) {
        return new TieredArrow(level, shooter, ammo.copyWithCount(1), weapon);
    }

    @Override
    public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
        TieredArrow arrow = new TieredArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }

    public @NotNull CradiaTier getTier() {
        return tier;
    }
}
