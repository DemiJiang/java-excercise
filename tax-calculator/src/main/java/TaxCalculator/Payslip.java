package TaxCalculator;

public class Payslip {
    private String name;
    private String payPeriod;
    private int grossIncome;
    private int incomeTax;
    private int netIncome;
    private int superannuation;

    public String getName() {
        return name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public int getGrossIncome() {
        return grossIncome;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public int getSuperannuation() {
        return superannuation;
    }

    public Payslip(String name, String payPeriod, int grossIncome, int incomeTax, int netIncome, int superannuation) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superannuation = superannuation;
    }


}
