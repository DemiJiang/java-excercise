import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FractionsEqualsTest {
    @Test
    public void sameNumeratorAndDenominator() throws Exception {
        assertEquals(new Fraction(3, 5), new Fraction(3, 5));
    }

    @Test
    public void differentNumerators() {
        assertNotEquals(new Fraction(1,5), new Fraction(2, 5));
    }

    @Test
    public void differentDenominators() {
        assertNotEquals(new Fraction(3, 4), new Fraction(3, 7));
    }

    @Test
    public void wholeNumberEqualsSameFraction() {
        assertEquals(new Fraction(5, 1), new Fraction(5));
    }

    @Test
    public void wholeNumberNotEqualToDifferentWholeNumber() {
        assertNotEquals(new Fraction(6), new Fraction(5));
    }

    @Test
    public void reduceResultToWholeNumber() {
        assertEquals( new Fraction(1), new Fraction(1,3).plus(new Fraction(2, 3)));
    }

    @Test
    public void oneDenominatorIsMultipleOfTheOther() {
        assertEquals(new Fraction(11, 8), new Fraction(3, 4).plus(new Fraction(5, 8)));
    }

    @Test
    public void commonFactorInDenominators() {
        assertEquals(new Fraction(11, 18), new Fraction(1, 6).plus(new Fraction(4, 9)));
    }

    @Test
    public void reduceResultWhenDenominatorsAreTheSame() {
        assertEquals(new Fraction(3,2), new Fraction(3, 4).plus(new Fraction(3, 4)));
    }

    @Test
    public void negativeFractionAndReducing() {
        assertEquals(new Fraction(1,2), new Fraction(-1, 4).plus(new Fraction(3, 4)));
        assertEquals(new Fraction(-1,8), new Fraction(3, 8).plus(new Fraction(-1, 2)));

    }

    @Test
    @Ignore("Ingore")
    public void negativeSignsEverywhere() {
        assertEquals(new Fraction(1,2), new Fraction(1, -4).plus(new Fraction(-3, -4)));
    }
}
