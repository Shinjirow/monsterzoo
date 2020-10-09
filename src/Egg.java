public class Egg {
    private int distance;

    public Egg() {
        this.distance = 0;
    }

    public void addDistance() {
        this.distance++;
    }

    public boolean canHatch() {
        return this.distance >= 3;
    }
}
