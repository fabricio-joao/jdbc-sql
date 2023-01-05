package cursojdbc.conexaobancosdedados.entidades;

import java.io.Serializable;
import java.util.Objects;

public class Departamentos implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String setores;
	
	public Departamentos() {
		
	}

	public Departamentos(Integer id, String setores) {
		this.id = id;
		this.setores = setores;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSetores() {
		return setores;
	}

	public void setSetores(String setores) {
		this.setores = setores;
	}
	
	@Override
	public String toString() {
		return "Departamentos [id=" + id + ", setores=" + setores + "]";
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
		Departamentos other = (Departamentos) obj;
		return Objects.equals(id, other.id);
	}
}
