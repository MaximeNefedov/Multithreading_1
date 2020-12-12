package Task2;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {

        Callable<Integer> callable1 = new CallableTask("Поток 1", 3);
        Callable<Integer> callable2 = new CallableTask("Поток 2", 3);

        List<Callable<Integer>> callables = Arrays.asList(callable1, callable2);

        ExecutorService service = Executors.newFixedThreadPool(2);

        try {
            List<Future<Integer>> futures = service.invokeAll(callables);
            for (int i = 0; i < futures.size(); i++) {
                System.out.println("Результат: " + futures.get(i).get());
            }

//            int result = service.invokeAny(callables);
//            System.out.println("Результат: " + result);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
    }
}
