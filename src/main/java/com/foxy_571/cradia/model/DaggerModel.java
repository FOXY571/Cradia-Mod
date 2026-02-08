package com.foxy_571.cradia.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class DaggerModel extends Model {
	private final ModelPart root;

	public DaggerModel(ModelPart root) {
		super(RenderType::entitySolid);
		this.root = root.getChild("dagger");
	}

	public static LayerDefinition createLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("dagger", CubeListBuilder.create()
						.texOffs(0, 0).addBox(-3.0F, -3.0F, -0.5F, 3.0F, 3.0F, 1.0F)
						.texOffs(8, 0).addBox(0.0F, -2.0F, -0.5F, 1.0F, 5.0F, 1.0F)
						.texOffs(8, 6).addBox(1.0F, -1.0F, -0.5F, 1.0F, 5.0F, 1.0F)
						.texOffs(0, 4).addBox(2.0F, 0.0F, -0.5F, 1.0F, 7.0F, 1.0F)
						.texOffs(12, 5).addBox(-2.0F, 0.0F, -0.5F, 2.0F, 1.0F, 1.0F)
						.texOffs(0, 12).addBox(5.0F, 1.0F, -0.5F, 2.0F, 3.0F, 1.0F)
						.texOffs(4, 4).addBox(3.0F, 1.0F, -0.5F, 1.0F, 6.0F, 1.0F)
						.texOffs(0, 16).addBox(-1.0F, 1.0F, -0.5F, 1.0F, 1.0F, 1.0F)
						.texOffs(12, 0).addBox(4.0F, 2.0F, -0.5F, 1.0F, 4.0F, 1.0F)
						.texOffs(6, 12).addBox(5.0F, 4.0F, -0.5F, 1.0F, 3.0F, 1.0F)
						.texOffs(12, 7).addBox(6.0F, 5.0F, -0.5F, 1.0F, 3.0F, 1.0F)
						.texOffs(14, 11).addBox(1.0F, 5.0F, -0.5F, 1.0F, 2.0F, 1.0F)
						.texOffs(10, 12).addBox(7.0F, 6.0F, -0.5F, 1.0F, 3.0F, 1.0F)
						.texOffs(14, 14).addBox(8.0F, 7.0F, -0.5F, 1.0F, 2.0F, 1.0F),
				PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(@NotNull PoseStack poseStack, @NotNull VertexConsumer buffer, int packedLight, int packedOverlay, int color) {
		root.render(poseStack, buffer, packedLight, packedOverlay, color);
	}
}