import java.util.stream.Stream;

public class UserMonsters {

    //卵は最大9個まで持てる．卵を取得するとeggにtrueが代入され，
    //移動するたびに,eggDistanceに1.0kmずつ加算される．
    //3km移動するとランダムでモンスターが孵る

    private Eggs eggs = new Eggs();

    //ユーザがGetしたモンスター一覧 元userMonster
    private Monsters monsters = new Monsters(100);

    public void addEgg() {
        this.eggs.addEgg();
    }

    public void addMonster(Monster m) {
        this.monsters.add(m);
    }

    public void hatchEggs() {
        Monsters m = this.eggs.hatch();
        this.monsters.addAll(m);
    }

    public Stream<Monster> streamMonsters() {
        return this.monsters.stream();
    }

    public void addDistance() {
        this.eggs.addDistance();
    }
}
