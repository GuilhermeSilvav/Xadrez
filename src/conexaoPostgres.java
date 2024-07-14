import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimplePostgreSQLExample {
    public static void main(String[] args) {
        // Parâmetros de conexão
        String url = "jdbc:postgresql://localhost:5432/teste";
        String user = "postgres";
        String password = "postgres";

        try {
            // Estabelecer conexão com o banco de dados
            Connection connection = DriverManager.getConnection(url, user, password);
            
            // Criar um statement
            Statement statement = connection.createStatement();
            
            // Executar uma consulta SQL
            ResultSet resultSet = statement.executeQuery("SELECT * FROM aluno");
            
            // Processar o resultado da consulta
            while (resultSet.next()) {
                // Exemplo de leitura de dados
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                // Faça o que precisar com os dados lidos
                System.out.println("ID: " + id + ", Nome: " + nome);
            }
            
            // Fechar conexão e statement
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
