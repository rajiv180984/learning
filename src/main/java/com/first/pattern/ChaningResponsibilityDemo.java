package com.first.pattern;

public class ChaningResponsibilityDemo {

    public static void main(String aap[]) {
        ATMDispense atm = new ATMDispense();
        Currency curreny = new Currency();
        curreny.setAmount(150);
        atm.dispenseAmount(curreny);
    }
}

class Currency {
    int amount;

    public int getAmount() {
        return amount;
    }

    public void setAmount(final int amount) {
        this.amount = amount;
    }
}

interface Dispensor {
    public void dispenseAmount(Currency currency);

    public void setDispenseChain(final Dispensor dispenseChain);
}

class Dispense100Notes implements Dispensor {

    Dispensor dispenseChain;

    public void setDispenseChain(final Dispensor dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispenseAmount(Currency currency) {
        if (currency.amount >= 100) {
            int notes = currency.amount / 100;
            currency.setAmount(currency.amount % 100);
            System.out.println(" 100 Note Dispense :" + notes);
            this.dispenseChain.dispenseAmount(currency);
        }
    }
}

class Dispense20Notes implements Dispensor {

    Dispensor dispenseChain;

    public void setDispenseChain(final Dispensor dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispenseAmount(Currency currency) {
        if (currency.amount >= 20) {
            int notes = currency.amount / 20;
            currency.setAmount(currency.amount % 20);
            System.out.println(" 20 Note Dispense :" + notes);
            this.dispenseChain.dispenseAmount(currency);
        }
    }
}

class Dispense10Notes implements Dispensor {

    Dispensor dispenseChain;

    public void setDispenseChain(final Dispensor dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispenseAmount(Currency currency) {
        if (currency.amount >= 10) {
            int notes = currency.amount / 10;
            currency.setAmount(currency.amount % 10);
            System.out.println(" 10 Note Dispense :" + notes);
            this.dispenseChain.dispenseAmount(currency);
        }
    }
}

class Dispense5Notes implements Dispensor {

    Dispensor dispenseChain;

    public void setDispenseChain(final Dispensor dispenseChain) {
        this.dispenseChain = dispenseChain;
    }

    @Override
    public void dispenseAmount(Currency currency) {
        if (currency.amount >= 5) {
            int notes = currency.amount / 5;
            currency.setAmount(currency.amount % 5);
            System.out.println(" 5 Note Dispense :" + notes);
            this.dispenseChain.dispenseAmount(currency);
        }
    }
}


class ATMDispense implements Dispensor {
    private Dispensor dispensor;

    @Override
    public void setDispenseChain(final Dispensor dispenseChain) {
        this.dispensor = dispensor;
    }
    public ATMDispense() {
        this.dispensor = new Dispense100Notes();
        ;
        Dispense20Notes dispense20Notes = new Dispense20Notes();
        Dispense10Notes dispense10Notes = new Dispense10Notes();
        Dispense5Notes dispense5Notes = new Dispense5Notes();

        this.dispensor.setDispenseChain(dispense20Notes);
        dispense20Notes.setDispenseChain(dispense10Notes);
        dispense10Notes.setDispenseChain(dispense5Notes);
    }

    @Override
    public void dispenseAmount(final Currency currency) {

        if (currency.amount > 5) {
            System.out.println(" We can withdraw Amount");
            dispensor.dispenseAmount(currency);

        }
    }


}

