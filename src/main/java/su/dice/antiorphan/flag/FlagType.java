package su.dice.antiorphan.flag;

import su.dice.antiorphan.config.Config;

public enum FlagType {
    PRIMED_TNT(Config.PRIME_TNT_WEIGHT),
    BREAK_CONTAINER(Config.BREAK_CONTAINER_WEIGHT);

    private final int weight;

    FlagType(int weight) {
        this.weight = weight;
    }

    public int weight() {
        return this.weight;
    }
}
