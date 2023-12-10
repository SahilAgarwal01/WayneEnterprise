package Shipment;
import java.util.concurrent.*;
public class WayneEnterpriseSimulation {
   public static void main(String[] args) {
       WayneEnterprise wayneEnterprise = new WayneEnterprise();
       ExecutorService executorService = Executors.newFixedThreadPool(12);
       for (int i = 0; i < 7; i++) {
           executorService.execute(new Customer(wayneEnterprise));
       }
       executorService.execute(new Shipping(wayneEnterprise));
       executorService.shutdown();
       try {
           executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       wayneEnterprise.printResults();
   }
}