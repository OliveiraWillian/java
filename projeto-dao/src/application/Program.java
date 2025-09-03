package application;


import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;
import model.impl.SellerDaoJDBC;
import model.util.CodigoMemoria;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Program {
    public static void main(String[] args) {
        SellerDao dao = DaoFactory.creteSellerDao(); // SellerDaoJDBC

        System.out.println("Teste 1: Seller findByID");
        Seller sel  = dao.findById(3);
        System.out.println(sel);
        Department department =  new Department(2,null);

        System.out.println("Teste 2: seller findByDepartment");
        List<Seller> list = dao.findByDepartment(department);
        for (Seller seller : list) {
            System.out.println(seller);
            CodigoMemoria.codigo(seller.getDepartment());


        }

        System.out.println("===Seller insert");
        Seller insertSeller = new Seller(null,"Willian","Willi@gmail.com",new Date(),4000.00,department);
        //dao.insert(insertSeller);
        System.out.println("Seller inserted low : " + insertSeller.getId());

        System.out.println("===Seller Update");
        sel = dao.findById(4);
        sel.setName("Willian Oliveira");
        dao.update(sel);
        System.out.println("Seller updated : " + sel.getName());

        System.out.println("===Seller Delete");
        //dao.deleteById(24);
        System.out.println("Deleted ");




    }
}
