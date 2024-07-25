package org.example.spring_meuble.service;

import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.entity.CartItem;
import org.example.spring_meuble.entity.Furniture;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
        //reduire le stock du produit qui a été retiré du panier
        Furniture furniture = cartItem.getFurniture();
        if (furniture.getStock()>0){
            //reduit le stock
            furniture.setStock(furniture.getStock()-1);
            //enregistre le nouveau stock
            furnitureService.saveFurniture(furniture);
            return cartItemRepository.save(cartItem);
        }else{
            throw new RuntimeException("Stock insuffisant" +furniture.getName());
        }


    }
    public void removeFromCart(int id) {

        CartItem cartItem = getCartItemById(id);
        //augmenter le stock dans la page produit
        //recup article et verif il soit pas null
        if (cartItem != null) {
            //recup objet furniture
            Furniture furniture = cartItem.getFurniture();
            furniture.setStock(furniture.getStock()+1);
            furnitureService.saveFurniture(furniture);
            cartItemRepository.delete(cartItem);

        }
    }
    public void clearCart() {

        cartItemRepository.deleteAll();
    }

}
