public class Monster {
    // 名前とレア度を持っている
    private String name;
    private int rare;

    public Monster(String name, int rare) {
        this.name = name;
        this.rare = rare;
    }

    public boolean canCatch(int r) {
        return this.rare <= r;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
