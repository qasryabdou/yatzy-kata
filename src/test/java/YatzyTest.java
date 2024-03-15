import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YatzyTest {

    @Test
    void should_verify_all_dice_chance_scoring() {
        assertEquals(15, Yatzy.chance(new DiceResult(2, 3, 4, 5, 1)));
        assertEquals(16, Yatzy.chance(new DiceResult(3, 3, 4, 5, 1)));
    }

    @Test
    void should_verify_yatzy_chance_scoring() {
        assertEquals(50, Yatzy.yatzy(new DiceResult(4, 4, 4, 4, 4)));
        assertEquals(50, Yatzy.yatzy(new DiceResult(6, 6, 6, 6, 6)));
        assertEquals(0, Yatzy.yatzy(new DiceResult(6, 6, 6, 6, 3)));
    }

    @Test
    void should_verify_ones_scoring() {
        assertEquals(1, Yatzy.ones(new DiceResult(1, 2, 3, 4, 5)));
        assertEquals(2, Yatzy.ones(new DiceResult(1, 2, 1, 4, 5)));
        assertEquals(0, Yatzy.ones(new DiceResult(6, 2, 2, 4, 5)));
        assertEquals(4, Yatzy.ones(new DiceResult(1, 2, 1, 1, 1)));
    }

    @Test
    void should_verify_twos_scoring() {
        assertEquals(4, Yatzy.twos(new DiceResult(1, 2, 3, 2, 6)));
        assertEquals(10, Yatzy.twos(new DiceResult(2, 2, 2, 2, 2)));
    }

    @Test
    void should_verify_threes_scoring() {
        assertEquals(6, Yatzy.threes(new DiceResult(1, 2, 3, 2, 3)));
        assertEquals(12, Yatzy.threes(new DiceResult(2, 3, 3, 3, 3)));
    }

    @Test
    void should_verify_fours_scoring() {
        assertEquals(12, Yatzy.fours(new DiceResult(4, 4, 4, 5, 5)));
        assertEquals(8, Yatzy.fours(new DiceResult(4, 4, 5, 5, 5)));
        assertEquals(4, Yatzy.fours(new DiceResult(4, 5, 5, 5, 5)));
    }

    @Test
    void should_verify_fives_scoring() {
        assertEquals(10, Yatzy.fives(new DiceResult(4, 4, 4, 5, 5)));
        assertEquals(15, Yatzy.fives(new DiceResult(4, 4, 5, 5, 5)));
        assertEquals(20, Yatzy.fives(new DiceResult(4, 5, 5, 5, 5)));
    }

    @Test
    void should_verify_sixes_scoring() {
        assertEquals(0, Yatzy.sixes(new DiceResult(4, 4, 4, 5, 5)));
        assertEquals(6, Yatzy.sixes(new DiceResult(4, 4, 6, 5, 5)));
        assertEquals(18, Yatzy.sixes(new DiceResult(6, 5, 6, 6, 5)));
    }

    @Test
    void should_verify_one_pair_scoring() {
        assertEquals(6, Yatzy.scorePair(new DiceResult(3, 4, 3, 5, 6)));
        assertEquals(10, Yatzy.scorePair(new DiceResult(5, 3, 3, 3, 5)));
        assertEquals(12, Yatzy.scorePair(new DiceResult(5, 3, 6, 6, 5)));
    }

    @Test
    void should_verify_two_pair_scoring() {
        assertEquals(16, Yatzy.twoPairs(new DiceResult(3, 3, 5, 4, 5)));
        assertEquals(16, Yatzy.twoPairs(new DiceResult(3, 3, 5, 5, 5)));
    }

    @Test
    void should_verify_three_of_a_kind_scoring() {
        assertEquals(9, Yatzy.threeOfaKind(new DiceResult(3, 3, 3, 4, 5)));
        assertEquals(15, Yatzy.threeOfaKind(new DiceResult(5, 3, 5, 4, 5)));
        assertEquals(9, Yatzy.threeOfaKind(new DiceResult(3, 3, 3, 3, 5)));
        assertEquals(9, Yatzy.threeOfaKind(new DiceResult(3, 3, 3, 3, 3)));

    }

    @Test
    void should_verify_four_of_a_kind_scoring() {
        assertEquals(12, Yatzy.fourOfaKind(new DiceResult(3, 3, 3, 3, 5)));
        assertEquals(20, Yatzy.fourOfaKind(new DiceResult(5, 5, 5, 4, 5)));
    }

    @Test
    void should_verify_small_straight_scoring() {
        assertEquals(15, Yatzy.smallStraight(new DiceResult(1, 2, 3, 4, 5)));
        assertEquals(15, Yatzy.smallStraight(new DiceResult(2, 3, 4, 5, 1)));
        assertEquals(0, Yatzy.smallStraight(new DiceResult(1, 2, 2, 4, 5)));
    }

    @Test
    void should_verify_large_straight_scoring() {
        assertEquals(20, Yatzy.largeStraight(new DiceResult(6, 2, 3, 4, 5)));
        assertEquals(20, Yatzy.largeStraight(new DiceResult(2, 3, 4, 5, 6)));
        assertEquals(0, Yatzy.largeStraight(new DiceResult(1, 2, 2, 4, 5)));
    }

    @Test
    void should_verify_full_house_scoring() {
        assertEquals(18, Yatzy.fullHouse(new DiceResult(6, 2, 2, 2, 6)));
        assertEquals(0, Yatzy.fullHouse(new DiceResult(2, 3, 4, 5, 6)));
    }
}
