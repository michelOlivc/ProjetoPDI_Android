package michel.projetopdi.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnectionSQLite extends SQLiteOpenHelper {
    private static ConnectionSQLite CONNECTION;
    private static final int VERSAO_DB = 1;
    private static final String NOME_DB = "projeto_pdi";

    public ConnectionSQLite(Context context) {
        super(context, NOME_DB, null, VERSAO_DB);
    }

    public static ConnectionSQLite getInstanceConnection(Context context) {
        if(CONNECTION == null) {
            CONNECTION = new ConnectionSQLite(context);
        }
        return CONNECTION;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlTabelaFilmes = "CREATE TABLE IF NOT EXISTS filme" +
                "(" +
                "idfilme INTEGER PRIMARY KEY," +
                "nome TEXT," +
                "genero TEXT," +
                "duracao NUMERIC," +
                "dtlancamento TIMESTAMP," +
                "valor REAL," +
                "classificacao TEXT" +
                ")";

        db.execSQL(sqlTabelaFilmes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
