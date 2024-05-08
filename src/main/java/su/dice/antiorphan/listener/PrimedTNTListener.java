package su.dice.antiorphan.listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.TNTPrimeEvent;
import su.dice.antiorphan.event.FlagEvent;
import su.dice.antiorphan.flag.Flag;
import su.dice.antiorphan.flag.FlagType;

public class PrimedTNTListener implements Listener {

    @EventHandler
    public void onPrimeTnt(TNTPrimeEvent event) {
        Entity potentialOrphanEntity = event.getPrimingEntity();
        if (potentialOrphanEntity == null) return;
        if (!(potentialOrphanEntity instanceof Player potentialOrphan)) return;

        Flag flag = new Flag(FlagType.PRIMED_TNT);
        FlagEvent flagEvent = new FlagEvent(potentialOrphan, flag);
        Bukkit.getPluginManager().callEvent(flagEvent);
    }
}
