package models;

/**
 * UseMethod es el modelo que permite abstraer todos los métodos de uso que
 * puede utilizar un pasajero para acceder a un bus o a las estaciones del STM.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public abstract class UseMethod extends Entity {

  /**
   * Define el tipo del que es el método de uso. Solo hay dos posibilidades:
   * Digital, que se codifica con "Digital"; y físico, que se codifica con
   * "Physical".
   */
  private String type;

  /**
   * Inicializa el método de uso asumiendo que es de tipo digital.
   *
   * @throws NullPointerException Si ocurre una excepción en el constructor de
   *                              Entity.
   */
  public UseMethod() throws NullPointerException {
    super();
    type = "Digital";
  }

  /**
   * Retorna el tipo que es el método de uso.
   *
   * @return Tipo del método de uso en texto.
   */
  protected String getType() {
    return type;
  }

  /**
   * Cambia el tipo del método de uso.
   *
   * Si el tipo del método de uso está en "Digital" se alterna a "Physical", y
   * viceversa.
   */
  protected void changeType() {
    if (type.equals("Digital")) {
      type = "Physical";
    } else {
      type = "Digital";
    }
  }
}
