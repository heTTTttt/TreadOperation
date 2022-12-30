import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
     ConcurrentList<String> concurrentList = new ThreadSafeList<>();
        Random random = new Random();

        Runnable task1 = () -> {
            for (int i = 0; i < 10; i++) {
                concurrentList.remove(0);

                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 10; i++) {
                    concurrentList.add("String " + i);
                try {
                    Thread.sleep((long) (Math.random() * 10));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };


        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task2);
        Thread thread4 = new Thread(task2);
        Thread thread5 = new Thread(task2);
        Thread thread6 = new Thread(task2);
        Thread thread7 = new Thread(task2);// створення 2х потоків.
        Thread thread8 = new Thread(task1);// створення 2х потоків.

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();

     concurrentList.add("abc");
        System.out.println(concurrentList);

        System.out.println(concurrentList.size());
    }
}
