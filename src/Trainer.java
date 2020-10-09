import java.util.List;
import java.util.ArrayList;

public class Trainer {
    double distance = 0.0;//歩いた距離
    int balls = 10;//モンスターを捕まえられるボールの数
    int fruits = 0;//ぶつけるとモンスターが捕まえやすくなるフルーツ

    //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
    //移動するたびに,eggDistanceに1.0kmずつ加算される．
    //3km移動するとランダムでモンスターが孵る
    List<Integer> eggDistance = new ArrayList<>(9);
    // double eggDistance[] = new double[9];
    List<Boolean> egg = new ArrayList<>(9);
    // boolean egg[] = new boolean[9];

    //ユーザがGetしたモンスター一覧
    List<String> userMonster = new ArrayList<>(100);
    // String userMonster[] = new String[100];

    public void walk() {
        this.distance++;
        this.addDistanceToEggs();
    }

    private void addDistanceToEggs() {
        // 卵の距離加算処理
        for (int i = 0; i < this.egg.size(); i++) {//卵は移動距離が進むと孵化するため，何km移動したかを更新する
            if (this.egg.get(i) == true) {
                this.eggDistance.set(i, this.eggDistance.get(i) + 1);
            }
        }
    }
}
