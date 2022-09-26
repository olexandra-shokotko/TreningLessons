package HW11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Peter", "Susanna", "David", "Arthur", "Maria", "Jack", "Steven", "Monica");

        // task1
        System.out.println("Task1-------");
        String result1 = IntStream.
                            range(0, names.size()).
                            filter(i -> i % 2 != 0).
                            mapToObj(i -> i + ". " + names.get(i)).
                            collect(Collectors.joining(", "));
        System.out.println(result1);

        // task2
        System.out.println("\nTask2-------");
        List<String> result2 = names.stream().
                                        map(String::toUpperCase).
                                        sorted(Comparator.reverseOrder()).
                                        collect(Collectors.toList());
        System.out.println(result2);

        // task3
        System.out.println("\nTask3-------");
        String[] strArr = new String[]{"1, 2, 0", "4, 5"};
        StringJoiner result3 = Arrays.stream(strArr).
                                        flatMapToInt(p -> Arrays.stream(p.split(", ")).mapToInt(Integer::parseInt)).
                                        sorted().
                                        collect(() -> new StringJoiner(", "),
                                                    (j, p) -> j.add(String.valueOf(p)),
                                                    StringJoiner::merge);
        System.out.println(result3);

        // task4
        Stream<Long> generator = generator(25214903917L, 11L, (long) Math.pow(2L, 48L));
        generator.forEach(System.out::println);

        //task5
        System.out.println("\nTask5-------");
        Stream<Integer> stream1 = Stream.of(1, 30, 28, 29, 44, 12, 67);
        Stream<Integer> stream2 = Stream.of(111, 300, 128, 100, 555);

        System.out.println(zip(stream1, stream2).collect(Collectors.toList()));
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> firstIterator = first.iterator();
        Iterator<T> secondIterator = second.iterator();

        Iterator<T> resultIterator = new Iterator<T>() {
            boolean isNextFirst = true;

            @Override
            public boolean hasNext() {
                if (isNextFirst) {
                    return firstIterator.hasNext();
                } else {
                    return secondIterator.hasNext();
                }
            }

            @Override
            public T next() {
                if (isNextFirst) {
                    isNextFirst = false;
                    return firstIterator.next();
                }
                isNextFirst = true;
                return secondIterator.next();
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(resultIterator, 0);
        return StreamSupport.stream(spliterator, false);
    }

    //x[0] = seed
    //x[n + 1] = 1 (a x[n] + c) % m
    //a = 25214903917
    //c = 11
    //m = 2^48
    public static Stream<Long> generator(Long a, Long c, Long m) {
        Long seed = 0L;
        Stream<Long> iterate = Stream.iterate(seed, x -> (1 * (a * x + c) % m));
        return iterate;
    }
}
