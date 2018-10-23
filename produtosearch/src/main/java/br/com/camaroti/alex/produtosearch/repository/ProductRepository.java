package br.com.camaroti.alex.produtosearch.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;
import org.springframework.stereotype.Repository;

import br.com.camaroti.alex.produtosearch.model.Product;

@Repository
public interface ProductRepository extends ElasticsearchCrudRepository<Product, String>{
	
	List<Product> findByTags(String tag);

}
