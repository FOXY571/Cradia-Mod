package com.foxy_571.cradia.util;

import com.foxy_571.cradia.Cradia;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

public class PlayerReachHandler {
    private static final ResourceLocation ENTITY_REACH_MODIFIER = ResourceLocation.fromNamespaceAndPath(Cradia.MOD_ID, "entity_reach_modifier");

    public static void applyEntityReachModifier(Player player, double reachBonus) {
        AttributeInstance entityReach = player.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);

        if (entityReach != null && !entityReach.hasModifier(ENTITY_REACH_MODIFIER)) {
            AttributeModifier modifier = new AttributeModifier(ENTITY_REACH_MODIFIER, reachBonus, AttributeModifier.Operation.ADD_VALUE);
            entityReach.addTransientModifier(modifier);
        }
    }

    public static void removeEntityReachModifier(Player player) {
        AttributeInstance entityReach = player.getAttribute(Attributes.ENTITY_INTERACTION_RANGE);

        if (entityReach != null && entityReach.hasModifier(ENTITY_REACH_MODIFIER)) {
            entityReach.removeModifier(ENTITY_REACH_MODIFIER);
        }
    }
}
