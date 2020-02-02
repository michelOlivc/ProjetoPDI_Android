package michel.projetopdi.controller;

import michel.projetopdi.DAO.FilmeDAO;
import michel.projetopdi.dbHelper.ConnectionSQLite;

import michel.projetopdi.model.Filme;

public class FilmeController {
    private final FilmeDAO filmeDAO;

    public FilmeController(ConnectionSQLite connectionSQLite) {
        filmeDAO = new FilmeDAO(connectionSQLite);
    }

    public Long salvar(Filme filme) {
        return this.filmeDAO.salvar(filme);
    }


}
