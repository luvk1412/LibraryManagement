/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;
import java.util.*;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author luv
 */
public class SSystem {

    static void exit(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    ArrayList <Subscriber> sub;
    ArrayList <Content> content;
    int conid, subid;
    SSystem(){
        conid = 1;
        subid = 1;
        sub  = new ArrayList<Subscriber>();
        content  = new ArrayList<Content>();
    }
    public void addSub(Subscriber s){
        sub.add(s);
        subid++;
    }
    public void addCon(Content s){
        content.add(s);
        conid++;
    }
    public int searchcon(String name){
        int flag = 0;
        for(int i = 0; i < content.size(); ++i){
            if(content.get(i).name.compareTo(name) == 0){
                if(content.get(i).status == 1){
                    flag = 1;
                }
                else{
                    return i;
                }
            }
        }
        if(flag == 0){
            return -1;
        }
        return -2;
    }
    public int searchconid(int id){
        for (int i = 0; i < sub.size(); ++i) {
            if (content.get(i).id == id) {
                return i;
            }
        }
        return -1;
    }
    public int searchsub(int id){
        for(int i = 0;i<sub.size(); ++i){
            if(sub.get(i).id == id){
                return i;
            }
        }
        return -1;
    }
    public int issue(int index, int id, Date date){
        for(int i = 0;i < sub.size(); ++i){
            if(sub.get(i).id == id){
                sub.get(i).issue(content.get(index).id, date);
                content.get(index).status = 1;
                return 1;
            }
        }
        return -1;
    }
    public void writefiles() throws FileNotFoundException{
        PrintStream o = new PrintStream(new File("contentdata.txt"));
        System.setOut(o);
        System.out.println(content.size());
        for(int i = 0; i < content.size(); ++i){
            System.out.println(content.get(i).type);
            System.out.println(content.get(i).id + " " + content.get(i).name + " " + content.get(i).author + " " + content.get(i).topic +" " + content.get(i).status);
        }
        o = new PrintStream(new File("subdata.txt"));
        System.setOut(o);
        System.out.println(sub.size());
        for(int i = 0; i < sub.size();++i){
            System.out.println(sub.get(i).type);
            System.out.println(sub.get(i).id + " " + sub.get(i).name + " " + sub.get(i).age);
            System.out.println(sub.get(i).issued.size());
            for(int j = 0; j < sub.get(i).issued.size(); ++j){
                System.out.println(sub.get(i).issued.get(j));
            }
            System.out.println(sub.get(i).start.size());
            for (int j = 0; j < sub.get(i).start.size(); ++j) {
                System.out.println(sub.get(i).start.get(j).d + " "+sub.get(i).start.get(j).m+" " + sub.get(i).start.get(j).y);
            }
        }
    }
    public void readfiles() throws FileNotFoundException{
        File file = new File("contentdata.txt");
        Scanner sc = new Scanner(file);
        int n = sc.nextInt();
        subid = 0;
        conid = 0;
        for(int i = 0; i < n; ++i){
            String type = sc.next();
            if(type.equals("Book")){
                int iddd = sc.nextInt();
                conid = Math.max(conid, iddd);
                content.add(new Book(iddd, sc.next(), sc.next(), sc.next()));
                content.get(i).status = sc.nextInt();
            }
            else if (type.equals("Article")) {
                int iddd = sc.nextInt();
                conid = Math.max(conid, iddd);
                content.add(new Article(iddd, sc.next(), sc.next(), sc.next()));
                content.get(i).status = sc.nextInt();
            }
            else if (type.equals("DigitalMedia")) {
                int iddd = sc.nextInt();
                conid = Math.max(conid, iddd);
                content.add(new Digital(iddd, sc.next(), sc.next(), sc.next()));
                content.get(i).status = sc.nextInt();
            }
            
        }
        conid++;
        file = new File("subdata.txt");
        sc = new Scanner(file);
        n = sc.nextInt();
        for(int i = 0; i < n; ++i){
            String type = sc.next();
            if(type.equals("Normal")){
                int iddd = sc.nextInt();
                subid = Math.max(subid, iddd);
                sub.add(new Normal(iddd, sc.next(), sc.nextInt()));
            }
            else if(type.equals("Golden")){
                int iddd = sc.nextInt();
                subid = Math.max(subid, iddd);
                sub.add(new Golden(iddd, sc.next(), sc.nextInt()));
            }
            int m = sc.nextInt();
            for(int j = 0; j < m; ++j){
                sub.get(i).issued.add(sc.nextInt());
            }
            m = sc.nextInt();
            for (int j = 0; j < m; ++j) {
                sub.get(i).start.add(new Date(sc.nextInt(), sc.nextInt(), sc.nextInt()));
            }
        }
        subid++;
    }
}