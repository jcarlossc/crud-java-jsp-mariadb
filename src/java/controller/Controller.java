package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import connection.ConnectionFactory;

/**
 *
 * @author Carlos da Costa
 */
public class Controller {
    
    private int id;
    private String first_name;
    private String last_name;
    private String phone;

    public Controller(int id, String first_name, String last_name, String phone) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }

    public Controller(String first_name, String last_name, String phone) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }
   
    public Controller() {
        
    }
    
    public boolean save() throws ClassNotFoundException {
        // Variável que recebe como valor uma instrução sql INSERT
        String sql = "INSERT INTO users(first_name, last_name, phone) VALUES(?, ?, ?)";
        // Declaração da variável connection
        Connection connection = null;
        // Declaração da variável statement
        PreparedStatement statement = null;
        
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            // Define os valores do parâmetro, tipo e posição
            statement.setString(1, this.first_name);
            statement.setString(2, this.last_name);
            statement.setString(3, this.phone);
            // Executa a sql para inserção dos dados
            statement.execute();
            //System.out.println("Usuário Cadastrado com sucesso!");
            
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao inserir dados no banco de dados. ", ex);
        } finally {
            // Fecha a connection e o statement
            ConnectionFactory.closeConnection(connection, statement);
        }
        return true;
    }
    
    public boolean update() throws ClassNotFoundException {
        // Variável que recebe como valor uma instrução sql UPDATE
        String sql = "UPDATE users SET first_name = ?, last_name = ?, phone = ? WHERE id = ?";
        // Declaração da variável connection
        Connection connection = null;
        // Declaração da variável statement
        PreparedStatement statement = null;
        
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            // Define os valores do parâmetro, tipo e posição
            statement.setString(1, this.first_name);
            statement.setString(2, this.last_name);
            statement.setString(3, this.phone);
            statement.setInt(4, this.id);
            // Executa a sql para atualizar os dados
            statement.execute();
            //System.out.println("Usuário atualizado com sucesso!");
            
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao atualizar o banco de dados. ", ex);
        } finally {
            // Fecha a connection e o statement
            ConnectionFactory.closeConnection(connection, statement);
        }
        return true;
    }
    
    public Controller getOne(int id) throws ClassNotFoundException {
        // Variável que recebe como valor uma instrução sql UPDATE
        String sql = "SELECT first_name, last_name, phone FROM users WHERE id = ?";
        // Declaração da variável connection
        Connection connection = null;
        // Declaração da variável statement
        PreparedStatement statement = null;
        // Declaração da variável resultSet
        ResultSet resultSet = null;
        
        Controller colab = null;
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            // Executa a query
            resultSet = statement.executeQuery();
            // Define os valores do parâmetro, tipo e posição
            statement.setInt(1, this.id);
            
            //if(resultSet.next()) {
                // Instancia um objeto Controller
                Controller controller = new Controller();
                // Define os valores do parâmetro, tipo e posição
                controller.setId(resultSet.getInt("id"));
                controller.setFirst_name(resultSet.getString("first_name"));
                controller.setLast_name(resultSet.getString("last_name"));
                controller.setPhone(resultSet.getString("phone"));
           // }
            
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao selecionar dados do banco de dados. ", ex);
        } finally {
            // Fecha a connection, o statement e o resultSet
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        return colab;
    }
    
    public List<Controller> getAll() throws ClassNotFoundException {
        // Variável que recebe como valor uma instrução sql SELECT
        String sql = "SELECT * FROM users";
        // Declaração da Lista que receberá os dados do SELECT
        List<Controller> list = new ArrayList<>();
        // Declaração da variável connection
        Connection connection = null;
        // Declaração da variável statement
        PreparedStatement statement = null;
        // Declaração da variável resultSet
        ResultSet resultSet = null;
        
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            // Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            // Executa a query
            resultSet = statement.executeQuery();
            // Enquanto existir dados no banco de dados, faça
            while (resultSet.next()) {
                // Instancia um objeto Controller
                Controller controller = new Controller();
                // Define os valores do parâmetro, tipo e posição
                controller.setId(resultSet.getInt("id"));
                controller.setFirst_name(resultSet.getString("first_name"));
                controller.setLast_name(resultSet.getString("last_name"));
                controller.setPhone(resultSet.getString("phone"));
                // Adiciona o cliente recuperado á lista
                list.add(controller);
            }
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao selecionar dados do banco de dados. ", ex);
        } finally {
            // Fecha a connection, o statement e o resultSet
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        // Retorna a lista com os dados do banco de dados
        return list;
    }
 
    public boolean delete() throws ClassNotFoundException {
        // Variável que recebe como valor a instrução sql DELETE
        String sql = "DELETE FROM users WHERE id = ?";
        // Declaração da variável connection
        Connection connection = null;
        // Declaração da variável statement
        PreparedStatement statement = null;
        
        try {
            // Cria uma conexão com o banco
            connection = ConnectionFactory.getConnection();
            //Cria um PreparedStatment, classe usada para executar a query
            statement = connection.prepareStatement(sql);
            // Define o valor do parâmetro, tipo e posição
            statement.setInt(1, id);
            // Executa a sql para deletar os dados
            statement.execute();
            //System.out.println("Usuário Excluído com sucesso!");
            
        } catch (SQLException ex) {
            // Exceção que será lançada caso algo de errado aconteça
            throw new RuntimeException("Erro ao apagar dados do banco de dados. ", ex);
        } finally {
            // Fecha a connection e o statement 
            ConnectionFactory.closeConnection(connection, statement);
        }
        return true;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
