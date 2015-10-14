package br.com.fiap.jogodavelha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import br.com.fiap.jogodavelha.R;
import br.com.fiap.jogodavelha.models.Jogador;
import br.com.fiap.jogodavelha.models.Partida;

/**
 * Created by felipeweb on 10/13/15.
 */
public class CadastarAlunoActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_jogador);
		Button cadastrar = (Button) findViewById(R.id.btnAdicionar);
		cadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText inputLogin = (EditText) findViewById(R.id.cadastrarLogin);
				EditText inputSenha = (EditText) findViewById(R.id.cadastrarSenha);
				EditText inputNome = (EditText) findViewById(R.id.cadastrarNome);
				Jogador jogador = new Jogador(inputNome.getText().toString(), inputLogin.getText().toString(), inputSenha.getText().toString(), 0);
				Partida.adicionarJogador(jogador);
				Intent intent = new Intent(CadastarAlunoActivity.this, MainActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("toast", "faca Toast");
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
