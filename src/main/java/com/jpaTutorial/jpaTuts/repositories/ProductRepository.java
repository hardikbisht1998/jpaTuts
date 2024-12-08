package com.jpaTutorial.jpaTuts.repositories;

import com.jpaTutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {


    List<ProductEntity> findBytitleOrderByPrice(String parleBiscuita);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime localDateTime);

    List<ProductEntity> findByQuantityAndPrice(int i, int i1);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, int i1);

    List<ProductEntity> findBytitleLike(String arl);

    List<ProductEntity> findBytitleContaining(String s);

//    Optional<ProductEntity> findByTitleAndPrice(String parleBiscuitb, BigDecimal bigDecimal);

    @Query("select e from ProductEntity e where e.title=?1 and e.price=?2 ")
    Optional<ProductEntity> findByTitleAndPrice(String parleBiscuitb, BigDecimal bigDecimal);

    List<ProductEntity> findBy(Sort sort);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);
}
