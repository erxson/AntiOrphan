package su.dice.antiorphan.config;

import org.bukkit.configuration.file.FileConfiguration;
import su.dice.antiorphan.AntiOrphan;

public class Config {
    public static FileConfiguration config;

    public static long FLAG_RETENTION;
    public static int WEIGHT_FOR_KICK;
    public static int MAX_HOURS_FOR_KICK;
    public static boolean BROADCAST_ON_KICK;

    public static boolean PRIME_TNT_ENABLED;
    public static boolean PRIME_TNT_FLAG_ONLY_ON_SPAWN;
    public static int PRIME_TNT_WEIGHT;
    public static int PRIME_TNT_NEWBIES_MIN_HOURS;
    public static String PRIME_TNT_NEWBIES_MESSAGE;

    public static boolean BREAK_CONTAINER_ENABLED;
    public static boolean BREAK_CONTAINER_FLAG_ONLY_ON_SPAWN;
    public static int BREAK_CONTAINER_WEIGHT;
    public static int BREAK_CONTAINER_NEWBIES_MIN_HOURS;
    public static String BREAK_CONTAINER_NEWBIES_MESSAGE;

    public static void init() {
        AntiOrphan.plugin.saveDefaultConfig();
        load();
    }

    public static void load() {
        AntiOrphan.plugin.reloadConfig();
        config = AntiOrphan.plugin.getConfig();

        FLAG_RETENTION = config.getLong("flags.flag-retention", 5) * 60 * 1000;
        WEIGHT_FOR_KICK = config.getInt("flags.weight-for-kick", 10);
        MAX_HOURS_FOR_KICK = config.getInt("flags.max-hours-for-kick", 24) * 60;
        BROADCAST_ON_KICK = config.getBoolean("flags.broadcast-on-kick", true);

        PRIME_TNT_ENABLED = config.getBoolean("flags.checks.prime-tnt.enabled", true);
        PRIME_TNT_FLAG_ONLY_ON_SPAWN = config.getBoolean("flags.checks.prime-tnt.flag-only-on-spawn", true);
        PRIME_TNT_WEIGHT = config.getInt("flags.checks.prime-tnt.weight", 3);
        PRIME_TNT_NEWBIES_MIN_HOURS = config.getInt("flags.checks.prime-tnt.newbies.min-hours", 6) * 60;
        PRIME_TNT_NEWBIES_MESSAGE = config.getString("flags.checks.prime-tnt.newbies.message", "<gray>Чувак, ты слишком маленький, чтобы играть со спичками!</gray>");

        BREAK_CONTAINER_ENABLED = config.getBoolean("flags.checks.break-container.enabled", true);
        BREAK_CONTAINER_FLAG_ONLY_ON_SPAWN = config.getBoolean("flags.checks.break-container.flag-only-on-spawn", true);
        BREAK_CONTAINER_WEIGHT = config.getInt("flags.checks.break-container.weight", 2);
        BREAK_CONTAINER_NEWBIES_MIN_HOURS = config.getInt("flags.checks.break-container.newbies.min-hours", 6) * 60;
        BREAK_CONTAINER_NEWBIES_MESSAGE = config.getString("flags.checks.break-container.newbies.message", "<gray>Чувак, ты слишком маленький, чтобы это самово!</gray>");
    }
}