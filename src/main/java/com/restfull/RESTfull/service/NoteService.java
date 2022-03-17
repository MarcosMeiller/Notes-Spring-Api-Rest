package com.restfull.RESTfull.service;

import com.restfull.RESTfull.converter.NoteConverter;
import com.restfull.RESTfull.entity.Note;
import com.restfull.RESTfull.model.MNote;
import com.restfull.RESTfull.repository.NoteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("services")
public class NoteService {
    @Autowired
    @Qualifier("repository")
    private NoteRepositorio repository;

    @Autowired
    @Qualifier("converter")
    private NoteConverter converter;

    public boolean create(Note note){
        try{
            repository.save(note);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean update(Note note){
        try{
            repository.save(note);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean delete(String name, Long id){
        try{
            Note note = repository.findByNameAndId(name, id);
            repository.delete(note);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<MNote> getList(){
        return converter.convertList(repository.findAll());
    }

    public MNote getByNameAndTitle (String name, String title){
        return new MNote(repository.findByTitleAndName(title,name));
    }

    public List<MNote> getByTitle(String title){
        return converter.convertList(repository.findByTitle(title));
    }
}
