package bidblitz;

public class Member {
    private final int id;
    private final String name;
    private int superCoins;

    public Member(int id, String name, int superCoins) {
        this.id = id;
        this.name = name;
        this.superCoins = superCoins;
    }

    public String getName() {
        return name;
    }

    public int getSuperCoins() {
        return superCoins;
    }

    public int getId() {
        return id;
    }

    public void setSuperCoins(int superCoins) {
        this.superCoins = superCoins;
    }
}
