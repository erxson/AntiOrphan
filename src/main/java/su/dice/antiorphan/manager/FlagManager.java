package su.dice.antiorphan.manager;

import su.dice.antiorphan.flag.FlagData;

import java.util.HashMap;

public class FlagManager {
    private static final HashMap<String, FlagData> playersData = new HashMap<>();

    public static FlagData getFlags(String nickname) {
        if (playersData.containsKey(nickname))
            return playersData.get(nickname);

        FlagData flagData = new FlagData();
        playersData.put(nickname, flagData);

        return flagData;
//        return flags.getOrDefault(nickname, new FlagData());
    }
}
