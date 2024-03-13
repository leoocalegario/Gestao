package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Cliente;
import app.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public String save(Cliente cliente) {
		this.clienteRepository.save(cliente);
		return cliente.getNome() + " salvo com sucesso";
	}

	public String update(long id, Cliente cliente) {
		cliente.setId(id);
		this.clienteRepository.save(cliente);
		return cliente.getNome() + " atualizado com sucesso";
	}

	public List<Cliente> listAll() {
		return this.clienteRepository.findAll();
	}

	public Cliente findById(long idCliente) {

		Cliente cliente = this.clienteRepository.findById(idCliente).get();
		return cliente;

	}

	public String delete(long idCliente) {
		this.clienteRepository.deleteById(idCliente);
		return "Cliente deletado com sucesso!";

	}

	public List<Cliente> findByNome(String nome) {
		return this.clienteRepository.findByNome(nome);
	}

	public List<Cliente> findByNomeLike(String nome) {
		return this.clienteRepository.findByNomeLike(nome);
	}

	public Cliente findByTelefone(String telefone) {
		Cliente cliente = clienteRepository.findByTelefone(telefone);
		return cliente;
	}

}
