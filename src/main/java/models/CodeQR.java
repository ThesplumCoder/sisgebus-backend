package models;

import java.time.Duration;
import java.time.LocalTime;

/**
 * CodeQR nos permite representar el código QR que nos permite acceder al STM.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0.
 */
public class CodeQR extends UseMethod {

  /**
   * Define la cantidad de horas que va a ser válido el código QR, después de este
   * tiempo el código queda obsoleto.
   */
  private final Duration WAIT_TIME = Duration.ofHours(1);

  /**
   * Define el momento del día en el que fue generado el QR. Este tiempo va a
   * tener hora, minutos y segundos.
   */
  private LocalTime time;

  /**
   * Crea un código QR tomando el momento del día.
   *
   * @param id Identificador numérico autogenerado por la BD.
   * @throws NullPointerException Si ocurre una excepción en el constructor de
   *                              UseMethod.
   */
  public CodeQR(Integer id) throws NullPointerException {
    super(id);
    time = LocalTime.now();
  }

  /**
   * Retorna el momento del día en el que se generó el código QR.
   *
   * @return El momento del día como un objeto.
   */
  public LocalTime getTime() {
    return time;
  }

  /**
   * Permite verificar si cierto código QR ya no es válido.
   *
   * Si el tiempo entre que se generó el código QR y el tiempo en que se invoca el
   * método, su diferencia es mayor a 1 hora entonces se invalida el código.
   *
   * @return true Si la diferencia de entre el momento del día actual y el
   *         generado es menor a 1 hora.
   */
  public boolean isValid() {
    LocalTime actualTime = LocalTime.now();
    Duration interval = Duration.between(time, actualTime);

    if (interval.toHours() >= WAIT_TIME.toHours()) {
      return false;
    }
    return true;
  }
}
