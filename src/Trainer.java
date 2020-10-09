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

    public double getDistance() {
        return distance;
    }

    public int getBalls() {
        return balls;
    }

    public int getFruits() {
        return fruits;
    }

    public String[] getUserMonster() {
        return userMonster;
    }
}
