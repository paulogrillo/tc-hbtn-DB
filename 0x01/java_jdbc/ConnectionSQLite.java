import java.sql.*;

public class ConnectionSQLite {

    public static void main(String[] args) {
        initConnection();
    }
    public static void initConnection() {
        Connection conexao = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:sqlite_database_2022.db";

            conexao = DriverManager.getConnection(url);

            System.out.println("Conexão com o SQlite foi estabelecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }
}