package TaxCalculator;

public class Employee {
    private String firstName;
    private String lastName;
    private int annuSalary;
    private double superRate;
    private String paymentStartDate;


    public Employee(String firstName, String lastName, int annuSalary, double superRate, String paymentStartDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annuSalary = annuSalary;
        this.superRate = superRate;
        this.paymentStartDate = paymentStartDate;
    }

    public Employee() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAnnuSalary() {
        return annuSalary;
    }

    public void setAnnuSalary(int annuSalary) {
        this.annuSalary = annuSalary;
    }

    public double getSuperRate() {
        return superRate;
    }

    public void setSuperRate(double superRate) {
        this.superRate = superRate;
    }

    public String getPaymentStartDate() {
        return paymentStartDate;
    }

    public void setPaymentStartDate(String paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }
}
