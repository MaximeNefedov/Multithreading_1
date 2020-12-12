package Task3;

import java.util.concurrent.RecursiveTask;

public class ArraySumTask extends RecursiveTask<Integer> {

    private int[] array;
    private int start;
    private int end;

    public ArraySumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;

        switch (diff) {
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    public int forkTasksAndGetResult() {
        final int middle = (end - start) / 2 + start;
        ArraySumTask task = new ArraySumTask(array, start, middle);
        ArraySumTask task2 = new ArraySumTask(array, middle, end);
        invokeAll(task, task2);
        return task.join() + task2.join();
    }
}
