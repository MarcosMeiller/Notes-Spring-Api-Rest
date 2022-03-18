package com.restfull.RESTfull.service;

import com.restfull.RESTfull.converter.NoteConverter;
import com.restfull.RESTfull.entity.Note;
import com.restfull.RESTfull.model.MNote;
import com.restfull.RESTfull.repository.NoteRepositorio;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

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

    private static final Log logger = LogFactory.getLog(NoteService.class);
    public boolean create(Note note){
        logger.info("creating a single note");
        try{
            logger.info("created a note");
            repository.save(note);
            return true;
        }catch (Exception e){
            logger.info("error log create");
            return false;
        }
    }

    public boolean update(Note note){
        logger.info("updating a single note");

        try{
            logger.info("updated note");

            repository.save(note);
            return true;
        }catch (Exception e){
            logger.info("ERROR UPDATING");
            return false;
        }
    }

    public boolean delete(String name, Long id){
        logger.info("DELETING A NOTE");

        try{
            Note note = repository.findByNameAndId(name, id);
            repository.delete(note);
            logger.info("NOTE DELETED");
            return true;
        }catch (Exception e){
            logger.info("ERROR DELETING");

            return false;
        }
    }

    public List<MNote> getList(){
        logger.info("GETTING A LIST OF NOTES");
        return converter.convertList(repository.findAll());
    }

    public MNote getByNameAndTitle (String name, String title){
        logger.info("SEARCHING A LIST OF NOTES WITH PARAMS OF TITLE AND NAME");
        return new MNote(repository.findByTitleAndName(title,name));
    }

    public List<MNote> getByTitle(String title){
        logger.info("SEARCHING A LIST OF NOTES WITH PARAMS OF TITLE");
        return converter.convertList(repository.findByTitle(title));
    }

    public List<MNote> getForPaginate (Pageable pageable){
        return converter.convertList(repository.findAll(pageable).getContent());
    }
}
