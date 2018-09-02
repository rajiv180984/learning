package com.design;


public class Singletone {
    private String field;
    private Singletone(){
        this.field = "test";
    }
    private static Singletone _ins = null;
    // make it thread-safe using syncronize but it should not be at method level. because there performance issue.
    // tread -safety required because at same time more than thread can invoke method and create multiple instance.
    // So we should protect code block which check and create instance.
    public static Singletone getInstance(){
        if(_ins== null){
            synchronized (Singletone.class) {
                 if(_ins==null) {
                     _ins = new Singletone();
                 }
            }
        }
        return _ins;
    }
}
