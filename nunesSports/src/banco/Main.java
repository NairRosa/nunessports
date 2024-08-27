package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

public class Main {
    // URL de conexão com o banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/nunessports?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "147852";

    public static void main(String[] args) {
        // SQL para criar a tabela
        String createTableSQL = "CREATE TABLE produtos (" +
                                 "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                                 "nome VARCHAR(255) NOT NULL, " +
                                 "codigo VARCHAR(100) UNIQUE NOT NULL, " +
                                 "descricao TEXT, " +
                                 "preco DECIMAL(10, 2) NOT NULL" +
                                 ");";

        // Tenta estabelecer a conexão e criar a tabela
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            // Executa o comando SQL
            statement.execute(createTableSQL);
            System.out.println("Tabela criada com sucesso!");

        } catch (SQLException e) {
            // Exibe uma mensagem de erro mais detalhada
            System.err.println("Erro ao criar tabela: " + e.getMessage());
            e.printStackTrace();
        }
        
    }
}