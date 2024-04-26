package com.example.warehouseproject.services;

import com.example.warehouseproject.exceptions.ItemNotFoundException;
import com.example.warehouseproject.models.Item;
import com.example.warehouseproject.repositories.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> listAll() {
        return itemRepository.findAll();
    }

    public Item getById(long id) {
        return itemRepository.findById(id)
                .orElseThrow(ItemNotFoundException::new);
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public void update(long id, Item item) {
        Item existingItem = itemRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Item not found."));
        existingItem.setItemGroup(item.getItemGroup());
        existingItem.setStatus(item.getStatus());
        existingItem.setQuantity(item.getQuantity());
        existingItem.setUnitOfMeasurement(item.getUnitOfMeasurement());
        existingItem.setPriceWithoutVAT(item.getPriceWithoutVAT());
        existingItem.setStorageLocation(item.getStorageLocation());
        existingItem.setContactPerson(item.getContactPerson());
    }

    public void delete(long id) {
        itemRepository.deleteById(id);
    }
}
