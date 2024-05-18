package su.dice.antiorphan.util;

import org.bukkit.Bukkit;
import su.dice.antiorphan.AntiOrphan;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class DiscordHelper {
    private static final String WEBHOOK = "https://canary.discord.com/api/webhooks/1237740896636637254/gp75IJEYeR33kYTbQDoqsOvt7yFgxpoIasQrs7NRDK3AacfPjlUjD1XvE1SIqBn1jo9d";

    public static void sendWebhook(String message) {
        Bukkit.getScheduler().runTaskAsynchronously(AntiOrphan.plugin, () -> {
            try {
                HttpsURLConnection connection = (HttpsURLConnection) new URL(WEBHOOK).openConnection();
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux i686) Gecko/20071127 Firefox/2.0.0.11");
                connection.setDoOutput(true);

                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(("{\"content\":\"" + message + "\"}").getBytes());

                int responseCode = connection.getResponseCode();
                if (responseCode != 200)
                    AntiOrphan.logger.severe("Ashipkar: " + connection.getResponseMessage());

                connection.getInputStream().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
