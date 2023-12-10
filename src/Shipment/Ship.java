package Shipment;
class Ship {
   private int cargo;
   private String currentPort;
   public Ship() {
       this.cargo = 0;
       this.currentPort = "Gotham";
   }
   public int getCargo() {
       return cargo;
   }
   public String getCurrentPort() {
       return currentPort;
   }
   public void loadCargo(int weight) {
       cargo += weight;
   }
   public void unloadCargo() {
       cargo = 0;
   }
   public void travel() {
       if (currentPort.equals("Gotham")) {
           currentPort = "Atlanta";
       } else {
           currentPort = "Gotham";
       }
   }
}



