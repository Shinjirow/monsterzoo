public class Items {
    private Balls balls;//モンスターを捕まえられるボールの数
    private Fruits fruits;//ぶつけるとモンスターが捕まえやすくなるフルーツ

    public Items() {
        this.balls = new Balls(10);
        this.fruits = new Fruits(0);

    }

    public boolean hasBalls() {
        return this.balls.hasBalls();
    }

    public boolean hasFruits() {
        return this.fruits.hasFruits();
    }

    public int chanceOfThrow() {
        return this.balls.chanceOfThrow();
    }

    public void addBalls(int v) {
        this.balls.add(v);
    }

    public void addFruits(int v) {
        this.fruits.add(v);
    }

    public void spendBalls() {
        this.balls.decrement();
    }

    public void spendFruits() {
        this.fruits.decrement();
    }

    @Override
    public String toString() {
        return "手持ちのボールは" + this.balls + "個，フルーツは" + this.fruits + "個";
    }
}
