package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Produto;
import app.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public String save(Produto produto) {
		this.produtoRepository.save(produto);
		return produto.getNome() + " Produto salvo com sucesso";
	}

	public String update(long id, Produto produto) {
		produto.setId(id);
		this.produtoRepository.save(produto);
		return produto.getNome() + " Produto atualizado com sucesso";
	}

	public List<Produto> listAll() {
		return this.produtoRepository.findAll();
	}

	public Produto findById(long idProduto) {
		Produto produto = this.produtoRepository.findById(idProduto).get();
		return produto;
	}

	public String delete(long idProduto) {
		this.produtoRepository.deleteById(idProduto);
		return "Produto deletado com sucesso!";
	}

	public Produto findByNome(String nome) {
		return this.produtoRepository.findByNome(nome);
	}

	public List<Produto> findByValor(int valor) {
		return this.produtoRepository.findByValor(valor);
	}

	public List<Produto> findByCategoria(String categoria) {
		return this.produtoRepository.findByCategoria(categoria);
	}

}