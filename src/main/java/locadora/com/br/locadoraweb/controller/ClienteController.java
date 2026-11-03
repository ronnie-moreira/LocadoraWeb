package locadora.com.br.locadoraweb.controller;

import locadora.com.br.locadoraweb.model.Cliente;
import locadora.com.br.locadoraweb.service.ClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    // 1. Listar todos os clientes
    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", service.listarClientes());
        return "clientes/listar"; // Caminho para o HTML de listagem
    }

    // 2. Abrir o formulário de cadastro
    @GetMapping("/novo")
    public String abrirFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/formulario"; // Caminho para o HTML do formulário
    }

    // 3. Salvar o cliente (cadastrar)
    @PostMapping("/salvar")
    public String salvarCliente(@ModelAttribute Cliente cliente, Model model) {
        try {
            service.cadastrarCliente(cliente);
            return "redirect:/clientes/novo?sucesso=true";
        } catch (IllegalArgumentException erro) {
            model.addAttribute("mensagemErro", erro.getLocalizedMessage());
            model.addAttribute("cliente", cliente);
            return "clientes/formulario";
        }
    }

    // 4. Excluir cliente
    @GetMapping("/excluir/{codigo}")
    public String excluirCliente(@PathVariable int codigo) {
        service.excluirCliente(codigo);
        return "redirect:/clientes";
    }

    // 5. Abrir formulário para editar cliente
    @GetMapping("/editar/{codigo}")
    public String editarCliente(@PathVariable int codigo, Model model) {
        Cliente cliente = service.buscarPorCodigo(codigo);
        model.addAttribute("cliente", cliente);
        return "clientes/formulario";
    }
}