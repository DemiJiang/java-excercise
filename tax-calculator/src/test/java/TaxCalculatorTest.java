import TaxCalculator.TaxCalculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaxCalculatorTest {

    @Test
    public void shouldCalculateGrossIncome() {
        TaxCalculator calculator = new TaxCalculator();
        int grossIncome = calculator.calculateGrossIncome(60050);
        assertEquals(5004, grossIncome);
    }

    @Test
    public void shouldCalculateNetIncome(){
        TaxCalculator calculator = new TaxCalculator();
        int netIncome = calculator.calculateNetIncome(5004, 922);
        assertEquals(4082, netIncome);
    }

    @Test
    public void shouldCalculateSuperannuation(){
        TaxCalculator calculator = new TaxCalculator();
        int superannuation = calculator.calculateSuper(5004, 0.09);
        assertEquals(450, superannuation);
    }

    @Test
    public void shouldCalculateIncomeTax(){
        TaxCalculator calculator = new TaxCalculator();
        int incomeTax = calculator.calculateIncomeTax(60050);
        assertEquals(922, incomeTax);

    }


}
