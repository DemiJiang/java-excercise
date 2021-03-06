package ca.jbrains.pos.test;

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

    @Test
    public void productNotFound() {
        final Display display = new Display();
        final Sale sale = new Sale(display);

        sale.onBarcode("99999");

        assertEquals("Product not found for 99999", display.getText());
    }

    public static class Display {
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    public static class Sale {
        private Display display;

        public Sale(Display display) {
            this.display = display;
        }

        public void onBarcode(String barcode) {
            if (barcode.equals("12345"))
                display.setText("$7.95");
            else if (barcode.equals("23456"))
                display.setText("$12.50");
            else
                display.setText("Product not found for " +
                        barcode);
        }
    }
}
