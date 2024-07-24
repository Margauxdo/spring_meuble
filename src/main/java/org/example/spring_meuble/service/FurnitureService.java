package org.example.spring_meuble.service;

import org.example.spring_meuble.dao.FurnitureRepository;
import org.example.spring_meuble.entity.Furniture;

import java.util.List;

public class FurnitureService {

    private final FurnitureRepository furnitureRepository;

    public FurnitureService(FurnitureRepository furnitureRepository) {
        this.furnitureRepository = furnitureRepository;
    }
   public List<Furniture> getAllFurnitures() {
        return furnitureRepository.findAll();
   }
   public Furniture getFurnitureById(int id) {
        return furnitureRepository.findById(id).orElse(null);
   }
   public Furniture createFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);
   }
   public Furniture updateFurniture(Furniture furniture) {
        return furnitureRepository.save(furniture);

   }
   public void deleteFurniture(int id) {
        furnitureRepository.deleteById(id);
   }

}
