package model.util;

public class CodigoMemoria {
    public static void codigo(Object obj){
        System.out.println(obj.getClass().getSimpleName() + "@" + Integer.toHexString(System.identityHashCode(obj)));
    }
}
