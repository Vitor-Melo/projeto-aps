package model;

import java.io.Serializable;
import java.util.Date;

public class Relatorio implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String endereco;
	private String CEP;
	private String titulo;
	private String descricao;
	private Integer usuarioId;
	private Date data;
	
	public Relatorio() {
		
	}
	
	public Relatorio(String endereco, String CEP, String titulo, String descricao, Integer usuarioId, Date data) {
		this.endereco = endereco;
		this.CEP = CEP;
		this.titulo = titulo;
		this.descricao = descricao;
		this.usuarioId = usuarioId;
		this.data = data;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public Integer getUsuarioId() {
		return usuarioId;
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
		Relatorio other = (Relatorio) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		return true;
	}

	@Override
	public String toString() {
		return "Relatorio [id=" + id + ", endereco=" + endereco + ", CEP=" + CEP + ", descricao=" + descricao + "]";
	}
}