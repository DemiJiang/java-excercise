package TaxCalculator;

import java.util.ArrayList;

public class TaxTable {
    private ArrayList<TaxBracket> taxTable = new ArrayList<>();

    public TaxTable(){
        taxTable.add(new TaxBracket(0, 18200, 0, 0));
        taxTable.add(new TaxBracket(18200, 37000, 0, 0.19));
        taxTable.add(new TaxBracket(37000, 87000, 3572, 0.325));
        taxTable.add(new TaxBracket(87000, 180000, 19822, 0.37));
        taxTable.add(new TaxBracket(180000, Integer.MAX_VALUE, 54232, 0.45));
    }

    public TaxBracket getMatchBacket(int annuSalary){
        return taxTable.stream()
                .filter(taxBracket -> annuSalary > taxBracket.getLowBand() && annuSalary <= taxBracket.getHighBand())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No bracket found"));
    }

}
