package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamModel {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = list.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(stream.toArray()));
        Stream<String> stream1 = Stream.of("a", "b", "c");
        System.out.println(Arrays.toString(stream1.toArray()));
        Stream<Integer> stream2 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString((stream2.limit(10).toArray())));
    }

}
