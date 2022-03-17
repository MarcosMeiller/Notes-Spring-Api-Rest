package com.restfull.RESTfull.entity;


import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Table(name = "note")
@Entity
@XmlRootElement
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note")
    private Long id;
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private String content;

    @Column(name = "title")
    private String title;

    public Note(Long id, String name, String content, String title) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.title = title;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
