package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import model.Cliente;

/**
 * @author julio_busarello
 */
public class ClienteDao {

    private Connection con;

    public ClienteDao() {
        this.con = new Conexao().getConexao();
    }
    
    public Cliente cadastro(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, telefone, dataNascimento, genero) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());
            ps.setDate(3, cliente.getDataNascimento());
            ps.setString(4, cliente.getGenero());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return cliente;
    }
}
