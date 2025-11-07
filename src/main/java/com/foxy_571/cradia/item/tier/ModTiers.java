package com.foxy_571.cradia.item.tier;

import com.foxy_571.cradia.item.ModItems;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

public class ModTiers {
    public static final Tier CRADIUM = new CradiaTier(4062, 10.0F, 5.0F, () -> Ingredient.of(ModItems.CRADIUM_INGOT));
}
