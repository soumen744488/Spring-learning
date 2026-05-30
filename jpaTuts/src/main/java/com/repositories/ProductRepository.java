package com.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpatuts.entites.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	List<ProductEntity> findByTitleOrderByPriceAsc(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime inpuTime);

  

    List<ProductEntity> findBy(Sort by);
   
   


}
