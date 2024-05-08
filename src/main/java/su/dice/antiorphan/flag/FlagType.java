package su.dice.antiorphan.flag;

public enum FlagType {
    PRIMED_TNT(3),
    BREAK_CONTAINER(2);

    private final int weight;

    FlagType(int weight) {
        this.weight = weight;
    }

    public int weight() {
        return this.weight;
    }
}
