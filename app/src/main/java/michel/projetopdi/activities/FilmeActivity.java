package michel.projetopdi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

import michel.projetopdi.R;
import michel.projetopdi.controller.FilmeController;
import michel.projetopdi.dbHelper.ConnectionSQLite;
import michel.projetopdi.model.Filme;

public class FilmeActivity extends AppCompatActivity {

    private EditText editIdFilme;
    private EditText editNome;
    private EditText editGenero;
    private EditText editClassificacao;
    private EditText editDuracao;
    private EditText editDtLancamento;
    private EditText editValor;

    private Button btnSalvarFilme;

    private Filme filme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme);

        editIdFilme = (EditText) findViewById(R.id.editIdFilme);
        editNome = (EditText) findViewById(R.id.editNome);
        editGenero = (EditText) findViewById(R.id.editGenero);
        editClassificacao = (EditText) findViewById(R.id.editClassificacao);
        editDuracao = (EditText) findViewById(R.id.editDuracao);
        editDtLancamento = (EditText) findViewById(R.id.editDtLancamento);
        editValor = (EditText) findViewById(R.id.editValor);

        btnSalvarFilme = (Button) findViewById(R.id.btnSalvarFilme);

        this.clickOnBtnSalvarListener();
    }

    private void clickOnBtnSalvarListener() {
        this.btnSalvarFilme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Filme filme = getDadosFilmeDoFormulario();
                if (filme != null) {
                    FilmeController filmeController = new FilmeController(ConnectionSQLite.getInstanceConnection(FilmeActivity.this));
                    Long resultado = filmeController.salvar(filme);

                    if (resultado > 0) {
                        Toast.makeText(FilmeActivity.this,
                                "Produto salvo com sucesso!",
                                Toast.LENGTH_LONG).show();
                    } else if (resultado == null || resultado != null && resultado <= 0) {
                        Toast.makeText(FilmeActivity.this,
                                "Produto não pode ser salvo.",
                                Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(FilmeActivity.this,
                            "Todos os campos são obrigatórios",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private Filme getDadosFilmeDoFormulario() {
        Filme form = new Filme();

        try {
            if(!isCamposObrigatoriosPreenchidos(this)) {
                return null;
            }

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

            form.setIdFilme(Long.parseLong(getValue(editIdFilme)));
            form.setNome(getValue(editNome));
            form.setGenero(getValue(editGenero));
            form.setClassificacao(getValue(editClassificacao));
            form.setDuracao(Double.parseDouble(getValue(editDuracao)));

            Timestamp dtLancamento = Timestamp.valueOf(getValue(editDtLancamento) + " 00:00");
            form.setDtLancamento(dtLancamento);

            form.setValor(strToBigDecimal(getValue(editValor)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return form;
    }

    private String getValue(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            return null;
        }
        return editText.getText().toString();
    }

    private BigDecimal strToBigDecimal(String str) throws Exception {
        str = str.replace(".", "").replace(",", ".");

        boolean isNumber = true;
        for (char c : str.toCharArray()) {
            String pattern = "0123456789,";
            if (pattern.indexOf(c) == -1) {
                isNumber = false;
                break;
            }
        }

        if (!isNumber) {
            throw new Exception("Erro: O texto não corresponde à um número.");
        }

        return new BigDecimal(str);
    }

    private Boolean isCamposObrigatoriosPreenchidos(FilmeActivity activity) throws Exception {
        Object object = activity.getClass();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(object);
            if (value == null) {
                return false;
            }
        }

        return true;
    }
}
