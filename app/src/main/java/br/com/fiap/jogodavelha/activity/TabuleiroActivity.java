package br.com.fiap.jogodavelha.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import br.com.fiap.jogodavelha.R;
import br.com.fiap.jogodavelha.models.Jogador;

import java.io.Serializable;

public class TabuleiroActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabuleiro);
		Jogador jogador = (Jogador) getIntent().getSerializableExtra("jogador");
		TextView lblJogador = (TextView) findViewById(R.id.nomeDoJogador);
		TextView lblNumeroPartidas = (TextView) findViewById(R.id.numeroPartidas);
		jogador.setNumeroDePartidas(jogador.getNumeroDePartidas() + 1);
		lblJogador.setText(jogador.getNome());
		lblNumeroPartidas.setText(String.valueOf(jogador.getNumeroDePartidas()));
	}
}
