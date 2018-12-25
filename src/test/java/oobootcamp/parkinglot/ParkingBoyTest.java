package oobootcamp.parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;

class ParkingBoyTest {

  @Test
  void should_get_ticket_when_parking_boy_park_car_given_a_available_parking_lot() {
    ParkingBoy boy = new ParkingBoy();
    ParkingLot parkingLot = new ParkingLot(1);
    boy.assignParkingLot(parkingLot);
    Car theCar = new Car();
    Ticket ticket = boy.parkCar(theCar);
    assertNotNull(ticket);
    assertSame(theCar, parkingLot.pickCar(ticket));
  }
}
