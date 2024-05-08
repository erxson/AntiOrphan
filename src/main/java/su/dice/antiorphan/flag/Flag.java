package su.dice.antiorphan.flag;

public class Flag {
    private final FlagType type;
    private final long time = System.currentTimeMillis();

    public Flag(FlagType type) {
        this.type = type;
    }

    public FlagType getType() {
        return this.type;
    }

    public int getWeight() {
        return this.type.weight();
    }

    public long getTime() {
        return this.time;
    }
}
