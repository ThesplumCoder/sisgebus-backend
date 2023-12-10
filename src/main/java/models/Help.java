package models;

/**
 * Modela cada posible ayuda que puede prestar un autobus.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class Help extends NamedEntity {

  /**
   * Identificador del bus al que pertenece la ayuda.
   */
  private Integer busId;

  /**
   * Crea una ayuda.
   *
   * @param id    Identificador numérico autogenerado por la BD.
   * @param name  Nombre de la ayuda.
   * @param busId Identificador numérico autogenerado del bus por la BD.
   */
  public Help(Integer id, String name, Integer busId) {
    super(id, name);
    //
  }

  /**
   * Retorna el identificador del bus.
   */
  public Integer getBusId() {
    return busId;
  }

  /**
   * Cambia el bus al que está relacionada la ayuda.
   *
   * @param busId Identificador del nuevo bus al que se le quiere asignar la
   *              ayuda.
   */
  public void setBusId(Integer busId) {
    this.busId = busId;
  }
}
