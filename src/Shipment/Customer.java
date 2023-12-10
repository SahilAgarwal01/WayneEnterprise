package Shipment;
import java.util.Random;
class Customer implements Runnable {
   private WayneEnterprise wayneEnterprise;
   public Customer(WayneEnterprise wayneEnterprise) {
       this.wayneEnterprise = wayneEnterprise;
   }
   @Override
   public void run() {
       Random random = new Random();
       while (wayneEnterprise.getTotalRevenue() < 1000000) {
           int cargoWeight = random.nextInt(41) + 10; // Random cargo between 10 and 50 tons
           String destination = random.nextBoolean() ? "Gotham" : "Atlanta"; // Random destination
           Order order = new Order(cargoWeight, destination);
           wayneEnterprise.placeOrder(order);
           try {
               Thread.sleep(100); // Adjust the wait time as needed
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
}