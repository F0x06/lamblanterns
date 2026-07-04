package me.f0x.lamblanterns;

import net.neoforged.neoforge.common.ModConfigSpec;

/**
 * Client-side configuration for the worn lantern's position on the player model.
 *
 * <p>The offsets use the same normalized-percent convention as the renderer's body
 * anchor: {@code 0} is the body-cube centre, {@code +1} is the AABB minimum and
 * {@code -1} the maximum along that axis. Values outside {@code [-1,1]} extrapolate
 * beyond the body. Axis directions (model space): +X is the entity's left,
 * +Y is down, +Z is the entity's back.
 *
 * <p>Defaults reproduce the original hard-coded right-hip placement. Flip the sign of
 * {@link #horizontalOffset} to hang the lantern on the left hip instead.
 */
public final class LambLanternsConfig {
    private LambLanternsConfig() {}

    public static final ModConfigSpec SPEC;

    private static final ModConfigSpec.DoubleValue HORIZONTAL_OFFSET;
    private static final ModConfigSpec.DoubleValue VERTICAL_OFFSET;
    private static final ModConfigSpec.DoubleValue DEPTH_OFFSET;

    static {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Lantern position on the player model")
                .translation("lamblanterns.configuration.position")
                .push("position");

        HORIZONTAL_OFFSET = builder
                .comment(
                        "Horizontal offset across the body (X axis).",
                        "  0.0 = centred on the body",
                        "  positive = towards the right hip (1.0 = default right hip)",
                        "  negative = towards the left hip (-1.0 = left hip)",
                        "Larger magnitudes push the lantern further off the side.")
                .translation("lamblanterns.configuration.horizontalOffset")
                .defineInRange("horizontalOffset", 1.0, -4.0, 4.0);

        VERTICAL_OFFSET = builder
                .comment(
                        "Vertical offset along the body (Y axis).",
                        "Higher values raise the lantern (towards the chest),",
                        "lower values drop it (towards the belt/hip). Dial to taste.")
                .translation("lamblanterns.configuration.verticalOffset")
                .defineInRange("verticalOffset", -1.55, -4.0, 4.0);

        DEPTH_OFFSET = builder
                .comment(
                        "Depth offset (Z axis).",
                        "Higher values move the lantern towards the front of the body,",
                        "lower values towards the back. Dial to taste.")
                .translation("lamblanterns.configuration.depthOffset")
                .defineInRange("depthOffset", -1.0, -4.0, 4.0);

        builder.pop();
        SPEC = builder.build();
    }

    public static float horizontalOffset() {
        return HORIZONTAL_OFFSET.get().floatValue();
    }

    public static float verticalOffset() {
        return VERTICAL_OFFSET.get().floatValue();
    }

    public static float depthOffset() {
        return DEPTH_OFFSET.get().floatValue();
    }
}
