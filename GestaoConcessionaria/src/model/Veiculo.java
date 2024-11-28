package model;

/**
 * @author julio_busarello
 */

public class Veiculo {

    // --- Atributos
    private Long id;
    private String placa;
    private String chassi;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;
    private boolean anunciado;
    
    // --- Construtores
    
    public Veiculo(){
    }
    
    public Veiculo(String placa, String chassi, String marca, String modelo, String cor, int ano, double preco){
        this.placa = placa;
        this.chassi = chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.anunciado = false;
    }
    
    public Veiculo(Long id, String placa, String chassi, String marca, String modelo, String cor, int ano, double preco, boolean anunciado){
        this.id = id;
        this.placa = placa;
        this.chassi = chassi;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.anunciado = anunciado;
    }
    
    // --- Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    
}
