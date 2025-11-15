package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.item.custom.TieredArrowItem;
import com.foxy_571.cradia.item.tier.CradiaTier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public abstract class TieredArrow extends AbstractArrow {
    private String tierName;

    public TieredArrow(EntityType<? extends TieredArrow> entityType, Level level) {
        super(entityType, level);
        updateType();
    }

    public TieredArrow(EntityType<? extends TieredArrow> entityType, double x, double y, double z, Level level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(entityType, x, y, z, level, pickupItemStack, firedFromWeapon);
        updateType();
    }

    public TieredArrow(EntityType<? extends TieredArrow> entityType, LivingEntity owner, Level level, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(entityType, owner, level, pickupItemStack, firedFromWeapon);
        updateType();
    }

    private void updateType() {
        CradiaTier tier = getTieredArrowItem().getTier();
        tierName = tier.getName();
        setBaseDamage(tier.getAttackDamageBonus());
    }

    public String getTierName() {
        return tierName;
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.contains("tier")) {
            tierName = tag.getString("tier");
            updateType();
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putString("tier", tierName);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(getTieredArrowItem());
    }

    protected abstract @NotNull TieredArrowItem getTieredArrowItem();
}
