package model;

/**
 * @author julio_busarello
 */

public class Veiculo {

    // --- Atributos
    private Long id;
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;
    private boolean anunciado;
    private Long id_cliente;
    
    // --- Construtores
    
    public Veiculo(){
    }
    
    public Veiculo(String placa, String marca, String modelo, String cor, int ano, double preco){
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.anunciado = false;
    }
    
    public Veiculo(Long id, String placa, String marca, String modelo, String cor, int ano, double preco){
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
    }
    
    public Veiculo(Long id, String placa, String marca, String modelo, String cor, int ano, double preco, boolean anunciado){
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.anunciado = anunciado;
        this.id_cliente = null;
    }
    
    public Veiculo(Long id, String placa, String marca, String modelo, String cor, int ano, double preco, boolean anunciado, Long id_cliente){
        this.id = id;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.anunciado = anunciado;
        this.id_cliente = id_cliente;
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

    public boolean isAnunciado() {
        return anunciado;
    }

    public void setAnunciado(boolean anunciado) {
        this.anunciado = anunciado;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }
    
    public boolean hasDono(){
        if(this.id_cliente != null && this.id_cliente != 0){
            return true;
        } else{
            return false;
        }
    }
    
    
}
