import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<Integer> myInts = Arrays.asList(1, 2, 3, 4);
        List<Double> myDoubles = Arrays.asList(3.14, 6.28);
        List<Object> myObjs = new ArrayList<Object>();
        copy(myInts, myObjs);
        copy(myDoubles, myObjs);
        System.out.println();
        printlist(myObjs);

    }

    public static void copy(List<? extends Number> atual, List<? super Number> destino) {
        for (Number obj : atual) {
            destino.add(obj);
            System.out.print("[");
            System.out.print(obj);
            System.out.print("]");

        }
        System.out.println();
    }

    public static void printlist(List<? extends Object> list) {
        for (Object obj : list) {
            System.out.print("[");
            System.out.print(obj);
            System.out.print("]");
        }

    }

}