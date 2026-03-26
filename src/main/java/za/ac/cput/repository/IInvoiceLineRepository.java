package za.ac.cput.repository;

import za.ac.cput.domain.InvoiceLine;
import java.util.List;

public interface IInvoiceLineRepository extends IRepository<InvoiceLine, String> {
    List<InvoiceLine> getAll();
}