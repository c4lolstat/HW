package com.epam.domain;

/**
 * Created by Zoltan_Biro on 6/15/2017.
 */
public class Creditcard {

    private String creditCardNumber = "";
    private Integer cvc = 0;
    private ExpirationDate expirationDate = new ExpirationDate();

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public ExpirationDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ExpirationDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
