package utilities;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Esta clase me permite establecer una conexión con la base de datos de la
 * aplicación.
 *
 * @author Anderson Acuña (ThesplumCoder).
 * @version 1.0
 */
public class ConnectionDB {
  private final String PROTOCOL = "jdbc:mariadb://";

  private String url;
  private String database;
  private String hostname;
  private String user;
  private String password;
  private Connection connection;

  /**
   * Inicializa los parámetros de la conexión con la base de datos.
   *
   * @param database Nombre de la base de datos.
   * @param hostname Dominio en el cual está respondiendo el gestor de base de
   *                 datos.
   * @param user     Nombre del usuario con el que se quiere autenticar.
   * @param password Contraseña del usuario.
   */
  public ConnectionDB(String database, String hostname, String user, String password) {
    this.user = user;
    this.password = password;
    url = PROTOCOL + hostname + "/" + database + "?serverTimezone=UTC";
  }

  /**
   * Retorna la conexión que nos permite interactuar con la base de datos.
   *
   * @return Objeto de la conexión exitosa. Si hubo algún falló retornará nulo.
   */
  public Connection getConnection() {
    try {
      connection = DriverManager.getConnection(url, user, password);
      connection.setTransactionIsolation(8);
      System.out.println("Connected");
    } catch (SQLException sqlex) {
      Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, sqlex);
    }
    return connection;
  }

  /**
   * Cierra la conexión establecida con base de datos.
   */
  public void closeConnection() {
    if (!connection.equals(null)) {
      try {
        connection.close();
      } catch (SQLException sqlex) {
        Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, sqlex);
      }
    }
  }

}
