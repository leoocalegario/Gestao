package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Cliente;
import app.service.ClienteService;

@RestController //marcar uma classe como uma controller
@RequestMapping("/api/cliente")//usando para mapear uma classe ou um metodo na controller nesse caso uma url
public class ClienteController {

	@Autowired //anotacao para o objeto receber anotacoes externas
	private ClienteService clienteService;

	@PostMapping("save")//usado para mapear requisicoes https do tipo post
	public ResponseEntity<String> save(@RequestBody Cliente cliente) {
		try {
			String mensagem = this.clienteService.save(cliente);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Cliente cliente, @PathVariable long id) {
		try {

			String mensagem = this.clienteService.update(id, cliente);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
///
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
///
		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Cliente>> listAll() {

		try {

			List<Cliente> lista = this.clienteService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/findById/{idCliente}")
	public ResponseEntity<Cliente> findById(@PathVariable long idCliente) {

		try {

			Cliente cliente = this.clienteService.findById(idCliente);
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{idCliente}")
	public ResponseEntity<String> delete(@PathVariable long idCliente) {

		try {

			String mensagem = this.clienteService.delete(idCliente);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Deu esse erro aqui: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findByNome")
	public ResponseEntity<List<Cliente>> findByNome(@RequestParam String nome) {
		try {

			List<Cliente> lista = this.clienteService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findByNomeLike")
	public ResponseEntity<List<Cliente>> findByNomeLike(@RequestParam String nome) {
		try {

			List<Cliente> lista = this.clienteService.findByNomeLike(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findByTelefone")
	public ResponseEntity<Cliente> findByTelefone(@RequestParam String telefone) {
		try {

			Cliente cliente = this.clienteService.findByTelefone(telefone);
			return new ResponseEntity<>(cliente, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

}
