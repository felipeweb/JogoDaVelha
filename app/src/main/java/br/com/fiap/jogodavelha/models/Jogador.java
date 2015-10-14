package br.com.fiap.jogodavelha.models;

import java.io.Serializable;

/**
 * Created by felipeweb on 10/14/15.
 */
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nome;
	private String login;
	private String senha;
	private int numeroDePartidas = 0;

	public Jogador(String nome, String login, String senha, int numeroDePartidas) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.numeroDePartidas = numeroDePartidas;
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

	public int getNumeroDePartidas() {
		return numeroDePartidas;
	}

	public void setNumeroDePartidas(int numeroDePartidas) {
		this.numeroDePartidas = numeroDePartidas;
	}
}
