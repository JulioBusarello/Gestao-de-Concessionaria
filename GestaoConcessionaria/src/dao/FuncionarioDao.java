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
import model.Funcionario;

/**
 * @author julio_busarello
 */
public class FuncionarioDao {

    private Connection con;

    public FuncionarioDao() {
        this.con = new Conexao().getConexao();
    }

    public Funcionario login(String login, String senha) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE login LIKE ? AND senha = ?";

        try (Connection connection = new Conexao().getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario();
                    funcionario.setId(rs.getLong("id"));
                    funcionario.setNome(rs.getString("nome"));
                    funcionario.setLogin(rs.getString("login"));
                    funcionario.setSenha(rs.getString("senha"));
                    funcionario.setAdmin(rs.getBoolean("admin"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }

    public Funcionario registro(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (nome, login, senha, admin) VALUES (?, ?, ?, 0)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getLogin());
            ps.setString(3, funcionario.getSenha());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return funcionario;
    }

    public Funcionario editar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET nome = ?, login = ?, senha = ?, salario = ?, admin = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, funcionario.getNome());
            ps.setString(2, funcionario.getLogin());
            ps.setString(3, funcionario.getSenha());
            ps.setDouble(4, funcionario.getSalario());
            ps.setBoolean(5, funcionario.getAdmin());
            ps.setLong(6, funcionario.getId());

            ps.execute();
            ps.close();

            JOptionPane.showMessageDialog(null, "Alteração realizada com sucesso!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return funcionario;
    }
    
    public Funcionario getById(Long id) {
        Funcionario funcionario = null;
        String sql = "SELECT * FROM funcionario WHERE id =  ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    funcionario = new Funcionario(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getDouble("salario"),
                            rs.getBoolean("admin")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionario;
    }

    public List<Funcionario> getAllFuncionarios() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        try (Connection connection = new Conexao().getConexao(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    funcionarios.add(new Funcionario(
                            rs.getLong("id"),
                            rs.getString("nome"),
                            rs.getString("login"),
                            rs.getString("senha"),
                            rs.getDouble("salario"),
                            rs.getBoolean("admin")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }
    
    public void delete(Long id){
        String sql = "DELETE FROM funcionario WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setLong(1, id);
            
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
