package vendingmachine;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5);

    private final double value;

    Coin(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
