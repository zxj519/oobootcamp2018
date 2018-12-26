package oobootcamp.parkinglot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
import oobootcamp.parkinglot.exception.InvalidTicketException;
import oobootcamp.parkinglot.exception.NoEnoughSpaceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParkingBoyTest {

  private ParkingBoy boy;

  @BeforeEach
  void setUp() {
    boy = new ParkingBoy();
  }

  @Test
  void should_get_ticket_when_parking_boy_park_car_given_a_available_parking_lot() {
    ParkingLot parkingLot = new ParkingLot(1);
    boy.assignParkingLot(parkingLot);
    Car theCar = new Car();
    Ticket ticket = boy.parkCar(theCar);
    assertNotNull(ticket);
    assertSame(theCar, parkingLot.pickCar(ticket));
  }

  @Test
  void should_get_ticket_when_parking_boy_park_car_given_two_parking_lots_and_one_is_full() {
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
    setupFullParkingLots(5);
    assertThrows(NoEnoughSpaceException.class, () -> boy.parkCar(new Car()));
  }

  private void setupFullParkingLots(int numberOfFullParkingLots) {
    IntStream.range(0, numberOfFullParkingLots).forEach(number -> {
      ParkingLot fullParkingLot = new ParkingLot(1);
      boy.assignParkingLot(fullParkingLot);
      boy.parkCar(new Car());
    });
  }


  @Test
  void should_pick_the_car_when_parking_boy_pick_a_parked_car() {
    ParkingLot fullParkingLot = new ParkingLot(1);
    boy.assignParkingLot(fullParkingLot);
    Car theCar = new Car();
    Ticket ticket = boy.parkCar(theCar);
    assertSame(theCar, boy.pickCar(ticket));
  }

  @Test
  void should_pick_the_right_car_when_parking_boy_pick_parked_cars_given_more_than_one_car_parked() {
    boy.assignParkingLot(new ParkingLot(1));
    boy.assignParkingLot(new ParkingLot(1));
    Car carA = new Car();
    Car carB = new Car();
    Ticket ticket1 = boy.parkCar(carA);
    Ticket ticket2 = boy.parkCar(carB);

    assertSame(carA, boy.pickCar(ticket1));
    assertSame(carB, boy.pickCar(ticket2));
  }

  @Test
  void should_get_invalid_ticket_exception_when_parking_boy_pick_a_car_given_invalid_ticket() {
    ParkingLot fullParkingLot = new ParkingLot(1);
    boy.assignParkingLot(fullParkingLot);
    Car theCar = new Car();
    boy.parkCar(theCar);
    assertThrows(InvalidTicketException.class, () -> boy.pickCar(new Ticket()));
  }
}
