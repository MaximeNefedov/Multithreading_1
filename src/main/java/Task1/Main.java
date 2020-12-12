package Task1;

public class Main {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Group 1");

        Thread thread1 = new MyThread(group, "поток 1");
        Thread thread2 = new MyThread(group, "поток 2");
        Thread thread3 = new MyThread(group, "поток 3");
        Thread thread4 = new MyThread(group, "поток 4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        group.interrupt();
    }
}
