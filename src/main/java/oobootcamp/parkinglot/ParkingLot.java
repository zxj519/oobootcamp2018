package oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;
import oobootcamp.parkinglot.exception.NoEnoughSpaceException;

class ParkingLot {

  private int numberOfSlot;
  private Map<Ticket, Car> parkedCars = new HashMap<>();

  ParkingLot(int numberOfSlot) {
    this.numberOfSlot = numberOfSlot;
  }

  Ticket parkCar(Car car) {
    if(this.hasSlot()) {
      Ticket ticket = new Ticket();
      parkedCars.put(ticket, car);
      return ticket;
    }
    throw new NoEnoughSpaceException();
  }

  Car pickCar(Ticket ticket) {
    return parkedCars.remove(ticket);
  }

  boolean hasSlot() {
    return numberOfSlot > parkedCars.size();
  }

  boolean hasSpecificCar(Ticket ticket) {
    return parkedCars.containsKey(ticket);
  }
}
