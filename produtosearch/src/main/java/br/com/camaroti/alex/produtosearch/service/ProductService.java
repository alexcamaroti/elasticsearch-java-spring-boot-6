package br.com.camaroti.alex.produtosearch.service;

import java.util.List;
import java.util.Optional;

import br.com.camaroti.alex.produtosearch.model.Product;

public interface ProductService {

	Product save(Product product);
	void delete(Product product);
	Optional<Product> findById(String id);
	Iterable<Product> findAll();
	List<Product> findByTags(String tag);
	Product update(Product product);
}
