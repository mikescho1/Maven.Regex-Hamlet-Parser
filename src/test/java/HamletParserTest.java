import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
       String test = hamletParser.changeHamletToLeon(hamletText);
        Assert.assertFalse(hamletParser.findHamlet(test));

    }

    @Test
    public void testChangeHoratioToTariq() {
        String test = hamletParser.changeHoratioToTariq(hamletText);


        Assert.assertFalse(hamletParser.findHoratio(test));

    }

    @Test
    public void testFindHoratio() {
        Assert.assertTrue(hamletParser.findHoratio(hamletText));
        Assert.assertFalse(hamletParser.findHamlet("Horatio"));

    }

    @Test
    public void testFindHamlet() {
        Assert.assertTrue(hamletParser.findHamlet(hamletText));
        Assert.assertTrue(hamletParser.findHamlet("HAMLET"));
    }
}