package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductControl {
    @Autowired
    ProductService productService;
//
    @GetMapping
    List<Product> findProduct(){
        return productService.getProductList();
    }
    @GetMapping(value = "{name}")
    Product findProductByProductName(@PathVariable String name){
        return productService.getProductByName(name);
    }
   // get
    @GetMapping("name/{name}/description/{description}")
    List<Product>  getProduct(@PathVariable String name,@PathVariable String description){
       return   productService.getProductByNameAndDesc(name,description);

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
