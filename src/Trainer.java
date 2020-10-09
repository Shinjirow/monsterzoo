import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Trainer {
    private double distance = 0.0;//歩いた距離
    private int balls = 10;//モンスターを捕まえられるボールの数
    private int fruits = 0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

    //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
    //移動するたびに,eggDistanceに1.0kmずつ加算される．
    //3km移動するとランダムでモンスターが孵る

    private List<Egg> eggs = new ArrayList<>(9);
    // List<Integer> eggDistance = new ArrayList<>(9);
    // double eggDistance[] = new double[9];
    // List<Boolean> egg = new ArrayList<>(9);
    // boolean egg[] = new boolean[9];

    //ユーザがGetしたモンスター一覧
    private List<Monster> userMonster = new ArrayList<>(100);
    // String userMonster[] = new String[100];

    public boolean hasBalls() {
        return this.balls > 0;
    }

    public void addBalls(int v) {
        this.balls += v;
    }

    public void addFruits(int v) {
        this.fruits += v;
    }

    public void addEggs(int v) {
        if (this.eggs.size() < 10) {
            this.eggs.add(new Egg());
        }
    }

    // バグっています　要修正
    public void tryToCatch(Monster m) {
        IntStream.range(0, Math.min(this.balls, 3)).map(i -> {
            int r = (int) (6 * Math.random());//0~5までの数字をランダムに返す
            if (this.fruits > 0) {
                System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
                this.fruits--;
                r = r * 2;
            }
            return r;
        }).forEach(r -> {
            System.out.println(m + "にボールを投げた");
            this.balls--;
            if (m.canCatch(r)) {
                System.out.println(m + "を捕まえた！");
                this.userMonster.add(m);
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

        List<Monster> monsters = this.eggs.stream()
                .filter(Egg::canHatch)
                .map(Egg::hatch)
                .collect(Collectors.toList());

        this.eggs = this.eggs.stream()
                .filter(e -> !e.canHatch())
                .collect(Collectors.toList());

        this.userMonster.addAll(monsters);
    }

    public void printCurrentResult() {

        System.out.println("手持ちのボールは" + this.balls + "個，フルーツは" + this.fruits + "個");
        System.out.println(this.distance + "km歩いた．");
    }

    public void printFinalResult() {
        this.userMonster.stream()
                .filter(Objects::nonNull)
                .forEach(e -> System.out.println(e + "を捕まえた．"));
    }

    public void walk() {
        this.distance++;
        this.addDistanceToEggs();
    }

    private void addDistanceToEggs() {
        // 卵の距離加算処理
        eggs.forEach(Egg::addDistance);
        /*
        for (int i = 0; i < this.egg.size(); i++) {//卵は移動距離が進むと孵化するため，何km移動したかを更新する
            if (this.egg.get(i) == true) {
                this.eggDistance.set(i, this.eggDistance.get(i) + 1);
            }
        }
        */
    }
}
