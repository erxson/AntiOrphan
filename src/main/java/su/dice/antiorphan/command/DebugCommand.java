package su.dice.antiorphan.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.dice.antiorphan.flag.FlagData;
import su.dice.antiorphan.manager.FlagManager;

public class DebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (!(sender instanceof Player p)) return false;

        FlagData data = FlagManager.getFlags(p.getName());

        p.sendMessage("[" + data.getFlagsWeight() + "/" + data.getFlagsCount() + "] Флаги:");
        data.getFlags().forEach(flag -> p.sendRichMessage(flag.getType().name() + " - " + flag.getType().weight()));

        return true;
    }
}
