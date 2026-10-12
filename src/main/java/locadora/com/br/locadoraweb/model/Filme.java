package locadora.com.br.locadoraweb.model;
/*
import java.lang.foreign.ValueLayout;

/*
Representa um filme cadastrado na locadora
 */


    public class Filme {
    private int codigo;                   /* Esses são os atributos do Code, criando uma classe privada */
    private String nome;
    private String genero;
    private boolean alugado;


    public Filme() {
        this.alugado = false;
    }

    public Filme(int codigo, String nome, String genero) {

        this.codigo = codigo; /* Referencia o atributo próprio */
        this.nome = nome;
        this.genero = genero;
        this.alugado = false;
    }

    //    consultar codigo
    public int getCodigo() {
        return codigo;
    }

    // define o codigo como automatico
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // permite ler
    public String getNome() {
        return nome;
    }

    // permite alterar o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }  /* Serve para alterar os valores e o Get para buscar valores*/

    public boolean isAlugado() {
        return alugado;
    }

    // muda o estado do filme se ele ta alugado ou não
    public void alugar() {

        if (alugado) {
            throw new IllegalArgumentException("Filme está alugado.\n"); /* */
        }

        alugado = true;
    }

    public void devolver() {
        alugado = false;
    }

    @Override
    public String toString() {

        String status = alugado ? "Alugado" : "Disponivel";  /* Estrutura condicional */

                return
                "Codigo: " + codigo
                + "| Nome: " + nome
                + "| Gênero: " + genero
                + "| Status: " + status;

    }
}
