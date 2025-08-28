package application;

import entities.Funcionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class ExercicioFuncionario {
    public static void main(String[] args) {

        List<Funcionario> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\willi\\Documents\\Java\\in.txt"))) {

            String linha = br.readLine();
            while (linha != null) {
                String[] linhaSplit = linha.split(",");
                list.add(new Funcionario(linhaSplit[0],Double.parseDouble(linhaSplit[2]),linhaSplit[1]));
                linha = br.readLine();
            }
            System.out.println(list);

            System.out.println("Enter Salary: 2000.00");
            double salary = 2000.00;

            System.out.println("Email of people whose salary is more than 2000.00");

            Stream<String> stream = list.stream().filter(x-> x.getSalario() > salary).map(x-> x.getEmail()).sorted();
            stream.forEach(System.out::println);
            Scanner sc = new Scanner(System.in);
            System.out.print("Sum of salary of people whose name starts with: ");
            char ch = sc.next().toUpperCase().charAt(0);

            double sum = list.stream().filter(x->x.getNome().toUpperCase().charAt(0) == ch).map(x-> x.getSalario()).reduce(0.0,(a,y)->a + y);
            System.out.printf("%.2f",sum);
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
