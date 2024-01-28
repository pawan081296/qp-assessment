package com.qp.assesment.service;

import com.qp.assesment.model.ProductModel;

import java.util.List;

public interface ProductService {

    void createProduct(ProductModel productModel);

    void updateProduct(ProductModel productModel);

    ProductModel getProductDetailsById(Long id);

    List<ProductModel> getAllProducts();
    List<ProductModel> getAllAvailableProducts();

    void deleteProduct(Long Id);

}
