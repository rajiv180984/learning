package com.first.pattern;

public class Singleton {
    private String conf1;
    private static Singleton _instance;

    private Singleton(){
        this.conf1="test Conf1";
    }
    public static Singleton getInstance(){
        if(_instance==null){
            _instance = new Singleton();

        }
        return _instance;
    }

    @Override
    public String toString() {
        return "Singleton{" +
                "conf1='" + conf1 + '\'' +
                '}';
    }
}
