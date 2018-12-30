package com.tw.xjzhou.oobootcamp.parkinglot;

import java.util.ArrayList;
import java.util.List;

public abstract class SuperBoy {

  protected List<ParkingLot> parkingLots = new ArrayList<>();

  public abstract Ticket parkCar(Car myCar);

  public void assignParkingLot(ParkingLot parkingLot) {
    this.parkingLots.add(parkingLot);
  }
}
