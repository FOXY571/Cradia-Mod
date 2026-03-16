package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.entity.ModEntityTypes;
import com.foxy_571.cradia.item.ModItems;
import com.foxy_571.cradia.item.custom.DaggerItem;
import com.foxy_571.cradia.item.tier.CradiaTier;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class ThrownDagger extends AbstractArrow {
    private final static EntityDataAccessor<String> TIER_NAME =
            SynchedEntityData.defineId(ThrownDagger.class, EntityDataSerializers.STRING);
    private boolean dealtDamage;

    public ThrownDagger(EntityType<? extends ThrownDagger> entityType, Level level) {
        super(entityType, level);
        updateType();
    }

    public ThrownDagger(Level level, LivingEntity shooter, ItemStack pickupItemStack) {
        super(ModEntityTypes.THROWN_DAGGER.get(), shooter, level, pickupItemStack, null);
        updateType();
    }

    public ThrownDagger(Level level, double x, double y, double z, ItemStack pickupItemStack) {
        super(ModEntityTypes.THROWN_DAGGER.get(), x, y, z, level, pickupItemStack, pickupItemStack);
        updateType();
    }

    private void updateType() {
        Item item = getPickupItem().getItem();
        if (item instanceof DaggerItem daggerItem) {
            CradiaTier tier = daggerItem.getTier();
            entityData.set(TIER_NAME, tier.getName());
            setBaseDamage(0.5F + tier.getAttackDamageBonus());
        }
    }

    @Nullable
    @Override
    protected EntityHitResult findHitEntity(@NotNull Vec3 startVec, @NotNull Vec3 endVec) {
        return dealtDamage ? null : super.findHitEntity(startVec, endVec);
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        Entity owner = getOwner();
        DamageSource damagesource = damageSources().thrown(this, (owner == null ? this : owner));

        dealtDamage = true;
        if (entity.hurt(damagesource, (float)getBaseDamage())) {
            if (entity.getType() == EntityType.ENDERMAN) {
                return;
            }

            if (entity instanceof LivingEntity livingEntity) {
                doKnockback(livingEntity, damagesource);
                doPostHurtEffects(livingEntity);
            }
        }

        setDeltaMovement(getDeltaMovement().multiply(-0.01, -0.1, -0.01));
        playSound(SoundEvents.TRIDENT_HIT, 1.0F, 1.0F);
    }

    @Override
    public @NotNull ItemStack getWeaponItem() {
        return getPickupItemStackOrigin();
    }

    @Override
    protected boolean tryPickup(@NotNull Player player) {
        return super.tryPickup(player) || isNoPhysics() && ownedBy(player) && player.getInventory().add(getPickupItem());
    }

    @Override
    protected @NotNull ItemStack getDefaultPickupItem() {
        return new ItemStack(ModItems.NAUADIAN_DAGGER.get());
    }

    @Override
    protected @NotNull SoundEvent getDefaultHitGroundSoundEvent() {
        return SoundEvents.TRIDENT_HIT_GROUND;
    }

    @Override
    public void playerTouch(@NotNull Player entity) {
        if (ownedBy(entity) || getOwner() == null) {
            super.playerTouch(entity);
        }
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putString("tier_name", getTierName());
        dealtDamage = compound.getBoolean("dealt_damage");
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        entityData.set(TIER_NAME, compound.getString("tier_name"));
        compound.putBoolean("dealt_damage", dealtDamage);
    }

    public String getTierName() {
        return entityData.get(TIER_NAME);
    }

    @Override
    public void tickDespawn() {
        if (pickup != Pickup.ALLOWED) {
            super.tickDespawn();
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {
        super.defineSynchedData(builder);
        builder.define(TIER_NAME, ((DaggerItem) getDefaultPickupItem().getItem()).getTier().getName());
    }
}
