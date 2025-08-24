import services.PrintService;

import java.util.Scanner;

public class Generic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService();
        PrintService<String> ps1 = new PrintService();

        System.out.print("How many values? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: " + ps.first());

        System.out.println("String");

        System.out.print("How many values? ");
        int n2 = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String value1 = sc.next();
            ps1.addValue(value1);
        }

        ps1.print();
        System.out.println("First: " + ps1.first());

        sc.close();
    }
}
