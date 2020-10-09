public class Fruits {
    private int value;

    public Fruits(int v) {
        this.value = v;
    }

    public boolean hasFruits() {
        return this.value > 0;
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
