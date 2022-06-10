import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class PrintJDBCDrivers {

    public static void main(String[] args) {
        System.out.println("Lista de drivers JDBC carregados: ");
        for (Enumeration<Driver> e = DriverManager.getDrivers(); e.hasMoreElements();) {
            Driver driver = e.nextElement();
            dadosDoDriver(driver);
        }
    }

    public static void dadosDoDriver(Driver driver) {
        String nomeClasse = driver.getClass().getName();
        int maiorVersao = driver.getMajorVersion();
        int menorVersao = driver.getMinorVersion();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Nome do driver: " + nomeClasse);
        System.out.println("Versão mais recente do driver: " + maiorVersao);
        System.out.println("Versão mais antiga do driver: " + menorVersao);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}