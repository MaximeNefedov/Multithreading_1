package Task3;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {

        int[] array = createAndFillArray(200_000_000);

        System.out.println("=====================================");
        long l1 = System.currentTimeMillis();
        int simpleResult = sumSimple(array);
        System.out.println("Result is: " + simpleResult);
        long l2 = System.currentTimeMillis();
        long l21d = l2 - l1;
        System.out.println("Однопоточное решение: " + l21d);

        System.out.println("=====================================");

        long l3 = System.currentTimeMillis();
        Integer result = new ArraySumTask(array, 0, array.length).compute();
        System.out.println("Result is: " + result);
        long l4 = System.currentTimeMillis();
        long l43d = l4 - l3;
        System.out.println("Многопоточное решение: " + l43d);
        System.out.println("=====================================");
        compareMethodsTime(l21d, l43d);

    }

    public static void compareMethodsTime(long timeBySimple, long timeByForkJoinPool) {
        long diff = timeBySimple - timeByForkJoinPool;
        if (diff < 0) {
            System.out.printf("ForkJoinPool работает медленнее на %d мс.\n", Math.abs(diff));
        } else if (diff > 0) {
            System.out.printf("ForkJoinPool работает быстрее на %d мс.\n", Math.abs(diff));
        } else {
            System.out.println("Оба решения работают с одинаковой скоростью");
        }
    }

    public static int sumSimple(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public static int[] createAndFillArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1_000_000);
        }
        return array;
    }
}
