package CLI;

import File.EmployeeFileReader;
import File.PayslipFileWriter;
import TaxCalculator.Employee;
import TaxCalculator.Payslip;
import TaxCalculator.PayslipService;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        String csv = "data.csv";
        String home = System.getProperty("user.home");
        String fileName = home + "/tax-service/src/main/resources/employee_data.csv";
        EmployeeFileReader reader = new EmployeeFileReader();
        List<Employee> employees = reader.loadResource(fileName);
        PayslipService payslipService = new PayslipService();
        List<Payslip> payslips = payslipService.toPayslips(employees);
        PayslipFileWriter writer = new PayslipFileWriter();


//        CSVWriter writer = new CSVWriter(new FileWriter(csv, true));
//
////        for(Payslip payslip: payslips){
////            writer.writeNext(writerone.buildLine(payslip));
////        }
//        String [] record = writerone.buildLine(payslips.get(0));
//
//        writer.writeNext(record);
       writer.write(csv, payslips);

    }
    }
