package com.qp.assesment.service.Impl;

import com.qp.assesment.entity.ProductEntity;
import com.qp.assesment.exceptions.ResourceNotFoundException;
import com.qp.assesment.mapper.ProductMapper;
import com.qp.assesment.model.ProductModel;
import com.qp.assesment.repository.ProductRepo;
import com.qp.assesment.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ProductMapper productMapper;

    @Override
    public void createProduct(ProductModel productModel) {
        productRepo.save(productMapper.toProductEntity(productModel));
    }

    @Override
    public void updateProduct(ProductModel productModel) {

        ProductEntity productEntity = productRepo.findById(productModel.getId()).orElseThrow(() ->
                new ResourceNotFoundException("Product ","Id",productModel.getId()));
        productMapper.toProductEntity(productModel, productEntity);
        productRepo.save(productMapper.toProductEntity(productModel, productEntity));

    }

    @Override
    public ProductModel getProductDetailsById(Long id) {
        Optional<ProductEntity> productEntity = productRepo.findById(id);
        return productMapper.toProduct(productEntity.orElseThrow(() -> new ResourceNotFoundException("Product ", "Id", id)));
    }

    @Override
    public List<ProductModel> getAllProducts() {
        return productMapper.toProductList(productRepo.findAll());
    }

    @Override
    public List<ProductModel> getAllAvailableProducts() {
        return productMapper.toProductList(productRepo.findAllAvailableProducts());
    }

    @Override
    public void deleteProduct(Long Id) {
        ProductEntity productEntity = productRepo.findById(Id).orElseThrow(() ->
                new ResourceNotFoundException("Product ", "Id", Id));
        productRepo.delete(productEntity);
    }
}
