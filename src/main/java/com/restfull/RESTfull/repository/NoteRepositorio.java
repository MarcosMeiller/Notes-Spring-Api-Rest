package com.restfull.RESTfull.repository;

import com.restfull.RESTfull.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository("repository")
public interface NoteRepositorio extends JpaRepository<Note,Serializable> {
    public abstract Note findByName(String name);

    public abstract List<Note> findByTitle(String title);

    public abstract Note findByTitleAndName(String title, String name);

    public abstract Note findByNameAndId (String name, Long id);


}
