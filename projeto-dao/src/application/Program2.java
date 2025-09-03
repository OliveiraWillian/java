package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("Busa departamento");
        DepartmentDao dao = DaoFactory.creteDepartmentDao();
        Department dep = dao.selectById(2);
        System.out.println("Departamento selecionado com sucesso");
        System.out.println("Name: "+dep.getName() + " \nID: "+dep.getId());

        System.out.println("Lista todos os departamento");
//        List<Department> list = dao.findAll();
//        for(Department d : list){
//            d.setName("Willian");
//            System.out.println(d);
//        }

        System.out.println("Lista todos os departamento");
//        dep.setName("Progamacao");
//        dep.setId(null);
//        System.out.println(dep);
//        dao.insert(dep);
//        System.out.println(dep);
        System.out.println("Atualizando Name do departamento");
//        dep = dao.selectById(1);
//        dep.setName("Computers_Desktop");
//        dao.update(dep);
        System.out.println("Deletando departamento");
        dao.deleteById(5);

    }
}
