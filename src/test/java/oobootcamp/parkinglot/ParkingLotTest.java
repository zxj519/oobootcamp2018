package oobootcamp.parkinglot;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ParkingLotTest {

  @Test
  void shouldParkMyCarSuccessfullyGivenAvailableParkingLot() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car car = new Car();
    assertNotNull(parkingLot.parkCar(car));
  }

  @Test
  void shouldParkMyCarFailedGivenNotAvailableParkingLot() {
    ParkingLot parkingLot = new ParkingLot(1);
    parkingLot.parkCar(new Car());
    assertThrows(NoAvailableParkingSlotException.class, () -> parkingLot.parkCar(new Car()));
  }

  @Test
  void shouldPickMyCarSuccessfullyGivenMyCarParkedAndIHaveValidTicket() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car myCar = new Car();
    Ticket myTicket = parkingLot.parkCar(myCar);
    assertEquals(myCar, parkingLot.pickCar(myTicket));
  }

  @Test
  void shouldFailedToPickMyCarGivenMyCarParkedWhenNoValidTicket() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car myCar = new Car();
    parkingLot.parkCar(myCar);
    assertAll("Should failed", () -> {
      assertNull(parkingLot.pickCar(null));
      assertNull(parkingLot.pickCar(new Ticket()));
    });
  }

  @Test
  void shouldParkCarSuccessfullyGivenACarLeftTheFullParkingLotBeforeIParkMyCar() {
    ParkingLot parkingLot = new ParkingLot(1);
    Car aCar = new Car();
    Ticket aTicket = parkingLot.parkCar(aCar);
    assertAll("Release parking slot", () -> {
      assertThrows(NoAvailableParkingSlotException.class, () -> parkingLot.parkCar(new Car()));
      parkingLot.pickCar(aTicket);
      assertNotNull(parkingLot.parkCar(new Car()));
    });
  }

}
