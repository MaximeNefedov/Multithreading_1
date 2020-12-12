package Task2;

import java.util.concurrent.Callable;

public class CallableTask extends Thread implements Callable<Integer> {

    private int value;
    private int valueOfEnd;

    public CallableTask(String name, int valueOfEnd) {
        super(name);
        value = 1;
        this.valueOfEnd = valueOfEnd;
    }

    @Override
    public Integer call() {
        while (value <= valueOfEnd) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Пока " + getName() + " спал, " + "его попытались остановить");
            }
            System.out.printf(getName() + " отправил сообщение %d раз\n", value);
            if (value == valueOfEnd) {
                break;
            } else {
                value++;
            }
        }
        return value;
    }
}
