import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Set<Integer> alunos = new HashSet();
       alunos.addAll(calculoAlunos("A"));
       alunos.addAll(calculoAlunos("B"));
       alunos.addAll(calculoAlunos("C"));
        System.out.println("Alunos: " + alunos.size());
        input.close();

    }
public static Set<Integer> calculoAlunos(String parametro){
    Scanner input = new Scanner(System.in);
    System.out.println("How many students for course " +parametro + "? ");
    int n = input.nextInt();
    Set<Integer> alunos_Funcao = new HashSet();
    for (int i = 1; i <= n; i++){

        alunos_Funcao.add(input.nextInt());

    }

    return alunos_Funcao;

}
}
