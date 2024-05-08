package su.dice.antiorphan;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import su.dice.antiorphan.command.DebugCommand;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.listener.BlockBreakListener;
import su.dice.antiorphan.listener.FlagListener;
import su.dice.antiorphan.listener.PrimedTNTListener;

import java.util.List;
import java.util.logging.Logger;

public final class AntiOrphan extends JavaPlugin {
    public static CoreProtectAPI capi;//ska
    public static AntiOrphan plugin;
    public static Logger logger;

    private final List<Listener> checks = List.of(
            new BlockBreakListener(), new FlagListener(), new PrimedTNTListener()
    );

    @Override
    public void onEnable() {
        logger = this.getLogger();

        capi = getCoreProtect();
        if (capi == null) return;
        capi.testAPI();

        Config.init();

        checks.forEach(e -> this.getServer().getPluginManager().registerEvents(e, this));

        this.getCommand("debug").setExecutor(new DebugCommand());
    }

    private CoreProtectAPI getCoreProtect() {
        Plugin plugin = getServer().getPluginManager().getPlugin("CoreProtect");

        if (!(plugin instanceof CoreProtect))
            return null;

        CoreProtectAPI CoreProtect = ((CoreProtect) plugin).getAPI();
        if (!CoreProtect.isEnabled())
            return null;

        if (CoreProtect.APIVersion() < 9)
            return null;

        return CoreProtect;
    }
}
