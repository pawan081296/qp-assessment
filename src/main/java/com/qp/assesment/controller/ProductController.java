package com.qp.assesment.controller;

import com.qp.assesment.model.ProductModel;
import com.qp.assesment.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@Valid @RequestBody ProductModel productModel) {
        productService.createProduct(productModel);
    }

    @PutMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateProduct(@Valid @RequestBody ProductModel productModel) {
        productService.updateProduct(productModel);
    }

    @GetMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/available")
    public List<ProductModel> getAllAvailableProducts() {
        return productService.getAllAvailableProducts();
    }

    @GetMapping("/{Id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ProductModel findProductById(@PathVariable Long Id) {
        return productService.getProductDetailsById(Id);
    }

    @DeleteMapping("/{Id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteProductById(@PathVariable Long Id) {
        productService.deleteProduct(Id);
    }
}
