package com.example.warehouseproject.repositories;


import com.example.warehouseproject.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {}
