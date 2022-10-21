package com.joshwork.pokedex.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joshwork.pokedex.model.Pokemon;

public interface PokedexRepository extends JpaRepository<Pokemon, Long> {
}
