package com.tw.xjzhou.oobootcamp.parkinglot;

import java.util.Comparator;

public class SmartParkingBoy extends SuperBoy {

  @Override
  public Ticket parkCar(Car car) {
    ParkingLot parkingLot = parkingLots.stream()
        .max(Comparator.comparing(ParkingLot::availableSlotNumber)).get();
    return parkingLot.parkCar(car);
  }
}
