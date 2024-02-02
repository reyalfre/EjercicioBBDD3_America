import java.sql.*;

public class Main {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/america";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            // Crear la tabla PersonasPaises
            String createTableQuery = "CREATE TABLE PersonasPaises AS " +
                    "SELECT p.Id, p.Nombre, p.Apellido, p.Edad, pa.Nombre AS NombrePais, pa.Tamanio " +
                    "FROM Persona p " +
                    "JOIN Pais pa ON p.Pais = pa.Id";
            stmt.executeUpdate(createTableQuery);

            // Suma un año a las personas de Costa Rica.
            String updateQuery = "UPDATE PersonasPaises SET Edad = Edad + 1 WHERE NombrePais = 'Costa Rica'";
            stmt.executeUpdate(updateQuery);

            // Mostrar la tabla PersonasPaises
            String selectQuery = "SELECT * FROM PersonasPaises";
            ResultSet rs = stmt.executeQuery(selectQuery);
            //Obtiene el nombre de las columnas
            while (rs.next()) {
                int id = rs.getInt("Id");
                String nombre = rs.getString("Nombre");
                String apellido = rs.getString("Apellido");
                int edad = rs.getInt("Edad");
                String nombrePais = rs.getString("NombrePais");
                String tamanio = rs.getString("Tamanio");
                //Imprime la tabla
                System.out.println("Id: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido +
                        ", Edad: " + edad + ", NombrePais: " + nombrePais + ", Tamaño: " + tamanio);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
