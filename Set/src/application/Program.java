package application;

import entities.LogEntry;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        String path = "C:\\Users\\willi\\Documents\\Java\\in.txt";
        Set<LogEntry> set = new HashSet<>();

        try(BufferedReader bf = new BufferedReader(new FileReader(path))){
            String line = bf.readLine();
            String name ;
            Date date ;
            while (line != null) {
                String[] split = line.split(" ");
                name = split[0];
                date = Date.from(Instant.parse(split[1]));
                set.add(new LogEntry(name,date));
                line = bf.readLine();
            }
            System.out.println("Total Log Entries: " + set.size());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
