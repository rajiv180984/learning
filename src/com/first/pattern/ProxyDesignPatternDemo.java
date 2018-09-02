package com.first.pattern;

public class ProxyDesignPatternDemo {

    public static void main(String aa[]){
        ContextObject con = Prototype.getInstance();
        ContextObject con1 = Prototype.getInstance();
        ContextObject con2 = Prototype.getInstance();

        System.out.println(" obj :"+ con.toString()+" and HashCode "+ con.hashCode());
        System.out.println(" obj1 :"+ con1.toString()+" and HashCode "+ con1.hashCode());
        System.out.println(" obj2 :"+ con2.toString()+" and HashCode "+ con2.hashCode());
    }

}


class ContextObject implements  Cloneable{
    private String connectionPath;
    private String driverName;

    public ContextObject(final String connectionPath, final String driverName) {
        this.connectionPath = connectionPath;
        this.driverName = driverName;
    }

    public String getConnectionPath() {
        return connectionPath;
    }

    public void setConnectionPath(final String connectionPath) {
        this.connectionPath = connectionPath;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(final String driverName) {
        this.driverName = driverName;
    }

    @Override
    protected Object clone(){
       try {
           return super.clone();
       }catch (CloneNotSupportedException e) {
        return null;
       }
    }

    @Override
    public String toString() {
        return "ContextObject{" +
                "connectionPath='" + connectionPath + '\'' +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}


class Prototype{
    private static  ContextObject con = new ContextObject("http://hello","SQLDriver");
    public static ContextObject getInstance(){
        return (ContextObject)con.clone();
    }

}