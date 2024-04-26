package com.example.warehouseproject.services;

import com.example.warehouseproject.exceptions.RequestNotFoundException;
import com.example.warehouseproject.models.Request;
import com.example.warehouseproject.repositories.RequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class RequestService {
    private final RequestRepository requestRepository;

    public List<Request> listAll() {
        return requestRepository.findAll();
    }

    public Request getById(long id) {
        return requestRepository.findById(id)
                .orElseThrow(RequestNotFoundException::new);
    }

    public void save(Request request) {
        requestRepository.save(request);
    }

    public void update(long id, Request request) {
        Request existingRequest = requestRepository
                .findById(id).orElseThrow(() -> new NoSuchElementException("Request not found."));
        existingRequest.setItem(request.getItem());
        existingRequest.setEmployeeName(request.getEmployeeName());
    }

    public void delete(long id) {
        requestRepository.deleteById(id);
    }
}