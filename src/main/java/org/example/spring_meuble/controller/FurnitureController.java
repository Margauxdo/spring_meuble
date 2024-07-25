package org.example.spring_meuble.controller;

import jakarta.validation.Valid;
import org.example.spring_meuble.entity.Furniture;
import org.example.spring_meuble.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String addFurniture( @Valid @ModelAttribute ("furniture")Furniture furniture, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("furnitures", furnitureService.getAllFurnitures());
            return "addFurniture";
        }else{
            if (furniture.getId() != 0){
                furnitureService.updateFurniture(furniture.getId(),furniture);
            }else{
//                System.out.println(furniture.getId());
//                System.out.println(furniture.getName());
//                System.out.println(furniture.getPrice());
//                System.out.println(furniture.getDescription());
                furnitureService.saveFurniture(furniture);
            }
        }
        return "redirect:/";


    }
    @GetMapping("/deleteFurniture/{id}")
    public String deleteFurniture(@PathVariable("id") int id) {
        furnitureService.deleteFurniture(id);
        return "redirect:/";
    }
    @GetMapping("/updatefurniture/{id}")
    public String updateFurniture(@PathVariable("id") int id, Model model) {
        Furniture furniture = furnitureService.getFurnitureById(id);
        model.addAttribute("furniture", furniture);

        return "addFurniture";
    }
//    @PostMapping("/updatefurniture/{id}")
//    public String updateFurniture(@ModelAttribute("furniture")  Furniture furniture) {
//        System.out.println("controller");
//        furnitureService.updateFurniture(furniture);
//        return "list";
//    }


}
