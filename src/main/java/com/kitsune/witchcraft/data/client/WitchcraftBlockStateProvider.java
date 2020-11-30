package com.kitsune.witchcraft.data.client;

import com.kitsune.witchcraft.WitchcraftMod;
import com.kitsune.witchcraft.setup.WitchcraftBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;


public class WitchcraftBlockStateProvider extends BlockStateProvider {

    public WitchcraftBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, WitchcraftMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(WitchcraftBlocks.SILVER_BLOCK.get());
        simpleBlock(WitchcraftBlocks.SILVER_ORE.get());
    }
}
