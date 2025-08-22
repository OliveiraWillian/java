package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class fr_br {
    public static void main(String[] args) {
        String path = "C:\\Users\\willi\\Documents\\Java\\home.txt";
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

            if (br != null){
                br.close();
            }
            if (fr != null){
                fr.close();
            }

            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
