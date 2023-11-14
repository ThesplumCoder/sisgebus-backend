package utilities;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import models.*;

/**
 * Factory
 */
public class Factory {
  private List<Passenger> passengers;
  private List<Bus> buses;
  private List<BusStand> busStands;
  private List<Route> routes;

  public Factory() {
    passengers = new ArrayList<>();
    buses = new ArrayList<>();
    busStands = new LinkedList<>();
    routes = new ArrayList<>();
  }

  public void startFactory() {
    passengers.add(new Passenger("Felipe", new Card()));
    passengers.add(new Passenger("Carlos", new Card()));
    passengers.add(new Passenger("Alejandro", new Card()));
    passengers.add(new Passenger("Ricardo", new Card()));
    passengers.add(new Passenger("José", new Card()));
    passengers.add(new Passenger("Sofia", new Card()));
    passengers.add(new Passenger("Ana", new Card()));
    passengers.add(new Passenger("Paula", new Card()));
    passengers.add(new Passenger("Alejandra", new Card()));
    passengers.add(new Passenger("Valeria", new Card()));

    List<String> helps = new ArrayList<>();
    helps.add("Silla de Ruedas");
    buses.add(new Bus("001-AAA", "Alimentador", helps));
    buses.add(new Bus("002-AAA", "Alimentador", helps));
    buses.add(new Bus("003-AAA", "Alimentador", helps));
    buses.add(new Bus("004-AAA", "Pre-troncal", helps));
    buses.add(new Bus("005-AAA", "Pre-troncal", helps));
    buses.add(new Bus("006-AAA", "Pre-troncal", helps));
    buses.add(new Bus("007-AAA", "Troncal", helps));
    buses.add(new Bus("008-AAA", "Troncal", helps));
    buses.add(new Bus("009-AAA", "Troncal", helps));
    buses.add(new Bus("010-AAA", "Troncal", helps));

    busStands.add(new BusStand("Carrera 27 Calle 50"));
    busStands.add(new BusStand("Carrera 27 Calle 45"));
    busStands.add(new BusStand("Carrera 27 Calle 40"));
    busStands.add(new BusStand("Carrera 27 Calle 35"));
    busStands.add(new BusStand("Carrera 27 Calle 30"));
    busStands.add(new BusStand("Carrera 27 Calle 25"));
    busStands.add(new BusStand("Carrera 27 Calle 20"));
    busStands.add(new BusStand("Carrera 27 Calle 15"));
    busStands.add(new BusStand("Carrera 27 Calle 10"));
    busStands.add(new BusStand("Carrera 27 Calle 5"));

    routes.add(new Route("Entrada 27", busStands.subList(0, 3), buses.subList(0, 3)));
    routes.add(new Route("Mitad 27", busStands.subList(3, 6), buses.subList(3, 6)));
    routes.add(new Route("Final 27", busStands.subList(6, 10), buses.subList(6, 10)));
  }

  public List<Passenger> getPassengers() {
    return passengers;
  }

  public List<Bus> getBuses() {
    return buses;
  }

  public List<BusStand> getBusStands() {
    return busStands;
  }

  public List<Route> getRoutes() {
    return routes;
  }
}
