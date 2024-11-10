package io.github.eman7blue.slimetweaker;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = SlimeTweaker.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class SlimeTweakerConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue MAX_SLIME_SIZE_DEFAULT = BUILDER
            .comment("The default value for the maxSlimeSize gamerule. Changing this does NOT change what the gamerule is set to in an already generated world.")
            .comment("These aren't the size values you see when you use /data or /summon, read the mod page to understand why these numbers are different.")
            .defineInRange("maxSlimeSizeDefault", 2, 0, 7);
    private static final ModConfigSpec.IntValue DIFFICULTY_MODIFIER_MAX_SLIME_SIZE = BUILDER
            .comment("When a slime spawns, there is a chance it is grown by 1. By default this only applies to medium slimes (size 1) and smaller. Set it to 0 to disable.")
            .defineInRange("difficultyModifierMaxSlimeSize", 1, 0, 5);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static int maxSlimeSizeDefault;
    public static int difficultyModifierMaxSlimeSize;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        maxSlimeSizeDefault = MAX_SLIME_SIZE_DEFAULT.get();
        difficultyModifierMaxSlimeSize = DIFFICULTY_MODIFIER_MAX_SLIME_SIZE.get();

    }
}
