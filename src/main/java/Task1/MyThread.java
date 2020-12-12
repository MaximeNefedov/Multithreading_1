package Task1;

public class MyThread extends Thread {
    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("Пока " + getName() + " спал, " + "его попытались остановить");
                return;
            }
            System.out.println("Я " + getName() + ". Всем привет!");
        }
    }
}
