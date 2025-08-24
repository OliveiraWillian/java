package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<W> {

    private List<W> list = new ArrayList<>();

    public void addValue(W value) {
        list.add(value);
    }

    public W first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        for (int i = 1; i < list.size(); i++) {
            System.out.print(", " + list.get(i));
        }
        System.out.println("]");
    }
}
