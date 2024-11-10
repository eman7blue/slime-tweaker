package io.github.eman7blue.slimetweaker.mixin;

import io.github.eman7blue.slimetweaker.SlimeTweakerConfig;
import io.github.eman7blue.slimetweaker.SlimeTweaker;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.ServerLevelAccessor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Slime.class)
public abstract class SlimeMixin {
    @ModifyConstant(method = "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;",
            constant = @Constant(intValue = 3))
    private int maxSlimeSizeSet(int value, ServerLevelAccessor pLevel){
        return pLevel.getLevel().getGameRules().getRule(SlimeTweaker.MAX_SLIME_SIZE).get() + 1;
    }

    @ModifyConstant(method = "finalizeSpawn(Lnet/minecraft/world/level/ServerLevelAccessor;Lnet/minecraft/world/DifficultyInstance;Lnet/minecraft/world/entity/MobSpawnType;Lnet/minecraft/world/entity/SpawnGroupData;)Lnet/minecraft/world/entity/SpawnGroupData;",
            constant = @Constant(intValue = 2))
    private int difficultyModifierMaxSlimeSizeSet(int value, ServerLevelAccessor pLevel){
        return SlimeTweakerConfig.difficultyModifierMaxSlimeSize;
    }
}
