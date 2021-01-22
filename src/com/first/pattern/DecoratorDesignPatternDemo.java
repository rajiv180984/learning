package com.first.pattern;

public class DecoratorDesignPatternDemo {

    public static void main(String aa[]){
      CreditCard card = new CreditCard("AMEX", "Internation ", 10000);
      Decorator decorator = new CountryWiseDecorator(card);
      decorator.awardPoint("US");
    }
}

class CreditCard{

    private String cardName;
    private String description;
    private int monthlyExpense;
    public CreditCard(final String cardName, final String description, final int monthlyExpense) {
        this.cardName = cardName;
        this.description = description;
        this.monthlyExpense =monthlyExpense;
    }

    public int getMonthlyExpense() {
        return monthlyExpense;
    }

    public void setMonthlyExpense(final int monthlyExpense) {
        this.monthlyExpense = monthlyExpense;
    }
}

abstract class Decorator{

    public abstract int awardPoint(String country);

}

class CountryWiseDecorator extends Decorator{

    private CreditCard creditCard;


    public CountryWiseDecorator(final CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public int awardPoint(String country) {
        if(country.equals("USA")){

            return 1000000;
        }
        return 0;
    }
}