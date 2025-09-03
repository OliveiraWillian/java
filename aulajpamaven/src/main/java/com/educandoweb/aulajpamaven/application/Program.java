package com.educandoweb.aulajpamaven.application;

import com.educandoweb.aulajpamaven.dominio.Pessoa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Program.class);
        app.setWebApplicationType(WebApplicationType.NONE); // Isso desativa o Tomcat
        app.run(args);

        Pessoa pessoa = new Pessoa(1,"Willian","will@gmail.com");
        Pessoa pessoa2 = new Pessoa(2,"Willian2","will2@gmail.com");
        Pessoa pessoa3 = new Pessoa(2,"Willian3","will3@gmail.com");
        System.out.println(pessoa);
        System.out.println(pessoa2);
        System.out.println(pessoa3);
    }

}
