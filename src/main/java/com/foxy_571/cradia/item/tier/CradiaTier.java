package com.foxy_571.cradia.item.tier;

import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CradiaTier extends SimpleTier {
    private final String name;

    public CradiaTier(String name, int uses, float speed, float attackDamageBonus, Supplier<Ingredient> repairIngredient) {
        super(null, uses, speed, attackDamageBonus, 0, repairIngredient);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public @NotNull String toString() {
        return "CradiaTier[name=" + name + ", uses=" + getUses() + ", speed=" + getSpeed() + ", attackDamageBonus=" + getAttackDamageBonus() + ", enchantmentValue=" + getEnchantmentValue() + ", repairIngredient=" + getRepairIngredient() + "]";
    }
}
