import File.EmployeeFileReader;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class EmployeeFileReaderTest {

    String home = System.getProperty("user.home");
    String fileName = home + "/tax-service/src/main/resources/employee_data.csv";
    EmployeeFileReader reader = new EmployeeFileReader();

    @Test
    public void shouldReadEmployeeFirstName() throws IOException {
        String employeeFirstName = reader.loadResource(fileName).get(0).getFirstName();
        assertEquals("David", employeeFirstName);
    }

    @Test
    public void shouldReadEmployeeAnnualSalary() throws IOException {
        int employeeAnnuSalary = reader.loadResource(fileName).get(0).getAnnuSalary();
        assertEquals(60050, employeeAnnuSalary);
    }

    @Test
    public void shouldReadEmployeeSuperRate() throws IOException {
        double employeeSuperRate = reader.loadResource(fileName).get(0).getSuperRate();
        assertEquals(0.09, employeeSuperRate);
    }

}
