package Shipment;
class Order {
   private int cargoWeight;
   private String destination;
   public Order(int cargoWeight, String destination) {
       this.cargoWeight = cargoWeight;
       this.destination = destination;
   }
   public int getCargoWeight() {
       return cargoWeight;
   }
   public String getDestination() {
       return destination;
   }
}