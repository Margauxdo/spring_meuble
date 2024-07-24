package org.example.spring_meuble.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "furniture")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Furniture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "furniture_id")
    private int id;
    @Column(name = "name_furniture")
    private String name;
    @Column(name = "description_furniture")
    private String description;
    @Column(name = "price_furniture")
    private int price;
    @Column(name = "stock_furniture")
    private int stock;
}
