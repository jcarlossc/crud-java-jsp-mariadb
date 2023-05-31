package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Carlos da Costa
 */
public class ConnectionFactory {
    
    // Atributo que recebe como valor a classe com.mysql.cj.jdbc.Driver
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    // Atributo que recebe como valor o endereço: local, porta e nome do banco de dados
    public static final String URL = "jdbc:mysql://localhost:3306/java_web1";
    // Atributo que recebe como valor o usuário do banco de dados
    public static final String USER = "root";
    // Atributo que recebe como valor a senha do banco de dados
    public static final String PASS = "";

    public static Connection getConnection() throws ClassNotFoundException {
        try {
            // Método da classe DriverManager que registra o driver utilizado
            Class.forName(DRIVER);
            // Retorna uma instância de Connection
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro na conexão com o banco de dados.", ex);
        }
    }

    public static void closeConnection(Connection connection) {
        try {
            // Testa se a connection é diferente de null
            if (connection != null) {
                // Fecha a connection
                connection.close();
            }
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", ex);
        }
    }
   
    public static void closeConnection(Connection connection, PreparedStatement statement) {
        try {
            // Testa se a connection é diferente de null
            if (connection != null) {
                // Fecha a connection
                connection.close();
            }
            // Testa se o statement é diferente de null
            if (statement != null) {
                // Fecha statement
                statement.close();
            }
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", ex);
        }
    }

    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            // Testa se a connection é diferente de null
            if (connection != null) {
                // Fecha a connection
                connection.close();
            }
            // Testa se o statement é diferente de null
            if (statement != null) {
                // Fecha statement
                statement.close();
            }
            // Testa se o resultSet é diferente de null
            if (resultSet != null) {
                // Fecha o resultSet
                resultSet.close();
            }
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dados.", ex);
        }
    }
}
