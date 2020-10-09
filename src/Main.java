import java.util.List;
import java.util.ArrayList;

public class Main {
    private MonsterZoo pz = new MonsterZoo();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        this.init();
        this.loop();
        this.printResult();
    }

    private void init() {
        this.setMonsterZukan();
    }

    private void loop() {
        //1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
        //手持ちのボールが無くなったら終了
        while (true) {
            try {
                Thread.sleep(1000);
                if (pz.getBalls() > 0) {
                    pz.move();
                    System.out.println("手持ちのボールは" + pz.getBalls() + "個，フルーツは" + pz.getFruits() + "個");
                    System.out.println(pz.getDistance() + "km歩いた．");
                } else {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printResult() {
        System.out.println("ボールがなくなった！");

        for (int i = 0; i < pz.getUserMonster().size(); i++) {
            if (pz.getUserMonster().get(i) != null) {
                System.out.println(pz.getUserMonster().get(i) + "を捕まえた．");
            }
        }
    }

    //テスト用のモンスターデータを登録するメソッド
    private void setMonsterZukan() {
        List<Monster> tempMonster = new ArrayList<>(22);
        // String tempMonster[] = new String[22];
        //List<Integer> tempMonsterRare = new ArrayList<>(22);
        // double tempMonsterRare[] = new double[22];
        tempMonster.add(new Monster("イガキン", 9));
        // tempMonsterRare.add(0, 9);
        tempMonster.add(new Monster("ナマチュウ", 3));
        // tempMonsterRare.add(1, 3);
        tempMonster.add(new Monster("イノウエン", 1));
        // tempMonsterRare.add(2, 1);
        tempMonster.add(new Monster("リョージィ", 2));
        // tempMonsterRare.add(3, 2);
        tempMonster.add(new Monster("アキモトン", 5));
        // tempMonsterRare.add(4, 5);
        tempMonster.add(new Monster("ゴージマ", 4));
        // tempMonsterRare.add(5, 4);
        tempMonster.add(new Monster("チュウデン", 6));
        // tempMonsterRare.add(6, 6);
        tempMonster.add(new Monster("ヅカホン", 8));
        // tempMonsterRare.add(7, 8);
        tempMonster.add(new Monster("ニシムラー", 7));
        // tempMonsterRare.add(8, 7);
        tempMonster.add(new Monster("サコーデン", 2));
        // tempMonsterRare.add(9, 2);
        tempMonster.add(new Monster("ウッチー", 5));
        // tempMonsterRare.add(10, 5);
        tempMonster.add(new Monster("ハヤッシー", 4));
        // tempMonsterRare.add(11, 4);
        tempMonster.add(new Monster("キーチー", 3));
        // tempMonsterRare.add(12, 3);
        tempMonster.add(new Monster("リョクン", 1));
        // tempMonsterRare.add(13, 1);
        tempMonster.add(new Monster("デコポン", 6));
        // tempMonsterRare.add(14, 6);
        tempMonster.add(new Monster("カミサン", 5));
        // tempMonsterRare.add(15, 5);
        tempMonster.add(new Monster("シスイ", 1));
        // tempMonsterRare.add(16, 1);
        tempMonster.add(new Monster("ジョナ", 7));
        // tempMonsterRare.add(17, 7);
        tempMonster.add(new Monster("ギダギダ", 2));
        // tempMonsterRare.add(18, 2);
        tempMonster.add(new Monster("ミッツー", 8));
        // tempMonsterRare.add(19, 8);
        tempMonster.add(new Monster("ゾエサン", 5));
        // tempMonsterRare.add(20, 5);
        tempMonster.add(new Monster("キタバー", 3));
        // tempMonsterRare.add(21, 3);

        pz.setMonsterZukan(tempMonster);
        // pz.setMonsterRare(tempMonsterRare);
    }
}
