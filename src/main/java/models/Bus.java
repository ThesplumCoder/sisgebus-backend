package models;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Bus modela los autobuses que soportan la operación de transporte de personas
 * en el STM.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class Bus extends Entity {

  private String licensePlate;
  private String type;

  /**
   * Es la última parada de autobus en la que estuvo el autobus. Con esto
   * podemos aproximar la ubicación real del mismo.
   */
  private BusStand location;
  private List<String> helps;

  /**
   * Crea un bus que tiene identificador, placa de tránsito, y tipo; pero no
   * cuenta inicialmente con ayudas para gente con discapacidad.
   *
   * @param licensePlate Placa de tránsito.
   * @param type         Tipo del bus.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(String licensePlate, String type) throws IllegalArgumentException, NullPointerException {
    this(licensePlate, null, type, null);
  }

  /**
   * Crea un bus que tiene identificador, placa de tránsito, tipo y ayudas para
   * gente con discapacidad.
   *
   * @param licensePlate Placa de tránsito.
   * @param location     Última parada visitada por el autobus.
   * @param type         Tipo del bus.
   * @param helps        Soportes o ayudas para gente con discapacidad.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(String licensePlate, BusStand location, String type, List<String> helps)
      throws IllegalArgumentException, NullPointerException {
    super();
    setLicensePlate(licensePlate);
    setType(type);

    if (location == null) {
      this.location = new BusStand("Parqueadero");
    } else {
      setLocation(location);
    }

    if (helps == null) {
      this.helps = new ArrayList<>();
    } else {
      setHelps(helps);
    }
  }

  /**
   * Retorna la placa de tránsito que tiene el bus.
   *
   * @return Cadena con la placa de tránsito.
   */
  public String getLicensePlate() {
    return licensePlate;
  }

  /**
   * Retorna el tipo de bus.
   *
   * @return Cadena que describe el tipo de bus.
   */
  public String getType() {
    return type;
  }

  /**
   * Retorna la última parada de autobus en la que estuvo.
   *
   * @return Parada de autobus de última vez.
   */
  public BusStand getLocation() {
    return location;
  }

  /**
   * Retorna todas las ayudas que posee el bus.
   *
   * @return Lista de cadenas, cada una es una ayuda que posee el bus.
   */
  public List<String> getHelps() {
    return helps;
  }

  /**
   * Cambia la placa de tránsito.
   *
   * @param licensePlate Nueva placa de tránsito.
   * @throws IllegalArgumentException Si la placa de tránsito está vacía o solo
   *                                  contiene espacios en blanco.
   * @throws NullPointerException     Si la placa de tránsito apunta a un valor
   *                                  nulo.
   */
  public void setLicensePlate(String licensePlate) throws IllegalArgumentException, NullPointerException {
    if (licensePlate == null) {
      throw new NullPointerException("The supplied license plate is null.");
    }
    if (licensePlate.isBlank()) {
      throw new IllegalArgumentException("The license plate can't be empty.");
    }

    this.licensePlate = licensePlate;
  }

  /**
   * Cambia el tipo del que es el bus.
   *
   * Los posibles valores son: Alimentador, Pre-troncal y Troncal.
   *
   * @param type Nuevo tipo del bus.
   * @throws IllegalArgumentException Si el tipo ingresado no corresponde con
   *                                  alguno de los valores posibles.
   */
  public void setType(String type) throws IllegalArgumentException {
    List<String> types = new ArrayList<>(3);
    types.add("Alimentador");
    types.add("Pre-troncal");
    types.add("Troncal");

    if (types.contains(type)) {
      this.type = type;
    } else {
      throw new IllegalArgumentException("The supplied type isn't valid.");
    }
  }

  /**
   * Cambia la última parada visitada del autobus.
   *
   * @param busStand Última parada de autobus en la que estuvo el autobus.
   * @throws NullPointerException Si el objeto de parada de autobus pasado es un
   *                              valor nulo.
   */
  public void setLocation(BusStand busStand) throws NullPointerException {
    if (busStand == null) {
      throw new NullPointerException("The bus stand is null.");
    }

    location = busStand;
  }

  /**
   * Cambia la lista de ayudas que tiene el autobus.
   *
   * @param helps Una lista con las nuevas ayudas que posee el bus, cada una
   *              como un texto.
   * @throws NullPointerException Si la lista apunta a un valor nulo.
   */
  public void setHelps(List<String> helps) throws NullPointerException {
    if (helps == null) {
      throw new NullPointerException("The supplied adjustments is null.");
    }

    this.helps = new ArrayList<String>(helps);
  }

  /**
   * Agrega una ayuda para gente discapacitada.
   *
   * @param help Nueva ayuda que se agregó.
   * @throws IllegalArgumentException Si la ayuda a agregar es una cadena vacía
   *                                  o de solo espacios.
   * @throws NullPointerException     Si la ayuda a agregar es un valor nulo.
   */
  public void addHelp(String help) throws IllegalArgumentException, NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    if (help.isBlank()) {
      throw new IllegalArgumentException("The help can't be empty.");
    }

    helps.add(help);
  }

  /**
   * Elimina una de las ayudas que posea el autobus.
   *
   * @param help Ayuda que se desea eliminar.
   * @throws IllegalArgumentException Si la ayuda a eliminar es una cadena vacía
   *                                  o de solo espacios.
   * @throws NoSuchElementException   Si la ayuda a eliminar no existe en la lista
   *                                  actual de ayudas.
   * @throws NullPointerException     Si la ayuda a eliminar es un valor nulo.
   */
  public void rmHelp(String help)
      throws IllegalArgumentException, NoSuchElementException, NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    if (help.isBlank()) {
      throw new IllegalArgumentException("The help can't be empty.");
    }
    if (!(helps.remove(help))) {
      throw new NoSuchElementException("The help doesn't exist.");
    }
  }
}
