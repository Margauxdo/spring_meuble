package org.example.spring_meuble.controller;


import jakarta.validation.Valid;
import org.example.spring_meuble.dao.CartItemRepository;
import org.example.spring_meuble.dao.FurnitureRepository;
import org.example.spring_meuble.entity.CartItem;
import org.example.spring_meuble.entity.Furniture;
import org.example.spring_meuble.service.CartItemService;
import org.example.spring_meuble.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartItemController {

    private final CartItemService cartItemService;
    private final FurnitureRepository furnitureRepository;

    public CartItemController(CartItemService cartItemService, FurnitureRepository furnitureRepository) {
        this.cartItemService = cartItemService;
        this.furnitureRepository = furnitureRepository;
    }

    @GetMapping("/listcart")
    public String listCart(Model model) {
        model.addAttribute("cartItems", cartItemService.getAllCartItems());
        System.out.println("test");
        return "cartItem";
    }
    @GetMapping("/addcart/{id}")
    public String addCart(@PathVariable int id, Model model) {

        //recup la fourniture par son identifiant
        Furniture furniture = furnitureRepository.findById(id).orElse(null);
        if (furniture != null) {
            //cree un nouvel element de panier avec mon produit
            CartItem cartItem = new CartItem();
            cartItem.setFurniture(furniture);
            cartItem.setQuantity(1);

            //ajout du produit au panier via service
            cartItemService.addToCart(cartItem);
            //ajout la liste du panier au modele pour les afficher
            model.addAttribute("cartItems", cartItemService.getAllCartItems());
            return "cartItem";
        }




        System.out.println("test");
        return "cartItem";

    }



;

   @GetMapping("/removecart/{id}")
    public String removeCart(@PathVariable("id") int id) {
       System.out.println("test");
        cartItemService.removeFromCart(id);
        return "redirect:/listcart";
   }
   @GetMapping("/clearcart")
    public String clearCart() {
       cartItemService.clearCart();
       return "redirect:/listcart";
   }



}
