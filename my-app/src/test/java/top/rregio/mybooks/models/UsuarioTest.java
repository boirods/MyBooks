package top.rregio.mybooks.models;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import top.rregio.mybooks.utils.UsuarioUtilidades;

/**
 * Teste unitários para o usuário.
 * @author rodrigo
 */
public class UsuarioTest {
    String senha="teste";
    String emailValido="teste@teste.com.br";
    String emailInvalido1="teste2teste.com.br";//possui um arroba
    String emailInvalido2="teste@teste;com;br";
    String emailInvalido3="teste.teste2teste.com.br";
    String emailInvalido4="teste.teste@teste;com;br";

    @Test
    /**
     * Testa os dados de um usuário válido
     */
    public void testaUsuarioValido() throws NoSuchAlgorithmException{
        Usuario usuario = new Usuario(emailValido, senha, "Rodrigo Régio de Araújo");
        assertEquals("Rodrigo Régio de Araújo", usuario.getNome());
        assertNotEquals("Senha deve ser diferente da fornecida",usuario.getSenha(), "teste123");
        assertTrue("Email possui o caractere '@'", usuario.getEmail().contains("@"));
        assertTrue("Email possui ao menos um caractere '.'", UsuarioUtilidades.emailPossuiAoMenosUmPonto(usuario.getEmail()));
        assertTrue("Email possui somente um caractere '@'", UsuarioUtilidades.emailPossuiSomenteUmArroba(usuario.getEmail()));
        assertTrue("Email possui ponto após o arroba", UsuarioUtilidades.emailPossuiAoMenosUmPontoApósArroba(usuario.getEmail()));
        assertEquals("Foi criado hoje", usuario.getDataRegistro(), new Date().toString());
    }

    @Test
    /**
     * Testa os dados de um usuário inválido
     */
    public void testaUsuarioInvalido() throws NoSuchAlgorithmException{
        Usuario u=new Usuario();
        u.setSenha(senha);
        assertNotEquals("Senha do usuario diferentes da variavel senha", u.getSenha(), senha);
        assertFalse("email nao possui pontos", UsuarioUtilidades.emailPossuiAoMenosUmPonto(emailInvalido2));
        assertFalse("email nao possui pontos", UsuarioUtilidades.emailPossuiAoMenosUmPonto(emailInvalido2));
        assertFalse("email não possui arroba", UsuarioUtilidades.emailPossuiSomenteUmArroba(emailInvalido1));
    }
    
    @Test
    /**
     * Testa a cobertura de códigos (cobrindo todos os códigos referente a um usuário.
     */
    public void cobrindoCodeCoverage() throws NoSuchAlgorithmException{
        Usuario u = new Usuario();
        u.setBiografia("Realizando testes na testolandia");
        u.setEmail(emailValido);
        u.setNome("Teste");
        u.setSenha(senha);
        
        assertNotEquals("Biografia diferente de ''!", u.getBiografia(),"");
        assertEquals("Senha igual", UsuarioUtilidades.senhaDescriptografada(u.getSenha()).equals(senha));
        assertNotEquals("Email diferente de ''!", u.getEmail(), "");
        assertNotEquals("Senha diferente de ''!", u.getSenha(), "");
        assertNotEquals("Nome diferente de ''!", u.getNome(), "");
        assertNotNull(u.getUuid());
    }
}
