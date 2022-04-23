/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package top.rregio.mybooks.utils;

import java.util.Arrays;
import org.apache.commons.codec.binary.Base64;

/**
 * Classe com métodos uteis referentes ao usuário
 * @author rodrigo
 */
public class UsuarioUtilidades {

    /**
     * Retorna a senha a ser criptografada
     * @param senhaAEncriptar senha a ser encriptada
     * @return senha encriptografada
     */
    public static String senhaCriptografada(String senhaAEncriptar){
        return Base64.encodeBase64String(senhaAEncriptar.getBytes());
    }
    
    /**
     * retorna a senha descriptografada
     * @param senhaCriptografada é a senha criptografada e será decriptografada
     * @return senha já descriptografada
     */
    public static String senhaDescriptografada(String senhaCriptografada){
        byte[] decoded = Base64.decodeBase64(senhaCriptografada.getBytes());
        return Arrays.toString(decoded);
    }

    /**
     * Checa se o email possui ao menos um @
     * @param email a ser verificado
     * @return booleano se possui um @
     */
    public static boolean emailPossuiSomenteUmArroba(String email){
        boolean possuiUm = false;
        for(char letra : email.toCharArray()){
            if(letra == '@'){
                possuiUm=true;
            } else if(possuiUm && letra == '@'){
                return false;
            }
        }
        return possuiUm;
    }

    /**
     * Checa se o email possui ao menos um ponto
     * @param email a ser verificado
     * @return booleano se possui um ponto
     */
    public static boolean emailPossuiAoMenosUmPonto(String email){
        return email.contains(".");
    }

    /**
     * Checa se o email possui ao menos um ponto após o @
     * @param email a ser verificado
     * @return boolean se possui um ponto após o @
     */
    public static boolean emailPossuiAoMenosUmPontoApósArroba(String email) {
        if(emailPossuiSomenteUmArroba(email)){
            String[] emailDividido = email.split("@");
            return emailPossuiAoMenosUmPonto(emailDividido[1]);
        }
        return false;
    }

}
