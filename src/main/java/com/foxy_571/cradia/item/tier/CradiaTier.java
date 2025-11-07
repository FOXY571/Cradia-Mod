package com.foxy_571.cradia.item.tier;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

public class CradiaTier extends SimpleTier {
    public CradiaTier(int uses, float speed, float attackDamageBonus, Supplier<Ingredient> repairIngredient) {
        super(null, uses, speed, attackDamageBonus, 0, repairIngredient);
    }
}
