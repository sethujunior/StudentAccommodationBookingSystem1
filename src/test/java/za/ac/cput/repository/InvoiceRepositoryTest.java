package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.Invoice;
import za.ac.cput.factory.InvoiceFactory;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceRepositoryTest {
    private static IInvoiceRepository repository = InvoiceRepository.getInstance();
    private static Invoice invoice;

    @BeforeAll
    static void setUp() {
        // Create an initial invoice using the factory
        invoice = InvoiceFactory.createInvoice(
                LocalDate.now(),
                "Siyalezo Mbuyisa - 221789812",
                1500.00
        );
    }

    @Test
    void a_create() {
        Invoice created = repository.create(invoice);
        assertNotNull(created);
        assertEquals(invoice.getInvoiceId(), created.getInvoiceId());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Invoice read = repository.read(invoice.getInvoiceId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        // Updating the amount using the builder's copy method
        Invoice updated = new Invoice.Builder()
                .copy(invoice)
                .setTotalAmount(2000.00)
                .build();

        Invoice result = repository.update(updated);
        assertNotNull(result);
        assertEquals(2000.00, result.getTotalAmount());
        System.out.println("Updated: " + result);
    }

    @Test
    void d_getAll() {
        assertNotNull(repository.getAll());
        System.out.println("All Invoices: " + repository.getAll());
    }

    @Test
    @Disabled("Disabled to keep data for other tests if needed")
    void e_delete() {
        boolean deleted = repository.delete(invoice.getInvoiceId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }
}