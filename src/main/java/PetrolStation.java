import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PetrolStation implements Callable<String> {
    public double amount = 1000;

//    ExecutorService executor = Executors.newFixedThreadPool(3);



    public void doRefuel() {

        Callable<String> limit = new Callable<>() {
            @Override
            public String call() throws Exception {
                Thread.sleep((long) (Math.random() * 7) + 3);
                return Thread.currentThread().getName();
            }
        };
        double fuelAmount = 20 + Math.random() * 40;
        System.out.println(fuelAmount);
        double remainingFuel = amount - fuelAmount;

        if (remainingFuel < fuelAmount) {
            System.out.println("Does not have the fuel amount that you need ");
            return;
        }
        amount -= fuelAmount;

        System.out.println("After amount " + amount);
    }

    @Override
    public String call() throws Exception {
        Thread.sleep((long) (Math.random() * 7) + 3);
        return Thread.currentThread().getName();
    }
}
