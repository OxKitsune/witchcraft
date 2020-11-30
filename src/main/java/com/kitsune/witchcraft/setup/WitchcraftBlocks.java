package com.kitsune.witchcraft.setup;

import com.kitsune.witchcraft.block.BelladonnaCropsBlock;
import com.kitsune.witchcraft.block.MagicCircleBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class WitchcraftBlocks {

    public static final RegistryObject<Block> SILVER_ORE = register("silver_ore", () -> new OreBlock(AbstractBlock.Properties.create(Material.ROCK).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)));
    public static final RegistryObject<Block> SILVER_BLOCK = register("silver_block", () -> new Block(AbstractBlock.Properties.create(Material.IRON, MaterialColor.IRON).setRequiresTool().hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)));
    public static final RegistryObject<Block> MAGIC_CIRCLE = register("magic_circle", MagicCircleBlock::new);
    public static final RegistryObject<Block> BELLADONNA_CROP = registerNoItem("belladonna_crop", BelladonnaCropsBlock::new);

    static void register () {};

    private static <T extends Block> RegistryObject<T> registerNoItem (String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register (String name, Supplier<T> block) {
        RegistryObject<T> registryObject = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(registryObject.get(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
        return registryObject;
    }
}
