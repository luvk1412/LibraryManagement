/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

/**
 *
 * @author luv
 */
public class Content {
    int id, status;
    String name, author, topic, type;
    Content(int id, String name, String author, String topic, String type){
        this.status  = 0;
        this.id = id;
        this.name= name;
        this.author = author;
        this.topic = topic;
        this.type = type;
    }
    
}

class Book extends Content{

    Book(int id, String name, String author, String topic){
        super(id, name, author, topic,"Book");
    }
}

class Article extends Content {
    Article(int id, String name, String author, String topic) {
        super(id, name, author, topic,"Article");
    }
}
class Digital extends Content {
    Digital(int id, String name, String author, String topic) {
        super(id, name, author, topic, "DigitalMedia");
    }
}
