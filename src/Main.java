import java.util.List;
import java.util.ArrayList;

public class Main {
    private MonsterZoo pz;

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        this.init();
        this.loop();
        this.printResult();
    }

    private void init() {
        this.pz = new MonsterZoo();
    }

    private void loop() {
        //1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
        //手持ちのボールが無くなったら終了
        while (pz.hasBalls()) {
            try {
                Thread.sleep(1000);
                pz.move();
                pz.printCurrentResult();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printResult() {
        System.out.println("ボールがなくなった！");
        pz.printFinalResult();
        /*
        for (int i = 0; i < pz.getUserMonster().size(); i++) {
            if (pz.getUserMonster().get(i) != null) {
                System.out.println(pz.getUserMonster().get(i) + "を捕まえた．");
            }
        }*/
    }
}
