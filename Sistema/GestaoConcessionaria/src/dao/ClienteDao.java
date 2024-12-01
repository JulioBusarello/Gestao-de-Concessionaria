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

    public Cliente registerCliente(Cliente cliente) {
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
    
    public Cliente getById(Long id) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("dataNascimento"),
                            rs.getString("telefone"),
                            rs.getString("genero")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }

    public List<Cliente> getAllClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
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

    public void deleteCliente(Long id) {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setLong(1, id);

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCliente(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, dataNascimento = ?, telefone = ?, genero = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setString(1, cliente.getNome());
            ps.setDate(2, cliente.getDataNascimento());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getGenero());

            ps.setLong(5, cliente.getId());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente getByNome(String nome) {
        Cliente cliente = null;
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nome);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    cliente = new Cliente(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getDate("dataNascimento"),
                            rs.getString("telefone"),
                            rs.getString("genero")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }
}
