package oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;
import oobootcamp.parkinglot.exception.NoEnoughSpaceException;

class ParkingBoy {

  private List<ParkingLot> parkingLots = new ArrayList<>();

  Ticket parkCar(Car car) {
    return parkingLots.stream().filter(ParkingLot::hasSlot)
        .findAny().orElseThrow(NoEnoughSpaceException::new).parkCar(car);
  }

  void assignParkingLot(ParkingLot parkingLot) {
    this.parkingLots.add(parkingLot);
  }
}
