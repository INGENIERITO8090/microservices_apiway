package co.sena.edu.productsservice.controllers;


import co.sena.edu.productsservice.model.dtos.ProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/api/product")
public class ProductController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  void addProduct(@RequestBody ProductRequest productRequest
    ){
 this.productService.addProduct(productRequest);

    }


}
