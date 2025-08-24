import entities.Product;
import entities.service.Calculadora;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {

        Calculadora calculadora = new Calculadora();

        List<Product> list = new ArrayList<>();
       list.add(new Product("Netbook", 100.00));
       list.add(new Product("Samsung", 200.00));
       list.add(new Product("Galaxy", 900.00));
       list.add(new Product("Sony", 400.00));
       list.add(new Product("Samsung", 500.00));
        for (Product p : list) {
            System.out.println(p);
        }
        System.out.println("Maior Preço");
        System.out.println(calculadora.max(list));

        System.out.println("Segundo projeto:");

        List<Integer> inteiros = Arrays.asList(1,2,3,4,5);
        List<Double> flutuantes = Arrays.asList(1.00,2.00,3.00,4.00,5.00);
        List<Object> obj = new ArrayList<>();
        insertList(inteiros,obj);
        insertList(flutuantes,obj);
        System.out.println();
        printlist(obj);
    }
    public static void insertList(List<? extends Number> atual, List<? super Number> destino) {

        for (Number item : atual){
            System.out.print("[");

            System.out.print(item);
            destino.add(item);
            System.out.print("]");

        }
        System.out.println();
    }
    public static void printlist(List<? extends Object> list){
        for (Object item : list){
            System.out.print("[");
            System.out.print(item);
            System.out.print("]");

        }
    }







}
