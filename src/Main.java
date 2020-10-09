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

    //1000ミリ秒（1秒）ずつ止まりながらpz.move()を呼び出し続ける
    //手持ちのボールが無くなったら終了
    private void loop() {
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
        Printer.sendMessage("ボールがなくなった！");
        pz.printFinalResult();
    }
}
