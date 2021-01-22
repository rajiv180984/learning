package com.first.pattern;

public class FactoryDemo {
}

interface Sender{
 String sendMessage(String msg);
}

class Email implements Sender{

    @Override
    public String sendMessage(final String msg) {
        return null;
    }
}

class SMS implements Sender{

    @Override
    public String sendMessage(final String msg) {
        return null;
    }
}

class Factory{
    private  static Sender sender;
    public Sender getInstance(String a){
        if(a.equals("SMS")){
            return new SMS();
        }else{
            return new Email();
        }
    }
}


// first get Factory
// then get instance from particular factory

