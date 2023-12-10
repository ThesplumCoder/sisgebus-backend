package models;

/**
 * Modelo que permite abstraer todos los métodos de uso que puede utilizar un
 * pasajero para acceder a un bus o a las estaciones del STM.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public abstract class UseMethod extends Entity {

  /**
   * Define el tipo del que es el método de uso.
   */
  private UseMethodType type;

  /**
   * Crea un método de uso. Por defecto es de tipo digital.
   *
   * @param id Identificador numérico autogenerado por la BD.
   * @throws NullPointerException Si ocurre una excepción en el constructor de
   *                              Entity.
   */
  public UseMethod(Integer id) throws NullPointerException {
    super(id);
    setType(UseMethodType.DIGITAL);
  }

  /**
   * Retorna el tipo que es el método de uso.
   *
   * @return Constante de la enumeración que representa el tipo.
   */
  protected UseMethodType getType() {
    return type;
  }

  /**
   * Cambia el tipo del que es el método de uso.
   *
   * @param type Nuevo tipo para el método de uso.
   */
  protected void setType(UseMethodType type) {
    if (type == null) {
      throw new NullPointerException("The type can't be null.");
    }
    this.type = type;
  }
}
