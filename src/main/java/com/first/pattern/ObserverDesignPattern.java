package com.first.pattern;

import java.util.LinkedList;
import java.util.List;

public class ObserverDesignPattern{

    public static void main(String aa[]){
        EditorComponent text = new Text();
        text.register(new EditObserver());
        text.changeState("This is text");
    }

}

interface EditorComponent{
    // register observer
    void register(ActionObserver observer);
    boolean unregister(ActionObserver actionObserver);
    // unregister observer
    // notifyAllObserver
    // update state of Object
    boolean changeState(String value);
    void notifyAllObserver();



}

class Text implements EditorComponent{
    String textStr;
   List<ActionObserver> list;

    public Text() {
        this.list = new LinkedList<>();
        this.textStr = "testing";
    }

    @Override
    public void register(final ActionObserver observer) {
      list.add(observer);
    }

    @Override
    public boolean unregister(final ActionObserver actionObserver) {
        list.remove(actionObserver);
        return false;
    }

    @Override
    public boolean changeState(final String value) {
        if(!value.equals(this.textStr)){
            this.textStr = value;
            notifyAllObserver();
        }
        return false;
    }

    @Override
    public void notifyAllObserver() {

        for(ActionObserver obs : list){
            System.out.println("=========== "+this.textStr);
            obs.update(this.textStr);
            //obs.setSubject();
        }
    }
}

interface ActionObserver{
   // attache Subject
    // update
    void update(String msg);
    void setSubject(EditorComponent component);
}

class EditObserver implements  ActionObserver{

    @Override
    public void update(final String msg) {
        System.out.println(" Subject change : "+ msg);
    }

    @Override
    public void setSubject(final EditorComponent component) {

    }
}