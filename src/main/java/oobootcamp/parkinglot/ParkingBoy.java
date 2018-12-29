package oobootcamp.parkinglot;

import oobootcamp.parkinglot.exception.InvalidTicketException;
import oobootcamp.parkinglot.exception.NoEnoughSpaceException;

class ParkingBoy extends SuperBoy{

  public Ticket parkCar(Car car) {
    return parkingLots.stream().filter(ParkingLot::hasSlot)
        .findAny().orElseThrow(NoEnoughSpaceException::new).parkCar(car);
  }

  Car pickCar(Ticket ticket) {
    return parkingLots.stream()
        .filter(parkingLot -> parkingLot.hasSpecificCar(ticket))
        .findAny().orElseThrow(InvalidTicketException::new).pickCar(ticket);
  }
}
