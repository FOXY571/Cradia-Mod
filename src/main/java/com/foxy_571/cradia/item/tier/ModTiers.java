package com.foxy_571.cradia.item.tier;

import com.foxy_571.cradia.item.ModItems;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final CradiaTier ADRENA = new CradiaTier("adrena", 1796, 8.5F, 3.5F, () -> Ingredient.of(ModItems.ADRENA_INGOT));
    public static final CradiaTier CRADIUM = new CradiaTier("cradium", 4062, 10.0F, 5.0F, () -> Ingredient.of(ModItems.CRADIUM_INGOT));
}
