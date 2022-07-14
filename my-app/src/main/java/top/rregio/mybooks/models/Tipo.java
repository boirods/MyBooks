package top.rregio.mybooks.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;

@Entity
public class Tipo extends Model{
	@Id
	private UUID id;
	private String editora;
	private String edicao;
	private TipoMidia tipoMidia;
	
	public Tipo() {
		this.id = UUID.randomUUID();
	}
	public Tipo(String editora, String edicao, TipoMidia tipoMidia) {
		this.id = UUID.randomUUID();
		this.editora = editora;
		this.edicao = edicao;
		this.tipoMidia = tipoMidia;
	}
	
	public UUID getId() {
		return id;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public TipoMidia getTipoMidia() {
		return tipoMidia;
	}
	public void setTipoMidia(TipoMidia tipo) {
		this.tipoMidia = tipo;
	}
	
	public enum TipoMidia{
		Revista, Livro, Link;
	}
}