package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LoginGeneratorTest {

    LoginService ls;
    LoginGenerator lg;

    @Before
    public void setUp(){
        ls = new LoginService(new String[] {"JROL", "BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        lg = new LoginGenerator(ls);
    }

    @Test
    public void testNomCourt(){
        lg.generateLoginForNomAndPrenom("DU", "Paul");
        assertTrue("Paul DU login should be PDU", ls.loginExists("PDU"));
    }

    @Test
    public void testGenerateLoginForNomAndPrenom() {
        lg.generateLoginForNomAndPrenom("DURAND", "Paul");
        assertTrue("Paul DURAND login should be PDUR", ls.loginExists("PDUR"));
    }

    @Test
    public void testAjoutChangeant(){
        lg.generateLoginForNomAndPrenom("ROLLING", "Jean");
        assertTrue("Jean ROLLING login should be JROL1", ls.loginExists("JROL1"));
    }

    @Test
    public void testAjoutAccent(){
        lg.generateLoginForNomAndPrenom("Dùrand", "Paul");
        assertTrue("Paul Dùrand login should be PDUR", ls.loginExists("PDUR"));
    }

    @Test
    public void testTroisiemeAjout(){
        lg.generateLoginForNomAndPrenom("RALLING", "John");
        assertTrue("New John Ralling should be JRAL2", ls.loginExists("JRAL2"));
    }
}