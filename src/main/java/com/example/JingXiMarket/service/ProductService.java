package com.example.JingXiMarket.service;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.entity.Reserve;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.reposity.ReserveRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;

@Service("service")
public class ProductService {
    @Resource
    ProductRepository productRepository;
    ReserveRepository reserveRepository;
    //add
    public Product createProduct(Product product){
        Reserve reserve = new Reserve();
        reserve.setQuantity((long)0);
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
    //
    public  Product getProduct(String name, String description){return productRepository.findByNameAndDescriptionLike("%"+name+"%","%"+description+"%");}

}
