package model.dao;

import db.DB;


import model.impl.DepartmentDaoJDBC;
import model.impl.SellerDaoJDBC;


public class DaoFactory{
    public static SellerDao creteSellerDao(){
        return new SellerDaoJDBC(DB.getConnection());
    }

    public static DepartmentDao creteDepartmentDao(){
        return new DepartmentDaoJDBC(DB.getConnection());
    }
}
