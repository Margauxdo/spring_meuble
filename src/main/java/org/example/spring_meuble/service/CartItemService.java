package org.example.spring_meuble.service;

import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.entity.CartItem;
import org.example.spring_meuble.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final FurnitureService furnitureService;
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).orElse(null);
    }
    public CartItem addToCart(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public CartItem removeFromCart(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public void clearCart(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
//    public List<Furniture> getAllFurnitures() {
//        return furnitureService.getAllFurnitures();
//    }
}
