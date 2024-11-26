package connection;

/**
 * @author julio_busarello
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexao {

    private Connection connection;

    public Connection getConexao() {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/dbConcessionaria";
            String user = "root";
            String password = "";
            return connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Impossível conectar-se ao banco de dados! " + e.getMessage());
            return null;
        }
    }
}
