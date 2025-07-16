package com.soumya.ekart.model.seller;

import com.soumya.ekart.model.user.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String gst;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "seller",orphanRemoval = true)
    private List<Product> product = new ArrayList<>();
}
