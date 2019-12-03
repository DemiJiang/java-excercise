package File;

import TaxCalculator.Payslip;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PayslipFileWriter {
    public PayslipFileWriter() throws IOException {
    }

    public void write(String fileName, List<Payslip> payslips) throws IOException {
        File payslipFile = new File(fileName);
        CSVWriter writer = new CSVWriter(new FileWriter(payslipFile, true));
        for(Payslip payslip: payslips){
            writer.writeNext(toString(payslip));
        }
    }

    public String[] toString(Payslip payslip){
        return new String[]{
                payslip.getName(),
                payslip.getPayPeriod(),
                String.valueOf(payslip.getGrossIncome()),
                String.valueOf(payslip.getIncomeTax()),
                String.valueOf(payslip.getNetIncome()),
                String.valueOf(payslip.getSuperannuation())
        };
    }

}
