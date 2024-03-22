package co.sena.edu.productsservice.services;


import co.sena.edu.productsservice.model.dtos.ProductRequest;
import co.sena.edu.productsservice.model.entities.Product;
import co.sena.edu.productsservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
private  final ProductRepository productRepository;



public  void addProduct (ProductRequest productRequest){
 var product = Product.builder()
         .sku(productRequest.getSku()).name(productRequest.getName()).description(productRequest.getDescription()).price(productRequest
                 .getPrice()).status(productRequest.getStatus()).build();


 productRepository.save(product);
 log.info("Product added : {}",product);
}


}
