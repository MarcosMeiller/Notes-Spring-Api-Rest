package com.restfull.RESTfull.converter;

import com.restfull.RESTfull.entity.Note;
import com.restfull.RESTfull.model.MNote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("converter")
public class NoteConverter {
    public List<MNote> convertList (List<Note> notes){
        List<MNote> mnotes = new ArrayList<>();
        for(Note note : notes){
            mnotes.add(new MNote(note));
        }
        return mnotes;
    }
}
