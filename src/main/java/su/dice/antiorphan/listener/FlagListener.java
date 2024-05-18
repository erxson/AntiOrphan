package su.dice.antiorphan.listener;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import su.dice.antiorphan.AntiOrphan;
import su.dice.antiorphan.config.Config;
import su.dice.antiorphan.flag.FlagData;
import su.dice.antiorphan.flag.FlagType;
import su.dice.antiorphan.manager.FlagManager;
import su.dice.antiorphan.event.FlagEvent;
import su.dice.antiorphan.util.DiscordHelper;
import su.dice.antiorphan.util.FlagHelper;

public class FlagListener implements Listener {

    @EventHandler
    public void onFlag(FlagEvent event) {
        if (event.isCancelled()) return;

        FlagData data = FlagManager.getFlags(event.getPlayer().getName());
        data.stream().filter(FlagHelper::isExpired).forEach(data::remove);
        data.add(event.getFlag());

        AntiOrphan.logger.info(
                "Flagged " + event.getPlayer().getName() + " for " + event.getFlag().getType().name()
        );

        if (event.getPlayer().getStatistic(Statistic.PLAY_ONE_MINUTE)/20/60 > Config.MAX_HOURS_FOR_KICK) return;
        if (data.getFlagsWeight() < Config.WEIGHT_FOR_KICK) return;

        if (Config.BROADCAST_ON_KICK) {
            Bukkit.getServer().broadcastMessage("Амиркина залупа антигрифер3000 кикнула " + event.getPlayer().getName());
            Bukkit.getServer().broadcastMessage("админы вейкап нахер!");
        }

        DiscordHelper.sendWebhook(String.format(
                "||<@&1167150163316441191>||\n%s ебучий грифер!\nPRIMED_TNT: %d\nBREAK_CONTAINER: %d",
                event.getPlayer().getName(),
                data.getFlagsByType(FlagType.PRIMED_TNT).size(),
                data.getFlagsByType(FlagType.BREAK_CONTAINER).size())
        );

        event.getPlayer().kick(
                Component.text(
                        """
                                Тебя кикнула наша мега защита от гриферов!
                                Её писали на коленке под квасом, так что она могла ошибиться.
                                Извини, чувак!
                                
                                Если она всё же не ошиблась,
                                то тебя ждёт более жесткое наказание, чем простой бан.""")
        );
    }
}
