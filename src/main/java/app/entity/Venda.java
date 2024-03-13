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
	@NotNull(message = "Pagamento não pode ser nulo")
	private String pagamento;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("venda")
	private Cliente cliente;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JsonIgnoreProperties("venda")
	private Funcionario funcionario;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "produtos_venda")
	private List<Produto> produto;

}
