package br.com.camaroti.alex.produtosearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.camaroti.alex.produtosearch.model.Product;
import br.com.camaroti.alex.produtosearch.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService service;

	@PostMapping("/product/add")
	public Product save(@RequestBody Product product) {
		return service.save(product);
	}

	@DeleteMapping("/product/{id}")
	public String delete(@PathVariable Product product) {
		service.delete(product);
		return "Document Deleted";
	}

	@GetMapping("/product/{id}")
	public Optional<Product> findById(@PathVariable String id) {
		return service.findById(id);
	}

	@GetMapping("/product/all")
	public Iterable<Product> findAll() {
		return service.findAll();
	}

	@GetMapping("/product/tag/{tag}")
	public List<Product> findByTags(@PathVariable String tag) {
		return service.findByTags(tag);
	}
	
	@PutMapping("/product/{id}")
	   public Product updateStudent(@PathVariable String id,@RequestBody Product product){
		product.setId(id);
		return service.save(product);
	}

}
