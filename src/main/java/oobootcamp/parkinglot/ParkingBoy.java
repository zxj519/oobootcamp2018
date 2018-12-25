package oobootcamp.parkinglot;

public class ParkingBoy {

  private ParkingLot parkingLot;

  public Ticket parkCar(Car car) {
    return parkingLot.parkCar(car);
  }

  public void assignParkingLot(ParkingLot parkingLot) {
    this.parkingLot = parkingLot;
  }
}
