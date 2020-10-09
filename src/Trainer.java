public class Trainer {
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

    public void walk() {
        this.distance++;
        this.addDistanceToEggs();
    }

    private void addDistanceToEggs() {
        // 卵の距離加算処理
        for (int i = 0; i < this.egg.length; i++) {//卵は移動距離が進むと孵化するため，何km移動したかを更新する
            if (this.egg[i] == true) {
                this.eggDistance[i]++;
            }
        }
    }
}
