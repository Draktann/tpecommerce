package com.iia.tptest.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * Class @see Order from database
 * @author Antoine
 *
 */

@Entity
@Table(name = "order")
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String date;
	private float totalPrice;
	private OrderState state;

	
	/**
	 * 
	 * Empty constructor class @see Order
	 */
	protected Order() {}
	
	
	/**
	 * 
	 * Constructor class 	@see Order			
	 * @param date			@see String			date of @see Order
	 * @param state			@see Orderstate 	state of @see Order
	 * @param totalPrice 	@see Float			totalPrice of @see Order
	 * @param customer 		@see Customer		customer of @see Order
	 */
	
	public Order(String date, OrderState state, float totalPrice, Customer customer) {
		this.setDate(date)
		.setState(state)
		.setTotalPrice(totalPrice)
		.setCustomer(customer);
	}
	
	/**
	 * 
	 * Override of the method @see toString() for the class @see Order
	 */
	@Override
	public String toString() {
		return "\nDate : " + this.getDate() 
			+ "\nState : " + this.getState() 
			+ "\nTotalPrice : " + this.getTotalPrice() 
			+ "\n";
		
	}
	
	/**
	 * 
	 * Reference ManyToOne to @see Customer
	 * 
	 */
	
	
	@ManyToOne
	private Customer customer;

	/**
	 * 
	 * 
	 * @return customer
	 */
	
	public Customer getCustomer() {
		return customer;
	}
	
	
	 /**
	  * 
	  * @param customer the customer to set
	  * @return this @see Order
	  */

	public Order setCustomer(Customer customer) {
		this.customer = customer;
		return this;
	}
	
	/**
	 * Reference ManyToMany to @see Product
	 * 
	 */
	
	@ManyToMany(targetEntity = Product.class, cascade=CascadeType.MERGE)
	
	/**
	 * Reference Table "product_order" in database
	 * 
	 */
	
	@JoinTable(
			name = "product_order",
			joinColumns = {@JoinColumn(name = "order_id")},
			inverseJoinColumns = {@JoinColumn(name = "product_id")})
	private Set<Product> products = new HashSet<>();
	
	/**
	 * 
	 * @return the products
	 */
	
	public Set<Product> getProducts() {
		return products;
	}
	
	/**
	 * 
	 * @param products the products to set
	 * @return this @see Order
	 */
	
	public Order setProducts(Set<Product> products) {
		this.products = products;
		return this;
	}
	
	/**
	 * Add a @see Product to @Order products
	 * @param product @see Product product to add
	 */
	
	public void ProductAdd(Product product) {
		this.products.add(product);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public Order setId(int id) {
		this.id = id;
		return this;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public Order setDate(String date) {
		this.date = date;
		return this;
	}

	/**
	 * @return the totalPrice
	 */
	public float getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public Order setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
		return this;
	}

	/**
	 * @return the state
	 */
	public OrderState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public Order setState(OrderState state) {
		this.state = state;
		return this;
	}
}
	
	
	
	
	
	
	
	