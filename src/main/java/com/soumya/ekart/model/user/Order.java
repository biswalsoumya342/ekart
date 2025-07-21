package com.soumya.ekart.model.user;

import com.soumya.ekart.model.seller.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Order {

    @Id
    private String id;

    @OneToMany()
    private List<Product> products = new ArrayList<>();
}
