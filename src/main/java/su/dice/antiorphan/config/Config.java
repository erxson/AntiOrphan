package su.dice.antiorphan.config;

import org.bukkit.configuration.file.FileConfiguration;
import su.dice.antiorphan.AntiOrphan;

public class Config {
    public static FileConfiguration config;

    public static void init() {
        AntiOrphan.plugin.saveDefaultConfig();
        load();
    }

    public static void load() {
        AntiOrphan.plugin.reloadConfig();
        config = AntiOrphan.plugin.getConfig();
    }
}
