package HW12.Task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Task2 {
    public static final int N = 15;
    public static int i = 1;
    volatile AtomicInteger currentElement = new AtomicInteger();
    public volatile List<String> result;
    public volatile List<Integer> numbers = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        Task2 task2 = new Task2();
        task2.start();
        System.out.println(task2.getResult());
    }

    public List<String> getResult() {
        return result;
    }

    public void start() throws InterruptedException {
        IntStream.range(i, N + 1).forEach(el -> numbers.add(el));
        result = Collections.synchronizedList(new ArrayList<>());

        Thread D = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    while (currentElement.get() < numbers.size()) {
                        if (!fizz() && !buzz() && !fizzbuzz()) {
                            result.add(String.valueOf(numbers.get(currentElement.get())));
                            currentElement.getAndIncrement();
                        }
                        if (currentElement.get() >= numbers.size()) {
                            interrupt();
                        }
                    }
                }
            }
        };
        Thread C = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    while (currentElement.get() < numbers.size()) {
                        if (fizzbuzz()) {
                            result.add("fizzbuzz");
                            currentElement.getAndIncrement();

                        }
                        if (currentElement.get() >= numbers.size()) {
                            interrupt();
                        }
                    }
                }
            }
        };
        Thread B = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    while (currentElement.get() < numbers.size()) {
                        if (buzz()) {
                            result.add("buzz");
                            currentElement.getAndIncrement();
                        }
                        if (currentElement.get() >= numbers.size()) {
                            interrupt();
                        }
                    }
                }
            }
        };
        Thread A = new Thread() {
            @Override
            public void run() {
                while (!isInterrupted()) {
                    while (currentElement.get() < numbers.size()) {
                        if (fizz()) {
                            result.add("fizz");
                            currentElement.getAndIncrement();
                        }
                        if (currentElement.get() >= numbers.size()) {
                            interrupt();
                        }
                    }
                }
            }
        };

        A.start();
        B.start();
        C.start();
        D.start();
        A.join();
        B.join();
        C.join();
        D.join();
    }

    private boolean fizz() {
        return numbers.get(currentElement.get()) % 3 == 0;
    }

    private boolean buzz() {
        return numbers.get(currentElement.get()) % 5 == 0;
    }

    private boolean fizzbuzz() {
        return numbers.get(currentElement.get()) % 3 == 0 && numbers.get(currentElement.get()) % 5 == 0;
    }
}
