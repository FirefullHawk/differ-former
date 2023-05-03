package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

class StatusFormer {
    public static List<Object> getStatus(Map<String, Object> firstMap, Map<String, Object> secondMap) {

        NavigableSet<String> allKeys = new TreeSet<>(firstMap.keySet());

        allKeys.addAll(secondMap.keySet());

        List<Object> result = new ArrayList<>();

        allKeys
                .forEach(x -> {
                    boolean keyFrom1 = firstMap.containsKey(x);
                    boolean keyFrom2 = secondMap.containsKey(x);
                    Object valueFirstMap = firstMap.get(x);
                    Object valueSecondMap = secondMap.get(x);
                    Element<? super Object> oneLine = new Element<>();

                    if (keyFrom1 & keyFrom2) {
                        if (Objects.equals(valueFirstMap, valueSecondMap)) {
                            oneLine = new Element<>(Status.unchanged, x, valueFirstMap);
                        } else {
                            oneLine = new Element<>(Status.updated, x, valueFirstMap, valueSecondMap);
                        }
                    }
                    if (!keyFrom1 & keyFrom2) {
                        oneLine = new Element<>(Status.added, x, valueSecondMap);
                    }
                    if (keyFrom1 & !keyFrom2) {
                        oneLine = new Element<>(Status.removed, x, valueFirstMap);
                    }
                    result.add(oneLine.getFullElement());
                });
        return result;
    }
}
