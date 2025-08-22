package application;

import java.io.File;
import java.util.Scanner;

public class manipulando_pasta {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o nome da pasta:");
        String diretorio = sc.nextLine();

        File file = new File(diretorio);

        System.out.println("PASTAS");
        File[] pastas = file.listFiles(File::isDirectory);
        for (File pasta : pastas) {
            System.out.println(pasta.getName());

        }

        System.out.println("ARQUIVOS");
        File[] arquivos = file.listFiles(File::isFile);
        for (File arquivo : arquivos){
            System.out.println(arquivo.getName());

        }
        System.out.println("Criando Pasta");

        Boolean statusPasta = new File(diretorio + "\\JaveiroWillian").mkdir();
        System.out.println("Pasta Criada " + statusPasta);

    }
}