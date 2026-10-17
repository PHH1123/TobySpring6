package tobyspring.tobyspring6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public List<String> sortByLength(List<String> list) {
        list.sort((a, b) -> a.length() - b.length());
        return list;
    }

    static void main() {
        List<String> scores = Arrays.asList("z", "x", "spring", "java");
        Collections.sort(scores, (a, b) -> a.length() - b.length());

        scores.forEach(System.out::println);
    }
}
