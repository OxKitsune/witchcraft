package com.kitsune.witchcraft.client.renderer.entity;

import com.kitsune.witchcraft.WitchcraftMod;
import com.kitsune.witchcraft.client.renderer.entity.model.TadpoleModel;
import com.kitsune.witchcraft.entity.TadpoleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class TadpoleRenderer extends MobRenderer<TadpoleEntity, TadpoleModel<TadpoleEntity>> {

    private static final ResourceLocation TADPOLE_LOCATION = new ResourceLocation(WitchcraftMod.MOD_ID, "textures/entity/tadpole/tadpole.png");

    public TadpoleRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new TadpoleModel<>(), 0.4f);
    }

    @Override
    protected void applyRotations(TadpoleEntity entityLiving, MatrixStack matrixStackIn, float ageInTicks, float rotationYaw, float partialTicks) {
        super.applyRotations(entityLiving, matrixStackIn, ageInTicks, rotationYaw, partialTicks);
        float f = 1.0F;
        float f1 = 1.0F;
        if (!entityLiving.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        float f2 = f * 4.3F * MathHelper.sin(f1 * 0.6F * ageInTicks);
        matrixStackIn.rotate(Vector3f.YP.rotationDegrees(f2));
        matrixStackIn.translate(0.0D, 0.0D, (double)-0.4F);
        if (!entityLiving.isInWater()) {
            matrixStackIn.translate((double)0.2F, (double)0.1F, 0.0D);
            matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(90.0F));
        }
    }

    @Override
    public ResourceLocation getEntityTexture(TadpoleEntity entity) {
        return TADPOLE_LOCATION;
    }
}
