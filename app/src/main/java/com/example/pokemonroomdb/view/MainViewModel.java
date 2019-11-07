package com.example.pokemonroomdb.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pokemonroomdb.entity.Pokemon;
import com.example.pokemonroomdb.model.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private Repository repository;

    private LiveData<List<Pokemon>> pokemon;

    public MainViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        pokemon = repository.getPokemonLive();
    }

    public LiveData<List<Pokemon>> getPokemon() {
        return pokemon;
    }

    public void insert(Pokemon pokemon) {
        repository.insertPokemon(pokemon);
    }
}
