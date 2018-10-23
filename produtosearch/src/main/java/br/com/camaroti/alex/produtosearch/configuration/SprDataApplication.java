package br.com.camaroti.alex.produtosearch.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import br.com.camaroti.alex.produtosearch.controller.ProductController;
import br.com.camaroti.alex.produtosearch.service.ProductService;

@SpringBootApplication
@ComponentScan(basePackageClasses = {ProductController.class, ProductService.class})
@EnableElasticsearchRepositories(basePackages = "br.com.camaroti.alex.produtosearch.repository")
public class SprDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprDataApplication.class, args);
	}

}
