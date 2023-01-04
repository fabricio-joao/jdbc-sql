package cursojdbc.conexaobancosdedados.entidades;


import java.sql.Date;
import java.util.Objects;

public class Vendedores {
	
	private Long id;
	private String nome;
	private String email;
	private Date nascimento;
	
	private Departamentos departamentos;
	
	public Vendedores() {
	
	}

    public Vendedores(Long id, String nome, String email, Date nascimento, Departamentos departamentos) {
		
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.nascimento = nascimento;
		this.departamentos = departamentos;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public Departamentos getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Departamentos departamentos) {
		this.departamentos = departamentos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vendedores other = (Vendedores) obj;
		return Objects.equals(id, other.id);
	}
}
