import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class MonsterZoo {
    /*
    double distance = 0.0;//歩いた距離
    int balls = 10;//モンスターを捕まえられるボールの数
    int fruits = 0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

    //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
    //移動するたびに,eggDistanceに1.0kmずつ加算される．
    //3km移動するとランダムでモンスターが孵る
    double eggDistance[] = new double[9];
    boolean egg[] = new boolean[9];

    //ユーザがGetしたモンスター一覧
    String userMonster[] = new String[100];
    */

    //モンスター図鑑．モンスターの名前とレア度(0.0~9.0)がそれぞれの配列に保存されている
    //レア度が高いほうが捕まえにくい
    List<Monster> monsterZukan = new ArrayList<>(22);
    // String monsterZukan[] = new String[22];
    // List<Integer> monsterRare = new ArrayList<>(22);
    // double monsterRare[] = new double[22];

    Trainer aTrainer = new Trainer();

    //呼び出すと1km distanceが増える
    void move() {
        aTrainer.walk();
        // this.addDistanceToEggs();
        this.checkEncounter();
        this.hatch();
    }

    public double getDistance() {
        return aTrainer.distance;
    }

    public int getBalls() {
        return aTrainer.balls;
    }

    public int getFruits() {
        return aTrainer.fruits;
    }

    public List<Monster> getUserMonster() {
        return aTrainer.userMonster;
    }

    public void setMonsterZukan(List<Monster> monsterZukan) {
        this.monsterZukan = monsterZukan;
    }

    /*
    public void setMonsterRare(List<Integer> monsterRare) {
        this.monsterRare = monsterRare;
    }
    */

    /*
    private void addDistanceToEggs() {
        // 卵の距離加算処理
        for (int i = 0; i < aTrainer.egg.length; i++) {//卵は移動距離が進むと孵化するため，何km移動したかを更新する
            if (aTrainer.egg[i] == true) {
                aTrainer.eggDistance[i]++;
            }
        }
    }

    */

    private void checkEncounter() {
        // エンカウント処理
        int flg1 = (int) (Math.random() * 10);//0,1の場合はズーstation，7~9の場合はモンスター
        if (flg1 <= 1) {
            System.out.println("ズーstationを見つけた！");
            int b = (int) (Math.random() * 3);//ball,fruits,eggがランダムに出る
            int f = (int) (Math.random() * 2);
            int e = (int) (Math.random() * 2);
            System.out.println("ボールを" + b + "個，" + "フルーツを" + f + "個" + "卵を" + e + "個Getした！");
            aTrainer.balls = aTrainer.balls + b;
            aTrainer.fruits = aTrainer.fruits + f;
            if (e >= 1) {//卵を1つ以上Getしたら
                //egg[]に10個以上卵がない場合は新しい卵データをセットする
                if (aTrainer.eggs.size() < 10) {
                    aTrainer.eggs.add(new Egg());
                }
                /*
                if (aTrainer.eggDistance.size() < 10) {
                    aTrainer.egg.add(true);
                    aTrainer.eggDistance.add(0);
                }
                */

                /*
                for (int i = 0; i < aTrainer.eggDistance.size(); i++) {
                    if (aTrainer.egg.get(i) == false) {
                        aTrainer.egg.add(i, true);
                        aTrainer.eggDistance.add(i, 0);
                        break;
                    }
                }
                */
            }
        } else if (flg1 >= 7) {
            int m = (int) (this.monsterZukan.size() * Math.random());//monsterZukanからランダムにモンスターを出す
            System.out.println(this.monsterZukan.get(m) + "が現れた！");

            IntStream.range(0, Math.min(aTrainer.balls, 3)).map(i -> {
                int r = (int) (6 * Math.random());//0~5までの数字をランダムに返す
                if (aTrainer.fruits > 0) {
                    System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
                    aTrainer.fruits--;
                    r = r * 2;
                }
                return r;
            }).forEach(r -> {
                System.out.println(this.monsterZukan.get(m) + "にボールを投げた");
                aTrainer.balls--;
                if (this.monsterZukan.get(m).getRare() <= r) {//monsterRare[m]の値がr以下の場合
                    System.out.println(this.monsterZukan.get(m) + "を捕まえた！");
                    aTrainer.userMonster.add(this.monsterZukan.get(m));
                    /*
                    for (int j = 0; j < aTrainer.userMonster.size(); j++) {
                        if (aTrainer.userMonster[j] == null) {
                            aTrainer.userMonster[j] = this.monsterZukan.get(m);
                            break;
                        }
                    }
                    */
                    // return;//ボール投げ終了
                } else {
                    System.out.println(this.monsterZukan.get(m) + "に逃げられた！");
                }
            });
            /*
            for (int i = 0; i < 3 && aTrainer.balls > 0; i++) {//捕まえる or 3回ボールを投げるまで繰り返す
                int r = (int) (6 * Math.random());//0~5までの数字をランダムに返す
                if (aTrainer.fruits > 0) {
                    System.out.println("フルーツを投げた！捕まえやすさが倍になる！");
                    aTrainer.fruits--;
                    r = r * 2;
                }
                System.out.println(this.monsterZukan.get(m) + "にボールを投げた");
                aTrainer.balls--;
                if (this.monsterZukan.get(m).getRare() <= r) {//monsterRare[m]の値がr以下の場合
                    System.out.println(this.monsterZukan.get(m) + "を捕まえた！");
                    aTrainer.userMonster.add(this.monsterZukan.get(m));
                    /*
                    for (int j = 0; j < aTrainer.userMonster.size(); j++) {
                        if (aTrainer.userMonster[j] == null) {
                            aTrainer.userMonster[j] = this.monsterZukan.get(m);
                            break;
                        }
                    }
                    *//*
                    break;//ボール投げ終了
                } else {
                    System.out.println(this.monsterZukan.get(m) + "に逃げられた！");
                }
            }
            */
        }

    }

    private void hatch() {
        // 卵の孵化処理
        for (int i = 0; i < aTrainer.eggs.size(); i++) {
            if (aTrainer.eggs.get(i).canHatch()) {
                System.out.println("卵が孵った！");
                int m = (int) (this.monsterZukan.size() * Math.random());
                System.out.println(this.monsterZukan.get(m) + "が産まれた！");

                aTrainer.userMonster.add(this.monsterZukan.get(m));
                /*
                for (int j = 0; j < aTrainer.userMonster.length; j++) {
                    if (aTrainer.userMonster[j] == null) {
                        aTrainer.userMonster[j] = this.monsterZukan.get(m);
                        break;
                    }
                }
                */

                aTrainer.eggs.remove(i);
                /*
                aTrainer.egg.set(i, false);
                aTrainer.eggDistance.set(i, 0);
                */
            }
        }
    }
}
