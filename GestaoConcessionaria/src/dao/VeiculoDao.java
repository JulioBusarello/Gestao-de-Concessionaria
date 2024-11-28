package dao;

import java.sql.Connection;
import connection.Conexao;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO veiculo (placa, chassi, marca, modelo, ano, cor, preco) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getChassi());
            ps.setString(3, veiculo.getMarca());
            ps.setString(5, veiculo.getModelo());
            ps.setInt(5, veiculo.getAno());
            ps.setString(6, veiculo.getCor());
            ps.setDouble(7, veiculo.getPreco());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        return veiculo;
    }
}
