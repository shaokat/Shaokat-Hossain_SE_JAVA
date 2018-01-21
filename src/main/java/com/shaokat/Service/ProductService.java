package com.shaokat.Service;


import com.shaokat.model.Product;
import com.shaokat.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    @Transactional
    public void create(Product product){
        repository.save(product);
    }

    public Product select(Long id){
        return repository.findOne(id);

    }
    @Transactional
    public void update(Product updated){

        Product selected = repository.findOne(updated.getId());

        selected.setProductName(updated.getProductName());
        selected.setProductPrice(updated.getProductPrice());
        selected.setProductType(updated.getProductType());
    }
    public void delete(Long id){
        repository.delete(id);
    }
    public List<Product> getAllProducts(){
        return repository.findAll();
    }
}
