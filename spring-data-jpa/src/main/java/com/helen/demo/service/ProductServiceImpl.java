package com.helen.demo.service;

import com.helen.demo.entity.Product;
import com.helen.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) this.productRepository.findAll();
    }

    @Override
    public Product getProductByID(Integer productID) {
        Optional<Product> productOptional = this.productRepository.findById(productID);
        if (productOptional.isPresent()){
            return productOptional.get();
        }
        return null; // or we can throw error.
    }

    @Override
    public Product updateOrInsert(Product product) {
        // in some case, we will implement some business in this layer
        Product saveProduct = null;
        if (product.getId() == null){
            //insert
            saveProduct = this.productRepository.save(product);
        } else {
            //update
            Optional<Product> productOptional = this.productRepository.findById(product.getId());
            if (productOptional.isPresent()){
//                Product oldProduct = productOptional.get();
//                oldProduct.setName(product.getName());
//                oldProduct.setDescription(product.getDescription());
//                oldProduct.setPrice(product.getPrice());
//                this.productRepository.save(oldProduct);

                // the other way
                saveProduct = this.productRepository.save(product);
            } else {
                // throw error because id does not exist.
            }
        }
        return saveProduct;
    }

    @Override
    public void delete(Integer productID) {
        Optional<Product> productOptional = this.productRepository.findById(productID);
        if (productOptional.isPresent()){
            this.productRepository.deleteById(productID);
        } else {
            // throw error.
        }
    }
}
