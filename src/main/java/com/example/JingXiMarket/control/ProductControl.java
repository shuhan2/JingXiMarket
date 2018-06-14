package com.example.JingXiMarket.control;

import com.example.JingXiMarket.entity.Product;
import com.example.JingXiMarket.service.ProductService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
    @GetMapping(value = "{id}")
    Product findProductByProductName(@PathVariable long id){
        return productService.getProductById(id);
    }
//    @GetMapping(value = "{name}")
//    Product findProductByProductName(@PathVariable String name){
//        return productService.getProductByName(name);
//    }
   // get
    @GetMapping(value ="productName/{productName}/description/{description}")
    @ResponseStatus(HttpStatus.OK)
    List<Product>  getProduct(@PathVariable String productName,@PathVariable String description){
       return   productService.getProductByNameAndDesc(productName,description);

    }

    //update
    @PostMapping("{id}")
    Product putProduct(@PathVariable long id,@PathVariable Product product) throws NotFoundException {

        return productService.updateProduct(id,product);
    }
    //add(@RequestBody Reserve reserve)
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    Product addProduct(@RequestParam(value = "productName", required =false) String productName, @RequestParam(value = "description", required =false) String description, @RequestParam(value ="singlePrice",required =false)
            Long singlePrice ){

        return  productService.createProduct(productName,description,singlePrice);
    }

//    @PostMapping()
//    @ResponseStatus(HttpStatus.CREATED)
//    Product addProduct(@RequestBody Product product ){
//
//        return  productService.addProduct(product);
//    }
}
