package com.fawato.webstore.service;

import com.fawato.webstore.model.Product;
import com.fawato.webstore.repository.ProductRepository;
import com.fawato.webstore.repository.ProductRepositoryCustom;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    public Product getProductById(int id){
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    @Autowired
    ProductRepositoryCustom customRepo;

    @PostConstruct
    public void init() {
        customRepo.printSomething();  // This works because you @Autowired directly
    }
}
