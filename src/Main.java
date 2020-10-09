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
        List<String> tempMonster = new ArrayList<>(22);
        // String tempMonster[] = new String[22];
        List<Integer> tempMonsterRare = new ArrayList<>(22);
        // double tempMonsterRare[] = new double[22];
        tempMonster.add(0, "イガキン");
        tempMonsterRare.add(0, 9);
        tempMonster.add(1, "ナマチュウ");
        tempMonsterRare.add(1, 3);
        tempMonster.add(2, "イノウエン");
        tempMonsterRare.add(2, 1);
        tempMonster.add(3, "リョージィ");
        tempMonsterRare.add(3, 2);
        tempMonster.add(4, "アキモトン");
        tempMonsterRare.add(4, 5);
        tempMonster.add(5, "ゴージマ");
        tempMonsterRare.add(5, 4);
        tempMonster.add(6, "チュウデン");
        tempMonsterRare.add(6, 6);
        tempMonster.add(7, "ヅカホン");
        tempMonsterRare.add(7, 8);
        tempMonster.add(8, "ニシムラー");
        tempMonsterRare.add(8, 7);
        tempMonster.add(9, "サコーデン");
        tempMonsterRare.add(9, 2);
        tempMonster.add(10, "ウッチー");
        tempMonsterRare.add(10, 5);
        tempMonster.add(11, "ハヤッシー");
        tempMonsterRare.add(11, 4);
        tempMonster.add(12, "キーチー");
        tempMonsterRare.add(12, 3);
        tempMonster.add(13, "リョクン");
        tempMonsterRare.add(13, 1);
        tempMonster.add(14, "デコポン");
        tempMonsterRare.add(14, 6);
        tempMonster.add(15, "カミサン");
        tempMonsterRare.add(15, 5);
        tempMonster.add(16, "シスイ");
        tempMonsterRare.add(16, 1);
        tempMonster.add(17, "ジョナ");
        tempMonsterRare.add(17, 7);
        tempMonster.add(18, "ギダギダ");
        tempMonsterRare.add(18, 2);
        tempMonster.add(19, "ミッツー");
        tempMonsterRare.add(19, 8);
        tempMonster.add(20, "ゾエサン");
        tempMonsterRare.add(20, 5);
        tempMonster.add(21, "キタバー");
        tempMonsterRare.add(21, 3);

        pz.setMonsterZukan(tempMonster);
        pz.setMonsterRare(tempMonsterRare);
    }
}
