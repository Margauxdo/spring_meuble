package org.example.spring_meuble.controller;

import org.example.spring_meuble.entity.Furniture;
import org.example.spring_meuble.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FurnitureController {

    private final FurnitureService furnitureService;

    public FurnitureController(FurnitureService furnitureService) {
        this.furnitureService = furnitureService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("furnitures", furnitureService.getAllFurnitures());
        return "list";
    }
    @GetMapping("/addfurniture")
    public String addFurniture(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "addFurniture";
    }
    @PostMapping("/addfurniture")
    public String addFurniture(@ModelAttribute ("furniture")Furniture furniture) {
        furnitureService.createFurniture(furniture);
        return "redirect:/";

    }
}
