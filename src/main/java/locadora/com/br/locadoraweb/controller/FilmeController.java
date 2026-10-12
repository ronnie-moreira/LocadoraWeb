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
        model.addAttribute("Filmes", service.ListarFilmes());
        return "Filmes/listar";

    }
}