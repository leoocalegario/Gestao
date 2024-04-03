package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Cliente {

	@Id //identifica como primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //basicamente um autoincrement
	private long id;
	
	@NotNull(message = "Nome não pode ser nulo")
	private String nome;
	
	@NotNull(message = "CPF não pode ser nulo")
	private String cpf;

	@NotNull(message = "Idade não pode ser nulo")
	private int idade;
	
	@NotNull(message = "Telefone não pode ser nulo")
	private String telefone;

	@OneToMany(mappedBy = "cliente")
	@JsonIgnoreProperties("cliente")//determinadas propriedades de uma classe devem ser ignoradas durante o processo de serializaçao
	private List<Venda> venda;

}
