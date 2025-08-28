package application;

import entities.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv",900.00));
        products.add(new Product("Notebook",1200.00));
        products.add(new Product("Tablet",450.00));
        Comparator<Product> comp =  (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

        products.sort((p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
