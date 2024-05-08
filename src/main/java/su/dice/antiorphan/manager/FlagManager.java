package su.dice.antiorphan.manager;

import su.dice.antiorphan.flag.FlagData;

import java.util.HashMap;

public class FlagManager {
    private static final HashMap<String, FlagData> playersData = new HashMap<>();

    public static FlagData getFlags(String nickname) {
        return playersData.getOrDefault(nickname, new FlagData());
    }
}
