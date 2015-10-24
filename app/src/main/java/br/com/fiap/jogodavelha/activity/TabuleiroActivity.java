package br.com.fiap.jogodavelha.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import br.com.fiap.jogodavelha.R;
import br.com.fiap.jogodavelha.models.Jogador;
import java.util.Random;

public class TabuleiroActivity extends Activity {

	private Button[][] buttons = new Button[3][3];
	private Jogador jogador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tabuleiro);
		jogador = (Jogador) getIntent().getSerializableExtra("jogador");
		TextView lblJogador = (TextView) findViewById(R.id.nomeDoJogador);
		TextView lblNumeroPartidas = (TextView) findViewById(R.id.numeroPartidas);
		jogador.setNumeroDePartidas(jogador.getNumeroDePartidas() + 1);
		lblJogador.setText(jogador.getNome());
		lblNumeroPartidas.setText(String.valueOf(jogador.getNumeroDePartidas()));
		adicionaEventoNosBotoes();
	}

	private void adicionaEventoNosBotoes() {
		buttons[0][0] = (Button) findViewById(R.id.btnJogo00);
		buttons[0][1] = (Button) findViewById(R.id.btnJogo01);
		buttons[0][2] = (Button) findViewById(R.id.btnJogo02);
		buttons[1][0] = (Button) findViewById(R.id.btnJogo10);
		buttons[1][1] = (Button) findViewById(R.id.btnJogo11);
		buttons[1][2] = (Button) findViewById(R.id.btnJogo12);
		buttons[2][0] = (Button) findViewById(R.id.btnJogo20);
		buttons[2][1] = (Button) findViewById(R.id.btnJogo21);
		buttons[2][2] = (Button) findViewById(R.id.btnJogo22);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				final Button button = buttons[i][j];
				button.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						if (button.getText().equals("")) {
							button.setText("X");
							boolean ganhou = verificaJogo(button);
							if (ganhou) {
								Toast.makeText(TabuleiroActivity.this, "Você ganhou", Toast.LENGTH_SHORT).show();
								int numeroDePartidas = jogador.getNumeroDePartidas();
								int vitorias = jogador.getVitorias();
								jogador.setVitorias(vitorias + 1);
								jogador.setNumeroDePartidas(numeroDePartidas + 1);
								TextView numeroPartidas = (TextView) findViewById(R.id.numeroPartidas);
								numeroPartidas.setText(String.valueOf(jogador.getNumeroDePartidas()));
								zerarTabuleiro();
							} else {
								Button b = jogaAndroid();
								boolean ganhouAndroid = verificaJogo(b);
								if (ganhouAndroid) {
									Toast.makeText(TabuleiroActivity.this, "Android ganhou", Toast.LENGTH_SHORT).show();
									int numeroDePartidas = jogador.getNumeroDePartidas();
									int derrotas = jogador.getDerrotas();
									jogador.setDerrotas(derrotas + 1);
									jogador.setNumeroDePartidas(numeroDePartidas + 1);
									TextView numeroPartidas = (TextView) findViewById(R.id.numeroPartidas);
									numeroPartidas.setText(String.valueOf(jogador.getNumeroDePartidas()));
									zerarTabuleiro();
								}
								if (!ganhouAndroid && !hasButton()) {
									Toast.makeText(TabuleiroActivity.this, "Empatou", Toast.LENGTH_SHORT).show();
									int numeroDePartidas = jogador.getNumeroDePartidas();
									jogador.setNumeroDePartidas(numeroDePartidas + 1);
									TextView numeroPartidas = (TextView) findViewById(R.id.numeroPartidas);
									numeroPartidas.setText(String.valueOf(jogador.getNumeroDePartidas()));
									zerarTabuleiro();
								}
							}
						}
					}
				});
			}
		}
	}

	private Button jogaAndroid() {
		int linha = new Random().nextInt(3);
		int coluna = new Random().nextInt(3);
		while (!buttons[linha][coluna].getText().equals("") && hasButton()) {
			linha = new Random().nextInt(3);
			coluna = new Random().nextInt(3);
		}
		buttons[linha][coluna].setText("O");
		return buttons[linha][coluna];
	}

	private boolean hasButton() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (buttons[i][j].getText().equals("")) {
					return true;
				}
			}
		}
		return false;
	}

	private void zerarTabuleiro() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j].setText("");
			}
		}
	}

	private boolean verificaJogo(Button button) {
		boolean parar = false;
		int linha = 0;
		int coluna = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (button.getId() == buttons[i][j].getId()) {
					linha = i;
					coluna = j;
				}
			}
		}
		boolean ganhou = verificaColuna(button, parar, coluna);
		if (!ganhou) {
			ganhou = verificaLinha(button, parar, buttons[linha]);
		}
		if (!ganhou) {
			ganhou = verificaDiagonalPrinciapal(button, parar);
		}
		if (!ganhou) {
			ganhou = verificaDiagonalSecundaria(button, parar);
		}
		return ganhou;
	}

	private boolean verificaDiagonalSecundaria(Button button, boolean parar) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int soma = i + j;
				if (parar) {
					return !parar;
				}
				if (soma == 2 && !button.getText().equals(buttons[i][j].getText()) && button.getId() != buttons[i][j].getId()) {
					parar = true;
				}
			}
		}
		return !parar;
	}

	private boolean verificaDiagonalPrinciapal(Button button, boolean parar) {
		for (int i = 0; i < 3; i++) {
			if (parar) {
				return !parar;
			}
			if (!button.getText().equals(buttons[i][i].getText()) && button.getId() != buttons[i][i].getId()) {
				parar = true;
			}
		}
		return !parar;
	}

	private boolean verificaColuna(Button button, boolean parar, int coluna) {
		for (int i = 0; i < 3; i++) {
			if (parar) {
				return !parar;
			}
			if (!button.getText().equals(buttons[i][coluna].getText()) && button.getId() != buttons[i][coluna].getId()) {
				parar = true;
			}
		}
		return !parar;
	}

	private boolean verificaLinha(Button button, boolean parar, Button[] buttons) {
		for (int i = 0; i < 3; i++) {
			if (parar) {
				return !parar;
			}
			if (!button.getText().equals(buttons[i].getText()) && button.getId() != buttons[i].getId()) {
				parar = true;
			}
		}
		return !parar;
	}
}
