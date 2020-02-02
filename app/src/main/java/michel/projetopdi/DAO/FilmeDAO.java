package michel.projetopdi.DAO;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import michel.projetopdi.dbHelper.ConnectionSQLite;
import michel.projetopdi.model.Filme;

public class FilmeDAO {
    private final ConnectionSQLite connectionSQLite;

    public FilmeDAO(ConnectionSQLite connectionSQLite) {
        this.connectionSQLite = connectionSQLite;
    }

    public Long salvar(Filme filme) {
        SQLiteDatabase db = connectionSQLite.getWritableDatabase();
        Long id = null;

        try {
            ContentValues values = new ContentValues();
            values.put("idfilme", filme.getIdFilme());
            values.put("nome", filme.getNome());
            values.put("duracao", filme.getDuracao());
            values.put("dtlancamento", filme.getDtLancamento() != null ? filme.getDtLancamento().toString() : null);
            values.put("valor", filme.getValor() != null ? filme.getValor().doubleValue() : null);
            values.put("classificacao", filme.getClassificacao());

            id = db.insert("filme", null, values);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }


}


