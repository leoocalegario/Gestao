package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Produto findByNome(String nome);

	@Query("From Produto p WHERE p.valor=:valor")
	public List<Produto> findByValor(int valor);

	public List<Produto> findByCategoria(String categoria);

}