package oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();

  Ticket parkCar(Car car) {
    return parkingLots.stream().filter(ParkingLot::hasSlot)
        .findAny().get().parkCar(car);
  }

  void assignParkingLot(ParkingLot parkingLot) {
    this.parkingLots.add(parkingLot);
  }
}
