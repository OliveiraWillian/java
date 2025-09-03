package base_Para_Conecção_Postgre.db;

public class DbException extends RuntimeException{
    public DbException(String message) {
        super(message);
    }
}
