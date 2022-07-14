package top.rregio.mybooks.models;

import java.util.UUID;

import javax.persistence.Entity;
import io.ebean.Model;

@Entity
public class Anotacao extends Model{
	private UUID id;
	private String anotacao;
	private Usuario usuario;
	private Capitulo capitulo;
	
	public Anotacao(String anotacao, Usuario usuario, Capitulo capitulo) {
		this.id=UUID.randomUUID();
		this.anotacao = anotacao;
		this.usuario = usuario;
		this.capitulo = capitulo;
	}
	
	public UUID getId() {
		return id;
	}
	public String getAnotacao() {
		return anotacao;
	}
	public void setAnotacao(String anotacao) {
		this.anotacao = anotacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	
}
