package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Funcionario;
import app.repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	public String save(Funcionario funcionario) {
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNome() + " salvo com sucesso";
	}

	public String update(long id, Funcionario funcionario) {
		funcionario.setId(id);
		this.funcionarioRepository.save(funcionario);
		return funcionario.getNome() + " atualizado com sucesso";
	}

	public List<Funcionario> listAll() {
		return this.funcionarioRepository.findAll();
	}

	public Funcionario findById(long idFuncionario) {

		Funcionario funcionario = this.funcionarioRepository.findById(idFuncionario).get();
		return funcionario;

	}

	public String delete(long idFuncionario) {
		this.funcionarioRepository.deleteById(idFuncionario);
		return "Funcionario deletado com sucesso!";

	}

	public Funcionario findByMatricula(int Matricula) {
		Funcionario funcionario = funcionarioRepository.findByMatricula(Matricula);
		return funcionario;
	}

	public List<Funcionario> findByIdade(int idade) {
		return this.funcionarioRepository.findByIdade(idade);

	}

	public List<Funcionario> findByNome(String nome) {
		return this.funcionarioRepository.findByNome(nome);
	}

}
