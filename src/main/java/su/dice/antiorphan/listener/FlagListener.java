package su.dice.antiorphan.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import su.dice.antiorphan.AntiOrphan;
import su.dice.antiorphan.manager.FlagManager;
import su.dice.antiorphan.event.FlagEvent;

public class FlagListener implements Listener {

    @EventHandler
    public void onFlag(FlagEvent event) {
        if (event.isCancelled()) return;

        FlagManager.getFlags(event.getPlayer().getName()).add(event.getFlag());

        AntiOrphan.logger.info(
                "Flagged " + event.getPlayer().getName() + " for " + event.getFlag().getType().name()
        );
    }
}
