import java.util.concurrent.atomic.AtomicInteger;

public class PetrolStation {
    public volatile double amount = 1000;
    private final Object objectLock = new Object();
    private AtomicInteger counter = new AtomicInteger();

    synchronized void doRefuel() {

        //synchronized (objectLock){
            if (counter.getAndIncrement() > 2){
                System.out.println("To much objects");
                return;
            }
        //}
        System.out.println("Before amount " + amount+ " count of obj " + counter);

        double fuelAmount = 20 + Math.random() * 40;
        System.out.println(fuelAmount);
        double remainingFuel = amount - fuelAmount;
        //synchronized (objectLock) {

            if (remainingFuel < fuelAmount) {
                System.out.println("Does not have the fuel amount that you need ");
                return;
            }
            try {
                Thread.sleep((long) (Math.random() * 7) + 3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            amount -= fuelAmount;
        //}
        System.out.println("After amount " + amount);
        counter.getAndDecrement();
    }
}
