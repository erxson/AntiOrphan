package su.dice.antiorphan.listener.checks;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.event.FlagEvent;
import su.dice.antiorphan.flag.Flag;
import su.dice.antiorphan.flag.FlagType;
import su.dice.antiorphan.util.FlagHelper;

public class PrimeTntListener implements Listener {

    @EventHandler
    public void check(TNTPrimeEvent event) {
        if (!Config.PRIME_TNT_ENABLED) return;

        Entity e = event.getPrimingEntity();
        if (e == null) return;
        if (!(e instanceof Player potentialOrphan)) return;

        if (Config.PRIME_TNT_FLAG_ONLY_ON_SPAWN && !FlagHelper.isSpawnZone(potentialOrphan.getLocation())) return;

        Flag flag = new Flag(FlagType.PRIMED_TNT);
        FlagEvent flagEvent = new FlagEvent(potentialOrphan, flag);
        Bukkit.getPluginManager().callEvent(flagEvent);
    }

    @EventHandler
    public void newbie(TNTPrimeEvent event) {
        if (!Config.PRIME_TNT_ENABLED) return;

        Entity e = event.getPrimingEntity();
        if (e == null) return;
        if (!(e instanceof Player p)) return;

        if (p.getStatistic(Statistic.PLAY_ONE_MINUTE)/20/60 > Config.PRIME_TNT_NEWBIES_MIN_HOURS) return;
        if (Config.PRIME_TNT_FLAG_ONLY_ON_SPAWN && !FlagHelper.isSpawnZone(p.getLocation())) return;

        p.sendRichMessage(Config.PRIME_TNT_NEWBIES_MESSAGE);
        event.setCancelled(true);
    }
}
