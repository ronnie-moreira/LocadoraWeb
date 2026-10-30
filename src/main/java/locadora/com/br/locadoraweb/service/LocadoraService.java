package locadora.com.br.locadoraweb.service;

import locadora.com.br.locadoraweb.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

    @Service //Faz Spring Boot criar e gerenciar um único objeto


    public class LocadoraService {


    private final List<Filme> filmes;
    private int proximoCodigoFilme;

    public LocadoraService() {

        filmes = new ArrayList<>();  //
        proximoCodigoFilme = 1;
    }

    public void cadastrarFilme(Filme filme) {

        filme.setCodigo(proximoCodigoFilme);
        proximoCodigoFilme++;
        filmes.add(filme);
    }

    public List<Filme> ListarFilmes() {
        return new ArrayList<>(filmes);
    }

    public Filme buscarFilmePorCodigo(int codigo) {
        for (Filme filme : filmes) {  //Para cada reptição ele apresenta um filme pra mim e se ele não encontrar ele retorna NULL;
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }

}







