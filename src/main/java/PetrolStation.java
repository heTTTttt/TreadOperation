
public class PetrolStation {
    double amount;

    void doRefuel(double fuelAmount){
        double remainingFuel = amount - fuelAmount;
        if (amount < fuelAmount){
            System.out.println("Does not have fuel amount what you need ");
        }
    }
}
