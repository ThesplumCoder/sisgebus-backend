package models;

/**
 * User modela los usuarios que utilizan el sistema.
 *
 * Esta clase permite identificar a cada usuario, y le permite realizar
 * operaciones de gestión de su transporte.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public class User extends NamedEntity {
  private Integer busTickets;
  private Card card;

  /**
   * Crea un usuario con el identificador y el nombre. El usuario inicia sin
   * tarjeta de bus y sin pasajes.
   *
   * @param id   Identificador del usuario.
   * @param name Nombre del usuario.
   */
  public User(Integer id, String name) {
    this(id, name, null, 0);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente, excepto la
   * cantidad de pasajes; por lo tanto, el usuario inicia con cero pasajes.
   *
   * @param id   Identificador del usuario.
   * @param name Nombre del usuario.
   * @param card Tarjeta de bus.
   */
  public User(Integer id, String name, Card card) {
    this(id, name, card, 0);
  }

  /**
   * Crea un usuario con todos los parámetros definidos externamente.
   *
   * @param id         Identificador del usuario.
   * @param name       Nombre del usuario.
   * @param card       Tarjeta de bus.
   * @param busTickets Cantidad de pasajes de bus.
   */
  public User(Integer id, String name, Card card, Integer busTickets) {
    super(id, name);
  }

  /**
   * Retorna la cantidad de pasajes de bus que tiene el usuario.
   *
   * @return Número de la cantidad de pasajes.
   */
  public Integer getBusTickets() {
    return this.busTickets;
  }

  /**
   * Retorna la tarjeta de bus que posee el usuario.
   *
   * @return Objeto que representa la tarjeta de bus del usuario.
   */
  public Card getCard() {
    return this.card;
  }

  /**
   * Adiciona un pasaje de bus a la cantidad actual que posea el usuario.
   */
  public void addTicket() {
    //
  }

  /**
   * Quita un pasaje de bus a la cantidad actual que posea el usuario.
   */
  public void rmTicket() {
    //
  }

  /**
   * Cambia la tarjeta de bus que tiene el usuario.
   *
   * @param card Tarjeta de bus que se desea dar al usuario.
   */
  public void setCard(Card card) {
    //
  }
}
