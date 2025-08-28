package application;


import entities.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ExercicioResolvidoNaAula {

    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\willi\\Documents\\Java\\in.txt"))){
            String linha = br.readLine();
            List<Product>  list = new ArrayList<>();

            while (linha != null) {
                String[] split = linha.split(",");
                list.add(new Product(split[0],Double.parseDouble(split[1])));

                linha = br.readLine();
            }
            System.out.println(list);

            double avg = list.stream().map(x-> x.getPrice()).reduce(0.0 , (a,b) -> a + b / list.size());
            System.out.printf("%.2f",avg);
            System.out.println();
            Comparator<String> comp = (a,b) -> a.toUpperCase().compareTo(b.toUpperCase());
            List<String> strings = list.stream().filter(x-> x.getPrice() < avg).map(x-> x.getName()).sorted(comp.reversed()).collect(Collectors.toList());
            strings.forEach(System.out::println);



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
