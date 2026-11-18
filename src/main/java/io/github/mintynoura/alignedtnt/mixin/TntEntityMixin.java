package io.github.mintynoura.alignedtnt.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.entity.TntEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TntEntity.class)
public class TntEntityMixin {
	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/TntEntity;setVelocity(DDD)V"), method = "<init>(Lnet/minecraft/world/World;DDDLnet/minecraft/entity/LivingEntity;)V")
	private static void alignedTnt$cancelTntMovement(TntEntity instance, double x, double y, double z, Operation<Void> original) {
		original.call(instance, 0.0d, y, 0.0d);
	}
}