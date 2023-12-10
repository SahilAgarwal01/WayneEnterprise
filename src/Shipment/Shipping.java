package Shipment;
class Shipping implements Runnable {
   private WayneEnterprise wayneEnterprise;
   public Shipping(WayneEnterprise wayneEnterprise) {
       this.wayneEnterprise = wayneEnterprise;
   }
   @Override
   public void run() {
       wayneEnterprise.processOrders();
   }
}