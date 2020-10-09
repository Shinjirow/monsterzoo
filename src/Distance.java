public class Distance {
    private double value;

    public Distance() {
        this.value = 0.0;
    }

    public void increment() {
        this.value++;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
