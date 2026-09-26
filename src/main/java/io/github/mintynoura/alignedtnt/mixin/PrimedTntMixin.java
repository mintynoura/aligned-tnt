package io.github.mintynoura.alignedtnt.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.item.PrimedTnt;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PrimedTnt.class)
public class PrimedTntMixin {
	@WrapOperation(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/item/PrimedTnt;setDeltaMovement(DDD)V"), method = "<init>(Lnet/minecraft/world/level/Level;DDDLnet/minecraft/world/entity/LivingEntity;)V")
	private static void alignedTnt$cancelTntMovement(PrimedTnt instance, double x, double y, double z, Operation<Void> original) {
		original.call(instance, 0.0d, y, 0.0d);
	}
}