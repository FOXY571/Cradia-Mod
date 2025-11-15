package com.foxy_571.cradia.item.custom;

import com.foxy_571.cradia.entity.custom.AdrenaArrow;
import com.foxy_571.cradia.entity.custom.CradiumArrow;
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

    // These hardcoded values should probably be dealt with in the future
    @Override
    public @NotNull AbstractArrow createArrow(@NotNull Level level, @NotNull ItemStack ammo, @NotNull LivingEntity shooter, @Nullable ItemStack weapon) {
        return switch (tier.getName()) {
            case "cradium" -> new CradiumArrow(level, shooter, ammo.copyWithCount(1), weapon);
            case "adrena" -> new AdrenaArrow(level, shooter, ammo.copyWithCount(1), weapon);
            default -> new AdrenaArrow(level, shooter, ammo.copyWithCount(1), weapon);
        };
    }

    // These hardcoded values should probably be dealt with in the future
    @Override
    public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
        TieredArrow arrow = switch (tier.getName()) {
            case "cradium" -> new CradiumArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
            case "adrena" -> new AdrenaArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
            default -> new AdrenaArrow(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1), null);
        };
        arrow.pickup = AbstractArrow.Pickup.ALLOWED;
        return arrow;
    }

    public CradiaTier getTier() {
        return tier;
    }
}
