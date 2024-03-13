package app.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	public Venda findByEndereco(String endereco);
	
	@Query("From Venda v WHERE v.vt=:vt" )
	public List<Venda> findByVt(int vt);
	
	
	
}