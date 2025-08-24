package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        System.out.println("Criando um arquivo");
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo");
        File fileNomeArquivo = new File(sc.nextLine());

        List<String> lista = new ArrayList<>();

        try (BufferedReader bf = new BufferedReader(new FileReader(fileNomeArquivo))) {

            String linha = bf.readLine();
            while (linha != null) {
                String[] remocaoDeVirgula = linha.split(",");
                //String sum = String.valueOf((Integer.valueOf(remocaoDeVirgula[1]) * Integer.valueOf(remocaoDeVirgula[2])));
                Double valor1 = Double.parseDouble(remocaoDeVirgula[1].trim());
                Integer valor2 = Integer.parseInt(remocaoDeVirgula[2].trim());
                Double soma = valor1 * valor2;
                String formatado = remocaoDeVirgula[0] + ", " + String.valueOf(soma);

                lista.add(formatado);
                System.out.println(formatado);
                linha = bf.readLine();

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Boolean criarPasta = new File(fileNomeArquivo.getParent()+"\\out").mkdir();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileNomeArquivo.getParent() + "\\out\\summary.csv", true))) {
            for (String linhaDoFor : lista) {
                bw.write(linhaDoFor);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    }


