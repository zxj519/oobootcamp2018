package com.tw.xjzhou.oobootcamp.parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class SmartParkingBoyTest {

  @Test
  void should_parking_to_first_when_park_car_given_the_first_has_more_free_space(){
    ParkingLot parkingLot1 = new ParkingLot(2);
    ParkingLot parkingLot2 = new ParkingLot(1);
    SuperBoy parkingBoy = new SmartParkingBoy();
    parkingBoy.assignParkingLot(parkingLot1);
    parkingBoy.assignParkingLot(parkingLot2);
    Car myCar = new Car();

    Ticket ticket = parkingBoy.parkCar(myCar);

    assertNotNull(ticket);
    assertSame(myCar, parkingLot1.pickCar(ticket));
  }

  @Test
  void should_parking_to_second_when_park_car_given_the_second_has_more_free_space(){
    ParkingLot parkingLot1 = new ParkingLot(1);
    ParkingLot parkingLot2 = new ParkingLot(2);

    SuperBoy parkingBoy = new SmartParkingBoy();
    parkingBoy.assignParkingLot(parkingLot1);
    parkingBoy.assignParkingLot(parkingLot2);

    Car myCar = new Car();

    Ticket ticket = parkingBoy.parkCar(myCar);

    assertNotNull(ticket);
    assertSame(myCar, parkingLot2.pickCar(ticket));
  }

}
