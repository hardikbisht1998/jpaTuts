package com.jpaTutorial.jpaTuts;

import com.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}


	@Test
	void testRepository(){
		ProductEntity productEntity=ProductEntity.builder()
				.sku("nestle2334").title("Nestle Chocolate").price(BigDecimal.valueOf(1212.12)).quantity(2).build();

		ProductEntity savedProduct= productRepository.save(productEntity);
		System.out.println(savedProduct);
	}


	@Test
	void getRepository(){
//		List<ProductEntity> entityList=productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));

//		List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(3,122);
//		List<ProductEntity> entities=productRepository.findBytitleLike("%arl%");
//		List<ProductEntity> entities=productRepository.findBytitleContaining("arl");

		Optional<ProductEntity> entities=productRepository.findByTitleAndPrice("parle biscuitb",BigDecimal.valueOf(11));
		System.out.println(entities);
	}




}
