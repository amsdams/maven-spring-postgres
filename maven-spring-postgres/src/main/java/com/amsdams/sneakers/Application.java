package com.amsdams.sneakers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.amsdams.sneakers.entity.Brand;
import com.amsdams.sneakers.entity.Product;
import com.amsdams.sneakers.entity.Shop;
import com.amsdams.sneakers.entity.Size;
import com.amsdams.sneakers.repo.BrandRepo;
import com.amsdams.sneakers.repo.ProductRepo;
import com.amsdams.sneakers.repo.ShopRepo;
import com.amsdams.sneakers.repo.SizeRepo;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EntityScan(basePackages = { "com.amsdams.sneakers.entity" }) 
@EnableJpaRepositories(basePackages = { "com.amsdams.sneakers.repo" })

public class Application implements CommandLineRunner {

	@Autowired
	private ProductRepo productRepo;

	@Autowired
	private ShopRepo shopRepo;

	@Autowired
	private SizeRepo sizeRepo;

	@Autowired
	private BrandRepo brandRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/* @Override */
	public void run(String... args) throws Exception {
		shopRepo.deleteAll();
		productRepo.deleteAll();
		sizeRepo.deleteAll();
		brandRepo.deleteAll();
		// save a couple of Sizes

		sizeRepo.save(new Size("43"));
		sizeRepo.save(new Size("XL"));
		sizeRepo.save(new Size("XXS"));

		// fetch all Sizes
		log.info("Sizes found with findAll():");
		log.info("-------------------------------");
		List<Size> sizes = (List<Size>) sizeRepo.findAll();

		for (Size size : sizes) {
			log.info(size.toString());
		}

		brandRepo.save(new Brand("PUMA"));
		brandRepo.save(new Brand("Trapstar"));

		// fetch all Brands
		log.info("Brands found with findAll():");
		log.info("-------------------------------");
		List<Brand> brands = (List<Brand>) brandRepo.findAll();

		for (Brand brand : brands) {
			log.info(brand.toString());
		}

		// save a couple of Products
		productRepo.save(new Product("Air Max", brands, BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));
		productRepo.save(new Product("ZX Flux", brands, BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));
		productRepo.save(new Product("Blaze of Glory", brands, BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0),
				"http://www.google.com", sizes));

		// fetch all products
		log.info("Products found with findAll():");
		log.info("-------------------------------");
		List<Product> products = (List<Product>) productRepo.findAll();

		for (Product product : products) {
			log.info(product.toString());
		}

		// fetch an individual product

		log.info("Products found with findByName('Air Max'):");
		log.info("--------------------------------");
		for (Product product : productRepo.findByName("Air Max", new PageRequest(0, 20))) {
			log.info(product.toString());
		}

		// save a couple of Shops
		shopRepo.save(new Shop("shopName", "http://www.google.com/shops", products));

		// fetch all Shops
		log.info("Shops found with findAll():");
		log.info("--------------------------------");
		for (Shop shop : shopRepo.findAll()) {
			log.info(shop.toString());
		}

		log.info("Products found with findByBrandsIn('" + brands.subList(0, 1).get(0) + "'):");
		log.info("--------------------------------");
		for (Product product : productRepo.findByBrandsIn(brands.subList(0, 1), new PageRequest(0, 20))) {
			log.info(product.toString());
		}

		log.info("Products found with findBySizesIn('" + sizes.subList(0, 1).get(0) + "'):");
		log.info("--------------------------------");
		for (Product product : productRepo.findBySizesIn(sizes.subList(0, 1), new PageRequest(0, 20))) {
			log.info(product.toString());
		}

	}
}
