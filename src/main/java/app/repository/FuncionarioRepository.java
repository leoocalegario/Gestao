package app.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	public Funcionario findByMatricula(int matricula);

	@Query("From Funcionario f WHERE f.nome LIKE %:nome% ")
	public List<Funcionario> findByNome(String nome);

	public List<Funcionario> findByIdade(int idade);

}