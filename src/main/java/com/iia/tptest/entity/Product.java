package com.iia.tptest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


/**
 * Class @see Product from database
 * @author Antoine
 *
 */


@Entity
@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String description;
	private int quantity;
	private boolean dead;
	private float price;

	/**
	 * Empty constructor class @see Product
	 */
	protected Product() {}
	
	/**
	 * 
	 * @param name				@see String		name of @see Product
	 * @param description		@see String 	description of @see Product
	 * @param quantity			@see Integer 	quantity of @see Product
	 * @param dead				@see Boolean 	dead of @see Product
	 * @param price				@see Float		price of @see Product
	 */
	
	public Product(String name, String description, int quantity, boolean dead, float price) {
		this.setName(name)
			.setDescription(description)
			.setQuantity(quantity)
			.setDead(dead)
			.setPrice(price);
	}
	
	/**
	 * Override of the method @see toString() for the class @see Product
	 */
	
	@Override
	public String toString() {
		return "\nName : " + this.getName() 
			+ "\nDescription : " + this.getDescription() 
			+ "\nQuantity : " + this.getQuantity() 
			+ "\nDead : " + this.getDead() 
			+ "\nPrice : " + this.getPrice() 
			+ "\n";
		
	}
	
	
	/**
	 * Reference ManyToMany to @see Order
	 * 
	 */
	
	@ManyToMany(targetEntity = Order.class, mappedBy = "products")
	private Set<Order> orders = new HashSet<>();
	
	
	/**
	 * 
	 * @return @see Set<Order> orders
	 */
	
	public Set<Order> getOrders() {
		return orders;
	}
	
	/**
	 * 
	 * @param orders @see Set<Order> orders to set
	 * @return @see Product
	 */
	
	public Product setOrders(Set<Order> orders) {
		this.orders = orders;
		return this;
	}
	/**
	 * Add a @see Order to @see Product products
	 * @param order @see Order order to add
	 */
	
	public void OrderAdd(Order order) {
		this.orders.add(order);
	}
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 * @return this @see Product
	 */
	public Product setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 * @return this @see Product
	 */
	public Product setName(String name) {
		this.name = name;
		return this;
	}
	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * @param description the description to set
	 * @return this @see Product
	 */
	public Product setDescription(String description) {
		this.description = description;
		return this;
	}
	
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * @param quantity the quantity to set
	 * @return this @see Product
	 */
	public Product setQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}
	
	/**
	 * @return the dead
	 */
	public Boolean getDead() {
		return dead;
	}
	
	/**
	 * @param dead the dead to set
	 * @return this @see Product
	 */
	public Product setDead(Boolean dead) {
		this.dead = dead;
		return this;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 * @return this @see Product
	 */
	public Product setPrice(float price) {
		this.price = price;
		return this;
	}
	 	 
}
