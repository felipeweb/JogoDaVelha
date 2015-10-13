package br.com.fiap.jogodavelha.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import br.com.fiap.jogodavelha.R;


public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		btnCadastrar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, CadastarAlunoActivity.class);
				startActivity(intent);
			}
		});
	}
}
