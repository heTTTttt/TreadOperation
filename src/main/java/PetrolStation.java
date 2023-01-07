import java.time.LocalTime;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.*;

public class PetrolStation {
    public double amount = 500;

    private final ExecutorService executor = Executors.newFixedThreadPool(3);

    public void doRefuel() {
        Callable<String> limit = new Callable<>() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName() + ": " +  "Time: " + LocalTime.now());
                double fuelAmount = 20 + Math.random() * 40;
                System.out.println(Thread.currentThread().getName() + ": " + fuelAmount);
                double remainingFuel = amount - fuelAmount;

                if (remainingFuel < 0) {
                    System.out.println(Thread.currentThread().getName() + ": " +  "Does not have the fuel amount that you need ");
                    System.out.println(amount);
                    return Thread.currentThread().getName();
                }
                amount -= fuelAmount;

                System.out.println(Thread.currentThread().getName() + ": " + "After amount " + amount);
                Thread.sleep((long) (Math.random() * 7000) + 3000);
                return Thread.currentThread().getName();
            }
        };

        try{
            executor.invokeAll(List.of(limit));
        }catch (InterruptedException ex){

        }

        executor.shutdown();
    }
}
