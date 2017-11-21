package com.iia.tptest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.iia.tptest.entity.Customer;
import com.iia.tptest.entity.Product;
import com.iia.tptest.entity.Order;
import com.iia.tptest.entity.OrderState;
import com.iia.tptest.repository.OrderRepository;
import com.iia.tptest.repository.CustomerRepository;
import com.iia.tptest.repository.ProductRepository;



/**	
 * 
 * Application
 * @author Antoine
 *
 */


@SpringBootApplication
public class Application {
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	@Bean
	public CommandLineRunner demo(CustomerRepository repositoryCustomer, ProductRepository repositoryProduct, OrderRepository repositoryOrder) {
		return (args) -> {
			
			repositoryCustomer.deleteAll();
			repositoryProduct.deleteAll();
			repositoryOrder.deleteAll();
			
			
			//DATE FORMAT
			Date date = new Date();
			DateFormat dateShort = DateFormat.getDateTimeInstance(
				DateFormat.SHORT,
				DateFormat.SHORT);
			
			//CUSTOMER
			Customer customerN1 = new Customer("Jack", "Bauer", "064641742", "44 rue du sada", 53641, "Kal");
			Customer customerN2 = new Customer("Jean", "Abdoul", "064614152", "44 rue du sda", 53640, "Aal");
			Customer customerN3 = new Customer("Pedro", "Lito", "0646752", "44 rue du car", 53652, "Cal");
			Customer customerN4 = new Customer("Albert", "Abdoul", "064784152", "44 rue du br", 53452, "Bal");
			Customer customerN5 = new Customer("Jacqueline", "Kaka", "07985464152", "44 rue du c", 53472, "Dal");
			
		
            //PRODUCT
            
			Product productN1 = new Product("Camembert", "Ceci est un camembert de qualite superieure qui pue bien sa mere", 26, true, 17844.12f);
			Product productN2 = new Product("Cacahuete", "Ceci est une cacahuete de qualite superieure", 20, true, 185541.12f);
			Product productN3 = new Product("Arachide", "Ceci est un arachide de qualite superieure", 18, false, 15445.1545f);
			Product productN4 = new Product("Noix de cajou", "Ceci est une noix de cajou de qualite superieure", 17, true, 55484.184f);
			Product productN5 = new Product("Amande", "Ceci est une Amande de qualite superieure", 15, true, 548754.141f);

		
			//ORDER
			Order orderN1 = new Order(dateShort.format(date), OrderState.Brouillon, 125849.15f, customerN1);
			Order orderN2 = new Order(dateShort.format(date), OrderState.EnCours, 125849.15f, customerN1);
			Order orderN3 = new Order(dateShort.format(date), OrderState.Fini, 125849.15f, customerN1);
			Order orderN4 = new Order(dateShort.format(date), OrderState.Brouillon, 125849.15f, customerN1);
			Order orderN5 = new Order(dateShort.format(date), OrderState.EnCours, 125849.15f, customerN1);
			
			List<Order> orders = new ArrayList<Order>();
			orders.add(orderN1);
			orders.add(orderN2);
			orders.add(orderN3);
			orders.add(orderN4);
			orders.add(orderN5);
			
			//ORDER'S CUSTOMERS
			customerN1.setOrders(orders);
			customerN2.setOrders(orders);
			customerN3.setOrders(orders);
			
			//ADD ORDER IN PRODUCT
			productN1.OrderAdd(orderN1);
			productN1.OrderAdd(orderN3);
			productN2.OrderAdd(orderN2);
			productN3.OrderAdd(orderN5);

			//ADD PRODUCT IN ORDER
			orderN1.ProductAdd(productN1);
			orderN2.ProductAdd(productN2);			
			orderN3.ProductAdd(productN1);
			orderN4.ProductAdd(productN3);
			
			//SAVE PRODUCT
			log.info("\n*************************************************************************************************");
			repositoryProduct.save(productN1);
			log.info("\nThis product has been added : " + productN1.toString());
			repositoryProduct.save(productN2);
			log.info("\nThis product has been added : " + productN2.toString());
			repositoryProduct.save(productN3);
			log.info("\nThis product has been added : " + productN3.toString());
			log.info("\n*************************************************************************************************");
			
			//SAVE CUSTOMER
			log.info("\n*************************************************************************************************");
			repositoryCustomer.save(customerN1);
			log.info("\nThis customer has been added : " + customerN1.toString());
			repositoryCustomer.save(customerN2);
			log.info("\nThis customer has been added : " + customerN2.toString());
			repositoryCustomer.save(customerN3);
			log.info("\nThis customer has been added : " + customerN3.toString());
			log.info("\n*************************************************************************************************");
			
			//SAVE ORDER
			log.info("\n*************************************************************************************************");
			repositoryOrder.save(orderN1);
			log.info("\nThis order has been added : " + orderN1.toString());
			repositoryOrder.save(orderN2);
			log.info("\nThis order has been added : " + orderN2.toString());
			repositoryOrder.save(orderN3);
			log.info("\nThis order has been added : " + orderN3.toString());
			log.info("\n*************************************************************************************************");
			
			
		};
	}

}
