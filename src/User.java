import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class User {
    private Distance distance = new Distance();//歩いた距離

    private Items items = new Items();

    private UserMonsters monsters = new UserMonsters();

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
    }
}
