package dao;

import java.sql.Connection;
import connection.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Veiculo;

/**
 * @author julio_busarello
 */
public class VeiculoDao {

    private Connection con;

    public VeiculoDao() {
        this.con = new Conexao().getConexao();
    }

    public Veiculo cadastrar(Veiculo veiculo) {
        String sql = "INSERT INTO veiculo (placa, marca, modelo, ano, cor, preco) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAno());
            ps.setString(5, veiculo.getCor());
            ps.setDouble(6, veiculo.getPreco());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return veiculo;
    }

    public List<Veiculo> getAllUnAnnounced() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo WHERE anunciado = false AND id_cliente is null";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    veiculos.add(new Veiculo(
                            rs.getLong("id"),
                            rs.getString("placa"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("cor"),
                            rs.getInt("ano"),
                            rs.getDouble("preco"),
                            rs.getBoolean("anunciado"),
                            rs.getLong("id_cliente")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }
    
    public Veiculo getById(Long id) {
        Veiculo veiculo = null;
        String sql = "SELECT * FROM veiculo WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    veiculo = new Veiculo(
                            rs.getLong("id"),
                            rs.getString("placa"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("cor"),
                            rs.getInt("ano"),
                            rs.getDouble("preco"),
                            rs.getBoolean("anunciado"),
                            rs.getLong("id_cliente")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculo;
    }

    public List<Veiculo> getAll() {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM veiculo";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    veiculos.add(new Veiculo(
                            rs.getLong("id"),
                            rs.getString("placa"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("cor"),
                            rs.getInt("ano"),
                            rs.getDouble("preco"),
                            rs.getBoolean("anunciado"),
                            rs.getLong("id_cliente")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculos;
    }

    public void anunciarVeiculo(Long id) {
        String sql = "UPDATE veiculo SET anunciado = true WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "O Veiculo foi anunciado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteVeiculo(Long id) {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);

            ps.executeUpdate();
            ps.close();

            JOptionPane.showMessageDialog(null, "O Veiculo foi deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Veiculo editarVeiculo(Veiculo veiculo) {
        String sql = "UPDATE veiculo SET placa = ?, marca = ?, modelo = ?, cor = ?, ano = ?, preco = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setString(4, veiculo.getCor());
            ps.setDouble(5, veiculo.getAno());
            ps.setDouble(6, veiculo.getPreco());
            ps.setLong(7, veiculo.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }
    
    public Veiculo getByPlaca(String placa) {
        Veiculo veiculo = null;
        String sql = "SELECT * FROM veiculo WHERE placa = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, placa);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    veiculo = new Veiculo(
                            rs.getLong("id"),
                            rs.getString("placa"),
                            rs.getString("marca"),
                            rs.getString("modelo"),
                            rs.getString("cor"),
                            rs.getInt("ano"),
                            rs.getDouble("preco"),
                            rs.getBoolean("anunciado"),
                            rs.getLong("id_cliente")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculo;
    }
    
    public Veiculo mudarDono(Veiculo veiculo, Long id_cliente){
        String sql = "UPDATE veiculo SET id_cliente = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id_cliente);
            ps.setLong(2, veiculo.getId());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }
    
    public Veiculo removerDono(Veiculo veiculo){
        String sql = "UPDATE veiculo SET id_cliente = null WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, veiculo.getId());

            ps.execute();
            ps.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return veiculo;
    }
    
    public boolean veiculoEmUso(Long id){
        String sql = "SELECT COUNT(*) FROM compra WHERE id_veiculo = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try(ResultSet rs = ps.executeQuery()){
                if(rs.next()){
                    int count = rs.getInt(1);
                    return count > 0;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar dependências!" + e );
        }
        
        return false;
    }
}
