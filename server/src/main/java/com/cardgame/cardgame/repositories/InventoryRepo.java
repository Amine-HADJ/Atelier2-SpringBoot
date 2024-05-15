package com.cardgame.cardgame.repositories;
import com.cardgame.cardgame.models.Inventory;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends CrudRepository<Inventory, Integer> {
    // Add custom query methods here if needed
    List<Inventory> findAll();

}
