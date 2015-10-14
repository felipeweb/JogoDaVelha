package br.com.fiap.jogodavelha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import br.com.fiap.jogodavelha.R;
import br.com.fiap.jogodavelha.models.Jogador;
import br.com.fiap.jogodavelha.models.Partida;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		Button btnLogar = (Button) findViewById(R.id.btnLogar);
		savedInstanceState = getIntent().getExtras();
		if (savedInstanceState != null && savedInstanceState.get("toast") != null) {
			Toast.makeText(this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
		}
		btnCadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CadastarAlunoActivity.class);
				startActivity(intent);
			}
		});
		btnLogar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText login = (EditText) findViewById(R.id.login);
				EditText senha = (EditText) findViewById(R.id.senha);
				Jogador jogador = Partida.getJogadorByLoginAndSenha(login.getText().toString(), senha.getText().toString());
				if (jogador == null) {
					Toast.makeText(MainActivity.this, "Login ou senha incorretos", Toast.LENGTH_SHORT).show();
				} else {
					Intent intent = new Intent(MainActivity.this, TabuleiroActivity.class);
					intent.putExtra("jogador", jogador);
					startActivity(intent);
				}
			}
		});
	}
}

