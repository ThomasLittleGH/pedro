/*
 * Clase que permite establecer la conexion
 * con la base de datos
 * mysql
 */
package pg;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Moya
 */
public class conectar {

    Connection conectar = null;
    Boolean flag = false;

    public Connection conexion() {
        flag = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // el orden de objeto para la conexion inicial es driver+servidor+puerto+base de datos, usuario, clave
            conectar = DriverManager.getConnection("jdbc:mysql://localhost:3306/pacientes", "Admin", "12345"); // PORT 8889 FOR MAMP    3306 FOR XAMPP
            System.out.println("Conexion exitosa...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Error, no se puede conectar a la base de datos");
            System.out.println("Trying with MAMP port");
            flag = true;
        }

        if (flag) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                // el orden de objeto para la conexion inicial es driver+servidor+puerto+base de datos, usuario, clave
                conectar = DriverManager.getConnection("jdbc:mysql://localhost:8889/pacientes", "Admin", "12345"); // PORT 8889 FOR MAMP    3306 FOR XAMPP
                System.out.println("Conexion exitosa...");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error, no se puede conectar a la base de datos");
            }
        }

        return conectar;
    }
}
