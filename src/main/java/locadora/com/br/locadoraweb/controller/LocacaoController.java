package locadora.com.br.locadoraweb.controller;

import locadora.com.br.locadoraweb.service.ClienteService;
import locadora.com.br.locadoraweb.service.LocacaoService;
import locadora.com.br.locadoraweb.service.LocadoraService; // Ajuste para o nome correto do seu service de filmes se for diferente
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/locacoes")
public class LocacaoController {

    private final LocacaoService locacaoService;
    private final ClienteService clienteService;
    private final LocadoraService filmeService; // Se o seu service de filmes se chama FilmeService, ajuste aqui

    public LocacaoController(LocacaoService locacaoService, ClienteService clienteService, LocadoraService filmeService) {
        this.locacaoService = locacaoService;
        this.clienteService = clienteService;
        this.filmeService = filmeService;
    }

    // 1. Listar todas as locações
    @GetMapping
    public String listarLocacoes(Model model) {
        model.addAttribute("locacoes", locacaoService.listarLocacoes());
        return "locacoes/listar";
    }

    // 2. Abrir formulário para realizar um novo aluguel
    @GetMapping("/novo")
    public String abrirFormularioLocacao(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        model.addAttribute("filmes", filmeService.listarFilmes()); // Ajuste para o método que lista os filmes no seu service
        return "locacoes/formulario";
    }

    // 3. Salvar/Efetivar a locação
    @PostMapping("/salvar")
    public String alugarFilme(@RequestParam int codigoCliente, @RequestParam int codigoFilme, Model model) {
        try {
            locacaoService.alugarFilme(codigoCliente, codigoFilme);
            return "redirect:/locacoes?sucesso=true";
        } catch (IllegalArgumentException erro) {
            model.addAttribute("mensagemErro", erro.getLocalizedMessage());
            model.addAttribute("clientes", clienteService.listarClientes());
            model.addAttribute("filmes", filmeService.listarFilmes());
            return "locacoes/formulario";
        }
    }

    // 4. Devolver filme
    @GetMapping("/devolver/{codigo}")
    public String devolverFilme(@PathVariable int codigo) {
        locacaoService.devolverFilme(codigo);
        return "redirect:/locacoes";
    }
}