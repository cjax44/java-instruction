package com.mma.db;

import org.springframework.data.repository.CrudRepository;

import com.mma.business.Invoice;
import com.mma.business.LineItem;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{

}
