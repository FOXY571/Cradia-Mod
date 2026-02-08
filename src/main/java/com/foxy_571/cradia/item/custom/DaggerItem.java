package com.foxy_571.cradia.item.custom;

import com.foxy_571.cradia.entity.custom.ThrownDagger;
import com.foxy_571.cradia.item.tier.CradiaTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TieredItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class DaggerItem extends TieredItem implements ProjectileItem {
    private final CradiaTier tier;

    public DaggerItem(Tier tier, Properties properties) {
        super(tier, properties);
        this.tier = (CradiaTier)tier;
        DispenserBlock.registerProjectileBehavior(this);
    }

    @Override
    public boolean isEnchantable(@NotNull ItemStack stack) {
        return false;
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, int attackDamage, float attackSpeed) {
        return createAttributes(tier, (float)attackDamage, attackSpeed);
    }

    public static ItemAttributeModifiers createAttributes(Tier tier, float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, (attackDamage + tier.getAttackDamageBonus()), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, attackSpeed, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                .build();
    }

    @Override
    public boolean canAttackBlock(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, Player player) {
        return !player.isCreative();
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level level, @NotNull Player player, @NotNull InteractionHand usedHand) {
        ItemStack stack = player.getItemInHand(usedHand);
        if (isTooDamagedToUse(stack)) {
            return InteractionResultHolder.fail(stack);
        } else {
            if (!level.isClientSide) {
            stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(usedHand));
                ThrownDagger thrownDagger = new ThrownDagger(level, player, stack);
                thrownDagger.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                if (player.hasInfiniteMaterials()) {
                    thrownDagger.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                }

                level.addFreshEntity(thrownDagger);
                level.playSound(null, thrownDagger, SoundEvents.EGG_THROW, SoundSource.PLAYERS, 0.5F, 0.4F / (level.getRandom().nextFloat() * 0.4F + 0.8F));

                if (!player.hasInfiniteMaterials()) {
                    player.getInventory().removeItem(stack);
                }
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }

        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }

    private static boolean isTooDamagedToUse(ItemStack stack) {
        return stack.getDamageValue() >= stack.getMaxDamage() - 1;
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        return true;
    }

    @Override
    public void postHurtEnemy(ItemStack stack, @NotNull LivingEntity target, @NotNull LivingEntity attacker) {
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
    }

    @Override
    public @NotNull Projectile asProjectile(@NotNull Level level, @NotNull Position pos, @NotNull ItemStack stack, @NotNull Direction direction) {
        ThrownDagger thrownDagger = new ThrownDagger(level, pos.x(), pos.y(), pos.z(), stack.copyWithCount(1));
        thrownDagger.pickup = AbstractArrow.Pickup.ALLOWED;
        return thrownDagger;
    }

    public @NotNull CradiaTier getTier() {
        return tier;
    }
}
