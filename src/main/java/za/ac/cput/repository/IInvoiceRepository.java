package za.ac.cput.repository;

import za.ac.cput.domain.Invoice;
import java.util.List;

public interface IInvoiceRepository extends IRepository<Invoice, String> {
    List<Invoice> getAll();
}