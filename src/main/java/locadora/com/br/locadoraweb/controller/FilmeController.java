package locadora.com.br.locadoraweb.controller;

import locadora.com.br.locadoraweb.model.Filme;
import locadora.com.br.locadoraweb.service.LocadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private final LocadoraService service;

    public FilmeController(LocadoraService service) {
        this.service = service;
    }

    @GetMapping("/novo")
    public String abrirFormulario(Model model) {
        model.addAttribute("filme", new Filme());
        return "Filmes/Formulario";
    }

    @PostMapping("/salvar")
    public String salvarFilmes(@ModelAttribute Filme filme, Model model) {
        try {
            service.cadastrarFilme(filme);
            return "redirect:/filmes/novo?sucesso=true";
        } catch (IllegalArgumentException erro) {
            model.addAttribute("mensagemErro", erro.getLocalizedMessage());
            model.addAttribute("filme", filme); // Mantém os dados preenchidos no formulário
            return "filmes/formulario";
        }
    }
    @GetMapping
    public String listarFilmes(Model model){
        model.addAttribute("filmes", service.listarFilmes());
        return "filmes/listar";

    }

    // 1. Método para Excluir o Filme
    @GetMapping("/excluir/{id}") // ou /{codigo} dependendo de qual atributo você usa como identificador na classe Filme
    public String excluirFilme(@org.springframework.web.bind.annotation.PathVariable int id) {
        service.excluirFilme(id); // (Certifique-se de que o método de exclusão no seu Service se chama assim, ou ajuste para o nome correto)
        return "redirect:/filmes";
    }

    // 2. Método para Abrir o Formulário de Edição (Carregando os dados do filme)
    @GetMapping("/editar/{id}")
    public String editarFilme(@org.springframework.web.bind.annotation.PathVariable int id, Model model) {
        Filme filme = service.buscarPorId(id); // (Ajuste para o método do seu Service que busca por ID/código)
        model.addAttribute("filme", filme);
        return "Filmes/Formulario"; // Reaproveita o mesmo formulário de cadastro
    }
}