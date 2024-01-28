package com.qp.assesment.repository;

import com.qp.assesment.entity.ProductEntity;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {

    @Override
    @NotNull
    List<ProductEntity> findAll();

    @Override
    @NotNull
    Optional<ProductEntity> findById(@NotNull Long id);

    @Query("FROM ProductEntity pe WHERE pe.quantity > 0 AND pe.quantity > 0")
    List<ProductEntity> findAllAvailableProducts();

    @Modifying
    @Transactional
    @Query("UPDATE ProductEntity pe SET pe.quantity = CASE " +
            "WHEN (pe.quantity > 0) THEN pe.quantity - :quantity END WHERE pe.id = :id")
    int updateProductQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);
}
