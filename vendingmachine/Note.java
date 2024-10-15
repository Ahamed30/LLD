package vendingmachine;

public enum Note {
    TEN(10),
    TWENTY(20),
    FIFTY(50);

    private final double value;

    Note(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
