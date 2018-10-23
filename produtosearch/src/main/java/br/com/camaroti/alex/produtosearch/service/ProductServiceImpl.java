package br.com.camaroti.alex.produtosearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.camaroti.alex.produtosearch.model.Product;
import br.com.camaroti.alex.produtosearch.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	
	@Override
	public Product save(Product product) {
		return repository.save(product);
	}

	@Override
	public void delete(Product product) {
		repository.delete(product);
	}

	@Override
	public Optional<Product> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Iterable<Product> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Product> findByTags(String tag) {
		return repository.findByTags(tag);
	}

	@Override
	public Product update(Product product) {
		Optional<Product> prd = repository.findById(product.getId());
		   if(prd.isPresent()){
			   Product s = prd.get();
			   s.setName(product.getName());
		   return repository.save(s);
		   }
		   else
			   return null;
	}

}
