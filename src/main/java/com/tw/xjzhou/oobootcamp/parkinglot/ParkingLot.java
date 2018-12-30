package com.tw.xjzhou.oobootcamp.parkinglot;

import com.tw.xjzhou.oobootcamp.parkinglot.exception.NoEnoughSpaceException;
import java.util.HashMap;
import java.util.Map;

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

  public  int availableSlotNumber() {
    return numberOfSlot - parkedCars.size();
  }
}
