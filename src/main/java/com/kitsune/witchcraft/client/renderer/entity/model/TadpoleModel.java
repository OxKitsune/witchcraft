package com.kitsune.witchcraft.client.renderer.entity.model;

import com.google.common.collect.ImmutableList;
import com.kitsune.witchcraft.entity.TadpoleEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.command.impl.SummonCommand;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


@OnlyIn(Dist.CLIENT)
public class TadpoleModel<T extends Entity> extends SegmentedModel<T>  {

    private final ModelRenderer body;
    private final ModelRenderer tail;

    public TadpoleModel() {
        textureWidth = 32;
        textureHeight = 32;

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 23.0F, 6.0F);
        body.setTextureOffset(0, 7).addBox(-2.0F, -2.0F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, false);

        tail = new ModelRenderer(this);
        tail.setRotationPoint(0.0F, 24.0F, 8.0F);
        setRotationAngle(tail, 0.0F, 0.0F, 1.5708F);
        tail.setTextureOffset(0, 0).addBox(-4.0F, 0.0F, 0.5F, 5.0F, 0.0F, 7.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = 1.0F;
        float f1 = 1.0F;
        if (!entityIn.isInWater()) {
            f = 1.3F;
            f1 = 1.7F;
        }

        this.tail.rotateAngleX = -f * 0.25F * MathHelper.sin(f1 * 0.4F * ageInTicks);
    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        tail.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(body, tail);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
