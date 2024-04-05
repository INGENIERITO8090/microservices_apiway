package co.sena.edu.orders_service.controller;


import co.sena.edu.orders_service.model.dtos.OrderRequest;
import co.sena.edu.orders_service.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor

public class OrderController {

 private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest)
    {
        this.orderService.placeOrder(orderRequest);
        return  "Order placed succesfully";
    }



    
}
