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

    public Monster hatch() {
        System.out.println("卵が孵った！");
        Monster newFace = Monsters.randomCall();
        System.out.println(newFace + "が産まれた！");

        return newFace;
    }
}
