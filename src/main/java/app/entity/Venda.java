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
import jakarta.validation.constraints.NotBlank;
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

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement para o ID
	private long id;

	@NotNull(message = "Endereço não pode ser nulo")
	private String endereco;
	@NotNull(message = "Vt não pode ser nulo")
	private double vt;
	@NotNull(message = "Pagamento não pode ser nulo")
	private String pagamento;
	@NotBlank
	private String status;

	@ManyToOne(cascade = CascadeType.MERGE) // cascade é a relacao Many, varias vendas podem estar atreladas a um cliente. 
	@JsonIgnoreProperties("venda")
	private Cliente cliente;

	@ManyToOne(cascade = CascadeType.MERGE) // relacao ManyToOne muitas vendas para um funcionario.
	@JsonIgnoreProperties("venda")
	private Funcionario funcionario;

	@ManyToMany(cascade = CascadeType.MERGE) // relacao ManyToMany muitas vendas para muitos produtos.
	@JoinTable(name = "produtos_venda")
	private List<Produto> produto;

}
