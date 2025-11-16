package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.entity.ModEntities;
import com.foxy_571.cradia.item.ModItems;
import com.foxy_571.cradia.item.custom.TieredArrowItem;
import com.foxy_571.cradia.item.tier.CradiaTier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TieredArrow extends AbstractArrow {
    private final static EntityDataAccessor<String> TIER_NAME =
            SynchedEntityData.defineId(TieredArrow.class, EntityDataSerializers.STRING);

    public TieredArrow(EntityType<? extends TieredArrow> entityType, Level level) {
        super(entityType, level);
        updateType();
    }

    public TieredArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.TIERED_ARROW.get(), x, y, z, level, pickupItemStack, firedFromWeapon);
        updateType();
    }

    public TieredArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.TIERED_ARROW.get(), owner, level, pickupItemStack, firedFromWeapon);
        updateType();
    }

    private void updateType() {
        Item item = getPickupItem().getItem();

        TieredArrowItem tieredArrowItem = (TieredArrowItem) getDefaultPickupItem().getItem();
        if (item instanceof TieredArrowItem) {
            tieredArrowItem = (TieredArrowItem) item;
        }

        CradiaTier tier = tieredArrowItem.getTier();
        entityData.set(TIER_NAME, tier.getName());
        setBaseDamage(tier.getAttackDamageBonus());
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("tier_name", getTierName());
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(TIER_NAME, compound.getString("tier_name"));
    }

    public String getTierName() {
        return entityData.get(TIER_NAME);
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.ADRENA_ARROW.get());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(TIER_NAME, ((TieredArrowItem) getDefaultPickupItem().getItem()).getTier().getName());
    }
}
