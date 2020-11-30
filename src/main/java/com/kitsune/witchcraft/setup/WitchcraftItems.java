package com.kitsune.witchcraft.setup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;

public class WitchcraftItems {

    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> BELLADONNA_SEEDS = Registration.ITEMS.register("belladonna_seeds",
            () -> new BlockItem(WitchcraftBlocks.BELLADONNA_CROP.get(), new Item.Properties().group(ItemGroup.MATERIALS)));

    static void register () {}

}
