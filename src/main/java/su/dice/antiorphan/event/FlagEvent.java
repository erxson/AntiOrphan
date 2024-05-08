package su.dice.antiorphan.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import su.dice.antiorphan.flag.Flag;

public class FlagEvent extends Event implements Cancellable {
    private final Player player;
    private final Flag flag;
    private boolean isCancelled;

    public FlagEvent(Player player, Flag flag) {
        this.player = player;
        this.flag = flag;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    public Player getPlayer() {
        return this.player;
    }

    public Flag getFlag() {
        return this.flag;
    }
}
