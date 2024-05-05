import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PairGenerator {

    private static final Random rnd = new Random();

    public List<List<Stranger>> splitByPairs(List<Stranger> strangers) {
        List<List<Stranger>> couples = new ArrayList<>();
        while (!strangers.isEmpty()) {
            List<Stranger> pair = getRandomPair(strangers);
            couples.add(pair);
            strangers.remove(pair.get(0));
            strangers.remove(pair.get(1));

        }
        return couples;
    }


    private List<Stranger> getRandomPair(List<Stranger> strangers) {
        int p1Index = rnd.nextInt(strangers.size());
        int p2Index = rnd.nextInt(strangers.size());
        while (p2Index == p1Index) {
            p2Index = rnd.nextInt(strangers.size());
        }

        Stranger strangerOne = strangers.get(p1Index);
        Stranger strangerTwo = strangers.get(p2Index);
        strangers.remove(p1Index);
        strangers.remove(p2Index);

        return List.of(strangerOne, strangerTwo);
    }
}