import org.junit.Test;
import ro.avs.bnr.model.Cube;
import ro.avs.bnr.parser.BnrExchangeRateParser;

import java.io.IOException;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BnrParserTest {

    private final BnrExchangeRateParser bnrExchangeRateParser = new BnrExchangeRateParser();

    @Test
    public void testBnrParser() throws IOException {
        Cube cube = bnrExchangeRateParser.getExchangeRatesCube();
        assertEquals(cube.getDate(), new Date());
        assertTrue(cube.getRates().length > 0);
    }
}
