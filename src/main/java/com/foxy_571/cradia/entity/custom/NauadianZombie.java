package com.foxy_571.cradia.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.event.EventHooks;
import org.jetbrains.annotations.NotNull;

public class NauadianZombie extends Zombie {
    public NauadianZombie(EntityType<? extends NauadianZombie> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void doUnderWaterConversion() {
        if (EventHooks.canLivingConvert(this, EntityType.ZOMBIE, (timer) -> this.conversionTime = timer)) {
            this.convertToZombieType(EntityType.ZOMBIE);
            if (!this.isSilent()) {
                this.level().levelEvent(null, 1041, this.blockPosition(), 0);
            }

        }
    }

    @Override
    protected @NotNull ItemStack getSkull() {
        return ItemStack.EMPTY;
    }
}
