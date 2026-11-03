package locadora.com.br.locadoraweb.service;

import locadora.com.br.locadoraweb.model.Filme;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocadoraService {

    private final List<Filme> filmes;
    private int proximoCodigoFilme; // Usando int primitivo

    public LocadoraService() {
        filmes = new ArrayList<>();
        proximoCodigoFilme = 1;
    }

    public void cadastrarFilme(Filme filme) {
        filme.setCodigo(proximoCodigoFilme);
        proximoCodigoFilme++;
        filmes.add(filme);
    }

    public List<Filme> listarFilmes() {
        return new ArrayList<>(filmes);
    }

    public Filme buscarFilmePorCodigo(int codigo) { // Recebe int
        for (Filme filme : filmes) {
            if (filme.getCodigo() == codigo) { // Usando '==' para comparar int primitivo
                return filme;
            }
        }
        return null;
    }

    public void excluirFilme(int codigo) { // Recebe int
        filmes.removeIf(filme -> filme.getCodigo() == codigo); // Usando '=='
    }

    public Filme buscarPorId(int codigo) { // Recebe int
        return buscarFilmePorCodigo(codigo);
    }
}