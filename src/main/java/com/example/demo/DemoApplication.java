package com.example.demo;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PartRepository partRepository, ProductRepository productRepository) {
		return args -> {
			Iterable<Part> parts = partRepository.findAll();
			boolean hasParts = parts.iterator().hasNext();
			if (!hasParts) {
				partRepository.save(new InhousePart("Ryzen 9 CPU", 499.99, 20, 1, 5, 1));
				partRepository.save(new OutsourcedPart("32BG (2x 16GB) DDR5 RAM", 119.99, 20, 1, 5, "test"));
				partRepository.save(new InhousePart("ATX Computer Tower", 59.99, 20, 1, 5, 3));
				partRepository.save(new OutsourcedPart("Radeon RX7900 XT GPU", 799.99, 20, 1, 5, "test"));
				partRepository.save(new InhousePart("X870E Socket AM5 Motherboard", 499.99, 20, 1, 5, 5));


			}




				/*for (Part partItems : partsList) {
					List<Part> foundParts = partRepository.search(partItems.getName());
					boolean exists = false;
					for (Part p : foundParts) {
						if (p.getName().equalsIgnoreCase(partItems.getName())) {
							exists = true;
							break;
						}
					}
					if (!exists) {
						partRepository.save(partItems);
					}
				}
			}*/
			Iterable<Product> products = productRepository.findAll();
			boolean hasProducts = products.iterator().hasNext();
			if (!hasProducts) {
				productRepository.save(new Product("Gaming Computer", 2099.99, 3));
				productRepository.save(new Product("Content Creation Computer", 2799.99, 3));
				productRepository.save(new Product("Gaming Motherboard and CPU Kit", 899.99, 3));
				productRepository.save(new Product("Gaming RAM and GPU Kit", 779.99, 3));
				productRepository.save(new Product("Gaming CPU and RAM Kit", 579.99, 3));

			}



			/*for (Product productItems : productList) {
				List<Product> foundProducts = productRepository.search(productItems.getName());
				boolean exists = false;
				for (Product p : foundProducts) {
					if (p.getName().equalsIgnoreCase(productItems.getName())) {
						exists = true;
						break;
					}
				}
				if (!exists) {
					productRepository.save(productItems);
				}
			}*/

		};
	}

}
