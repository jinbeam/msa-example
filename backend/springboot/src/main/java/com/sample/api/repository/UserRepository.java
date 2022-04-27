package com.sample.api.repository;

import com.sample.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * Created by jspark
 */
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {
//    Optional<User> findById(Integer id);
    Optional<User> findByUserId(String userId);

//    Product findByProductFkAndProductTable(Integer productFk, String productTable);
//
//    Product findProductByProductTableAndProductFk(String productTable, int productFk);
//    Page<Product> findAll(Specification<Product> spec, Pageable pageable);
}