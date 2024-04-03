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

import app.entity.Venda;
import app.service.VendaService;

@RestController
@RequestMapping("/api/venda")

public class VendaController {

	@Autowired
	private VendaService vendaService;

	@PostMapping("save")
	public ResponseEntity<String> save(@RequestBody Venda venda) {
		try {
			String mensagem = this.vendaService.save(venda);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@PathVariable Long id,@RequestBody Venda venda) {
		try {
			String mensagem = this.vendaService.update(venda, id);
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<String>("Ocorreu esse erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/listAll")
	public ResponseEntity<List<Venda>> listAll() {

		try {

			List<Venda> lista = this.vendaService.listAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}

	}

	@GetMapping("/findByIdVenda{idVenda}")
	public ResponseEntity<Venda> delete(@PathVariable Long id) {

		try {

			Venda venda = this.vendaService.findById(id);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{idVenda}")
	public ResponseEntity<String> delete(@PathVariable long id) {

		try {
			String mensagem = this.vendaService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Ocorreu esse erro: " + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/findByVt")
	public ResponseEntity<List<Venda>> findByVt(@RequestParam int vt) {
		try {

			List<Venda> lista = this.vendaService.findByVt(vt);
			return new ResponseEntity<>(lista, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findByEndereco")
	public ResponseEntity<Venda> findByEndereco(@RequestParam String endereco) {
		try {
			Venda venda = this.vendaService.findByEndereco(endereco);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/findByPagamento")
	public ResponseEntity<Venda> findByPagamento(@RequestParam String pagamento) {
		try {
			Venda venda = this.vendaService.findByEndereco(pagamento);
			return new ResponseEntity<>(venda, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
}