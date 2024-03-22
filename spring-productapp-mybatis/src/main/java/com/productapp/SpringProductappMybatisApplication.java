package com.productapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.Product;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappMybatisApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappMybatisApplication.class, args);
	}
    @Autowired
    IProductService service;
    
	@Override
	public void run(String... args) throws Exception {
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Add Product: \n"+
		                   "2.Update Product: \n"+
				           "3.Delete Product: \n"+
		                   "4.Find All Product: \n"+
				           "5.Find product by ID: \n"+
		                   "6.Find Product by brand: \n"+
			               "7.Find product by price: \n"+
		                   "8.Find product by category and price:");
		System.out.println("Enter your choice:");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter product id:");
			int id=sc.nextInt();
			System.out.println("Enter product name:");
			String name=sc.next();
			System.out.println("Enter product brand:");
			String brand=sc.next();
			System.out.println("Enter product category:");
			String cat=sc.next();
			System.out.println("Enter product price:");
			double price=sc.nextDouble();
			service.addProduct(new Product(id,name,brand,cat,price));
			break;
		case 2:
			System.out.println("Enter product id:");
			int id1=sc.nextInt();
			System.out.println("Enter product price:");
			double price1=sc.nextDouble();
			service.updateProduct(id1, price1);
			break;
	   case 3:
		   System.out.println("Enter product id:");
		   int id2=sc.nextInt();
		   service.deleteProduct(id2);
		   break;
	   case 4:
		   System.out.println("Products List:");
		   List<Product> products=service.getAll();
		   for (Product product : products) {
			System.out.println(product);
		}
		   break;
	   case 5:
		   System.out.println("Enter Id:");
		   int id3=sc.nextInt();
		   Product product=service.getById(id3);
		   System.out.println(product);
		   break;
	   case 6:
		   System.out.println("Enter brand:");
		   String brand1=sc.next();
		   List<Product> products2=service.getByBrand(brand1);
		   for (Product product2 : products2) {
			System.out.println(product2);
		   }
		   break;
	   case 7:
		   System.out.println("Enter price:");
		   double price2=sc.nextDouble();
		   List<Product> products3=service.getByLessPrice(price2);
		   for (Product product2 : products3) {
			System.out.println(product2);
		}
		   break;
	   case 8:
		   System.out.println("Enter category and price:");
		   String cat1=sc.next();
		   double price3=sc.nextDouble();
		   List<Product> products4=service.getByCategortyandPrice(cat1, price3);
		   for (Product product2 : products4) {
			System.out.println(product2);
		}
		}
		
	}

}
