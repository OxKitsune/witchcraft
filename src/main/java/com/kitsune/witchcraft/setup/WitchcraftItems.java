package com.kitsune.witchcraft.setup;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.fml.RegistryObject;

public class WitchcraftItems {

    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties().group(ItemGroup.MATERIALS).rarity(Rarity.RARE)));

    public static final RegistryObject<Item> BELLADONNA_SEEDS = Registration.ITEMS.register("belladonna_seeds",
            () -> new BlockItem(WitchcraftBlocks.BELLADONNA_CROP.get(), new Item.Properties().group(ItemGroup.MATERIALS)));

    public static final RegistryObject<Item> TADPOLE_TAIL = Registration.ITEMS.register("tadpole_tail",
            () -> new Item(new Item.Properties()
                    .group(ItemGroup.MATERIALS)
                    .food(new Food.Builder()
                            .setAlwaysEdible()
                            .fastToEat()
                            .hunger(2)
                            .saturation(1)
                            .effect(() -> new EffectInstance(Effects.POISON, 60, 1), 0.5f)
                    .build())));

    static void register () {}

}
