package model;

/**
 * @author julio_busarello
 */
public class Funcionario {

    // - Base
    private Long id;
    private String nome;
    private String login;
    private String senha;

    // - Funcionário
    private Double salario;
    private Boolean admin;
    
    public Funcionario(){
    }
    
    public Funcionario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.admin = false;
    }

    // ---- Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    // ---- Métodos
    public void cadastrarVeiculo() {

    }

    public void anunciarVeiculo() {

    }

    public void deletarVeiculo() {

    }

    public void editarVeiculo() {

    }

    public void cadastrarCliente() {

    }
}
