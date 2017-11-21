package com.iia.tptest.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.iia.tptest.entity.Order;
import com.iia.tptest.entity.Customer;

/**
 * Class @see Customer from database
 * @author Antoine
 *
 */


@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String phone;
	private String adress;
	private int cp;
	private String city;
	
	/**
	 * Empty constructor class @see Customer
	 * 
	 */
	protected Customer() {}
	
	/**
	 * 
	 * @param firstName		@see String		firstName of  @see Customer
	 * @param lastName 		@see String		lastName of  @see Customer
	 * @param phone			@see String		phone of  @see Customer
	 * @param adress		@see String		adress of  @see Customer
	 * @param cp			@see Integer	cp of  @see Customer
	 * @param city			@see String		city of  @see Customer
	 */
	
	public Customer(String firstName, String lastName, String phone, String adress, int cp, String city) {
		this.setLastName(lastName)
			.setFirstName(firstName)
			.setPhone(phone)
			.setAdress(adress)
			.setCp(cp)
			.setCity(city);

	}

	
	/**
	 * Override of the method @see toString() for the class @see Customer
	 */
	@Override
	public String toString() {
	return "\nLastName : " + this.getLastName() 
		+ "\nFirstName : " + this.getFirstName() 
		+ "\nPhone : " + this.getPhone() 
		+ "\nAddress : " + this.getAdress() 
		+ "\nCp : " + this.getCp() 
		+ "\nCity : " + this.getCity()
		+ "\n";
	
	}

	/**
	 * Reference OneToMany to @see Order
	 */
	
	@OneToMany(mappedBy="customer")
	private List<Order> orders;
	
	/**
	 * 
	 * 
	 * @return @see List<Order> A list of the @see Order
	 */
	public List<Order> getOrders() {
		return orders;
	}
	
	/**
	 * 
	 * @param orders the orders to set
	 * @return this @see Order
	 */
	
	public Customer setOrders(List<Order> orders) {
		this.orders = orders;
		return this;
	}
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 * @return this @see Customer
	 */
	public Customer setId(Long id) {
		this.id = id;
		return this;
	}
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param lastName the lastName to set
	 * @return this @see Customer
	 */
	public Customer setLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 * @return this @see Customer
	 */
	public Customer setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	
	/**
	 * @param phone the phone to set
	 * @return this @see Customer
	 */
	public Customer setPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	/**
	 * 
	 * @return the adress
	 */
	public String getAdress() {
		return adress;
	}
	
	/**
	 * @param adress the adress to set
	 * @return this @see Customer
	 */
	public Customer setAdress(String adress) {
		this.adress = adress;
		return this;
	}
	
	/**
	 * @return the cp
	 */
	public int getCp() {
		return cp;
	}
	
	/**
	 * @param cp the cp to set
	 * @return this @see Customer
	 */
	public Customer setCp(int cp) {
		this.cp = cp;
		return this;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param city the city to set
	 * @return this @see Customer
	 */
	public Customer setCity(String city) {
		this.city = city;
		return this;
	}

}
