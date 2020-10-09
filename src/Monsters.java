import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Monsters {

    // テスト用のモンスターデータ
    private static final List<Monster> monstersList = Collections.unmodifiableList(new ArrayList<>(22) {{
        add(new Monster("イガキン", 9));
        add(new Monster("ナマチュウ", 3));
        add(new Monster("イノウエン", 1));
        add(new Monster("リョージィ", 2));
        add(new Monster("アキモトン", 5));
        add(new Monster("ゴージマ", 4));
        add(new Monster("チュウデン", 6));
        add(new Monster("ヅカホン", 8));
        add(new Monster("ニシムラー", 7));
        add(new Monster("サコーデン", 2));
        add(new Monster("ウッチー", 5));
        add(new Monster("ハヤッシー", 4));
        add(new Monster("キーチー", 3));
        add(new Monster("リョクン", 1));
        add(new Monster("デコポン", 6));
        add(new Monster("カミサン", 5));
        add(new Monster("シスイ", 1));
        add(new Monster("ジョナ", 7));
        add(new Monster("ギダギダ", 2));
        add(new Monster("ミッツー", 8));
        add(new Monster("ゾエサン", 5));
        add(new Monster("キタバー", 3));
    }});

    private List<Monster> monsters;

    public Monsters(int initialCapacity) {
        this.monsters = new ArrayList<>(initialCapacity);
    }

    public Monsters(Stream<Monster> stream) {
        this.monsters = new ArrayList<>();
        stream.forEach(monsters::add);
    }

    public static Monster randomCall() {
        int random = (int) (Monsters.monstersList.size() * Math.random());
        return Monsters.monstersList.get(random);
    }

    public void add(Monster m) {
        this.monsters.add(m);
    }

    public void add(Stream<Monster> m) {
        m.forEach(monsters::add);
    }

    public void addAll(Monsters monsters) {
        this.monsters.addAll(monsters.monsters);
    }


    public Stream<Monster> stream() {
        return monsters.stream();
    }
}
