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
        int integer = Integer.parseInt(string);
        return integer;
    }

    static float stringToFloat(String string) {
        float floater = Float.parseFloat(string);
        return floater;
    }
}
