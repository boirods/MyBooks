package top.rregio.mybooks.models;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.ebean.Model;
import top.rregio.mybooks.utils.UsuarioUtilidades;
/**
 * Representa um usuário no sistema mybook
 * @author rodrigo
 */
@Entity
public class Usuario extends Model {
    @Column
    private UUID uuid;
    @Column
    private String email;
    @Column
    private String senha;
    @Column
    private String nome;
    @Column
    private String biografia;
    @Column
    private String dataRegistro;

    public Usuario(){
        this.uuid=UUID.randomUUID();
        this.dataRegistro=new Date().toString();
    } 

    public Usuario(String email, String senha, String nome){
        this.uuid = UUID.randomUUID();
        this.email=email;
        this.senha=UsuarioUtilidades.senhaCriptografada(senha);
        this.nome=nome;
        this.dataRegistro = new Date().toString();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha= UsuarioUtilidades.senhaCriptografada(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }
}
