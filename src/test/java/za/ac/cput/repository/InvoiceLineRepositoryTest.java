package za.ac.cput.repository;

import org.junit.jupiter.api.*;
import za.ac.cput.domain.InvoiceLine;
import za.ac.cput.factory.InvoiceLineFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class InvoiceLineRepositoryTest {
    private static IInvoiceLineRepository repository = InvoiceLineRepository.getInstance();
    private static InvoiceLine invoiceLine;

    @BeforeAll
    static void setUp() {
        invoiceLine = InvoiceLineFactory.createInvoiceLine(
                "Python Textbook",
                1,
                650.00
        );
    }

    @Test
    void a_create() {
        InvoiceLine created = repository.create(invoiceLine);
        assertNotNull(created);
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        InvoiceLine read = repository.read(invoiceLine.getInvoiceLineId());
        assertNotNull(read);
        assertEquals(invoiceLine.getDescription(), read.getDescription());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        InvoiceLine updated = new InvoiceLine.Builder()
                .copy(invoiceLine)
                .setQuantity(2)
                .setLineTotal(1300.00) // Assuming manual update or logic in builder
                .build();

        InvoiceLine result = repository.update(updated);
        assertNotNull(result);
        assertEquals(2, result.getQuantity());
        System.out.println("Updated: " + result);
    }

    @Test
    void d_getAll() {
        assertNotNull(repository.getAll());
        assertFalse(repository.getAll().isEmpty());
        System.out.println("All Lines: " + repository.getAll());
    }

    @Test
    @Disabled
    void e_delete() {
        boolean deleted = repository.delete(invoiceLine.getInvoiceLineId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }
}