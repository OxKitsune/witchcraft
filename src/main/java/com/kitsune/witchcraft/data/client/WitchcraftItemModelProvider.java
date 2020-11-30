package com.kitsune.witchcraft.data.client;

import com.kitsune.witchcraft.WitchcraftMod;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WitchcraftItemModelProvider extends ItemModelProvider {

    public WitchcraftItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WitchcraftMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("silver_block", modLoc("block/silver_block"));
        withExistingParent("silver_ore", modLoc("block/silver_ore"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));
        builder(itemGenerated, "silver_ingot");
        builder(itemGenerated, "belladonna_seeds");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
