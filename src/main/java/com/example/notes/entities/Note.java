package com.example.notes.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes")
public class Note {

    @Id
    private String id;
    private String title;
    private String description;
    private LocalDateTime createdAt;

    public boolean containsTitle() {
        return this.title != null && !this.title.isBlank();
    }
}
