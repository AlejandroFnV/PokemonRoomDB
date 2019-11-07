package com.example.pokemonroomdb.model;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.pokemonroomdb.dao.PokemonDAO;
import com.example.pokemonroomdb.database.PokemonDatabase;
import com.example.pokemonroomdb.entity.Pokemon;

import java.util.List;

public class Repository {

    private PokemonDAO pokemonDAO;
    private LiveData<List<Pokemon>> pokemonLive;

    public Repository(Context contexto) {
        PokemonDatabase db = PokemonDatabase.getDatabase(contexto);
        pokemonDAO = db.getUserDAO();
        pokemonLive = pokemonDAO.getAllLive();
        //populateDb();
    }

    private void populateDb() {
        for (int i = 0; i < 100; i++) {
            Pokemon pokemon = new Pokemon();
            pokemon.setNombre("Pokemon " + i);
            insertPokemon(pokemon);
        }
    }

    public LiveData<List<Pokemon>> getPokemonLive() {
        return pokemonLive;
    }

    public void insertPokemon(Pokemon pokemon) {
        new InsertThread().execute(pokemon);
    }

    private class InsertThread extends AsyncTask<Pokemon, Void, Void> {

        @Override
        protected Void doInBackground(Pokemon... pokemons) {
            pokemonDAO.insert(pokemons[0]);
            Log.v("xyz", pokemons[0].toString());
            return null;
        }
    }

}