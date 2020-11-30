package com.kitsune.witchcraft.setup;

import com.kitsune.witchcraft.entity.TadpoleEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;

public class WitchcraftEntityTypes {

    public static final RegistryObject<EntityType<TadpoleEntity>> TADPOLE_ENTITY = Registration.ENTITIES.register("tadpole", () -> EntityType.Builder.<TadpoleEntity>create(EntityClassification.WATER_AMBIENT).size(0.7f, 0.4f).trackingRange(4).build("tadpole"));

    public static void register() {
    }
}
