package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (Connection connection = new Conexao().getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    clientes.add(new Cliente(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("dataNascimento"),
                            rs.getString("telefone"),
                            rs.getString("genero")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }
}
