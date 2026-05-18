package com.example.notes.daos;

import com.example.notes.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface INoteRepository extends JpaRepository<Note, String> {
    boolean existsByCreatedAt(String number);


    boolean existsByIdAndCreatedAt(String number, LocalDateTime now);
}
