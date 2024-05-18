package su.dice.antiorphan.util;

import org.bukkit.Location;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.flag.Flag;

public class FlagHelper {
    public static boolean isExpired(Flag flag) {
        return System.currentTimeMillis() - flag.getTimestamp() > Config.FLAG_RETENTION;
    }

    public static boolean isSpawnZone(Location loc) {
        return Math.abs(loc.getX()) < 100 && Math.abs(loc.getZ()) < 100;
    }
}
