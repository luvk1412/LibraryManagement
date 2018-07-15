/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.util.ArrayList;

/**
 *
 * @author luv
 */
abstract public class Subscriber {
    int id, age;
    String name, type;
    ArrayList <Integer> issued;
    ArrayList <Date> start;
    Subscriber(int id, String name, int age, String type){
        this.id = id;
        this.age = age;
        this.name = name;
        issued = new ArrayList<Integer>();
        start = new ArrayList <Date>();
        this.type = type;
    }
    public void issue(int bookid, Date date){
        issued.add(bookid);
        start.add(date);
    }
    abstract public int getfine(Date et, int cur);
}

class Normal extends Subscriber{
    Normal(int id, String name, int age){
        super(id,name,age, "Normal");
    }
    public int getfine(Date et, int cur){
        Date st = start.get(cur);
        issued.remove(cur);
        start.remove(cur);
        int d1 = st.d + st.m*30 + (st.y-1)*365;
        int d2 = et.d + et.m * 30 + (et.y - 1) * 365;
        if(d2 - d1 >= 21){
            return 5*(d2-d1 - 21);
        }
        return 0;
    }
}
class Golden extends Subscriber{
    Golden(int id, String name, int age) {
        super(id, name, age,"Golden");
    }
    public int getfine(Date et, int cur) {
        Date st = start.get(cur);
        issued.remove(cur);
        start.remove(cur);
        int d1 = st.d + st.m * 30 + (st.y - 1) * 365;
        int d2 = et.d + et.m * 30 + (et.y - 1) * 365;
        if (d2 - d1 >= 90) {
            return 5 * (d2 - d1 - 21);
        }
        return 0;
    }    
}