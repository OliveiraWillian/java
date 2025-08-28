package model.services;


import entities.Product;

import java.util.List;
import java.util.function.Predicate;

public class ProductService {
public double findchar(List<Product> p , Predicate<Product> predicate){
    double sum = 0;
for (Product list : p){

    if (predicate.test(list)){
        sum += list.getPrice();
    }
}

    return sum;
}
}
