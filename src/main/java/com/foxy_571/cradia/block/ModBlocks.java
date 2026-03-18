package com.foxy_571.cradia.block;

import com.foxy_571.cradia.Cradia;
import com.foxy_571.cradia.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Cradia.MOD_ID);

    public static final DeferredBlock<Block> ADRENA_ORE;
    public static final DeferredBlock<Block> DEEPSLATE_ADRENA_ORE;
    public static final DeferredBlock<Block> CRADIUM_ORE;
    public static final DeferredBlock<Block> NAUADIAN_BLOCK;
    public static final DeferredBlock<Block> ADRENA_BLOCK;
    public static final DeferredBlock<Block> CRADIUM_BLOCK;
    public static final DeferredBlock<Block> NAUADIAN_SHARD_BLOCK;
    public static final DeferredBlock<Block> RAW_ADRENA_BLOCK;

    static {
        ADRENA_ORE = registerBlock("adrena_ore", () -> new Block(Block.Properties.ofFullCopy(Blocks.GOLD_ORE)));
        DEEPSLATE_ADRENA_ORE = registerBlock("deepslate_adrena_ore", () -> new Block(Block.Properties.ofFullCopy(Blocks.DEEPSLATE_GOLD_ORE)));
        CRADIUM_ORE = registerBlock("cradium_ore", () -> new Block(Block.Properties.ofFullCopy(Blocks.ANCIENT_DEBRIS).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        NAUADIAN_BLOCK = registerBlock("nauadian_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        ADRENA_BLOCK = registerBlock("adrena_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.GOLD_BLOCK).mapColor(MapColor.COLOR_RED)));
        CRADIUM_BLOCK = registerBlock("cradium_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).sound(SoundType.METAL).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        NAUADIAN_SHARD_BLOCK = registerBlock("nauadian_shard_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        RAW_ADRENA_BLOCK = registerBlock("raw_adrena_block", () -> new Block(Block.Properties.ofFullCopy(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.COLOR_RED)));
    }

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
