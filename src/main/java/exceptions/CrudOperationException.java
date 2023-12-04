package exceptions;

/**
 * Esta clase me permite lanzar la excepción causada por un mal manejo de la
 * clase que realiza las operaciones CRUD.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class CrudOperationException extends Exception {

  public CrudOperationException(String message) {
    super(message);
  }
}
