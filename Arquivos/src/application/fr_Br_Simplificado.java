package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class fr_Br_Simplificado {
    public static void main(String[] args) {
        String caminho = "C:\\Users\\willi\\Documents\\Java\\home.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
            String texto = br.readLine();

            while (texto != null){
                System.out.println(texto);
                texto = br.readLine();
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
