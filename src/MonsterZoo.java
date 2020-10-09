public class MonsterZoo {
    private User aUser = new User();

    public MonsterZoo() {
    }

    //呼び出すと1km distanceが増える
    void move() {
        aUser.walk();
        this.checkEncounter();
        this.hatch();
    }

    public boolean hasBalls() {
        return aUser.hasBalls();
    }

    private void checkEncounter() {
        // エンカウント処理
        int flg1 = (int) (Math.random() * 10);//0,1の場合はズーstation，7~9の場合はモンスター
        if (flg1 <= 1) {
            this.encounterZooStation();
        } else if (flg1 >= 7) {
            this.encounterMonster();
        }
    }

    private void encounterZooStation() {
        Printer.sendMessage("ズーstationを見つけた！");
        int b = (int) (Math.random() * 3);//ball,fruits,eggがランダムに出る
        int f = (int) (Math.random() * 2);
        int e = (int) (Math.random() * 2);
        Printer.sendMessage("ボールを" + b + "個，" + "フルーツを" + f + "個" + "卵を" + e + "個Getした！");
        aUser.addBalls(b);
        aUser.addFruits(f);
        if (e >= 1) //卵を1つ以上Getしたら
            aUser.addEggs(e);
    }

    private void encounterMonster() {
        //monsterZukanからランダムにモンスターを出す
        Monster m = Monsters.randomCall();
        Printer.sendMessage(m + "が現れた！");

        aUser.tryToCatch(m);
    }

    private void hatch() {
        // 卵の孵化処理
        this.aUser.hatchEggs();
    }

    public void printCurrentResult() {
        aUser.printCurrentResult();
    }

    public void printFinalResult() {
        aUser.printFinalResult();
    }
}
