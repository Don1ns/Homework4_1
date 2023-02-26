import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)).stream();
        findMinMax(stream, Comparator.naturalOrder(), ((min, max) -> System.out.println("Min= " + min + " Max= " + max)));

        Stream<Integer> stream1 = new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99)).stream();
        System.out.println("Количество четных чисел = " + findEven(stream1));

    }

    public static <T> void findMinMax(Stream<? extends T> stream, Comparator<? super T> order, BiConsumer<? super T, ? super T> minMaxConsumer) {
        List<T> list = stream.collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            list.sort(order);
            minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
        }
    }

    public static int findEven(Stream<Integer> stream) {
        List<Integer> list = stream.toList();
        return (int) list.stream().filter(i -> i % 2 == 0)
                .peek(System.out::println)
                .count();
    }
}