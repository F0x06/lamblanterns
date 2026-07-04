package me.f0x.lamblanterns.client;

import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

/**
 * Client-only holder that wires the in-game config button (Mods → Lamb Lanterns → Config)
 * to NeoForge's auto-generated configuration screen. Kept in a separate class so the
 * client-only {@link ConfigurationScreen} type is never loaded on a dedicated server.
 */
public final class LambLanternsConfigScreen {
    private LambLanternsConfigScreen() {}

    public static void register(ModContainer container) {
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
