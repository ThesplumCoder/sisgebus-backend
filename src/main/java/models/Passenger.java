package models;

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
  private Card card;

  /**
   * Crea un usuario con solo el nombre. El usuario inicia sin tarjeta de bus y
   * sin pasajes.
   *
   * @param name Nombre del usuario.
   */
  public Passenger(String name) {
    this(name, null, 0);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente, excepto la
   * cantidad de pasajes; por lo tanto, el usuario inicia con cero pasajes.
   *
   * @param name Nombre del usuario.
   * @param card Tarjeta de bus.
   */
  public Passenger(String name, Card card) {
    this(name, card, 0);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente.
   *
   * @param name       Nombre del usuario.
   * @param card       Tarjeta de bus.
   * @param busTickets Cantidad de pasajes de bus.
   * @throws NullPointerException     Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   * @throws IllegalArgumentException Si ocurrió un error en el constructor de
   *                                  NamedEntity.
   */
  public Passenger(String name, Card card, int busTickets) throws NullPointerException, IllegalArgumentException {
    super(name);
    setCard(card);
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
   * Retorna la tarjeta de bus que posee el pasajero.
   * 
   * @return Objeto que representa la tarjeta de bus del pasajero. Si no tiene
   *         tarjeta retorna nulo.
   */
  public Card getCard() {
    return card;
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

  /**
   * Cambia la tarjeta de bus que tiene el pasajero.
   *
   * Si se pasa un valor nulo se acepta y se entiende que el pasajero ahora no
   * posee tarjeta.
   * 
   * @param card Tarjeta de bus que se desea dar al pasajero.
   */
  public void setCard(Card card) {
    this.card = card;
  }
}
