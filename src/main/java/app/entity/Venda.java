package app.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Endereço não pode ser nulo")
	private String endereco;
	@NotNull(message = "Vt não pode ser nulo")
	private int vt;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Cliente cliente;

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties("venda")
	private Funcionario funcionario;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "produtos_venda")
	private List<Produto> produto;

}
