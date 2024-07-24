package org.example.spring_meuble.service;

import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.entity.CartItem;

import java.util.List;

public class CartItemService {
    private CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;

    }
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }
    public CartItem getCartItemById(int id) {
        return cartItemRepository.findById(id).orElse(null);
    }
    public CartItem saveCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public CartItem updateCartItem(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }
    public void deleteCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }
}
