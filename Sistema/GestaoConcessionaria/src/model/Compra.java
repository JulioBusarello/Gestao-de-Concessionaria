package model;

import dao.ClienteDao;
import dao.FuncionarioDao;
import dao.VeiculoDao;
import java.sql.Date;

/**
 * @author julio
 */

public class Compra {
    
    private final VeiculoDao veiculoDao = new VeiculoDao();
    private final ClienteDao clienteDao = new ClienteDao();
    private final FuncionarioDao funcionarioDao = new FuncionarioDao();
    
    // --- Atributos
    private Long id;
    private int parcelas;
    private Date data;
    Veiculo veiculo;
    Funcionario funcionario;
    Cliente cliente;
    
    // --- Construtores
    public Compra() {
    }
    
    public Compra(int parcelas, Date data, Veiculo veiculo, Cliente cliente, Funcionario funcionario) {
        this.parcelas = parcelas;
        this.data = data;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }
    
    public Compra(Long id, int parcelas, Date data, Long id_cliente, Long id_veiculo, Long id_funcionario) {
        this.id = id;
        this.parcelas = parcelas;
        this.data = data;
        this.veiculo = veiculoDao.getById(id_veiculo);
        this.cliente = clienteDao.getById(id_cliente);
        this.funcionario = funcionarioDao.getById(id_funcionario);
    }
    
    // --- Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    
}
