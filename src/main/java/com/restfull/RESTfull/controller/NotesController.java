package com.restfull.RESTfull.controller;

import com.restfull.RESTfull.entity.Note;
import com.restfull.RESTfull.model.MNote;
import com.restfull.RESTfull.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class NotesController {
    @Autowired
    @Qualifier("services")
    NoteService service;

    @PutMapping("/note")
    public boolean createNote(@RequestBody @Validated Note note){
        return service.create(note);
    }

    @PostMapping("/note")
    public boolean updateNote(@RequestBody @Validated Note note){
        return service.update(note);
    }

    @DeleteMapping("/note/{id}/{name}")
    public boolean deleteNote(@PathVariable("id") long id, @PathVariable("name") String name){
        return service.delete(name,id);
    }

    @GetMapping("notes")
    public List<MNote> getNotes(){
        return service.getList();
    }
}
