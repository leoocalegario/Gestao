package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.entity.Venda;
import app.repository.VendaRepository;

@Service //Classes anotadas com @Service são automaticamente identificadas e
//gerenciadas pelo contêiner do Spring. Isso significa que outras classes podem
//injetar instâncias desses serviços usando anotações como @Autowired, facilitando a injeção de dependências.
public class VendaService {

	@Autowired
	private VendaRepository vendaRepository; //instacia de objeto VendaRepository e atribuir a vendaRepository

	public String save(Venda venda) {
		this.vendaRepository.save(venda); //salvando a venda
		return venda.getProduto() + "salvo com sucesso"; 
	}

	public String update( Venda venda,Long id) {
		venda.setId(id);
		double valorTotal=calcularValorTotal(venda.getProduto());
		venda.setVt(valorTotal);
		venda=verificarStatus(venda);
		this.vendaRepository.save(venda);
		return venda.getProduto() + " Venda atualizada com sucesso";
	}

	public List<Venda> listAll() {
		return this.vendaRepository.findAll();
	}

	public Venda findById(long id) {

		Venda venda = this.vendaRepository.findById(id).get();
		return venda;

	}

	public String delete(Long id) {
		this.vendaRepository.deleteById(id);
		return "Venda deletada com sucesso!";
	}
	
	
	public Venda verificarStatus(Venda venda) {
		if(venda.getStatus().equals("CANCELADO")) {
			venda.setVt(0);
			venda.setProduto(null);
		}
		return venda;
	}
	
	public double calcularValorTotal(List<Produto> produtos) {
		double soma = 0;
		if(produtos!= null)
			for(int i=0;i<produtos.size();i++) {
				soma += produtos.get(i).getValor();
			}
		return soma;
	}

	public Venda findByEndereco(String endereco) {
		return this.vendaRepository.findByEndereco(endereco);
	}

	public List<Venda> findByVt(int vt) {
		return this.vendaRepository.findByVt(vt);
	}

	public Venda findByPagamento(String pagamento) {
		return this.vendaRepository.findByPagamento(pagamento);
	}

}