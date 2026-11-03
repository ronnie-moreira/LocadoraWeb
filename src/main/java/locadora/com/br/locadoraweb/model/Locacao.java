package locadora.com.br.locadoraweb.model;

import java.time.LocalDate;

public class Locacao {

    private int codigo;
    private Cliente cliente;
    private Filme filme;
    private LocalDate dataLocacao;
    private LocalDate dataDevolucaoPrevista;
    private String status; // Ex: "ATIVO", "DEVOLVIDO"

    // Construtor vazio
    public Locacao() {
        this.dataLocacao = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(3); // 3 dias de prazo padrão
        this.status = "ATIVO";
    }

    // Construtor completo
    public Locacao(int codigo, Cliente cliente, Filme filme) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = LocalDate.now();
        this.dataDevolucaoPrevista = LocalDate.now().plusDays(3);
        this.status = "ATIVO";
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public void setDataDevolucaoPrevista(LocalDate dataDevolucaoPrevista) {
        this.dataDevolucaoPrevista = dataDevolucaoPrevista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}