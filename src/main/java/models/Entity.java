package models;

/**
 * Esta clase es la abstracción base para todos los elementos de la aplicación.
 *
 * Su responsabilidad es de proveer a todos los elementos el atributo de "id"
 * que permite identificar a cada instancia para cada clase.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public abstract class Entity {
  private Integer id;

  /**
   * Inicializa el objeto con el identificador.
   *
   * @param id Identificador numérico autogenerado por la BD.
   */
  protected Entity(Integer id) {
    setId(id);
  }

  /**
   * Regresa el valor del identificador.
   *
   * @return Número del identificador generado por BD.
   */
  protected Integer getId() {
    return id;
  }

  /**
   * Cambia el valor del identificador.
   *
   * @param id Nuevo número para el identificador.
   * @throws NullPointerException Si el identificador pasado apunta a nulo.
   */
  protected void setId(Integer id) throws NullPointerException {
    if (id == null) {
      throw new NullPointerException("The supplied identifier is null.");
    }
    this.id = id;
  }
}
