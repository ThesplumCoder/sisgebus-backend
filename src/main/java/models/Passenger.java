package models;

import java.util.ArrayList;
import java.util.List;

import exceptions.NotEnoughTickets;

/**
 * Passenger modela los usuarios que utilizan el sistema.
 *
 * Esta clase permite identificar a cada usuario, y le permite realizar
 * operaciones de gestión de su transporte.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class Passenger extends NamedEntity {
  private int busTickets;
  private List<Card> cards;
  private List<PaymentMethod> paymentMethods;

  /**
   * Crea un usuario con solo el nombre. El usuario inicia sin tarjetas de bus y
   * sin pasajes.
   *
   * @param id   Identificador numérico autogenerado por la BD.
   * @param name Nombre del usuario.
   */
  public Passenger(Integer id, String name) {
    this(id, name, 0, null, null);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente, excepto la
   * cantidad de pasajes; por lo tanto, el usuario inicia con cero pasajes.
   *
   * @param id    Identificador numérico autogenerado por la BD.
   * @param name  Nombre del usuario.
   * @param cards Tarjetas de bus.
   */
  public Passenger(Integer id, String name, List<Card> cards) {
    this(id, name, 0, cards, null);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente.
   *
   * @param id             Identificador numérico autogenerado por la BD.
   * @param name           Nombre del usuario.
   * @param busTickets     Cantidad de pasajes de bus.
   * @param cards          Tarjetas de bus.
   * @param paymentMethods Métodos de pago que tenga el usuario registrados.
   * @throws NullPointerException     Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   * @throws IllegalArgumentException Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   */
  public Passenger(Integer id, String name, int busTickets, List<Card> cards, List<PaymentMethod> paymentMethods)
      throws NullPointerException, IllegalArgumentException {
    super(id, name);
    setBusTickets(busTickets);
    setCards(cards);
    setPaymentMethods(paymentMethods);
  }

  /**
   * Retorna la cantidad de pasajes de bus que tiene el pasajero.
   *
   * @return Número de la cantidad de pasajes.
   */
  public int getBusTickets() {
    return busTickets;
  }

  /**
   * Retorna las tarjetas de bus que posee el pasajero.
   * 
   * @return Lista de tarjetas de bus. Si no tiene ninguna se retornará una lista
   *         vacía.
   */
  public List<Card> getCards() {
    return cards;
  }

  /**
   * Retorna los métodos de pago que tiene registrados.
   *
   * @return Lista de métodos de pago. Si no tiene ninguno se retornará una lista
   *         vacía.
   */
  public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }

  /**
   * Cambia la cantidad de tiquetes de bus.
   *
   * @param busTickets Nueva cantidad de tiquetes de bus.
   * @throws IllegalArgumentException Si la cantidad de tiquetes de autobus es
   *                                  menor que cero.
   */
  public void setBusTickets(int busTickets) throws IllegalArgumentException {
    if (busTickets < 0) {
      throw new IllegalArgumentException("The amount of tickets can't be negative.");
    }
    this.busTickets = busTickets;
  }

  /**
   * Cambia la lista de tarjetas de bus que tiene el pasajero.
   *
   * Si se pasa un valor nulo se acepta y se entiende que el pasajero ahora no
   * posee tarjetas.
   * 
   * @param cards Lista de tarjetas de bus que se desea dar al pasajero.
   */
  public void setCards(List<Card> cards) {
    if (cards == null) {
      this.cards = new ArrayList<>();
    } else {
      this.cards = cards;
    }
  }

  /**
   * Cambia la lista de métodos de pago.
   *
   * Si se pasa un valor nulo se entiende que el pasajero por el momento no tiene
   * ningún método de pago.
   * 
   * @param paymentMethods Lista de métodos de pago que tiene el pasajero.
   */
  public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
    if (paymentMethods == null) {
      this.paymentMethods = new ArrayList<>();
    } else {
      this.paymentMethods = paymentMethods;
    }
  }

  /**
   * Adiciona un pasaje de bus a la cantidad actual de pasajes.
   */
  public void addTicket() {
    busTickets += 1;
  }

  /**
   * Quita un pasaje de bus a la cantidad actual de pasajes.
   *
   * @throws NotEnoughTickets Si la cantidad de pasajes es igual a cero y se
   *                          invoca este método.
   */
  public void rmTicket() throws NotEnoughTickets {
    if (busTickets == 0) {
      throw new NotEnoughTickets();
    }

    busTickets -= 1;
  }

}
