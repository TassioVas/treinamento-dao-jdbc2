package model.entites;

import java.io.Serializable;
import java.util.Date;

public class Estado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String sigla;
	private String nome;
	private Date date_criacao;
	
	public Estado() {
		
	}

	public Estado(Integer id, String sigla, String nome, Date date_criacao) {
		this.id = id;
		this.sigla = sigla;
		this.nome = nome;
		this.date_criacao = date_criacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDate_criacao() {
		return date_criacao;
	}

	public void setDate_criacao(Date date_criacao) {
		this.date_criacao = date_criacao;
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
		Estado other = (Estado) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Estado [id=" + id + ", sigla=" + sigla + ", nome=" + nome + ", date_criacao=" + date_criacao + "]";
	}
}
