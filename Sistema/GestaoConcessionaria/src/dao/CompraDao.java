package dao;

import connection.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Compra;
import model.Veiculo;

/**
 * @author julio
 */
public class CompraDao {

    private Connection con;

    public CompraDao() {
        this.con = new Conexao().getConexao();
    }

    public Compra criarCompra(Compra compra) {
        String sql = "INSERT INTO compra (parcelas, dataCompra, id_cliente, id_veiculo, id_funcionario) VALUES(?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, compra.getParcelas());
            ps.setDate(2, compra.getData());
            ps.setLong(3, compra.getCliente().getId());
            ps.setLong(4, compra.getVeiculo().getId());
            ps.setLong(5, compra.getFuncionario().getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return compra;
    }

    public List<Compra> getAll() {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT * FROM compra";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    compras.add(new Compra(
                            rs.getLong("id"),
                            rs.getInt("parcelas"),
                            rs.getDate("dataCompra"),
                            rs.getLong("id_cliente"),
                            rs.getLong("id_veiculo"),
                            rs.getLong("id_funcionario")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compras;
    }

    public Compra getById(Long id) {
        Compra compra = null;
        String sql = "SELECT * FROM compra WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    compra = new Compra(
                            rs.getLong("id"),
                            rs.getInt("parcelas"),
                            rs.getDate("dataCompra"),
                            rs.getLong("id_cliente"),
                            rs.getLong("id_veiculo"),
                            rs.getLong("id_funcionario")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return compra;
    }

    public void delete(Long id) {
        VeiculoDao veiculoDao = new VeiculoDao();
        String sql = "DELETE FROM compra WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setLong(1, id);
            
            veiculoDao.removerDono(this.getById(id).getVeiculo());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
