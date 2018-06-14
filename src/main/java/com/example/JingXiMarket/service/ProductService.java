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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service("productService")
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReserveRepository reserveRepository;
    long index = 10;
    long indexe = 10;
    //find
    public List<Product> getProductList(){
        return productRepository.findAll();
    }
    //findbyId
    public Product getProductById(long id){
        return productRepository.findById(id);
    }
    //findbyname
    public Product getProductByName(String name){
        return productRepository.findByProductName(name);
    }
    //add
    public Product createProduct(@RequestParam("productName") String productName, @RequestParam("description") String description, @RequestParam("singlePrice")long singlePrice){

        Product product = new Product();
        product.setId(++index);
        product.setQuantity((long)0);
        product.setDescription(description);
        product.setProductName(productName);
        product.setSinglePrice(singlePrice);
        Long temp = product.getId();
        Reserve reserve = new Reserve();
        reserve.setId(++indexe);
        reserve.setQuantity((long)0);
        reserve.setProductId(temp);
        reserve.setProductName(product.getProductName());
        reserveRepository.save(reserve);

        return productRepository.save(product);
    }
    //create
    public Product addProduct(Product product){
        return productRepository.save(product);
    }    //
    //update
    public Product updateProduct(@PathVariable long id, @RequestBody Product product) throws NotFoundException{
        Product mproduct = productRepository.findById(id);
        if (mproduct == null){
            throw   new NotFoundEx(id,"product");
        }
        product.setId(id);
        return productRepository.save(product);
    }
    //模糊查询
    public  List<Product>getProductByNameAndDesc(String productName, String description){return productRepository.findByNameAndDescriptionLike(productName,description);}

    //buy


}
