package model;

public class BarbeariaDTO {
	private int id_usuario, id_cliente;
	private String nome_usuario,senha_usuario,nome_cliente,telefone,tipo_de_corte,tipo_de_barba,adicional;
	private Float preco_1,preco_2,preco_3,total;
	
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getSenha_usuario() {
		return senha_usuario;
	}
	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo_de_corte() {
		return tipo_de_corte;
	}
	public void setTipo_de_corte(String tipo_de_corte) {
		this.tipo_de_corte = tipo_de_corte;
	}
	public String getTipo_de_barba() {
		return tipo_de_barba;
	}
	public void setTipo_de_barba(String tipo_de_barba) {
		this.tipo_de_barba = tipo_de_barba;
	}
	public String getAdicional() {
		return adicional;
	}
	public void setAdicional(String adicional) {
		this.adicional = adicional;
	}
	public Float getPreco_1() {
		return preco_1;
	}
	public void setPreco_1(Float preco_1) {
		this.preco_1 = preco_1;
	}
	public Float getPreco_2() {
		return preco_2;
	}
	public void setPreco_2(Float preco_2) {
		this.preco_2 = preco_2;
	}
	public Float getPreco_3() {
		return preco_3;
	}
	public void setPreco_3(Float preco_3) {
		this.preco_3 = preco_3;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	public void teste() {
		System.out.println("nome_cliente" +""+"telefone");
	}
	
}
