package br.com.camaroti.alex.produtosearch.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import br.com.camaroti.alex.produtosearch.controller.ProductController;
import br.com.camaroti.alex.produtosearch.model.Product;
import br.com.camaroti.alex.produtosearch.service.ProductService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ProductController.class, ProductService.class})
@EnableElasticsearchRepositories(basePackages = "br.com.camaroti.alex.produtosearch.repository")
public class SprDataApplication implements CommandLineRunner{

	
	@Autowired
	private ProductService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SprDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product prd1 = new Product("Nitendo Switch", "Videogames", "games", 
				new String[]{"nitendo", "switch", "videogame", "games"}, "Nitendo", 1400.0); 
	
	service.save(prd1);
	
	Iterable<Product> listProducts = service.findAll();
	for (Product product : listProducts) {
		System.out.println("Product: " + product);
	}
	}

}
