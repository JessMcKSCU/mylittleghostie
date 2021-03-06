package net.mcreator.mylittleghostie.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import net.mcreator.mylittleghostie.entity.MyLittleGhostieEntity;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MyLittleGhostieRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(MyLittleGhostieEntity.entity, renderManager -> {
				return new MobRenderer(renderManager, new ModelMyLittleGhostie(), 0.5f) {
					@Override
					public ResourceLocation getEntityTexture(Entity entity) {
						return new ResourceLocation("my_little_ghostie:textures/cute-ghost-skin-edited.png");
					}
				};
			});
		}
	}

	// Made with Blockbench 3.9.2
	// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
	// Paste this class into your mod and generate all required imports
	public static class ModelMyLittleGhostie extends EntityModel<Entity> {
		private final ModelRenderer bone;
		private final ModelRenderer midsection;
		private final ModelRenderer legs;
		public ModelMyLittleGhostie() {
			textureWidth = 48;
			textureHeight = 48;
			bone = new ModelRenderer(this);
			bone.setRotationPoint(8.0F, 24.0F, -8.0F);
			bone.setTextureOffset(1, 1).addBox(-12.0F, -11.0F, 4.0F, 6.0F, 6.0F, 5.0F, 0.0F, false);
			midsection = new ModelRenderer(this);
			midsection.setRotationPoint(8.0F, 24.0F, -8.0F);
			midsection.setTextureOffset(0, 26).addBox(-11.25F, -5.2F, 5.0F, 4.0F, 1.0F, 3.0F, 0.0F, false);
			midsection.setTextureOffset(28, 14).addBox(-11.25F, -5.0F, 5.0F, 4.0F, 2.0F, 3.0F, 0.0F, false);
			legs = new ModelRenderer(this);
			legs.setRotationPoint(8.0F, 24.0F, -8.0F);
			legs.setTextureOffset(26, 39).addBox(-11.0F, -4.1F, 5.5027F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			legs.setTextureOffset(32, 39).addBox(-8.0F, -4.3F, 5.5027F, 1.0F, 3.0F, 1.0F, 0.0F, false);
			legs.setTextureOffset(27, 38).addBox(-9.0F, -4.8F, 6.5027F, 1.0F, 4.0F, 1.0F, 0.0F, true);
			legs.setTextureOffset(33, 39).addBox(-10.0F, -4.5F, 6.5027F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		}

		@Override
		public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
			// previously the render function, render code was moved to a method below
		}

		@Override
		public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue,
				float alpha) {
			bone.render(matrixStack, buffer, packedLight, packedOverlay);
			midsection.render(matrixStack, buffer, packedLight, packedOverlay);
			legs.render(matrixStack, buffer, packedLight, packedOverlay);
		}

		public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
			modelRenderer.rotateAngleX = x;
			modelRenderer.rotateAngleY = y;
			modelRenderer.rotateAngleZ = z;
		}
	}
}
