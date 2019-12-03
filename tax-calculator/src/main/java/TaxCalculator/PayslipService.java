package TaxCalculator;

import java.util.ArrayList;
import java.util.List;

public class PayslipService {

    public PayslipService() {

    }

    TaxCalculator taxCalculator = new TaxCalculator();

    public List<Payslip> toPayslips(List<Employee> employees) {
        List<Payslip> payslips = new ArrayList<>();

        for (Employee employee: employees) {
            payslips.add(calculatePayslip(employee));
        }
        return payslips;
    }

    public Payslip calculatePayslip(Employee employee){
        String name = employee.getFirstName() +" "+ employee.getLastName();
        String payPeriod = employee.getPaymentStartDate();
        int grossIncome = taxCalculator.calculateGrossIncome(employee.getAnnuSalary());
        int incomeTax = taxCalculator.calculateIncomeTax(employee.getAnnuSalary());
        int netIncome = taxCalculator.calculateNetIncome(grossIncome,incomeTax);
        int superannuation = taxCalculator.calculateSuper(grossIncome, employee.getSuperRate());

        return new Payslip(name,payPeriod,grossIncome,incomeTax,netIncome,superannuation);

    }


}
