package items;

public enum Currency {
    CP(1),
    SP(10),
    GP(100),
    PP(1000);

    private final int copperValue;

    Currency(int copperValue) {
        this.copperValue = copperValue;
    }

    public int getCopperValue() {
        return copperValue;
    }
}
