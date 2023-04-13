package com.example.pruebaKS.controller;

import com.example.pruebaKS.model.FlowerModel;
import com.example.pruebaKS.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/prueba")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;
    @PostMapping("/save")
    public String saveFlower(@RequestBody List<FlowerModel> flower){
        return this.flowerService.saveFlower(flower);
    }

    @GetMapping("/getFlowerAll")
    public static List<Map<String, Object>> getFlowerModels(){
        return FlowerService.getListFlower();
    }

    @GetMapping("/getFlowers")
    public List<FlowerModel> getListFlowers(){
        return this.flowerService.getListFlowerM20();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteFlower(@PathVariable("id") Integer id){
        return this.flowerService.deleteFlower(id);
    }
    @GetMapping("/getFlowerByName")
    public List<FlowerModel> getFlowerByName(@RequestParam String name){
        return this.flowerService.getFlowerByName(name);
    }



}
