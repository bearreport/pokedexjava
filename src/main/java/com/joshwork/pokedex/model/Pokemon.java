package com.joshwork.pokedex.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @Getter @Setter private long id;
    @Getter @Setter private String name;
    @Getter @Setter private boolean tattooed;
    @Getter @Setter private LocalDateTime created_at;
    @Getter @Setter private LocalDateTime updated_at;
    @Getter @Setter private String last_updated_by;


    public Pokemon() {
    }

    public Pokemon(long id, String name, boolean tattooed, LocalDateTime created_at, LocalDateTime updated_at, String last_updated_by) {
        this.id = id;
        this.name = name;
        this.tattooed = tattooed;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.last_updated_by = last_updated_by;
    }

}