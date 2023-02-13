import java.util.*;

public class Util {
    public static List<KeyAndList<String, Card>> transform(Map<String, List<Card>> map) {
        List<KeyAndList<String, Card>> result = new ArrayList<>();

        for (String name : map.keySet()) {
            KeyAndList<String, Card> list = new KeyAndList<>(name, map.get(name));
            result.add(list);
        }
        return result;
    }
}
