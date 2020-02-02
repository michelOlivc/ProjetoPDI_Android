package michel.projetopdi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.math.BigDecimal;
import java.sql.Timestamp;

import michel.projetopdi.activities.FilmeActivity;
import michel.projetopdi.controller.FilmeController;
import michel.projetopdi.dbHelper.ConnectionSQLite;

import michel.projetopdi.model.Filme;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastroFilmes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionSQLite connectionSQLite = ConnectionSQLite.getInstanceConnection(this);

        this.btnCadastroFilmes = (Button) findViewById(R.id.btnCadastroFilme);
        this.btnCadastroFilmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FilmeActivity.class);
                startActivity(intent);
            }
        });
    }
}
