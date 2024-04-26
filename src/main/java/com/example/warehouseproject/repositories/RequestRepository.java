package com.example.warehouseproject.repositories;

import com.example.warehouseproject.models.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {}