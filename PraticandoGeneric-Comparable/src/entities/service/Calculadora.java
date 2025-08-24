package entities.service;

import java.util.List;

public class Calculadora {
    public <T extends Comparable<? super T>>T max(List<T> list){
        T max = list.get(0);
        for(T item : list){
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
    return max;
    }
}
