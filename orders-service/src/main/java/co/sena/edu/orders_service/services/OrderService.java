package co.sena.edu.orders_service.services;
import co.sena.edu.orders_service.model.dtos.BaseResponse;
import co.sena.edu.orders_service.model.dtos.OrderItemRequest;
import co.sena.edu.orders_service.model.dtos.OrderRequest;
import co.sena.edu.orders_service.model.entities.Order;
import co.sena.edu.orders_service.model.entities.OrderItems;
import co.sena.edu.orders_service.repositories.OrderRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.UUID;


@Service
@RequiredArgsConstructor

public class OrderService {

    private  final OrderRepository orderRepository;
    private final WebClient.Builder webClientBuilder;
    public  void placeOrder (OrderRequest  orderRequest){
       BaseResponse result = this.webClientBuilder.build()
                    .post()
                    .uri("http://localhost:8083/api/inventory/in-stock")
                    .bodyValue(orderRequest.getOrderItems())
                    .retrieve()
                    .bodyToMono(BaseResponse.class)
                    .block();
    if  ( result != null && !result.hasErrors()){
    Order order  = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());
    order.setOrderItems(orderRequest.getOrderItems().stream().map(orderItemRequest -> mapOrderItemRequestToOrdenItem(orderItemRequest,order)).toList());
    this.orderRepository.save(order);}
    else {
    throw  new IllegalArgumentException("Some  of the products are not in stock");
    }
    }


    private OrderItems mapOrderItemRequestToOrdenItem(OrderItemRequest orderItemRequest, Order order) {
        return OrderItems.builder()
                .id(orderItemRequest.getId())
                .sku(orderItemRequest.getSku())
                .price(orderItemRequest.getPrice())
                .quantity(orderItemRequest.getQuantity())
                .order(order)
                .build();
    }
}
