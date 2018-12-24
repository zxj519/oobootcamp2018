package oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;
import oobootcamp.parkinglot.exception.NoAvailableParkingSlotException;

public class ParkingLot {

  private int numberOfSlot;
  private Map<Ticket, Car> parkedCars = new HashMap<>();

  public ParkingLot(int numberOfSlot) {
    this.numberOfSlot = numberOfSlot;
  }

  public Ticket parkCar(Car car) {
    if(numberOfSlot > parkedCars.size()) {
      Ticket ticket = new Ticket();
      parkedCars.put(ticket, car);
      return ticket;
    }
    throw new NoAvailableParkingSlotException();
  }

  public Car pickCar(Ticket ticket) {
    return parkedCars.remove(ticket);
  }
}
