public class ClienteTest {
    public static void main(String[] args) {

        String url = "jdbc:sqlite_database_marco_2022.db";

        // 1) Criando o banco de dados
        ClienteDAOImpl clienteDAOImpl = new ClienteDAOImpl();
        clienteDAOImpl.connect(url);

        // 2 - Criando a tabela
        clienteDAOImpl.createTable(url);

        // 3 - Inserindo clientes
        Cliente c1 = new Cliente();
        c1.setNome("Danilo R. Pereira");
        c1.setIdade(37);
        c1.setCpf("111.111.111-11");
        c1.setRg("222.222.222-22");

        Cliente c1iente2 = new Cliente();
        c1iente2.setNome("Joao Oliveira Silva");
        c1iente2.setIdade(55);
        c1iente2.setCpf("888.111.111-11");
        c1iente2.setRg("777.222.222-22");

        clienteDAOImpl.insert(url, c1);
        clienteDAOImpl.insert(url, c1iente2);


        // 4 - selecionado todos os cliente
        clienteDAOImpl.selectAll(url);


        // 5 - atualizando um cliente
        clienteDAOImpl.update(url, 1, "Danilo Rodrigues Pereira", 38);
        clienteDAOImpl.selectAll(url);

        // 5 - deletando um cliente
        clienteDAOImpl.delete(url, 2);
        clienteDAOImpl.selectAll(url);
    }
}
