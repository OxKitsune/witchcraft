package com.kitsune.witchcraft.entity;

import com.kitsune.witchcraft.setup.WitchcraftItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.AbstractGroupFishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class TadpoleEntity extends AbstractGroupFishEntity {

    public TadpoleEntity(EntityType<? extends TadpoleEntity> type, World worldIn) {
        super(type, worldIn);
    }

    // func_234176_m_() --> registerAttributes()
    // This is the first reference I found while trying to find one in the superclasses
    // I've also tried MobEntity, but that doesn't work.
    public static AttributeModifierMap.MutableAttribute setCustomAttributes () {
        return AbstractFishEntity.func_234176_m_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 2.5D)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    @Override
    public int getMaxGroupSize() {
        return 5;
    }

    @Override
    protected ItemStack getFishBucket() {
        // Temporary since I cba to add a new item just for this
        return new ItemStack(WitchcraftItems.SILVER_INGOT.get());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SALMON_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SALMON_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SALMON_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_SALMON_FLOP;
    }
}
