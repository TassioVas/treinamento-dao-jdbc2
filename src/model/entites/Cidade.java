package model.entites;

import java.io.Serializable;
import java.util.Date;

public class Cidade implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private Integer id_estado;
	private Date date_criacao;
	
	private Estado estado;
	
	public Cidade() {
		
	}

	public Cidade(Integer id, String nome, Integer id_estado, Date date_criacao, Estado estado) {
		this.id = id;
		this.nome = nome;
		this.id_estado = id_estado;
		this.date_criacao = date_criacao;
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId_estado() {
		return id_estado;
	}

	public void setId_estado(Integer id_estado) {
		this.id_estado = id_estado;
	}

	public Date getDate_criacao() {
		return date_criacao;
	}

	public void setDate_criacao(Date date_criacao) {
		this.date_criacao = date_criacao;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cidade other = (Cidade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
			return 
					
			"Cidade [id=" + id + ", nome=" + nome + ", id_estado=" + id_estado + ", date_criacao=" + date_criacao
					+ ", estado=" + estado + "]" ;

	}
	
}
