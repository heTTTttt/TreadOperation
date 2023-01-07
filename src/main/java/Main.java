import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        PetrolStation petrolStation = new PetrolStation();
        Runnable task1 = petrolStation::doRefuel;

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task1);
        Thread thread3 = new Thread(task1);
        Thread thread4 = new Thread(task1);
        Thread thread5 = new Thread(task1);
        Thread thread6 = new Thread(task1);
        Thread thread7 = new Thread(task1);
        Thread thread8 = new Thread(task1);// створення потоків.

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

    }
}
