package com.foxy_571.cradia.entity.custom;

import com.foxy_571.cradia.entity.ModEntities;
import com.foxy_571.cradia.item.ModItems;
import com.foxy_571.cradia.item.custom.TieredArrowItem;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class CradiumArrow extends TieredArrow {
    public CradiumArrow(EntityType<? extends TieredArrow> entityType, Level level) {
        super(entityType, level);
    }

    public CradiumArrow(Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.CRADIUM_ARROW.get(), x, y, z, level, pickupItemStack, firedFromWeapon);
    }

    public CradiumArrow(Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(ModEntities.CRADIUM_ARROW.get(), owner, level, pickupItemStack, firedFromWeapon);
    }

    @Override
    protected @NotNull TieredArrowItem getTieredArrowItem() {
        return ModItems.CRADIUM_ARROW.get();
    }
}
