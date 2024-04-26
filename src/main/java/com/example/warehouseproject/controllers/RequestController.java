package com.example.warehouseproject.controllers;

import com.example.warehouseproject.models.Request;
import com.example.warehouseproject.services.RequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/requests")
public class RequestController {
    private final RequestService requestService;

    @GetMapping
    public List<Request> getAll() {
        return requestService.listAll();
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody Request request) {
        requestService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/{id}")
    public Request getById(@PathVariable long id){
        return requestService.getById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Request request) {
        requestService.update(id, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        requestService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
