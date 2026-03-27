package za.ac.cput.repository;

import za.ac.cput.domain.InvoiceLine;
import java.util.ArrayList;
import java.util.List;

public class InvoiceLineRepository implements IInvoiceLineRepository {

    private static IInvoiceLineRepository repository = null;
    private List<InvoiceLine> invoiceLineList;

    private InvoiceLineRepository() {
        invoiceLineList = new ArrayList<>();
    }

    public static IInvoiceLineRepository getInstance() {
        if (repository == null) {
            repository = new InvoiceLineRepository();
        }
        return repository;
    }

    @Override
    public InvoiceLine create(InvoiceLine invoiceLine) {
        if (invoiceLineList.add(invoiceLine)) {
            return invoiceLine;
        }
        return null;
    }

    @Override
    public InvoiceLine read(String invoiceLineId) {
        for (InvoiceLine il : invoiceLineList) {
            if (il.getInvoiceLineId().equals(invoiceLineId)) {
                return il;
            }
        }
        return null;
    }

    @Override
    public InvoiceLine update(InvoiceLine invoiceLine) {
        InvoiceLine oldLine = read(invoiceLine.getInvoiceLineId());
        if (oldLine != null) {
            invoiceLineList.remove(oldLine);
            if (invoiceLineList.add(invoiceLine)) {
                return invoiceLine;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String invoiceLineId) {
        InvoiceLine lineToDelete = read(invoiceLineId);
        if (lineToDelete == null) {
            return false;
        }
        return invoiceLineList.remove(lineToDelete);
    }

    @Override
    public List<InvoiceLine> getAll() {
        return invoiceLineList;
    }
}