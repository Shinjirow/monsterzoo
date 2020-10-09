import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class User {
    private Distance distance = new Distance();//歩いた距離

    private Items items = new Items();

    // List<Integer> eggDistance = new ArrayList<>(9);
    // double eggDistance[] = new double[9];
    // List<Boolean> egg = new ArrayList<>(9);
    // boolean egg[] = new boolean[9];

    private UserMonsters monsters = new UserMonsters();

    // String userMonster[] = new String[100];

    public boolean hasBalls() {
        return items.hasBalls();
    }

    public void addBalls(int v) {
        this.items.addBalls(v);
    }

    public void addFruits(int v) {
        this.items.addFruits(v);
    }

    public void addEggs(int v) {
        this.monsters.addEgg();
    }

    // バグっています　要修正
    public void tryToCatch(Monster m) {
        IntStream.range(0, this.items.chanceOfThrow()).map(i -> {
            int r = (int) (6 * Math.random());//0~5までの数字をランダムに返す
            if (this.items.hasFruits()) {
                System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
                this.items.spendFruits();
                r = r * 2;
            }
            return r;
        }).forEach(r -> {
            System.out.println(m + "にボールを投げた");
            this.items.spendBalls();
            if (m.canCatch(r)) {
                System.out.println(m + "を捕まえた！");
                this.monsters.addMonster(m);
                    /*
                    for (int j = 0; j < aTrainer.userMonster.size(); j++) {
                        if (aTrainer.userMonster[j] == null) {
                            aTrainer.userMonster[j] = m;
                            break;
                        }
                    }
                    */
                // return;//ボール投げ終了
            } else {
                System.out.println(m + "に逃げられた！");
            }
        });
    }

    public void hatchEggs() {
        this.monsters.hatchEggs();
    }

    public void printCurrentResult() {
        System.out.println(this.items);
        System.out.println(this.distance + "km歩いた．");
    }

    public void printFinalResult() {
        this.monsters.streamMonsters()
                .filter(Objects::nonNull)
                .forEach(e -> System.out.println(e + "を捕まえた．"));
    }

    public void walk() {
        this.distance.increment();
        this.addDistanceToEggs();
    }

    private void addDistanceToEggs() {
        // 卵の距離加算処理
        this.monsters.addDistance();
        // eggs.forEach(Egg::addDistance);
        /*
        for (int i = 0; i < this.egg.size(); i++) {//卵は移動距離が進むと孵化するため，何km移動したかを更新する
            if (this.egg.get(i) == true) {
                this.eggDistance.set(i, this.eggDistance.get(i) + 1);
            }
        }
        */
    }
}
