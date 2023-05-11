package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.TreeSet;

class Comparator {
    public static List<KeyDiff> getDifferList(Map<String, Object> firstMap, Map<String, Object> secondMap) {
        NavigableSet<String> allKeys = new TreeSet<>(firstMap.keySet());
        allKeys.addAll(secondMap.keySet());

        List<KeyDiff> result = new ArrayList<>();
        allKeys
                .forEach(key -> {
                    boolean keyFrom1 = firstMap.containsKey(key);
                    boolean keyFrom2 = secondMap.containsKey(key);
                    Object valueFirstMap = firstMap.get(key);
                    Object valueSecondMap = secondMap.get(key);
                    KeyDiff oneLine;

                    if (!keyFrom1) {
                        oneLine = new KeyDiff(Status.ADDED, key, valueFirstMap, valueSecondMap);
                    } else if (!keyFrom2) {
                        oneLine = new KeyDiff(Status.REMOVED, key, valueFirstMap);
                    } else if (Objects.equals(valueFirstMap, valueSecondMap)) {
                        oneLine = new KeyDiff(Status.UNCHANGED, key, valueFirstMap);
                    } else {
                        oneLine = new KeyDiff(Status.UPDATED, key, valueFirstMap, valueSecondMap);
                    }
                    result.add(oneLine);
                });
        return result;
    }
}
