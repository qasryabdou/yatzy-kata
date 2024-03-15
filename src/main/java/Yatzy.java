import java.util.List;

/**
 * @author abdouelqasry
 */
public class Yatzy {
    /**
     * The player scores the sum of all dice, no matter what they read.
     *
     * @param diceResult
     * @return score
     */
    public static int chance(DiceResult diceResult) {
        return diceResult.sumDiceValues();
    }

    /**
     * If all dice have the same number, the player scores 50 points.
     *
     * @param diceResult
     * @return score
     */
    public static int yatzy(DiceResult diceResult) {
        return diceResult.countByDieValue().values()
            .stream()
            .filter(value -> value == 5)
            .findFirst()
            .map(e -> 50)
            .orElse(0);
    }

    /**
     * The player scores the sum of the dice that reads one.
     *
     * @param diceResult
     * @return score
     */
    public static int ones(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(1);
    }

    /**
     * The player scores the sum of the dice that reads two
     *
     * @param diceResult
     * @return score
     */
    public static int twos(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(2) * 2;
    }

    /**
     * The player scores the sum of the dice that reads three.
     *
     * @param diceResult
     * @return score
     */
    public static int threes(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(3) * 3;
    }

    /**
     * The player scores the sum of the dice that reads four.
     *
     * @param diceResult
     * @return score
     */
    public static int fours(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(4) * 4;
    }

    /**
     * The player scores the sum of the dice that reads five.
     *
     * @param diceResult
     * @return score
     */
    public static int fives(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(5) * 5;
    }

    /**
     * The player scores the sum of the dice that reads six.
     *
     * @param diceResult
     * @return score
     */
    public static int sixes(DiceResult diceResult) {
        return diceResult.countDieValueOccurrence(6) * 6;
    }

    /**
     * The player scores the sum of the two highest matching dice.
     *
     * @param diceResult
     * @return score
     */
    public static int scorePair(DiceResult diceResult) {
        List<Integer> pairs = diceResult.getDiceOccurringTwoTimes();
        return pairs.isEmpty() ? 0 : pairs.get(0) * 2;
    }

    /**
     * If there are two pairs of dice with the same number, the player scores the sum of these dice.
     *
     * @param diceResult
     * @return score
     */
    public static int twoPairs(DiceResult diceResult) {
        List<Integer> pairs = diceResult.getDiceOccurringTwoTimes();
        if (pairs.size() >= 2) {
            return pairs.stream()
                .mapToInt(pair -> pair * 2)
                .sum();
        }
        return 0;

    }

    /**
     * If there are three dice with the same number, the player scores the sum of these dice.
     *
     * @param diceResult
     * @return score
     */
    public static int threeOfaKind(DiceResult diceResult) {
        return diceResult.getDieValueByNumberOfOccurrence(3) * 3;
    }

    /**
     * If there are four dice with the same number, the player scores the sum of these dice.
     *
     * @param diceResult
     * @return score
     */
    public static int fourOfaKind(DiceResult diceResult) {
        return diceResult.getDieValueByNumberOfOccurrence(4) * 4;
    }

    /**
     * When placed on “small straight”, if the dice read 1,2,3,4,5 the player scores 15 (the sum of all the dice).
     *
     * @param diceResult
     * @return score
     */
    public static int smallStraight(DiceResult diceResult) {
        if (diceResult.sortedValues().equals(List.of(1, 2, 3, 4, 5))) {
            return 15;
        }
        return 0;
    }

    /**
     * When placed on “large straight”, if the dice read 2,3,4,5,6, the player scores 20 (the sum of all the dice).
     *
     * @param diceResult
     * @return score
     */
    public static int largeStraight(DiceResult diceResult) {
        if (diceResult.sortedValues().equals(List.of(2, 3, 4, 5, 6))) {
            return 20;
        }
        return 0;
    }

    /**
     * If the dice are two of a kind and three of a kind, the player scores the sum of all the dice.
     *
     * @param diceResult
     * @return score
     */
    public static int fullHouse(DiceResult diceResult) {
        boolean hasThreeOfAKind = diceResult.getDieValueByNumberOfOccurrence(3) != 0;
        boolean hasPair = diceResult.getDieValueByNumberOfOccurrence(2) != 0;
        boolean isYatzy = diceResult.countByDieValue().values()
            .stream()
            .anyMatch(count -> count == 5);

        return hasThreeOfAKind && hasPair && !isYatzy ? diceResult.sumDiceValues() : 0;
    }
}

