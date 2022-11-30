package com.integraciones.steps;
import java.sql.*;
public class ConexionBaseDatos {
    public static void main(String[] args) throws ClassNotFoundException {
      //  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://MANAGUA\\PRUCONTSQL;"
                + "databaseName=Icontroller;"
                + "integratedSecurity=true; ";
        try {
            Connection connection = DriverManager.getConnection(url);
            System.out.println("*** CONECTADO A LA BASE DE DATOS **");
            Statement statement = connection.createStatement();
            String sql = "USE Iseguridad\n" +
                    "SELECT UIN_IdClienteCredito, UIN_IdUsuarioIntegracion, UIN_Password, UIN_Token\n" +
                    "FROM UsuarioIntegracion_SEG\n" +
                    "WHERE UIN_IdClienteCredito IN (1057) order By UIN_FechaCreacion desc;";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " "
                        + resultSet.getString(2) + " "
                        + resultSet.getString(3) + " "
                        + resultSet.getString(4));
            }
            System.out.println("\n** FIN CONSULTA ***");
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("**** Error al intentar conectarse a la Base de datos ****");
        }
    }
}

