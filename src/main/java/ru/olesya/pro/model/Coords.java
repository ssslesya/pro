package ru.olesya.pro.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coords {
    private Double x1;
    private Double y1;

    public Double distancePoint(Double x2, Double y2){
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
    public List<Order> sort(Map<Order, Double> map){
        LinkedHashMap<Order, Double> linkedHashMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new
                ));
        List<Order> sort = new ArrayList<>(linkedHashMap.keySet());
        List<Order> res = new ArrayList<>();
        if(sort.size()>0){
            res.add(sort.get(0));
            if(sort.size()>1){
                res.add(sort.get(1));
                if(sort.size()>2){
                    res.add(sort.get(2));
                }
            }
        }
        return res;
    }
}
