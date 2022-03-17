package com.restfull.RESTfull.model;

import com.restfull.RESTfull.entity.Note;

public class MNote {
    private Long id;

    private String name;

    private String content;

    private String title;

    public MNote() {
    }

    public MNote(Long id, String name, String content, String title) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.title = title;
    }

    public MNote(Note note) {
        this.id = note.getId();
        this.name = note.getName();
        this.content = note.getContent();
        this.title = note.getTitle();
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
