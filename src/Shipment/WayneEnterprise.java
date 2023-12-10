package Shipment;
import java.util.concurrent.*;
class WayneEnterprise {
   private BlockingQueue<Order> ordersQueue;
   private BlockingQueue<Order> canceledOrdersQueue;
   private BlockingQueue<Ship> shipsQueue;
   private int totalRevenue;
   private int totalOrdersDelivered;
   private int totalOrdersCanceled;
   public WayneEnterprise() {
       ordersQueue = new LinkedBlockingQueue<>();
       canceledOrdersQueue = new LinkedBlockingQueue<>();
       shipsQueue = new LinkedBlockingQueue<>();
       totalRevenue = 0;
       totalOrdersDelivered = 0;
       totalOrdersCanceled = 0;
       for (int i = 0; i < 5; i++) {
           Ship ship = new Ship();
           shipsQueue.offer(ship);
       }
   }
   public void placeOrder(Order order) {
       ordersQueue.offer(order);
   }
   public void cancelOrder(Order order) {
       canceledOrdersQueue.offer(order);
   }
   public void processOrders() {
       while (totalRevenue < 1000000) {
           try {
               Order order = ordersQueue.poll(500, TimeUnit.MILLISECONDS);
               if (order != null) {
                   Ship ship = shipsQueue.poll();
                   if (ship != null) {
                       if (ship.getCurrentPort().equals(order.getDestination()) && ship.getCargo() + order.getCargoWeight() <= 300) {
                           ship.loadCargo(order.getCargoWeight());
                           ship.travel();
                           shipsQueue.offer(ship);
                           totalRevenue += 1000;
                           totalOrdersDelivered++;
                       } else {
                           cancelOrder(order);
                       }
                   } else {
                       cancelOrder(order);
                   }
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
   }
   public void printResults() {
       System.out.println("Total Orders Delivered: " + totalOrdersDelivered);
       System.out.println("Total Orders Canceled: " + totalOrdersCanceled);
   }
   public int getTotalRevenue() {
       return totalRevenue;
   }
}