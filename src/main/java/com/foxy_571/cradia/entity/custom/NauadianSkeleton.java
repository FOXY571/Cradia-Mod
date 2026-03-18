package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.item.ModItems;
import com.foxy_571.cradia.item.custom.TieredArrowItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NauadianSkeleton extends AbstractSkeleton {
    public NauadianSkeleton(EntityType<? extends NauadianSkeleton> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.SKELETON_AMBIENT;
    }

    @Override
    protected @NotNull SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.SKELETON_HURT;
    }

    @Override
    protected @NotNull SoundEvent getDeathSound() {
        return SoundEvents.SKELETON_DEATH;
    }

    @Override
    protected @NotNull SoundEvent getStepSound() {
        return SoundEvents.SKELETON_STEP;
    }

    @Override
    protected @NotNull AbstractArrow getArrow(@NotNull ItemStack arrow, float velocity, @Nullable ItemStack weapon) {
        AbstractArrow abstractarrow = ((ArrowItem)ModItems.NAUADIAN_ARROW.get()).createArrow(level(), arrow, this, weapon);
        abstractarrow.setBaseDamageFromMob(velocity);
        return abstractarrow;
    }
}
