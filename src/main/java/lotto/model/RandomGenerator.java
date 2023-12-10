package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomGenerator {

    private static final int LOW_BOUND = 1;
    private static final int MAX_BOUND = 45;

    private final List<Integer> numbers;

    public RandomGenerator() {
        numbers = new ArrayList<>();
        for (int number = LOW_BOUND; number < MAX_BOUND; number++) {
            numbers.add(number);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(numbers);
        List<Integer> result = new ArrayList<>(numbers.subList(0, 6));
        Collections.sort(result);
        return result;
    }
}
