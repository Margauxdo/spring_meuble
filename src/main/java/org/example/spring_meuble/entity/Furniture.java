package org.example.spring_meuble.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    private long id;
    @NotNull(message = "cet élément doit être rempli")
    @NotBlank
    @Column(name = "name_furniture")
    private String name;
    @Column(name = "description_furniture")
    private String description;
    @NotNull(message = "cet élément doit être rempli")
    @Column(name = "price_furniture")
    private int price;
    @Column(name = "stock_furniture")
    private int stock;
}
