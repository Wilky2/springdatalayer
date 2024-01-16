package com.carlibassurance.datalayer.model;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@DynamicUpdate
@Table(name = "produit")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="produit_id")
	private int product_id;
	
	@Column(name="nom")
	private String name;
	
	@Column(name="description")
	private String description;
	
	@Column(name="cout")
	private int cost;
	
	@OneToMany(
			mappedBy="product",
			cascade = CascadeType.ALL,
			orphanRemoval=true
			)
	private List<Comment> comments = new ArrayList<Comment>();
	
	@ManyToMany(
			mappedBy="products",
			cascade=CascadeType.ALL
			)
	List<Category> categories = new ArrayList<Category>();

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment) {
        comments.add(comment);
        comment.setProduct(this);
    }
 
    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setProduct(null);
    }
	
}
