package br.com.fiap.jogodavelha.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by felipeweb on 10/14/15.
 */
public class Partida implements Serializable {
	private static final long serialVersionUID = 1L;
	private static List<Jogador> jogadoresCadastrados = new ArrayList<>();

	public static List<Jogador> getJogadoresCadastrados() {
		return jogadoresCadastrados;
	}

	public static void setJogadoresCadastrados(List<Jogador> jogadoresCadastrados) {
		Partida.jogadoresCadastrados = jogadoresCadastrados;
	}

	public static void adicionarJogador(Jogador jogador) {
		jogadoresCadastrados.add(jogador);
	}

	public static Jogador getJogadorByLoginAndSenha(String login, String senha) {
		for (Jogador jogadoresCadastrado : jogadoresCadastrados) {
			if (jogadoresCadastrado.getLogin().equals(login) && jogadoresCadastrado.getSenha().equals(senha)) {
				return jogadoresCadastrado;
			}
		}
		return null;
	}
}
