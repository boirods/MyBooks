package top.rregio.mybooks.models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.ebean.Model;

@Entity
public class Categoria extends Model{
	@Id
	private UUID id;
	private String tema;
	
	public Categoria(String tema) {
		this.id = UUID.randomUUID();
		this.tema = tema;
	}
	
	public UUID getId() {
		return id;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
}
