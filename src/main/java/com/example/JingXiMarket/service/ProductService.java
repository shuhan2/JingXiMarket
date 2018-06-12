package com.example.JingXiMarket.service;

import com.example.JingXiMarket.exception.NotFoundEx;
import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service("service")
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReserveRepository reserveRepository;
    long index = 10;
    //find
    public List<Product> getProductList(){
        return productRepository.findAll();
    }
    //findbyname
    public Product getProductByName(String name){
        return productRepository.findByProductName(name);
    }
    //add
    public Product createProduct(@PathVariable String name, String description,long singlePrice){
        Reserve reserve = new Reserve();
        reserve.setQuantity((long)0);
        Product product = new Product();
        product.setId(++index);
        product.setQuantity((long)0);
        product.setDescription(description);
        product.setName(name);
        reserve.setProductId(product.getId());
        reserve.setProductName(product.getName());
        reserveRepository.save(reserve);

        return productRepository.save(product);
    }
    //update
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) throws NotFoundException{
        Product mproduct = productRepository.findById(id).get();
        if (mproduct == null){
            throw   new NotFoundEx(id,"product");
        }
        product.setId(id);
        return productRepository.save(product);
    }
    //模糊查询
    public  List<Product> getProductByNameAndDesc(String name, String description){return productRepository.findByNameAndDescriptionLike(name,description);}

}
