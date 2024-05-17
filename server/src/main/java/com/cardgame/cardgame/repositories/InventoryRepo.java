package com.cardgame.cardgame.repositories;
import com.cardgame.cardgame.models.Inventory;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InventoryRepo extends JpaRepository<Inventory, Integer> {
    
    @SuppressWarnings("null")
    List<Inventory> findAll();
}
