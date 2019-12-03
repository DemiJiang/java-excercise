package TaxCalculator;

public class TaxCalculator {
    TaxTable taxTable = new TaxTable();

    public int calculateGrossIncome(int annuSalary) {
        return annuSalary / 12;
    }

    public int calculateNetIncome(int grossIncome, int incomeTax) {
        return grossIncome - incomeTax;
    }

    public int calculateSuper(int grossIncome,  double superRate) {
        return (int)(grossIncome * superRate);
    }

    public int calculateIncomeTax(int annuSalary) {
        TaxBracket taxBracket = taxTable.getMatchBacket(annuSalary);
        return (int) Math.round((taxBracket.getAmount() + (annuSalary - taxBracket.getLowBand() )* taxBracket.getRate() ) / 12);
    }
}
