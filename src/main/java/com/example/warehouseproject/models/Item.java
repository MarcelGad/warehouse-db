package com.example.warehouseproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String itemGroup;
    private String unitOfMeasurement;
    private double quantity;
    private double priceWithoutVAT;
    private String status;
    private String storageLocation;
    private String contactPerson;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(quantity, item.quantity) == 0 && Double.compare(priceWithoutVAT, item.priceWithoutVAT) == 0 && Objects.equals(itemGroup, item.itemGroup) && Objects.equals(unitOfMeasurement, item.unitOfMeasurement) && Objects.equals(status, item.status) && Objects.equals(storageLocation, item.storageLocation) && Objects.equals(contactPerson, item.contactPerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemGroup, unitOfMeasurement, quantity, priceWithoutVAT, status, storageLocation, contactPerson);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemGroup='" + itemGroup + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", quantity=" + quantity +
                ", priceWithoutVAT=" + priceWithoutVAT +
                ", status='" + status + '\'' +
                ", storageLocation='" + storageLocation + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                '}';
    }
}