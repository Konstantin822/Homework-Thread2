package homework;

import java.util.concurrent.Semaphore;

public class PetrolStation {
    private volatile int amount;
    private final Semaphore semaphore;

    public PetrolStation(int amount, int semaphore) {
        this.amount = amount;
        this.semaphore = new Semaphore(semaphore);
    }

    public void doRefuel(int requestedAmount) throws InterruptedException {
        semaphore.acquire();
        System.out.println("Request: " + requestedAmount);
        Thread.sleep((int) (Math.random() * 10000 + 1000));
        synchronized (this) {
            if (amount >= requestedAmount) {
                amount -= requestedAmount;
                System.out.println("Refueled with " + requestedAmount + " of fuel. Fuel remain " + amount);
            } else {
                System.out.println("Insufficient fuel. Fuel amount: " + amount);
            }
        }
        semaphore.release();
    }
}
