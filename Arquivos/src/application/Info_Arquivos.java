package application;

import java.io.File;
import java.util.Scanner;

public class Info_Arquivos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o nome do arquivo: ");
        File file = new File(sc.nextLine());
        System.out.println("Nome do Arquivo"+file.getName());
        System.out.println("Nome do caminho sem o arquivo"+file.getParent());
        System.out.println("Caminho COmplet do arquivo"+file.getPath());

    }
}
