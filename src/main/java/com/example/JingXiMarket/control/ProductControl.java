package com.example.JingXiMarket.control;

import com.example.JingXiMarket.NotFoundEx;
import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.reposity.ProductRepository;
import com.example.JingXiMarket.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductControl {
    @Autowired
    ProductService productService;

    //get
    @GetMapping("/findProduct")
    Product getProduct(String name, String description){return productService.getProduct(name,description);}
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Product saveProduct(@RequestBody Product product){

        return productService.createProduct(product);
    }
    //update
    @PostMapping("{id}")
    Product putProduct(@PathVariable long id,@RequestBody Product product) throws NotFoundException {

        return productService.updateProduct(id,product);
    }
    //add(@RequestBody Reserve reserve)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Product addProduct(@RequestBody Product product){

        return  productService.createProduct(product);
    }
}
