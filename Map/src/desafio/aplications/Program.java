package desafio.aplications;

import desafio.entities.Candidato;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        try (BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\willi\\Documents\\Java\\in.txt"))){
            Map<Candidato, Integer> mapa = new LinkedHashMap<>();
            String linha = bf.readLine();
            while (linha != null) {
                String[] linhaSplit = linha.split(",");
                Candidato candidato = new Candidato(linhaSplit[0], Integer.parseInt(linhaSplit[1]));
                if (!mapa.containsKey(candidato)) {
                    mapa.put(candidato, Integer.parseInt(linhaSplit[1]));
                }else if (mapa.containsKey(candidato)) {
                    mapa.put(candidato,Integer.parseInt(linhaSplit[1]) + mapa.get(candidato));

                }
                linha = bf.readLine();

            }
            for (Candidato candidato : mapa.keySet()) {
                System.out.print(candidato.getNome() + ": ");
                System.out.println(mapa.get(candidato));
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
