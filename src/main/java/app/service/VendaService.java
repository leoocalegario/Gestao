package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Venda;
import app.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository;
	
	public String save(Venda venda) {
		this.vendaRepository.save(venda);
		return venda.getProduto() + " Venda salva com sucesso";
	}
	
	public String update(long id, Venda venda) {
		venda.setId(id);
		this.vendaRepository.save(venda);
		return venda.getProduto() + " Venda atualizada com sucesso";
	}
	
	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}
	
	public Venda findById(long idVenda) {
		
		Venda venda = this.vendaRepository.findById(idVenda).get();
		return venda;
		
	}
	
	public String delete(long idVenda) {
		this.vendaRepository.deleteById(idVenda);
		return "Venda deletada com sucesso!";
	}
	
	public Venda findByEndereco(String endereco) {
		return this.vendaRepository.findByEndereco(endereco);
	}
	
	public List<Venda> findByVt(int vt) {
		return this.vendaRepository.findByVt(vt);
	}
	

}