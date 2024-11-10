package io.github.eman7blue.slimetweaker;

import com.mojang.logging.LogUtils;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import org.slf4j.Logger;

@Mod(SlimeTweaker.MOD_ID)
public class SlimeTweaker {
    public static final String MOD_ID = "slimetweaker";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final GameRules.Key<GameRules.IntegerValue> MAX_SLIME_SIZE = GameRules.register("maxSlimeSize", GameRules.Category.MOBS, GameRules.IntegerValue.create(SlimeTweakerConfig.maxSlimeSizeDefault));

    public SlimeTweaker(IEventBus modEventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, io.github.eman7blue.slimetweaker.SlimeTweakerConfig.SPEC);
        LOGGER.info("don't worry puppy, the mod has loaded");
    }
}
