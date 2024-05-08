package su.dice.antiorphan.event;

import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

class Event extends org.bukkit.event.Event {
    private static final HandlerList handlers = new HandlerList();

    public @NotNull HandlerList getHandlers() {
        return handlers;
    }

    public static @NotNull HandlerList getHandlerList() {
        return handlers;
    }
}