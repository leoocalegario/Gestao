package app.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long> {

	public Venda findByEndereco(String endereco); // metodo de consulta que puxa o endereco

	@Query("From Venda v WHERE v.vt=:vt") // metodo de consulta JPQL que puxa o vt da venda
	public List<Venda> findByVt(int vt);

	public Venda findByPagamento(String pagamento); // metodo de consulta que puxa os metodos de pagamento e as suas vendas

}