package com.example.notes;

import com.example.notes.daos.INoteRepository;
import com.example.notes.entities.Note;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {

    private final INoteRepository noteRepository;

    public DemoApplication(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    ApplicationRunner initData() {
        return args ->
        {
            var noteNormal = new Note("1", "xx", "xxx", LocalDateTime.now());
            var noteBlank = new Note("2", "", "xxx", LocalDateTime.now());
            var noteX = new Note("3", "", "xxx", LocalDateTime.now());


            if (noteRepository.existsByIdAndCreatedAt("4", LocalDateTime.now())) {
                System.out.println("Note already exists " + noteRepository.findById("1").get().getId());
            }

            noteRepository.save(noteBlank);
            noteRepository.save(noteNormal);
            noteRepository.save(noteX);

            this.noteRepository.findAll().forEach(itemNote -> {
                System.out.println(itemNote);

                if(itemNote.containsTitle()) {
                    System.out.println("Contains title" + itemNote.getId());
                }
            });

        };

    }



}
