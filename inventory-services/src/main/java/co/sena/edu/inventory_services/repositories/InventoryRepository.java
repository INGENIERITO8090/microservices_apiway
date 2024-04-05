package co.sena.edu.inventory_services.repositories;

import co.sena.edu.inventory_services.model.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;


public interface InventoryRepository extends JpaRepository <Inventory,Long> {

    Optional<Inventory> findBySku (String sku);


    List<Inventory> findBySkuIn(List<String> sku);

}
