package com.joshwork.pokedex.controller;

import com.joshwork.pokedex.model.Pokemon;
import com.joshwork.pokedex.repository.PokedexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class PokemonController {

    @Autowired
    PokedexRepository pokedexRepository;

    @GetMapping("/pokemons")
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        try {
            List<Pokemon> pokemon = new ArrayList<Pokemon>();
            pokedexRepository.findAll().forEach(pokemon::add);

            if (pokemon.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(pokemon, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pokemons/{id}")
	public ResponseEntity<Pokemon> getSpecificPokemon(@PathVariable("id") Long id) {
        Optional<Pokemon> pokemonData = pokedexRepository.findById(id);

        if (pokemonData.isPresent()) {
            return new ResponseEntity<>(pokemonData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/pokemons/{id}", method = RequestMethod.POST)
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable("id") Long id) {
        Optional<Pokemon> pokemonData = pokedexRepository.findById(id);

        if (pokemonData.isPresent()) {
			Pokemon _pokemon = pokemonData.get();
			_pokemon.setTattooed(true);
			return new ResponseEntity<>(pokedexRepository.save(_pokemon), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
   
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }

}
