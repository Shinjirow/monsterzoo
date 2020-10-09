import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Eggs {
    List<Egg> eggs;

    public Eggs() {
        this.eggs = new ArrayList<>(9);
    }

    public void addEgg() {
        if (this.eggs.size() < 10) {
            this.eggs.add(new Egg());
        }
    }

    public Monsters hatch() {
        Stream<Monster> monsters = this.eggs.stream()
                .filter(Egg::canHatch)
                .map(Egg::hatch);
        Monsters m = new Monsters(monsters);

        this.eggs = this.eggs.stream()
                .filter(e -> !e.canHatch())
                .collect(Collectors.toList());

        return m;
    }

    public void addDistance() {
        eggs.forEach(Egg::addDistance);
    }
}
