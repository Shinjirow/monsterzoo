public class Monster {
    // 名前とレア度を持っている
    private Pair<String, Integer> info;

    public Monster(String name, int rare) {
        info = Pair.of(name, rare);
    }

    public boolean canCatch(int r) {
        return info.unify((left, right) -> right) <= r;
    }

    @Override
    public String toString() {
        return info.unify((left, right) -> left).toString();
    }
}
