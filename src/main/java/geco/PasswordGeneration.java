package geco;

import java.nio.charset.Charset;
import java.util.Random;

public class PasswordGeneration {

    /**
     * Fonction de génération d'un mot de passe aléatoire de 8 caractères.
     * @return mot de passe généré.
     */
    public String getRandomPassword(){
        byte[] array = new byte[8];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        return generatedString;
    }

    /**
     * Constructeur qui ne fait rien
     */
    public PasswordGeneration(){

    }
}
