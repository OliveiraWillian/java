package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class bw_fw_Criando_Arquivo {
    public static void main(String[] args) {
        String[] vect = new String[] {"Good Morny", "Good Afternoon", "Good Evening", "Good Night"};
        String path = "C:\\Users\\willi\\Documents\\Java\\ok.txt";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))){

            for(String line : vect){
                bw.write(line);
                bw.newLine();

            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
