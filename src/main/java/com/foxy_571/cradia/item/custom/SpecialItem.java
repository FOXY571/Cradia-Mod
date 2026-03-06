package com.foxy_571.cradia.item.custom;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SpecialItem extends Item {
    public SpecialItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        if (!level.isClientSide) {
            boolean isCrouching = player.isCrouching();
            boolean heightCheck = (int)player.position().y >= level.getMaxBuildHeight();

            if (isCrouching && heightCheck) {
                // Do special stuff...
                player.addItem(new ItemStack(ModItems.NAUADIAN_INGOT.get()));
                player.addItem(new ItemStack(ModItems.ADRENA_INGOT.get()));
                player.addItem(new ItemStack(ModItems.CRADIUM_INGOT.get()));

                Cradia.LOGGER.info("{} used the special item!", player.getGameProfile().getName());
            }
        }

        return super.use(level, player, usedHand);
    }
}
