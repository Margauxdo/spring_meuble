package org.example.spring_meuble.dao;

import org.example.spring_meuble.entity.CartItem;
import org.example.spring_meuble.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {



}
