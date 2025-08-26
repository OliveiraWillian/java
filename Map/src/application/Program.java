package application;

import entities.Produtos;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        Produtos produto1 = new Produtos("Sansugue", 100.00);
        Produtos produto2 = new Produtos("Galaxy", 300.00);
        Produtos produto3 = new Produtos("Motorola", 100.00);


        Map<Produtos, Integer> mapa = new HashMap<>();
        mapa.put(produto1, 900);
        mapa.put(produto2, 4500);
        mapa.put(produto3, 2000);

        Produtos produto4 = new Produtos("Sansugue", 100.00);
        System.out.println(mapa.containsKey(produto4));
        for (Produtos produto : mapa.keySet()) {
            System.out.println(produto + " - Estoque : " + mapa.get(produto));
        }
    }

}
