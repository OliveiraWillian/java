package application;

import dominio.Pessoa;

public class Program {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(1,"Willian","will@gmail.com");
        Pessoa pessoa2 = new Pessoa(2,"Willian2","will2@gmail.com");
        Pessoa pessoa3 = new Pessoa(2,"Willian3","will3@gmail.com");
        System.out.println(pessoa);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
    }

}
