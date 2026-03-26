package za.ac.cput.repository;

import za.ac.cput.domain.Invoice;
import java.util.ArrayList;
import java.util.List;

public class InvoiceRepository implements IInvoiceRepository {

    private static IInvoiceRepository repository = null;
    private List<Invoice> invoiceList;

    private InvoiceRepository() {
        invoiceList = new ArrayList<>();
    }

    public static IInvoiceRepository getInstance() {
        if (repository == null) {
            repository = new InvoiceRepository();
        }
        return repository;
    }

    @Override
    public Invoice create(Invoice invoice) {
        if (invoiceList.add(invoice)) {
            return invoice;
        }
        return null;
    }

    @Override
    public Invoice read(String invoiceId) {
        for (Invoice i : invoiceList) {
            if (i.getInvoiceId().equals(invoiceId)) {
                return i;
            }
        }
        return null;
    }

    @Override
    public Invoice update(Invoice invoice) {
        Invoice oldInvoice = read(invoice.getInvoiceId());
        if (oldInvoice != null) {
            invoiceList.remove(oldInvoice);
            if (invoiceList.add(invoice)) {
                return invoice;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String invoiceId) {
        Invoice invoiceToDelete = read(invoiceId);
        if (invoiceToDelete == null) {
            return false;
        }
        return invoiceList.remove(invoiceToDelete);
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceList;
    }
}