package application;


import entities.Product;
import model.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Tv",900.00));
        products.add(new Product("Notebook",1200.00));
        products.add(new Product("Tablet",350.50));

        ProductService ps = new ProductService();

       Double sum =  ps.findchar(products, p -> p.getName().charAt(0) == 'T');
        System.out.println(sum);
    }

}
