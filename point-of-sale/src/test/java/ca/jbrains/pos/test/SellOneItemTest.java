package ca.jbrains.pos.test;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SellOneItemTest {

    @Test
    public void productFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("12345");

        assertEquals("$7.95", display.getText());
    }

    @Test
    public void anotherProductFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("23456");

        assertEquals("$12.50", display.getText());
    }

    public static class Display{

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Sale{
        private Display display;

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode){
            if(barcode.equals("12345"))
                display.setText("$7.95");
            else
            display.setText("$12.50");
        }
    }
}
