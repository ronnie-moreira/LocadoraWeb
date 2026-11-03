package locadora.com.br.locadoraweb.service;

import locadora.com.br.locadoraweb.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private final List<Cliente> clientes;
    private int proximoCodigoCliente;

    public ClienteService() {
        clientes = new ArrayList<>();
        proximoCodigoCliente = 1;
    }

    // Cadastrar novo cliente gerando código automático
    public void cadastrarCliente(Cliente cliente) {
        // Se o cliente já tiver código (edição), atualiza; senão, cria um novo
        if (cliente.getCodigo() == 0) {
            cliente.setCodigo(proximoCodigoCliente);
            proximoCodigoCliente++;
            clientes.add(cliente);
        } else {
            // Lógica de atualização caso seja edição
            Cliente clienteExistente = buscarPorCodigo(cliente.getCodigo());
            if (clienteExistente != null) {
                clienteExistente.setNome(cliente.getNome());
                clienteExistente.setCpf(cliente.getCpf());
                clienteExistente.setTelefone(cliente.getTelefone());
            }
        }
    }

    // Listar todos os clientes
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    // Buscar cliente por código
    public Cliente buscarPorCodigo(int codigo) {
        for (Cliente cliente : clientes) {
            if (cliente.getCodigo() == codigo) {
                return cliente;
            }
        }
        return null;
    }

    // Excluir cliente por código
    public void excluirCliente(int codigo) {
        clientes.removeIf(cliente -> cliente.getCodigo() == codigo);
    }
}