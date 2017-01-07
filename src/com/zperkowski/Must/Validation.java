package com.zperkowski.Must;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

/**
 * Changes one format to another
 */
class Validation {
    static BigDecimal stringToBigDecimal(String string) {
        BigDecimal bigDecimal = null;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        try {
            bigDecimal = (BigDecimal) decimalFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bigDecimal;
    }

    static int stringToInt(String string) {
        if (!string.trim().equals(""))
            return Integer.parseInt(string);
        else
            return 0;
    }

    static float stringToFloat(String string) {
        if (!string.trim().equals(""))
            return Float.parseFloat(string);
        else
            return 0.0f;
    }
}
