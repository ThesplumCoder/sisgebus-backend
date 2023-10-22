package models;

/**
 * Esta clase es la abstracción base para todos los elementos de la aplicación.
 *
 * Su responsabilidad es de proveer a todos los elementos el atributo de "id"
 * que permite identificar a cada instancia para cada clase.
 *
 * @author ThesplumCoder.
 * @version 1.0.
 */
public abstract class Entity {
  private Integer id;

  /**
   * Inicializa el objeto con el identificador.
   *
   * @param id Identificador que se le quiere dar al objeto.
   */
  protected Entity(Integer id) {
    setId(id);
  }

  /**
   * Regresa el valor del identificador.
   *
   * @return Número almacenado como identificador.
   */
  protected Integer getId() {
    return id;
  }

  /**
   * Cambia el valor del identificador.
   *
   * @param id Nuevo número para el identificador.
   */
  protected void setId(Integer id) {
    this.id = id;
  }
}
