package su.dice.antiorphan.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.flag.FlagData;
import su.dice.antiorphan.manager.FlagManager;

public class ReloadCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Config.load();
        sender.sendRichMessage("<yellow>Конфиг перезагружен!</yellow>");

        return true;
    }
}
