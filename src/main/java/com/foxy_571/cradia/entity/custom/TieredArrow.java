package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.entity.ModEntities;
import com.foxy_571.cradia.item.ModItems;
import com.foxy_571.cradia.item.custom.TieredArrowItem;
import com.foxy_571.cradia.item.tier.CradiaTier;
import com.foxy_571.cradia.item.tier.ModTiers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class TieredArrow extends AbstractArrow {
    private String tierName = ModTiers.CRADIUM.getName();

    public TieredArrow(EntityType<? extends TieredArrow> entityType, Level level) {
        super(entityType, level);
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
        Item item = getPickupItemStackOrigin().getItem();
        if (item instanceof TieredArrowItem tieredArrowItem) {
            CradiaTier tier = tieredArrowItem.getTier();
            tierName = tier.getName();
            setBaseDamage(tier.getAttackDamageBonus());
        }
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
        return new ItemStack(ModItems.CRADIUM_ARROW.get());
    }
}
