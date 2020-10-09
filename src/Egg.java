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
        Printer.sendMessage("卵が孵った！");
        Monster newFace = Monsters.randomCall();
        Printer.sendMessage(newFace + "が産まれた！");

        return newFace;
    }
}
