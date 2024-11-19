package model;

import java.sql.Date;

/**
 * @author julio_busarello
 */
public class Cliente {

    // - Base
    private Long id;
    private String nome;
    private Date dataNascimento;
    private String telefone;
    private String genero;

    // ---- Construtores
    public Cliente() {
    }

    public Cliente(String nome, Date dataNascimento, String telefone, String genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.genero = genero;
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

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    // ---- Métodos
    public void visualizarVeiculos() {

    }

    public void agendarVisita(Date data) {

    }
}
