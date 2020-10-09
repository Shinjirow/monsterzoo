public class Balls {
    private int value;

    public Balls(int v) {
        this.value = v;
    }

    public boolean hasBalls() {
        return this.value > 0;
    }

    public int chanceOfThrow() {
        return Math.min(this.value, 3);
    }

    public void add(int v) {
        this.value += v;
    }

    public void decrement() {
        this.value--;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
