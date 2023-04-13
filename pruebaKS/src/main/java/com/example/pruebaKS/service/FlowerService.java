package com.example.pruebaKS.service;

import com.example.pruebaKS.model.FlowerModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class FlowerService {

    private static List<FlowerModel> listFlower = new ArrayList<>();

    public String saveFlower(List<FlowerModel> flower){
        listFlower = flower;
        return "Lista de flores guardada!";
    }

    public static List<Map<String, Object>> getListFlower(){
        List<Map<String, Object>> list = new ArrayList<>();
        for (FlowerModel flower : listFlower) {
            Map<String, Object> param = new HashMap<>();
            param.put("name", flower.getName() + "-kometsales");
            param.put("price", flower.getPrice());
            list.add(param);
        }
        Collections.sort(list, (a, b) -> ((String) b.get("name")).compareTo((String) a.get("name")));
        return list;

    }

    public List<FlowerModel> getListFlowerM20(){
        List<FlowerModel> list = listFlower.stream().filter(f -> f.getPrice()>20).collect(Collectors.toList());
        return list;
    }

    public String deleteFlower(Integer id){

        Optional<FlowerModel> delete = listFlower.stream()
                .filter(f -> f.getId().equals(id))
                .findFirst();

        if(delete.isEmpty()){
            return "Registro no encontrado.";
        }else{

            listFlower.remove(delete.get());
         return "Registro eliminado.";
        }
    }

    public List<FlowerModel> getFlowerByName(String name){
        List<FlowerModel> list = listFlower.stream().filter(f -> f.getName().equals(name)).collect(Collectors.toList());
        return list;
    }

}
