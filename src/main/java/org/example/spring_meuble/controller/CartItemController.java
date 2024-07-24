package org.example.spring_meuble.controller;


import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.dao.FurnitureRepository;
import org.example.spring_meuble.entity.CartItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartItemController {

    private final CartItemRepository cartItemRepository;
    private final FurnitureRepository furnitureRepository;

    public CartItemController(CartItemRepository cartItemRepository, FurnitureRepository furnitureRepository) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureRepository = furnitureRepository;
    }

    @GetMapping("/listcart")
    public String listCart(Model model) {
        List<CartItem> cartItems = cartItemRepository.findAll();
        model.addAttribute("cartItems", cartItems);
        return "cartItem";
    }
    @GetMapping("/addcart")
    public String addCart(Model model) {
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("cartItems", cartItemRepository.findAll());

        model.addAttribute("furnitures", furnitureRepository.findAll());

        return "cartItem";
    }
    @PostMapping("/addcart")
    public String addCart(@ModelAttribute("cartItem") CartItem cartItem ){
        cartItemRepository.save(cartItem);


//        model.addAttribute(furnitureRepository);
        return "redirect:/cartItem";
    }
   @GetMapping("/deletecart/{id}")
    public String deleteCart(@PathVariable long id) {
        cartItemRepository.deleteById(id);
        return "redirect:/cartItem";
   }



}
