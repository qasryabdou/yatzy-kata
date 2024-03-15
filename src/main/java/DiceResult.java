import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;

import static java.util.stream.Collectors.*;
/**
 * @author abdouelqasry
 */
public class DiceResult {
    public static final Collector<Integer, ?, Integer> counting = reducing(0, (previous, current) -> previous + 1);
    public static final Collector<Integer, ?, Map<Integer, Integer>> groupingCountByDieValue = groupingBy(Function.identity(), counting);

    private final List<Integer> dice;

    public DiceResult(int d1, int d2, int d3, int d4, int d5) {
        this.dice = List.of(d1, d2, d3, d4, d5);
    }

    public List<Integer> getDice() {
        return dice;
    }

    /**
     * Sums all values in the dice result.
     *
     * @return sum
     */
    public int sumDiceValues() {
        return this.dice.stream().mapToInt(d -> d).sum();
    }

    /**
     * count the number of occurrence by dice value.
     *
     * @return a map where the keys represent the values of the dice and the values represent the number of occurrences of each dice value
     */
    public Map<Integer, Integer> countByDieValue() {
        return this.dice.stream().collect(groupingCountByDieValue);
    }

    /**
     * Counts the occurrences of a specific dice value.
     *
     * @param dice the value of the dice to count occurrences for
     * @return the number of occurrences of the specified dice value, or 0 if the value is not found
     */
    public int countDieValueOccurrence(int dice) {
        return countByDieValue().getOrDefault(dice, 0);
    }


    /**
     * Retrieves the die value that occurs at least the specified number of times.
     *
     * @param numberOfOccurrence the minimum number of times a dice value should occur
     * @return the first dice value that occurs at least the specified number of times,
     * or 0 if no such value is found or if the provided number of occurrence is negative
     */
    public int getDieValueByNumberOfOccurrence(int numberOfOccurrence) {
        Map<Integer, Integer> diceOccurrences = countByDieValue();

        return diceOccurrences.entrySet()
            .stream()
            .filter(e -> e.getValue() >= numberOfOccurrence)
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(0);
    }

    /**
     * Retrieves a list of die values that occur exactly two times.
     *
     * @return a list containing the dice values that occur exactly two times, sorted in descending order,
     * an empty list if no dice value occurs exactly two times
     */
    public List<Integer> getDiceOccurringTwoTimes() {
        return countByDieValue().entrySet()
            .stream()
            .filter(e -> e.getValue() >= 2)
            .map(Map.Entry::getKey)
            .sorted(Comparator.reverseOrder())
            .collect(toList());
    }

    public List<Integer> sortedValues(){
        return this.dice.stream().sorted().collect(toList());
    }

}
