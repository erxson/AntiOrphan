package su.dice.antiorphan.flag;

import java.util.ArrayList;

public class FlagData extends ArrayList<Flag> {

    public ArrayList<Flag> getFlags() {
        return this;
    }

    public int getFlagsCount() {
        return this.size();
    }

    public int getFlagsWeight() {
        int w = 0;
        for (Flag flag : this) {
            w += flag.getWeight();
        }

        return w;
    }
}
