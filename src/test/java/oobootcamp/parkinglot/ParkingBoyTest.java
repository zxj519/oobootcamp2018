package oobootcamp.parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
import oobootcamp.parkinglot.exception.NoEnoughSpaceException;
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

  @Test
  void should_get_ticket_when_parking_boy_park_car_given_two_parking_lots_and_one_is_full() {
    ParkingBoy boy = new ParkingBoy();
    ParkingLot fullParkingLot = new ParkingLot(1);
    ParkingLot parkingLot = new ParkingLot(1);
    boy.assignParkingLot(fullParkingLot);
    boy.assignParkingLot(parkingLot);
    Car myCar = new Car();
    boy.parkCar(new Car());
    Ticket ticket = boy.parkCar(myCar);
    assertNotNull(ticket);
  }

  @Test
  void should_get_no_enough_space_exception_when_parking_boy_park_car_given_all_parking_lots_are_full() {
    ParkingBoy boy = new ParkingBoy();
    IntStream.range(0, 2).forEach(number -> {
      ParkingLot fullParkingLot = new ParkingLot(1);
      boy.assignParkingLot(fullParkingLot);
      boy.parkCar(new Car());
    });
    assertThrows(NoEnoughSpaceException.class, () -> boy.parkCar(new Car()));
  }
}
