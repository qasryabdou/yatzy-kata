import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DiceResultTest {

    @Test
    public void should_sum_dice_results() {
        DiceResult result = new DiceResult(1, 2, 3, 4, 5);
        assertEquals(15, result.sumDiceValues());
    }

    @Test
    public void should_count_by_dice_result() {
        DiceResult result = new DiceResult(1, 2, 2, 3, 3);
        Map<Integer, Integer> countMap = result.countByDieValue();
        assertEquals(1, countMap.get(1));
        assertEquals(2, countMap.get(2));
        assertEquals(2, countMap.get(3));
        assertNull( countMap.get(4)); // Non-existing dice value
    }

    @Test
    public void should_count_dice_occurrences() {
        DiceResult result = new DiceResult(1, 2, 2, 3, 3);
        assertEquals(1, result.countDieValueOccurrence(1));
        assertEquals(2, result.countDieValueOccurrence(2));
        assertEquals(2, result.countDieValueOccurrence(3));
        assertEquals(0, result.countDieValueOccurrence(4)); // Non-existing dice value
    }

    @Test
    public void should_get_dice_by_number_of_occurrence() {
        DiceResult result = new DiceResult(1, 2, 2, 3, 3);
        assertEquals(2, result.getDieValueByNumberOfOccurrence(2));
        assertEquals(0, result.getDieValueByNumberOfOccurrence(3)); // Non-existing occurrence
    }

    @Test
    public void should_find_dices_occurring_two_times() {
        DiceResult result = new DiceResult(1, 2, 2, 3, 3);
        List<Integer> list = result.getDiceOccurringTwoTimes();
        assertEquals(2, list.size());
        assertEquals(3, (int) list.get(0));
        assertEquals(2, (int) list.get(1));
    }

    @Test
    public void should_return_sorted_dice_values() {
        DiceResult result = new DiceResult(4, 2, 6, 1, 3);
        List<Integer> sorted = result.sortedValues();
        assertEquals(1, (int) sorted.get(0));
        assertEquals(2, (int) sorted.get(1));
        assertEquals(3, (int) sorted.get(2));
        assertEquals(4, (int) sorted.get(3));
        assertEquals(6, (int) sorted.get(4));
    }
}
