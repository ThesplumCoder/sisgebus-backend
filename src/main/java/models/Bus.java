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

  private BusClassification classification;
  /**
   * Es el identificador de la última parada de autobus en la que estuvo. Con esto
   * podemos aproximar la ubicación real del mismo.
   */
  private Integer locationId;
  private Integer routeId;
  private String licensePlate;
  private List<Help> helps;

  /**
   * Crea un bus que tiene identificador, placa de tránsito, clasificación,
   * localización y ayudas para gente con discapacidad.
   *
   * @param id             Identificador numérico autogenerado por la BD.
   * @param classification Clasificación del bus.
   * @param locationId     Última parada visitada por el autobus.
   * @param routeId        Identificador numérico autogenerado por la BD para la
   *                       ruta.
   * @param licensePlate   Placa de tránsito.
   * @param helps          Soportes o ayudas para gente con discapacidad.
   * @throws IllegalArgumentException Si ocurrió un error en la asignación de
   *                                  atributos.
   * @throws NullPointerException     Si ocurrió un error en la asignación de
   *                                  atributos o en el constructor de Entity.
   */
  public Bus(Integer id, BusClassification classification, Integer locationId, Integer routeId, String licensePlate,
      List<Help> helps) throws IllegalArgumentException, NullPointerException {
    super(id);

    setClassification(classification);
    setLocationId(locationId);
    setRouteId(routeId);
    setLicensePlate(licensePlate);
    setHelps(helps);
  }

  /**
   * Retorna la clasificación del bus.
   *
   * @return Constante que representa la clasificación.
   */
  public BusClassification getClassification() {
    return classification;
  }

  /**
   * Retorna el identificador de la última parada de autobus en la que estuvo.
   *
   * @return Identificador de parada de autobus de última vez.
   */
  public Integer getLocationId() {
    return locationId;
  }

  /**
   * Retorna el identificador de la ruta que está haciendo el bus.
   *
   * @return Identificador de la ruta.
   */
  public Integer getRouteId() {
    return routeId;
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
   * Retorna todas las ayudas que posee el bus.
   *
   * @return Lista de ayudas, cada una es una ayuda que posee el bus.
   */
  public List<Help> getHelps() {
    return helps;
  }

  /**
   * Cambia la clasificación del bus.
   *
   * @param classification Nuevo clasificación del bus.
   * @throws NullPointerException Si la clasificación del bus es un valor nulo.
   */
  public void setClassification(BusClassification classification) throws NullPointerException {
    if (classification == null) {
      throw new NullPointerException("The classification can't be null.");
    }
    this.classification = classification;
  }

  /**
   * Cambia el identificador de la última parada visitada del autobus.
   *
   * @param locationId Identificador de la última parada de autobus en la que
   *                   estuvo el autobus.
   * @throws NullPointerException Si el identificador de parada de autobus pasado
   *                              es un valor nulo.
   */
  public void setLocationId(Integer locationId) throws NullPointerException {
    if (locationId == null) {
      throw new NullPointerException("The location id is null.");
    }
    if (locationId.intValue() < 0) {
      throw new IllegalArgumentException("The identifier for location can't be negative.");
    }
    this.locationId = locationId;
  }

  /**
   * Cambia el identificador de la ruta del autobus.
   *
   * @param routeId Identificador de la ruta de autobus.
   * @throws NullPointerException Si el identificador la ruta pasado es un valor
   *                              nulo.
   */
  public void setRouteId(Integer routeId) throws NullPointerException {
    if (routeId == null) {
      throw new NullPointerException("The route id is null.");
    }
    if (routeId.intValue() < 0) {
      throw new IllegalArgumentException("The route id can't be negative.");
    }
    this.routeId = routeId;
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
   * Cambia la lista de ayudas que tiene el autobus.
   *
   * Si se pasa un valor nulo se entenderá que el bus por el momento no posee
   * ninguna ayuda, y se inicializa una lista vacía.
   *
   * @param helps Una lista con las nuevas ayudas que posee el bus, cada una
   *              como un texto.
   */
  public void setHelps(List<Help> helps) {
    if (helps == null) {
      this.helps = new ArrayList<>();
    } else {
      this.helps = new ArrayList<>(helps);
    }
  }

  /**
   * Agrega una ayuda para gente discapacitada.
   *
   * @param help Nueva ayuda que se agregó.
   * @throws NullPointerException Si la ayuda a agregar es un valor nulo.
   */
  public void addHelp(Help help) throws NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    helps.add(help);
  }

  /**
   * Elimina una de las ayudas que posea el autobus.
   *
   * @param help Ayuda que se desea eliminar.
   * @throws NoSuchElementException Si la ayuda a eliminar no existe en la lista
   *                                actual de ayudas.
   * @throws NullPointerException   Si la ayuda a eliminar es un valor nulo.
   */
  public void rmHelp(Help help) throws NoSuchElementException, NullPointerException {
    if (help == null) {
      throw new NullPointerException("The supplied help is null.");
    }
    if (!(helps.remove(help))) {
      throw new NoSuchElementException("The help doesn't exist.");
    }
  }
}
