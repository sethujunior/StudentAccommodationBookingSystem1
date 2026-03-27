package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Invoice;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceFactoryTest {

    @Test
    void testCreateInvoiceSuccess() {
        LocalDate testDate = LocalDate.now();
        String studentInfo = "Siyalezo - 221789812";
        double amount = 2500.00;

        Invoice invoice = InvoiceFactory.createInvoice(testDate, studentInfo, amount);

        assertNotNull(invoice);
        assertNotNull(invoice.getInvoiceId());
        assertEquals(studentInfo, invoice.getStudentDetails());
        assertEquals(testDate, invoice.getDate());
        assertEquals(amount, invoice.getTotalAmount());

        System.out.println("Success: " + invoice.toString());
    }

    @Test
    void testCreateInvoiceWithNullDate() {
        Invoice invoice = InvoiceFactory.createInvoice(null, "Siyalezo", 1000.00);

        assertNull(invoice);
        System.out.println("Null Date Test: Correctly returned null");
    }

    @Test
    void testCreateInvoiceWithEmptyStudentDetails() {
        Invoice invoice = InvoiceFactory.createInvoice(LocalDate.now(), "", 500.00);

        assertNull(invoice);
        System.out.println("Empty Student Details Test: Correctly returned null");
    }

    @Test
    void testCreateInvoiceWithNegativeAmount() {
       Invoice invoice = InvoiceFactory.createInvoice(LocalDate.now(), "Siyalezo", -50.00);

        assertNull(invoice);
        System.out.println("Negative Amount Test: Correctly returned null");
    }
}