package File;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVReader;
import TaxCalculator.Employee;

public class EmployeeFileReader {
    public EmployeeFileReader() {
    }

    public List<Employee> loadResource(String fileName) throws IOException {

        CSVReader reader = new CSVReader(getReader(fileName), ',');

        List<Employee> employees = new ArrayList<Employee>();

        String[] line = null;

        while ((line = reader.readNext()) != null){
            Employee employee = new Employee();
            employee.setFirstName(line[0]);
            employee.setLastName(line[1]);
            employee.setAnnuSalary(parseAnnuSalary((line[2])));
            employee.setSuperRate(parseSuperRate((line[3])));
            employee.setPaymentStartDate(line[4]);
            employees.add(employee);
        }
        return employees;
   }

   private int parseAnnuSalary(String annuSalary){
       return Integer.parseInt(annuSalary);
   }

   private double parseSuperRate(String superRate){
      return Double.parseDouble(superRate);
   }

   private Reader getReader(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        return new FileReader(file);
   }



}
