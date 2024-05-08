package su.dice.antiorphan.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import su.dice.antiorphan.event.FlagEvent;
import su.dice.antiorphan.flag.Flag;
import su.dice.antiorphan.flag.FlagType;

import java.util.List;

import static org.bukkit.Material.*;

public class BlockBreakListener implements Listener {
    private final List<Material> bannedBlocks = List.of(
            CHEST, BARREL
    );

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player potentialOrphan = event.getPlayer();
        Block block = event.getBlock();

        if (!bannedBlocks.contains(block.getType())) return;

        Flag flag = new Flag(FlagType.BREAK_CONTAINER);
        FlagEvent flagEvent = new FlagEvent(potentialOrphan, flag);
        Bukkit.getPluginManager().callEvent(flagEvent);
    }
}
