package com.carlibassurance.datalayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carlibassurance.datalayer.model.Category;
import com.carlibassurance.datalayer.model.Comment;
import com.carlibassurance.datalayer.model.Product;
import com.carlibassurance.datalayer.service.CategoryService;
import com.carlibassurance.datalayer.service.CommentService;
import com.carlibassurance.datalayer.service.ProductService;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DatalayerApplication implements CommandLineRunner {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CommentService commentService;
	
	public static void main(String[] args) {
		SpringApplication.run(DatalayerApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		Iterable<Product> products = this.productService.getProducts();
		System.out.println("Liste des produits :");
		products.forEach(product -> {
			System.out.println(product.getName());
			if(product.getComments().size() > 0) {
				System.out.println("		Liste des commentaires :");
				product.getComments().forEach(comment -> System.out.println("			" + comment.getContent()));
			}
		});
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		Iterable<Category> categories = this.categoryService.getCategories();
		System.out.println("Liste des catégories :");
		categories.forEach(category -> {
			System.out.println(category.getName());
			if(category.getProducts().size() > 0) {
				System.out.println("		Liste des produits :");
				category.getProducts().forEach(product -> System.out.println("			" + product.getName()));
			}
		});
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		Iterable<Comment> comments = this.commentService.getComments();
		System.out.println("Liste des commentaires :");
		comments.forEach(comment -> System.out.println(comment.getContent()));
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
		Optional<Product> product = this.productService.getProduct(1);
		Product productInstance = product.get();
		System.out.println("Le produit numéro " + productInstance.getProduct_id() + " est : " + productInstance.getName() );
		System.out.println("---------------------------------------------------------------------------------------------------------------");
		
	}

}
