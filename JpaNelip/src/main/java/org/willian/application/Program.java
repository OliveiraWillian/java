package org.willian.application;



import org.willian.dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Program {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa(null,"Willian","will@gmail.com");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager(); //libera a conexcão

        em.getTransaction().begin(); // começa a transição
        em.persist(pessoa); //insert
        em.getTransaction().commit();//confirma a trasação

        em.getTransaction().begin();
        Pessoa p = em.find(Pessoa.class, 1); // select banco de dados
        em.remove(p); // remove o usuario
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

}
