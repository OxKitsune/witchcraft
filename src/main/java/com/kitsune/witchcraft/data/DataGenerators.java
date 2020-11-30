package com.kitsune.witchcraft.data;

import com.kitsune.witchcraft.WitchcraftMod;
import com.kitsune.witchcraft.data.client.WitchcraftBlockStateProvider;
import com.kitsune.witchcraft.data.client.WitchcraftItemModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WitchcraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData (GatherDataEvent e) {
        DataGenerator dataGenerator = e.getGenerator();
        ExistingFileHelper existingFileHelper = e.getExistingFileHelper();

        dataGenerator.addProvider(new WitchcraftBlockStateProvider(dataGenerator, existingFileHelper));
        dataGenerator.addProvider(new WitchcraftItemModelProvider(dataGenerator, existingFileHelper));
    }

}
