package geco;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private String loginTest;
    String voiture = "maVoiture";
    String maison = "maMaison";
    String femme = "maFemme";

    @Before
    public void setUp(){
        loginTest = "test";
    }

    @Test
    public void testLoginExists(){
        //GIVEN
        String[] emptyLogins = new String[0];
        LoginService empty = new LoginService(emptyLogins);
        //WHEN
        //THEN
        assertFalse("Login should not be found when it is not in the list", empty.loginExists(loginTest));

        //GIVEN
        String[] testLogin = new String[1];
        //WHEN
        testLogin[0] = loginTest;
        LoginService notempty = new LoginService(testLogin);
        //THEN
        assertTrue("Login should be found when it is in the login list", notempty.loginExists(loginTest));
    }

    @Test
    public void testAddLogin(){
        //GIVEN
        String[] emptyLogins = new String[0];
        LoginService empty = new LoginService(emptyLogins);
        //WHEN
        empty.addLogin(loginTest);
        //THEN
        assertTrue("Login is not added correctly to the list", empty.loginExists(loginTest));
    }

    @Test
    public void testFindAllLoginsStartingWith(){
        //GIVEN
        String[] notEmptyLogins = new String[5];
        List<String> expected = new ArrayList<>();
        expected.add(voiture);
        expected.add(maison);
        expected.add(femme);
        //WHEN
        notEmptyLogins[0] = voiture;
        notEmptyLogins[1] = maison;
        notEmptyLogins[2] = femme;
        notEmptyLogins[3] = "undeuxcamion";
        notEmptyLogins[4] = "undeuxtracteur";
        LoginService logins = new LoginService(notEmptyLogins);
        //THEN
        assertTrue(expected.containsAll(logins.findAllLoginsStartingWith("ma")));
        assertFalse(expected.containsAll(logins.findAllLoginsStartingWith("undeux")));
    }

    @Test
    public void testFindAllLogins(){
        //GIVEN
        String[] notEmptyLogins = new String[3];
        List<String> expected = new ArrayList<>();
        expected.add(voiture);
        expected.add(maison);
        expected.add(femme);
        //WHEN
        notEmptyLogins[0] = voiture;
        notEmptyLogins[1] = maison;
        notEmptyLogins[2] = femme;
        LoginService logins = new LoginService(notEmptyLogins);
        //THEN
        assertTrue(expected.containsAll(logins.findAllLogins()));
    }
}