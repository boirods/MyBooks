package top.rregio.mybooks.models;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.joda.time.DateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author rodrigo
 */
@Entity
public class Usuario {
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
    private DateTime dataRegistro; 

    public Usuario(String email, String senha, String nome){
        this.email=email;
        MessageDigest algo = MessageDigest.getInstance("MD5");
        byte messageDigest[]=algo.digest(senha.getBytes());

        this.senha=messageDigest.toString();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
        this.senha = senha;
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

    public DateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(DateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }
}
