import org.junit.Test;
import ro.avs.ExchangeRateParser;
import ro.avs.bnr.model.Cube;
import ro.avs.bnr.model.DataSet;
import ro.avs.bnr.parser.BnrExchangeRateParser;
import ro.avs.oer.model.ExchangeRateData;
import ro.avs.oer.parser.OpenExchangeRateParser;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class OpenExchangeRateParserTest {

    @Test
    public void testBnrParser() {
        ExchangeRateParser<DataSet> exchangeRateParser = new BnrExchangeRateParser();
        DataSet dataSet = exchangeRateParser.getExchangeRateData();
        Cube cube = dataSet.getBody().getCube();
        assertTrue(isSameDate(cube.getDate(), new Date()));
        assertTrue(cube.getRates().length > 0);
    }

    @Test
    public void testOpenExchangeRateParser() {
        ExchangeRateParser<ExchangeRateData> exchangeRateParser = new OpenExchangeRateParser("TEST KEY");
        ExchangeRateData data = exchangeRateParser.getExchangeRateData();

        Date exchangeRateDate = new Date(data.getTimestamp());
        assertTrue(isSameDate(exchangeRateDate, new Date()));
        assertFalse(data.getRates().isEmpty());
    }

    private boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
    }
}
