package locadora.com.br.locadoraweb.service;

import locadora.com.br.locadoraweb.model.Cliente;
import locadora.com.br.locadoraweb.model.Filme;
import locadora.com.br.locadoraweb.model.Locacao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocacaoService {

    private final List<Locacao> locacoes;
    private int proximoCodigoLocacao;

    private final LocadoraService filmeService;
    private final ClienteService clienteService;

    public LocacaoService(LocadoraService filmeService, ClienteService clienteService) {
        locacoes = new ArrayList<>();
        proximoCodigoLocacao = 1;
        this.filmeService = filmeService;
        this.clienteService = clienteService;
    }

    public void alugarFilme(int codigoCliente, int codigoFilme) {
        Cliente cliente = clienteService.buscarPorCodigo(codigoCliente);
        Filme filme = filmeService.buscarFilmePorCodigo(codigoFilme);

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não encontrado!");
        }
        if (filme == null) {
            throw new IllegalArgumentException("Filme não encontrado!");
        }

        // Altera o estado do filme para alugado usando o método da sua classe Filme
        filme.alugar();

        Locacao locacao = new Locacao();
        locacao.setCodigo(proximoCodigoLocacao++);
        locacao.setCliente(cliente);
        locacao.setFilme(filme);

        locacoes.add(locacao);
    }

    public List<Locacao> listarLocacoes() {
        return new ArrayList<>(locacoes);
    }

    public Locacao buscarPorCodigo(int codigo) {
        for (Locacao locacao : locacoes) {
            if (locacao.getCodigo() == codigo) {
                return locacao;
            }
        }
        return null;
    }

    public void devolverFilme(int codigoLocacao) {
        Locacao locacao = buscarPorCodigo(codigoLocacao);
        if (locacao != null) {
            locacao.getFilme().devolver(); // Devolve o filme chamando o método da classe Filme
            locacao.setStatus("DEVOLVIDO");
        }
    }
}