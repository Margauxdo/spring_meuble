package org.example.spring_meuble.service;

import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;

    }
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
    public CartItem getCartItemById(long id) {
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
}
