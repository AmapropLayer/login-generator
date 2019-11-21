package geco;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordGenerationTest {

    PasswordGeneration pg;

    @Before
    public void setUp(){
        pg = new PasswordGeneration();
    }


    @Test
    public void getRandomPassword() {
        assertTrue("Password should be 8 chars long", pg.getRandomPassword().length() == 8);
    }
}