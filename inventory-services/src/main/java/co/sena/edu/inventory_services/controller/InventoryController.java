package co.sena.edu.inventory_services.controller;


import co.sena.edu.inventory_services.model.dtos.BaseResponse;
import co.sena.edu.inventory_services.model.dtos.OrderItemRequest;
import co.sena.edu.inventory_services.services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/ api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private  final InventoryService inventoryServices;

    @GetMapping("/{sku}")
    @ResponseStatus(HttpStatus.OK)
    public  boolean isInStock (@PathVariable("sku") String sku){
        return inventoryServices.isInStock(sku);
    }

    @PostMapping("/in-stock")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponse areInStock(@RequestBody List<OrderItemRequest> orderItems){
         return  inventoryServices.areInStock(orderItems);
    }
}
