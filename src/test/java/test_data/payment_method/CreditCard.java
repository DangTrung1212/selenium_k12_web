package test_data.payment_method;

import java.util.Calendar;
import java.util.GregorianCalendar;

public enum CreditCard {
    VISA("Visa", "000000", "11111"),
    MASTER_CARD("Master card", "22222", "3333333"),
    AMEX("Amex", "22222", "3333333"),
    DISCOVER("Discover", "22222", "3333333");

    private final String creditCardStr;
    private final String expiredMonth;
    private final String creditCardCode;
    private final String expiredYear;
    private final String creditCardNum;


    CreditCard(String creditCardStr, String creditCardCode, String creditCardNum) {
        this.creditCardNum = creditCardNum;
        this.creditCardStr = creditCardStr;
        this.creditCardCode = creditCardCode;
        Calendar calendar = new GregorianCalendar();
        this.expiredMonth = String.valueOf(calendar.get(Calendar.MONTH) + 1);
        this.expiredYear = String.valueOf(calendar.get(Calendar.YEAR) + 1);
    }

    public String getCreditCardStr() {
        return creditCardStr;
    }

    public String getCreditCardNum() {
        return creditCardNum;
    }

    public String getExpiredMonth() {
        return expiredMonth;
    }

    public String getCreditCardCode() {
        return creditCardCode;
    }

    public String getExpiredYear() {
        return expiredYear;
    }
}
