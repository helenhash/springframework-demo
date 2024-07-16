package com.helen.demo.repository;

import com.helen.demo.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    /**
     * Find price of product has value greater than priceMin and less than price max
     * @param priceMin the price min
     * @param priceMax the price max
     * @return
     */
    List<Product> findByPriceGreaterThanAndPriceLessThan(BigDecimal priceMin, BigDecimal priceMax);

    /**
     * Query list product has name like name param
     * @param name the name search
     * @return
     */
    @Query("FROM Product WHERE name LIKE %:name%")
    List<Product> findProductNameLike(@Param("name") String name);

    /**
     * Find product has id in list of id param
     * @param ids the list id query
     * @return
     */
    @Query(value = "SELECT p.* FROM pro p WHERE p.id in (:ids)", nativeQuery = true)
    List<Product> findProductIdIn(@Param("ids") List<Integer> ids);


    /**
     * Find price of product has value greater than price param with paging and sort
     * @param price the price
     * @param pageable the paging and sort
     * @return
     */
    Page<Product> findByPriceGreaterThan(BigDecimal price, Pageable pageable);
}
