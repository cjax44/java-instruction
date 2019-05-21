package com.mma.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mma.business.Invoice;
import com.mma.business.JsonResponse;
import com.mma.business.Product;
import com.mma.db.InvoiceRepository;
import com.mma.db.ProductRepository;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceRepository invoiceRepo;

	public JsonResponse getAll() {
		JsonResponse jr = null;
		try {
			jr = JsonResponse.getInstance(invoiceRepo.findAll());

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;

	}

	@GetMapping("/{id}")
	public JsonResponse getAll(@PathVariable int id) {
		JsonResponse jr = null;
		try {
			Optional<Invoice> p = invoiceRepo.findById(id);
			if (p.isPresent())
				jr = JsonResponse.getInstance(p);
			else
				jr = JsonResponse.getInstance("No product found for id: " + id);

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;

	}
	
	@DeleteMapping("/")
	public JsonResponse delete(@RequestBody Invoice p) {
		JsonResponse jr = null;
		// NOTE: May want to enhance exception handling
		try {
			if (invoiceRepo.existsById(p.getId())) {
				invoiceRepo.delete(p);
			jr = JsonResponse.getInstance("Product deleted.");
			}
			else {
				jr = JsonResponse.getInstance("Product ID: " + p.getId() + " does not exist and you are attempting to delete it");
			}

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
		
	}
	
	@PutMapping("/")
	public JsonResponse update(@RequestBody Invoice p) {
		JsonResponse jr = null;
		// NOTE: May want to enhance exception handling
		try {
			if (invoiceRepo.existsById(p.getId())) {
			jr = JsonResponse.getInstance(invoiceRepo.save(p));
			}
			else {
				jr = JsonResponse.getInstance("Product ID: " + p.getId() + " does not exist and you are attempting to save it");
			}

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;
		
	}

	
	@PostMapping("/")
	public JsonResponse add(@RequestBody Invoice p) {
		JsonResponse jr = null;
		// NOTE: May want to enhance exception handling
		try {
			jr = JsonResponse.getInstance(invoiceRepo.save(p));

		} catch (Exception e) {
			jr = JsonResponse.getInstance(e);
		}
		return jr;

	}

}
