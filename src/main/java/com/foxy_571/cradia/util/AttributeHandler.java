package com.foxy_571.cradia.util;

import com.foxy_571.cradia.Cradia;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class AttributeHandler {
    public static void modifyEntityAttribute(LivingEntity entity, Holder<Attribute> attribute, double modifierValue) {
        AttributeInstance instance = entity.getAttribute(attribute);
        ResourceLocation location = getLocationOfAttribute(entity, attribute);

        if (instance != null && !instance.hasModifier(location)) {
            AttributeModifier modifier = new AttributeModifier(location, modifierValue, AttributeModifier.Operation.ADD_VALUE);
            instance.addTransientModifier(modifier);
        }
    }

    public static void removeEntityAttributeModifier(LivingEntity entity, Holder<Attribute> attribute) {
        AttributeInstance instance = entity.getAttribute(attribute);
        ResourceLocation location = getLocationOfAttribute(entity, attribute);

        if (instance != null && instance.hasModifier(location)) {
            instance.removeModifier(location);
        }
    }

    private static ResourceLocation getLocationOfAttribute(LivingEntity entity, Holder<Attribute> attribute) {
        return ResourceLocation.fromNamespaceAndPath(
                Cradia.MOD_ID,
                entity.getStringUUID() + "_" + attribute.value().getDescriptionId() + "_modifier"
        );
    }
}
