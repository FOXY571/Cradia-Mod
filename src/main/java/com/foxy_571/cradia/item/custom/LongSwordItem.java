package com.foxy_571.cradia.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import org.jetbrains.annotations.NotNull;

public class LongSwordItem extends SwordItem {
    public LongSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }
}
