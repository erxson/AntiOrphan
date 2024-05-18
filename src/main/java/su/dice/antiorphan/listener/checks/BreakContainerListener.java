package su.dice.antiorphan.listener.checks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.event.FlagEvent;
import su.dice.antiorphan.flag.Flag;
import su.dice.antiorphan.flag.FlagType;
import su.dice.antiorphan.util.FlagHelper;

import java.util.List;

import static org.bukkit.Material.*;

public class BreakContainerListener implements Listener {
    private final List<Material> bannedBlocks = List.of(
            CHEST, BARREL
    );

    @EventHandler
    public void check(BlockBreakEvent event) {
        if (!Config.BREAK_CONTAINER_ENABLED) return;

        Player potentialOrphan = event.getPlayer();
        Block block = event.getBlock();

        if (!bannedBlocks.contains(block.getType())) return;
        if (Config.BREAK_CONTAINER_FLAG_ONLY_ON_SPAWN && !FlagHelper.isSpawnZone(block.getLocation())) return;

        Flag flag = new Flag(FlagType.BREAK_CONTAINER);
        FlagEvent flagEvent = new FlagEvent(potentialOrphan, flag);
        Bukkit.getPluginManager().callEvent(flagEvent);
    }

    @EventHandler
    public void newbies(BlockBreakEvent event) {
        if (!Config.BREAK_CONTAINER_ENABLED) return;

        Player p = event.getPlayer();
        Block block = event.getBlock();

        if (!bannedBlocks.contains(block.getType())) return;
        if (p.getStatistic(Statistic.PLAY_ONE_MINUTE)/20/60 > Config.BREAK_CONTAINER_NEWBIES_MIN_HOURS) return;
        if (Config.BREAK_CONTAINER_FLAG_ONLY_ON_SPAWN && !FlagHelper.isSpawnZone(block.getLocation())) return;

        p.sendRichMessage(Config.BREAK_CONTAINER_NEWBIES_MESSAGE);
        event.setCancelled(true);
    }
}
