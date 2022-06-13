import java.sql.Connection;

public interface ClienteDAO {

    public Connection connect(String urlConexao);
    public void createTable(String urlConexao);
    public void insert(String url_conexao, Cliente cliente);
    public void selectAll(String urlConexao);
    public void update(String urlConexao, int id, String name, Integer idade);
    public void delete(String urlConexao, int id);
}
